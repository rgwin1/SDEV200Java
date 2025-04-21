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
        Image china = new Image("Images/china.gif");
        ImageView chinaIV = new ImageView();
        chinaIV.setImage(china);
        chinaIV.setFitWidth(150);
        chinaIV.setFitHeight(100);
        chinaIV.setPreserveRatio(true);
        //create and set turkey?
        Image france = new Image("Images/france.gif");
        ImageView franceIV = new ImageView();
        franceIV.setImage(france);
        franceIV.setFitWidth(150);
        franceIV.setFitHeight(100);
        franceIV.setPreserveRatio(true);
        //create and set US?
        Image unitedS = new Image("Images/us.gif");
        ImageView unitedSIV = new ImageView();
        unitedSIV.setImage(unitedS);
        unitedSIV.setFitWidth(150);
        unitedSIV.setFitHeight(100);
        unitedSIV.setPreserveRatio(true);
        //created and set uk
        Image unitedK = new Image("Images/uk.gif");
        ImageView unitedKIV = new ImageView();
        unitedKIV.setImage(unitedK);
        unitedKIV.setFitWidth(150);
        unitedKIV.setFitHeight(100);
        unitedKIV.setPreserveRatio(true);
        //add images to gridpane?
        gridpane.add(unitedKIV, 0, 0);
        gridpane.add(chinaIV, 1, 0);
        gridpane.add(franceIV, 0, 1);
        gridpane.add(unitedSIV, 1, 1);
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
