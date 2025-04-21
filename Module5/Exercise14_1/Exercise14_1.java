import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Exercise14_1 extends Application {
    @Override
    public void start (Stage primaryStage) {
        //create gridpane
        GridPane gridpane = new GridPane();
        //create and set china image?
        Image china = new Image("Images/china.jpg");
        ImageView chinaIV = new ImageView();
        chinaIV.setImage(china);
        //create and set turkey?
        Image turkey = new Image("Images/turkey.jpg");
        ImageView turkeyIV = new ImageView();
        turkeyIV.setImage(turkey);
        //create and set US?
        Image unitedS = new Image("Images/us.jpg");
        ImageView unitedSIV = new ImageView();
        unitedSIV.setImage(unitedS);
        //created and set uk
        Image unitedK = new Image("Images/uk.jpg");
        ImageView unitedKIV = new ImageView();
        unitedKIV.setImage(unitedK);
        //add images to gridpane?
        gridpane.add(chinaIV, 0, 0);
        gridpane.add(turkeyIV, 1, 0);
        gridpane.add(unitedSIV, 0, 1);
        gridpane.add(unitedKIV, 1, 1);
        //set gaps between columns and rows
        gridpane.setHgap(3.0);
        gridpane.setVgap(3.0);

        Scene scene = new Scene(gridpane);
        primaryStage.setTitle("Exercise14_1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}

//images folder didn't have a valid france flag, and I wasn't sure if i should use .gif extension
//I chose what I chose to complete the assignment.
