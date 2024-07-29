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
        for(CSVRecord record : parser) {
            String countryName = record.get"
        }
    }



    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser);

        CSVParser parser = fr.getCSVParser();


        CSVParser parser = fr.getCSVParser();



    }
}
