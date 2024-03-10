package shapesM4;

public class Circle extends Shape{
	
	private double radius;
	
	public void setRadius(double radius) {
		
		this.radius = radius;
	}
	//getters
	private double getRadius() {
		
		return radius;
	}

	//abstract methods 
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
	
	//printing out shape info
	public String toString() {
		return "\nCircle's circumference: " + perimeter + "\n\tCircle's area: " + area;
	}
}
