package module4;

import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {

    public void listExporters(CSVParser parser, String exportOfInterest) {
        for(CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportOfInterest)) {
                String country = record.get("Country");
                System.out.println(country);

            }
        }
    }

    public void whoExportsCofee() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
    }

    public String countryInfo(CSVParser parser, String country) {

        boolean countryFound = false;
        String exports = "";
        String value = "";

        for(CSVRecord record : parser) {
            String countryName = record.get("Country");
            if (countryName.contains(country)){
                exports = record.get("Exports");
                value = record.get("Value (dollars)");
                countryFound = true;
            }
        }
        if (countryFound = true) {
            return country + ": " + exports + ": " + value;
        }
        else {
            return "NOT FOUND";
        }
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for(CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem) {
        int numberOfExporters = 0;
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem)) {
                numberOfExporters = numberOfExporters + 1;
            }
        }
        return numberOfExporters;
    }

    public void bigExporters(CSVParser parser, String amount){
        for (CSVRecord record : parser) {
            String exportValue = record.get("Value (dollars)");
            if (exportValue.length() > amount.length()) {
                String countryName = record.get("Country");
                System.out.println(countryName + " " + exportValue);
            }
        }
    }

    public void tester() {
        // three column headers labeled Country, Exports, and Value (dollars)
        FileResource fr = new FileResource();

//        CSVParser parser = fr.getCSVParser();
//        countryInfo(parser, "Nauru");

//        CSVParser parser2 = fr.getCSVParser();
//        listExportersTwoProducts(parser2, "gold", "diamonds");

        CSVParser parser3 = fr.getCSVParser();
        numberOfExporters(parser3, "gold");
//
//        CSVParser parser4 = fr.getCSVParser();
//        bigExporters(parser4, "$400,000,000");

    }
}
