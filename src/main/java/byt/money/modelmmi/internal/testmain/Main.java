package byt.money.modelmmi.internal.testmain;

import byt.money.modelmmi.ModelMmi;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Lukasz
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ModelMmi addingMmi = new ModelMmi();
        addingMmi.start();
        primaryStage.setTitle(addingMmi.getName());
        primaryStage.setScene(addingMmi.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
