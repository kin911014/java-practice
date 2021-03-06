package com.douzon.paint.point;

import com.douzon.paint.i.Drawable;

public class Point implements Drawable{
	private int x;
	private int y;
	
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
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
	
	public void show() {
		System.out.println("");
	}
	public void show(boolean visible) {
		if(visible) {
			this.show();
		}
		else
			System.out.println("");
	}

	@Override
	public void draw() {
		show();
		
	}
}
