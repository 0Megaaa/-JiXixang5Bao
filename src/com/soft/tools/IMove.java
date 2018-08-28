package com.soft.tools;

import java.util.Set;

public interface IMove {
	/**
	 * 求点1到点2的合适路线
	 * @param x1 点1x坐标
	 * @param y1 点1y坐标
	 * @param x2 点2x坐标
	 * @param y2 点2y坐标
	 * @param barrier 有顺序的路线列表
	 * @return
	 */
	Point move(int x1,int y1,int x2,int y2,Set<Point> barrier);

}
