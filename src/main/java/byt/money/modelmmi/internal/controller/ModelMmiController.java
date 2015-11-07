package byt.money.modelmmi.internal.controller;

import byt.money.common.model.Model;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ModelMmiController implements Initializable {

    private static final String AMMOUNT_VALIDATOR = "[0-9]+([,.][0-9]{1,2})?";
    private static final ResourceBundle I18N = ResourceBundle.getBundle("i18n/i18n");
    
    public void update(Model model){
        categoryComboBox.setValue(model.getCategory());
        ammountField.setText(String.valueOf(model.getAmount()));
        nameField.setText(model.getName());
        detailsField.setText(model.getDetails());
        datePicker.setValue(model.getDate());
    }

    @FXML
    private Label messageLabel;
    @FXML
    private ComboBox categoryComboBox;
    @FXML
    private TextField ammountField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField detailsField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button acceptButton;

    @FXML
    private void acceptButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }

    @FXML
    private void validateAmmount(Event event) {
        boolean valid = ammountField.getText().matches(AMMOUNT_VALIDATOR);
        acceptButton.setDisable(!valid);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setCategories();
        update(new Model("Inflow", "Wypłata", 5000, LocalDate.now(), "Premia"));
        localize();
    }
    
    public void setCategories(){
        //czytać z DB docelowo
        ObservableList<String> categories
                = FXCollections.observableArrayList(
                        "Inflow",
                        "Expense",
                        "Deposit"
                );
        categoryComboBox.setItems(categories);
    }
    
    private void localize(){
        categoryLabel.setText(I18N.getString("categoryLabel"));
        ammountLabel.setText(I18N.getString("ammountLabel"));
        nameLabel.setText(I18N.getString("nameLabel"));
        detailsLabel.setText(I18N.getString("detailsLabel"));
        dateLabel.setText(I18N.getString("dateLabel"));
        acceptButton.setText(I18N.getString("acceptButton"));
    }
    
    @FXML
    private Label categoryLabel;
    @FXML
    private Label ammountLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label detailsLabel;
    @FXML
    private Label dateLabel;
    
}
