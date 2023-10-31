import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Stack;

public class Main extends Application {
    private int photoNum = 0;
    // The Quote that will be updated every 10 seconds
    private Label quoteLabel = new Label("Invest with Wisdom, Grow with Purpose");

    // The Button that goes along with the change
    private Button actionButton = new Button("");

    private ImageView imageView = new ImageView();
    StackPane imageContainer = new StackPane();

    @Override
    public void start(Stage stage) throws IOException {

        // To make the menu bar at the top and adds styles
        updateUI();
        MenuBar topBar = new MenuBar();

        Menu logoMenu = new Menu("Berkshire Hathaway");
        logoMenu.setStyle("-fx-text-fill: white; -fx-font-size: 14");

        Menu contactUsMenu = new Menu("Contact Us");
        contactUsMenu.setStyle("-fx-text-fill: white; -fx-font-size: 14");

        // Used to serve as spacing between Two menu items
        Menu emptySpacing = new Menu("      " +
                "                                                " +
                "                                                " +
                "                                                " +
                "                                           ");
        emptySpacing.setStyle("-fx-opacity: 0.0;");
        topBar.getMenus().addAll(logoMenu,emptySpacing, contactUsMenu);
        topBar.setPadding(new Insets(7, 15, 7, 15));


        // Adds shadow effect
        DropShadow shadow = new DropShadow();
        shadow.setRadius(7);
        shadow.setOffsetX(4);
        shadow.setOffsetY(4);
        shadow.setColor(Color.BLACK);
        quoteLabel.setEffect(shadow);
        actionButton.setEffect(shadow);


        // Places text and button in vbox for spacing and alignment
        VBox quoteAndButtonBox = new VBox(quoteLabel, actionButton);
        quoteAndButtonBox.setAlignment(Pos.BOTTOM_LEFT);
        quoteAndButtonBox.setPadding(new Insets(50));
        quoteAndButtonBox.setSpacing(10);

        // The container of the image, button, and quote

        imageContainer.setPrefHeight(800);
        imageContainer.getChildren().addAll( imageView, quoteAndButtonBox);

        // The root vbox with all the elements

        StackPane rootImage = new StackPane();
        rootImage.getChildren().setAll(imageContainer, topBar);
        rootImage.setMaxSize(800,400);
        rootImage.setMinSize(800,400);
        topBar.setStyle("-fx-background-color: rgba(60,60,60, 0.4);");







        VBox rootBox = new VBox(rootImage);
        rootImage.setAlignment(Pos.TOP_CENTER);
        rootBox.setFillWidth(true);



        //Sets the styling for the Quote label
        quoteLabel.setStyle("-fx-text-fill: 'white'; -fx-underline: true; -fx-font-size: 25;  ");

        //Sets the styling for the actionButton
        actionButton.setStyle("-fx-border-width: 2; -fx-border-color: 'white'; -fx-border-radius: 20; -fx-background-radius: 20; -fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-text-fill: 'black'; -fx-background-color: 'white' ;");
        actionButton.borderProperty().set(null);

        // To Change properties when hovering
        actionButton.setOnMouseEntered(event ->{
            actionButton.setStyle("-fx-border-width: 2; -fx-border-color: 'black'; -fx-border-radius: 20; -fx-background-radius: 20; -fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-text-fill: 'white'; -fx-background-color: 'black' ; -fx-font-size: 15; ");

        });
        // To revert to normal when not hovered
        actionButton.setOnMouseExited(event ->{

            actionButton.setStyle("-fx-border-width: 2; -fx-border-color: 'white'; -fx-border-radius: 20; -fx-background-radius: 20; -fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-text-fill: 'black'; -fx-background-color: 'white' ;");


        });




        Scene scene = new Scene(rootBox, 800, 400);
        scene.getStylesheets().add("data:, " +
                ".menu-bar .label {" +
                "-fx-text-fill: white;" +
                "}");




        // Create a KeyFrame with a duration of 10 seconds
        KeyFrame tenSecondKeyFrame = new KeyFrame(Duration.seconds(10), event -> {
            updateUI();
        });


        // Create a Timeline with the KeyFrame and set it to repeat indefinitely
        Timeline tenSecondCycle = new Timeline(tenSecondKeyFrame);
        tenSecondCycle.setCycleCount(Timeline.INDEFINITE);
        tenSecondCycle.play();


        stage.setTitle("Testing");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void updateUI() {
        // Allows imgaes to fade out
        FadeTransition fadeAnimation = new FadeTransition(Duration.millis(2000), imageContainer);
        fadeAnimation.setFromValue(1.0);
        fadeAnimation.setToValue(0);

        switch (photoNum) {
            case 0:
                Image image1 = new Image("warren.png" );
                setBackgroundImage(image1);
                quoteLabel.setText("Read Warren Buffets Annual Letter");
                actionButton.setText("Click Here");
                break;
            case 1:
                Image image2 = new Image("PicB.png" );
                setBackgroundImage(image2);
                quoteLabel.setText("Invest with Wisdom, Grow with Purpose");
                actionButton.setText("Invest With Us");
                break;
            case 2:
                Image image3 = new Image("PicC.png" );
                setBackgroundImage(image3);
                quoteLabel.setText("Text 3");
                actionButton.setText("This is button three");
                break;
        }

        if (photoNum >= 3) {
            photoNum = 1;
        } else {
            photoNum++;
        }
        fadeAnimation.setFromValue(0);
        fadeAnimation.setToValue(1);
        fadeAnimation.play();
    }

  private void setBackgroundImage(Image image) {
      BackgroundImage backgroundImage = new BackgroundImage(image,
              BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
              BackgroundPosition.DEFAULT,
              BackgroundSize.DEFAULT);
      Background background = new Background(backgroundImage);
      imageContainer.setBackground(background);
  }
}