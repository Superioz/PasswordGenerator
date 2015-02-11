package de.superioz.passwordgenerator.api;

import de.superioz.passwordgenerator.api.parent.PasswordSettings;
import de.superioz.passwordgenerator.scenes.ContentController;

/**
 * Class created on 08.02.2015
 */
public class ContentConverter {

    private ContentController controller;

    public ContentConverter(ContentController controller){
        this.controller = controller;
    }

    /*
    using all settings - returns a settings object
     */
    public PasswordSettings convertToSettings(){
        boolean withWord = controller.getWithWord().isSelected();
        String word = "";

        // getting word of textfield
        if(withWord)
            word = controller.getWord().getText();

        // self-generated word variables
        boolean[] firstLetter = getFirstLetterSettings();
        boolean[] middleLetters = getMiddleLetterSettings();
        boolean[] lastLetter = getLastLetterSettings();

        // other settings
        boolean swirlLetters = controller.getSwirlLetters().isSelected();
        boolean reverseWord = controller.getReverseWord().isSelected();

        // letter replacement
        boolean letterReplacement = controller.getLetterReplacement().isSelected();
        double letterReplacementLevel = -1;
        Object letterReplacementChoice = "";

        // value of choicebox
        if(letterReplacement)
            letterReplacementLevel = controller.getLetterReplacementLevel().getValue();

        // number of characters
        double numberCharacter = getNumberCharacter();
        if(numberCharacter <= 3)
            numberCharacter = 6;

        return new PasswordSettings(
                withWord, word, firstLetter, middleLetters
                , lastLetter, swirlLetters, reverseWord, letterReplacement,
                letterReplacementChoice, letterReplacementLevel,
                numberCharacter
        );
    }

    /*
    returns a boolean array of first letter setting
     */
    public boolean[] getFirstLetterSettings(){
        return new boolean[]{
                controller.getFirstLetter01().isSelected(),
                controller.getFirstLetter02().isSelected(),
                controller.getFirstLetter03().isSelected()
        };
    }

    /*
    returns a boolean array of the middle of the word settings
     */
    public boolean[] getMiddleLetterSettings(){
        return new boolean[]{
                controller.getMiddleLetters01().isSelected(),
                controller.getMiddleLetters02().isSelected(),
                controller.getMiddleLetters03().isSelected()
        };
    }

    /*
    returns a boolean array of last letter settings
     */
    public boolean[] getLastLetterSettings(){
        return new boolean[]{
                controller.getLastLetter01().isSelected(),
                controller.getLastLetter02().isSelected(),
                controller.getLastLetter03().isSelected()
        };
    }

    /*
    returns the number of characters
     */
    public double getNumberCharacter(){
        double numberCharacter = -1;

        try{
            numberCharacter = Double.parseDouble(controller.getNumberCharacters().getText());
        }catch(NumberFormatException ignored){}

        return numberCharacter;
    }


}
