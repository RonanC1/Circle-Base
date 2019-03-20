/*CircleBase is an abstract class for creating a circle object and has a colour and a radius.
* The class implements the Comparable Interface and has an abstract method for calculating the area
* of a circle*/

package com.Lectures;

public abstract class CircleBase implements Comparable<CircleBase> {

    private String colour;
    protected int radius;
    //private static int instance;

    //default constructor
    public CircleBase(){
        this.radius = 1;
    }

    //constructor that sets the radius
    public CircleBase(int radius){
        this.radius = radius;
    }

    //abstract method
    public abstract double calculateArea();

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
