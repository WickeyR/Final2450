//Author: Ricky Franco, Denise Thuong, Byron Wong
//15 Nov 2023
//ArticleImageContainer.java: Class that sets behaviors and formatting for each article
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import java.io.File;

public class ArticleImageContainer extends HBox {

    ImageView articleImage;
    Label articleNameLabel;
    Label articleDateLabel;
    String articleFilePath;
    String articleDescription;
    Separator separator;
    Label descriptionLabel;
    VBox articleVbox;

    /*
    @PARAM articleThumbnail: Filepath passed to set the thumbnail of the article
    @PARAM articleName: The title of the article
    @PARAM date: The date the article was published
    @PARAM articleFilePath: The String filepath leading to the pdf document
    @PARAM description: A short description telling the user the contents of the article
    ArticleImageContainer: Constructor used in ArticleSection.java that constructs an article fully formatted based on inputs
     */
    public ArticleImageContainer(Image articleThumbnail, String articleName, String date, String articleFilePath, String description){
         this.articleImage = new ImageView(articleThumbnail);
         this.articleNameLabel = new Label(articleName);
         this.articleDateLabel = new Label(date);
         this.articleFilePath = articleFilePath;
         this.articleDescription = description;
    }


    //-----------------------------------------SETTER METHODS-----------------------------------------------

    /*
    @PARAM box: The VBox that needs to be formatted
    setContainerStyling: sets all the styling and formatting of the contents int the article container
     */
    private void setContainerStyling(VBox box){
        box.setStyle("-fx-border-width: 1.5px; -fx-border-color: black; -fx-border-radius: 20; -fx-background-radius: 20; -fx-background-color: 'DEE2E6';");
        articleNameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18;");
        articleNameLabel.setTextAlignment(TextAlignment.CENTER);
        articleDateLabel.setStyle("-fx-font-size: 14;");
        descriptionLabel.setStyle("-fx-font-size: 15");
        descriptionLabel.setTextAlignment(TextAlignment.LEFT);
        descriptionLabel.setMaxWidth(350);
        descriptionLabel.setWrapText(true);
        box.setMaxWidth(400);
        box.setMaxHeight(250);
        box.setMinHeight(100);
        box.setMinWidth(400);
        box.setSpacing(10);
        box.setPadding(new Insets(20));
        box.setAlignment(Pos.TOP_CENTER);

        // Creates a rectangle to act as a clip for imageview to give border radius effect
        Rectangle clip = new Rectangle(150, 100);
        clip.setArcWidth(15);
        clip.setArcHeight(15);

        //Image size is based on the container it resides in
        articleImage.fitWidthProperty().bind(articleVbox.widthProperty().multiply(.4));
        articleImage.fitHeightProperty().bind(articleVbox.heightProperty());
        articleImage.setPreserveRatio(true);
        articleImage.setClip(clip);
    }

    /*
    setContainerBehavior: Called on the article container to set formatting and behavior when hovered over and clicked
     */
    public VBox setContainerBehavior(){
        VBox articleInfoBox = new VBox(articleNameLabel, articleDateLabel);
        articleInfoBox.setSpacing(10);
        articleInfoBox.setAlignment(Pos.CENTER);
        HBox imageAndInfo = new HBox(articleImage, articleInfoBox);
        imageAndInfo.setSpacing(15);
        separator = new Separator(Orientation.HORIZONTAL);
        separator.setMaxWidth(300);
        separator.setStyle("-fx-background-color: black; -fx-font-size: 1px;");
        descriptionLabel = new Label(this.articleDescription);

        //Places all components into Box
        this.articleVbox = new VBox(imageAndInfo, separator,  descriptionLabel);

        //Sets behaviors to call various methods depending on the action performed on the box
        articleVbox.setOnMouseClicked(event -> Main.openFile(new File(this.articleFilePath)));
        articleVbox.setOnMouseEntered(event -> scaleButton(articleVbox));
        articleVbox.setOnMouseExited(event -> descaleButton(articleVbox));


        setContainerStyling(articleVbox);
        return articleVbox;
    }
    /*
    @PARAM box: the vbox that will be modified
    scaleButton: Scaled the button slightly when hovered and changes cursor to give user a button feel
     */
    public void scaleButton(VBox box){
        box.setScaleX(1.1);
        box.setScaleY(1.1);
        box.setCursor(Cursor.HAND);
    }
    /*
    @PARAM box: The box being modified
    descaleButton: Sets the size and cursor back to normal when hovered off container
     */
    public void descaleButton(VBox box){
        box.setScaleX(1.0);
        box.setScaleY(1.0);
        box.setCursor(Cursor.DEFAULT);
    }
}
