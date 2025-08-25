package org.example;

import org.example.model.Neo;
import org.example.model.NeoFeedResponse;
import org.example.service.NASAService;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    //This class' job is to interface with the user
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Hello to my Near Earth Object App!");
        System.out.print("Please enter start date (YYYY-MM-DD): ");

        String startDate = userInput.nextLine();

        NASAService service = new NASAService();
        NeoFeedResponse response = service.getAllNeos(startDate, startDate);

        //For each loop - to loop through the map
        for (String key: response.getNearEarthObject().keySet()){
            //grab the list(values) based on the key (date)
            List<Neo> neoList = response.getNearEarthObject().get(key);
            int count = neoList.size();
            System.out.println("For Date: " + key + " there are " + count + " near earth objects");

            for(Neo n: neoList){
                System.out.println("Id: " + n.getId());
                System.out.println("Name: " + n.getName());
                System.out.println("Potentially Hazardous? " + n.getItHazardous());
                System.out.println("Estimated Diameter:");
                System.out.println("\tMin in Miles: " + n.getEstimatedDiameter().getMiles().getEstimatedDiameterMin());
                System.out.println("\tMax in Miles: " + n.getEstimatedDiameter().getMiles().getEstimatedDiameterMax());
                System.out.println("\n");
            }
        }
    }
}