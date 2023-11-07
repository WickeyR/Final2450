import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Cursor;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.MenuBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.*;

public class Main extends Application {

    private final Label currentPageLabel = new Label("Page: 0");

    private int photoNum = 0;
    // The Quote that will be updated every 10 seconds
    private final Label quoteLabel = new Label("Invest with Wisdom, Grow with Purpose");

    // The Button that goes along with the change
    private final Button actionButton = new Button("");

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
        imageContainer.getChildren().addAll(quoteAndButtonBox);

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

        Label imporantTaglineLabel = new Label("Read Updates from Berkshire Hathaway");
        imporantTaglineLabel.setStyle("-fx-font-size: 15; -fx-underline: true;");

        ImageButtonPanels newsBox = new ImageButtonPanels("News Reports", new Image("importantUpdatesImages/newsReports.png"));
        ImageButtonPanels sustainabilityPanel = new ImageButtonPanels("Our Path to Sustainability", new Image("importantUpdatesImages/sustain.png"));
        ImageButtonPanels meetingsPanel = new ImageButtonPanels("Annual Meeting Information", new Image("importantUpdatesImages/AnnualMeetings (1).png"));
        ImageButtonPanels stockHolderPanel = new ImageButtonPanels("Stock Holder Information", new Image("importantUpdatesImages/StockHolderInformation.png"));

        HBox imagePanelContainer = new HBox(newsBox, sustainabilityPanel, meetingsPanel, stockHolderPanel);
        imagePanelContainer.setSpacing(10);


        VBox containerText = new VBox(imagePanelContainer);

        VBox importantInformationPanel = new VBox(imporantTaglineLabel, containerText);
        importantInformationPanel.setSpacing(12.5);
        importantInformationPanel.setPadding(new Insets(30, 0, 0, 30));

        //TODO:  add functionality under page where when user clicks on panel, the contents load. Default is news panel










        // Sets the styling for the pdfViewer buttons
        Button previousButton = new Button("prev");
        Button nextButton = new Button("next");
        HBox changePageButtonsBox = new HBox(previousButton, currentPageLabel, nextButton);
        changePageButtonsBox.setSpacing(15);
        changePageButtonsBox.setAlignment(Pos.CENTER);






        VBox pdfViewerBox = new VBox(changePageButtonsBox);
        pdfViewerBox.setAlignment(Pos.CENTER);
        pdfViewerBox.setPadding(new Insets(25, 10, 10, 25));

        // Contains all other boxes
        VBox rootBox = new VBox(rootImageContainer , importantInformationPanel, pdfViewerBox);
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


        stage.setTitle("Berkshire Hathaway");
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
                quoteLabel.setText("Read our Quarterly Reports");
                actionButton.setText("Click Here");
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
        pane.setBackground(new Background(backgroundImage));
    }

}