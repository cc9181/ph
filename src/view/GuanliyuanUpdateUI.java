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
 * GuanliyuanUpdateUI 类是管理员信息修改界面的用户界面类。
 */
public class GuanliyuanUpdateUI extends AnchorPane {

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
	Dao<Guanliyuan> table_199564dao = new Dao(new Guanliyuan());
	ObservableList<Guanliyuan> table_199564data = FXCollections.observableArrayList();

	/**
	 * GuanliyuanUpdateUI 类的构造方法，接收主界面ID作为参数。
	 * @param param 主界面ID参数
	 */
	public GuanliyuanUpdateUI(String param) {
		this.mainid = param;

		// 创建用户名标签和文本框
		Label label_158072 = new Label("用户名");
		label_158072.setFont(new Font("宋体", 14));
		label_158072.setPrefWidth(Double.valueOf(100));
		label_158072.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_158072, Double.valueOf(150));
		this.setTopAnchor(label_158072, Double.valueOf(60));
		this.getChildren().add(label_158072);

		TextField textField_1919274 = new TextField();
		textField_1919274.setFont(new Font("宋体", 14));
		textField_1919274.setPrefWidth(Double.valueOf(93));
		textField_1919274.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1919274, Double.valueOf(220));
		this.setTopAnchor(textField_1919274, Double.valueOf(60));
		this.getChildren().add(textField_1919274);

		// 创建密码标签和文本框
		Label label_1819879 = new Label("密码");
		label_1819879.setFont(new Font("宋体", 14));
		label_1819879.setPrefWidth(Double.valueOf(100));
		label_1819879.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1819879, Double.valueOf(370));
		this.setTopAnchor(label_1819879, Double.valueOf(60));
		this.getChildren().add(label_1819879);

		TextField textField_1631440 = new TextField();
		textField_1631440.setFont(new Font("宋体", 14));
		textField_1631440.setPrefWidth(Double.valueOf(93));
		textField_1631440.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1631440, Double.valueOf(440));
		this.setTopAnchor(textField_1631440, Double.valueOf(60));
		this.getChildren().add(textField_1631440);

		// 创建管理员信息表格视图
		TableView table_199564 = new TableView();
		table_199564.setPrefWidth(Double.valueOf(0));
		table_199564.setPrefHeight(Double.valueOf(0));
		table_199564.setMaxWidth(Double.valueOf(0));
		table_199564.setMaxHeight(Double.valueOf(0));
		table_199564.setMinWidth(Double.valueOf(0));
		table_199564.setMinHeight(Double.valueOf(0));
		this.setLeftAnchor(table_199564, Double.valueOf(0));
		this.setTopAnchor(table_199564, Double.valueOf(0));

		// 设置表格列和数据
		TableColumn table_199564id = new TableColumn("编号");
		table_199564id.setCellValueFactory(new PropertyValueFactory<>("id"));
		table_199564.getColumns().add(table_199564id);

		TableColumn table_1995640 = new TableColumn("用户名");
		table_1995640.setCellValueFactory(new PropertyValueFactory<>("yonghuming"));
		table_199564.getColumns().add(table_1995640);

		TableColumn table_1995641 = new TableColumn("密码");
		table_1995641.setCellValueFactory(new PropertyValueFactory<>("mima"));
		table_199564.getColumns().add(table_1995641);

		table_199564.setItems(table_199564data);
		this.getChildren().add(table_199564);

		// 刷新表格数据
		table_199564refresh();

		// 创建保存按钮
		Button btn_1601016 = new Button("保存");
		btn_1601016.setFont(new Font("宋体", 14));
		btn_1601016.setPrefWidth(Double.valueOf(93));
		btn_1601016.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1601016, Double.valueOf(200));
		this.setTopAnchor(btn_1601016, Double.valueOf(350));

		// 为保存按钮添加点击事件处理器
		btn_1601016.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Guanliyuan bean = table_199564data.get(Integer.valueOf(param));
				bean.setYonghuming(textField_1919274.getText());
				bean.setMima(textField_1631440.getText());
				table_199564dao.update(bean);
				showMsg("修改成功");
			}
		});
		this.getChildren().add(btn_1601016);

		// 创建关闭按钮
		Button btn_1303215 = new Button("关闭");
		btn_1303215.setFont(new Font("宋体", 14));
		btn_1303215.setPrefWidth(Double.valueOf(93));
		btn_1303215.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1303215, Double.valueOf(300));
		this.setTopAnchor(btn_1303215, Double.valueOf(350));

		// 为关闭按钮添加点击事件处理器
		btn_1303215.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
			}
		});
		this.getChildren().add(btn_1303215);

		// 为表格视图添加鼠标点击事件处理器
		table_199564.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = table_199564.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
				Guanliyuan bean = (Guanliyuan) table_199564.getSelectionModel().getSelectedItems().get(0);
				textField_1919274.setText(bean.getYonghuming());
				textField_1631440.setText(bean.getMima());
			};
		});

		// 刷新表格数据
		table_199564refresh();

		Guanliyuan bean = table_199564data.get(Integer.valueOf(param));
		textField_1919274.setText(bean.getYonghuming());
		textField_1631440.setText(bean.getMima());
	}

	/**
	 * 刷新管理员信息表格数据。
	 */
	public void table_199564refresh() {
		table_199564data.clear();
		table_199564data.addAll(table_199564dao.getAll());
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
