package shapesM4;



public class ShapeArray {

	public static <objects> void main(String[] args) {
		double length = 2.0;
		double width = 2.0;
		
		Rectangle rect = new Rectangle();
		rect.setLW(length, width);
		
		Circle circ = new Circle();
		circ.setRadius(2.0);
		
		Triangle tri = new Triangle();
		tri.setSides(2.0, 2.0, 2.0, 2.0);
		
		Object[] ShapesArray = {rect, circ, tri};
		
		for(Object s: ShapesArray) {
			System.out.println(s.toString());
		}

	}

}
