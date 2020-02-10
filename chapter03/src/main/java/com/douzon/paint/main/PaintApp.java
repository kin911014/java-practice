package com.douzon.paint.main;

import com.douzon.paint.i.Drawable;
import com.douzon.paint.point.ColorPoint;
import com.douzon.paint.point.Point;
import com.douzon.paint.shape.Circle;
import com.douzon.paint.shape.Rect;
import com.douzon.paint.shape.Shape;
import com.douzon.paint.shape.Triangle;

public class PaintApp {

	public static void main(String[] args) {
		Point point = new Point(2, 5);
		point.setX(2);
		point.setY(5);
//		drawPoint(point);
		draw(point);
		
		Point point2 = new Point(10,20);
//		drawPoint(point2);
		draw(point2);
		
		// point2.show(false);
		// ColorPoint a = (ColorPoint) new Point();
		
		ColorPoint point3 = new ColorPoint(50, 100, "red");
//		drawPoint(point3);
		draw(point3);
		point3.show(false);
		point3.show(true);
		
		Rect rect = new Rect();
//		drawShape(rect);
		draw(rect);
		
		Triangle triangle = new Triangle();
//		drawShape(triangle);
		draw(triangle);
		
		Circle circle = new Circle();
//		drawShape(circle);
		draw(circle);
		
		// instanceof test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		// 오류: class는 hierachy 상위와 하위만 instanceof 연산자를 사용할 수 있다.
//		System.out.println(circle instanceof Rect);
		Shape s = new Circle();
		System.out.println(s instanceof Object);
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Rect);
		// Interface 는 hierachy 상관없이 instanceof연산자를 사용할 수 있다.
		System.out.println(s instanceof Drawable);
		System.out.println(s instanceof Runnable);
	}
	
	public static void draw(Drawable d) {
		d.draw();
	}

//	public static void drawPoint(Point point) {
//		point.show();
//	}
//
//	public static void drawShape(Shape shape) {
//		shape.drow();
//	}
}
