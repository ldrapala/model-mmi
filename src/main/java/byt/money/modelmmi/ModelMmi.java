package byt.money.modelmmi;

import byt.money.common.service.IStartStop;
import byt.money.common.bar.IWorkingPanel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ModelMmi implements IStartStop, IWorkingPanel {

    private static final Logger LOGGER = Logger.getLogger(ModelMmi.class.getName());

    private GridPane root;
    private Button button;

    public ModelMmi() {
        start();
    }

    @Override
    public void start() {
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/ModelMmi.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            button = new Button();
            Image image = new Image(getClass().getResourceAsStream("/icons/add.png"));
            button.setGraphic(new ImageView(image));
        } catch (IOException ex) {
            LOGGER.log(Level.INFO, "Exception during activate adding-mmi ", ex);
        }
    }

    @Override
    public GridPane getScene() {
        return root;
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
