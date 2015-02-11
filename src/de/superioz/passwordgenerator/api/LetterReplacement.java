package de.superioz.passwordgenerator.api;

import de.superioz.passwordgenerator.api.enums.ReplacementLevel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Class created on 09.02.2015
 */
public class LetterReplacement {

    /*
     hashmap for all letters plus alternatives
     two or more letters in exchange are bad, so i removed them
      */
    private static HashMap<String, List<String>> exchanges = new HashMap<String, List<String>>() {{
        this.put("a", Arrays.asList("@", "4"));
        this.put("b", Arrays.asList("8"));
        this.put("c", Arrays.asList("(", "{", "[", "<"));
        this.put("d", Arrays.asList(")"));
        this.put("e", Arrays.asList("3", "€"));
        // no 'f' because of bad exchange
        this.put("g", Arrays.asList("6", "&"));
        this.put("h", Arrays.asList("4"));
        this.put("i", Arrays.asList("1", "!"));
        // no 'j' because of bad exchange
        // no 'k' because of bad exchange
        this.put("l", Arrays.asList("£"));
        // no 'm' because of bad exchange
        // no 'n' because of bad exchange
        this.put("o", Arrays.asList("0", "#"));
        // no 'p' because of bad exchange
        // no 'q' because of bad exchange
        this.put("r", Arrays.asList("?"));
        this.put("s", Arrays.asList("5", "$"));
        this.put("t", Arrays.asList("7"));
        // no 'u' because of bad exchange
        // no 'v' because of bad exchange
        // no 'w' because of bad exchange
        this.put("x", Arrays.asList("%"));
        this.put("y", Arrays.asList("¥"));
        this.put("z", Arrays.asList("2"));
    }};

    /*
     replace letters with exchanges from leetspeak
     iterate through the hashmap and choose the certain character
      */
    public static String replaceLetters(String word, ReplacementLevel level){
        // variables
        StringBuilder stringBuilder = new StringBuilder(word);
        int replaceable = countReplaceableItems(word);
        int shouldReplaced = (int) shouldReplacedItems(level, replaceable);

        int counter = 0;

        while(counter != shouldReplaced){
            int index = Randomizer.getRandomInteger(0, word.length() - 1);
            String ch = String.valueOf(word.charAt(index));

            if(isReplaceable(ch.toLowerCase())){
                // can be replaced with leet
                String leet = replaceLetter(ch.toLowerCase());
                stringBuilder.setCharAt(index, leet.charAt(0));
                word = stringBuilder.toString();
                counter++;
            }
        }

        return stringBuilder.toString();
    }

    /*
    count letters in a word, which can be replaced
     */
    private static int countReplaceableItems(String word){
        int counter = 0;

        // iterate through hashmap
        for(String s : exchanges.keySet()){
            if(word.contains(s) || word.contains(s.toUpperCase())){
                counter += countCharsIn(word, s.charAt(0));
                counter += countCharsIn(word, s.toUpperCase().charAt(0));
            }
        }

        return counter;
    }

    /*
    returns the value of words, that must be replaced.
    needed is the replacement level and the length of the word
     */
    public static double shouldReplacedItems(ReplacementLevel level, double replaceableLength){
        double value = 0;

        if(level == ReplacementLevel.FULL_WORD)
            value = replaceableLength;
        else if(level == ReplacementLevel.THREE_FOURTH_WORD)
            value = (replaceableLength / 100) * 75;
        else if(level == ReplacementLevel.HALF_WORD)
            value = replaceableLength / 2;
        else if(level == ReplacementLevel.ONE_FOURTH_WORD)
            value = (replaceableLength / 100) * 25;

        return value;
    }

    /*
    checks, if the given char is replaceable with leetspeak
     */
    private static boolean isReplaceable(String ch){
        return exchanges.keySet().contains(ch);
    }

    /*
    replaces a letter with the certain leet
     */
    private static String replaceLetter(String letter){
        if(isReplaceable(letter))
            return Randomizer.getRandomItem(exchanges.get(letter));

        return "-1";
    }

    /*
    count the chars contains in the string
     */
    public static int countCharsIn(String s, char ch){
        int count = 0;

        for(char c : s.toCharArray()){
            if(ch == c){
                count++;
            }
        }

        return count;
    }
}
