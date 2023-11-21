//Author: Ricky Franco
//20 Nov 2023
//InvestWithUsPage.java: 

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InvestWithUsPage {

    public void openNewPage(){

        //TODO: Add styling to make look pretty, button needs to change page to only say "THank you, a team member will be reaching out to you shortly"

        Stage stage = new Stage();
        ImageView headerPhoto = new ImageView(new Image("cityBackshot.png"));
        headerPhoto.setFitWidth(600);
        headerPhoto.setPreserveRatio(true);

        Label investLabel = new Label("Invest with Berkshire Hathaway");

        Label firstName = new Label("First Name");
        TextField fNameField = new TextField();
        HBox firstNameBox = new HBox(firstName, fNameField);
        firstNameBox.setSpacing(5);
        firstNameBox.setAlignment(Pos.CENTER);

        Label lastName = new Label("Last");
        TextField lNameField = new TextField();
        HBox lastNameBox = new HBox(lastName, lNameField);
        lastNameBox.setSpacing(5);
        lastNameBox.setAlignment(Pos.CENTER);


        HBox nameHBox = new HBox(firstNameBox, lastNameBox);
        nameHBox.setSpacing(20);
        nameHBox.setAlignment(Pos.CENTER);

        Label emailLabel = new Label("Email");
        TextField emailField = new TextField();
        emailField.setPromptText("ex: ironMan@gmail.com");
        HBox emailBox = new HBox(emailLabel, emailField);
        emailBox.setSpacing(5);
        emailBox.setSpacing(20);
        emailBox.setAlignment(Pos.CENTER);

        Label phoneNumberLabel = new Label("Phone #");
        TextField phoneNumberField = new TextField();
        phoneNumberField.setPromptText("###-###-####");
        HBox phoneNumberBox = new HBox(phoneNumberLabel, phoneNumberField);
        phoneNumberBox.setAlignment(Pos.CENTER);
        phoneNumberBox.setSpacing(20);

        Label moreInfo = new Label("How did you find out about us?");
        ChoiceBox<String> moreInfoChoices = new ChoiceBox<>();
        moreInfoChoices.getItems().addAll("News Articles", "Through a friend/family member", "TV Commercial", "Other");
        HBox moreInfoBox = new HBox(moreInfo, moreInfoChoices);
        moreInfoBox.setSpacing(20);
        moreInfoBox.setAlignment(Pos.CENTER);

        Button submitButton = new Button("Submit");
        HBox submitButtonBox = new HBox(submitButton);
        submitButton.setAlignment(Pos.CENTER);

        VBox pageContents = new VBox(headerPhoto, investLabel, nameHBox, emailBox, phoneNumberBox, moreInfoBox, submitButtonBox);
        investLabel.setAlignment(Pos.CENTER);
        pageContents.setSpacing(20);
        pageContents.setStyle("-fx-background-color: '495057'");


        Scene root = new Scene(pageContents, 600, 800);

        stage.setTitle("Invest with us");

        stage.setScene(root);
        stage.setResizable(false);
        stage.show();
    }
}
