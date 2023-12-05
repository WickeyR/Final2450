//Author: Ricky Franco, Denise Thuong, Byron Wong
//22 Nov 2023
//LogoAnimation.java: Sets the behavior for Pane that will serve as a logo animation
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class LogoAnimation {

    /*
    @param pane: The node that the animation will take place on
    SetAnimation: Grabs the images from the file paths and calls methods to perform animation
     */
    public static void SetAnimation(Pane pane) {

        // Creates a HBox that our images will be placed on
        HBox images = new HBox();
        for (int i = 0; i < 10; i++) {
            // Opens the filepath and increments for each image
            ImageView imageView = new ImageView(new Image("AffiliatedBrands/Image" + i + ".png"));
            imageView.setFitWidth(125);
            imageView.setPreserveRatio(true);

            // Wrap the ImageView in a StackPane for better hover performance
            StackPane imageContainer = new StackPane(imageView);
            imageContainer.setPrefSize(125, 125);
            imageContainer.setAlignment(Pos.CENTER);
            images.getChildren().add(imageContainer);

            // TO save the current increment for switch
            int finalI = i;

            // Set mouse events on the imageContainer instead of imageView
            imageContainer.setOnMouseEntered(event -> {
                imageView.setScaleX(1.2);
                imageView.setScaleY(1.2);
                imageContainer.setCursor(Cursor.HAND);
            });
            imageContainer.setOnMouseExited(event -> {
                imageView.setScaleX(1);
                imageView.setScaleY(1);
                imageContainer.setCursor(Cursor.DEFAULT);
            });

            imageContainer.setOnMouseClicked(event -> {
                // Based on the png added, the openWebpage is given a different link to match the website
                switch (finalI) {
                    case 0 -> Main.openWebpage("https://www.geico.com/");
                    case 1 ->
                            Main.openWebpage("https://www.benbridge.com/?gad_source=1&gclid=CjwKCAiAmZGrBhAnEiwAo9qHif3ppkk7F2YEpc2nvD9W_InZoSyoCEhTzGgzr4a86vjdrrVp5h4oTxoC7VIQAvD_BwE");
                    case 2 ->
                            Main.openWebpage("https://www.benjaminmoore.com/en-us/store-locator?gad_source=1&gclid=CjwKCAiAmZGrBhAnEiwAo9qHiU8LUtCAzmNbXTLF36Rj_p3S4F6aR2zoFXE86ZnUGhDXxY1MQafu7xoCwMoQAvD_BwE&gclsrc=aw.ds");
                    case 3 -> Main.openWebpage("https://www.duracell.com/en-us/");
                    case 4 -> Main.openWebpage("https://www.businesswire.com/portal/site/home/");
                    case 5 ->
                            Main.openWebpage("https://www.brooksrunning.com/en_us/featured/black-friday-cyber-sale/?tid=sem:GOOGLE:USA%7CSearch%7CBrand%7CCore%7CGeneral-HV-Primary-Exact%7CStandard%7CActive+Evaluators%7CNeutral:B%7CBrooks%7CGN%7CHV%7CExact:brooks&gclsrc=aw.ds&");
                    case 6 ->
                            Main.openWebpage("https://www.heinz.com/products/00013000006057-heinz-tomato-ketchup-32-oz-bottle/?gclid=CjwKCAiAmZGrBhAnEiwAo9qHiRadZUVUFn9X113UoDWsLBXy1bH_3mRIEbG27Iuk24Oi0dZ-4cfnJhoCWf8QAvD_BwE");
                    case 7 -> Main.openWebpage("https://www.medpro.com/");
                    case 8 ->
                            Main.openWebpage("https://www.rcwilley.com/Free-Shipping/Search?utm_source=google&utm_medium=cpc&utm_campaign=Shipping%20-%20Shopping_Performance%20Max&campaignid=17560936752&adgroupid=&targetid=&matchtype=&network=x&device=c&gclid=CjwKCAiAmZGrBhAnEiwAo9qHiQXYJtFEe2sCkwryik7mHpsmVYfHljiPRhtKcuKFAYaGWAXGH8vcMhoCb9gQAvD_BwE&creative=&keyword=&placement=&target=&random=5237548662710088024&adposition=&adtype=&merchant_id=&product_channel=&product_id=&product_partition_id=&store_code=&s_kwcid=AL!17948!3!!!!x!!&gad_source=1");
                    case 9 -> Main.openWebpage("https://www.sees.com/");
                }

            });


        }

        // Formats images to provide space between
        images.setAlignment(Pos.CENTER);
        images.setSpacing(75);

        // Sets the behavior of our animation, a transition from end to end, indefinitely
        TranslateTransition boxTransition = new TranslateTransition(Duration.seconds(30), images);
        boxTransition.setFromX(-2000);
        boxTransition.setToX(1500);
        boxTransition.setCycleCount(TranslateTransition.INDEFINITE);
        boxTransition.setOnFinished(event -> boxTransition.play());
        boxTransition.play();

        // The image Box is now added to the pane with all its behaviors and animations
        pane.getChildren().addAll(images);
        pane.setClip(new Rectangle(1465, 400));
    }

}

