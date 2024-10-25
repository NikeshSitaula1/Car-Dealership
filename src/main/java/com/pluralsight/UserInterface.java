package com.pluralsight;

public class UserInterface {


    public UserInterface(){

        Dealership deal = DealershipFileManager.getDealership();

        System.out.println("Car Dealership App");


        deal.allVehicles();


    }


}
