package module4;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.*;

import java.io.File;

public class CSVMax {

    public CSVRecord coldestHourInFile (CSVParser parser){
       CSVRecord rowWithColdestTemp = null;

       for(CSVRecord currentRow : parser){
           if (rowWithColdestTemp == null){
               rowWithColdestTemp = currentRow;
           }
           else {
               double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
               double coldestTemp = Double.parseDouble(rowWithColdestTemp.get("TemperatureF"));

               if (currentTemp == -9999 ) {
                   continue;
               }

               if (currentTemp < coldestTemp) {
                   rowWithColdestTemp = currentRow;
               }
           }
       }

       return rowWithColdestTemp;
    }

    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord rowWithColdestTemp = coldestHourInFile(parser);
        String timeOfColdestHour = rowWithColdestTemp.get("TimeEST");
        String coldestTemp = rowWithColdestTemp.get("TemperatureF");
        System.out.println("timeOfColdestHour: " + timeOfColdestHour);
        System.out.println("coldestTemp: " + coldestTemp);
    }

    public String fileWithColdestTemperature(){
        String fileWithColdestTemperature = "";
        CSVRecord rowWithColdestTemp = null;
        DirectoryResource dr = new DirectoryResource();

        for (File f: dr.selectedFiles()) {
            FileResource file = new FileResource(f);
            CSVParser parser = file.getCSVParser();
            String fileName = file.getName();
            // get coldest temp from this file
            CSVRecord rowWithColdestTempCurrent = coldestHourInFile(parser);

            if (rowWithColdestTemp == null) {
                rowWithColdestTemp = rowWithColdestTempCurrent;
                fileWithColdestTemperature = fileName;
            } else {
                double currentTemp = Double.parseDouble(rowWithColdestTempCurrent.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(rowWithColdestTemp.get("TemperatureF"));
                if (currentTemp < coldestTemp) {
                    rowWithColdestTemp = rowWithColdestTempCurrent;
                    fileWithColdestTemperature = fileName;
                }
            }
        }
        System.out.println("Coldest day was in file " + fileWithColdestTemperature);
        System.out.println("Coldest temperature on that day was: " + );
        return fileWithColdestTemperature;
    }


    public void testFileWithColdestTemperature() {
        fileWithColdestTemperature();
    }




    public CSVRecord hottestHourInFile(CSVParser parser) {
        CSVRecord largestSoFar = null;
        for (CSVRecord currentRow : parser) {
            largestSoFar = getlargestOfTwo(currentRow, largestSoFar);
        }
        return largestSoFar;
    }

    public void testHottestDay() {
        FileResource fr = new FileResource();
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("hottest temp was: " + largest + "at " + largest.get("TimeEST"));
    }

    public CSVRecord hottestDayInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();

        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);

            // use hottestHourInFile method to get hottest hour in file
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
                largestSoFar = getlargestOfTwo(currentRow, largestSoFar);
        }

        return largestSoFar;
    }

    public CSVRecord getlargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar) {
        if (largestSoFar == null) {
            largestSoFar = currentRow;
        }
        else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if (currentTemp > largestTemp) {
                largestSoFar = currentRow;
            }
        }
        return largestSoFar;
    }

    public void testHottestInManyDays() {
        CSVRecord largest = hottestDayInManyDays();
        System.out.println("hottest temp was " + largest + " at day" + largest.get("DateUTC"));
}

}
