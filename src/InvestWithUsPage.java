import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InvestWithUsPage {

    private TextField fNameField;
    private TextField lNameField;
    private TextField emailField;
    private TextField phoneNumberField;

    public void openNewPage() {
        Stage stage = new Stage();
        ImageView headerPhoto = new ImageView(new Image("ArticleThumbnails/cityBackshot.png"));
        headerPhoto.setFitWidth(600);
        headerPhoto.setPreserveRatio(true);

        Label investLabel = new Label("Invest with Berkshire Hathaway");
        investLabel.setStyle("-fx-font-size: 20; -fx-underline: 'true'; -fx-text-fill: 'F8F9FA'");

        Label fullName = new Label("Enter Name");
        setLabelStyling(fullName);
        fNameField = new TextField();
        VBox fullNameBox = new VBox(fullName, fNameField);
        fullNameBox.setSpacing(5);
        fullNameBox.setAlignment(Pos.CENTER_LEFT);
        fNameField.setMaxWidth(400);
        setFieldStyling(fNameField);


        Label emailLabel = new Label("Email");
        setLabelStyling(emailLabel);
        emailField = new TextField();
        emailField.setPromptText("ex: ironMan@gmail.com");
        VBox emailBox = new VBox(emailLabel, emailField);
        emailBox.setSpacing(5);
        emailBox.setAlignment(Pos.CENTER_LEFT);
        emailField.setMaxWidth(400);
        setFieldStyling(emailField);

        Label phoneNumberLabel = new Label("Phone");
        setLabelStyling(phoneNumberLabel);
        phoneNumberField = new TextField();
        phoneNumberField.setPromptText("###-###-####");
        VBox phoneNumberBox = new VBox(phoneNumberLabel, phoneNumberField);
        phoneNumberBox.setAlignment(Pos.CENTER_LEFT);
        phoneNumberBox.setSpacing(5);
        phoneNumberField.setMaxWidth(400);
        setFieldStyling(phoneNumberField);


        Label moreInfo = new Label("How did you find out about us?");
        setLabelStyling(moreInfo);
        ChoiceBox<String> moreInfoChoices = new ChoiceBox<>();
        moreInfoChoices.getItems().addAll("News Articles", "Through a friend/family member", "TV Commercial", "Other");
        VBox moreInfoBox = new VBox(moreInfo, moreInfoChoices);
        moreInfoBox.setSpacing(5);
        moreInfoBox.setAlignment(Pos.CENTER_LEFT);
        moreInfoChoices.setMaxWidth(400);
        moreInfoChoices.setStyle("-fx-font-size:16");


        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-font-size: 25; -fx-background-color: 'F8F9FA'; -fx-text-fill: '212529'; -fx-border-color: '212529'; -fx-border-width: 2px; -fx-border-radius: 10; -fx-background-radius: 10; -fx-focus-color: 'transparent'; -fx-faint-focus-color: 'transparent';");
        submitButton.setOnMouseEntered(event -> submitButton.setStyle("-fx-font-size: 25; -fx-background-color: '212529'; -fx-text-fill: 'F8F9FA'; -fx-border-color: '212529'; -fx-border-width: 2px; -fx-border-radius: 10; -fx-background-radius: 10; -fx-focus-color: 'transparent'; -fx-faint-focus-color: 'transparent';"));
        submitButton.setOnMouseExited(event -> submitButton.setStyle("-fx-font-size: 25; -fx-background-color: 'F8F9FA'; -fx-text-fill: '212529'; -fx-border-color: '212529'; -fx-border-width: 2px; -fx-border-radius: 10; -fx-background-radius: 10; -fx-focus-color: 'transparent'; -fx-faint-focus-color: 'transparent';"));
        submitButton.setOnAction(event -> {
            String errorMessages = validateFields();
            if (errorMessages.isEmpty()) {
                setNewScene(fNameField.getText(), stage);
            } else {
                showAlert("Please correct the following errors:\n" + errorMessages);
            }
        });

        VBox pageContents = new VBox(investLabel, fullNameBox, emailBox, phoneNumberBox, moreInfoBox, submitButton);
        pageContents.setMaxHeight(600);
        pageContents.setMaxWidth(400);
        pageContents.setPadding(new Insets(20,50,50,50));
        pageContents.setAlignment(Pos.TOP_CENTER); // Center alignment for the VBox itself
        investLabel.setAlignment(Pos.CENTER);
        pageContents.setSpacing(25);
        pageContents.setStyle("-fx-background-color: rgba(73, 80, 87, 0.8); ");
        investLabel.setOpacity(1);
        fullNameBox.setOpacity(1);
        emailBox.setOpacity(1);
        phoneNumberBox.setOpacity(1);
        moreInfoBox.setOpacity(1);
        submitButton.setOpacity(1);

// Your existing ImageView setup
        ImageView citySkyline = new ImageView(new Image("citySkyline.png"));
        citySkyline.setFitWidth(600); // Adjust as necessary

// Create and set up the GridPane
        GridPane rootPane = new GridPane();
        rootPane.setAlignment(Pos.CENTER); // Center the GridPane itself
        rootPane.add(citySkyline, 0, 0); // Add the ImageView first
        GridPane.setHgrow(citySkyline, Priority.ALWAYS); // Ensure ImageView stretches
        GridPane.setVgrow(citySkyline, Priority.ALWAYS);

// Define column and row constraints for centering
        ColumnConstraints column = new ColumnConstraints();
        column.setHalignment(HPos.CENTER); // Center horizontally in column
        RowConstraints row = new RowConstraints();
        row.setValignment(VPos.CENTER); // Center vertically in row

// Add constraints to GridPane
        rootPane.getColumnConstraints().add(column);
        rootPane.getRowConstraints().add(row);

// Add the VBox over the ImageView
        rootPane.add(pageContents, 0, 0); // Add VBox at the same position



// Create the Scene with the rootPane
        Scene root = new Scene(rootPane);
        stage.setScene(root);
        stage.setResizable(false);
        stage.show();
    }

    private String validateFields() {
        StringBuilder errorMessages = new StringBuilder();

        if (!areFieldsFilled(fNameField, emailField, phoneNumberField)) {
            errorMessages.append("  - Fill in all fields.\n");
        }

        if (!isValidEmail(emailField.getText())) {
            errorMessages.append("  - Enter valid email address\n");
        }

        if (!isValidPhoneNumber(phoneNumberField.getText())) {
            errorMessages.append("  - Enter a valid phone-number ###-###-####\n");
        }

        return errorMessages.toString();
    }

    private boolean areFieldsFilled(TextField... fields) {
        for (TextField field : fields) {
            if (field.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        return (email.contains("@") && email.contains(".")) ;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Check if the phone number matches the format ###-###-####
        return phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Invalid Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void setLabelStyling(Label label) {
        label.setStyle("-fx-font-size: 16px; -fx-text-fill: 'F8F9FA'");
    }
    private void setFieldStyling(TextField field){field.setStyle("-fx-font-size:16px;");}

    private void setNewScene(String customerName, Stage stage) {
        Label thankYouLabel = new Label("Thank You, " + customerName + "!");
        thankYouLabel.setStyle("-fx-font-size: 50; -fx-text-fill: 'F8F9FA'");
        Label tagLineLabel = new Label("A representative will reach out to you shortly with more information");
        tagLineLabel.setStyle("-fx-font-size: 25; -fx-text-fill: 'F8F9FA'");

        VBox thankYouPage = new VBox(thankYouLabel, tagLineLabel);
        thankYouPage.setStyle("-fx-background-color: '495057'");
        thankYouPage.setPadding(new Insets(40));
        Scene scene = new Scene(thankYouPage, 800, 250);
        stage.setScene(scene);
        stage.setTitle("Thank You");
    }
}
