package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Magic8BallLogic;
import model.MagischeMiesmuschelAnswer;

public class ChatController {
    private Magic8BallLogic magic8BallLogic;

    @FXML
    private TextField questionTextField;

    @FXML
    private TextArea chatlogTextArea;

    @FXML
    void onAskPressed(ActionEvent event) {
        chatlogTextArea.appendText(questionTextField.getText() +"\n");
        questionTextField.clear();

        chatlogTextArea.appendText(magic8BallLogic.getAnswer()+"\n");
    }

    public void setLogic(Magic8BallLogic magic8BallLogic) {
        this.magic8BallLogic=magic8BallLogic;
    }
}
