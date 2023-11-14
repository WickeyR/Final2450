//Author: Ricky Franco
//07 Nov 2023
//PDFLinks.java: 

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PDFLinks extends HBox {
    PdfReaderWindow window = new PdfReaderWindow();

    public PDFLinks(String articleName, String date, String directoryName) {
        Label articleLabel = new Label(articleName);
        Label dateLabel = new Label(date);
        VBox box = new VBox(articleLabel, dateLabel);
        box.setAlignment(Pos.CENTER_LEFT);

        this.getChildren().addAll(box);

        articleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 13;");

        articleLabel.setOnMouseEntered(event -> {
            articleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 13; -fx-text-fill: blue; -fx-underline: true;");
            dateLabel.setStyle("-fx-text-fill: blue; -fx-underline: true;");
        });
        dateLabel.setOnMouseEntered(event -> {
            articleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 13; -fx-text-fill: blue; -fx-underline: true;");
            dateLabel.setStyle("-fx-text-fill: blue; -fx-underline: true;");
        });


        articleLabel.setOnMouseExited(event -> {
            articleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 13; ");
            dateLabel.setStyle("-fx-text-fill: black;");
        });
        dateLabel.setOnMouseExited(event -> {
            articleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 13; ");
            dateLabel.setStyle("-fx-text-fill: black;");
        });


        articleLabel.setOnMouseClicked(event -> window.openNewWindow(directoryName));
        dateLabel.setOnMouseClicked(event -> window.openNewWindow(directoryName));
    }
}
