package com.soft.tools;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
 
/**
 * 
 * @author hjn
 * @version 1.0 2015-03-11
 * 
 */
public class AStar implements IMove {
 
    public static final int MOVE_TETN = 10;
    public static final int MOVE_SIDE =17;
    public static final int LENGHT = 10;
    /* 打开的列表 */
    Map<String, Point> openMap = new HashMap<String, Point>();
    /* 关闭的列表 */
    Map<String, Point> closeMap = new HashMap<String, Point>();
    /* 障碍物 */
    Set<Point> barrier;
    /* 起点 */
    Point startPoint;
    /* 终点 */
    Point endPoint;
    /* 当前使用节点 */
    Point currentPoint;
    /* 循环次数，为了防止目标不可到达 */
    int num = 0;
    //下一个节点
    Point lastPoint;
 
    /**
     * 获取点1到点1的最佳路径
     */
    @Override
    public Point move(int x1, int y1, int x2, int y2, Set<Point> barrier) {
        num = 0;
        this.lastPoint=new Point(x2,y2);
        this.barrier = barrier;
        this.startPoint = new Point(x1, y1);
        Point endPoint=new Point(x2,y2);
        this.endPoint = this.getNearPoint(endPoint,endPoint);
        this.closeMap.put(startPoint.getKey(), startPoint);
        this.currentPoint = this.startPoint;
        this.toOpen(x1, y1);
        return endPoint;
    }
 
    
 
    /**
     * 求亮点间的估算代价，性能由高到低 启发函数一（曼哈顿距离）： (Math.abs(x1 - x2) + Math.abs(y1 - y2)) *
     * 单位长度 启发函数二（平方的欧几里得距离）：((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 -y1))*
     * 单位长度 启发函数三（欧几里得距离）：(int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) *
     * (y2 -y1))* 单位长度 启发函数四（对角线距离）：Math.max(Math.abs(x1 - x2), Math.abs(y1 -
     * y2)) * 单位长度 不用启发函数：0
     * 
     * @param x1
     *            点1x轴
     * @param y1
     *            点1y轴
     * @param x2
     *            点2x轴
     * @param y2
     *            点2y轴
     * @return
     */
    private int getGuessLength(int x1, int y1, int x2, int y2) {
        //return ((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 -y1))* AStar.LENGHT;
        return (Math.abs(x1 - x2) + Math.abs(y1 - y2)) * AStar.LENGHT;
        // return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)) * AStar.LENGHT;
        // return 0;
    }
 
    /**
     * 把该节点相邻点加入打开的列表
     * 
     * @param x
     * @param y
     */
    private void toOpen(int x, int y) {
        this.addOpenPoint(new Point(x - 1, y), AStar.MOVE_TETN);
        this.addOpenPoint(new Point(x + 1, y), AStar.MOVE_TETN);
        this.addOpenPoint(new Point(x, y - 1), AStar.MOVE_TETN);
        this.addOpenPoint(new Point(x, y + 1), AStar.MOVE_TETN);
        this.addOpenPoint(new Point(x - 1, y - 1), AStar.MOVE_SIDE);
        this.addOpenPoint(new Point(x - 1, y + 1), AStar.MOVE_SIDE);
        this.addOpenPoint(new Point(x + 1, y - 1), AStar.MOVE_SIDE);
        this.addOpenPoint(new Point(x + 1, y + 1), AStar.MOVE_SIDE);
        num++;
        if (num <= 4000) {
            this.toClose(x, y);
        }
 
    }
 
