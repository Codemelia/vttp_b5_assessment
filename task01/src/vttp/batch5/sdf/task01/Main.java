package vttp.batch5.sdf.task01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import vttp.batch5.sdf.task01.models.BikeEntry;

public class Main {
    
    public static void main (String[] args) throws FileNotFoundException, IOException {
        // init
        String inputFile = "task01/day.csv";
        String input;

        Map<String, Integer> headers = new HashMap<>();
        Map<String, BikeEntry> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            while((input = br.readLine()) != null) {

                String[] lines = input.split(",");
                BikeEntry bikeEntry = BikeEntry.toBikeEntry(lines);

                map.put("weekday", bikeEntry);

            }

            // Find top 5 days with most cyclists
            for (Map.Entry<String, BikeEntry> entry : map.entrySet()) {
                BikeEntry bikeEntry = entry.getValue();
                if ("weekday".equals(bikeEntry.getWeekday())) {
                    
                }
            }
            
        }
    }

}
