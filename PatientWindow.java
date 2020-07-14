package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class PatientWindow {
    // Creating a confirm box to show which shows do you want to close the window or not
    private boolean confirmDisplay() {
        AtomicBoolean result = new AtomicBoolean(false);
        Stage window = new Stage();

        window.setTitle("Confirm");
        window.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label("Are your sure you want to close the window?");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 11));

        Button yesButton = new Button("Yes");
        yesButton.setMinWidth(100);
        yesButton.setStyle("-fx-background-color: #e63946;");
        yesButton.setTextFill(Paint.valueOf("#fff"));
        Button noButton = new Button("No");

        noButton.setMinWidth(100);
        noButton.setStyle("-fx-background-color: #496a81;");
        noButton.setTextFill(Paint.valueOf("#fff"));

        VBox vbox = new VBox(20);
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(yesButton, noButton);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().addAll(label, hBox);

        yesButton.setOnAction(event -> {
            result.set(true);
            window.close();
        });

        noButton.setOnAction(event -> {
            result.set(false);
            window.close();
        });

        Scene scene = new Scene(vbox, 250, 70);

        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();

        return result.get();
    }

    public void getWindow() throws FileNotFoundException {
        Stage window = new Stage();
        window.setTitle("Patient");
        window.initModality(Modality.APPLICATION_MODAL);

        // Layout
        BorderPane borderPane = new BorderPane();

        // Instances
        PatientViewItem patientViewItem = new PatientViewItem();

        // VBox and HBox layouts
        VBox vBox1 = new VBox(22);
        VBox vBox2 = new VBox(15);
        VBox vBox3 = new VBox(22);
        VBox vBox4 = new VBox(15);
        HBox hBox1 = new HBox(20);
        HBox hBox2 = new HBox(20);
        HBox hBox = new HBox(80);
        HBox buttonHBox = new HBox(20);

        // Label
        // First column label
        Label niNumber = new Label("NI No");
        niNumber.setTextFill(Paint.valueOf("#000"));
        niNumber.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label firstName = new Label("First Name");
        firstName.setTextFill(Paint.valueOf("#000"));
        firstName.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label surName = new Label("Surname");
        surName.setTextFill(Paint.valueOf("#000"));
        surName.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label dateOfBirth = new Label("Date of Birth");
        dateOfBirth.setTextFill(Paint.valueOf("#000"));
        dateOfBirth.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label billingName = new Label("Billing Name");
        billingName.setTextFill(Paint.valueOf("#000"));
        billingName.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label address = new Label("Address");
        address.setTextFill(Paint.valueOf("#000"));
        address.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label postCode = new Label("Post Code");
        postCode.setTextFill(Paint.valueOf("#000"));
        postCode.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label city = new Label("City");
        city.setTextFill(Paint.valueOf("#000"));
        city.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        vBox1.setMargin(billingName, new Insets(4, 0, 0, 0));
        vBox1.setMargin(city, new Insets(1, 0, 0, 0));
        vBox1.getChildren().addAll(niNumber, firstName, surName, dateOfBirth, billingName, address, postCode, city);

        // Text field
        // First column text field
        TextField niNumberTextField = new TextField();
        niNumberTextField.setPromptText("Enter NI number");
        niNumberTextField.setMinWidth(200);
        niNumberTextField.setFont(Font.font("Arial", 14));
        TextField firstNameTextField = new TextField();
        firstNameTextField.setPromptText("Enter first name");
        firstNameTextField.setMinWidth(200);
        firstNameTextField.setFont(Font.font("Arial", 14));
        TextField surNameTextField = new TextField();
        surNameTextField.setPromptText("Enter surname");
        surNameTextField.setMinWidth(200);
        surNameTextField.setFont(Font.font("Arial", 14));
        DatePicker dateOfBirthTextField = new DatePicker();
        dateOfBirthTextField.setPromptText("Month-Day-Year");
        dateOfBirthTextField.setMinWidth(200);
        TextField billingNameTextField = new TextField();
        billingNameTextField.setPromptText("Enter billing name");
        billingNameTextField.setMinWidth(200);
        billingNameTextField.setFont(Font.font("Arial", 14));
        TextField addressTextField = new TextField();
        addressTextField.setPromptText("Enter address");
        addressTextField.setMinWidth(200);
        addressTextField.setFont(Font.font("Arial", 14));
        TextField postCodeTextField = new TextField();
        postCodeTextField.setPromptText("Enter post code");
        postCodeTextField.setMinWidth(200);
        postCodeTextField.setFont(Font.font("Arial", 14));
        TextField cityTextField = new TextField();
        cityTextField.setPromptText("Enter city");
        cityTextField.setMinWidth(200);
        cityTextField.setFont(Font.font("Arial", 14));

        vBox2.setMargin(billingNameTextField, new Insets(5, 0, 0, 0));
        vBox2.setMargin(addressTextField, new Insets(2, 0, 0, 0));
        vBox2.setMargin(cityTextField, new Insets(3, 0, 0, 0));

        vBox2.getChildren().addAll(niNumberTextField, firstNameTextField, surNameTextField, dateOfBirthTextField,
                billingNameTextField, addressTextField, postCodeTextField, cityTextField);

        // Second column label
        Label country = new Label("Country");
        country.setTextFill(Paint.valueOf("#000"));
        country.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label homePhone = new Label("Home Phone");
        homePhone.setTextFill(Paint.valueOf("#000"));
        homePhone.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label mobilePhone = new Label("Mobile Phone");
        mobilePhone.setTextFill(Paint.valueOf("#000"));
        mobilePhone.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label faxPhone = new Label("Fax Phone");
        faxPhone.setTextFill(Paint.valueOf("#000"));
        faxPhone.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label memo = new Label("Memo");
        memo.setTextFill(Paint.valueOf("#000"));
        memo.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label patientId = new Label("Patient ID");
        patientId.setTextFill(Paint.valueOf("#000"));
        patientId.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label patientNhsNumber = new Label("Patient NHS No");
        patientNhsNumber.setTextFill(Paint.valueOf("#000"));
        patientNhsNumber.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label emisNumber = new Label("EMIS No");
        emisNumber.setTextFill(Paint.valueOf("#000"));
        emisNumber.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label gpAppointmentRef = new Label("GP Appointment Ref");
        gpAppointmentRef.setTextFill(Paint.valueOf("#000"));
        gpAppointmentRef.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        vBox3.setMargin(faxPhone, new Insets(1, 0, 0, 0));
        vBox3.setMargin(memo, new Insets(4, 0, 0, 0));
        vBox3.setMargin(patientId, new Insets(1, 0, 0, 0));
        vBox3.setMargin(patientNhsNumber, new Insets(2, 0, 0, 0));
        vBox3.setMargin(gpAppointmentRef, new Insets(-2, 0, 0, 0));
        vBox3.getChildren().addAll(country, homePhone, mobilePhone, faxPhone, memo, patientId, patientNhsNumber,
                emisNumber, gpAppointmentRef);



        // Second column text field
        TextField countryTextField = new TextField();
        countryTextField.setPromptText("Enter country");
        countryTextField.setMinWidth(200);
        countryTextField.setFont(Font.font("Arial", 14));
        TextField homePhoneTextField = new TextField();
        homePhoneTextField.setPromptText("Enter home phone number");
        homePhoneTextField.setMinWidth(200);
        homePhoneTextField.setFont(Font.font("Arial", 14));
        TextField mobilePhoneTextField = new TextField();
        mobilePhoneTextField.setPromptText("Enter mobile phone number");
        mobilePhoneTextField.setMinWidth(200);
        mobilePhoneTextField.setFont(Font.font("Arial", 14));
        TextField faxPhoneTextField = new TextField();
        faxPhoneTextField.setPromptText("Enter fax phone number");
        faxPhoneTextField.setMinWidth(200);
        faxPhoneTextField.setFont(Font.font("Arial", 14));
        TextField memoTextField = new TextField();
        memoTextField.setPromptText("Enter memo number");
        memoTextField.setMinWidth(200);
        memoTextField.setFont(Font.font("Arial", 14));
        TextField patientIdTextField = new TextField();
        patientIdTextField.setPromptText("Enter patient ID");
        patientIdTextField.setMinWidth(200);
        patientIdTextField.setFont(Font.font("Arial", 14));
        TextField patientNhsNumberTextField = new TextField();
        patientNhsNumberTextField.setPromptText("Enter NHS number");
        patientNhsNumberTextField.setMinWidth(200);
        patientNhsNumberTextField.setFont(Font.font("Arial", 14));
        TextField emisNumberTextField = new TextField();
        emisNumberTextField.setPromptText("Enter EMIS number");
        emisNumberTextField.setMinWidth(200);
        emisNumberTextField.setFont(Font.font("Arial", 14));
        TextField gpAppointmentRefTextField = new TextField();
        gpAppointmentRefTextField.setPromptText("Enter appointment reference");
        gpAppointmentRefTextField.setMinWidth(200);
        gpAppointmentRefTextField.setFont(Font.font("Arial", 14));

        vBox4.setMargin(memoTextField, new Insets(5, 0, 0, 0));
        vBox4.setMargin(patientIdTextField, new Insets(2, 0, 0, 0));
        vBox4.setMargin(patientNhsNumberTextField, new Insets(4, 0, 0, 0));

        vBox4.getChildren().addAll(countryTextField, homePhoneTextField, mobilePhoneTextField, faxPhoneTextField,
                memoTextField, patientIdTextField, patientNhsNumberTextField, emisNumberTextField, gpAppointmentRefTextField);

        hBox1.getChildren().addAll(vBox1, vBox2);
        hBox2.getChildren().addAll(vBox3, vBox4);
        hBox.getChildren().addAll(hBox1, hBox2);

        borderPane.setCenter(hBox);
        borderPane.setMargin(hBox, new Insets(70, 0, 0, 130));

        // Actions
        Button addButton = new Button("Add");
        addButton.setMinWidth(100);
        addButton.setMinHeight(30);
        addButton.setTextFill(Paint.valueOf("#fff"));
        addButton.setStyle("-fx-background-color: gray;");
        addButton.setOnAction(e -> {
            try {
                patientViewItem.addItem(
                        niNumberTextField.getText(), firstNameTextField.getText(), surNameTextField.getText(),
                        dateOfBirthTextField, billingNameTextField.getText(), addressTextField.getText(),
                        postCodeTextField.getText(), cityTextField.getText(), countryTextField.getText(),
                        homePhoneTextField.getText(), mobilePhoneTextField.getText(), faxPhoneTextField.getText(),
                        memoTextField.getText(), patientIdTextField.getText(), patientNhsNumberTextField.getText(),
                        emisNumberTextField.getText(), gpAppointmentRefTextField.getText()
                );
                niNumberTextField.clear();
                firstNameTextField.clear();
                surNameTextField.clear();
                billingNameTextField.clear();
                addressTextField.clear();
                postCodeTextField.clear();
                dateOfBirthTextField.getEditor().clear();
                cityTextField.clear();
                countryTextField.clear();
                homePhoneTextField.clear();
                mobilePhoneTextField.clear();
                faxPhoneTextField.clear();
                memoTextField.clear();
                patientIdTextField.clear();
                patientNhsNumberTextField.clear();
                emisNumberTextField.clear();
                gpAppointmentRefTextField.clear();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        Button showButton = new Button("Show Database");
        showButton.setMinWidth(100);
        showButton.setMinHeight(30);
        showButton.setTextFill(Paint.valueOf("#fff"));
        showButton.setStyle("-fx-background-color: #4f6367");
        showButton.setOnAction(e -> patientViewItem.perform());

        Button closeButton = new Button("Close");
        closeButton.setMinWidth(100);
        closeButton.setMinHeight(30);
        closeButton.setTextFill(Paint.valueOf("#fff"));
        closeButton.setStyle("-fx-background-color: #ff6b6c");
        closeButton.setOnAction(e -> {
            boolean close = confirmDisplay();

            if (close)
                window.close();
        });

        window.setOnCloseRequest(e -> {
            e.consume();
            boolean close = confirmDisplay();

            if (close)
                window.close();
        });

        buttonHBox.getChildren().addAll(addButton, showButton, closeButton);

        borderPane.setBottom(buttonHBox);
        borderPane.setMargin(buttonHBox, new Insets(0, 0, 80, 350));

        FileInputStream input = new FileInputStream("src\\images\\patient.jpg");

        // create a image

        Image image = new Image(input);

        // create a background image
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        // create Background
        Background background = new Background(backgroundimage);

        // set background
        borderPane.setBackground(background);

        Scene scene = new Scene(borderPane, 1024, 600);

        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
}
