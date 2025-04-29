package Exercise34_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import java.sql.*;

public class Exercise34_1 extends Application {
    //create private fields (textfields and labels)
    private TextField idTextField = new TextField();
    private TextField lastNameTextField = new TextField();
    private TextField firstNameTextField = new TextField();
    private TextField miTextField = new TextField();
    private TextField addressTextField = new TextField();
    private TextField cityTextField = new TextField();
    private TextField stateTextField = new TextField();
    private TextField telephoneTextField = new TextField();

    private Label updateLabel = new Label();

    private Connection connection;

    @Override
    public void start(Stage primaryStage){
        //initialize database connection
        initializeDB();

        //create labels, buttons, textfields
        VBox vbox = new VBox();
        updateLabel = new Label("Record Test"); //update to show (Record found) or (Record not found)

        //create ID row
        HBox idHbox = new HBox();
        Label idLabel = new Label("ID");
        idHbox.getChildren().addAll(idLabel, idTextField);

        //create hbox for name row (Last Name Label, TextField, First Name Label, TextField, MI Label, TextField)
        HBox hboxname = new HBox();
        Label firstNameLabel = new Label("First Name");
        Label lastNameLabel = new Label("Last Name");
        Label middleinitialLabel = new Label("MI");
        hboxname.getChildren().addAll(lastNameLabel, lastNameTextField, firstNameLabel, firstNameTextField, middleinitialLabel, miTextField);

        //create street address line
        HBox hboxaddress = new HBox();
        Label addressLabel = new Label("Address");
        hboxaddress.getChildren().addAll(addressLabel, addressTextField);

        //create hbox for city and state
        HBox hboxcitystate = new HBox();
        Label cityLabel = new Label("City");
        Label stateLabel = new Label("State");
        hboxcitystate.getChildren().addAll(cityLabel, cityTextField, stateLabel, stateTextField);

        //create phone number label and textfield
        HBox hboxphone = new HBox();
        Label telephoneLabel = new Label("Telephone");
        hboxphone.getChildren().addAll(telephoneLabel, telephoneTextField);

        //create gridpane with 4 buttons and 2 empty spaces
        GridPane gridpane = new GridPane();
        Button viewButton = new Button("View");
        Button insertButton = new Button("Insert");
        Button updateButton = new Button("Update");
        Button clearButton = new Button("Clear");

        ColumnConstraints col0 = new ColumnConstraints(100);
        gridpane.getColumnConstraints().add(col0);

        gridpane.add(viewButton, 1, 0);
        gridpane.add(insertButton, 2, 0);
        gridpane.add(updateButton, 3, 0);
        gridpane.add(clearButton, 4, 0);

        //assemble all rows into vbox
        vbox.getChildren().addAll(updateLabel, idHbox, hboxname, hboxaddress, hboxcitystate, hboxphone, gridpane);

        //create scene and place it in stage
        Scene scene = new Scene(vbox, 600, 300);
        primaryStage.setTitle("Exercise34_1");
        primaryStage.setScene(scene);
        primaryStage.show();

        //button actions
        viewButton.setOnAction(e -> viewStaff());
        insertButton.setOnAction(e -> insertStaff());
        updateButton.setOnAction(e -> updateStaff());
        clearButton.setOnAction(e -> clearFields());
    }
    //intialize connection to DB
    private void initializeDB() {
        try {
            //load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //establish connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            System.out.println("Database connected");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //logic for viewStaff button
    private void viewStaff() {
        try {
            //view staff information
            String query = "SELECT * FROM staff WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, idTextField.getText().trim());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                lastNameTextField.setText(resultSet.getString("lastName"));
                firstNameTextField.setText(resultSet.getString("firstName"));
                miTextField.setText(resultSet.getString("mi"));
                addressTextField.setText(resultSet.getString("address"));
                cityTextField.setText(resultSet.getString("city"));
                stateTextField.setText(resultSet.getString("state"));
                telephoneTextField.setText(resultSet.getString("telephone"));
                updateLabel.setText("Record Found");
            } else {
                updateLabel.setText("Record Not Found");
            }

            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //logic for insertStaff button
    private void insertStaff() {
        try {
            //insert staff information
            String query = "INSERT INTO Staff (id, lastName, firstName, mi, address, city, state, telephone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, idTextField.getText().trim());
            statement.setString(2, lastNameTextField.getText().trim());
            statement.setString(3, firstNameTextField.getText().trim());
            statement.setString(4, miTextField.getText().trim());
            statement.setString(5, addressTextField.getText().trim());
            statement.setString(6, cityTextField.getText().trim());
            statement.setString(7, stateTextField.getText().trim());
            statement.setString(8, telephoneTextField.getText().trim());

            statement.executeUpdate();
            updateLabel.setText("Record Inserted");
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //logic for updateStaff button
    private void updateStaff() {
        try {
            //update staff information
            String query = "UPDATE Staff SET lastName=?, firstName=?, mi=?, address=?, city=?, state=?, telephone=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, lastNameTextField.getText().trim());
            statement.setString(2, firstNameTextField.getText().trim());
            statement.setString(3, miTextField.getText().trim());
            statement.setString(4, addressTextField.getText().trim());
            statement.setString(5, cityTextField.getText().trim());
            statement.setString(6, stateTextField.getText().trim());
            statement.setString(7, telephoneTextField.getText().trim());
            statement.setString(8, idTextField.getText().trim());

            statement.executeUpdate();
            updateLabel.setText("Record Updated");
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //clearFields button logic
    private void clearFields() {
        //clear all text fields
        idTextField.clear();
        lastNameTextField.clear();
        firstNameTextField.clear();
        miTextField.clear();
        addressTextField.clear();
        cityTextField.clear();
        stateTextField.clear();
        telephoneTextField.clear();
        updateLabel.setText("");
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
