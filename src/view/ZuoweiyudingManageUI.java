package view;


import dao.*;
import entity.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javafx.scene.layout.Background;
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
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;


public class ZuoweiyudingManageUI extends AnchorPane {

	private String mainid;
	public String getMainid() {
		return mainid;
	}
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	Dao<Zuoweiyuding> table_1113668dao = new Dao(new Zuoweiyuding());
	ObservableList<Zuoweiyuding> table_1113668data = FXCollections.observableArrayList();
	Dao<Duzhe> combox_1605728dao = new Dao(new Duzhe());
	Dao<Yuelanshi> combox_15460dao = new Dao(new Yuelanshi());
	public ZuoweiyudingManageUI(String param) {
		this.mainid=param;
		Label label_173020=new Label("读者");
		label_173020.setFont(new Font("宋体", 14));
		label_173020.setPrefWidth(Double.valueOf(100));
		label_173020.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_173020, Double.valueOf(150));
		this.setTopAnchor(label_173020, Double.valueOf(30));
		this.getChildren().add(label_173020);
		ComboBox<String> combox_1605728 = new ComboBox<>();
		combox_1605728.setPrefWidth(Double.valueOf(93));
		combox_1605728.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(combox_1605728, Double.valueOf(220));
		this.setTopAnchor(combox_1605728, Double.valueOf(30));
		List<Duzhe> combox_1605728list=combox_1605728dao.getAll();
		combox_1605728.getItems().add("");
		for (int i = 0; i < combox_1605728list.size(); i++) {
			combox_1605728.getItems().add(combox_1605728list.get(i).getXingming());
		}
		this.getChildren().add(combox_1605728);
		Label label_1659573=new Label("座位");
		label_1659573.setFont(new Font("宋体", 14));
		label_1659573.setPrefWidth(Double.valueOf(100));
		label_1659573.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1659573, Double.valueOf(370));
		this.setTopAnchor(label_1659573, Double.valueOf(30));
		this.getChildren().add(label_1659573);
		TextField textField_1903198 = new TextField();
		textField_1903198.setFont(new Font("宋体", 14));
		textField_1903198.setPrefWidth(Double.valueOf(93));
		textField_1903198.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1903198, Double.valueOf(440));
		this.setTopAnchor(textField_1903198, Double.valueOf(30));
		this.getChildren().add(textField_1903198);
		Label label_1199073=new Label("阅览室");
		label_1199073.setFont(new Font("宋体", 14));
		label_1199073.setPrefWidth(Double.valueOf(100));
		label_1199073.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1199073, Double.valueOf(590));
		this.setTopAnchor(label_1199073, Double.valueOf(30));
		this.getChildren().add(label_1199073);
		ComboBox<String> combox_15460 = new ComboBox<>();
		combox_15460.setPrefWidth(Double.valueOf(93));
		combox_15460.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(combox_15460, Double.valueOf(660));
		this.setTopAnchor(combox_15460, Double.valueOf(30));
		List<Yuelanshi> combox_15460list=combox_15460dao.getAll();
		combox_15460.getItems().add("");
		for (int i = 0; i < combox_15460list.size(); i++) {
			combox_15460.getItems().add(combox_15460list.get(i).getMingcheng());
		}
		this.getChildren().add(combox_15460);
		Label label_187353=new Label("日期");
		label_187353.setFont(new Font("宋体", 14));
		label_187353.setPrefWidth(Double.valueOf(100));
		label_187353.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_187353, Double.valueOf(810));
		this.setTopAnchor(label_187353, Double.valueOf(30));
		this.getChildren().add(label_187353);
		DatePicker textField_1107636 = new DatePicker();
		textField_1107636.setPrefWidth(Double.valueOf(93));
		textField_1107636.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1107636, Double.valueOf(880));
		this.setTopAnchor(textField_1107636, Double.valueOf(30));
		this.getChildren().add(textField_1107636);
		Label label_1456797=new Label("时间");
		label_1456797.setFont(new Font("宋体", 14));
		label_1456797.setPrefWidth(Double.valueOf(100));
		label_1456797.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1456797, Double.valueOf(150));
		this.setTopAnchor(label_1456797, Double.valueOf(60));
		this.getChildren().add(label_1456797);
		TextField textField_1929937 = new TextField();
		textField_1929937.setFont(new Font("宋体", 14));
		textField_1929937.setPrefWidth(Double.valueOf(93));
		textField_1929937.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1929937, Double.valueOf(220));
		this.setTopAnchor(textField_1929937, Double.valueOf(60));
		this.getChildren().add(textField_1929937);
		 TableView table_1113668=new TableView();
		table_1113668.setPrefWidth(Double.valueOf(800));
		table_1113668.setPrefHeight(Double.valueOf(400));
		table_1113668.setMaxWidth(Double.valueOf(800));
		table_1113668.setMaxHeight(Double.valueOf(400));
		table_1113668.setMinWidth(Double.valueOf(800));
		table_1113668.setMinHeight(Double.valueOf(400));
		this.setLeftAnchor(table_1113668, Double.valueOf(190));
		this.setTopAnchor(table_1113668, Double.valueOf(145));
		 TableColumn table_1113668id=new TableColumn("编号");
		 table_1113668id.setCellValueFactory(new PropertyValueFactory<>("id"));
		 table_1113668.getColumns().add(table_1113668id);
		 TableColumn table_11136680=new TableColumn("读者");
		 table_11136680.setCellValueFactory(new PropertyValueFactory<>("duzhe"));
		 table_1113668.getColumns().add(table_11136680);
		 TableColumn table_11136681=new TableColumn("座位");
		 table_11136681.setCellValueFactory(new PropertyValueFactory<>("zuowei"));
		 table_1113668.getColumns().add(table_11136681);
		 TableColumn table_11136682=new TableColumn("阅览室");
		 table_11136682.setCellValueFactory(new PropertyValueFactory<>("yuelanshi"));
		 table_1113668.getColumns().add(table_11136682);
		 TableColumn table_11136683=new TableColumn("日期");
		 table_11136683.setCellValueFactory(new PropertyValueFactory<>("riqi"));
		 table_1113668.getColumns().add(table_11136683);
		 TableColumn table_11136684=new TableColumn("时间");
		 table_11136684.setCellValueFactory(new PropertyValueFactory<>("shijian"));
		 table_1113668.getColumns().add(table_11136684);
		table_1113668.setItems(table_1113668data);
		this.getChildren().add(table_1113668);
		table_1113668refresh();
		Button btn_1756238=new Button("新增");
		btn_1756238.setFont(new Font("宋体", 14));
		btn_1756238.setPrefWidth(Double.valueOf(93));
		btn_1756238.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1756238, Double.valueOf(200));
		this.setTopAnchor(btn_1756238, Double.valueOf(100));
		btn_1756238.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("新增");
			    stage.setScene(new Scene(new ZuoweiyudingAddUI(""),600,600));
			    stage.show();
			}
		});
		this.getChildren().add(btn_1756238);
		Button btn_1716883=new Button("修改");
		btn_1716883.setFont(new Font("宋体", 14));
		btn_1716883.setPrefWidth(Double.valueOf(93));
		btn_1716883.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1716883, Double.valueOf(300));
		this.setTopAnchor(btn_1716883, Double.valueOf(100));
		/**
			修改按钮触发事件
		*/
		btn_1716883.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int row = table_1113668.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					showMsg("请选择一行");
					return;
				}
			    Stage stage=new Stage();
			    stage.setTitle("修改");
			    stage.setScene(new Scene(new ZuoweiyudingUpdateUI(String.valueOf(row)),600,600));
			    stage.show();
			}
		});
		this.getChildren().add(btn_1716883);
		Button btn_1163724=new Button("删除");
		btn_1163724.setFont(new Font("宋体", 14));
		btn_1163724.setPrefWidth(Double.valueOf(93));
		btn_1163724.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1163724, Double.valueOf(400));
		this.setTopAnchor(btn_1163724, Double.valueOf(100));
		btn_1163724.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int row = table_1113668.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					showMsg("请选择一行");
					return;
				}
				Zuoweiyuding bean = (Zuoweiyuding)table_1113668.getSelectionModel().getSelectedItems().get(0);
				table_1113668dao.delBykey("id", bean.getId().toString());
				showMsg("删除成功");
				table_1113668refresh();

			}
		});
		this.getChildren().add(btn_1163724);
		Button btn_1753844=new Button("查询");
		btn_1753844.setFont(new Font("宋体", 14));
		btn_1753844.setPrefWidth(Double.valueOf(93));
		btn_1753844.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1753844, Double.valueOf(500));
		this.setTopAnchor(btn_1753844, Double.valueOf(100));
		btn_1753844.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Zuoweiyuding bean=new Zuoweiyuding();
				bean.setDuzhe(combox_1605728.getSelectionModel().getSelectedItem());
				bean.setZuowei(textField_1903198.getText());
				bean.setYuelanshi(combox_15460.getSelectionModel().getSelectedItem());
				if(textField_1107636.getValue()!=null)
				bean.setRiqi(textField_1107636.getValue().toString());
				bean.setShijian(textField_1929937.getText());
				table_1113668data.clear();
				table_1113668data.addAll(table_1113668dao.query(bean));

			}
		});
		this.getChildren().add(btn_1753844);
		Button btn_1201595=new Button("重置");
		btn_1201595.setFont(new Font("宋体", 14));
		btn_1201595.setPrefWidth(Double.valueOf(93));
		btn_1201595.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1201595, Double.valueOf(600));
		this.setTopAnchor(btn_1201595, Double.valueOf(100));
		btn_1201595.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				combox_1605728.setValue("");
				textField_1903198.setText("");
				combox_15460.setValue("");
				textField_1107636.setValue(null);
				textField_1929937.setText("");
			}
		});
		this.getChildren().add(btn_1201595);
		table_1113668.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = table_1113668.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
		 			Zuoweiyuding bean = (Zuoweiyuding)table_1113668.getSelectionModel().getSelectedItems().get(0);
				combox_1605728.setValue(bean.getDuzhe());
				textField_1903198.setText(bean.getZuowei());
				combox_15460.setValue(bean.getYuelanshi());
				textField_1929937.setText(bean.getShijian());

			};
		});
		table_1113668refresh();
	}
	public void table_1113668refresh(){
		table_1113668data.clear();
    	table_1113668data.addAll(table_1113668dao.getAll());
	}
 	public void showMsg(String msg){
   	 Alert alert = new Alert(AlertType.INFORMATION);
        alert.titleProperty().set("提示");
        alert.headerTextProperty().set(msg);
        alert.showAndWait();
   }
}
