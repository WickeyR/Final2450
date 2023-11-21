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

import javax.sound.sampled.Line;

public class Main extends Application {
    InvestWithUsPage investWithUsPage = new InvestWithUsPage();


    Label selectedCategoryLabel;
    ArticleSection currentContainer;

    HBox articleCaterogiesList;
    HBox currentArticleCategoryBox = new HBox();
    Separator seperator = new Separator();
    Separator separator2 = new Separator();
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
        seperator.setOrientation(Orientation.HORIZONTAL);
        seperator.prefWidthProperty().bind(stage.widthProperty().multiply(0.75));
        separator2.setOrientation(Orientation.HORIZONTAL);
        separator2.prefWidthProperty().bind(stage.widthProperty().multiply(0.75));

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
                "                                                                             " +
                "                                                                              " +
                "                                                                              " +

                "                                                                 ");
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
        imageContainer.setPrefHeight(1000);
        imageContainer.getChildren().addAll(quoteAndButtonBox);

        // Contains Updated Image and Menu Bar
        StackPane rootImageContainer = new StackPane();
        rootImageContainer.getChildren().setAll(imageContainer, topBar);
        rootImageContainer.setMaxSize(1465,650);
        rootImageContainer.setMinSize(1465,650);
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

        // This is the end of the Image pane


        //
        Label newsLabel = new Label("News");
        //News Label is selected by default
        this.selectedCategoryLabel = newsLabel;
        selectedCategoryLabel.setStyle("-fx-font-size:25; -fx-font-weight:bold;");
        setCategoryLabelStyling(newsLabel);
        Label sustainabilityLabel = new Label("Sustainability");
        setCategoryLabelStyling(sustainabilityLabel);
        Label meetingsLabel = new Label("Meeting Reports");
        setCategoryLabelStyling(meetingsLabel);
        Label stockHolderLabel = new Label("Stock Holder Info");
        setCategoryLabelStyling(stockHolderLabel);

        articleCaterogiesList = new HBox(newsLabel, sustainabilityLabel, meetingsLabel, stockHolderLabel);
        articleCaterogiesList.setAlignment(Pos.CENTER);
        articleCaterogiesList.setSpacing(30);


        ArticleSection container = new ArticleSection(1);
        currentArticlesPane = container.getGridPane();

        // Sets up behavior of label click changing the articles displayed on page.
        newsLabel.setOnMouseClicked(event -> setupCategoryLabel(newsLabel, 1));
        sustainabilityLabel.setOnMouseClicked(event -> setupCategoryLabel(sustainabilityLabel,2));
        meetingsLabel.setOnMouseClicked(event -> setupCategoryLabel(meetingsLabel, 3));
        stockHolderLabel.setOnMouseClicked(event -> setupCategoryLabel(stockHolderLabel, 4));


        VBox articleSectionOfPage = new VBox(articleCaterogiesList, currentArticlesPane);
        articleSectionOfPage.setAlignment(Pos.CENTER);
        articleCaterogiesList.setAlignment(Pos.CENTER);
        articleSectionOfPage.setSpacing(10);

        //TODO: Add seperateor Styles
        HBox separatorBox = new HBox(seperator);
        separatorBox.setAlignment(Pos.CENTER);

        HBox separator2Box = new HBox(separator2);
        separator2Box.setAlignment(Pos.CENTER);








        // Section about berskrhire Hathaway in HBox for Photo, Vbox for label and paragraph




        HBox aboutUsSection = new HBox();
        aboutUsSection.setMinWidth(1465);
        aboutUsSection.setMinHeight(500);
        aboutUsSection.setMaxWidth(1465);
        aboutUsSection.setMaxHeight(500);


        //TODO: Add fonts and styling to the labels, center them better toward the bottom middle of current located
        Label ceoHeadline = new Label("About our Ceo");
        ceoHeadline.setStyle("-fx-font-size:25;");
        Label ceoInfo = new Label(
                "Warren Buffett's business interests extend beyond Berkshire Hathaway, with significant stakes \n" +
                        "in companies across various sectors, including technology, consumer goods, and finance. \n" +
                        "His investment choices often set trends in the financial world, reflecting his deep understanding\n" +
                        " of market dynamics. Buffett is also known for his keen eye for talent, mentoring numerous successful \n" +
                        "investors and business leaders who have themselves become influential figures. His approach to wealth \n" +
                        "accumulation and distribution is often cited in discussions about responsible capitalism and corporate ethics.\n" +
                        "\n" +
                        "Buffett's insights into market trends and economics are not just confined to his annual letters; he is a \n" +
                        "frequent speaker at conferences and interviews, offering valuable advice to investors of all levels.\n" +
                        " Despite his success, Buffett has maintained a reputation for integrity and ethical business practices, \n" +
                        "setting a standard in the corporate world. His legacy is not just in his wealth, but in the principles of \n" +
                        "investment and business management that he has shared with the world.\n" +
                        "\n" +
                        "In addition to his business and philanthropic endeavors, Buffett is known for his wit and humor, often using\n" +
                        " anecdotes and parables to explain complex financial concepts. His approachable demeanor and ability to simplify\n" +
                        " the intricacies of finance have made him a popular figure beyond the business world. Lastly, Buffett's commitment \n" +
                        "to his hometown of Omaha is evident in his choice to live there instead of in a major financial center, further reflecting \n" +
                        "his down-to-earth personality and loyalty to his roots."
                );
        ceoInfo.setStyle("-fx-font-size: 16");
        ceoInfo.setLineSpacing(2);

        VBox aboutCeoBox = new VBox(ceoHeadline, ceoInfo);
        aboutCeoBox.setSpacing(10);
        aboutCeoBox.setPadding(new Insets(25, 0,0,0));

        ImageView ceoImage= new ImageView(new Image("WarrenStill.png"));
        ceoImage.setPreserveRatio(true);
        ceoImage.fitWidthProperty().bind(aboutUsSection.widthProperty().multiply(.4));
        ceoImage.fitHeightProperty().bind(aboutUsSection.heightProperty());



        aboutUsSection.getChildren().addAll(ceoImage, aboutCeoBox);
        aboutUsSection.setSpacing(125);
        aboutCeoBox.setAlignment(Pos.TOP_CENTER);
        aboutUsSection.setStyle("-fx-background-color: 'E9ECEF'");
        // This is the end of the about us secion






        // Contains all other boxes
        VBox rootBox = new VBox(rootImageContainer, articleSectionOfPage,separatorBox, aboutUsSection, separator2Box);
        rootImageContainer.setAlignment(Pos.TOP_CENTER);
        currentArticlesPane.setAlignment(Pos.CENTER);
        rootBox.setFillWidth(true);
        ScrollPane pane = new ScrollPane();
        pane.setContent(rootBox);
        pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        rootBox.setSpacing(35);
        Scene scene = new Scene(pane, 1920, 1080);
        scene.getStylesheets().add("websiteStyles.css");

        // Create a KeyFrame with a duration of 10 seconds
        KeyFrame tenSecondKeyFrame = new KeyFrame(Duration.seconds(6), event -> updateUI());

        // Create a Timeline with the KeyFrame and set it to repeat indefinitely
        Timeline tenSecondCycle = new Timeline(tenSecondKeyFrame);
        tenSecondCycle.setCycleCount(Timeline.INDEFINITE);
        tenSecondCycle.play();


        stage.setTitle("Berkshire Hathaway");
        stage.setScene(scene);
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
                break;
            }
            case 1 -> {
                Image image2 = new Image("FadingHeadlineImages/PicB.png");
                setBackgroundImage(imageContainer, image2);
                quoteLabel.setText("Invest with Wisdom, Grow with Purpose");
                actionButton.setText("Invest With Us");
                actionButton.setOnAction(event -> investWithUsPage.openNewPage());
                break;
            }
            case 2 -> {
                Image image3 = new Image("FadingHeadlineImages/PicC.png");
                setBackgroundImage(imageContainer, image3);
                quoteLabel.setText("Read our Quarterly Reports");
                actionButton.setText("Click Here");
                break;
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

    private void setCategoryLabelStyling(Label categoryLabel) {
        if (categoryLabel == selectedCategoryLabel){
            categoryLabel.setStyle("-fx-font-size:25; -fx-font-weight:bold;" );
        }
        else {
            categoryLabel.setStyle("-fx-font-size:20;");

        }
        categoryLabel.setOnMouseEntered(event -> categoryLabel.setStyle("-fx-font-size:25; -fx-font-weight:bold;"));
        categoryLabel.setOnMouseExited(event -> {
            if (!categoryLabel.equals(selectedCategoryLabel)) {
                categoryLabel.setStyle("-fx-font-size:20;");
            }
        });

        categoryLabel.setOnMouseClicked(event -> {
            this.selectedCategoryLabel = categoryLabel;
            updateCategoryStyles(); // Update styles for all labels
        });
    }
     private void setupCategoryLabel(Label label, int categoryNumber) {
        setCategoryLabelStyling(label);
        label.setOnMouseClicked(event -> {
            ArticleSection newContainer = new ArticleSection(categoryNumber);
            updateArticlesPane(newContainer);
            this.selectedCategoryLabel = label;
            updateCategoryStyles();
        });
    }

    private void updateCategoryStyles() {
        // Iterate over all category labels and update their styles
        for (Node node : articleCaterogiesList.getChildren()) {
            if (node instanceof Label) {
                Label label = (Label) node;
                if (label.equals(selectedCategoryLabel)) {
                    label.setStyle("-fx-font-size:25; -fx-font-weight:bold;");
                } else {
                    label.setStyle("-fx-font-size: 20;");
                }
            }
        }
    }
    private void updateArticlesPane(ArticleSection newContainer) {
        currentArticlesPane.getChildren().clear(); // Clear existing content
        currentArticlesPane.getChildren().addAll(newContainer.getGridPane().getChildren()); // Add new content
    }


}