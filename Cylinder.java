/*The Cylinder class is a child of CircleBase. It implements a method to calculate the volume of a cylinder object,
 * it overrides an abstract method from the parent class to calculate the area and implements an abstract method compareTo()
 * from the Comparable interface*/

package com.Lectures;

public class Cylinder extends CircleBase{
    private int height;

    //default constructor calling the constructor that accepts two ints and passing default values to it
    public Cylinder(){
        this(1,1);
    }

    //constructor that accepts two ints as parameters
    public Cylinder(int radius, int height) {
        super(radius);
        this.height = height;
    }

    //calculating the volume of a cylinder with the formula A = πr(2)h
    public double calculateVolume(){
        double volume = Math.PI*(getRadius()*getRadius())*this.height;
        return volume;
    }

    //calculating cylinder area with the formula A = 2πrh + 2πr(2)
    @Override
    public double calculateArea(){
        double area = 2*(Math.PI*getRadius()*this.height) + 2*(Math.PI*(getRadius()*getRadius()));
        return area;
    }

    //Overridden method from Comparable interface that compares this object's volume with another that has the same parent class
    //Polymorphism is used to hide the child object as a circleBase object
    @Override
    public int compareTo(CircleBase circleBase){
        //if circleBase is an instance of Cylinder then cast it to a Cylinder object
        if(circleBase instanceof Cone) {
            Cone cone = (Cone)circleBase;
            return Double.compare(this.calculateVolume(), cone.calculateVolume());
        }
        //using Double.compare, we compare the volume of both objects
        else {
            Cylinder cylinder = (Cylinder)circleBase;
            return Double.compare(this.calculateVolume(), cylinder.calculateVolume());
        }
    }

    //return a String representation of the class
    @Override
    public String toString(){
        return "Radius = " + this.radius + ". Height = " + this.height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
