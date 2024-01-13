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
 * YuelanshiAddUI 类是阅览室信息添加界面的用户界面类。
 */
public class YuelanshiAddUI extends AnchorPane {

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
	Dao<Yuelanshi> table_1892880dao = new Dao(new Yuelanshi());
	ObservableList<Yuelanshi> table_1892880data = FXCollections.observableArrayList();

	/**
	 * YuelanshiAddUI 类的构造方法，接收主界面ID作为参数。
	 * @param param 主界面ID参数
	 */
	public YuelanshiAddUI(String param) {
		this.mainid = param;

		// 创建名称标签和文本框
		Label label_1386089 = new Label("名称");
		label_1386089.setFont(new Font("宋体", 14));
		label_1386089.setPrefWidth(Double.valueOf(100));
		label_1386089.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1386089, Double.valueOf(150));
		this.setTopAnchor(label_1386089, Double.valueOf(60));
		this.getChildren().add(label_1386089);

		TextField textField_110169 = new TextField();
		textField_110169.setFont(new Font("宋体", 14));
		textField_110169.setPrefWidth(Double.valueOf(93));
		textField_110169.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_110169, Double.valueOf(220));
		this.setTopAnchor(textField_110169, Double.valueOf(60));
		this.getChildren().add(textField_110169);

		// 创建阅览室信息表格视图
		TableView table_1892880 = new TableView();
		table_1892880.setPrefWidth(Double.valueOf(0));
		table_1892880.setPrefHeight(Double.valueOf(0));
		table_1892880.setMaxWidth(Double.valueOf(0));
		table_1892880.setMaxHeight(Double.valueOf(0));
		table_1892880.setMinWidth(Double.valueOf(0));
		table_1892880.setMinHeight(Double.valueOf(0));
		this.setLeftAnchor(table_1892880, Double.valueOf(0));
		this.setTopAnchor(table_1892880, Double.valueOf(0));

		// 设置表格列和数据
		TableColumn table_1892880id = new TableColumn("编号");
		table_1892880id.setCellValueFactory(new PropertyValueFactory<>("id"));
		table_1892880.getColumns().add(table_1892880id);

		TableColumn table_18928800 = new TableColumn("名称");
		table_18928800.setCellValueFactory(new PropertyValueFactory<>("mingcheng"));
		table_1892880.getColumns().add(table_18928800);

		table_1892880.setItems(table_1892880data);
		this.getChildren().add(table_1892880);

		// 刷新表格数据
		table_1892880refresh();

		// 创建保存按钮
		Button btn_1453348 = new Button("保存");
		btn_1453348.setFont(new Font("宋体", 14));
		btn_1453348.setPrefWidth(Double.valueOf(93));
		btn_1453348.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1453348, Double.valueOf(200));
		this.setTopAnchor(btn_1453348, Double.valueOf(350));

		// 为保存按钮添加点击事件处理器
		btn_1453348.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Yuelanshi bean = new Yuelanshi();
				bean.setMingcheng(textField_110169.getText());
				table_1892880dao.add(bean);
				showMsg("新增成功");
				table_1892880refresh();
			}
		});
		this.getChildren().add(btn_1453348);

		// 创建关闭按钮
		Button btn_1185060 = new Button("关闭");
		btn_1185060.setFont(new Font("宋体", 14));
		btn_1185060.setPrefWidth(Double.valueOf(93));
		btn_1185060.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1185060, Double.valueOf(300));
		this.setTopAnchor(btn_1185060, Double.valueOf(350));

		// 为关闭按钮添加点击事件处理器
		btn_1185060.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
			}
		});
		this.getChildren().add(btn_1185060);

		// 为表格视图添加鼠标点击事件处理器
		table_1892880.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = table_1892880.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
				Yuelanshi bean = (Yuelanshi) table_1892880.getSelectionModel().getSelectedItems().get(0);
				textField_110169.setText(bean.getMingcheng());
			};
		});

		// 刷新表格数据
		table_1892880refresh();
	}

	/**
	 * 刷新阅览室信息表格数据。
	 */
	public void table_1892880refresh() {
		table_1892880data.clear();
		table_1892880data.addAll(table_1892880dao.getAll());
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