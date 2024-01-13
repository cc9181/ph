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

public class DuzheAddUI extends AnchorPane {

	private String mainid;  // 主ID
	public String getMainid() { // 获取主ID
		return mainid;
	}
	public void setMainid(String mainid) { // 设置主ID
		this.mainid = mainid;
	}
	Dao<Duzhe> table_1553471dao = new Dao(new Duzhe());  // 数据访问对象
	ObservableList<Duzhe> table_1553471data = FXCollections.observableArrayList();  // 可观察的读者表数据
	public DuzheAddUI(String param) {  // 读者添加界面构造方法
		this.mainid=param;
		Label label_1414149=new Label("姓名");  // 姓名标签
		label_1414149.setFont(new Font("宋体", 14));
		label_1414149.setPrefWidth(Double.valueOf(100));
		label_1414149.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1414149, Double.valueOf(150));
		this.setTopAnchor(label_1414149, Double.valueOf(60));
		this.getChildren().add(label_1414149);
		TextField textField_1289798 = new TextField();  // 姓名输入框
		textField_1289798.setFont(new Font("宋体", 14));
		textField_1289798.setPrefWidth(Double.valueOf(93));
		textField_1289798.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1289798, Double.valueOf(220));
		this.setTopAnchor(textField_1289798, Double.valueOf(60));
		this.getChildren().add(textField_1289798);
		Label label_1524629=new Label("年龄");  // 年龄标签
		label_1524629.setFont(new Font("宋体", 14));
		label_1524629.setPrefWidth(Double.valueOf(100));
		label_1524629.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1524629, Double.valueOf(370));
		this.setTopAnchor(label_1524629, Double.valueOf(60));
		this.getChildren().add(label_1524629);
		TextField textField_1898319 = new TextField();  // 年龄输入框
		textField_1898319.setFont(new Font("宋体", 14));
		textField_1898319.setPrefWidth(Double.valueOf(93));
		textField_1898319.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1898319, Double.valueOf(440));
		this.setTopAnchor(textField_1898319, Double.valueOf(60));
		this.getChildren().add(textField_1898319);
		Label label_1152403=new Label("性别");  // 性别标签
		label_1152403.setFont(new Font("宋体", 14));
		label_1152403.setPrefWidth(Double.valueOf(100));
		label_1152403.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1152403, Double.valueOf(150));
		this.setTopAnchor(label_1152403, Double.valueOf(120));
		this.getChildren().add(label_1152403);
		ComboBox<String> combox_1325280 = new ComboBox<>();  // 性别下拉框
		combox_1325280.setPrefWidth(Double.valueOf(93));
		combox_1325280.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(combox_1325280, Double.valueOf(220));
		this.setTopAnchor(combox_1325280, Double.valueOf(120));
		combox_1325280.getItems().add("");
		combox_1325280.getItems().add("男");
		combox_1325280.getItems().add("女");
		this.getChildren().add(combox_1325280);
		Label label_1112999=new Label("联系电话");  // 联系电话标签
		label_1112999.setFont(new Font("宋体", 14));
		label_1112999.setPrefWidth(Double.valueOf(100));
		label_1112999.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1112999, Double.valueOf(370));
		this.setTopAnchor(label_1112999, Double.valueOf(120));
		this.getChildren().add(label_1112999);
		TextField textField_1237723 = new TextField();  // 联系电话输入框
		textField_1237723.setFont(new Font("宋体", 14));
		textField_1237723.setPrefWidth(Double.valueOf(93));
		textField_1237723.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1237723, Double.valueOf(440));
		this.setTopAnchor(textField_1237723, Double.valueOf(120));
		this.getChildren().add(textField_1237723);
		TableView table_1553471=new TableView();  // 读者表
		table_1553471.setPrefWidth(Double.valueOf(0));
		table_1553471.setPrefHeight(Double.valueOf(0));
		table_1553471.setMaxWidth(Double.valueOf(0));
		table_1553471.setMaxHeight(Double.valueOf(0));
		table_1553471.setMinWidth(Double.valueOf(0));
		table_1553471.setMinHeight(Double.valueOf(0));
		this.setLeftAnchor(table_1553471, Double.valueOf(0));
		this.setTopAnchor(table_1553471, Double.valueOf(0));
		TableColumn table_1553471id=new TableColumn("编号");  // 编号列
		table_1553471id.setCellValueFactory(new PropertyValueFactory<>("id"));
		table_1553471.getColumns().add(table_1553471id);
		TableColumn table_15534710=new TableColumn("姓名");  // 姓名列
		table_15534710.setCellValueFactory(new PropertyValueFactory<>("xingming"));
		table_1553471.getColumns().add(table_15534710);
		TableColumn table_15534711=new TableColumn("年龄");  // 年龄列
		table_15534711.setCellValueFactory(new PropertyValueFactory<>("nianling"));
		table_1553471.getColumns().add(table_15534711);
		TableColumn table_15534712=new TableColumn("性别");  // 性别列
		table_15534712.setCellValueFactory(new PropertyValueFactory<>("xingbie"));
		table_1553471.getColumns().add(table_15534712);
		TableColumn table_15534713=new TableColumn("联系电话");  // 联系电话列
		table_15534713.setCellValueFactory(new PropertyValueFactory<>("lianxidianhua"));
		table_1553471.getColumns().add(table_15534713);
		table_1553471.setItems(table_1553471data);
		this.getChildren().add(table_1553471);
		table_1553471refresh();
		Button btn_1344947=new Button("保存");  // 保存按钮
		btn_1344947.setFont(new Font("宋体", 14));
		btn_1344947.setPrefWidth(Double.valueOf(93));
		btn_1344947.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1344947, Double.valueOf(200));
		this.setTopAnchor(btn_1344947, Double.valueOf(350));
		btn_1344947.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Duzhe bean=new Duzhe();
				bean.setXingming(textField_1289798.getText());
				bean.setNianling(textField_1898319.getText());
				bean.setXingbie(combox_1325280.getSelectionModel().getSelectedItem());
				bean.setLianxidianhua(textField_1237723.getText());
				table_1553471dao.add(bean);
				showMsg("新增成功");
				table_1553471refresh();
			}
		});
		this.getChildren().add(btn_1344947);
		Button btn_1235163=new Button("关闭");  // 关闭按钮
		btn_1235163.setFont(new Font("宋体", 14));
		btn_1235163.setPrefWidth(Double.valueOf(93));
		btn_1235163.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1235163, Double.valueOf(300));
		this.setTopAnchor(btn_1235163, Double.valueOf(350));
		btn_1235163.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
			}
		});
		this.getChildren().add(btn_1235163);
		table_1553471.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = table_1553471.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
				Duzhe bean = (Duzhe)table_1553471.getSelectionModel().getSelectedItems().get(0);
				textField_1289798.setText(bean.getXingming());
				textField_1898319.setText(bean.getNianling());
				combox_1325280.setValue(bean.getXingbie());
				textField_1237723.setText(bean.getLianxidianhua());
			};
		});
		table_1553471refresh();
	}
	public void table_1553471refresh(){
		table_1553471data.clear();
		table_1553471data.addAll(table_1553471dao.getAll());
	}
	public void showMsg(String msg){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.titleProperty().set("提示");
		alert.headerTextProperty().set(msg);
		alert.showAndWait();
	}
}
