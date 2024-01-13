package view;

// 导入dao包，实现数据访问
import dao.*;
// 导入entity包，实现实体类的操作
import entity.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javafx.stage.FileChooser;
// 导入事件相关类
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

// 定义GuanliyuanAddUI类
public class GuanliyuanAddUI extends AnchorPane {

	// 定义mainid属性
	private String mainid;
	// 获取mainid属性值
	public String getMainid() {
		return mainid;
	}
	// 设置mainid属性值
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	// 创建Dao实例
	Dao<Guanliyuan> table_1768929dao = new Dao(new Guanliyuan());
	// 创建可观察的列表
	ObservableList<Guanliyuan> table_1768929data = FXCollections.observableArrayList();
	// 构造方法
	public GuanliyuanAddUI(String param) {
		// 设置mainid属性值
		this.mainid=param;
		// 创建标签
		Label label_1666256=new Label("用户名");
		// 设置标签字体
		label_1666256.setFont(new Font("宋体", 14));
		label_1666256.setPrefWidth(Double.valueOf(100));
		label_1666256.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1666256, Double.valueOf(150));
		this.setTopAnchor(label_1666256, Double.valueOf(60));
		this.getChildren().add(label_1666256);
		// 创建文本框
		TextField textField_1613747 = new TextField();
		// 设置文本框字体
		textField_1613747.setFont(new Font("宋体", 14));
		textField_1613747.setPrefWidth(Double.valueOf(93));
		textField_1613747.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1613747, Double.valueOf(220));
		this.setTopAnchor(textField_1613747, Double.valueOf(60));
		this.getChildren().add(textField_1613747);
		// 创建标签
		Label label_1836241=new Label("密码");
		// 设置标签字体
		label_1836241.setFont(new Font("宋体", 14));
		label_1836241.setPrefWidth(Double.valueOf(100));
		label_1836241.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1836241, Double.valueOf(370));
		this.setTopAnchor(label_1836241, Double.valueOf(60));
		this.getChildren().add(label_1836241);
		// 创建文本框
		TextField textField_1572537 = new TextField();
		// 设置文本框字体
		textField_1572537.setFont(new Font("宋体", 14));
		textField_1572537.setPrefWidth(Double.valueOf(93));
		textField_1572537.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1572537, Double.valueOf(440));
		this.setTopAnchor(textField_1572537, Double.valueOf(60));
		this.getChildren().add(textField_1572537);
		// 创建表格视图
		TableView table_1768929=new TableView();
		// 设置表格视图尺寸
		table_1768929.setPrefWidth(Double.valueOf(0));
		table_1768929.setPrefHeight(Double.valueOf(0));
		table_1768929.setMaxWidth(Double.valueOf(0));
		table_1768929.setMaxHeight(Double.valueOf(0));
		table_1768929.setMinWidth(Double.valueOf(0));
		table_1768929.setMinHeight(Double.valueOf(0));
		this.setLeftAnchor(table_1768929, Double.valueOf(0));
		this.setTopAnchor(table_1768929, Double.valueOf(0));
		// 创建表格列
		TableColumn table_1768929id=new TableColumn("编号");
		table_1768929id.setCellValueFactory(new PropertyValueFactory<>("id"));
		table_1768929.getColumns().add(table_1768929id);
		TableColumn table_17689290=new TableColumn("用户名");
		table_17689290.setCellValueFactory(new PropertyValueFactory<>("yonghuming"));
		table_1768929.getColumns().add(table_17689290);
		TableColumn table_17689291=new TableColumn("密码");
		table_17689291.setCellValueFactory(new PropertyValueFactory<>("mima"));
		table_1768929.getColumns().add(table_17689291);
		// 将数据集与表格视图相关联
		table_1768929.setItems(table_1768929data);
		this.getChildren().add(table_1768929);
		// 刷新表格
		table_1768929refresh();
		// 创建保存按钮
		Button btn_1949632=new Button("保存");
		btn_1949632.setFont(new Font("宋体", 14));
		btn_1949632.setPrefWidth(Double.valueOf(93));
		btn_1949632.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1949632, Double.valueOf(200));
		this.setTopAnchor(btn_1949632, Double.valueOf(350));
		// 监听保存按钮
		btn_1949632.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Guanliyuan bean=new Guanliyuan();
				bean.setYonghuming(textField_1613747.getText());
				bean.setMima(textField_1572537.getText());
				table_1768929dao.add(bean);
				showMsg("新增成功");
				table_1768929refresh();

			}
		});
		this.getChildren().add(btn_1949632);
		// 创建关闭按钮
		Button btn_1462210=new Button("关闭");
		btn_1462210.setFont(new Font("宋体", 14));
		btn_1462210.setPrefWidth(Double.valueOf(93));
		btn_1462210.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1462210, Double.valueOf(300));
		this.setTopAnchor(btn_1462210, Double.valueOf(350));
		// 监听关闭按钮
		btn_1462210.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
			}
		});
		this.getChildren().add(btn_1462210);
		// 监听表格点击
		table_1768929.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = table_1768929.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
				Guanliyuan bean = (Guanliyuan)table_1768929.getSelectionModel().getSelectedItems().get(0);
				textField_1613747.setText(bean.getYonghuming());
				textField_1572537.setText(bean.getMima());

			};
		});
		// 刷新表格
		table_1768929refresh();

	}
	// 刷新表格数据
	public void table_1768929refresh(){
		table_1768929data.clear();
		table_1768929data.addAll(table_1768929dao.getAll());
	}
	// 显示消息
	public void showMsg(String msg){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.titleProperty().set("提示");
		alert.headerTextProperty().set(msg);
		alert.showAndWait();
	}
}
