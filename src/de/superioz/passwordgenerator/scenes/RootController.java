package de.superioz.passwordgenerator.scenes;

import de.superioz.passwordgenerator.api.parent.Controller;
import javafx.fxml.FXML;

/**
 * Class created on 07.02.2015
 */
public class RootController extends Controller {

    /*
    exit program, when exit is pressed
     */
    @FXML
    public void handleClickExit(){
        System.exit(0);
    }


}
