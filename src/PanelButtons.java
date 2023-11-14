//Author: Ricky Franco
//07 Nov 2023
//PanelButtons.java: Allows pass-through of Image and Label to make Button panels
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.image.*;

public class PanelButtons extends StackPane {

    private final int panelNum;
    /*
    @PARAM labelText: sets the label text of panel
    @PARAM backgroundImage: The image to be applied to the panel
    @PARAM panelNum: Sets the texts of the articles based on which panel is creates
    PanelButtons: Creates a Pane and calls functions for styling
     */
     public PanelButtons(String labelText, Image backgroundImage, int panelNum){
         StackPane pane = new StackPane();
         this.panelNum = panelNum;
         // Makes all panes consistent size
         pane.setMinSize(175, 120);
         pane.setMinSize(175,120);
         pane.setMaxSize(175,120);
         pane.setStyle("-fx-background-color: 'black';");
         // Calls function to add image to pane
         setUpdateImage(pane, backgroundImage);
         Label label = new Label(labelText);
         VBox box = new VBox(pane, label);
         // Calls function to properly format VBox
         formatInformationPaneBox(box);
         this.getChildren().add(box);
     }

     /*
     @PARAM box: The Vbox with label and image panel for styling
     formatInformationPaneBox: Uses VBox methods to properly style nodes
      */
    public void formatInformationPaneBox(VBox box){
        box.setAlignment(Pos.CENTER);
        box.setStyle("-fx-font-size: 13; -fx-border-color: grey; -fx-border-width: 3px; -fx-background-color: rgb(165, 165, 165)");
        box.setSpacing(7.5);
        // Calls methods on entire box when hovered over, resets to normal when exited.
        box.setOnMouseEntered(event -> scaleButton(box));
        box.setOnMouseExited(event -> descaleButton(box));
    }

    /*
    @PARAM box: The VBox to be edited
    scaleButton: Adds slight scaling to make button appear physical
     */
    public void scaleButton(VBox box){
        box.setScaleX(1.1);
        box.setScaleY(1.1);
        box.setCursor(Cursor.HAND);
    }
    /*
    @PARAM box: The VBox to be edited
    descaleButton: Sets scale to original when mouse exited
     */
    public void descaleButton(VBox box){
        box.setScaleX(1.0);
        box.setScaleY(1.0);
        box.setCursor(Cursor.DEFAULT);
    }
    /*
    @PARAM pane: The pane that will contain the image
    @PARAM image: The image to be passed and set to the background of pane
    setUpdateImage: sets background of pane and preserves image quality by scaling
     */
    private void setUpdateImage(StackPane pane, Image image){
        ImageView imageView = new ImageView(image);
        imageView.fitWidthProperty().bind(pane.widthProperty());
        imageView.fitHeightProperty().bind(pane.heightProperty());

        // Preserve the image's aspect ratio
        imageView.setPreserveRatio(true);

        // Add the ImageView to the pane
        pane.getChildren().add(imageView);
    }
    public void setArticleNames(HBox box){
        PDFLinks firstArticle, secondArticle, thirdArticle, fourthArticle;
        switch (panelNum) {
            case 1 -> {
                firstArticle = new PDFLinks("Third Quarter Earnings", "November 4, 2023", "Resources/ArticleImages/NewsArticles/Nov4News");
                secondArticle = new PDFLinks("Earnings Release", "November 2, 2023", "Resources/ArticleImages/NewsArticles/Nov2News");
                thirdArticle = new PDFLinks("Second Quarter Earnings", "August 5, 2023", "Resources/ArticleImages/NewsArticles/Aug5News");
                fourthArticle = new PDFLinks("News Release", "June 21, 2023", "Resources/ArticleImages/NewsArticles/Aug3News");
                box.getChildren().clear();
                box.getChildren().addAll(firstArticle, secondArticle, thirdArticle, fourthArticle);
            }
            case 2 ->//TODO: Add images for sustainability section
                    box.getChildren().clear();
            case 3 -> {
                firstArticle = new PDFLinks("First Quarter Report ", "2023", "Resources/ArticleImages/MeetingReportArticles/FirstQuarterReport");
                secondArticle = new PDFLinks("Second Quarter  Report", "2023", "Resources/ArticleImages/MeetingReportArticles/SecondQuarterReport");
                thirdArticle = new PDFLinks("Third Quarter Report", "2023", "Resources/ArticleImages/MeetingReportArticles/ThirdQuarterReport");
                fourthArticle = new PDFLinks("Annual Report", "2022", "Resources/ArticleImages/MeetingReportArticles/AnnualReport");
                box.getChildren().clear();
                box.getChildren().addAll(firstArticle, secondArticle, thirdArticle, fourthArticle);
            }
            case 4 -> {
                firstArticle = new PDFLinks("Investment Facts", "Feb 17, 2022", "Resources/ArticleImages/StockHolderArticles/InvestmentFacts");
                secondArticle = new PDFLinks("Stock Holder Info", "2023", "Resources/ArticleImages/StockHolderArticles/StockHolderInfo");
                thirdArticle = new PDFLinks("Energy Presentation", "Nov, 2022", "Resources/ArticleImages/StockHolderArticles/EnergyPresentation");
                fourthArticle = new PDFLinks("Comparative Rights", "Feb, 1999", "Resources/ArticleImages/StockHolderArticles/ComparativeRights");
                box.getChildren().clear();
                box.getChildren().addAll(firstArticle, secondArticle, thirdArticle, fourthArticle);
            }
        }

    }
}
