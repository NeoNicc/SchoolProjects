//Author: Nicholas Watson
//Date: 10/01/2026
//Class: COP 3337
//Program: create and manipulate circles and rectangle
//that are subclasses with implementations

public class ShapeTest {
	public static void main(String[] args) {
        Circle circle = new Circle("Circle", "Red", 5);
        Rectangle rectangle = new Rectangle("Rectangle", "Blue", 4, 6);

        System.out.println("Circle:");
        System.out.println("Name: " + circle.getName());
        System.out.println("Color: " + circle.getColor());
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Perimeter: " + circle.calculatePerimeter());
        circle.resize(50);
        System.out.println("Resized Circle - Radius: " + circle.getRadius());

        System.out.println("\nRectangle:");
        System.out.println("Name: " + rectangle.getName());
        System.out.println("Color: " + rectangle.getColor());
        System.out.println("Length: " + rectangle.getLength());
        System.out.println("Width: " + rectangle.getWidth());
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
        rectangle.resize(50);
        System.out.println("Resized Rectangle - Length: " + rectangle.getLength() + ", Width: " + rectangle.getWidth());
    }
}
