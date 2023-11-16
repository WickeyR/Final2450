import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

import java.io.File;
import java.util.ArrayList;

public class PdfReaderWindow {

    private final ArrayList<Image> images = new ArrayList<>();
    private int currentIndex = 0;
    private final Label currentPageLabel = new Label("Page: 1");

    public void openNewWindow(String directoryPath) {
        Stage pdfStage = new Stage();
        pdfStage.setTitle("PDF Viewer");

        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(true);

        Button btnPrevious = new Button("Previous");
        btnPrevious.setOnAction(e -> goToPreviousPage(imageView));

        Button btnNext = new Button("Next");
        btnNext.setOnAction(e -> goToNextPage(imageView));

        HBox navigationBox = new HBox(20, btnPrevious, currentPageLabel, btnNext);
        navigationBox.setAlignment(Pos.CENTER);

        VBox box = new VBox(10);
        imageView.setFitWidth(1920);
        imageView.setFitHeight(1080);

        box.getChildren().addAll(imageView, navigationBox);
        box.setPadding(new Insets(0, 0, 10, 0));

        ScrollPane pane = new ScrollPane(box);
        pane.setFitToWidth(true);

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        imageView.setFitWidth(screenBounds.getWidth() * .9);
        imageView.setFitHeight(screenBounds.getHeight() * 0.9);

        // Load the images
        loadImages(directoryPath);
        if (!images.isEmpty()) {
            imageView.setImage(images.get(currentIndex));
        }

        pdfStage.setScene(new Scene(pane));
        pdfStage.show();
    }

    private void goToNextPage(ImageView imageView) {
        if (currentIndex < images.size() - 1) {
            currentIndex++;
            imageView.setImage(images.get(currentIndex));
            currentPageLabel.setText("Page: " + (currentIndex + 1) + " of " + (images.size()));
        }
    }

    private void goToPreviousPage(ImageView imageView) {
        if (currentIndex > 0) {
            currentIndex--;
            imageView.setImage(images.get(currentIndex));
            currentPageLabel.setText("Page: " + (currentIndex + 1) + " of " + (images.size()));
        }
    }

    public void loadImages(String directoryPath) {
        File dir = new File(directoryPath);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".png") || name.endsWith(".jpg")); // Add other file extensions as needed

        if (files != null) {
            for (File file : files) {
                images.add(new Image(file.toURI().toString()));
            }
        }
    }
}
