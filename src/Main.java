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
    GridPane currentArticlesPane;
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
        Menu emptySpacing = new Menu("                                                   " +
                "                                                                         " +
                "                                                         ");
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



        Label newsLabel = new Label("News");
        setCategoryLabelStyling(newsLabel);
        Label sustainabilityLabel = new Label("Sustainability");
        setCategoryLabelStyling(sustainabilityLabel);
        Label meetingsLabel = new Label("Meeting Reports");
        setCategoryLabelStyling(meetingsLabel);
        Label stockHolderLabel = new Label("Stock Holder Info");
        setCategoryLabelStyling(stockHolderLabel);

        HBox articleCaterogiesList = new HBox(newsLabel, sustainabilityLabel, meetingsLabel, stockHolderLabel);
        articleCaterogiesList.setAlignment(Pos.CENTER);
        articleCaterogiesList.setSpacing(20);
        ArticleSection container = new ArticleSection(1);

         currentArticlesPane = container.getGridPane();

        VBox articleSectionOfPage = new VBox(articleCaterogiesList, currentArticlesPane);
        articleSectionOfPage.setAlignment(Pos.CENTER);
        articleCaterogiesList.setAlignment(Pos.CENTER);
        articleSectionOfPage.setSpacing(10);

        //TODO: Add seperateor line between articles and about ceo

        //Changes made to file

        // Section about berskrhire Hathaway in HBox for Photo, Vbox for label and paragraph


        HBox aboutUsSection = new HBox();
        aboutUsSection.setMinWidth(800);
        aboutUsSection.setMinHeight(250);
        aboutUsSection.setMaxWidth(800);
        aboutUsSection.setMaxHeight(250);


        //TODO: Add fonts and styling to the labels, center them better toward the bottom middle of current located
        Label ceoHeadline = new Label("About our Ceo");
        ceoHeadline.setStyle("-fx-font-size:20;");
        Label ceoInfo = new Label(
                "Warren Buffett, born on August 30, 1930, in Omaha, Nebraska, is\n" +
                        " a renowned American businessman and philanthropist, often hailed \n" +
                        "as the most successful investor of the 20th and early 21st centuries\n" +
                        ". His journey began with a Bachelor of Science from the University of Nebraska\n" +
                " in 1950 and a Master of Science from Columbia University's School \n" +
                "of Business in 1951. In 1956, Buffett returned to Omaha and in 1965\n" +
                " gained majority control of Berkshire Hathaway Inc., a textile manufacturer \n" +
                "at the time. He transformed it into his primary investment vehicle, achieving\n" +
                " an exceptional annual gain of about 28% in Berkshire Hathaway’s publicly traded \n" +
                "shares, compared to the 11% average of major stock indices. \n");
        VBox aboutCeoBox = new VBox(ceoHeadline, ceoInfo);
        aboutCeoBox.setSpacing(10);

        ImageView ceoImage= new ImageView(new Image("WarrenStill.png"));
        ceoImage.setPreserveRatio(true);
        ceoImage.fitWidthProperty().bind(aboutUsSection.widthProperty().multiply(.33));
        ceoImage.fitHeightProperty().bind(aboutUsSection.heightProperty());



        aboutUsSection.getChildren().addAll(ceoImage, aboutCeoBox);
        aboutUsSection.setSpacing(50);
        aboutCeoBox.setAlignment(Pos.TOP_CENTER);
        aboutUsSection.setStyle("-fx-background-color: 'E9ECEF'");
        // This is the end of the about us secion






        // Contains all other boxes
        VBox rootBox = new VBox(rootImageContainer, articleSectionOfPage, aboutUsSection);
        rootImageContainer.setAlignment(Pos.TOP_CENTER);
        currentArticlesPane.setAlignment(Pos.CENTER);
        rootBox.setFillWidth(true);
        ScrollPane pane = new ScrollPane();
        pane.setContent(rootBox);
        pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        rootBox.setSpacing(50);
        Scene scene = new Scene(pane, 802, 810);
        scene.getStylesheets().add("websiteStyles.css");

        // Create a KeyFrame with a duration of 10 seconds
        KeyFrame tenSecondKeyFrame = new KeyFrame(Duration.seconds(6), event -> updateUI());

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

    private void setCategoryLabelStyling(Label categoryLabel){
        categoryLabel.setStyle("-fx-font-size: 15; ");

        categoryLabel.setOnMouseEntered(event -> categoryLabel.setStyle("-fx-font-size:18; -fx-font-weight:bold;"));
        categoryLabel.setOnMouseExited(event -> categoryLabel.setStyle("-fx-font-size:15;"));

    }

}