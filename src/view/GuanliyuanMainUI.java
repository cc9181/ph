package view;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;

import java.util.*;

import javafx.util.Callback;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Alert.AlertType;

import java.text.SimpleDateFormat;

import javafx.event.EventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
/**
 * GuanliyuanMainUI 类是管理员主界面的用户界面类。
 */
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * GuanliyuanMainUI 类是管理员主界面的用户界面类。
 */
public class GuanliyuanMainUI extends AnchorPane {

	// 成员变量，用于存储用户名和主界面ID
	private String username;
	private String mainid;

	/**
	 * 获取用户名。
	 * @return 用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置用户名。
	 * @param username 要设置的用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取主界面ID。
	 * @return 主界面ID
	 */
	public String getMainid() {
		return mainid;
	}

	/**
	 * 设置主界面ID。
	 * @param mainid 要设置的主界面ID
	 */
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}

	/**
	 * GuanliyuanMainUI 类的构造方法，接收主界面ID作为参数。
	 * @param param 主界面ID参数
	 */
	public GuanliyuanMainUI(String param) {
		// 加载 CSS 文件
		this.mainid = param;
		this.getStyleClass().add("background-pane");

		// 创建管理员管理按钮，设置样式和布局
		Button btn_1702854 = new Button("管理员管理");
		btn_1702854.setFont(new Font("楷体", 20));
		btn_1702854.setPrefWidth(Double.valueOf(180));
		btn_1702854.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(btn_1702854, Double.valueOf(200));
		this.setTopAnchor(btn_1702854, Double.valueOf(10));

		// 为管理员管理按钮添加点击事件处理器
		btn_1702854.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				// 创建新的舞台，显示管理员管理界面
				Stage stage = new Stage();
				stage.setTitle("管理员管理");
				stage.setScene(new Scene(new GuanliyuanManageUI(""), 1200, 730));
				stage.show();
			}
		});
		this.getChildren().add(btn_1702854);

		// 创建读者管理按钮，设置样式和布局
		Button btn_17660 = new Button("读者管理");
		btn_17660.setFont(new Font("楷体", 20));
		btn_17660.setPrefWidth(Double.valueOf(180));
		btn_17660.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(btn_17660, Double.valueOf(200));
		this.setTopAnchor(btn_17660, Double.valueOf(60));

		// 为读者管理按钮添加点击事件处理器
		btn_17660.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				// 创建新的舞台，显示读者管理界面
				Stage stage = new Stage();
				stage.setTitle("读者管理");
				stage.setScene(new Scene(new DuzheManageUI(""), 1200, 730));
				stage.show();
			}
		});
		this.getChildren().add(btn_17660);

		// 创建阅览室管理按钮，设置样式和布局
		Button btn_1580924 = new Button("阅览室管理");
		btn_1580924.setFont(new Font("楷体", 20));
		btn_1580924.setPrefWidth(Double.valueOf(180));
		btn_1580924.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(btn_1580924, Double.valueOf(200));
		this.setTopAnchor(btn_1580924, Double.valueOf(110));

		// 为阅览室管理按钮添加点击事件处理器
		btn_1580924.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				// 创建新的舞台，显示阅览室管理界面
				Stage stage = new Stage();
				stage.setTitle("阅览室管理");
				stage.setScene(new Scene(new YuelanshiManageUI(""), 1200, 730));
				stage.show();
			}
		});
		this.getChildren().add(btn_1580924);

		// 创建座位预定管理按钮，设置样式和布局
		Button btn_1277399 = new Button("座位预定管理");
		btn_1277399.setFont(new Font("楷体", 20));
		btn_1277399.setPrefWidth(Double.valueOf(180));
		btn_1277399.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(btn_1277399, Double.valueOf(200));
		this.setTopAnchor(btn_1277399, Double.valueOf(160));

		// 为座位预定管理按钮添加点击事件处理器
		btn_1277399.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				// 创建新的舞台，显示座位预定管理界面
				Stage stage = new Stage();
				stage.setTitle("座位预定管理");
				stage.setScene(new Scene(new ZuoweiyudingManageUI(""), 1200, 730));
				stage.show();
			}
		});
		this.getChildren().add(btn_1277399);

		// 创建退出按钮，设置样式和布局
		Button btn_1631070 = new Button("退出");
		btn_1631070.setFont(new Font("楷体", 20));
		btn_1631070.setPrefWidth(Double.valueOf(180));
		btn_1631070.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(btn_1631070, Double.valueOf(200));
		this.setTopAnchor(btn_1631070, Double.valueOf(210));

		// 为退出按钮添加点击事件处理器，退出程序
		btn_1631070.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});
		this.getChildren().add(btn_1631070);
	}

	/**
	 * 显示信息的方法。
	 * @param msg 要显示的信息
	 */
	public void showMsg(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.titleProperty().set("提示");
		alert.headerTextProperty().set(msg);
		alert.showAndWait();
	}
}
