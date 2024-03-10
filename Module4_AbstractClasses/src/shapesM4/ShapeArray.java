package shapesM4;



public class ShapeArray {

	public static void main(String[] args) {
		
		
		Rectangle rect = new Rectangle();
		rect.setLW(7.5, 2.0);
		rect.calcArea();
		rect.calcPerimeter();
		
		Circle circ = new Circle();
		circ.setRadius(5.0);
		circ.calcArea();
		circ.calcPerimeter();
		
		Triangle tri = new Triangle();
		tri.setSides(2.0, 2.0, 4.0, 2.0);
		tri.calcArea();
		tri.calcPerimeter();
		
		Object[] ShapesArray = {rect, circ, tri};
		
		for(Object s: ShapesArray) {
			System.out.println(s.toString());
		}

	}

}
