package model;

import controller.ChatController;
import controller.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Magic8BallLogic {
    private Stage stage;
    private LoginController loginController;
    private ChatController chatController;
    private Answerable answer;

    //nur für Testzwecke statisch -> gehört in Datei und gehasht!
    private final Login[] LOGINS ={
      new Login("hansi", "ist_GEIL"),
      new Login("IvanJelica","Miriana_Oranga"),
      new Login("NemanjaJa","Voiletta_Lecker_Schmecker")
    };


    public Magic8BallLogic(Stage stage) {
        //z.B. lies Usernames/passwörter aus file ein
        this.stage = stage;

        answer = new Magic8BallAnswer();
    }

    public void showLogin() throws Exception{
        //load FXML
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/login.fxml"));

        //load root node, e.g. Anchor Pane
        Parent root =loader.load();

        //get LoginController reference
        loginController=loader.getController();

        //give logincontroller reference to logic
        loginController.setLogic(this);
        stage.setTitle("LOGIN");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();

    }

    public void showChat() throws IOException {
        //TODO: load+show Chatcontroller

        //load FXML
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/chat.fxml"));

        //load root node, e.g. Anchor Pane
        Parent root =loader.load();

        //get LoginController reference
        chatController=loader.getController();

        //give logincontroller reference to logic
        chatController.setLogic(this);
        stage.setTitle("Chat");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();

    }

    public void onLogin(Login l) throws IOException {
        boolean passwordCorrect = false;
        int i=0;

        while (!passwordCorrect && i<LOGINS.length){
            passwordCorrect=LOGINS[i].equals(l);
            i++;
        }

        if(passwordCorrect){
            showChat();

        }
        else { //Zeige Fehler an --> flascher User/Passwort
            loginController.onLoginFailed();
        }
    }

    public String getAnswer() {
        return answer.getAnswer();
    }
}
