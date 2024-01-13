package view;


import dao.*;
import entity.*;
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
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import javafx.util.Callback;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Alert.AlertType;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * YuelanshiManageUI 类是阅览室信息管理界面的用户界面类。
 */
public class YuelanshiManageUI extends AnchorPane {

	// 成员变量，用于存储主界面ID
	private String mainid;

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

	// 数据访问对象和可观察列表，用于管理阅览室信息
	Dao<Yuelanshi> table_1409865dao = new Dao(new Yuelanshi());
	ObservableList<Yuelanshi> table_1409865data = FXCollections.observableArrayList();

	/**
	 * YuelanshiManageUI 类的构造方法，接收主界面ID作为参数。
	 * @param param 主界面ID参数
	 */
	public YuelanshiManageUI(String param) {
		this.mainid = param;

		// 创建名称标签和文本框
		Label label_1393365 = new Label("名称");
		label_1393365.setFont(new Font("宋体", 14));
		label_1393365.setPrefWidth(Double.valueOf(100));
		label_1393365.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1393365, Double.valueOf(150));
		this.setTopAnchor(label_1393365, Double.valueOf(30));
		this.getChildren().add(label_1393365);

		TextField textField_114480 = new TextField();
		textField_114480.setFont(new Font("宋体", 14));
		textField_114480.setPrefWidth(Double.valueOf(93));
		textField_114480.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_114480, Double.valueOf(220));
		this.setTopAnchor(textField_114480, Double.valueOf(30));
		this.getChildren().add(textField_114480);

		// 创建阅览室信息表格视图
		TableView table_1409865 = new TableView();
		table_1409865.setPrefWidth(Double.valueOf(800));
		table_1409865.setPrefHeight(Double.valueOf(400));
		table_1409865.setMaxWidth(Double.valueOf(800));
		table_1409865.setMaxHeight(Double.valueOf(400));
		table_1409865.setMinWidth(Double.valueOf(800));
		table_1409865.setMinHeight(Double.valueOf(400));
		this.setLeftAnchor(table_1409865, Double.valueOf(190));
		this.setTopAnchor(table_1409865, Double.valueOf(145));

		// 设置表格列和数据
		TableColumn table_1409865id = new TableColumn("编号");
		table_1409865id.setCellValueFactory(new PropertyValueFactory<>("id"));
		table_1409865.getColumns().add(table_1409865id);

		TableColumn table_14098650 = new TableColumn("名称");
		table_14098650.setCellValueFactory(new PropertyValueFactory<>("mingcheng"));
		table_1409865.getColumns().add(table_14098650);

		table_1409865.setItems(table_1409865data);
		this.getChildren().add(table_1409865);

		// 刷新表格数据
		table_1409865refresh();

		// 创建新增按钮
		Button btn_1625399 = new Button("新增");
		btn_1625399.setFont(new Font("宋体", 14));
		btn_1625399.setPrefWidth(Double.valueOf(93));
		btn_1625399.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1625399, Double.valueOf(200));
		this.setTopAnchor(btn_1625399, Double.valueOf(100));

		// 为新增按钮添加点击事件处理器
		btn_1625399.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Stage stage = new Stage();
				stage.setTitle("新增");
				stage.setScene(new Scene(new YuelanshiAddUI(""), 600, 600));
				stage.show();
			}
		});
		this.getChildren().add(btn_1625399);

		// 创建修改按钮
		Button btn_1206470 = new Button("修改");
		btn_1206470.setFont(new Font("宋体", 14));
		btn_1206470.setPrefWidth(Double.valueOf(93));
		btn_1206470.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1206470, Double.valueOf(300));
		this.setTopAnchor(btn_1206470, Double.valueOf(100));

		// 为修改按钮添加点击事件处理器
		btn_1206470.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int row = table_1409865.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					showMsg("请选择一行");
					return;
				}
				Stage stage = new Stage();
				stage.setTitle("修改");
				stage.setScene(new Scene(new YuelanshiUpdateUI(String.valueOf(row)), 600, 600));
				stage.show();
			}
		});
		this.getChildren().add(btn_1206470);

		// 创建删除按钮
		Button btn_1465124 = new Button("删除");
		btn_1465124.setFont(new Font("宋体", 14));
		btn_1465124.setPrefWidth(Double.valueOf(93));
		btn_1465124.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1465124, Double.valueOf(400));
		this.setTopAnchor(btn_1465124, Double.valueOf(100));

		// 为删除按钮添加点击事件处理器
		btn_1465124.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int row = table_1409865.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					showMsg("请选择一行");
					return;
				}
				Yuelanshi bean = (Yuelanshi) table_1409865.getSelectionModel().getSelectedItems().get(0);
				table_1409865dao.delBykey("id", bean.getId().toString());
				showMsg("删除成功");
				table_1409865refresh();
			}
		});
		this.getChildren().add(btn_1465124);

		// 创建查询按钮
		Button btn_1188989 = new Button("查询");
		btn_1188989.setFont(new Font("宋体", 14));
		btn_1188989.setPrefWidth(Double.valueOf(93));
		btn_1188989.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1188989, Double.valueOf(500));
		this.setTopAnchor(btn_1188989, Double.valueOf(100));

		// 为查询按钮添加点击事件处理器
		btn_1188989.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Yuelanshi bean = new Yuelanshi();
				bean.setMingcheng(textField_114480.getText());
				table_1409865data.clear();
				table_1409865data.addAll(table_1409865dao.query(bean));
			}
		});
		this.getChildren().add(btn_1188989);

		// 创建重置按钮
		Button btn_180243 = new Button("重置");
		btn_180243.setFont(new Font("宋体", 14));
		btn_180243.setPrefWidth(Double.valueOf(93));
		btn_180243.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_180243, Double.valueOf(600));
		this.setTopAnchor(btn_180243, Double.valueOf(100));

		// 为重置按钮添加点击事件处理器
		btn_180243.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				textField_114480.setText("");
			}
		});
		this.getChildren().add(btn_180243);

		// 为表格视图添加鼠标点击事件处理器
		table_1409865.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = table_1409865.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
				Yuelanshi bean = (Yuelanshi) table_1409865.getSelectionModel().getSelectedItems().get(0);
				textField_114480.setText(bean.getMingcheng());
			};
		});

		// 刷新表格数据
		table_1409865refresh();
	}

	/**
	 * 刷新阅览室信息表格数据。
	 */
	public void table_1409865refresh() {
		table_1409865data.clear();
		table_1409865data.addAll(table_1409865dao.getAll());
	}

	/**
	 * 显示信息提示框。
	 * @param msg 要显示的信息
	 */
	public void showMsg(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.titleProperty().set("提示");
		alert.headerTextProperty().set(msg);
		alert.showAndWait();
	}
}