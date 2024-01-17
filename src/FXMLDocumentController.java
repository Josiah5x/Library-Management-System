/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 *
 * @author MarcoMan
 *         Channel: https://www.youtube.com/channel/UCPgcmw0LXToDn49akUEJBkQ
 *         Please support our channel (SUBSCRIBE --> TURN ON NOTIFICATION -->
 *         HIT THE LIKE BUTTON)
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField admin;

    @FXML
    private PasswordField password;

    @FXML
    private Button login_Btn;

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    // DATABASE TOOLS, DON'T FORGET TO ADD THE JAR FILE!!
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private double x = 0;
    private double y = 0;

    String Uname = "admin";
    String pass = "admin";

    public void login() {



        try {

            String Username = admin.getText();
            String passwords = password.getText();
            Alert alert;
            if (admin.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields.");
                alert.showAndWait();

            } else {
                if (Username.equals(Uname) && passwords.equals(pass)) {

                        getData.studentNumber = admin.getText().toUpperCase();
                        // DON'T FORGET THIS!!!!
                        // getData.path = result.getString("image");

                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Admin Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Login!");
                        alert.showAndWait();
                        // TO HIDE THE LOGIN FORM
                        login_Btn.getScene().getWindow().hide();
                        // FOR DASHBOARD
                        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        root.setOnMousePressed((MouseEvent event) -> {
                            x = event.getSceneX();
                            y = event.getSceneY();
                        });
                        root.setOnMouseDragged((MouseEvent event) -> {
                            stage.setX(event.getScreenX() - x);
                            stage.setY(event.getScreenY() - y);
                        });
                        stage.initStyle(StageStyle.TRANSPARENT);
                        stage.setScene(scene);
                        stage.show();

                    } else {
                        alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Admin Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Wrong Username or Password.");
                        alert.showAndWait();
                    }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // ONLY NUMBERS ALLOWED
    public void numbersOnly(KeyEvent event) {

        if (event.getCharacter().matches("[^\\e\t\r\\d+$]")) {
            event.consume();

            admin.setStyle("-fx-border-color:#e04040");
        } else {
            admin.setStyle("-fx-border-color:#fff");
        }

    }

    // LET'S PROCEED TO DASHBOARD :)

    @FXML
    public void minimize() {
        Stage stage = (Stage) minimize.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void exit() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
