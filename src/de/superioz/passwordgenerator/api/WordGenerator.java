package de.superioz.passwordgenerator.api;

/**
 * Class created on 09.02.2015
 */
public class WordGenerator {

    public static String generateWord(String[] alphabetics, int len){
        StringBuilder sb = new StringBuilder();

        // random strings
        String firstLetter = Randomizer.getRandomString(alphabetics[0], 1);
        String middleLetters = Randomizer.getRandomString(alphabetics[1], (len-2));
        String lastletter = Randomizer.getRandomString(alphabetics[2], 1);
        String[] letters = new String[]{firstLetter, middleLetters, lastletter};

        for(String s : letters)
            sb.append(s);

        return sb.toString();
    }

}
