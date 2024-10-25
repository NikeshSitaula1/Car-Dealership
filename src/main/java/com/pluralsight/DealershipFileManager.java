package com.pluralsight;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.regex.Pattern;

public class DealershipFileManager {

    
    public static Dealership getDealership() {



        Dealership dealership = new Dealership();

        try {
            FileReader fr = new FileReader("inventory.csv");
            BufferedReader br = new BufferedReader(fr);

            String input;

            br.readLine(); //Skips line by line

            /* Read each line from the file until there are no more lines to read.
            Splits the lines into tokens using the '|' character as the delimiter.
             */
            while ((input = br.readLine()) != null) {

                Vehicle vehicle = new Vehicle(input);
                dealership.addVehicle(vehicle);
            }
            br.close(); //Closes the BufferedReader

        } catch (Exception e) {
            System.out.println("Error while saving Transactions: " + e.getMessage());
        }
        return dealership; //Returns the list
    }


    // Method to save transactions to a file in a specific format
    public static void saveDealership(Dealership dealership) {

        try {
            //Creating a file writer and assigning the file writer to the buffered writer.
            FileWriter fw = new FileWriter("inventory.csv");
            BufferedWriter bw = new BufferedWriter(fw);

            // Loop through transactions and write each one to the file
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                String data = vehicle.getVin() + "|"
                        + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel()
                        + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" +vehicle.getColor() +
                        "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "\n";
                bw.write(data);
            }
            bw.close(); // Close the BufferedWriter

        } catch (IOException e){
            System.out.println("Error while saving Transactions: " + e.getMessage());
        }
    }
}
