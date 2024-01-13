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

public class GuanliyuanManageUI extends AnchorPane {

	private String mainid;
	public String getMainid() {
		return mainid;
	}
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	Dao<Guanliyuan> table_1721355dao = new Dao(new Guanliyuan());
	ObservableList<Guanliyuan> table_1721355data = FXCollections.observableArrayList();
	public GuanliyuanManageUI(String param) {
		this.mainid=param;
		Label label_1253821=new Label("用户名");
		label_1253821.setFont(new Font("宋体", 14));
		label_1253821.setPrefWidth(Double.valueOf(100));
		label_1253821.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1253821, Double.valueOf(150));
		this.setTopAnchor(label_1253821, Double.valueOf(30));
		this.getChildren().add(label_1253821);
		TextField textField_136892 = new TextField();
		textField_136892.setFont(new Font("宋体", 14));
		textField_136892.setPrefWidth(Double.valueOf(93));
		textField_136892.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_136892, Double.valueOf(220));
		this.setTopAnchor(textField_136892, Double.valueOf(30));
		this.getChildren().add(textField_136892);
		Label label_1302902=new Label("密码");
		label_1302902.setFont(new Font("宋体", 14));
		label_1302902.setPrefWidth(Double.valueOf(100));
		label_1302902.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1302902, Double.valueOf(370));
		this.setTopAnchor(label_1302902, Double.valueOf(30));
		this.getChildren().add(label_1302902);
		TextField textField_1548117 = new TextField();
		textField_1548117.setFont(new Font("宋体", 14));
		textField_1548117.setPrefWidth(Double.valueOf(93));
		textField_1548117.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1548117, Double.valueOf(440));
		this.setTopAnchor(textField_1548117, Double.valueOf(30));
		this.getChildren().add(textField_1548117);
		 TableView table_1721355=new TableView();
		table_1721355.setPrefWidth(Double.valueOf(800));
		table_1721355.setPrefHeight(Double.valueOf(400));
		table_1721355.setMaxWidth(Double.valueOf(800));
		table_1721355.setMaxHeight(Double.valueOf(400));
		table_1721355.setMinWidth(Double.valueOf(800));
		table_1721355.setMinHeight(Double.valueOf(400));
		this.setLeftAnchor(table_1721355, Double.valueOf(190));
		this.setTopAnchor(table_1721355, Double.valueOf(145));
		 TableColumn table_1721355id=new TableColumn("编号");
		 table_1721355id.setCellValueFactory(new PropertyValueFactory<>("id"));
		 table_1721355.getColumns().add(table_1721355id);
		 TableColumn table_17213550=new TableColumn("用户名");
		 table_17213550.setCellValueFactory(new PropertyValueFactory<>("yonghuming"));
		 table_1721355.getColumns().add(table_17213550);
		 TableColumn table_17213551=new TableColumn("密码");
		 table_17213551.setCellValueFactory(new PropertyValueFactory<>("mima"));
		 table_1721355.getColumns().add(table_17213551);
		table_1721355.setItems(table_1721355data);
		this.getChildren().add(table_1721355);
		table_1721355refresh();
		Button btn_1587292=new Button("新增");
		btn_1587292.setFont(new Font("宋体", 14));
		btn_1587292.setPrefWidth(Double.valueOf(93));
		btn_1587292.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1587292, Double.valueOf(200));
		this.setTopAnchor(btn_1587292, Double.valueOf(100));
		btn_1587292.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("新增");
			    stage.setScene(new Scene(new GuanliyuanAddUI(""),600,600));
			    stage.show();
			}
		});
		this.getChildren().add(btn_1587292);
		Button btn_1802081=new Button("修改");
		btn_1802081.setFont(new Font("宋体", 14));
		btn_1802081.setPrefWidth(Double.valueOf(93));
		btn_1802081.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1802081, Double.valueOf(300));
		this.setTopAnchor(btn_1802081, Double.valueOf(100));
		/**
			修改按钮触发事件
		*/
		btn_1802081.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int row = table_1721355.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					showMsg("请选择一行");
					return;
				}
			    Stage stage=new Stage();
			    stage.setTitle("修改");
			    stage.setScene(new Scene(new GuanliyuanUpdateUI(String.valueOf(row)),600,600));
			    stage.show();
			}
		});
		this.getChildren().add(btn_1802081);
		Button btn_1283399=new Button("删除");
		btn_1283399.setFont(new Font("宋体", 14));
		btn_1283399.setPrefWidth(Double.valueOf(93));
		btn_1283399.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1283399, Double.valueOf(400));
		this.setTopAnchor(btn_1283399, Double.valueOf(100));
		btn_1283399.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int row = table_1721355.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					showMsg("请选择一行");
					return;
				}
				Guanliyuan bean = (Guanliyuan)table_1721355.getSelectionModel().getSelectedItems().get(0);
				table_1721355dao.delBykey("id", bean.getId().toString());
				showMsg("删除成功");
				table_1721355refresh();

			}
		});
		this.getChildren().add(btn_1283399);
		Button btn_1802990=new Button("查询");
		btn_1802990.setFont(new Font("宋体", 14));
		btn_1802990.setPrefWidth(Double.valueOf(93));
		btn_1802990.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1802990, Double.valueOf(500));
		this.setTopAnchor(btn_1802990, Double.valueOf(100));
		btn_1802990.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Guanliyuan bean=new Guanliyuan();
				bean.setYonghuming(textField_136892.getText());
				bean.setMima(textField_1548117.getText());
				table_1721355data.clear();
				table_1721355data.addAll(table_1721355dao.query(bean));

			}
		});
		this.getChildren().add(btn_1802990);
		Button btn_1366144=new Button("重置");
		btn_1366144.setFont(new Font("宋体", 14));
		btn_1366144.setPrefWidth(Double.valueOf(93));
		btn_1366144.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1366144, Double.valueOf(600));
		this.setTopAnchor(btn_1366144, Double.valueOf(100));
		btn_1366144.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				textField_136892.setText("");
				textField_1548117.setText("");
			}
		});
		this.getChildren().add(btn_1366144);
		table_1721355.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = table_1721355.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
		 			Guanliyuan bean = (Guanliyuan)table_1721355.getSelectionModel().getSelectedItems().get(0);
				textField_136892.setText(bean.getYonghuming());
				textField_1548117.setText(bean.getMima());

			};
		});
		table_1721355refresh();

	}
	public void table_1721355refresh(){
		table_1721355data.clear();
    	table_1721355data.addAll(table_1721355dao.getAll());
	}
 	public void showMsg(String msg){
   	 Alert alert = new Alert(AlertType.INFORMATION);
        alert.titleProperty().set("提示");
        alert.headerTextProperty().set(msg);
        alert.showAndWait();
   }
}
