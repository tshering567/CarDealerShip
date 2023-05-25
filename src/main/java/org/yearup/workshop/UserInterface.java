package org.yearup.workshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
  // public static Scanner scanner = new Scanner(System.in);
  private DealerShip dealerShip;

    private contractFileManager contractFileManager;

    private void init(){
      DealerShipFileManager fileManager = new DealerShipFileManager();
      this.dealerShip = fileManager.getDealership();
        this.contractFileManager = new contractFileManager();
   }
   public static Scanner scanner= new Scanner(System.in);
    public void printHeader(){
        System.out.println("_______________________________________________________________________________________________________________");
        System.out.println("VIN                 YEAR      MAKE            MODEL         TYPE         COLOR     ODOMETER           PRICE");
        System.out.println("_______________________________________________________________________________________________________________");
    }

   public void display() {
       ////Load the dealership data
       init();

       Scanner scanner = new Scanner(System.in);
       int input;
       do {



           System.out.println("\n \n Main Menu:");
           //1 Display the menu
           System.out.println("Display by Price [1]");
           System.out.println("Display by Make and Model [2]");
           System.out.println("Display by Year [3]");
           System.out.println("Display by Color [4]");
           System.out.println("Display by Mileage [5]");
           System.out.println("Display by Type [6]");
           System.out.println("Display All vehicles [7]");
           System.out.println("Add vehicle [8]");
           System.out.println("Remove vehicle [9]");
           System.out.println("Buy or Lease Vehicle [10]");
           System.out.println("Exit [0]");
           input = Integer.parseInt(scanner.nextLine());

           //2 Read user's command
           //3 switch statement that calls the correct process() method

           switch (input) {
               case 1 -> processGetByPriceRequest();
               case 2 -> processGetByMakeModelRequest();
               case 3 -> processGetByYearRequest();
               case 4 -> processGetByColorRequest();
               case 5 -> processGetByMileageRequest();
               case 6 -> processGetByVehicleTypeRequest();
               case 7 -> getAllVehicleRequest();
               case 8 -> AddVehicleRequest();
               case 9 -> RemoveVehicleRequest();
               case 10 -> buyOrLeaseVehicle();
               case 0 -> {
                   System.out.println("Have a nice day :)");
                   System.exit(0);
               }
               default -> System.out.println("Please enter a valid option");


           }
       } while (input != 0);


   }

    private void buyOrLeaseVehicle() {
    }

    public void displayVehicles(ArrayList<Vehicle> inventory){

        for(Vehicle v :inventory) {
            System.out.printf("%-20d %-7d %-15s %-15s %-10s %-10s %-20d %-20.2f \n",
                    v.getVin(),
                    v.getYear(),
                    v.getMake(),
                    v.getModel(),
                    v.getVehicleType(),
                    v.getColor(),
                    v.getOdometer(),
                    v.getPrice());
        }

    }
   public void processGetByPriceRequest(){
       Scanner scanner = new Scanner(System.in);
       System.out.println("Please enter a minimum price");
       int min = scanner.nextInt();
       System.out.println("Please enter a maximum price");
       int max = scanner.nextInt();
        this.dealerShip.getVehiclesByPrice(min, max);

   }

   public void processGetByMakeModelRequest(){
        Scanner scanner = new Scanner(System.in);
       System.out.println("Please enter the make of the vehicle");
       String make = scanner.nextLine();
       System.out.println("Please enter the model of the vehicle");
       String model = scanner.nextLine();
       this.dealerShip.getVehiclesByMakeModel(make,model);

   }

   public void processGetByYearRequest(){
       Scanner scanner = new Scanner(System.in);
       System.out.println("Please enter the minimum Year of the vehicle");
       int minYear = scanner.nextInt();
       System.out.println("Please enter the maximum Year of the vehicle");
       int maxYear = scanner.nextInt();
       this.dealerShip.getVehiclesByYear(minYear, maxYear);



   }

   public void processGetByColorRequest(){
       Scanner scanner = new Scanner(System.in);
       System.out.println("Please enter the color of the vehicle");
       String color = scanner.nextLine();
       this.dealerShip.getVehiclesByColor(color);


   }

   public void processGetByMileageRequest(){
       Scanner scanner = new Scanner(System.in);
       System.out.println("Please enter the minimum mileage of the vehicle");
       int min = scanner.nextInt();
       System.out.println("Please enter the maximum mileage of the vehicle");
       int max = scanner.nextInt();
       this.dealerShip.getVehiclesByMileage(min, max);
    }

   public void processGetByVehicleTypeRequest(){
       Scanner scanner = new Scanner(System.in);
       System.out.println("Please enter the type of the vehicle");
       String type = scanner.nextLine();
       this.dealerShip.getVehiclesByType(type);



   }

   public void getAllVehicleRequest(){
        printHeader();
     ArrayList list = (ArrayList) dealerShip.getAllVehicles();
     displayVehicles(list);

   }
   public void AddVehicleRequest(){
       Scanner scanner = new Scanner(System.in);
       System.out.println("Please enter the vin of the vehicle: ");
       int vin = scanner.nextInt();
       System.out.println("Please enter the year of the vehicle: ");
       int year = scanner.nextInt();
       System.out.println("Please enter the make of the vehicle: ");
       String make = scanner.next();
       System.out.println("Please enter the model of the vehicle: ");
       String model = scanner.next();
       System.out.println("Please enter the type of the vehicle: ");
       String vehicleType = scanner.next();
       System.out.println("Please enter the color of the vehicle: ");
       String color = scanner.next();
       System.out.println("Please enter the odometer of the vehicle: ");
       int odometer = scanner.nextInt();
       System.out.println("Please enter the price of the vehicle: ");
       double price = scanner.nextDouble();
       System.out.println(" \n Vehicle added successfully. Thank You!");
       Vehicle vehicle =  new Vehicle(vin, year, make, model, vehicleType,color,odometer, price);
       dealerShip.addVehicle(vehicle);

       DealerShipFileManager DFM = new DealerShipFileManager();
       DFM.saveDealership(dealerShip);


   }

   public void RemoveVehicleRequest(){
       Scanner scanner = new Scanner(System.in);
       System.out.println("Please enter the vin of the vehicle that you would like to remove: ");
       int vin = scanner.nextInt();
       Vehicle vehicleEntered = null;
       for(Vehicle v: dealerShip.getAllVehicles())
           if (v.getVin() == vin) {
               vehicleEntered = v;
               break;
           } if (vehicleEntered != null){
               dealerShip.removeVehicle(vehicleEntered);
           System.out.println("Vehicle removed successfully. Thank You!");
           DealerShipFileManager DFM = new DealerShipFileManager();
          DFM.saveDealership(dealerShip);
       }else{
           System.out.println("No match");
       }
   }
    public void buyOrLeaseAVehicle() {
        LocalDate date = LocalDate.now();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your full name?");
        String customerName = scanner.nextLine();
        System.out.println("What is your email address?");
        String customerEmail = scanner.nextLine();
        System.out.println("Do you want to lease or buy? (Enter lease/buy)");
        String leaseOrBuy = scanner.nextLine().toLowerCase();

        DealerShip dealership;
        dealership = null;
        if (leaseOrBuy.equals("buy")) {
            System.out.println("Which vehicle do you want to buy? (Enter VIN)");
            int chosenVehicle = scanner.nextInt();
            Vehicle vehicle = dealership.getVehicleByVin(chosenVehicle);

            if (vehicle != null) {
                System.out.println("Do you want to finance the car? (y/n)");
                String financeOrNot = scanner.nextLine().toLowerCase();
                boolean finance = financeOrNot.equals("y");

                SalesContract salesContract = new SalesContract(
                        date.toString(), customerName, customerEmail, vehicle
                );
                double monthlyPayment = salesContract.getMonthlyPayment();
                if (finance) {
                    System.out.println("Your monthly payment is " + monthlyPayment);
                }
                System.out.println("Congrats! The vehicle is yours.");
                contractFileManager.saveContract(salesContract);
                dealership.removeVehicle(vehicle);
            } else {
                System.out.println("Vehicle not found.");
            }
        } else if (leaseOrBuy.equals("lease")) {
            System.out.println("Which vehicle do you want to lease? (Enter VIN)");
            int chosenVehicle = scanner.nextInt();
            Vehicle vehicle = dealership.getVehicleByVin(chosenVehicle);

            if (vehicle != null) {
                LeaseContract leaseContract = new LeaseContract(
                        date.toString(), customerName, customerEmail, vehicle.toString());

                double monthlyPayment = leaseContract.getMonthlyPayment();
                System.out.println("Congrats! The vehicle is yours for the next 3 years.");
                System.out.println("Your monthly payment is " + monthlyPayment);
                org.yearup.workshop.contractFileManager.saveContract(leaseContract);
                dealership.removeVehicle(vehicle);
            } else {
                System.out.println("Vehicle not found.");
            }
        } else {
            System.out.println("Invalid response. Try again.");
        }
    }





    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            System.out.println("List of Vehicles available:");
            for (Vehicle v : vehicles) {
                System.out.printf("%-20d %-7d %-15s %-15s %-10s %-10s %-20d %-20.2f \n",
                        v.getVin(),
                        v.getYear(),
                        v.getMake(),
                        v.getModel(),
                        v.getVehicleType(),
                        v.getColor(),
                        v.getOdometer(),
                        v.getPrice());
            }
        }
    }
}


