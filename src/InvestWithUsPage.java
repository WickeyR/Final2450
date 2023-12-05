//Author: Ricky Franco, Denise Thuong, Byron Wong
//Nov 15 2023
//InvestWithUsPage.java: A separate page that opens up with additional functions to act as a sign-up
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
    private TextField emailField;
    private TextField phoneNumberField;

    /*
    openNewPage: Opens a new sub-page that acts as a sign-up site
     */
    public void openNewPage() {
        //Creates a stage for all our components
        Stage stage = new Stage();

        Label investLabel = new Label("Invest with Berkshire Hathaway");
        investLabel.setStyle("-fx-font-size: 22; -fx-underline: 'true'; -fx-text-fill: 'F8F9FA'");

        // The beginning of our input fields to allow users to enter information
        Label fullName = new Label("Enter Name");
        setLabelStyling(fullName);
        fNameField = new TextField();
        // Adds into VBox for formatting
        VBox fullNameBox = new VBox(fullName, fNameField);
        fullNameBox.setSpacing(5);
        fullNameBox.setAlignment(Pos.CENTER_LEFT);
        fNameField.setMaxWidth(400);
        setFieldStyling(fNameField);


        // Creates a area to enter information for email
        Label emailLabel = new Label("Email");
        setLabelStyling(emailLabel);
        emailField = new TextField();
        emailField.setPromptText("ex: ironMan@gmail.com");
        VBox emailBox = new VBox(emailLabel, emailField);
        emailBox.setSpacing(5);
        emailBox.setAlignment(Pos.CENTER_LEFT);
        emailField.setMaxWidth(400);
        setFieldStyling(emailField);

        // Creates out phone-number input area
        Label phoneNumberLabel = new Label("Phone");
        setLabelStyling(phoneNumberLabel);
        phoneNumberField = new TextField();
        phoneNumberField.setPromptText("###-###-####");
        VBox phoneNumberBox = new VBox(phoneNumberLabel, phoneNumberField);
        phoneNumberBox.setAlignment(Pos.CENTER_LEFT);
        phoneNumberBox.setSpacing(5);
        phoneNumberField.setMaxWidth(400);
        setFieldStyling(phoneNumberField);

        // Choice-box for more information abou the user
        Label moreInfo = new Label("How did you find out about us?");
        setLabelStyling(moreInfo);
        ChoiceBox<String> moreInfoChoices = new ChoiceBox<>();
        moreInfoChoices.getItems().addAll("News Articles", "Through a friend/family member", "TV Commercial", "Other");
        VBox moreInfoBox = new VBox(moreInfo, moreInfoChoices);
        moreInfoBox.setSpacing(5);
        moreInfoBox.setAlignment(Pos.CENTER_LEFT);
        moreInfoChoices.setMaxWidth(400);
        moreInfoChoices.setStyle("-fx-font-size:16");


        //  Submit button that will call upon several methods for user to make changes if needed
        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-font-size: 25; -fx-background-color: 'F8F9FA'; -fx-text-fill: '212529'; -fx-border-color: '212529'; -fx-border-width: 2px; -fx-border-radius: 10; -fx-background-radius: 10; -fx-focus-color: 'transparent'; -fx-faint-focus-color: 'transparent';");
        submitButton.setOnMouseEntered(event -> submitButton.setStyle("-fx-font-size: 25; -fx-background-color: '212529'; -fx-text-fill: 'F8F9FA'; -fx-border-color: '212529'; -fx-border-width: 2px; -fx-border-radius: 10; -fx-background-radius: 10; -fx-focus-color: 'transparent'; -fx-faint-focus-color: 'transparent';"));
        submitButton.setOnMouseExited(event -> submitButton.setStyle("-fx-font-size: 25; -fx-background-color: 'F8F9FA'; -fx-text-fill: '212529'; -fx-border-color: '212529'; -fx-border-width: 2px; -fx-border-radius: 10; -fx-background-radius: 10; -fx-focus-color: 'transparent'; -fx-faint-focus-color: 'transparent';"));
        submitButton.setOnAction(event -> {
            String errorMessages = validateFields();
            if (errorMessages.isEmpty()) {
                // Grabs the text of the user and calls upon function to thank user for signing up
                setNewScene(fNameField.getText(), stage);
            } else {
                // If user has errors, it displays what they need to fix to proceed
                showAlert("Please correct the following errors:\n" + errorMessages);
            }
        });

        // Adds all of our components into root VBox and formats them appropriately
        VBox pageContents = new VBox(investLabel, fullNameBox, emailBox, phoneNumberBox, moreInfoBox, submitButton);
        pageContents.setMaxHeight(600);
        pageContents.setMaxWidth(400);
        pageContents.setPadding(new Insets(20,50,50,50));
        pageContents.setAlignment(Pos.TOP_CENTER); // Center alignment for the VBox itself
        investLabel.setAlignment(Pos.CENTER);
        pageContents.setSpacing(25);
        // Adds a slight transparency to our background to view background image
        pageContents.setStyle("-fx-background-color: rgba(73, 80, 87, 0.8); ");
        // Ensures all content such as labels and text-fields have no transparency
        investLabel.setOpacity(1);
        fullNameBox.setOpacity(1);
        emailBox.setOpacity(1);
        phoneNumberBox.setOpacity(1);
        moreInfoBox.setOpacity(1);
        submitButton.setOpacity(1);

        //ImageView created with height and width set to serve as background
        ImageView citySkyline = new ImageView(new Image("ArticleThumbnails/citySkyline.png"));
        citySkyline.setFitWidth(600); // Adjust as necessary

        // GridPane used to center the contents of page, adds background image and contents
        GridPane rootPane = new GridPane();
        rootPane.setAlignment(Pos.CENTER);
        rootPane.add(citySkyline, 0, 0);
        GridPane.setHgrow(citySkyline, Priority.ALWAYS);
        GridPane.setVgrow(citySkyline, Priority.ALWAYS);

        // Ensures the Contents are properly centered
        ColumnConstraints column = new ColumnConstraints();
        column.setHalignment(HPos.CENTER);
        RowConstraints row = new RowConstraints();
        row.setValignment(VPos.CENTER);

        rootPane.getColumnConstraints().add(column);
        rootPane.getRowConstraints().add(row);

        //Adds contents to RootPane with formatting
        rootPane.add(pageContents, 0, 0); // Add VBox at the same position

        // Sets the scene of the page
        Scene root = new Scene(rootPane);
        stage.setScene(root);
        stage.setResizable(false);
        stage.show();
    }



    //-----------------------------------------GETTER METHODS-----------------------------------------------

    /*
    validateFields: Checks all the text-field and input locations, if any are empty or inputted incorrectly, errors are shown
    @return errorMessages.toString(): Returns the stringBuilder string, with all the messages added
     */
    private String validateFields() {
        // Creates an empty string-builder which will have messages added accordingly
        StringBuilder errorMessages = new StringBuilder();

        // Checks if fields are empty
        if (!areFieldsFilled(fNameField, emailField, phoneNumberField)) {
            errorMessages.append("  - Fill in all fields.\n");
        }
        // Checks if email is valid
        if (!isValidEmail(emailField.getText())) {
            errorMessages.append("  - Enter valid email address\n");
        }
        // Checks if phone-number is valid
        if (!isValidPhoneNumber(phoneNumberField.getText())) {
            errorMessages.append("  - Enter a valid phone-number ###-###-####\n");
        }

        return errorMessages.toString();
    }
    /*
    @param fields: The fields that are being checked
    areFieldsFilled: Returns true or false depending on if fields are filled or not
     */
    private boolean areFieldsFilled(TextField... fields) {
        for (TextField field : fields) {
            if (field.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /*
    @param emailL: The string of the email grabbed from the input text-field
    isValidEmail: Checks if email contains @ and . for validity. Returns true or false
     */
    private boolean isValidEmail(String email) {
        return (email.contains("@") && email.contains(".")) ;
    }

    /*
    @param phoneNumber: The string of the phone number that is being checked
    isValidPhoneNumber: Checks if phone-number contains proper formatting, returns true or false
     */
    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}");
    }


    /*
    @param message: The String message places into Alert to be shown if errors
    showAlert: Displays a alert to the screen telling user their errors
     */
    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Invalid Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //-----------------------------------------SETTER METHODS-----------------------------------------------

    /*
    @param label: The object that will have their styles changed
    setLabelStyling: used several times for each label in the input section
     */
    private void setLabelStyling(Label label) {
        label.setStyle("-fx-font-size: 16px; -fx-text-fill: 'F8F9FA'");
    }

    /*
    @param field: the text field that will have their style changed
    setFieldStyling: Sets the styling of several textfields
     */
    private void setFieldStyling(TextField field){field.setStyle("-fx-font-size:16px;");}


    /*
    @param customerName: The name of the customer that was input in the text-field
    @param stage: The new stage that will be shown on screen
    setNewScene: Displays a screen after successful information input that thanks the user
     */
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
