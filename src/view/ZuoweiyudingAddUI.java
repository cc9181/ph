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

/**
 * ZuoweiyudingAddUI 类是座位预定信息添加界面的用户界面类。
 */
public class ZuoweiyudingAddUI extends AnchorPane {

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

	// 数据访问对象和可观察列表，用于管理座位预定信息
	Dao<Zuoweiyuding> table_129981dao = new Dao(new Zuoweiyuding());
	ObservableList<Zuoweiyuding> table_129981data = FXCollections.observableArrayList();

	// 数据访问对象，用于获取读者信息
	Dao<Duzhe> combox_1610015dao = new Dao(new Duzhe());

	// 数据访问对象，用于获取阅览室信息
	Dao<Yuelanshi> combox_1110334dao = new Dao(new Yuelanshi());

	/**
	 * ZuoweiyudingAddUI 类的构造方法，接收主界面ID作为参数。
	 * @param param 主界面ID参数
	 */
	public ZuoweiyudingAddUI(String param) {
		this.mainid = param;

		// 创建读者标签和下拉框
		Label label_1626674 = new Label("读者");
		label_1626674.setFont(new Font("宋体", 14));
		label_1626674.setPrefWidth(Double.valueOf(100));
		label_1626674.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1626674, Double.valueOf(150));
		this.setTopAnchor(label_1626674, Double.valueOf(60));
		this.getChildren().add(label_1626674);

		ComboBox<String> combox_1610015 = new ComboBox<>();
		combox_1610015.setPrefWidth(Double.valueOf(93));
		combox_1610015.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(combox_1610015, Double.valueOf(220));
		this.setTopAnchor(combox_1610015, Double.valueOf(60));

		// 获取读者信息并添加到下拉框中
		List<Duzhe> combox_1610015list = combox_1610015dao.getAll();
		combox_1610015.getItems().add("");
		for (int i = 0; i < combox_1610015list.size(); i++) {
			combox_1610015.getItems().add(combox_1610015list.get(i).getXingming());
		}
		this.getChildren().add(combox_1610015);

