package corejava;

/*
 Write a Java program that uses polymorphism by defining an interface called Shape
with methods to calculate the area and perimeter of a shape. Then create classes
that implement the Shape interface for different types of shapes, such as circles and
triangles. */

interface Shape{
	double perimeter();
	double area();
}

class Circle implements Shape{
	private double radius;

	Circle(double radius){
		this.radius=radius;
	}

	@Override
	public double perimeter() {
		double perimeter;
		perimeter=2 * Math.PI*radius;
		return perimeter;
	}

	@Override
	public double area() {
		double area;
		area=Math.PI * radius * radius;
		return area;
	}
}

class Triangle implements Shape{
	private double sidea;
	private double sideb;
	private double sidec;
	Triangle(double a,double b,double c){
		this.sidea=a;
		this.sideb=b;
		this.sidec=c;
	}
	@Override
	public double perimeter() {
		double perimeter;
		perimeter=sidea+sideb+sidec;
		
		return perimeter ;
	}
	@Override
	public double area() {
		double s;
		s=0.5 *(sidea+sideb+sidec);
		double area;
		area=Math.sqrt(s *(s-sidea)*(s-sideb)*(s-sidec));
		return area;
	}
	
	
}
public class Question1 {

	public static void main(String[] args) {
		Shape shape=new Circle(30.2);
		System.out.println("Perimeter of Circle: "+String.format("%.2f", shape.perimeter()));
		System.out.println("Area of Circle : "+String.format("%.2f", shape.area()));
		
		shape=new Triangle(10.4,20,12);
		System.out.println("Perimeter of Traingle: "+String.format("%.2f", shape.perimeter()));
		System.out.println("Area of Triangle: "+String.format("%.2f", shape.area()));
	}

}
