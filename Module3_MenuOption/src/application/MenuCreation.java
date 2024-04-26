package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javafx.geometry.Insets;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MenuCreation {
	final Text InfoDisplayed = new Text();
	final Text currentTime = new Text();
	HBox hBox =new HBox();
	GridPane gridPane = new GridPane();
	public void MenuInfo() {
	//Creating Menu items and text
		

		InfoDisplayed.setText("Select First menu option to display current Date and Time");//Initial text
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
			InfoDisplayed.setText("Select First menu option to display current Date and Time");
			//Randomizing red and blue to get different greens
			Random random1 = new Random();
			int blue = random1.nextInt(128);
			int red = random1.nextInt(191);
		
			gridPane.setBackground(new Background(new BackgroundFill(Color.rgb(red, 255, blue), new CornerRadii(0), new Insets(0))));
		});

		MenuButton menuButton = new MenuButton("Option Selection", null, menuItem1, menuItem2, menuItem3);
		hBox.getChildren().add(menuButton); 
		gridPane.add(InfoDisplayed, 1, 10);
		gridPane.add(currentTime, 1, 20);
		gridPane.add(hBox, 0, 0);
		gridPane.setBackground(new Background(new BackgroundFill(Color.rgb(140, 200, 140), new CornerRadii(0), new Insets(0))));
	}
}
