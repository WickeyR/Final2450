//Author: Ricky Franco
//22 Nov 2023
//LogoAnimation.java: 

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class LogoAnimation {
    public static void SetAnimation(Pane pane) {


        HBox firstImages = new HBox();
        for (int i = 0; i < 5; i++) {
            ImageView imageView = new ImageView(new Image("AffiliatedBrands/Image" + i + ".png"));
            imageView.setFitWidth(125);
            imageView.setPreserveRatio(true);
            firstImages.getChildren().add(imageView);
        }
        firstImages.setAlignment(Pos.CENTER);
        firstImages.setSpacing(75);

        TranslateTransition boxTransition = new TranslateTransition(Duration.seconds(45), firstImages);
        boxTransition.setFromX(-1400);
        boxTransition.setToX(1500);
        boxTransition.setCycleCount(TranslateTransition.INDEFINITE);
        boxTransition.setOnFinished(event -> boxTransition.play());
        boxTransition.play();




        HBox secondImages = new HBox();
        for (int i = 5; i < 10; i++) {
            ImageView imageView = new ImageView(new Image("AffiliatedBrands/Image" + i + ".png"));
            imageView.setFitWidth(125);
            imageView.setPreserveRatio(true);
            firstImages.getChildren().add(imageView);
        }
        firstImages.setAlignment(Pos.CENTER);
        firstImages.setSpacing(75);

        TranslateTransition secondTransition = new TranslateTransition(Duration.seconds(45), firstImages);
        secondTransition.setFromX(-1900);
        secondTransition.setToX(1500);
        secondTransition.setCycleCount(TranslateTransition.INDEFINITE);
        secondTransition.setOnFinished(event -> secondTransition.play());

        secondTransition.play();
        pane.getChildren().addAll(firstImages, secondImages);
        pane.setClip(new Rectangle(1465, 400));
    }

}

