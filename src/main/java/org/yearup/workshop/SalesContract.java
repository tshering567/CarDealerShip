package org.yearup.workshop;

import java.util.Scanner;

public class SalesContract extends Contract{
    public SalesContract(String dateOfContract, String customerName, String customerEmail, String vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }

    @Override
    public double getTotalPrice() {
        double vehiclePrice = 0;
        double totalPrice = 0;
        Vehicle vehicleSold= null;
        vehiclePrice = vehicleSold.getPrice();
        if(vehiclePrice < 10000){
            totalPrice = vehiclePrice + 295;
        } else{ totalPrice = vehiclePrice + 495;
        } totalPrice = totalPrice + 100;
        totalPrice = totalPrice + (vehiclePrice + 0.05);


        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
//       Scanner scanner = new Scanner(System.in);
//       System.out.println("Would you like to finance your payment? Please enter (Yes or No.");
//       String userInput = scanner.nextLine();
      Vehicle vehicleSold = null;
        double vehiclePrice = vehicleSold.getPrice();
        double p = vehiclePrice;
        double r;
        double n;
        double t;
        if(vehiclePrice >= 10000){
            r = 0.0425;
            t = 4;
            n = 12;
        }else{
            r = 0.0525;
            t = 2;
            n = 12;
        }
        double rOverN = r/n ;
        double numerator = p * rOverN;
        double onePlusOverN = 1 + rOverN;
        double power = -t * n;
        double denominator = 1 - Math.pow(onePlusOverN, power);
        double payment = numerator/denominator;
        return payment;





    }

    @Override
    public String getPersistenceString() {
        return null;
    }
}
