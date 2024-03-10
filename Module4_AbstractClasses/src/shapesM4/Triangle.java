package shapesM4;

public class Triangle extends Shape{
	double area;
	double perimeter;
	private double side1;
	private double side2;
	private double base1;
	private double height;
	
	public void setSides(double s1, double s2, double base, double height) {
		side1 = s1;
		side2 = s2;
		base1 = base;
		this.height = height;
	}

	private double getSide1() {
		
		return side1;
	}
	private double getSide2() {
		
		return side2;
	}
	private double getBase() {
	
	return base1;
	}
	private double getHeight() {
		
		return height;
	}
	@Override
	double calcArea() {
		area = (getHeight() * getBase()) / 2;
		return area;
	}

	@Override
	double calcPerimeter() {
		perimeter = getSide1() + getSide2() + getBase();
		
		return perimeter;
	}
	
	public String toString() {
		return "\nTriangle's Perimeter: " + perimeter + "\n\tTriangle's area: " + area;
	}
}
