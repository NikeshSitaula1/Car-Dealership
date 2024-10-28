package com.pluralsight;

public class UserInterface {

    static Dealership deal;


    public UserInterface(){
        deal = DealershipFileManager.getDealership();

        do {
            try {
                System.out.println("-----------------Welcome to Car Dealership-------------------");
                System.out.println("1. [Display] all vehicles");
                System.out.println("2. [Add] a vehicle");
                System.out.print(">> ");

                String option = Console.PromptForString();

                if (option.equals("1")) {
                    displayAll();
                }
                else if (option.equals("2")) {
                    addVehicle();
                } else {
                    System.out.println("Invalid entry");
                }
            } catch (Exception e){
                System.out.println("Invalid entry");
            }
        }while (true);


    }

    public void display(){


    }

    public void displayAll(){
        for(Vehicle vehicle : deal.getAllVehicles()){
            System.out.println(vehicle);
        }
    }


    void addVehicle(){
        //get lots of values from the user...
        int vin = Console.PromptForInt("Enter Vin: ");
        int year = Console.PromptForInt("Enter date: ");
        String make = Console.PromptForString("Enter make: ");
        String model = Console.PromptForString("Enter model: ");
        String vehicleType = Console.PromptForString("Enter vehicle type: ");
        String color = Console.PromptForString("Enter color:  ");
        int odometer = Console.PromptForInt("Enter odometer: ");
        double price = Console.PromptForDouble("Enter price: ");

        //create an instance of a Vehicle class from those values...
        Vehicle v = new Vehicle(vin,year, make, model, vehicleType, color, odometer, price);

        //call the dealerships addVehicle method, passing it the vehicle you just created.
        deal.addVehicle(v);
        DealershipFileManager.saveDealership(deal);
    }
}
