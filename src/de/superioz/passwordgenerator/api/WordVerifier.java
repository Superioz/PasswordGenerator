package de.superioz.passwordgenerator.api;

/**
 * Class created on 08.02.2015
 */
public class WordVerifier {

    // checking if the word is empty
    public static boolean verifyWord(String word){
        return !(word == null || word.isEmpty());
    }

    // replaces ä,ö,ü
    public static String optimizeWord(String word){
        word = word.replaceAll("ä", "ae").replaceAll("ö", "oe").replaceAll("ü", "ue")
                .replaceAll(" ", "");
        return word;
    }


}
