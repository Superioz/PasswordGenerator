package de.superioz.passwordgenerator.api.enums;

/**
 * Class created on 09.02.2015
 */
public enum Alphabetic {

    NUMBERS("0123456789"),
    LOWER_CASE("abcdefghijklmnopqrstuvwqxyz"),
    UPPER_CASE("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    public String s;

    Alphabetic(String s){
        this.s = s;
    }

    public String getString(){
        return s;
    }

    /*
    Returns a string from boolean array,
    to see if numbers etc should be inside
     */
    public static String getAlphabeticWith(boolean[] generatorSettings){
        StringBuilder sb = new StringBuilder();

        if(generatorSettings[0])
            sb.append(LOWER_CASE.getString());
        if(generatorSettings[1])
            sb.append(UPPER_CASE.getString());
        if(generatorSettings[2])
            sb.append(NUMBERS.getString());

        return sb.toString();
    }

}
