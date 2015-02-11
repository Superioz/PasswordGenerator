package de.superioz.passwordgenerator.scenes;

import de.superioz.passwordgenerator.Main;
import de.superioz.passwordgenerator.api.PasswordGenerator;
import de.superioz.passwordgenerator.api.management.SettingsManager;
import de.superioz.passwordgenerator.api.parent.Controller;
import de.superioz.passwordgenerator.api.parent.Password;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.util.Pair;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class created on 07.02.2015
 */
public class ContentController extends Controller implements Initializable {

    //============================================= FXML variables =====================================
    @FXML
    private CheckBox withWord;
    @FXML
    private TextField word;

    @FXML
    private CheckBox firstLetter01;
    @FXML
    private CheckBox firstLetter02;
    @FXML
    private CheckBox firstLetter03;

    @FXML
    private CheckBox middleLetters01;
    @FXML
    private CheckBox middleLetters02;
    @FXML
    private CheckBox middleLetters03;

    @FXML
    private CheckBox lastLetter01;
    @FXML
    private CheckBox lastLetter02;
    @FXML
    private CheckBox lastLetter03;

    @FXML
    private CheckBox swirlLetters;
    @FXML
    private CheckBox reverseWord;

    @FXML
    private CheckBox letterReplacement;
    @FXML
    private Slider letterReplacementLevel;

    @FXML
    private TextField numberCharacters;

    @FXML
    private Button randomSettings;
    @FXML
    private Button generatePassword;
    @FXML
    private Button resetSettings;
    //============================================= FXML variables =====================================

    // variables
    private CheckBox[] checkBoxes;


    // init
    @Override
    public void initialize(URL location, ResourceBundle resources){
        // adding checkboxes to array
        checkBoxes = new CheckBox[]{
                firstLetter01, firstLetter02, firstLetter03,
                middleLetters01, middleLetters02, middleLetters03,
                lastLetter01, lastLetter02, lastLetter03
        };
    }


    /*
    action, when checkbox of textfield is selected
     */
    @FXML
    public void handleWordTextfieldActive(){
        boolean marked = withWord.isSelected();

        // Setze Textfeld aktiv/nicht aktiv
        word.setDisable(!marked);

        // Setze alle Textfelder (ohne Wort) aktiv/nicht aktiv
        for(CheckBox checkBox : checkBoxes){
            checkBox.setDisable(marked);
        }
    }

    /*
    action, when checkbox of letter replacement is selected
     */
    @FXML
    public void handleLetterReplacementActive(){
        boolean marked = letterReplacement.isSelected();
        letterReplacementLevel.setDisable(!marked);
    }

    /*
    action, if reset button is pressed
     */
    @FXML
    public void handleClickResetSettings(){
        // Resette alle Settings
        SettingsManager.resetSettings(this);
    }

    /*
    action, when randomized settings is pressed
     */
    @FXML
    public void handleClickRandomizeSettings(){
        // Randomize alle Settings
        SettingsManager.randomizeSettings(this);
    }

    /*
    generate password
     */
    @FXML
    public void handleClickGeneratePassword(){
        // generate the password
        Password password = new PasswordGenerator(this).generatePassword();
        String passwordString = password.getPassword();

        // show custom dialog
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Dein Passwort");
        dialog.setHeaderText("Dein Passwort lautet:");
        dialog.setGraphic(new ImageView(
                Main.class.getResource("style/icons/password.png").toExternalForm()));
        dialog.setContentText(passwordString);

        // buttons
        ButtonType okayButtonType = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
        ButtonType copyButtonType = new ButtonType("Kopieren", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okayButtonType, copyButtonType, ButtonType.CANCEL);

        // functions
        Node copyButton = dialog.getDialogPane().lookupButton(copyButtonType);
        copyButton.setOnMousePressed(event -> Main.copyToClipboard(passwordString));

        // show
        dialog.showAndWait();
    }


    public CheckBox getFirstLetter01(){
        return firstLetter01;
    }

    public CheckBox getFirstLetter02(){
        return firstLetter02;
    }

    public CheckBox getFirstLetter03(){
        return firstLetter03;
    }

    public Button getGeneratePassword(){
        return generatePassword;
    }

    public CheckBox getLastLetter01(){
        return lastLetter01;
    }

    public CheckBox getLastLetter02(){
        return lastLetter02;
    }

    public CheckBox getLastLetter03(){
        return lastLetter03;
    }

    public CheckBox getLetterReplacement(){
        return letterReplacement;
    }

    public Slider getLetterReplacementLevel(){
        return letterReplacementLevel;
    }

    public CheckBox getMiddleLetters01(){
        return middleLetters01;
    }

    public CheckBox getMiddleLetters03(){
        return middleLetters03;
    }

    public CheckBox getMiddleLetters02(){
        return middleLetters02;
    }

    public TextField getNumberCharacters(){
        return numberCharacters;
    }

    public Button getResetSettings(){
        return resetSettings;
    }

    public CheckBox getReverseWord(){
        return reverseWord;
    }

    public CheckBox getSwirlLetters(){
        return swirlLetters;
    }

    public Button getRandomSettings(){
        return randomSettings;
    }

    public CheckBox getWithWord(){
        return withWord;
    }

    public TextField getWord(){
        return word;
    }

    public CheckBox[] getCheckBoxes(){
        return checkBoxes;
    }
}
