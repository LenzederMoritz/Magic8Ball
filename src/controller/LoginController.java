/**
 * Sample Skeleton for 'login.fxml' Controller Class
 */

package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Login;
import model.Magic8BallLogic;

import java.io.IOException;

public class LoginController {

    @FXML // fx:id="usernameTextField"
    private TextField usernameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="passwordTextField"
    private PasswordField passwordTextField; // Value injected by FXMLLoader
    private Magic8BallLogic magic8BallLogic;

    @FXML
    void onLoginButton(ActionEvent event) {

        if(usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()){

            Alert alert = new Alert(Alert.AlertType.WARNING, "Username and Password has to be specified!");
            alert.showAndWait();
        }
        else{
            //generiere Login aus Usereingabe
            Login l = new Login(usernameTextField.getText(), passwordTextField.getText());
            //TODO: Login an Logik schicken
            try {
                magic8BallLogic.onLogin(l);
            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Something bad happend, Goodbye!");
                alert.showAndWait();
                Platform.exit();
            }
        }
    }

    //setzt Referenz auf die "Anwendungsllogik"
    public void setLogic(Magic8BallLogic magic8BallLogic) {
        this.magic8BallLogic=magic8BallLogic;
    }
    
    public void onLoginFailed(){
        Alert alert = new Alert(Alert.AlertType.WARNING, "Username or Password is incorrect!");
        alert.showAndWait();

        usernameTextField.clear();
        passwordTextField.clear();
    }

}
