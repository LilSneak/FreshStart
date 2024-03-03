package application;

import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.MenuButton;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class BuildingMenu extends Application {
@Override
	public void start(Stage mainStage) throws Exception{
	//Setting up grid Pane for layout management of frame
	GridPane gridPane = new GridPane();
	//Creating Menu items and text
	final Text InfoDisplayed = new Text();
	final Text currentTime = new Text();

	InfoDisplayed.setText("Select Menu Option 1 to display current Date and Time");//Initial text
	MenuItem menuItem1 = new MenuItem("Display current Time + Date");
	MenuItem menuItem2 = new MenuItem("Save current Time + Date to File");
	MenuItem menuItem3 = new MenuItem("Change hue of background");
	
	//Actions for each menu option
	menuItem1.setOnAction(event -> {
		InfoDisplayed.setText("Current Date and Time: ");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		currentTime.setText(dtf.format(now));
	});
	
	menuItem2.setOnAction(event -> {
		InfoDisplayed.setText("Current Date and Time saved to file \"log.txt\" file");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			currentTime.setText(dtf.format(now));
			
		SaveToFile saver = new SaveToFile();
		saver.save(dtf.format(now));
		
	});

	menuItem3.setOnAction(event -> {
		InfoDisplayed.setText("Select Menu Option 1 to display current Date and Time");
		//Randomizing red and blue to get different greens
		Random random1 = new Random();
		int blue = random1.nextInt(128);
		int red = random1.nextInt(191);
	
		gridPane.setBackground(new Background(new BackgroundFill(Color.rgb(red, 255, blue), new CornerRadii(0), new Insets(0))));
	});

	MenuButton menuButton = new MenuButton("Option Selection", null, menuItem1, menuItem2, menuItem3);
	HBox hBox =new HBox(menuButton);

	gridPane.add(InfoDisplayed, 1, 10);
	gridPane.add(currentTime, 1, 20);
	gridPane.add(hBox, 0, 0);
	gridPane.setBackground(new Background(new BackgroundFill(Color.rgb(140, 200, 140), new CornerRadii(0), new Insets(0))));

	Scene scene = new Scene(gridPane,600,600,Color.GREY);
	mainStage.setTitle("What is the Time and Date?");
	mainStage.setScene(scene);
	mainStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}