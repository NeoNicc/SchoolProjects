//subclass of shape

public class Rectangle extends Shape implements Resizable {
	private double length;
	private double width;
	
	//constructor
	Rectangle(String name, String color, double length, double width) {
		super(name, color);
		this.length = length;
		this.width = width;
	}
	
	//getters
	public String getName() {
		return this.name;
	}
	public String getColor() {
		return this.color;
	}
	public double getLength() {
		return length;
	}
	public double getWidth() {
		return width;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
	//override perimeter calculation method
	@Override
	public double calculatePerimeter() {
		return (length*2)+(width*2);
	}
	
	//override area calculation method
	@Override
	public double calculateArea() {
		return this.length * this.width;
	}
	
	//implementation of Resizable
	@Override
	public void resize(int percent) {
		this.length += this.length*percent*0.01;
		this.width += this.width*percent*0.01;
	}
}
