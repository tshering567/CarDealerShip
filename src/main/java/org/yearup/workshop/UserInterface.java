package org.yearup.workshop;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
  // public static Scanner scanner = new Scanner(System.in);
   DealerShip dealerShip;
    private void init(){
      DealerShipFileManager fileManager = new DealerShipFileManager();
      this.dealerShip = fileManager.getDealership();
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
               case 0 -> {
                   System.out.println("Have a nice day :)");
                   System.exit(0);
               }
               default -> System.out.println("Please enter a valid option");


           }
       } while (input != 0);


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

   }

   public void getAllVehicleRequest(){
   this.dealerShip.getAllVehicles();

   }
   public void AddVehicleRequest(){


   }

   public void RemoveVehicleRequest(){

   }
}
