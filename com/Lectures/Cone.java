/*The Cone class is a child of CircleBase. It implements a method to calculate the volume of a cone object,
 * it overrides an abstract method from the parent class to calculate the area and implements an abstract method compareTo()
 * from the Comparable interface*/

package com.Lectures;

public class Cone extends CircleBase{
    private int height;

    //default constructor, passes the values to the constructor that accepts two doubles
    public Cone(){
        this(1,1);
    }

    //constructor that accepts a radius and height from the user
    public Cone(int radius, int height){
        super(radius);
        this.height = height;
    }

    //calculates the volume of the cone using the formula Vcone = 1/3 × pi × r2 × h
    public double calculateVolume(){
        double volume = (1/3d)*(Math.PI)*(getRadius()*getRadius())*(this.height);

        return volume;
    }

    //Calculates the area of the cone with A = PI*r(r+sqrt(h*h + r*r)
    @Override
    public double calculateArea() {
        double area = (Math.PI*getRadius())*(getRadius() + Math.sqrt((height*height)+(getRadius()*getRadius())));

        return area;
    }

    //Overridden method from Comparable interface that compares this object's volume with another that has the same parent class
    //Polymorphism is used to hide the child object as a circleBase object
   @Override
   public int compareTo(CircleBase circleBase){
        //if circleBase is an instance of Cylinder then cast it to a Cylinder object
        if(circleBase instanceof Cylinder){
            Cylinder cylinder = (Cylinder) circleBase;
            //using Double.compare, we compare the volume of both objects
            return Double.compare(this.calculateVolume(), cylinder.calculateVolume());
        }
        else {
            Cone cone = (Cone)circleBase;
            return Double.compare(this.calculateVolume(), cone.calculateVolume());
        }
   }

    //return a String representation of the class
    @Override
    public String toString(){
        return "Radius = " + this.radius + ". Height = " + this.height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}