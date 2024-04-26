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
import java.time.LocalDateTime;

public class BuildingMenu extends Application {
@Override
	public void start(Stage mainStage) throws Exception{
	//Setting up grid Pane for layout management of frame
	
	MenuCreation menus = new MenuCreation();
	menus.MenuInfo();

	

	Scene scene = new Scene(menus.gridPane,600,600,Color.GREY);
	mainStage.setTitle("What is the Time and Date?");
	mainStage.setScene(scene);
	mainStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}