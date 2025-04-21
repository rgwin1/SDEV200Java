import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise16_17 extends Application {
    @Override
    public void start(Stage primaryStage) {
        //text
        Text text = new Text("Show Colors");
        text.setStyle("-fx-font-size: 24");

        //scroll bars
        ScrollBar sbRed = new ScrollBar();
        ScrollBar sbGreen = new ScrollBar();
        ScrollBar sbBlue = new ScrollBar();
        ScrollBar sbOpacity = new ScrollBar();

        sbRed.setMax(255);
        sbGreen.setMax(255);
        sbBlue.setMax(255);
        sbOpacity.setMax(1);
        sbOpacity.setBlockIncrement(0.01);

        sbRed.setValue(0);
        sbGreen.setValue(0);
        sbBlue.setValue(0);
        sbOpacity.setValue(1);

        //labels
        Label lblRed = new Label("Red");
        Label lblGreen = new Label("Green");
        Label lblBlue = new Label("Blue");
        Label lblOpacity = new Label("Opacity");

        //grid for labels and sliders
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        grid.add(lblRed, 0, 0);
        grid.add(sbRed, 1, 0);
        grid.add(lblGreen, 0, 1);
        grid.add(sbGreen, 1, 1);
        grid.add(lblBlue, 0, 2);
        grid.add(sbBlue, 1, 2);
        grid.add(lblOpacity, 0, 3);
        grid.add(sbOpacity, 1, 3);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(80);
        grid.getColumnConstraints().addAll(col1, col2);

        //layout
        VBox layout = new VBox(20, text, grid);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.TOP_CENTER);

        //update color
        Runnable updateColor = () -> {
            Color color = Color.rgb(
                (int) sbRed.getValue(),
                (int) sbGreen.getValue(),
                (int) sbBlue.getValue(),
                sbOpacity.getValue()
            );
            text.setFill(color);
        };

        sbRed.valueProperty().addListener(e -> updateColor.run());
        sbGreen.valueProperty().addListener(e -> updateColor.run());
        sbBlue.valueProperty().addListener(e -> updateColor.run());
        sbOpacity.valueProperty().addListener(e -> updateColor.run());

        //scene
        Scene scene = new Scene(layout, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_17");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
