package module3;

import edu.duke.URLResource;

public class Part4 {
    // Write a program that reads the lines from the file at this URL location,
    //http://www.dukelearntoprogram.com/course2/data/manylinks.html
    //, and prints each URL on the page that is a link to youtube.com. Assume that a link to youtube.com has no spaces in it and would be in the format (where [stuff] represents characters that are not verbatim): “http:[stuff]youtube.com[stuff]”
    URLResource urlResource = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");

    public void printYouTubeLinks() {
        for (String line : urlResource.lines()) {
            String lineLower = line.toLowerCase();
            int youtubeIndex = lineLower.indexOf("youtube.com");
            if (youtubeIndex != -1) {
                int startIndex = line.lastIndexOf("\"", youtubeIndex);
                int stopIndex = line.indexOf("\"", youtubeIndex);
                System.out.println(line.substring(startIndex+1, stopIndex));
        }
    }


//    public void printYoutubeLinks() {
//        for (String line : urlResource.lines()) {
//            String lineLower = line.toLowerCase();
//            int youtubeIndex = lineLower.indexOf("youtube.com");
//            if (youtubeIndex != -1) {
//                int startIndex = line.lastIndexOf("\"", youtubeIndex);
//                int stopIndex = line.indexOf("\"", youtubeIndex);
//                System.out.println(line.substring(startIndex+1, stopIndex));
//            }
//        }
//    }
}
}
