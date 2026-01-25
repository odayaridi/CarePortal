package Controllers;

import com.example.assignment_i.MedForm;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainPage extends Application {

    @Override
    public void start(Stage stage) {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: #FFEFEF;");
        vbox.setSpacing(10);

        GridPane gPane = new GridPane();
        gPane.setAlignment(Pos.CENTER);
        gPane.setVgap(10);
        gPane.setHgap(10);

        FlowPane fPane1 = new FlowPane();
        fPane1.setHgap(5);
        fPane1.setAlignment(Pos.CENTER);

        FlowPane fPane2 = new FlowPane();
        fPane2.setHgap(5);
        fPane2.setAlignment(Pos.CENTER);


        Label username_label = new Label("Username:");
        Label password_label = new Label("Password:");
        Label email_label = new Label("Email:");
        TextField username = new TextField();
        PasswordField password = new PasswordField();
        TextField email = new TextField();
        Button enter = new Button("Enter");
        enter.setStyle("-fx-background-color: #ED0431; -fx-text-fill: white; -fx-background-radius: 12px; -fx-padding: 8px;");


        gPane.add(username_label, 0, 0);
        gPane.add(username, 1, 0);
        gPane.add(email_label, 0, 1);
        gPane.add(email, 1, 1);
        gPane.add(password_label, 0, 2);
        gPane.add(password, 1, 2);
        gPane.add(enter, 0, 3);

        for (int i = 0; i < 2; i++) {
            FlowPane currentPane;
            if(i==0){
                currentPane = fPane1;
            }
            else {
                currentPane = fPane2;
            }
            for (int j = 0; j < 3; j++) {
                ImageView imageView = new ImageView(new Image(getClass().getResource("/Images/image.png").toExternalForm()));
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);
                imageView.setPreserveRatio(true);
                currentPane.getChildren().add(imageView);
            }
        }

        enter.setOnAction(e -> {
            String em = email.getText();
            String usName = username.getText();
            String pass = password.getText();

            if (usName.isEmpty() || pass.isEmpty() || em.isEmpty()) {
                showAlert("Invalid Credentials", "Username, email, and password cannot be empty!");
            }

          else {
                showAlert("Success", "User registered successfully!");
                Stage mdFormStage = new Stage();
                MedForm medForm = new MedForm();
                medForm.start(mdFormStage);
                mdFormStage.setMaximized(true);
                stage.close();
            }
        });

        vbox.getChildren().addAll(fPane1, gPane, fPane2);

        Scene scene = new Scene(vbox, 600, 600);
        stage.setTitle("SerenePatientPortal");
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String title, String content) {
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
