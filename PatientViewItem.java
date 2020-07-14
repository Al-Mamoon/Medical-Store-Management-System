package sample;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class PatientViewItem {
    private TableView<PatientItem> tableView = new TableView<>();

    // Creating a confirm box to show which shows do you want to close the window or not
    private boolean confirmDisplay() {
        AtomicBoolean result = new AtomicBoolean(false);
        Stage window = new Stage();

        window.setTitle("Confirm");
        window.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label("Are your sure you want to close the window?");
        Button yesButton = new Button("Yes");
        yesButton.setMinWidth(100);
        yesButton.setStyle("-fx-background-color: #e63946;");
        yesButton.setTextFill(Paint.valueOf("#fff"));
        Button noButton = new Button("No");
        noButton.setMinWidth(100);

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
        window.showAndWait();

        return result.get();
    }

//        public ObservableList<PatientItem> getItems() {
//            ObservableList<DoctorItem> items = FXCollections.observableArrayList();
//            // Work on progress
//            items.add(new DoctorItem())
//
//            return items;
//        }

    public void addItem(String niNumber, String firstName, String surName, DatePicker dateOfBirth, String billingName,
                        String address, String postCode, String city, String country, String homePhone,
                        String mobilePhone, String faxPhone, String meno, String patientId, String patientNhsNumber,
                        String emisNumber, String gpAppointmentRef) throws IOException {
        PatientItem patientItem = new PatientItem();

        patientItem.setNiNumber(niNumber);
        patientItem.setFirstName(firstName);
        patientItem.setSurName(surName);
        patientItem.setDateOfBirth(dateOfBirth);
        patientItem.setBillingName(billingName);
        patientItem.setAddress(address);
        patientItem.setPostCode(postCode);
        patientItem.setCity(city);
        patientItem.setCountry(country);
        patientItem.setHomePhone(homePhone);
        patientItem.setMobilePhone(mobilePhone);
        patientItem.setFaxPhone(faxPhone);
        patientItem.setMemo(meno);
        patientItem.setPatientId(patientId);
        patientItem.setPatientNhsNumber(patientNhsNumber);
        patientItem.setEmisNumber(emisNumber);
        patientItem.setGpAppointmentRef(gpAppointmentRef);

        String line = niNumber + "," + firstName + "," + surName +"," + patientItem.getDateOfBirth() + "," + billingName + "," +
                address + "," + postCode + "," + city + "," + country + "," + homePhone + "," + mobilePhone + "," +
                faxPhone + "," + meno + "," + patientId + "," + patientNhsNumber + "," + emisNumber + "," + gpAppointmentRef;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\data\\Patient.csv", true))) {
            writer.write(line + "\n");
        }

        tableView.getItems().add(patientItem);   // Adding all the items

        Stage window = new Stage();
        window.setTitle("Information");

        BorderPane borderPane = new BorderPane();

        VBox vBox = new VBox(15);
        Label label = new Label("Added successfully.");

        Button button = new Button("Ok");
        button.setMinWidth(100);
        button.setMinHeight(30);
        button.setOnAction(e -> window.close());

        vBox.getChildren().addAll(label, button);
        borderPane.setMargin(vBox, new Insets(5, 0, 0, 70));

        borderPane.setCenter(vBox);

        Scene scene = new Scene(borderPane, 250, 70);

        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void deleteItem() {
        ObservableList<PatientItem> items;
        items = tableView.getItems();
        items.remove(tableView.getSelectionModel().getSelectedItem());
    }

    public void perform() {
        Stage window = new Stage();
        window.setTitle("Patient Data");

        BorderPane borderPane = new BorderPane();

        // Columns
        TableColumn<PatientItem, String> niNumberColumn = new TableColumn<>("NI No.");
        niNumberColumn.setCellValueFactory(new PropertyValueFactory<>("niNumber"));

        TableColumn<PatientItem, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<PatientItem, String> surnameColumn = new TableColumn<>("Surname");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surName"));

        TableColumn<PatientItem, String> dateOfBirthColumn = new TableColumn<>("Date of Birth");
        dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

        TableColumn<PatientItem, String> billingNameColumn = new TableColumn<>("Billing Name");
        billingNameColumn.setCellValueFactory(new PropertyValueFactory<>("billingName"));

        TableColumn<PatientItem, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<PatientItem, String> postCodeColumn = new TableColumn<>("Post Code");
        postCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postCode"));

        TableColumn<PatientItem, String> cityColumn = new TableColumn<>("City");
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));

        TableColumn<PatientItem, String> countryColumn = new TableColumn<>("Country");
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));

        TableColumn<PatientItem, String> homePhoneColumn = new TableColumn<>("Home Phone");
        homePhoneColumn.setCellValueFactory(new PropertyValueFactory<>("homePhone"));

        TableColumn<PatientItem, String> mobilePhoneColumn = new TableColumn<>("Mobile Phone");
        mobilePhoneColumn.setCellValueFactory(new PropertyValueFactory<>("mobilePhone"));

        TableColumn<PatientItem, String> faxPhoneColumn = new TableColumn<>("Fax Phone");
        faxPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("faxPhone"));

        TableColumn<PatientItem, String> memoColumn = new TableColumn<>("Memo");
        memoColumn.setCellValueFactory(new PropertyValueFactory<>("memo"));

        TableColumn<PatientItem, String> patientIdColumn = new TableColumn<>("Patient ID");
        patientIdColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));

        TableColumn<PatientItem, String> patientNhsNumberColumn = new TableColumn<>("Patient NHS No");
        patientNhsNumberColumn.setCellValueFactory(new PropertyValueFactory<>("patientNhsNumber"));

        TableColumn<PatientItem, String> emisNumberColumn = new TableColumn<>("EMIS No");
        emisNumberColumn.setCellValueFactory(new PropertyValueFactory<>("emisNumber"));

        TableColumn<PatientItem, String> gpAppointmentRefColumn = new TableColumn<>("GP Appointment Ref.");
        gpAppointmentRefColumn.setCellValueFactory(new PropertyValueFactory<>("gpAppointmentRef"));

//        tableView.getItems().addAll(getItems())
        tableView.getColumns().addAll(niNumberColumn, firstNameColumn, surnameColumn, dateOfBirthColumn,
                billingNameColumn, addressColumn, postCodeColumn, cityColumn, countryColumn, homePhoneColumn,
                mobilePhoneColumn, faxPhoneColumn, memoColumn, patientIdColumn, patientNhsNumberColumn,
                emisNumberColumn, gpAppointmentRefColumn);

        borderPane.setCenter(tableView);

        HBox hBox = new HBox(20);

        Button deleteButton = new Button("Delete");
        deleteButton.setMinHeight(30);
        deleteButton.setMinWidth(100);
        deleteButton.setOnAction(e -> deleteItem());
        deleteButton.setTextFill(Paint.valueOf("#fff"));
        deleteButton.setStyle("-fx-background-color: #4f6367");

        Button closeButton = new Button("Close");
        closeButton.setMinHeight(30);
        closeButton.setMinWidth(100);
        closeButton.setOnAction(e -> window.close());
        closeButton.setTextFill(Paint.valueOf("#fff"));
        closeButton.setStyle("-fx-background-color: #ff6b6c");

        hBox.getChildren().addAll(deleteButton, closeButton);
        borderPane.setMargin(hBox, new Insets(0, 0, 0, 300));
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, 800, 600);

        window.setScene(scene);
        window.show();
    }
}
