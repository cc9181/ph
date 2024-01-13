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

public class GuanliyuanLoginUI extends AnchorPane {

	// 静态变量，用于存储用户名和角色信息
	public static String username;
	public static String role;
	// 静态变量，用于存储用户名和角色信息
	private String mainid;
	public String getMainid() {
		return mainid;
	}
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	// Dao类实例，用于对管理员信息进行数据库操作
	Dao<Guanliyuan> table_1943581dao = new Dao(new Guanliyuan());
	// ObservableList用于存储表格数据
	ObservableList<Guanliyuan> table_1943581data = FXCollections.observableArrayList();
	// 构造方法，接收主界面ID作为参数
	public GuanliyuanLoginUI(String param) {
		this.mainid=param;
		// 创建UI元素，设置样式和布局
		Label label_1759397=new Label("图书馆订座系统");
		label_1759397.setFont(new Font("楷体", 25));
		label_1759397.setPrefWidth(Double.valueOf(410));
		label_1759397.setPrefHeight(Double.valueOf(62));
		this.setLeftAnchor(label_1759397, Double.valueOf(184));
		this.setTopAnchor(label_1759397, Double.valueOf(25));
		this.getChildren().add(label_1759397);
		Label label_1753206=new Label("用户名");
		label_1753206.setFont(new Font("楷体", 20));
		label_1753206.setPrefWidth(Double.valueOf(110));
		label_1753206.setPrefHeight(Double.valueOf(32));
		this.setLeftAnchor(label_1753206, Double.valueOf(104));
		this.setTopAnchor(label_1753206, Double.valueOf(125));
		this.getChildren().add(label_1753206);
		TextField textField_1462041 = new TextField();
		textField_1462041.setFont(new Font("宋体", 14));
		textField_1462041.setPrefWidth(Double.valueOf(227));
		textField_1462041.setPrefHeight(Double.valueOf(38));
		this.setLeftAnchor(textField_1462041, Double.valueOf(224));
		this.setTopAnchor(textField_1462041, Double.valueOf(119));
		this.getChildren().add(textField_1462041);
		Label label_1726331=new Label("密码");
		label_1726331.setFont(new Font("楷体", 20));
		label_1726331.setPrefWidth(Double.valueOf(110));
		label_1726331.setPrefHeight(Double.valueOf(32));
		this.setLeftAnchor(label_1726331, Double.valueOf(104));
		this.setTopAnchor(label_1726331, Double.valueOf(210));
		this.getChildren().add(label_1726331);
		PasswordField password_1746402=new PasswordField();
		password_1746402.setPromptText("");
		password_1746402.setFont(new Font("宋体", 14));
		password_1746402.setPrefWidth(Double.valueOf(227));
		password_1746402.setPrefHeight(Double.valueOf(38));
		this.setLeftAnchor(password_1746402, Double.valueOf(224));
		this.setTopAnchor(password_1746402, Double.valueOf(210));
		this.getChildren().add(password_1746402);
		 TableView table_1943581=new TableView();
		table_1943581.setPrefWidth(Double.valueOf(0));
		table_1943581.setPrefHeight(Double.valueOf(0));
		table_1943581.setMaxWidth(Double.valueOf(0));
		table_1943581.setMaxHeight(Double.valueOf(0));
		table_1943581.setMinWidth(Double.valueOf(0));
		table_1943581.setMinHeight(Double.valueOf(0));
		this.setLeftAnchor(table_1943581, Double.valueOf(0));
		this.setTopAnchor(table_1943581, Double.valueOf(0));
		 TableColumn table_1943581id=new TableColumn("编号");
		 table_1943581id.setCellValueFactory(new PropertyValueFactory<>("id"));
		 table_1943581.getColumns().add(table_1943581id);
		 TableColumn table_19435810=new TableColumn("用户名");
		 table_19435810.setCellValueFactory(new PropertyValueFactory<>("yonghuming"));
		 table_1943581.getColumns().add(table_19435810);
		 TableColumn table_19435811=new TableColumn("密码");
		 table_19435811.setCellValueFactory(new PropertyValueFactory<>("mima"));
		 table_1943581.getColumns().add(table_19435811);
		table_1943581.setItems(table_1943581data);
		this.getChildren().add(table_1943581);
		table_1943581refresh();
		Button btn_1332267=new Button("注册");
		btn_1332267.setFont(new Font("楷体", 20));
		btn_1332267.setPrefWidth(Double.valueOf(105));
		btn_1332267.setPrefHeight(Double.valueOf(38));
		this.setLeftAnchor(btn_1332267, Double.valueOf(332));
		this.setTopAnchor(btn_1332267, Double.valueOf(350));
		btn_1332267.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("注册");
			    stage.setScene(new Scene(new GuanliyuanRegistUI(""),600,600));
			    stage.show();
			}
		});
		this.getChildren().add(btn_1332267);
		Button btn_1892058=new Button("登录");
		btn_1892058.setFont(new Font("楷体", 20));
		btn_1892058.setPrefWidth(Double.valueOf(105));
		btn_1892058.setPrefHeight(Double.valueOf(38));
		this.setLeftAnchor(btn_1892058, Double.valueOf(175));
		this.setTopAnchor(btn_1892058, Double.valueOf(350));
		/**
			登录按钮触发事件
		*/
		btn_1892058.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				List<Guanliyuan> list = table_1943581dao.queryByKey("yonghuming", textField_1462041.getText());
				if(list.size()>0){
					if(list.get(0).getMima().equals(password_1746402.getText())){
						username=list.get(0).getYonghuming();
						showMsg("登录成功");
			    		Stage stage=new Stage();
			    		stage.setTitle("系统功能");
			    		GuanliyuanMainUI mainui = new GuanliyuanMainUI("");
						mainui.setUsername(username);
			    		stage.setScene(new Scene(mainui,600,600));
			    		stage.show();
			    		((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
						return;
					}
				}

							showMsg("用户名或密码错误,登录失败");
			}
		});
		this.getChildren().add(btn_1892058);
		table_1943581.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = table_1943581.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
		 			Guanliyuan bean = (Guanliyuan)table_1943581.getSelectionModel().getSelectedItems().get(0);
				textField_1462041.setText(bean.getYonghuming());
				password_1746402.setText(bean.getMima());
				
			};
		});
		table_1943581refresh();
		
	}
	// 刷新表格数据的方法
	public void table_1943581refresh(){
		table_1943581data.clear();
    	table_1943581data.addAll(table_1943581dao.getAll());
	}
	// 显示信息的方法
 	public void showMsg(String msg){
   	 Alert alert = new Alert(AlertType.INFORMATION);
        alert.titleProperty().set("提示");
        alert.headerTextProperty().set(msg);
        alert.showAndWait();
   }
}
