package org.yearup.workshop;

public abstract class Contract {
   private  String dateOfContract;
   private  String customerName;
   private String customerEmail;
   private Vehicle vehicle;
   private Double totalPrice;
   private Double monthlyPayment;

   public Contract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle) {
   }

   public String getDateOfContract() {
      return dateOfContract;
   }

   public void setDateOfContract(String dateOfContract) {
      this.dateOfContract = dateOfContract;
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

   public Vehicle getVehicle() {
      return vehicle;
   }

   public void setVehicleSold(String vehicleSold) {
      this.vehicle = vehicle;
   }

   public Contract(String dateOfContract, String customerName, String customerEmail, String vehicleSold) {
      this.dateOfContract = dateOfContract;
      this.customerName = customerName;
      this.customerEmail = customerEmail;
      this.vehicle = vehicle;
   }

   public abstract  double getTotalPrice();

   public abstract double getMonthlyPayment();
   public abstract String getPersistenceString();




}

