package com.example.w22comp1011gcw10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//http://www.omdbapi.com/
public class Main extends  Application{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
//        launch();
//        ApiResponse apiResponse = APIUtility.getMoviesFromOMDB("Spider Man");
//        System.out.println(apiResponse);

        ApiResponse apiResponse2 = APIUtility.getMoviesFromOMDBQuick("Iron Man");
        System.out.println(apiResponse2);
    }
}

