package shapesM4;

public class Rectangle extends Shape{
	double area;
	double perimeter;
	double rWidth;
	double rLength;
	
	public void setLW(double length, double width) {
		rLength = length;
		rWidth = width;
		
	}
	private double getLength() {
		
		return rLength;
	}
	
	private double getWidth() {
		
		return rWidth;
	}
	
	@Override
	public double calcArea() {
		area = getWidth() * getLength();
		
		return area;
	}

	@Override
	public double calcPerimeter() {
		perimeter = (getWidth() * 2) + (getLength() * 2);
		
		return perimeter;
	}
	
	public String toString() {
		return "\nRectangle's Perimeter: " + perimeter + "\n\tRectangle's area: " + area;
	}
}
