package com.soft.tools;

public class Point {
	int x;
	int y;
	int gCost;//位移的位置。
	int hEstimate;
	int fTotal;
    Point prev;
    int level=1;
    
    public String getKey(){
    	return x+"_"+y;
    }
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
 
	
	public Point(int x, int y, int gCost) {
		super();
		this.x = x;
		this.y = y;
		this.gCost = gCost;
	}
 
 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getgCost() {
		return gCost;
	}
	public void setgCost(int gCost) {
		this.gCost = gCost;
	}
	public int gethEstimate() {
		return hEstimate;
	}
	public void sethEstimate(int hEstimate) {
		this.hEstimate = hEstimate;
	}
	public int getfTotal() {
		return fTotal;
	}
	public void setfTotal(int fTotal) {
		this.fTotal = fTotal;
	}
	public Point getPrev() {
		return prev;
	}
	public void setPrev(Point prev) {
		this.prev = prev;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

}
