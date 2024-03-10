package shapesM4;

public class Rectangle extends Shape{
	
	private double width;
	private double length;
	
	public void setLW(double length, double width) {
		this.length = length;
		this.width = width;
	}
	//getters
	private double getLength() {
		
		return length;
	}
	private double getWidth() {
		
		return width;
	}
	
	//abstract methods 
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
	//printing out shape info
	public String toString() {
		return "\nRectangle's Perimeter: " + perimeter + "\n\tRectangle's area: " + area;
	}
}
