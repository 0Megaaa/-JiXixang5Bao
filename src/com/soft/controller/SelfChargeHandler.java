package com.soft.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.soft.bean.TbCar;
import com.soft.biz.SelfChargeBiz;

@Controller
@RequestMapping("/user")
public class SelfChargeHandler {
	@Resource
	private SelfChargeBiz SelfChargeBizImpl;
	@Resource
	TbCar tbCar3;
	@Resource
	TbCar tbCarMini;

	@RequestMapping(value = "/selfCharge.action")
	public ModelAndView selfCharge(HttpServletRequest request, String carNum1) {

		ModelAndView modelAndView = null;
		// 到Biz中判断是否是白名单和vip，如果是则返回您是会员，无需缴费。

		int i = SelfChargeBizImpl.findList(carNum1);
		if (i == 1) {
			// i=1说明有值，说明是会员。或白名单。
			String msg = "您是免缴会员，可直接出场！";
			request.setAttribute("msg", msg);
			modelAndView = new ModelAndView("user/userIndex");
			// 更新车状态。为已缴费。
			// 先通过车号查车id，再根据车id取更新数据。
			SelfChargeBizImpl.updateCarState(carNum1);

		} else {
			// 调出缴费记录，计算缴费信息下发，并点击缴费 就缴费。
			/* paystate=7 */
			/*
			 * 有数据下发数据。没数据下发输入车牌号有误，请重新输入。
			 */
			TbCar tbCar = SelfChargeBizImpl.queryCarMsg(carNum1);
			if (tbCar == null) {

				String msg = "对不起，输入车号有误！";
				request.setAttribute("msg", msg);
				modelAndView = new ModelAndView("user/userIndex");
			} else {
				// j就是卡id。 通过卡id去查记录，并计算金额。下发到客户端。
				request.setAttribute("tbCar", tbCar);
				modelAndView = new ModelAndView("user/chargeMsg");
			}

		}

		return modelAndView;

	}

	@RequestMapping(value = "/chargeMoney.action")
	public ModelAndView chargeMoney(HttpServletRequest request, long carId, String endTime, long money) {
		// 上发数据上来，更改出场时间，paychannel，插入money
		// 过杆时计算出场时间是否大于30分钟。

		tbCar3.setCarId(carId);
		tbCar3.setEndTime(endTime);
		tbCar3.setMoney(money);

		// 传到biz层进行处理
		SelfChargeBizImpl.updateCarMsg(tbCar3);
		ModelAndView modelAndView = new ModelAndView("user/userIndex");
		// 更新车位

		request.setAttribute("msg", "支付成功，请在30分钟内出场，否则将收取额外费用！");

		return modelAndView;

	}

	// 上发数据上来，更改出场时间，paychannel，插入money
	// 过杆时计算出场时间是否大于30分钟。

	@RequestMapping(value = "/selfChargeMini.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody TbCar selfChargeMini(HttpServletRequest request, String carNum) {
		
		// ModelAndView modelAndView = null;
		// 到Biz中判断是否是白名单和vip，如果是则返回您是会员，无需缴费。

		int i = SelfChargeBizImpl.findList(carNum);
		if (i == 1) {
			// i=1说明有值，说明是会员。或白名单。
			String msg = "您是免缴用户，无需缴费！";
			// request.setAttribute("msg", msg);
			// modelAndView = new ModelAndView("user/userIndex");
			// 更新车状态。为已缴费。
			// 先通过车号查车id，再根据车id取更新数据。
			SelfChargeBizImpl.updateCarState(carNum);
			tbCarMini.setMsg(msg);
			return tbCarMini;
		} else {
			// 调出缴费记录，计算缴费信息下发，并点击缴费 就缴费。
			/* paystate=7 */
			/*
			 * 有数据下发数据。没数据下发输入车牌号有误，请重新输入。
			 */
			TbCar tbCar = SelfChargeBizImpl.queryCarMsg(carNum);
			if (tbCar == null) {
				String msg = "您没有停车，不用缴费！";
				tbCarMini.setMsg(msg);
				return tbCarMini;
				// request.setAttribute("msg", msg);
				// modelAndView = new ModelAndView("user/userIndex");
			} else {
				// j就是卡id。 通过卡id去查记录，并计算金额。下发到客户端。
				tbCarMini = tbCar;
				// request.setAttribute("tbCar", tbCar);
				// modelAndView = new ModelAndView("user/chargeMsg");
				return tbCarMini;
			}

		}

	}
	
	
	@RequestMapping(value = "/chargeMoneyMini.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ ResponseBody TbCar  chargeMoneyMini(HttpServletRequest request, long carId, String endTime, long money) {
		// 上发数据上来，更改出场时间，paychannel，插入money   //, long carId, String endTime, long money
		// 过杆时计算出场时间是否大于30分钟。

	tbCar3.setCarId(carId);
	tbCar3.setEndTime(endTime);
	tbCar3.setMoney(money);

		// 传到biz层进行处理
		SelfChargeBizImpl.updateCarMsg(tbCar3);
		
	tbCar3.setMsg("支付成功，请在30分钟内出场，否则将收取额外费用！");
		//ModelAndView modelAndView = new ModelAndView("user/userIndex");
		// 更新车位

//		request.setAttribute("msg", "支付成功，请在30分钟内出场，否则将收取额外费用！");

		return tbCar3;

	}


}
