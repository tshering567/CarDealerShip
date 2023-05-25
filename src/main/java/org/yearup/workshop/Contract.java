package org.yearup.workshop;

public abstract class Contract {
   private  String date;
   private  String customerName;
   private String customerEmail;
   private Vehicle vehicleSold;
   private Double totalPrice;
   private Double monthlyPayment;

   public Contract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle) {
      this.date = date;
      this.customerName = customerName;
      this.customerEmail = customerEmail;
      this.vehicleSold = vehicle;

   }

   public String getDate() {
      return date;
   }

   public void setDateOfContract(String date) {
      this.date = date;
   }

   public String getCustomerName() {
      return customerName;
   }

   public void setCustomerName(String customerName) {
      this.customerName = customerName;
   }

   public String getCustomerEmail() {
      return customerEmail;
   }

   public void setCustomerEmail(String customerEmail) {
      this.customerEmail = customerEmail;
   }
   public Vehicle getVehicleSold() {
      return vehicleSold;
   }

   public void setVehicle(Vehicle vehicle) {
      this.vehicleSold = vehicle;
   }





   public abstract  double getTotalPrice();

   public abstract double getMonthlyPayment();
   public abstract String getPersistenceString();




}

