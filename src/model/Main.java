package model;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        new Magic8BallLogic(primaryStage).showLogin();

    }


    public static void main(String[] args) {
        launch(args);
    }


}