    /**
     * 把该节点相邻点加入关闭的列表
     * 
     * @param x
     * @param y
     */
    //把走过的点加入到关闭列表中
    private void toClose(int x, int y) {
        List<Point> list = new ArrayList<Point>(openMap.values());//openMap.values() 打开区间的值point
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.fTotal > o2.fTotal) {
                    return 1;
                } else if (o1.fTotal < o2.fTotal) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        if (list.size() > 0) {
            this.currentPoint = list.get(0);
            closeMap.put(this.currentPoint.getKey(), this.currentPoint);
            openMap.remove(this.currentPoint.getKey());
            if (!currentPoint.equals(endPoint)) {
                this.toOpen(this.currentPoint.x, this.currentPoint.y);
            } else {
                    endPoint = this.currentPoint;
            }
        }
    }
 
    /**
     * 添加开放的点
     * 
     * @param point
     *            点
     * @param gCost
     *            当前点到该点的消耗
     * @return
     */
    private void addOpenPoint(Point point, int gCost) {
        if (point.x < 0 || point.y < 0) {
            return;
        }
        String key = point.getKey();
        if (!barrier.contains(point) && !point.equals(this.currentPoint)) {
            int hEstimate = this.getGuessLength(point.x, point.y,
                    this.endPoint.x, this.endPoint.y);
            int totalGCost = this.currentPoint.gCost + gCost;
            int fTotal = totalGCost + hEstimate;
            if (!closeMap.containsKey(key)) {
                point.hEstimate = hEstimate;
                point.gCost = totalGCost;
                point.fTotal = fTotal;
                Point oldPoint = openMap.get(key);
                if (oldPoint != null) {
                    if (oldPoint.gCost > totalGCost) {
                        oldPoint.fTotal = fTotal;
                        oldPoint.prev = this.currentPoint;
                        openMap.put(key, oldPoint);
                    }
                } else {
                    point.prev = this.currentPoint;
                    openMap.put(key, point);
                }
            } else {
                Point oldPoint = closeMap.get(key);
                if (oldPoint != null) {
                    if ((oldPoint.gCost + gCost) < this.currentPoint.gCost) {
                        if (this.currentPoint.prev != oldPoint) {
                            this.currentPoint.fTotal = oldPoint.fTotal + gCost;
                            this.currentPoint.gCost = oldPoint.gCost + gCost;
                            this.currentPoint.prev = oldPoint;
                        }
                    }
                }
            }
        }
    }
    
    
 
    Map<String, Point> nearOutMap;
 
    public Point getNearPoint(Point point,Point point2) {
        if(this.barrier.contains(point)){
            nearOutMap = new HashMap<String, Point>();
            this.endPoint=point;
            this.toNearPoint(point,point2);
            List<Point> nearList = new ArrayList<Point>(nearOutMap.values());
            Collections.sort(nearList, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if (o1.gCost > o2.gCost) {
                        return 1;
                    } else if (o1.gCost < o2.gCost) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            this.openMap=new HashMap<String,Point>();
            this.closeMap=new HashMap<String,Point>();
            if (nearList.size() > 0) {
                return nearList.get(0);
            }else{
                return point;
            }
        }else{
            return point;
        }
        
    }
 
    public void toNearPoint(Point point,Point point2) {
        int x = point.x;
        int y = point.y;
        this.addNearOpenPoint(new Point(x - 1, y),point2);
        this.addNearOpenPoint(new Point(x + 1, y),point2);
        this.addNearOpenPoint(new Point(x, y - 1),point2);
        this.addNearOpenPoint(new Point(x, y + 1),point2);
        this.addNearOpenPoint(new Point(x - 1, y - 1),point2);
        this.addNearOpenPoint(new Point(x - 1, y + 1),point2);
        this.addNearOpenPoint(new Point(x + 1, y - 1),point2);
        this.addNearOpenPoint(new Point(x + 1, y + 1),point2);
        if(this.nearOutMap.size()==0){
            List<Point> list = new ArrayList<Point>(openMap.values());
            Collections.sort(list, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    int l1 = o1.gCost;
                    int l2 = o2.gCost;
                    if (l1 > l2) {
                        return 1;
                    } else if (l1 < l2) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            if (list.size() > 0) {
                Point p = list.get(0);
                this.closeMap.put(p.getKey(), p);
                this.openMap.remove(p.getKey());
                this.toNearPoint(list.get(0),point2);
            }
        }
    }
 
    private void addNearOpenPoint(Point point,Point point2) {
        String key = point.getKey();
        int gCost = this.getGuessLength(point.x, point.y, point2.x,
                point2.y);
        point.gCost = gCost;
        if (this.barrier.contains(point)) {
            if (!this.openMap.containsKey(key)
                    && !this.closeMap.containsKey(key)) {
                this.openMap.put(key, point);
            }
        } else {
            this.nearOutMap.put(key, point);
        }
 
    }
 
    public Map<String, Point> getOpenMap() {
        return openMap;
    }
 
    public void setOpenMap(Map<String, Point> openMap) {
        this.openMap = openMap;
    }
 
    public Map<String, Point> getCloseMap() {
        return closeMap;
    }
 
    public void setCloseMap(Map<String, Point> closeMap) {
        this.closeMap = closeMap;
    }
 
    public Set<Point> getBarrier() {
        return barrier;
    }
 
    public void setBarrier(Set<Point> barrier) {
        this.barrier = barrier;
    }
 
    public Point getEndPoint() {
        return endPoint;
    }
 
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
 
    public Point getStartPoint() {
        return startPoint;
    }
 
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }
 
}
 
