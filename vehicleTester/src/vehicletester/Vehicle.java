package vehicletester;

import javax.swing.*;

/**
 * @title VehicleTester
 * @author Steven Biro
 * @teacher Mr. J. Carron
 * @date 01-May-2015 1:40:44 PM
 * @purpose The purpose of this program is to emulate the functions of a vehicle
 */

public class Vehicle {

    public double gasKilometrage;
    public double fuelTankSize;
    public double fuelAvailable;
    public double kilometresTravelled;
    public int passengers;
    public double fare, fuleCost, cost, revenue;

    public Vehicle() {
        //Default Constructor
        gasKilometrage = 0;
        fuelTankSize = 0;
        fuelAvailable = 0;
        kilometresTravelled = 0;
        passengers = 0;
        fare = 0;
        fuleCost = 0;
    }

    public Vehicle(double gK, double fTS, double fA, double kT) {
        //basic constructor
        gasKilometrage = gK;
        fuelTankSize = fTS;
        fuelAvailable = fA;
        kilometresTravelled = kT;
    }

    public Vehicle(double gK, double fTS, double fA, double kT, int pass, double fr, double fuleC) {
        //full constructor
        gasKilometrage = gK;
        fuelTankSize = fTS;
        fuelAvailable = fA;
        kilometresTravelled = kT;
        passengers = pass;
        fare = fr;
        fuleCost = fuleC;
    }

    public void addFuel(double gas) {//add fule to the tank if it can fit
        if ((fuelTankSize - fuelAvailable) >= gas) {
            fuelAvailable += gas;
            System.out.println("Added " + gas
                    + "L of gas to the tank.");
        } else {//disply this if it cant fit
            System.out.println("You tried to add " + gas + "L of gas.");
            System.out.println("There is only room for "
                    + (fuelTankSize - fuelAvailable) + "L.");
        }
    }

    public void driveVehicle(double kms) {
    //Drive the vehicle
        //ex.  If the vehicle uses 9.5L/100 km then
        //litresNeeded = kms * 9.5 / 100
        System.out.println("Drive " + kms + "kms.  Start with "
                + fuelAvailable + "L of gas.");
        double litresNeeded = (kms * gasKilometrage) / 100.0;
        if (fuelAvailable >= litresNeeded) {
            fuelAvailable -= litresNeeded;
            kilometresTravelled += kms;
            System.out.println("Used " + litresNeeded + "L of gas.");
        } else {
            System.out.println("Ran out of fuel!");
            //Calculate how many kms were driven
            double kmsThisDrive = (fuelAvailable * 100.0) / gasKilometrage;
            kilometresTravelled += kmsThisDrive;
            fuelAvailable = 0;
            System.out.println("The vehicle drove " + kmsThisDrive
                    + " before running out of gas.");
        }
    }
//output all the info about the vehicle

    public String toString() {
        String output = "Gas Kilometrage = " + gasKilometrage + "\n";
        output += "Fuel Tank Size = " + fuelTankSize + "\n";
        output += "Fuel Available = " + fuelAvailable + "\n";
        output += "Kilometres Driven = " + kilometresTravelled + "\n";
        output += "Passengers = " + passengers + "\n";
        output += "Fare = " + fare + "\n";
        output += "Fule Cost = " + fuleCost + "\n";
        return output;
    }//set passengers

    public void setPassengers(int pass) {
        passengers = pass;
    }//set fare

    public void setFare(double fr) {
        fare = fr;
    }//set fule cost

    public void setFuleCost(double fuleC) {
        fuleCost = fuleC;
    }//calculate revenu

    public void revenue() {
        revenue = passengers * fare;
        //output revenue
        JOptionPane.showMessageDialog(null, "The revenue from your trip is: $" + revenue);
        System.out.println("Revenue = " + revenue);
    }

    public void cost() {
        //calculate cost
        try {//try to use a number give by user, if not possible use default
            fuleCost = Double.parseDouble(JOptionPane.showInputDialog("How much does fule cost right now?\nEx. 1.23"));
        } catch (NumberFormatException e) {
            System.out.println("That was not an acceptable number, using current value");
        }
        cost = ((kilometresTravelled * gasKilometrage) / 100) * fuleCost;
//output cost      
        JOptionPane.showMessageDialog(null, "The cost of your trip is: $" + cost);
        System.out.println("Cost = " + cost);

    }

    public void profit() {
        //calculate and output profit
        JOptionPane.showMessageDialog(null, "The profit frome your trip is: $" + (revenue - cost));
        System.out.println("Profit = " + (revenue - cost));

    }
}
