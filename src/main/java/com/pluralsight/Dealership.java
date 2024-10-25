package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;


    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }


    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void allVehicles(){
        for(Vehicle vehicle : inventory){
            System.out.println(vehicle);
        }
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }
}