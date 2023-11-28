import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//TODO: add comments to main
public class Main extends Application {
    InvestWithUsPage investWithUsPage = new InvestWithUsPage();
    Label selectedCategoryLabel;
    HBox articleCaterogiesList;
    Separator seperator = new Separator();
    Separator separator2 = new Separator();
    Separator seperator3 = new Separator();
    Separator separator4 = new Separator();
    GridPane currentArticlesPane;
    private int photoNum = 0;
    // The Quote that will be updated every 10 seconds
    private final Label quoteLabel = new Label("Invest with Wisdom, Grow with Purpose");

    // The Button that goes along with the change
    private final Button actionButton = new Button("");
    StackPane imageContainer = new StackPane();
    private EventHandler<MouseEvent> mouseEventEventHandler;

    @Override
    public void start(Stage stage) {
        seperator.setOrientation(Orientation.HORIZONTAL);
        seperator.prefWidthProperty().bind(stage.widthProperty().multiply(0.75));
        separator2.setOrientation(Orientation.HORIZONTAL);
        separator2.prefWidthProperty().bind(stage.widthProperty().multiply(0.75));
        seperator3.setOrientation(Orientation.HORIZONTAL);
        seperator3.prefWidthProperty().bind(stage.widthProperty().multiply(0.75));
        separator4.setOrientation(Orientation.HORIZONTAL);
        separator4.prefWidthProperty().bind(stage.widthProperty().multiply(0.75));

        updateUI();



        MenuBar topBar = new MenuBar();


        Menu logoMenu = new Menu("Berkshire Hathaway");
        logoMenu.getStyleClass().add("menu-bar-label");

        Menu contactUsMenu = new Menu("Contact Us");
        contactUsMenu.getStyleClass().add("menu-bar-label");
        MenuItem contactUsItem = new MenuItem();
        contactUsItem.setVisible(true); // Making it invisible
        contactUsMenu.getItems().add(contactUsItem);

        // Used to serve as spacing between Two menu items
        Menu emptySpacing = new Menu("                                                  " +
                "                                                                          " +
                "                                                                          " +
                "                                                                " +
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
        actionButton.setOnMouseEntered(event ->{
            actionButton.setCursor(Cursor.HAND);
            actionButton.getStyleClass().add("action-button:hover");
        });
        // To revert to normal when not hovered
        actionButton.setOnMouseExited(event -> {
            actionButton.setCursor(Cursor.DEFAULT);
            actionButton.getStyleClass().add("action-button");
        });


        Label articleSectionLabel = new Label("Important Updates from Berkshire Hathaway");
        articleSectionLabel.setStyle("-fx-font-size: 30; -fx-underline: true;");

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

        VBox articleSectionOfPage = new VBox(articleSectionLabel ,articleCaterogiesList, currentArticlesPane);
        articleSectionLabel.setAlignment(Pos.TOP_RIGHT);
        articleCaterogiesList.setAlignment(Pos.CENTER);
        articleSectionOfPage.setAlignment(Pos.CENTER);
        articleSectionOfPage.setSpacing(25);



        HBox separatorBox = new HBox(seperator);
        separatorBox.setPrefWidth(1465);
        separatorBox.setAlignment(Pos.CENTER);

        HBox separator2Box = new HBox(separator2);
        separator2Box.setPrefWidth(1465);
        separator2Box.setAlignment(Pos.CENTER);

        HBox separator3Box = new HBox(seperator3);
        separator3Box.setPrefWidth(1465);
        separator3Box.setAlignment(Pos.CENTER);

        HBox separator4Box = new HBox(separator4);
        separator4Box.setPrefWidth(1465);
        separator4Box.setAlignment(Pos.CENTER);





        HBox aboutUsSection = new HBox();
        aboutUsSection.setMinWidth(1465);
        aboutUsSection.setMinHeight(500);
        aboutUsSection.setMaxWidth(1465);
        aboutUsSection.setMaxHeight(500);

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
        ceoInfo.setTextAlignment(TextAlignment.CENTER);
        aboutCeoBox.setSpacing(10);
        aboutCeoBox.setPadding(new Insets(25, 0,0,0));

        ImageView ceoImage= new ImageView(new Image("ArticleThumbnails/WarrenStill.png"));
        ceoImage.setPreserveRatio(true);
        ceoImage.fitWidthProperty().bind(aboutUsSection.widthProperty().multiply(.4));
        ceoImage.fitHeightProperty().bind(aboutUsSection.heightProperty());

        aboutUsSection.getChildren().addAll(ceoImage, aboutCeoBox);
        aboutUsSection.setSpacing(125);
        aboutCeoBox.setAlignment(Pos.TOP_CENTER);
        aboutUsSection.setStyle("-fx-background-color: 'E9ECEF'");
        // This is the end of the about us secion

        // AFFILIATED COMPANIES SECTION
        Label affilatedBrandsLabel = new Label("Some of our Subsidiary Companies");
        affilatedBrandsLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 25; ");
        Pane animationPane = new Pane();
        LogoAnimation.SetAnimation(animationPane);
        animationPane.setMaxWidth(1465);

        VBox affiliatedBrandsSection = new VBox(affilatedBrandsLabel, animationPane);
        affiliatedBrandsSection.setAlignment(Pos.TOP_CENTER);
        affiliatedBrandsSection.setSpacing(20);
        // END OF THE AFFILIATED

        Label investLabelTitle = new Label("Why Invest with Berkshire Hathaway?");
        investLabelTitle.setStyle("-fx-font-size: 25;");
        investLabelTitle.setAlignment(Pos.CENTER); // Center alignment for the title
        investLabelTitle.setMaxWidth(Double.MAX_VALUE); // Allow the label to expand
        Label investLabelContent = new Label(
                "Berkshire Hathaway, under the legendary leadership of Warren Buffett, has established itself as a\n " +
                "titan in the investment world. This conglomerate's success story is built on a foundation of \n" +
                "diversified investments and a strong emphasis on long-term value creation. Investing with Berkshire \n" +
                "Hathaway means aligning with a company that has a proven track record of outperforming the market.\n" +
                " Their approach, focusing on acquiring undervalued companies with strong potential for growth and\n " +
                "meticulously managed reinvestments, has consistently delivered superior returns to shareholders.\n" +
                "\n" +
                "One of the key advantages of investing with Berkshire Hathaway is the opportunity to benefit from \n" +
                "Buffett's investment philosophy. Known as the 'Oracle of Omaha', Buffett's strategy of picking stocks \n" +
                "with strong fundamentals and holding onto them for the long term has become a blueprint for success in\n" +
                " the investment world. Additionally, Berkshire Hathaway’s portfolio includes a mix of high-performing\n" +
                " companies across various industries, from insurance and energy to technology and consumer goods,\n" +
                " providing investors with a balanced and diversified investment option.\n" +
                "\n");
        investLabelContent.setStyle("-fx-font-size: 16;");
        investLabelContent.setLineSpacing(2);
        investLabelContent.setTextAlignment(TextAlignment.CENTER); // Center alignment for the content text
        investLabelContent.setMaxWidth(Double.MAX_VALUE);

        Button connectWithUsButton = new Button("Connect With A Representative");
        connectWithUsButton.setOnMouseClicked(event -> investWithUsPage.openNewPage());
        connectWithUsButton.getStyleClass().add("connect-button");
        connectWithUsButton.borderProperty().set(null);

        // To Change properties when hovering
        connectWithUsButton.setOnMouseEntered(event -> {
            connectWithUsButton.setCursor(Cursor.HAND);
            connectWithUsButton.getStyleClass().add("connect-button:hover");
                });
        // To revert to normal when not hovered
        connectWithUsButton.setOnMouseExited(event -> {
            connectWithUsButton.setCursor(Cursor.DEFAULT);
            connectWithUsButton.getStyleClass().add("connect-button");
        });




        VBox investWithUsBox = new VBox(10, investLabelTitle, investLabelContent, connectWithUsButton);
        investWithUsBox.setAlignment(Pos.TOP_CENTER); // Align the VBox contents to the top center
        investWithUsBox.setPadding(new Insets(25, 75, 25, 75));

        ImageView berkshireImage = new ImageView(new Image("ArticleThumbnails/BerkshireBuilding.png"));
        berkshireImage.setPreserveRatio(true);
        berkshireImage.fitWidthProperty().bind(aboutUsSection.widthProperty().multiply(.4));
        berkshireImage.fitHeightProperty().bind(aboutUsSection.heightProperty());

        HBox investWithUsSectionBox = new HBox(125, investWithUsBox, berkshireImage);
        investWithUsSectionBox.setAlignment(Pos.CENTER_LEFT); // Align the HBox contents to the center left
        investWithUsSectionBox.setStyle("-fx-background-color: 'E9ECEF'");
        investWithUsSectionBox.setMinWidth(1465);
        investWithUsSectionBox.setMinHeight(500);
        investWithUsSectionBox.setMaxWidth(1465);
        investWithUsSectionBox.setMaxHeight(500);




        // start of more info
        GridPane moreInfoSection = new GridPane();
        moreInfoSection.setStyle("-fx-background-color: '#343A40'; -fx-font-size: 14;");
        moreInfoSection.setPadding(new Insets(40, 100, 40, 100));
        moreInfoSection.setVgap(30); // Vertical gap between rows
        moreInfoSection.setHgap(60); // Horizontal gap between columns

// Contact Information
        Label contactUsLabel = new Label("Contact Us:");
        contactUsLabel.setStyle("-fx-font-size: 14; -fx-text-fill:'F8F9FA' ;-fx-font-weight: bold;");
        Hyperlink emailLink = new Hyperlink("berkshire@berkshirehathaway.com");
        emailLink.setOnMouseClicked(event -> openEmail());
        emailLink.setStyle("-fx-text-fill: '#F8F9FA'; -fx-underline: true;");

        Text contactText1 = new Text(
                "Phone: (848) 932-7889\n" +
                "Email: ");
        contactText1.setFill(Color.web("#F8F9FA"));

        Text contactText2 = new Text("\nOffice Hours: 8am - 5pm Mo-Fr");
        contactText2.setFill(Color.web("#F8F9FA"));

        TextFlow contactUsTextFlow = new TextFlow(contactText1, emailLink, contactText2);
        VBox contactUsBox = new VBox(contactUsLabel, contactUsTextFlow);
        contactUsBox.setSpacing(10);
        contactUsTextFlow.setLineSpacing(3);

        moreInfoSection.add(contactUsBox, 0, 0); // Adjust the position as needed

// Corporate Office
        Label coporateOfficeHeaderLabel = new Label("Corporate Office; ");
        coporateOfficeHeaderLabel.setStyle("-fx-font-size: 14; -fx-text-fill:'F8F9FA' ;-fx-font-weight: bold;");

        Label corporateOfficeinfoLabel = new Label(
                        "Address: 3555 Farnam Street, Omaha, NE 68131"
        );
        corporateOfficeinfoLabel.setStyle("-fx-text-fill: '#F8F9FA';");
        corporateOfficeinfoLabel.setLineSpacing(3);
        VBox corperateOfficeBox = new VBox(coporateOfficeHeaderLabel, corporateOfficeinfoLabel);
        corperateOfficeBox.setSpacing(10);
        moreInfoSection.add(corperateOfficeBox, 1, 0); // Adding to column 1, row 0

// Investor Relations
        Label investorRelationsLabel = new Label("Investor Relations: ");
        investorRelationsLabel.setStyle("-fx-font-size: 14; -fx-text-fill:'F8F9FA' ;-fx-font-weight: bold;");
        Hyperlink secLink = new Hyperlink("www.sec.gov");
        secLink.setOnMouseClicked(event -> openWebpage(secLink.getText()));
        secLink.setStyle("-fx-text-fill: '#F8F9FA'; -fx-underline: true;");

        Hyperlink annualMeetingLink = new Hyperlink("https://www.berkshirehathaway.com/reports.html");
        annualMeetingLink.setOnMouseClicked(event -> openWebpage(annualMeetingLink.getText()));
        annualMeetingLink.setStyle("-fx-text-fill: '#F8F9FA'; -fx-underline: true;");

        Text investorText1 = new Text(
                "SEC Filings: ");
        investorText1.setFill(Color.web("#F8F9FA"));

        Text investorText2 = new Text("\nAnnual Reports: ");
        investorText2.setFill(Color.web("#F8F9FA"));

        TextFlow investorRelationTextFlow = new TextFlow(investorText1, secLink, investorText2, annualMeetingLink);
        VBox investorRelationBox = new VBox(investorRelationsLabel, investorRelationTextFlow);
        investorRelationBox.setSpacing(10);
        moreInfoSection.add(investorRelationBox, 0, 1); // Adding to column 0, row 1

// Social Media
        Label socialMediaLabel = new Label("Social Media");
        socialMediaLabel.setStyle("-fx-font-size: 14; -fx-text-fill:'F8F9FA' ;-fx-font-weight: bold;");

        Label socialMediaLinks = new Label("Twitter, Facebook, YouTube, StockTwits, Financial Juice, LinkedIn");
        socialMediaLinks.setStyle("-fx-text-fill: '#F8F9FA';");
        VBox socialMediaBox = new VBox(socialMediaLabel, socialMediaLinks);
        socialMediaBox.setSpacing(10);
        moreInfoSection.add(socialMediaBox, 1, 1); // Adding to column 1, row 1

// Legal
        Label legalLabel = new Label("Legal: ");
        legalLabel.setStyle("-fx-font-size: 14; -fx-text-fill:'F8F9FA' ;-fx-font-weight: bold;");
        Hyperlink legalLink = new Hyperlink("https://www.bhhs.com/privacy-policy");
        legalLink.setOnMouseClicked(event -> openWebpage(legalLink.getText()));
        legalLink.setStyle("-fx-text-fill: '#F8F9FA'; -fx-underline: true;");
        Text legalText1 = new Text("Privacy Policy: ");
        legalText1.setFill(Color.web("#F8F9FA"));

        TextFlow legalLinkText = new TextFlow(legalText1, legalLink);
        VBox legalBox = new VBox(legalLabel, legalLinkText);
        legalBox.setSpacing(10);
        moreInfoSection.add(legalBox, 2, 0); // Adding to column 2, row 0




        // Contains all other boxes
        VBox rootBox = new VBox(rootImageContainer, articleSectionOfPage,separatorBox, aboutUsSection, separator2Box, affiliatedBrandsSection,separator3Box, investWithUsSectionBox,separator4Box ,moreInfoSection);
        rootImageContainer.setAlignment(Pos.TOP_CENTER);
        currentArticlesPane.setAlignment(Pos.CENTER);
        rootBox.setFillWidth(true);
        ScrollPane pane = new ScrollPane();
        pane.setContent(rootBox);
        pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        //Scrolls to bottom when clicked
        contactUsMenu.setOnShowing(e -> pane.setVvalue(1.0)); // Scroll to the bottom when menu is clicked

        rootBox.setSpacing(35);
        Scene scene = new Scene(pane, 1465, 1080);
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
                actionButton.setOnMouseClicked(event -> openFile(new File("src/PdfPaths/WarrenBuffetLetter.pdf")));
                break;
            }
            case 1 -> {
                Image image2 = new Image("FadingHeadlineImages/familyInspiring.png");
                setBackgroundImage(imageContainer, image2);
                quoteLabel.setText("Invest with Wisdom, Grow with Purpose");
                actionButton.setText("Invest With Us");
                actionButton.setOnMouseClicked(event -> investWithUsPage.openNewPage());
                break;
            }
            case 2 -> {
                Image image3 = new Image("FadingHeadlineImages/merchBackground.png");
                setBackgroundImage(imageContainer, image3);
                quoteLabel.setText("Visit our Merchandise Website");
                actionButton.setText("Click Here");
                Hyperlink merchLink = new Hyperlink("https://berkshirewear.com/");
                actionButton.setOnMouseClicked(event -> openWebpage(merchLink.getText()));
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
        categoryLabel.setOnMouseEntered(event -> {
                categoryLabel.setCursor(Cursor.HAND);
                categoryLabel.setStyle("-fx-font-size:25; -fx-font-weight:bold;");
        });
        categoryLabel.setOnMouseExited(event -> {
            categoryLabel.setCursor(Cursor.DEFAULT);
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
    public static void openWebpage(String url){
        if(Desktop.isDesktopSupported()){
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void openEmail(){
        if (Desktop.isDesktopSupported()){
            File file = new File("file.pdf");
            try {
                Desktop.getDesktop().mail(new URI("mailto:berkshire@berkshirehathaway.com?subject=Inquiry"));

            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void openFile(File file){
        if (Desktop.isDesktopSupported()) {
            try {

                if (file.exists()) {
                    Desktop.getDesktop().open(file);
                } else {
                    System.err.println("File does not exist at path: " + file.getAbsolutePath());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}