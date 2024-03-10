package shapesM4;

public class Circle extends Shape{
	double area;
	double perimeter;
	private double cRadius;
	
	public void setRadius(double radius) {
		cRadius = radius;
		
	}
	private double getRadius() {
		
		return cRadius;
	}

	@Override
	public double calcArea() {
		area = Math.PI * Math.pow(getRadius(), 2);
		
		return area;
	}

	@Override
	public double calcPerimeter() {
		perimeter = 2 * Math.PI * getRadius();
		
		return perimeter;
	}
	
	public String toString() {
		return "\nCircle's circumference: " + perimeter + "\n\tCircle's area: " + area;
	}
}
