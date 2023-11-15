import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.*;
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
    HBox currentArticleCategoryBox = new HBox();
    Label currentArticleCategoryLabel  = new Label("News Reports");
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
        //logoMenu.setStyle("-fx-text-fill: white; -fx-font-size: 14");
        logoMenu.getStyleClass().add("menu-bar-label");

        Menu contactUsMenu = new Menu("Contact Us");
        //contactUsMenu.setStyle("-fx-text-fill: white; -fx-font-size: 14");
        contactUsMenu.getStyleClass().add("menu-bar-label");
        
        // Used to serve as spacing between Two menu items
        Menu emptySpacing = new Menu("                               " +
                "                                                    " +
                "                                                    ");
        emptySpacing.setDisable(true);
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
        topBar.getStyleClass().add("top-bar");


        //Sets the styling for the Quote label
        quoteLabel.getStyleClass().add("quote-label");

        //Sets the styling for the actionButton
        actionButton.getStyleClass().add("action-button");
        actionButton.borderProperty().set(null);

        // To Change properties when hovering
        actionButton.setOnMouseEntered(event ->  actionButton.getStyleClass().add("action-button:hover"));
        // To revert to normal when not hovered
        actionButton.setOnMouseExited(event -> actionButton.getStyleClass().add("action-button"));

        Label imporantTaglineLabel = new Label("Read Updates from Berkshire Hathaway");
        imporantTaglineLabel.getStyleClass().add("important-tagline-label");

        PanelButtons newsPanel = new PanelButtons("News Reports", new Image("PanelButtonThumnails/newsReports.png"), 1);
        PanelButtons sustainabilityPanel = new PanelButtons("Our Path to Sustainability", new Image("PanelButtonThumnails/sustain.png"), 2);
        PanelButtons meetingsPanel = new PanelButtons("Annual Meeting Information", new Image("PanelButtonThumnails/AnnualMeetings (1).png"), 3);
        PanelButtons stockHolderPanel = new PanelButtons("Stock Holder Information", new Image("PanelButtonThumnails/StockHolderInformation.png"),4 );

        HBox imagePanelContainer = new HBox(newsPanel, sustainabilityPanel, meetingsPanel, stockHolderPanel);
        imagePanelContainer.setSpacing(10);

        VBox containerText = new VBox(imagePanelContainer);

        VBox importantInformationPanel = new VBox(imporantTaglineLabel, containerText);
        importantInformationPanel.setSpacing(12.5);
        importantInformationPanel.setPadding(new Insets(30, 0, 15, 30));

        currentArticleCategoryBox.setSpacing(60);
        currentArticleCategoryBox.setMinSize(680,60);
        currentArticleCategoryBox.setMaxSize(680,60);

        currentArticleCategoryLabel.getStyleClass().add("article-box");
        VBox articleBox = new VBox(currentArticleCategoryLabel, currentArticleCategoryBox);
        articleBox.setPadding(new Insets(0,50,0,50));
        articleBox.getStyleClass().add("article-box");


        newsPanel.setOnMouseClicked(event -> {
            currentArticleCategoryLabel.setText("News Reports");
            newsPanel.setArticleNames(currentArticleCategoryBox);
        });
        sustainabilityPanel.setOnMouseClicked(event ->{
            currentArticleCategoryLabel.setText("Sustainability Reports");
            sustainabilityPanel.setArticleNames(currentArticleCategoryBox);
        });
        meetingsPanel.setOnMouseClicked(event -> {
            currentArticleCategoryLabel.setText("Meeting Reports");
            meetingsPanel.setArticleNames(currentArticleCategoryBox);
        });
        stockHolderPanel.setOnMouseClicked(event -> {
            currentArticleCategoryLabel.setText("Stock Holder Reports");
            stockHolderPanel.setArticleNames(currentArticleCategoryBox);
        });


        // Contains all other boxes
        VBox rootBox = new VBox(rootImageContainer , importantInformationPanel, articleBox);
        rootImageContainer.setAlignment(Pos.TOP_CENTER);
        rootBox.setFillWidth(true);
        ScrollPane pane = new ScrollPane();
        pane.setContent(rootBox);
        pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        rootBox.setSpacing(10);
        Scene scene = new Scene(pane, 802, 810);
        scene.getStylesheets().add("websiteStyles.css");

        // Create a KeyFrame with a duration of 10 seconds
        KeyFrame tenSecondKeyFrame = new KeyFrame(Duration.seconds(7), event -> updateUI());

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
        FadeTransition fadeAnimation = new FadeTransition(Duration.millis(500), imageContainer);
        fadeAnimation.setFromValue(1.0);
        fadeAnimation.setToValue(.5);

        switch (photoNum) {
            case 0 -> {
                Image image1 = new Image("FadingHeadlineImages/warren.png");
                setBackgroundImage(imageContainer, image1);
                quoteLabel.setText("Read Warren Buffets Annual Letter");
                actionButton.setText("Click Here");
            }
            case 1 -> {
                Image image2 = new Image("FadingHeadlineImages/PicB.png");
                setBackgroundImage(imageContainer, image2);
                quoteLabel.setText("Invest with Wisdom, Grow with Purpose");
                actionButton.setText("Invest With Us");
            }
            case 2 -> {
                Image image3 = new Image("FadingHeadlineImages/PicC.png");
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