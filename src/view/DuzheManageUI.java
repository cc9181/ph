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

public  class  DuzheManageUI  extends  AnchorPane  {
	//  设置mainid属性
	private  String  mainid;
	public  String  getMainid()  {
		return  mainid;
	}
	public  void  setMainid(String  mainid)  {
		this.mainid  =  mainid;
	}
	//  数据访问对象创建
	Dao<Duzhe>  table_1329625dao  =  new  Dao(new  Duzhe());
	ObservableList<Duzhe>  table_1329625data  =  FXCollections.observableArrayList();
	//  创建构造函数
	public  DuzheManageUI(String  param)  {
		this.mainid=param;
		//  设置标签姓名
		Label  label_178192=new  Label("姓名");
		label_178192.setFont(new  Font("宋体",  14));
		label_178192.setPrefWidth(Double.valueOf(100));
		label_178192.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_178192,  Double.valueOf(150));
		this.setTopAnchor(label_178192,  Double.valueOf(30));
		this.getChildren().add(label_178192);
		//  创建文本框
		TextField  textField_1933926  =  new  TextField();
		textField_1933926.setFont(new  Font("宋体",  14));
		textField_1933926.setPrefWidth(Double.valueOf(93));
		textField_1933926.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1933926,  Double.valueOf(220));
		this.setTopAnchor(textField_1933926,  Double.valueOf(30));
		this.getChildren().add(textField_1933926);
		//  设置标签年龄
		Label  label_189543=new  Label("年龄");
		label_189543.setFont(new  Font("宋体",  14));
		label_189543.setPrefWidth(Double.valueOf(100));
		label_189543.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_189543,  Double.valueOf(370));
		this.setTopAnchor(label_189543,  Double.valueOf(30));
		this.getChildren().add(label_189543);
		//  创建文本框
		TextField  textField_1460791  =  new  TextField();
		textField_1460791.setFont(new  Font("宋体",  14));
		textField_1460791.setPrefWidth(Double.valueOf(93));
		textField_1460791.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1460791,  Double.valueOf(440));
		this.setTopAnchor(textField_1460791,  Double.valueOf(30));
		this.getChildren().add(textField_1460791);
		//  设置标签性别
		Label  label_1795249=new  Label("性别");
		label_1795249.setFont(new  Font("宋体",  14));
		label_1795249.setPrefWidth(Double.valueOf(100));
		label_1795249.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1795249,  Double.valueOf(590));
		this.setTopAnchor(label_1795249,  Double.valueOf(30));
		this.getChildren().add(label_1795249);
		//  创建组合框
		ComboBox<String>  combox_151346  =  new  ComboBox<>();
		combox_151346.setPrefWidth(Double.valueOf(93));
		combox_151346.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(combox_151346,  Double.valueOf(660));
		this.setTopAnchor(combox_151346,  Double.valueOf(30));
		combox_151346.getItems().add("");
		combox_151346.getItems().add("男");
		combox_151346.getItems().add("女");

		//  添加选择框
		this.getChildren().add(combox_151346);
		//  设置标签联系电话
		Label  label_1119900=new  Label("联系电话");
		label_1119900.setFont(new  Font("宋体",  14));
		label_1119900.setPrefWidth(Double.valueOf(100));
		label_1119900.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1119900,  Double.valueOf(810));
		this.setTopAnchor(label_1119900,  Double.valueOf(30));
		this.getChildren().add(label_1119900);
		//  创建文本框
		TextField  textField_1645766  =  new  TextField();
		textField_1645766.setFont(new  Font("宋体",  14));
		textField_1645766.setPrefWidth(Double.valueOf(93));
		textField_1645766.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1645766,  Double.valueOf(880));
		this.setTopAnchor(textField_1645766,  Double.valueOf(30));
		this.getChildren().add(textField_1645766);

		//  创建表视图
		TableView  table_1329625=new  TableView();
		table_1329625.setPrefWidth(Double.valueOf(800));
		table_1329625.setPrefHeight(Double.valueOf(400));
		table_1329625.setMaxWidth(Double.valueOf(800));
		table_1329625.setMaxHeight(Double.valueOf(400));
		table_1329625.setMinWidth(Double.valueOf(800));
		table_1329625.setMinHeight(Double.valueOf(400));
		this.setLeftAnchor(table_1329625,  Double.valueOf(190));
		this.setTopAnchor(table_1329625,  Double.valueOf(145));
		//  创建表列
		TableColumn  table_1329625id=new  TableColumn("编号");
		table_1329625id.setCellValueFactory(new  PropertyValueFactory<>("id"));
		table_1329625.getColumns().add(table_1329625id);
		TableColumn  table_13296250=new  TableColumn("姓名");
		table_13296250.setCellValueFactory(new  PropertyValueFactory<>("xingming"));
		table_1329625.getColumns().add(table_13296250);
		TableColumn  table_13296251=new  TableColumn("年龄");
		table_13296251.setCellValueFactory(new  PropertyValueFactory<>("nianling"));
		table_1329625.getColumns().add(table_13296251);
		TableColumn  table_13296252=new  TableColumn("性别");
		table_13296252.setCellValueFactory(new  PropertyValueFactory<>("xingbie"));
		table_1329625.getColumns().add(table_13296252);
		TableColumn  table_13296253=new  TableColumn("联系电话");
		table_13296253.setCellValueFactory(new  PropertyValueFactory<>("lianxidianhua"));
		table_1329625.getColumns().add(table_13296253);
		table_1329625.setItems(table_1329625data);
		//  添加视图
		this.getChildren().add(table_1329625);
		table_1329625refresh();
		Button  btn_1340281=new  Button("新增");
		btn_1340281.setFont(new  Font("宋体",  14));
		btn_1340281.setPrefWidth(Double.valueOf(93));
		btn_1340281.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1340281,  Double.valueOf(200));
		this.setTopAnchor(btn_1340281,  Double.valueOf(100));
		btn_1340281.setOnAction(new  EventHandler<ActionEvent>()  {
			public  void  handle(ActionEvent  e)  {
				Stage  stage=new  Stage();
				stage.setTitle("新增");
				stage.setScene(new  Scene(new  DuzheAddUI(""),600,600));
				stage.show();
			}
		});
		this.getChildren().add(btn_1340281);
		Button  btn_19897=new  Button("修改");
		btn_19897.setFont(new  Font("宋体",  14));
		btn_19897.setPrefWidth(Double.valueOf(93));
		btn_19897.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_19897,  Double.valueOf(300));
		this.setTopAnchor(btn_19897,  Double.valueOf(100));
		//  修改按钮触发事件
		btn_19897.setOnAction(new  EventHandler<ActionEvent>()  {
			public  void  handle(ActionEvent  e)  {
				int  row  =  table_1329625.getSelectionModel().getSelectedIndex();
				if  (row  ==  -1)  {
					showMsg("请选择一行");
					return;
				}
				Stage  stage=new  Stage();
				stage.setTitle("修改");
				stage.setScene(new  Scene(new  DuzheUpdateUI(String.valueOf(row)),600,600));
				stage.show();
			}
		});
		this.getChildren().add(btn_19897);
		Button  btn_1572272=new  Button("删除");
		btn_1572272.setFont(new  Font("宋体",  14));
		btn_1572272.setPrefWidth(Double.valueOf(93));
		btn_1572272.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1572272,  Double.valueOf(400));
		this.setTopAnchor(btn_1572272,  Double.valueOf(100));
		btn_1572272.setOnAction(new  EventHandler<ActionEvent>()  {
			public  void  handle(ActionEvent  e)  {
				int  row  =  table_1329625.getSelectionModel().getSelectedIndex();
				if  (row  ==  -1)  {
					showMsg("请选择一行");
					return;
				}
				Duzhe  bean  =  (Duzhe)table_1329625.getSelectionModel().getSelectedItems().get(0);
				table_1329625dao.delBykey("id",  bean.getId().toString());
				showMsg("删除成功");
				table_1329625refresh();

			}
		});
		this.getChildren().add(btn_1572272);
		Button  btn_1236161=new  Button("查询");
		btn_1236161.setFont(new  Font("宋体",  14));
		btn_1236161.setPrefWidth(Double.valueOf(93));
		btn_1236161.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1236161,  Double.valueOf(500));
		this.setTopAnchor(btn_1236161,  Double.valueOf(100));
		btn_1236161.setOnAction(new  EventHandler<ActionEvent>()  {
			public  void  handle(ActionEvent  e)  {
				Duzhe  bean=new  Duzhe();
				bean.setXingming(textField_1933926.getText());
				bean.setNianling(textField_1460791.getText());
				bean.setXingbie(combox_151346.getSelectionModel().getSelectedItem());
				bean.setLianxidianhua(textField_1645766.getText());
				table_1329625data.clear();
				table_1329625data.addAll(table_1329625dao.query(bean));

			}
		});
		this.getChildren().add(btn_1236161);
		Button  btn_1769776=new  Button("重置");
		btn_1769776.setFont(new  Font("宋体",  14));
		btn_1769776.setPrefWidth(Double.valueOf(93));
		btn_1769776.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1769776,  Double.valueOf(600));
		this.setTopAnchor(btn_1769776,  Double.valueOf(100));
		btn_1769776.setOnAction(new EventHandler<ActionEvent>() { // 设置按钮点击事件的处理程序
			public void handle(ActionEvent e) { // 处理事件的方法
				textField_1933926.setText(""); // 设置文本字段为""
				textField_1460791.setText(""); // 设置文本字段为""
				combox_151346.setValue(""); // 设置下拉框的值为""
				textField_1645766.setText(""); // 设置文本字段为""
			}
		});
		this.getChildren().add(btn_1769776); // 在布局中添加按钮
		table_1329625.setOnMouseClicked(new EventHandler<Event>() { // 设置表格点击事件的处理程序
			public void handle(Event event) { // 处理事件的方法
				int row = table_1329625.getSelectionModel().getSelectedIndex(); // 获取选定行的索引
				if (row == -1) { // 如果行索引为-1
					return; // 退出方法
				}
				Duzhe bean = (Duzhe)table_1329625.getSelectionModel().getSelectedItems().get(0); // 获取选定行的数据
				textField_1933926.setText(bean.getXingming()); // 设置文本字段为数据中的姓名
				textField_1460791.setText(bean.getNianling()); // 设置文本字段为数据中的年龄
				combox_151346.setValue(bean.getXingbie()); // 设置下拉框的值为数据中的性别
				textField_1645766.setText(bean.getLianxidianhua()); // 设置文本字段为数据中的联系电话
			};
		});
		table_1329625refresh(); // 刷新表格数据

	}
	public void table_1329625refresh(){ // 方法：刷新表格数据
		table_1329625data.clear(); // 清空表格数据
		table_1329625data.addAll(table_1329625dao.getAll()); // 添加新的表格数据
	}
	public void showMsg(String msg){ // 方法：显示消息
		Alert alert = new Alert(AlertType.INFORMATION); // 创建一个信息弹窗
		alert.titleProperty().set("提示"); // 设置弹窗的标题
		alert.headerTextProperty().set(msg); // 设置弹窗的消息内容
		alert.showAndWait(); // 显示弹窗并等待
	}
} // 类结束
