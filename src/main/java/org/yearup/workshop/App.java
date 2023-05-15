package org.yearup.workshop;

public class App {
    public static void main(String[] args) {
DealerShipFileManager Dfm = new DealerShipFileManager();
DealerShip d = Dfm.getDealership();
d.getAllVehicles();
    }
}
