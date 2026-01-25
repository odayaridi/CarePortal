package com.example.assignment_i;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
public class MedForm extends Application {
    public void start(Stage stage) {
        //App Name
        FlowPane fPane = new FlowPane();
        Text titleApp = new Text("CarePortal");
        titleApp.setFont(Font.font("Arial", 30));
        titleApp.setFill(Color.web("#ED0431"));// Start color
        fPane.setAlignment(Pos.CENTER);
        Timeline colorAnimation = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(titleApp.fillProperty(), Color.web("#ED0431"))),
                new KeyFrame(Duration.seconds(1.25), new KeyValue(titleApp.fillProperty(), Color.PINK))
        );
        colorAnimation.setAutoReverse(true);
        colorAnimation.setCycleCount(Animation.INDEFINITE);
        colorAnimation.play();
        fPane.getChildren().add(titleApp);

        //Parent Vbox
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: #ED0431;");
        vbox.setPadding(new Insets(10));

        //Child nestedVbox
        VBox nestedVbox = new VBox();
        nestedVbox.setAlignment(Pos.CENTER);
        nestedVbox.setSpacing(20);
        nestedVbox.setStyle("-fx-background-color: #FFEFEF; -fx-border-radius: 20px; -fx-background-radius: 20px;");
        nestedVbox.setPadding(new Insets(15));

        //Child of nestedVbox
        GridPane grPane = new GridPane();
        grPane.setAlignment(Pos.CENTER);
        grPane.setVgap(10);
        grPane.setHgap(10);
        grPane.setPadding(new Insets(10));

        //Preparing UI Nodes
        Label fName_label = new Label("Full Name:");
        TextField fName = new TextField();
        Label dob_label = new Label("Date of Birth:");
        DatePicker dob = new DatePicker();
        Label pNumber_label = new Label("Phone Number:");
        TextField pNumber = new TextField();
        Label rsonvisit_label = new Label("Reason to visit:");
        TextField reasonVisit = new TextField();
        Label cSymptoms_label = new Label("Current Symptoms:");
        TextField cSymptoms = new TextField();

        //Medical History
        Label medicalhistory_label = new Label("Medical History:");
        CheckBox hbp = new CheckBox("High Blood Pressure");
        CheckBox diabetes = new CheckBox("Diabetes");
        CheckBox asthma = new CheckBox("Asthma");
        CheckBox heartDisease = new CheckBox("Heart Disease");
        CheckBox epilepsy = new CheckBox("Epilepsy");
        CheckBox otherOptions = new CheckBox("Other");
        TextField otherOption = new TextField();
        otherOption.setPromptText("Please specify");
        otherOptions.setOnAction(e -> {
            if (otherOptions.isSelected() && !grPane.getChildren().contains(otherOption)) {
                grPane.add(otherOption, 1, 11);
            } else {
                grPane.getChildren().remove(otherOption);
            }
        });

        //Medications
        Label medQn_label = new Label("Taking any medications currently?");
        ToggleGroup medsRadio = new ToggleGroup();
        HBox medsHbox = new HBox(10);
        RadioButton yesMed = new RadioButton("Yes");
        RadioButton noMed = new RadioButton("No");
        yesMed.setToggleGroup(medsRadio);
        noMed.setToggleGroup(medsRadio);
        medsHbox.getChildren().addAll(yesMed, noMed);
        TextField yesMedsText = new TextField();
        yesMedsText.setPromptText("List medications");
        yesMed.setOnAction(e -> {
            if (!grPane.getChildren().contains(yesMedsText)) {
                grPane.add(yesMedsText, 1, 13);
            }
        });

        noMed.setOnAction(e -> grPane.getChildren().remove(yesMedsText));

        //Smoke
        Label smokeQn_label = new Label("Do you smoke?");
        ToggleGroup smokeRadio = new ToggleGroup();
        HBox smokeHbox = new HBox(10);
        RadioButton yesSm = new RadioButton("Yes");
        RadioButton noSm = new RadioButton("No");
        yesSm.setToggleGroup(smokeRadio);
        noSm.setToggleGroup(smokeRadio);
        smokeHbox.getChildren().addAll(yesSm, noSm);

        //Alcohol
        Label alcoholQn_label = new Label("Do you consume alcohol?");
        ToggleGroup alcoholRadio = new ToggleGroup();
        HBox alcoholHbox = new HBox(10);
        RadioButton yesAlc = new RadioButton("Yes");
        RadioButton noAlc = new RadioButton("No");
        yesAlc.setToggleGroup(alcoholRadio);
        noAlc.setToggleGroup(alcoholRadio);
        alcoholHbox.getChildren().addAll(yesAlc, noAlc);

        //Insurance Provider Name
        Label ipm_label = new Label("Insurance Provider Name:");
        TextField ipm = new TextField();
        Label policynumber_label = new Label("Policy Number:");
        TextField policyNumber = new TextField();

        //Button
        HBox hBoxBtn = new HBox();
        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
            if (fName.getText().isEmpty() ||
                    dob.getValue() == null ||
                    pNumber.getText().isEmpty() ||
                    cSymptoms.getText().isEmpty() ||
                    reasonVisit.getText().isEmpty() ||
                    ipm.getText().isEmpty() ||
                    policyNumber.getText().isEmpty() ||
                    (otherOptions.isSelected() && otherOption.getText().isEmpty()) ||
                    (yesMed.isSelected() && yesMedsText.getText().isEmpty())) {
                viewAlert("Error In Submission", "Incomplete Entry of Information!");
            }
            else {
                viewAlert("Thank You","Form submitted Successfully!");
            }
        });
        submit.setStyle("-fx-background-color: #ED0431; -fx-text-fill: white; -fx-background-radius: 15px; -fx-padding: 5px 10px;");
        hBoxBtn.getChildren().add(submit);
        hBoxBtn.setAlignment(Pos.TOP_RIGHT);
        hBoxBtn.setPadding(new Insets(10, 0, 0, 0));

        //Show the elements
        grPane.add(fName_label, 0, 0);
        grPane.add(fName, 1, 0);
        grPane.add(dob_label, 0, 1);
        grPane.add(dob, 1, 1);
        grPane.add(pNumber_label, 0, 2);
        grPane.add(pNumber, 1, 2);
        grPane.add(rsonvisit_label, 0, 3);
        grPane.add(reasonVisit, 1, 3);
        grPane.add(cSymptoms_label, 0, 4);
        grPane.add(cSymptoms, 1, 4);

        grPane.add(medicalhistory_label, 0, 5);
        grPane.add(hbp, 1, 5);
        grPane.add(diabetes, 1, 6);
        grPane.add(asthma, 1, 7);
        grPane.add(heartDisease, 1, 8);
        grPane.add(epilepsy, 1, 9);
        grPane.add(otherOptions, 1, 10);

        grPane.add(medQn_label, 0, 12);
        grPane.add(medsHbox, 1, 12);
        grPane.add(smokeQn_label, 0, 14);
        grPane.add(smokeHbox, 1, 14);
        grPane.add(alcoholQn_label, 0, 15);
        grPane.add(alcoholHbox, 1, 15);
        grPane.add(ipm_label, 0, 16);
        grPane.add(ipm, 1, 16);
        grPane.add(policynumber_label, 0, 17);
        grPane.add(policyNumber, 1, 17);
        grPane.add(hBoxBtn,1,18);

        for (int i = 0; i < grPane.getChildren().size(); i++) {
            var node = grPane.getChildren().get(i);
            if (node instanceof Label) {
                node.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
            }
        }

        nestedVbox.getChildren().addAll(fPane,grPane);
        vbox.getChildren().addAll(nestedVbox);

        Scene scene = new Scene(vbox, 650, 750);
        stage.setTitle("Medical Form");
        stage.setScene(scene);
        stage.show();
    }

    private void viewAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}
