package com.Lectures;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

//hello hello
public class Main {

    public static void main(String[] args) {

        int a;
        int b;
        String c;
        char d;
        //String for output later
        String result = "";

        //creating a new instance of cone with parameters passed to the constructor
        Cone cone = new Cone(10, 27);
        result += "Cone: " + cone.toString() + "\n";

        //creating a new instance of cylinder using parameters passes to the constructor
        Cylinder cylinder = new Cylinder(5, 13);
        result += "Cylinder: " + cylinder.toString();

        JOptionPane.showConfirmDialog(null, result);

        //now we check which object has a bigger value using the abstract compareTo() method.
        // In this case, if the cone has a bigger volume, the return value will be 1. If it's
        //smaller -1, or both are the same value then 0.
        if (cone.compareTo(cylinder) == 1) {
            result = "Cone has a larger volume";
        } else if (cone.compareTo(cylinder) == -1) {
            result = "Cylinder has a larger volume";
        } else {
            result = "They are equal";
        }

        //Now output the resulting String
        result += "\n\tCone volume = " + round(cone.calculateVolume(),2) + "\n\tCylinder volume = " + round(cylinder.calculateVolume(),2);
        JOptionPane.showConfirmDialog(null, result);

        //reset our String to empty
        result = "";
        int amount = 5;
        //RegEx pattern that checks for 1 or 2 only
        String pattern = "^[12]$";
        String radiusHeightPattern = "^[0-9]{1,2},[0-9]{1,2}$";

        //create array of type BaseCircle of size 5
        CircleBase[] circleBaseArray = new CircleBase[amount];
        //create an array of Strings for user input of height and radius
        String[] heightRadiusArray;

        int height, radius, choice = 0, i = 0;
        String input, dimensions;

        //create an instance of random and then assign random radius and height values
        Random random = new Random();
        //if we come across an error, this will be changed to false and finish the program
        Boolean flag = true;

        //this do while loop will add an object to each element of the array, depending on what shape the user picks.
        //They will then have the option to input numbers for dimensions, or have random numbers as dimensions
        //do this while i < amount
        try {
            do {
                //Use JOptionPane to get user input
                input = JOptionPane.showInputDialog(null, "Pick either a cone or a cylinder by entering 1 or 2");

                //if the user input matches our regex pattern we execute the statement
                if (input.matches(pattern)) {
                    radius = random.nextInt(26) + 1;
                    height = random.nextInt(26) + 1;
                    //convert input number given from user to an int. This will decide if a circle or cone is instantiated later on
                    choice = Integer.parseInt(input);

                    //Then ask would they like random or user input by inputting Y or N. String dimensions will record the answer
                    dimensions = JOptionPane.showInputDialog(null, "Would you like to enter a radius and height? Y/N");

                    //if they have selected to enter their own input and the string matches Y, enter this loop
                    if(dimensions.equalsIgnoreCase("Y")){
                        do{
                            //Ask for user input in the format of 123,456
                            dimensions = JOptionPane.showInputDialog(null, "Enter radius and height in the format radius,height");

                            //if the input matches the Regex Pattern then enter the if statement, otherwise skip to the else statement
                            if(dimensions.matches(radiusHeightPattern)){

                                //split the input into two elements of an array and then assign to new int variables
                                heightRadiusArray = dimensions.split(",");
                                height = Integer.parseInt(heightRadiusArray[0]);
                                radius = Integer.parseInt(heightRadiusArray[1]);

                            }
                            else{
                                JOptionPane.showInputDialog(null, "Incorrect input format.");
                            }
                        }while(!dimensions.matches(radiusHeightPattern));
                    }

                    //based on user input in the last do while loop, either case 1 or 2 (Cone/ Cylinder) will be executed depending on
                    //what the user picked
                    switch (choice) {
                        case 1:

                            //if they picked Cone, element[i] of the array will be a new Cone object of random radius/height
                            //then increment i
                            circleBaseArray[i] = new Cone(radius, height);
                            i++;

                            break;
                        case 2:

                            circleBaseArray[i] = new Cylinder(radius, height);
                            i++;

                            break;
                    }
                }
                //if the pattern isn't matched then display this message
                else {
                    JOptionPane.showConfirmDialog(null, "Incorrect user input");
                }
            } while (i < amount);
        }

        //we are trying to catch a null pointer exception. This happens if the user enters cancel on the JOptionPane
        //dialogue box
        catch (NullPointerException anError){
            JOptionPane.showConfirmDialog(null, "Exited program. " + anError);
            //change flag to false to stop next block executing
            flag = false;
        }

        //if we encounter an error from the previous block of code, this code will not execute
        if(flag) {
            //this block of code prints out the array, and states whether each element is a Cone or a Circle
            String shape = "";
            for (i = 0; i < circleBaseArray.length; i++) {
                if (circleBaseArray[i] instanceof Cone) {
                    shape = "Cone";
                } else {
                    shape = "Cylinder";
                }
                result += i + ". " + shape + " -> " + circleBaseArray[i].toString() + "\n";
            }
            JOptionPane.showConfirmDialog(null, "The array you created is;\n" + result);

            //Using the Arrays class, sort the array by smallest to largest volume. The sort method uses
            //the implemented abstract method compareTo() from the Comparable interface
            Arrays.sort(circleBaseArray);

            //this block of code prints out the array again, but also displays the volume of each object
            result = "";
            shape = ";";
            double volume = 0d;
            for (i = 0; i < circleBaseArray.length; i++) {
                if (circleBaseArray[i] instanceof Cone) {
                    shape = "Cone";
                    Cone newCone = (Cone) circleBaseArray[i];
                    volume = newCone.calculateVolume();
                } else {
                    shape = "Cylinder";
                    Cylinder newCylinder = (Cylinder) circleBaseArray[i];
                    volume = newCylinder.calculateVolume();
                }
                result += i + ". " + shape + ": " + circleBaseArray[i].toString() + ". Volume = " + round(volume, 2) + "\n";
            }
            JOptionPane.showConfirmDialog(null, "The array put in order of volume, from smallest to biggest\n" + result);
        }
    }

    //this method rounds a double to precision decimal places
    public static double round(double number, int precision){
        //first, multiply 10 by the expected number of decimal places
        int decimalPlaces = (int)Math.pow(10, precision);
        //now multiply the number the precision, round the number a,d then divided again by precision and cast to a double to get the correct
        //number of decimal places
        double rounded = (double)Math.round(number*decimalPlaces)/decimalPlaces;
        return rounded;
    }
}