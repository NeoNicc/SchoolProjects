//subclass of Shape

public class Circle extends Shape implements Resizable {
	private double radius;
	
	Circle(String name, String color, double radius) {
		super(name, color);
		this.radius = radius;
	}
	
	//getters
	public String getName() {
		return this.name;
	}
	public String getColor() {
		return this.color;
	}
	public double getRadius() {
		return this.radius;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	//override perimeter method of shape
	@Override
	public double calculatePerimeter() {
		return 2*Math.PI*this.radius;
	}
	
	//override the area method of shape
	@Override
	public double calculateArea() {
		return Math.PI*Math.pow(radius, 2);
	}
	
	//override the interface Resizable
	@Override
	public void resize(int percent) {
		this.radius += this.radius*percent*0.01;
	}
}
