package de.superioz.passwordgenerator;

import de.superioz.passwordgenerator.scenes.ContentController;
import de.superioz.passwordgenerator.scenes.RootController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

/**
 * Dont wonder, why i'm using german text in my application:
 * I use german words, because my friends, parents etc should understand
 * everything. Dont be afraid to use methods from my program, if you wish..
 */
public class Main extends Application {

    // variables
    private static Stage stage;
    private BorderPane rootPane;
    private String title = "PasswordGenerator";

    @Override
    public void start(Stage stage) throws Exception{
        // setting stage and init main attributes
        this.setStage(stage);
        stage.setResizable(false);
        stage.setTitle(title);
        stage.centerOnScreen();
        stage.getIcons().add(new Image(
                Main.class.getResource("style/icons/icon.png").toExternalForm()
        ));

        // init root pane
        this.initRoot();
        this.initContent();

        // open window
        stage.show();
    }

    // init root scene
    public void initRoot(){
        try{
            // loading fxml file of root
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("scenes/root.fxml"));
            rootPane = loader.load();

            // giving controller access to main
            RootController rootController = loader.getController();
            rootController.setMain(this);

            // puts the root pane into the scene
            Scene scene = new Scene(rootPane);
            this.addStylesheets(new String[]{"style/style.css"}, scene);
            stage.setScene(scene);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // init inner scene
    public void initContent(){
        try{
            // loading the fxml of the inner scene
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("scenes/content.fxml"));
            AnchorPane contentPane = loader.load();

            // setting scene into the window
            rootPane.setCenter(contentPane);

            // loading the controller and giving access to main
            ContentController controller = loader.getController();
            controller.setMain(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // adding stylesheets
    public void addStylesheets(String[] styleSheets, Scene scene){
        for(String s : styleSheets){
            scene.getStylesheets().add(Main.class.getResource(s).toExternalForm());
        }
    }

    // copies smth to the clipboard
    public static void copyToClipboard(String aString){
        StringSelection stringSelection = new StringSelection(aString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    // main method of application
    public static void main(String[] args) {
        launch(args);
    }

    /*
    getter and setter
     */
    public static Stage getStage(){
        return stage;
    }

    public void setStage(Stage st){
        stage = st;
    }

    public BorderPane getRootPane(){
        return rootPane;
    }

    public void setRootPane(BorderPane rootPane){
        this.rootPane = rootPane;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

}
