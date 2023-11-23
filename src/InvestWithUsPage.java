import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

        Label firstName = new Label("First Name");
        setLabelStyling(firstName);
        fNameField = new TextField();
        HBox firstNameBox = new HBox(firstName, fNameField);
        firstNameBox.setSpacing(5);
        firstNameBox.setAlignment(Pos.CENTER);

        Label lastName = new Label("Last");
        setLabelStyling(lastName);
        lNameField = new TextField();
        HBox lastNameBox = new HBox(lastName, lNameField);
        lastNameBox.setSpacing(5);
        lastNameBox.setAlignment(Pos.CENTER);

        HBox nameHBox = new HBox(firstNameBox, lastNameBox);
        nameHBox.setSpacing(20);
        nameHBox.setAlignment(Pos.CENTER);

        Label emailLabel = new Label("Email");
        setLabelStyling(emailLabel);
        emailField = new TextField();
        emailField.setPromptText("ex: ironMan@gmail.com");
        HBox emailBox = new HBox(emailLabel, emailField);
        emailBox.setSpacing(5);
        emailBox.setSpacing(20);
        emailBox.setAlignment(Pos.CENTER);

        Label phoneNumberLabel = new Label("Phone");
        setLabelStyling(phoneNumberLabel);
        phoneNumberField = new TextField();
        phoneNumberField.setPromptText("###-###-####");
        HBox phoneNumberBox = new HBox(phoneNumberLabel, phoneNumberField);
        phoneNumberBox.setAlignment(Pos.CENTER);
        phoneNumberBox.setSpacing(20);

        Label moreInfo = new Label("How did you find out about us?");
        setLabelStyling(moreInfo);
        ChoiceBox<String> moreInfoChoices = new ChoiceBox<>();
        moreInfoChoices.getItems().addAll("News Articles", "Through a friend/family member", "TV Commercial", "Other");
        HBox moreInfoBox = new HBox(moreInfo, moreInfoChoices);
        moreInfoBox.setSpacing(20);
        moreInfoBox.setAlignment(Pos.CENTER);

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

        VBox pageContents = new VBox(headerPhoto, investLabel, nameHBox, emailBox, phoneNumberBox, moreInfoBox, submitButton);
        pageContents.setAlignment(Pos.TOP_CENTER);
        investLabel.setAlignment(Pos.CENTER);
        pageContents.setSpacing(25);
        pageContents.setStyle("-fx-background-color: '495057'");

        Scene root = new Scene(pageContents, 600, 800);

        stage.setTitle("Invest with us");

        stage.setScene(root);
        stage.setResizable(false);
        stage.show();
    }

    private String validateFields() {
        StringBuilder errorMessages = new StringBuilder();

        if (!areFieldsFilled(fNameField, lNameField, emailField, phoneNumberField)) {
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
        label.setStyle("-fx-font-size: 15px; -fx-text-fill: 'F8F9FA'");
    }

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
