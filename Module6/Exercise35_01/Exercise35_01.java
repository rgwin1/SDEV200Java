package Exercise35_01;

//import JavaFX libraries for GUI components
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Modality;

//import JDBC libraries for database connection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//main application class
public class Exercise35_01 extends Application {
    //database connection object
    private Connection connection;
    //label to show connection or operation status
    private Label lblStatus = new Label("Batch update succeeded");
    //text area to display operation results
    private TextArea taResult = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        //create buttons for database connection and insert operations
        Button btConnect = new Button("Connect to Database");
        Button btBatch = new Button("Batch Update");
        Button btNonBatch = new Button("Non-Batch Update");

        //organize the top section with status label and connect button
        HBox topBox = new HBox(10, lblStatus, btConnect);
        //organize the bottom section with batch and non-batch buttons
        HBox bottomBox = new HBox(10, btBatch, btNonBatch);
        //main layout using BorderPane
        BorderPane mainPane = new BorderPane();
        mainPane.setTop(topBox);
        mainPane.setCenter(taResult);
        mainPane.setBottom(bottomBox);

        //set button actions
        btConnect.setOnAction(e -> showDBDialog());
        btBatch.setOnAction(e -> batchInsert());
        btNonBatch.setOnAction(e -> nonBatchInsert());

        //create and display the scene
        Scene scene = new Scene(mainPane, 400, 250);
        primaryStage.setTitle("Exercise35_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //method to show the database connection dialog
    private void showDBDialog() {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL); //make dialog modal
        dialog.setTitle("Connect to DB");

        //combo box for selecting JDBC driver
        ComboBox<String> cboDriver = new ComboBox<>();
        cboDriver.getItems().addAll("com.mysql.cj.jdbc.Driver");
        cboDriver.getSelectionModel().selectFirst();

        //combo box for selecting database URL
        ComboBox<String> cboURL = new ComboBox<>();
        cboURL.getItems().addAll("jdbc:mysql://localhost:3306/mysql");
        cboURL.getSelectionModel().selectFirst();

        //text field for username input
        TextField tfUsername = new TextField();
        //password field for password input
        PasswordField pfPassword = new PasswordField();

        //buttons for connecting and closing the dialog
        Button btConnectDB = new Button("Connect to DB");
        Button btClose = new Button("Close Dialog");

        //layout for input fields
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("JDBC Drive"), 0, 0);
        gridPane.add(cboDriver, 1, 0);
        gridPane.add(new Label("Database URL"), 0, 1);
        gridPane.add(cboURL, 1, 1);
        gridPane.add(new Label("Username"), 0, 2);
        gridPane.add(tfUsername, 1, 2);
        gridPane.add(new Label("Password"), 0, 3);
        gridPane.add(pfPassword, 1, 3);

        //layout for the dialog buttons
        HBox hBoxButtons = new HBox(10, btConnectDB, btClose);

        //overall layout combining connection information and buttons
        VBox vBox = new VBox(10, new Label("Connected to " + cboURL.getValue()), gridPane, hBoxButtons);

        //action for Connect to DB button
        btConnectDB.setOnAction(e -> {
            try {
                //load JDBC driver class
                Class.forName(cboDriver.getValue());
                //establish database connection
                connection = DriverManager.getConnection(
                        cboURL.getValue(),
                        tfUsername.getText(),
                        pfPassword.getText()
                );
                //close the dialog after successful connection
                dialog.close();
            } catch (Exception ex) {
                ex.printStackTrace(); //print exception stack trace if connection fails
            }
        });

        //action for Close Dialog button
        btClose.setOnAction(e -> dialog.close());

        //create and show the dialog scene
        Scene scene = new Scene(vBox, 400, 250);
        dialog.setScene(scene);
        dialog.showAndWait();
    }

    //method to perform batch insertion
    private void batchInsert() {
        //check if connected to database
        if (connection == null) {
            taResult.appendText("Not connected to database\n");
            return;
        }

        String sql = "insert into Temp (num1, num2, num3) values (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            long start = System.currentTimeMillis(); //start time measurement

            //add 1000 insert commands to batch
            for (int i = 0; i < 1000; i++) {
                pstmt.setDouble(1, Math.random());
                pstmt.setDouble(2, Math.random());
                pstmt.setDouble(3, Math.random());
                pstmt.addBatch();
            }

            pstmt.executeBatch(); //execute all commands at once
            long end = System.currentTimeMillis(); //end time measurement

            //display elapsed time
            taResult.appendText("Batch update completed\nThe elapsed time is " + (end - start) + "\n\n");
        } catch (SQLException ex) {
            ex.printStackTrace(); //print exception if insertion fails
        }
    }

    //method to perform non-batch insertion
    private void nonBatchInsert() {
        //check if connected to database
        if (connection == null) {
            taResult.appendText("Not connected to database\n");
            return;
        }

        String sql = "insert into Temp (num1, num2, num3) values (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            long start = System.currentTimeMillis(); //start time measurement

            //execute each insert individually
            for (int i = 0; i < 1000; i++) {
                pstmt.setDouble(1, Math.random());
                pstmt.setDouble(2, Math.random());
                pstmt.setDouble(3, Math.random());
                pstmt.executeUpdate();
            }

            long end = System.currentTimeMillis(); //end time measurement

            //display elapsed time
            taResult.appendText("Non-Batch update completed\nThe elapsed time is " + (end - start) + "\n\n");
        } catch (SQLException ex) {
            ex.printStackTrace(); //print exception if insertion fails
        }
    }

    //launch the application
    public static void main(String[] args) {
        launch(args);
    }
}
