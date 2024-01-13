package view;

import dao.Dao;
import entity.Guanliyuan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * GuanliyuanRegistUI 类是管理员注册界面的用户界面类。
 */
public class GuanliyuanRegistUI extends AnchorPane {

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

	// 数据访问对象和可观察列表，用于管理管理员信息
	Dao<Guanliyuan> table_1356948dao = new Dao(new Guanliyuan());
	ObservableList<Guanliyuan> table_1356948data = FXCollections.observableArrayList();

	/**
	 * GuanliyuanRegistUI 类的构造方法，接收主界面ID作为参数。
	 * @param param 主界面ID参数
	 */
	public GuanliyuanRegistUI(String param) {
		this.mainid = param;

		// 创建用户名标签和文本框
		Label label_1239083 = new Label("用户名");
		label_1239083.setFont(new Font("宋体", 14));
		label_1239083.setPrefWidth(Double.valueOf(100));
		label_1239083.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1239083, Double.valueOf(150));
		this.setTopAnchor(label_1239083, Double.valueOf(60));
		this.getChildren().add(label_1239083);

		TextField textField_1569074 = new TextField();
		textField_1569074.setFont(new Font("宋体", 14));
		textField_1569074.setPrefWidth(Double.valueOf(93));
		textField_1569074.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1569074, Double.valueOf(220));
		this.setTopAnchor(textField_1569074, Double.valueOf(60));
		this.getChildren().add(textField_1569074);

		// 创建密码标签和文本框
		Label label_1253859 = new Label("密码");
		label_1253859.setFont(new Font("宋体", 14));
		label_1253859.setPrefWidth(Double.valueOf(100));
		label_1253859.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1253859, Double.valueOf(370));
		this.setTopAnchor(label_1253859, Double.valueOf(60));
		this.getChildren().add(label_1253859);

		TextField textField_1485832 = new TextField();
		textField_1485832.setFont(new Font("宋体", 14));
		textField_1485832.setPrefWidth(Double.valueOf(93));
		textField_1485832.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1485832, Double.valueOf(440));
		this.setTopAnchor(textField_1485832, Double.valueOf(60));
		this.getChildren().add(textField_1485832);

		// 创建管理员信息表格视图
		TableView table_1356948 = new TableView();
		table_1356948.setPrefWidth(Double.valueOf(0));
		table_1356948.setPrefHeight(Double.valueOf(0));
		table_1356948.setMaxWidth(Double.valueOf(0));
		table_1356948.setMaxHeight(Double.valueOf(0));
		table_1356948.setMinWidth(Double.valueOf(0));
		table_1356948.setMinHeight(Double.valueOf(0));
		this.setLeftAnchor(table_1356948, Double.valueOf(0));
		this.setTopAnchor(table_1356948, Double.valueOf(0));

		// 设置表格列和数据
		TableColumn table_1356948id = new TableColumn("编号");
		table_1356948id.setCellValueFactory(new PropertyValueFactory<>("id"));
		table_1356948.getColumns().add(table_1356948id);

		TableColumn table_13569480 = new TableColumn("用户名");
		table_13569480.setCellValueFactory(new PropertyValueFactory<>("yonghuming"));
		table_1356948.getColumns().add(table_13569480);

		TableColumn table_13569481 = new TableColumn("密码");
		table_13569481.setCellValueFactory(new PropertyValueFactory<>("mima"));
		table_1356948.getColumns().add(table_13569481);

		table_1356948.setItems(table_1356948data);
		this.getChildren().add(table_1356948);

		// 刷新表格数据
		table_1356948refresh();

		// 创建注册按钮
		Button btn_1315462 = new Button("注册");
		btn_1315462.setFont(new Font("宋体", 14));
		btn_1315462.setPrefWidth(Double.valueOf(93));
		btn_1315462.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1315462, Double.valueOf(200));
		this.setTopAnchor(btn_1315462, Double.valueOf(350));

		// 为注册按钮添加点击事件处理器
		btn_1315462.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Guanliyuan bean = new Guanliyuan();
				bean.setYonghuming(textField_1569074.getText());
				bean.setMima(textField_1485832.getText());
				table_1356948dao.add(bean);
				showMsg("新增成功");
				table_1356948refresh();
			}
		});
		this.getChildren().add(btn_1315462);

		// 创建关闭按钮
		Button btn_1422456 = new Button("关闭");
		btn_1422456.setFont(new Font("宋体", 14));
		btn_1422456.setPrefWidth(Double.valueOf(93));
		btn_1422456.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1422456, Double.valueOf(300));
		this.setTopAnchor(btn_1422456, Double.valueOf(350));

		// 为关闭按钮添加点击事件处理器
		btn_1422456.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
			}
		});
		this.getChildren().add(btn_1422456);

		// 为表格视图添加鼠标点击事件处理器
		table_1356948.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = table_1356948.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
				Guanliyuan bean = (Guanliyuan) table_1356948.getSelectionModel().getSelectedItems().get(0);
				textField_1569074.setText(bean.getYonghuming());
				textField_1485832.setText(bean.getMima());
			};
		});

		// 刷新表格数据
		table_1356948refresh();
	}

	/**
	 * 刷新管理员信息表格数据。
	 */
	public void table_1356948refresh() {
		table_1356948data.clear();
		table_1356948data.addAll(table_1356948dao.getAll());
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
