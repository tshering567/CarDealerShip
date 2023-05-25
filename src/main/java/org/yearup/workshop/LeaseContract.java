package org.yearup.workshop;

import java.text.DecimalFormat;

public class LeaseContract extends Contract {
    private Vehicle vehicleSold;
    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }
    double endingValueAndLeaseFee() {
        double vehiclePrice = vehicleSold.getPrice();
        double endingValue = vehiclePrice / 2;
        double leaseFee = vehiclePrice * 0.07;
        return endingValue + leaseFee;
    }
    public double expectedEndingValue() {
        double vehiclePrice = vehicleSold.getPrice();
        double endingValue = vehiclePrice / 2;
        return endingValue;
    }
    double getLeaseFee() {
        double vehiclePrice = vehicleSold.getPrice();
        double leaseFee = vehiclePrice * 0.07;
        return leaseFee;
    }


    public Vehicle getVehicleSold() {
        Vehicle vehicleSold = null;
        return vehicleSold;
    }
    @Override
    public double getTotalPrice() {
        double vehiclePrice;
        double totalPrice;
        vehiclePrice = getVehicleSold().getPrice();
        totalPrice = vehiclePrice + (vehiclePrice * 0.07);
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        double vehiclePrice = getVehicleSold().getPrice();
        double interestRate = 0.04; // 4.0%
        int loanTerm = 36;
        double monthlyInterestRate = interestRate / 12;
        double loanAmount = vehiclePrice - expectedEndingValue();
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -loanTerm));
        return monthlyPayment;

    }

    @Override
    public String getPersistenceString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LEASE").append("|");
        builder.append(getDate()).append("|");
        builder.append(getCustomerName()).append("|");
        builder.append(getCustomerEmail()).append("|");
        builder.append(getVehicleSold().getVin()).append("|");
        builder.append(getVehicleSold().getYear()).append("|");
        builder.append(getVehicleSold().getMake()).append("|");
        builder.append(getVehicleSold().getModel()).append("|");
        builder.append(getVehicleSold().getVehicleType()).append("|");
        builder.append(getVehicleSold().getColor()).append("|");
        builder.append(getVehicleSold().getOdometer()).append("|");
        builder.append(getVehicleSold().getPrice()).append("|");
        builder.append(expectedEndingValue()).append("|");
        builder.append(getLeaseFee()).append("|");
        builder.append(getTotalPrice()).append("|");
        builder.append(getMonthlyPayment()).append("|");

        return builder.toString();
    }
}
