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

public class DuzheUpdateUI extends AnchorPane {

	private String mainid;
	public String getMainid() {
		return mainid;
	}
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	Dao<Duzhe> table_1303779dao = new Dao(new Duzhe());
	// 创建可观察的读者列表
	ObservableList<Duzhe> table_1303779data = FXCollections.observableArrayList();
	public DuzheUpdateUI(String param) {
		this.mainid=param;
		// 创建一个名为“姓名”的标签
		Label label_1797514=new Label("姓名");
		label_1797514.setFont(new Font("宋体", 14));
		label_1797514.setPrefWidth(Double.valueOf(100));
		label_1797514.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1797514, Double.valueOf(150));
		this.setTopAnchor(label_1797514, Double.valueOf(60));
		this.getChildren().add(label_1797514);
		// 创建一个用于输入姓名的文本框
		TextField textField_1978880 = new TextField();
		// 设置文本框字体
		textField_1978880.setFont(new Font("宋体", 14));
		textField_1978880.setPrefWidth(Double.valueOf(93));
		textField_1978880.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1978880, Double.valueOf(220));
		this.setTopAnchor(textField_1978880, Double.valueOf(60));
		this.getChildren().add(textField_1978880);
		Label label_1552824=new Label("年龄");
		label_1552824.setFont(new Font("宋体", 14));
		label_1552824.setPrefWidth(Double.valueOf(100));
		label_1552824.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1552824, Double.valueOf(370));
		this.setTopAnchor(label_1552824, Double.valueOf(60));
		this.getChildren().add(label_1552824);
		TextField textField_1557766 = new TextField();
		textField_1557766.setFont(new Font("宋体", 14));
		textField_1557766.setPrefWidth(Double.valueOf(93));
		textField_1557766.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1557766, Double.valueOf(440));
		this.setTopAnchor(textField_1557766, Double.valueOf(60));
		this.getChildren().add(textField_1557766);
		Label label_1912052=new Label("性别");
		label_1912052.setFont(new Font("宋体", 14));
		label_1912052.setPrefWidth(Double.valueOf(100));
		label_1912052.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1912052, Double.valueOf(150));
		this.setTopAnchor(label_1912052, Double.valueOf(120));
		this.getChildren().add(label_1912052);
		ComboBox<String> combox_1500465 = new ComboBox<>();
		combox_1500465.setPrefWidth(Double.valueOf(93));
		combox_1500465.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(combox_1500465, Double.valueOf(220));
		this.setTopAnchor(combox_1500465, Double.valueOf(120));
		combox_1500465.getItems().add("");
		combox_1500465.getItems().add("男");
		combox_1500465.getItems().add("女");
		this.getChildren().add(combox_1500465);
		Label label_1267984=new Label("联系电话");
		label_1267984.setFont(new Font("宋体", 14));
		label_1267984.setPrefWidth(Double.valueOf(100));
		label_1267984.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1267984, Double.valueOf(370));
		this.setTopAnchor(label_1267984, Double.valueOf(120));
		this.getChildren().add(label_1267984);
		TextField textField_1149047 = new TextField();
		textField_1149047.setFont(new Font("宋体", 14));
		textField_1149047.setPrefWidth(Double.valueOf(93));
		textField_1149047.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1149047, Double.valueOf(440));
		this.setTopAnchor(textField_1149047, Double.valueOf(120));
		this.getChildren().add(textField_1149047);
		TableView table_1303779=new TableView();
		table_1303779.setPrefWidth(Double.valueOf(0));
		table_1303779.setPrefHeight(Double.valueOf(0));
		table_1303779.setMaxWidth(Double.valueOf(0));
		table_1303779.setMaxHeight(Double.valueOf(0));
		table_1303779.setMinWidth(Double.valueOf(0));
		table_1303779.setMinHeight(Double.valueOf(0));
		this.setLeftAnchor(table_1303779, Double.valueOf(0));
		this.setTopAnchor(table_1303779, Double.valueOf(0));
		TableColumn table_1303779id=new TableColumn("编号");
		table_1303779id.setCellValueFactory(new PropertyValueFactory<>("id"));
		table_1303779.getColumns().add(table_1303779id);
		TableColumn table_13037790=new TableColumn("姓名");
		table_13037790.setCellValueFactory(new PropertyValueFactory<>("xingming"));
		table_1303779.getColumns().add(table_13037790);
		TableColumn table_13037791=new TableColumn("年龄");
		table_13037791.setCellValueFactory(new PropertyValueFactory<>("nianling"));
		table_1303779.getColumns().add(table_13037791);
		TableColumn table_13037792=new TableColumn("性别");
		table_13037792.setCellValueFactory(new PropertyValueFactory<>("xingbie"));
		table_1303779.getColumns().add(table_13037792);
		TableColumn table_13037793=new TableColumn("联系电话");
		table_13037793.setCellValueFactory(new PropertyValueFactory<>("lianxidianhua"));
		table_1303779.getColumns().add(table_13037793);
		table_1303779.setItems(table_1303779data);
		this.getChildren().add(table_1303779);
		table_1303779refresh();
		Button btn_1981079=new Button("保存");
		btn_1981079.setFont(new Font("宋体", 14));
		btn_1981079.setPrefWidth(Double.valueOf(93));
		btn_1981079.setPrefHeight(Double.valueOf(23));
		// 修改按钮点击事件
		btn_1981079.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				// 获取表格中的读者信息
				Duzhe bean = table_1303779data.get(Integer.valueOf(param));
				bean.setXingming(textField_1978880.getText());
				bean.setNianling(textField_1557766.getText());
				bean.setXingbie(combox_1500465.getSelectionModel().getSelectedItem());
				bean.setLianxidianhua(textField_1149047.getText());
				table_1303779dao.update(bean);
				showMsg("修改成功");
			}
		});
		this.getChildren().add(btn_1981079);
		Button btn_1111786=new Button("关闭");
		btn_1111786.setFont(new Font("宋体", 14));
		btn_1111786.setPrefWidth(Double.valueOf(93));
		btn_1111786.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1111786, Double.valueOf(300));
		this.setTopAnchor(btn_1111786, Double.valueOf(350));
		// 关闭按钮点击事件
		btn_1111786.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
			}
		});
		this.getChildren().add(btn_1111786);
		table_1303779.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = table_1303779.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
				// 获取选中的读者信息
				Duzhe bean = (Duzhe)table_1303779.getSelectionModel().getSelectedItems().get(0);
				textField_1978880.setText(bean.getXingming());
				textField_1557766.setText(bean.getNianling());
				combox_1500465.setValue(bean.getXingbie());
				textField_1149047.setText(bean.getLianxidianhua());

			};
		});
		table_1303779refresh();
		// 初始化读者信息
		Duzhe bean = table_1303779data.get(Integer.valueOf(param));
		textField_1978880.setText(bean.getXingming());
		textField_1557766.setText(bean.getNianling());
		combox_1500465.setValue(bean.getXingbie());
		textField_1149047.setText(bean.getLianxidianhua());
	}
	// 刷新表格数据
	public void table_1303779refresh(){
		table_1303779data.clear();
		table_1303779data.addAll(table_1303779dao.getAll());
	}
	// 显示信息提示框
	public void showMsg(String msg){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.titleProperty().set("提示");
		alert.headerTextProperty().set(msg);
		alert.showAndWait();
	}
}
