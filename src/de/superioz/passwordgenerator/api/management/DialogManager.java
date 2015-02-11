package de.superioz.passwordgenerator.api.management;

import de.superioz.passwordgenerator.Main;
import javafx.scene.control.Alert;

/**
 * Class created on 07.02.2015
 */
public class DialogManager {

    public static void showError(String headerText, String contentText){
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Programm Fehler");
        dialog.setHeaderText(headerText);
        dialog.setContentText(contentText);

        dialog.show();
    }

    public static void showInfo(String headerText, String contentText){
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.initOwner(Main.getStage());
        dialog.setTitle("Programm Information");
        dialog.setHeaderText(headerText);
        dialog.setContentText(contentText);

        dialog.show();
    }

}
