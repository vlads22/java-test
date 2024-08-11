package module2_5;

import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        // the encrypted message, the index the slice should start from, the length of the key
        // sliceString("abcdefghijklm", 0, 3) should return "adgjm"
        ArrayList<Character> characterArrayList = new ArrayList<>();

        char firstCharacter = message.charAt(whichSlice);
        //System.out.println(firstCharacter);
        characterArrayList.add(firstCharacter);

        int currentIndex = whichSlice + totalSlices;

        for (int i=currentIndex; i<message.length(); ){
            char character = message.charAt(i);
            //System.out.println(character);
            characterArrayList.add(character);
            i += totalSlices;
            //currentIndex = currentIndex + totalSlices;
        }

        //System.out.println(characterArrayList);
        StringBuilder characterStringBuilder = new StringBuilder();

        for (char character : characterArrayList){
            characterStringBuilder.append(character);
        }

        String sliceString = characterStringBuilder.toString();
        System.out.println(sliceString);
        //REPLACE WITH YOUR CODE
        return sliceString;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
    }
    
}
