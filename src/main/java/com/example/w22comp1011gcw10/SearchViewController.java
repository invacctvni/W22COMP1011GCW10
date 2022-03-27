package com.example.w22comp1011gcw10;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private ImageView imageView;

    @FXML
    private ListView<Movie> resultListView;

    @FXML
    private TextField searchTextField;

    @FXML
    private void searchMovies()
    {
        ApiResponse apiResponse = APIUtility.getMoviesFromOMDBQuick(searchTextField.getText());
        resultListView.getItems().addAll(apiResponse.getSearch());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resultListView.getSelectionModel().selectedItemProperty().addListener((obs,oldMovieSelected,newMovieSelected) ->
        {
            try{
                imageView.setImage(new Image(newMovieSelected.getPoster()));
            }
            catch (IllegalArgumentException e) {
                imageView.setImage(new Image("https://trailerfailure.com/img/images/missingCoverPhoto.jpg"));
            }

        });
    }
}
