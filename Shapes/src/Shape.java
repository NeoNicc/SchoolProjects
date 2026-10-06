//Author: Nicholas Watson
//Date: 10/01/2026
//Class: COP 3337
//Program: Creates an abstract Shape class to be inherited by circle and rectangle

public abstract class Shape {
	protected String name;
	protected String color;
	
	protected Shape(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
	abstract double calculateArea();
	
	abstract double calculatePerimeter();
}
