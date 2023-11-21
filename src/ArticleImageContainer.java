//Author: Ricky Franco
//15 Nov 2023
//ArticleImageContainer.java:

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ArticleImageContainer extends HBox {

    ImageView articleImage;
    Label articleNameLabel;
    Label articleDateLabel;
    String articleFilePath;
    HBox articleHbox;
    PdfReaderWindow window = new PdfReaderWindow();
    public ArticleImageContainer(Image articleThumbnail, String articleName, String date, String articleFilePath){
         this.articleImage = new ImageView(articleThumbnail);
         this.articleNameLabel = new Label(articleName);
         this.articleDateLabel = new Label(date);
         this.articleFilePath = articleFilePath;
    }
    private void setContainerStyling(HBox box){
        box.setStyle("-fx-border-width: 2px; -fx-border-color: black;");
        articleNameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 13;");
        box.setMaxWidth(350);
        box.setMaxHeight(200);
        box.setMinHeight(100);
        box.setMinWidth(350);
        box.setSpacing(25);
        articleImage.fitWidthProperty().bind(articleHbox.widthProperty().multiply(.45));
        articleImage.fitHeightProperty().bind(articleHbox.heightProperty());
        articleImage.setPreserveRatio(true);
    }

    public HBox setContainerBehavior(){
        VBox articleInfoBox = new VBox(articleNameLabel, articleDateLabel);
        articleInfoBox.setAlignment(Pos.CENTER);
        this.articleHbox = new HBox(articleImage, articleInfoBox);
        articleHbox.setOnMouseClicked(event -> window.openNewWindow(articleFilePath));
        articleHbox.setOnMouseEntered(event -> scaleButton(articleHbox));
        articleHbox.setOnMouseExited(event -> descaleButton(articleHbox));


        setContainerStyling(articleHbox);
        return articleHbox;
    }
    public void scaleButton(HBox box){
        box.setScaleX(1.1);
        box.setScaleY(1.1);
        box.setCursor(Cursor.HAND);
    }
    public void descaleButton(HBox box){
        box.setScaleX(1.0);
        box.setScaleY(1.0);
        box.setCursor(Cursor.DEFAULT);
    }
}
