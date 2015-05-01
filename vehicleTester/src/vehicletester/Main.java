package vehicletester;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //make car1
        Vehicle car1 = new Vehicle(7.5, 60.0, 60.0, 0.0, 15, 5.75, 1.39);
        //Show Vehicle Info
        System.out.println(car1);

        //Drive car for 300km
        car1.driveVehicle(300.0);
        System.out.println(car1);

        //Drive car for 225 kms
        car1.driveVehicle(225.0);
        System.out.println(car1);

//calculate revenu cost and profit
        car1.revenue();
        car1.cost();
        car1.profit();

    }
}
