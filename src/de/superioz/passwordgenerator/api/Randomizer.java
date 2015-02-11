package de.superioz.passwordgenerator.api;

import de.superioz.passwordgenerator.api.enums.Alphabetic;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Random;

/**
 * Class created on 08.02.2015
 */
public class Randomizer {

    // variables
    public static Random rand = new Random();

    /*
    returns a random boolean, true or false
     */
    public static boolean getRandomBoolean(){
        return rand.nextBoolean();
    }

    /*
    returns an item inside an array
     */
    public static Object getRandomItem(ObservableList observableList){
        int randNum = getRandomInteger(0, observableList.size()-1);
        return observableList.get(randNum);
    }

    /*
    returns an item inside an list
     */
    public static String getRandomItem(List<String> stringList){
        int randNum = getRandomInteger(0, stringList.size()-1);
        return stringList.get(randNum);
    }

    /*
    returns an integer inside the given range
     */
    public static int getRandomInteger(int min, int max){
        return rand.nextInt((max - min) + 1) + min;
    }

    /*
    returns a double inside the given range
     */
    public static double getRandomDouble(double min, double max){
        return rand.nextInt(((int)max - (int)min) + 1) + (int)min;
    }

    /*
    returns a string with random characters from the alphabetic class
     */
    public static String getRandomString(Alphabetic alph, int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(alph.getString().charAt(rand.nextInt(alph.getString().length())));

        return sb.toString();
    }

    /*
    returns a string with random characters from a string
     */
    public static String getRandomString(String s, int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(s.charAt(rand.nextInt(s.length())));

        return sb.toString();
    }

    /*
    returns the random object of this class
     */
    public static Random getRand(){
        return rand;
    }
}
