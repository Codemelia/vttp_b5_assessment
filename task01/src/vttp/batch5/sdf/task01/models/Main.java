package vttp.batch5.sdf.task01.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    BikeEntry bikeEntry = new BikeEntry();
    
    public static void main (String[] args) throws FileNotFoundException, IOException {
        // init
        String inputFile = "task01/day.csv";
        String input;

        Map<String, BikeEntry> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            while((input = br.readLine()) != null) {
                String[] lines = input.split(",");
                BikeEntry bikeEntry = BikeEntry.toBikeEntry(lines);
                
                map.put(br.readLine(), bikeEntry);

            }

            // Find top 5 days with most cyclists
            for (Map.Entry<String, BikeEntry> entry : map.entrySet()) {
                BikeEntry bikeEntry = entry.getValue();
                if (entry.getKey().equals("weekday")) {
                    map.put("weekday", bikeEntry);
                }
            }

            // Print - put in values
            System.out.println("The <position> recorded number of cyclist was in <season>, on a <day> in the month of <month>. There were a total of <total> cyclists. The weather was <weather. <day> was <holiday>.");
            
        }
    }

}
