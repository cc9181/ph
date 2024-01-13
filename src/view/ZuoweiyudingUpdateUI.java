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
import javafx.scene.image.Image;

public class ZuoweiyudingUpdateUI extends AnchorPane {

	private String mainid;
	public String getMainid() {
		return mainid;
	}
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	Dao<Zuoweiyuding> table_1484096dao = new Dao(new Zuoweiyuding());
	ObservableList<Zuoweiyuding> table_1484096data = FXCollections.observableArrayList();
	Dao<Duzhe> combox_1615434dao = new Dao(new Duzhe());
	Dao<Yuelanshi> combox_1976998dao = new Dao(new Yuelanshi());
	public ZuoweiyudingUpdateUI(String param) {
		this.mainid=param;
		Label label_1773043=new Label("读者");
		label_1773043.setFont(new Font("宋体", 14));
		label_1773043.setPrefWidth(Double.valueOf(100));
		label_1773043.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1773043, Double.valueOf(150));
		this.setTopAnchor(label_1773043, Double.valueOf(60));
		this.getChildren().add(label_1773043);
		ComboBox<String> combox_1615434 = new ComboBox<>();
		combox_1615434.setPrefWidth(Double.valueOf(93));
		combox_1615434.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(combox_1615434, Double.valueOf(220));
		this.setTopAnchor(combox_1615434, Double.valueOf(60));
		List<Duzhe> combox_1615434list=combox_1615434dao.getAll();
		combox_1615434.getItems().add("");
		for (int i = 0; i < combox_1615434list.size(); i++) {
			combox_1615434.getItems().add(combox_1615434list.get(i).getXingming());
		}
		this.getChildren().add(combox_1615434);
		Label label_1390931=new Label("座位");
		label_1390931.setFont(new Font("宋体", 14));
		label_1390931.setPrefWidth(Double.valueOf(100));
		label_1390931.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1390931, Double.valueOf(370));
		this.setTopAnchor(label_1390931, Double.valueOf(60));
		this.getChildren().add(label_1390931);
		TextField textField_1789899 = new TextField();
		textField_1789899.setFont(new Font("宋体", 14));
		textField_1789899.setPrefWidth(Double.valueOf(93));
		textField_1789899.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1789899, Double.valueOf(440));
		this.setTopAnchor(textField_1789899, Double.valueOf(60));
		this.getChildren().add(textField_1789899);
		Label label_1568034=new Label("阅览室");
		label_1568034.setFont(new Font("宋体", 14));
		label_1568034.setPrefWidth(Double.valueOf(100));
		label_1568034.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1568034, Double.valueOf(150));
		this.setTopAnchor(label_1568034, Double.valueOf(120));
		this.getChildren().add(label_1568034);
		ComboBox<String> combox_1976998 = new ComboBox<>();
		combox_1976998.setPrefWidth(Double.valueOf(93));
		combox_1976998.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(combox_1976998, Double.valueOf(220));
		this.setTopAnchor(combox_1976998, Double.valueOf(120));
		List<Yuelanshi> combox_1976998list=combox_1976998dao.getAll();
		combox_1976998.getItems().add("");
		for (int i = 0; i < combox_1976998list.size(); i++) {
			combox_1976998.getItems().add(combox_1976998list.get(i).getMingcheng());
		}
		this.getChildren().add(combox_1976998);
		Label label_1963106=new Label("日期");
		label_1963106.setFont(new Font("宋体", 14));
		label_1963106.setPrefWidth(Double.valueOf(100));
		label_1963106.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1963106, Double.valueOf(370));
		this.setTopAnchor(label_1963106, Double.valueOf(120));
		this.getChildren().add(label_1963106);
		DatePicker textField_1561775 = new DatePicker();
		textField_1561775.setPrefWidth(Double.valueOf(93));
		textField_1561775.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1561775, Double.valueOf(440));
		this.setTopAnchor(textField_1561775, Double.valueOf(120));
		this.getChildren().add(textField_1561775);
		Label label_1450289=new Label("时间");
		label_1450289.setFont(new Font("宋体", 14));
		label_1450289.setPrefWidth(Double.valueOf(100));
		label_1450289.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1450289, Double.valueOf(150));
		this.setTopAnchor(label_1450289, Double.valueOf(180));
		this.getChildren().add(label_1450289);
		TextField textField_123324 = new TextField();
		textField_123324.setFont(new Font("宋体", 14));
		textField_123324.setPrefWidth(Double.valueOf(93));
		textField_123324.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_123324, Double.valueOf(220));
		this.setTopAnchor(textField_123324, Double.valueOf(180));
		this.getChildren().add(textField_123324);
		 TableView table_1484096=new TableView();
		table_1484096.setPrefWidth(Double.valueOf(0));
		table_1484096.setPrefHeight(Double.valueOf(0));
		table_1484096.setMaxWidth(Double.valueOf(0));
		table_1484096.setMaxHeight(Double.valueOf(0));
		table_1484096.setMinWidth(Double.valueOf(0));
		table_1484096.setMinHeight(Double.valueOf(0));
		this.setLeftAnchor(table_1484096, Double.valueOf(0));
		this.setTopAnchor(table_1484096, Double.valueOf(0));
		 TableColumn table_1484096id=new TableColumn("编号");
		 table_1484096id.setCellValueFactory(new PropertyValueFactory<>("id"));
		 table_1484096.getColumns().add(table_1484096id);
		 TableColumn table_14840960=new TableColumn("读者");
		 table_14840960.setCellValueFactory(new PropertyValueFactory<>("duzhe"));
		 table_1484096.getColumns().add(table_14840960);
		 TableColumn table_14840961=new TableColumn("座位");
		 table_14840961.setCellValueFactory(new PropertyValueFactory<>("zuowei"));
		 table_1484096.getColumns().add(table_14840961);
		 TableColumn table_14840962=new TableColumn("阅览室");
		 table_14840962.setCellValueFactory(new PropertyValueFactory<>("yuelanshi"));
		 table_1484096.getColumns().add(table_14840962);
		 TableColumn table_14840963=new TableColumn("日期");
		 table_14840963.setCellValueFactory(new PropertyValueFactory<>("riqi"));
		 table_1484096.getColumns().add(table_14840963);
		 TableColumn table_14840964=new TableColumn("时间");
		 table_14840964.setCellValueFactory(new PropertyValueFactory<>("shijian"));
		 table_1484096.getColumns().add(table_14840964);
		table_1484096.setItems(table_1484096data);
		this.getChildren().add(table_1484096);
		table_1484096refresh();
		Button btn_1168020=new Button("保存");
		btn_1168020.setFont(new Font("宋体", 14));
		btn_1168020.setPrefWidth(Double.valueOf(93));
		btn_1168020.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1168020, Double.valueOf(200));
		this.setTopAnchor(btn_1168020, Double.valueOf(350));
		/**
			修改按钮触发事件
		*/
		btn_1168020.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
		 			Zuoweiyuding bean = table_1484096data.get(Integer.valueOf(param));
				bean.setDuzhe(combox_1615434.getSelectionModel().getSelectedItem());
				bean.setZuowei(textField_1789899.getText());
				bean.setYuelanshi(combox_1976998.getSelectionModel().getSelectedItem());
				if(textField_1561775.getValue()!=null)
				bean.setRiqi(textField_1561775.getValue().toString());
				bean.setShijian(textField_123324.getText());
				table_1484096dao.update(bean);
				showMsg("修改成功");
			}
		});
		this.getChildren().add(btn_1168020);
		Button btn_1893025=new Button("关闭");
		btn_1893025.setFont(new Font("宋体", 14));
		btn_1893025.setPrefWidth(Double.valueOf(93));
		btn_1893025.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1893025, Double.valueOf(300));
		this.setTopAnchor(btn_1893025, Double.valueOf(350));
		btn_1893025.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    ((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
			}
		});
		this.getChildren().add(btn_1893025);
		table_1484096.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = table_1484096.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
		 			Zuoweiyuding bean = (Zuoweiyuding)table_1484096.getSelectionModel().getSelectedItems().get(0);
				combox_1615434.setValue(bean.getDuzhe());
				textField_1789899.setText(bean.getZuowei());
				combox_1976998.setValue(bean.getYuelanshi());
				textField_123324.setText(bean.getShijian());
				
			};
		});
		table_1484096refresh();
		 			Zuoweiyuding bean = table_1484096data.get(Integer.valueOf(param));
				combox_1615434.setValue(bean.getDuzhe());
				textField_1789899.setText(bean.getZuowei());
				combox_1976998.setValue(bean.getYuelanshi());
				textField_123324.setText(bean.getShijian());
	}
	public void table_1484096refresh(){
		table_1484096data.clear();
    	table_1484096data.addAll(table_1484096dao.getAll());
	}
 	public void showMsg(String msg){
   	 Alert alert = new Alert(AlertType.INFORMATION);
        alert.titleProperty().set("提示");
        alert.headerTextProperty().set(msg);
        alert.showAndWait();
   }
}
