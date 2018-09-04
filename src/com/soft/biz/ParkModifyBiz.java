package com.soft.biz;


import com.soft.bean.TbParkPlace;

public interface ParkModifyBiz {
	//查找前缀
	void updateById(TbParkPlace ParkPlace);
		//情况前缀
		void deleted();
		//情况前缀
		long findAllNum();
		//修改没有编号的车位
		public void updateUnPrefixById(TbParkPlace ParkPlace);

}
