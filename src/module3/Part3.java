package module3;

public class Part3 {
    public boolean twoOccurences(String stringA, String stringB) {
        // call twoOccurrences(“by”, “A story by Abby Long”) returns true as there are two occurrences of “by”,
        int firstOccurence = stringB.indexOf(stringA);
        if (firstOccurence == -1) {
            return false;
        }
        int secondOccurence = stringB.indexOf(stringA, firstOccurence + stringA.length());
        if (secondOccurence == -1) {
            return false;
        }
        return true;
    }

    public void testing() {
        String stringA = "by";
        String stringB = "A story by Abby Long";
        System.out.println("String A: " + stringA);
        System.out.println("String B: " + stringB);
        System.out.println("Two occurrences of string A in string B: " + twoOccurences(stringA, stringB));

        stringA = "a";
        stringB = "banana";
        System.out.println("String A: " + stringA);
        System.out.println("String B: " + stringB);
        System.out.println("Two occurrences of string A in string B: " + twoOccurences(stringA, stringB));

        stringA = "atg";
        stringB = "ctgtatgta";
        System.out.println("String A: " + stringA);
        System.out.println("String B: " + stringB);
        System.out.println("Two occurrences of string A in string B: " + twoOccurences(stringA, stringB));
    }

    public String lastPart(String stringA, String stringB) {
        // example, the call lastPart(“an”, “banana”) returns the string “ana”, the part of the string after the first “an”. The call lastPart(“zoo”, “forest”) returns the string “forest” since “zoo” does not appear in that word.
        int indexOfFirstOccurence = stringB.indexOf(stringA);
        if (indexOfFirstOccurence == -1) {
            return "";
        }
        String resultString = stringB.substring(indexOfFirstOccurence + stringA.length());
        return resultString;
    }

    public void testLastPart() {
        String stringA = "an";
        String stringB = "banana";
        System.out.println("String A: " + stringA);
        System.out.println("String B: " + stringB);
        System.out.println("Last part of string B after string A: " + lastPart(stringA, stringB));

        stringA = "zoo";
        stringB = "forest";
        System.out.println("String A: " + stringA);
        System.out.println("String B: " + stringB);
        System.out.println("Last part of string B after string A: " + lastPart(stringA, stringB));
    }
}
