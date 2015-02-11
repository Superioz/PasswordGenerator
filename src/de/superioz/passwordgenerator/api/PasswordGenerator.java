package de.superioz.passwordgenerator.api;

import de.superioz.passwordgenerator.api.enums.Alphabetic;
import de.superioz.passwordgenerator.api.enums.ReplacementLevel;
import de.superioz.passwordgenerator.api.management.DialogManager;
import de.superioz.passwordgenerator.api.management.SettingsManager;
import de.superioz.passwordgenerator.api.parent.Password;
import de.superioz.passwordgenerator.api.parent.PasswordSettings;
import de.superioz.passwordgenerator.scenes.ContentController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class created on 08.02.2015
 */
public class PasswordGenerator {

    // variables
    private PasswordSettings settings;
    private ContentController controller;

    public PasswordGenerator(ContentController contentController){
        settings = new ContentConverter(contentController).convertToSettings();
        controller = contentController;
    }

    /*
    generate password
     */
    public Password generatePassword(){
        Password password = new Password("-1");

        // checks if a word is given or not
        if(settings.isWithWord()){
            // he puts a word into the textfield
            String word = settings.getWord();

            // verifies the word
            if(!WordVerifier.verifyWord(word)){
                DialogManager.showError("Inkorrekte Eingabe!"
                        , "Das Textfeld darf bei Benutzung nicht leer bleiben!" +
                        " Bitte überprüfe deine Angabe und versuche es erneut.");
                return null;
            }

            // word isnt empty
            word = WordVerifier.optimizeWord(word);
            password.setPassword(word);
        }else{
            // Checks if generate word checkboxes are empty
            if(!SettingsManager.areGenerateWortSettingsEmpty(settings)){
                DialogManager.showError("Inkorrekte Einstellungen!"
                        , "Die Wort-Generator-Einstellungen dürfen nicht leer bleiben, wenn ein Wort generiert werden soll!" +
                        "\nBitte überprüfe deine Eingabe und versuche es erneut!");
                return null;
            }

            // generate a random word
            String word = generateWord();
            password.setPassword(word);
        }

        // setting other settings
        if(settings.isSwirlLetters())
            password.setPassword(swirlLetters(password.getPassword()));

        if(settings.isReverseWord())
            password.setPassword(reverseWord(password.getPassword()));

        // letter replacement
        if(settings.isLetterReplacement())
            password.setPassword(LetterReplacement.replaceLetters(password.getPassword(),
                    ReplacementLevel.getByValue((int)settings.getLetterReplacementLevel())));

        return password;
    }

    /*
    generates a random word with the controller settings
     */
    public String generateWord(){
        int value = (int) settings.getNumberCharacters();
        boolean[] firstLetter = settings.getFirstLetter();
        boolean[] middleLetters = settings.getMiddleLetters();
        boolean[] lastLetter = settings.getLastLetter();

        // strings
        String alphabeticFirst = Alphabetic.getAlphabeticWith(firstLetter);
        String alphabeticMiddle = Alphabetic.getAlphabeticWith(middleLetters);
        String alphabeticLast = Alphabetic.getAlphabeticWith(lastLetter);
        String[] alphabetics = new String[]{alphabeticFirst, alphabeticMiddle, alphabeticLast};

        return WordGenerator.generateWord(alphabetics, value);
    }

    /*
    swirls all letters to other locations
     */
    public String swirlLetters(String word){
        StringBuilder sb = new StringBuilder();

        // create a list to use the shuffle method
        List<Character> characters = new ArrayList<>();

        // setting all characters of word to the list
        for(int i = 0; i < word.length(); i++){
            characters.add(word.charAt(i));
        }

        // shuffle and adds chars to sb with forEach
        Collections.shuffle(characters);
        characters.forEach(sb::append);

        return sb.toString();
    }

    /*
    reverse the word
     */
    public String reverseWord(String word){
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }


}
