import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Main extends Application {


    private final StackPane annualReportPane = new StackPane();
     private final StackPane sustainabilityPane = new StackPane();
     private final StackPane annualMeetingPane = new StackPane();
    private final StackPane stockHolderInformationPane = new StackPane();
    //To track current photo
    private int photoNum = 0;
    // The Quote that will be updated every 10 seconds
    private final Label quoteLabel = new Label("Invest with Wisdom, Grow with Purpose");

    // The Button that goes along with the change
    private final Button actionButton = new Button("");

    private final ImageView imageView = new ImageView();
    StackPane imageContainer = new StackPane();

    @Override
    public void start(Stage stage) {
        // Loads first image
        updateUI();

        // To make the menu bar at the top and adds styles
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


        // Adds shadow effect to text and button
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

        // Contains Updated Image and Menu Bar
        StackPane rootImageContainer = new StackPane();
        rootImageContainer.getChildren().setAll(imageContainer, topBar);
        rootImageContainer.setMaxSize(800,400);
        rootImageContainer.setMinSize(800,400);
        topBar.setStyle("-fx-background-color: rgba(60,60,60, 0.4);");


        //Sets the styling for the Quote label
        quoteLabel.setStyle("-fx-text-fill: 'white'; -fx-underline: true; -fx-font-size: 25;  ");

        //Sets the styling for the actionButton
        actionButton.setStyle("-fx-border-width: 2; -fx-border-color: 'white'; -fx-border-radius: 20; -fx-background-radius: 20; -fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-text-fill: 'black'; -fx-background-color: 'white' ;");
        actionButton.borderProperty().set(null);

        // To Change properties when hovering
        actionButton.setOnMouseEntered(event ->  actionButton.setStyle("-fx-border-width: 2; -fx-border-color: 'black'; -fx-border-radius: 20; -fx-background-radius: 20; -fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-text-fill: 'white'; -fx-background-color: 'black' ; -fx-font-size: 15; "));
        // To revert to normal when not hovered
        actionButton.setOnMouseExited(event -> actionButton.setStyle("-fx-border-width: 2; -fx-border-color: 'white'; -fx-border-radius: 20; -fx-background-radius: 20; -fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-text-fill: 'black'; -fx-background-color: 'white' ;"));

        // For all items on page after imageContainer


        Label imporantTaglineLabel = new Label("Read Updates from Berkshire Hathaway");

        // Calls function to set styling and functionality of stackPanes in "Updates"
        setUpdatesPaneStyling();

        // Places update panes into HBox for styling
        HBox imagePanelContainer = new HBox(annualReportPane, sustainabilityPane, annualMeetingPane, stockHolderInformationPane);
        imagePanelContainer.setSpacing(10);



        VBox importantInformationPanel = new VBox(imporantTaglineLabel, imagePanelContainer);
        importantInformationPanel.setSpacing(10);
        importantInformationPanel.setPadding(new Insets(30, 0, 0, 30));




        // Contains all other boxes
        VBox rootBox = new VBox(rootImageContainer , importantInformationPanel);
        rootImageContainer.setAlignment(Pos.TOP_CENTER);
        rootBox.setFillWidth(true);

        rootBox.setSpacing(10);
        Scene scene = new Scene(rootBox, 800, 800);
        scene.getStylesheets().add("data:, " +
                ".menu-bar .label {" +
                "-fx-text-fill: white;" +
                "}");

        // Create a KeyFrame with a duration of 10 seconds
        KeyFrame tenSecondKeyFrame = new KeyFrame(Duration.seconds(10), event -> updateUI());


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
        // Allows images to fade out
        FadeTransition fadeAnimation = new FadeTransition(Duration.millis(2000), imageContainer);
        fadeAnimation.setFromValue(1.0);
        fadeAnimation.setToValue(0);

        switch (photoNum) {
            case 0 -> {
                Image image1 = new Image("HeadlineImages/warren.png");
                setBackgroundImage(imageContainer, image1);
                quoteLabel.setText("Read Warren Buffets Annual Letter");
                actionButton.setText("Click Here");
            }
            case 1 -> {
                Image image2 = new Image("HeadlineImages/PicB.png");
                setBackgroundImage(imageContainer, image2);
                quoteLabel.setText("Invest with Wisdom, Grow with Purpose");
                actionButton.setText("Invest With Us");
            }
            case 2 -> {
                Image image3 = new Image("HeadlineImages/PicC.png");
                setBackgroundImage(imageContainer, image3);
                quoteLabel.setText("Text 3");
                actionButton.setText("This is button three");
            }
        }

        if (photoNum >= 2) {
            photoNum = 0;
        } else {
            photoNum++;
        }
        fadeAnimation.setFromValue(0);
        fadeAnimation.setToValue(1);
        fadeAnimation.play();
    }

    private void setBackgroundImage(StackPane pane, Image image) {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);
        Background background = new Background(backgroundImage);
        pane.setBackground(background);
    }


    public void scaleButton(StackPane button){
        button.setScaleX(1.1);
        button.setScaleY(1.1);
        button.setCursor(Cursor.HAND);
  }
  public void descaleButton(StackPane button){
      button.setScaleX(1.0);
      button.setScaleY(1.0);
      button.setCursor(Cursor.DEFAULT);

  }

  public void setUpdatesPaneStyling(){
      annualReportPane.setMinSize(175,100);
      annualReportPane.setMaxSize(175,100);
      annualReportPane.setStyle("-fx-background-color: 'black' ");
      annualReportPane.setOnMouseEntered(e -> scaleButton(annualReportPane));
      annualReportPane.setOnMouseExited(e -> descaleButton(annualReportPane));
      setBackgroundImage(annualReportPane, new Image("importantUpdatesImages/newsReports.png"));


      sustainabilityPane.setMinSize(175,100);
      sustainabilityPane.setMaxSize(175,100);
      sustainabilityPane.setStyle("-fx-background-color: 'black' ");
      sustainabilityPane.setOnMouseEntered(e -> scaleButton(sustainabilityPane));
      sustainabilityPane.setOnMouseExited(e -> descaleButton(sustainabilityPane));
      setBackgroundImage(sustainabilityPane, new Image("importantUpdatesImages/sustainablility.png"));


      annualMeetingPane.setMinSize(175,100);
      annualMeetingPane.setMaxSize(175,100);
      annualMeetingPane.setStyle("-fx-background-color: 'black' ");
      annualMeetingPane.setOnMouseEntered(e -> scaleButton(annualMeetingPane));
      annualMeetingPane.setOnMouseExited(e -> descaleButton(annualMeetingPane));
      setBackgroundImage(annualMeetingPane, new Image("importantUpdatesImages/AnnualMeetings (1).png"));



      stockHolderInformationPane.setMinSize(175,100);
      stockHolderInformationPane.setMaxSize(175,100);
      stockHolderInformationPane.setStyle("-fx-background-color: 'black' ");
      stockHolderInformationPane.setOnMouseEntered(e -> scaleButton(stockHolderInformationPane));
      stockHolderInformationPane.setOnMouseExited(e -> descaleButton(stockHolderInformationPane));
      setBackgroundImage(stockHolderInformationPane, new Image("importantUpdatesImages/StockHolderInformation.png"));





  }
}