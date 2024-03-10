package shapesM4;

public class Triangle extends Shape{
	
	private double side1;
	private double side2;
	private double base;
	private double height;
	
	public void setSides(double s1, double s2, double base, double height) {
		side1 = s1;
		side2 = s2;
		this.base = base;
		this.height = height;
	}
	
	//getters
	private double getSide1() {
		
		return side1;
	}
	private double getSide2() {
		
		return side2;
	}
	private double getBase() {
	
		return base;
	}
	private double getHeight() {
		
		return height;
	}
	
	//abstract methods 
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
	
	//printing out shape info
	public String toString() {
		return "\nTriangle's Perimeter: " + perimeter + "\n\tTriangle's area: " + area;
	}
}
