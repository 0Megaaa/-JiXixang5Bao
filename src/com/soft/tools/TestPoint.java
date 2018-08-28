package com.soft.tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.stereotype.Component;
@Component
public class TestPoint {
	/*@Test*/
	public 	ArrayList<Point>  test2( int startX,int startY,int endX,int endY) {//ArrayList<Point>     int startX,int startY,int endX,int endY
	ArrayList<Point> list=new ArrayList<>();
		AStar aStar = new AStar();
		Set<Point> barrier = new HashSet<Point>();
/*		
		 * for (int j = 30; j > 15; j--) { for (int i = 20; i < 50; i++) {
		 * barrier.add(new Point(j, i)); } }
		 

		for (int j = 30; j > 15; j--) {
			barrier.add(new Point(j, 20));
		}
		
		 * for (int j = 30; j > 15; j--) { barrier.add(new Point(j, 50)); }
		 
		for (int i = 20; i < 50; i++) {
			barrier.add(new Point(30, i));
		}

		for (int i = 20; i < 59; i++) {
			barrier.add(new Point(15, i));
		}
*/
		/* 我的测试 */
		/* 横i乘于4，纵向j乘于2 */
		// 第A区车。
		for (int i = 4; i < 12; i++) {      /*1-3   *4              */
			for (int j = 2; j < 12; j++) {     /*1-6     *2      */
				barrier.add(new Point(i, j));
			}
		}

		//B區域
		for (int i = 16; i < 24; i++) {
			for (int j = 2; j < 12; j++) {
				barrier.add(new Point(i, j));

			}

		}
		
		

		for (int i =28; i < 36; i++) {
			for (int j = 2; j < 12; j++) {
				barrier.add(new Point(i, j));

			}

		}
		
		
		for (int i =40; i < 48; i++) {
			for (int j = 2; j < 12; j++) {
				barrier.add(new Point(i, j));

			}

		}
		
		
		// 第C区车。
		for (int i = 4; i < 12; i++) {
			for (int j = 16; j < 26; j++) {
				barrier.add(new Point(i, j));
			}
		}
		
		
		
		// 第D区车。
		for (int i = 16; i < 24; i++) {
			for (int j = 16; j < 26; j++) {
				barrier.add(new Point(i, j));
			}
		}
		
		
		
		
		for (int i = 28; i < 36; i++) {
			for (int j = 16; j < 26; j++) {
				barrier.add(new Point(i, j));
			}
		}
		
		
		
		for (int i = 40; i < 48; i++) {
			for (int j = 16; j < 26; j++) {
				barrier.add(new Point(i, j));
			}
		}
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {
			aStar = new AStar();
			// 设置其点和重点的坐标
			aStar.move(startX*4, startY*2, endX*4+2, 2*endY+1, barrier);// startX*4, startY*2, endX*4, 2*endY
		}
		long end = System.currentTimeMillis();
	/*	System.out.println(end - start);*/
		Set<Point> set = new HashSet<Point>();
		Point endPoint = aStar.getEndPoint();
		Point startPoint = aStar.getStartPoint();
		Map<String, Point> openMap = aStar.getOpenMap();
		Map<String, Point> closeMap = aStar.getCloseMap();
		set = TestPoint.get(endPoint, set);
		/**
		 * 显示最佳路径
		 */
	/*	System.out.println(aStar.getEndPoint().getKey());*/
		for (int i = 0; i <30; i++) {
			for (int j = 0; j < 52; j++) {
				Point p = new Point(j, i);
				if (p.equals(aStar.getEndPoint())) {
					System.out.print("o");
				} else if (p.equals(startPoint)) {
					System.out.print("^");
				} else {
					if (set.contains(p)) {
						System.out.print("@");
				String x=		p.getKey().split("_")[0];
				String y=		p.getKey().split("_")[1];
list.add(p);
					} else if (barrier.contains(p)) {
						System.out.print("#");
					} else {
						System.out.print("*");
					}

				}
				System.out.print(" ");
			}
			System.out.println();
		}

		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
/*		return list;*/
		return list;}
		/**
		 * 扫描的范围
		 */
/*		for (int i = 0; i < 70; i++) {
			for (int j = 0; j < 70; j++) {
				Point p = new Point(j, i);
				if (p.equals(endPoint)) {
					System.out.print("o");
				} else if (p.equals(startPoint)) {
					System.out.print("^");
				} else {
					if (openMap.containsKey(p.getKey())) {
						System.out.print("%");
					} else if (closeMap.containsKey(p.getKey())) {
						System.out.print("@");
					} else if (barrier.contains(p)) {
						System.out.print("#");
					} else {
						System.out.print("*");
					}

				}
				System.out.print(" ");
			}
			System.out.println();
		}

	}
*/
	public static Set<Point> get(Point p, Set<Point> set) {
		if (p != null) {
			set.add(p);
		}
		Point pp = p.prev;
		if (pp != null) {
			TestPoint.get(pp, set);
		} else {
			return set;
		}
		return set;
	}

}
