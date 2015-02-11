package de.superioz.passwordgenerator.api.management;

import de.superioz.passwordgenerator.api.ContentConverter;
import de.superioz.passwordgenerator.api.Randomizer;
import de.superioz.passwordgenerator.api.parent.PasswordSettings;
import de.superioz.passwordgenerator.scenes.ContentController;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;

/**
 * Class created on 08.02.2015
 */
public class SettingsManager {

    /*
    resets all settings
     */
    public static void resetSettings(ContentController controller){
        // own word
        controller.getWithWord().setSelected(false);
        controller.getWord().setDisable(true);
        controller.getWord().setText("");

        // checkboxes of word generator
        for(CheckBox box : controller.getCheckBoxes()){
            box.setDisable(false);
            box.setSelected(false);
        }

        // other settings
        controller.getSwirlLetters().setSelected(false);
        controller.getReverseWord().setSelected(false);

        // Letter Replacement
        controller.getLetterReplacement().setSelected(false);
        Slider letterReplacementLevel = controller.getLetterReplacementLevel();
            letterReplacementLevel.setValue(1.0);
            letterReplacementLevel.setDisable(true);

        // number of characters
        controller.getNumberCharacters().setText("");
    }


    /*
    setting the settings random
     */
    public static void randomizeSettings(ContentController controller){
        // content converter
        ContentConverter contentConverter = new ContentConverter(controller);

        // resets all settings for better randomizing
        resetSettings(controller);

        // checkboxen of word generating
        for(CheckBox box : controller.getCheckBoxes()){
            box.setSelected(Randomizer.getRandomBoolean());
        }
        // check settings
        SettingsManager.checkRandomWordGeneratingSettings(contentConverter.getFirstLetterSettings(),
                contentConverter.getMiddleLetterSettings(), contentConverter.getLastLetterSettings());

        // other settings
        controller.getSwirlLetters().setSelected(Randomizer.getRandomBoolean());
        controller.getReverseWord().setSelected(Randomizer.getRandomBoolean());

        /*
        Letter Replacement
          */
        boolean replaceLetters = Randomizer.getRandomBoolean();
        controller.getLetterReplacement().setSelected(replaceLetters);

        if(replaceLetters){
            // setting a random value of slider
            Slider choiceSlider = controller.getLetterReplacementLevel();
            choiceSlider.setDisable(false);
            choiceSlider.setValue(Randomizer.getRandomDouble(
                    choiceSlider.getMin(), choiceSlider.getMax()
            ));
        }

        // number of characters
        int value = Randomizer.getRandomInteger(0, 25);
        controller.getNumberCharacters().setText(value+"");

    }

    // Checks if the word generator settings are empty
    public static boolean areGenerateWortSettingsEmpty(PasswordSettings settings){
        boolean[] firstLetter = settings.getFirstLetter();
        boolean[] middleLetters = settings.getMiddleLetters();
        boolean[] lastLetter = settings.getLastLetter();

        if(!firstLetter[0] && !firstLetter[1] && !firstLetter[2])
            return false;
        else if(!middleLetters[0] && !middleLetters[1] && !middleLetters[2])
            return false;
        else if(!lastLetter[0] && !lastLetter[1] && !lastLetter[2])
            return false;

        return true;
    }

    // checks if every row is minimum one ticked
    public static void checkRandomWordGeneratingSettings(boolean[] firstLetter
            , boolean[] middleLetters, boolean[] lastLetter){

        if(!firstLetter[0] && !firstLetter[1] && !firstLetter[2]){
            firstLetter[Randomizer.getRandomInteger(0, firstLetter.length)] = true;
        }

        if(!middleLetters[0] && !middleLetters[1] && !middleLetters[2]){
            middleLetters[Randomizer.getRandomInteger(0, middleLetters.length)] = true;
        }

        if(!lastLetter[0] && !lastLetter[1] && !lastLetter[2]){
            lastLetter[Randomizer.getRandomInteger(0, lastLetter.length)] = true;
        }
    }


}
