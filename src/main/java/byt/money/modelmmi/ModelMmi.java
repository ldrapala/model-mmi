package byt.money.modelmmi;

import byt.money.common.service.IStartStop;
import byt.money.common.leftbar.IWorkingPanel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class ModelMmi implements IStartStop, IWorkingPanel {

    private static final Logger LOGGER = Logger.getLogger(ModelMmi.class.getName());

    private Scene scene;
    private Button button;

    @Override
    public void start() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ModelMmi.fxml"));
            scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            button = new Button("ADD");
        } catch (IOException ex) {
            LOGGER.log(Level.INFO, "Exception during activate adding-mmi ", ex);
        }
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public String getName() {
        return "Adding";
    }

    @Override
    public Button getButton() {
        return button;
    }

    @Override
    public void stop() {
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
