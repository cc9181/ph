package view;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	public void start(Stage primaryStage) {
		try {
			GuanliyuanLoginUI root = new GuanliyuanLoginUI("");
			Scene scene = new Scene(root, 600, 600);

			// 加载 CSS 文件
			scene.getStylesheets().add("styles.css");

			// 应用样式类
			scene.getRoot().getStyleClass().add("background-pane");

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
