package org.yearup.workshop;

public class LeaseContract extends Contract {
    public LeaseContract(String dateOfContract, String customerName, String customerEmail, String vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }

    @Override
    public double getTotalPrice() {
        double vehiclePrice;
        double totalPrice;
        vehiclePrice = getVehicle().getPrice();
        totalPrice = vehiclePrice + (vehiclePrice * 0.07);
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {

        return 0;
    }

    @Override
    public String getPersistenceString() {
        return null;
    }
}