		// 创建座位标签和文本框
		Label label_1289349 = new Label("座位");
		label_1289349.setFont(new Font("宋体", 14));
		label_1289349.setPrefWidth(Double.valueOf(100));
		label_1289349.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1289349, Double.valueOf(370));
		this.setTopAnchor(label_1289349, Double.valueOf(60));
		this.getChildren().add(label_1289349);

		TextField textField_1837054 = new TextField();
		textField_1837054.setFont(new Font("宋体", 14));
		textField_1837054.setPrefWidth(Double.valueOf(93));
		textField_1837054.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1837054, Double.valueOf(440));
		this.setTopAnchor(textField_1837054, Double.valueOf(60));
		this.getChildren().add(textField_1837054);

		// 创建阅览室标签和下拉框
		Label label_1129087 = new Label("阅览室");
		label_1129087.setFont(new Font("宋体", 14));
		label_1129087.setPrefWidth(Double.valueOf(100));
		label_1129087.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1129087, Double.valueOf(150));
		this.setTopAnchor(label_1129087, Double.valueOf(120));
		this.getChildren().add(label_1129087);

		ComboBox<String> combox_1110334 = new ComboBox<>();
		combox_1110334.setPrefWidth(Double.valueOf(93));
		combox_1110334.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(combox_1110334, Double.valueOf(220));
		this.setTopAnchor(combox_1110334, Double.valueOf(120));

		// 获取阅览室信息并添加到下拉框中
		List<Yuelanshi> combox_1110334list = combox_1110334dao.getAll();
		combox_1110334.getItems().add("");
		for (int i = 0; i < combox_1110334list.size(); i++) {
			combox_1110334.getItems().add(combox_1110334list.get(i).getMingcheng());
		}
		this.getChildren().add(combox_1110334);

		// 创建日期标签和日期选择器
		Label label_1255876 = new Label("日期");
		label_1255876.setFont(new Font("宋体", 14));
		label_1255876.setPrefWidth(Double.valueOf(100));
		label_1255876.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1255876, Double.valueOf(370));
		this.setTopAnchor(label_1255876, Double.valueOf(120));
		this.getChildren().add(label_1255876);

		DatePicker textField_1196034 = new DatePicker();
		textField_1196034.setPrefWidth(Double.valueOf(93));
		textField_1196034.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1196034, Double.valueOf(440));
		this.setTopAnchor(textField_1196034, Double.valueOf(120));
		this.getChildren().add(textField_1196034);

		// 创建时间标签和文本框
		Label label_1862037 = new Label("时间");
		label_1862037.setFont(new Font("宋体", 14));
		label_1862037.setPrefWidth(Double.valueOf(100));
		label_1862037.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(label_1862037, Double.valueOf(150));
		this.setTopAnchor(label_1862037, Double.valueOf(180));
		this.getChildren().add(label_1862037);

		TextField textField_1631981 = new TextField();
		textField_1631981.setFont(new Font("宋体", 14));
		textField_1631981.setPrefWidth(Double.valueOf(93));
		textField_1631981.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(textField_1631981, Double.valueOf(220));
		this.setTopAnchor(textField_1631981, Double.valueOf(180));
		this.getChildren().add(textField_1631981);

		// 创建座位预定信息表格
		TableView table_129981 = new TableView();
		table_129981.setPrefWidth(Double.valueOf(0));
		table_129981.setPrefHeight(Double.valueOf(0));
		table_129981.setMaxWidth(Double.valueOf(0));
		table_129981.setMaxHeight(Double.valueOf(0));
		table_129981.setMinWidth(Double.valueOf(0));
		table_129981.setMinHeight(Double.valueOf(0));
		this.setLeftAnchor(table_129981, Double.valueOf(0));
		this.setTopAnchor(table_129981, Double.valueOf(0));

		// 创建表格列并设置列名和数据绑定
		TableColumn table_129981id = new TableColumn("编号");
		table_129981id.setCellValueFactory(new PropertyValueFactory<>("id"));
		table_129981.getColumns().add(table_129981id);

		TableColumn table_1299810 = new TableColumn("读者");
		table_1299810.setCellValueFactory(new PropertyValueFactory<>("duzhe"));
		table_129981.getColumns().add(table_1299810);

		TableColumn table_1299811 = new TableColumn("座位");
		table_1299811.setCellValueFactory(new PropertyValueFactory<>("zuowei"));
		table_129981.getColumns().add(table_1299811);

		TableColumn table_1299812 = new TableColumn("阅览室");
		table_1299812.setCellValueFactory(new PropertyValueFactory<>("yuelanshi"));
		table_129981.getColumns().add(table_1299812);

		TableColumn table_1299813 = new TableColumn("日期");
		table_1299813.setCellValueFactory(new PropertyValueFactory<>("riqi"));
		table_129981.getColumns().add(table_1299813);

		TableColumn table_1299814 = new TableColumn("时间");
		table_1299814.setCellValueFactory(new PropertyValueFactory<>("shijian"));
		table_129981.getColumns().add(table_1299814);

		table_129981.setItems(table_129981data);
		this.getChildren().add(table_129981);

		// 刷新座位预定信息表格
		table_129981refresh();

		// 创建保存按钮，添加保存操作
		Button btn_1564021 = new Button("保存");
		btn_1564021.setFont(new Font("宋体", 14));
		btn_1564021.setPrefWidth(Double.valueOf(93));
		btn_1564021.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1564021, Double.valueOf(200));
		this.setTopAnchor(btn_1564021, Double.valueOf(350));
		btn_1564021.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				// 创建座位预定信息对象并设置属性
				Zuoweiyuding bean = new Zuoweiyuding();
				bean.setDuzhe(combox_1610015.getSelectionModel().getSelectedItem());
				bean.setZuowei(textField_1837054.getText());
				bean.setYuelanshi(combox_1110334.getSelectionModel().getSelectedItem());
				if (textField_1196034.getValue() != null)
					bean.setRiqi(textField_1196034.getValue().toString());
				bean.setShijian(textField_1631981.getText());
				// 添加座位预定信息到数据库
				table_129981dao.add(bean);
				showMsg("新增成功");
				table_129981refresh();
			}
		});
		this.getChildren().add(btn_1564021);
		// 创建关闭按钮，添加关闭操作
		Button btn_1111522 = new Button("关闭");
		btn_1111522.setFont(new Font("宋体", 14));
		btn_1111522.setPrefWidth(Double.valueOf(93));
		btn_1111522.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(btn_1111522, Double.valueOf(300));
		this.setTopAnchor(btn_1111522, Double.valueOf(350));
		btn_1111522.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				// 关闭当前界面
				((Stage) ((Button) e.getSource()).getScene().getWindow()).close();
			}
		});
		this.getChildren().add(btn_1111522);

		// 为座位预定信息表格添加鼠标点击事件，用于选中表格行时填充表单
		table_129981.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = table_129981.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}

				// 获取选中的座位预定信息对象，并将其属性设置到表单中
				Zuoweiyuding bean = (Zuoweiyuding) table_129981.getSelectionModel().getSelectedItems().get(0);
				combox_1610015.setValue(bean.getDuzhe());
				textField_1837054.setText(bean.getZuowei());
				combox_1110334.setValue(bean.getYuelanshi());
				textField_1631981.setText(bean.getShijian());
			};
		});

		// 刷新座位预定信息表格
		table_129981refresh();
	}

	/**
	 * 刷新座位预定信息表格数据。
	 */
	public void table_129981refresh() {
		table_129981data.clear();
		table_129981data.addAll(table_129981dao.getAll());
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