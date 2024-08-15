package simplefx;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.prefs.Preferences;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Assignment extends Application{
	private MenuBar bar = new MenuBar();
	private Menu mFile = new Menu("Operator");
	private Menu mTextFill = new Menu("Text Fill");
	private MenuItem mADD = new MenuItem("Addition");
	private MenuItem mSub = new MenuItem("Substraction");
	private MenuItem mMul = new MenuItem("Multiply");
	private MenuItem mDiv = new MenuItem("Division");
	private MenuItem mMod = new MenuItem("Modulas");
	private MenuItem mExit = new MenuItem("Exit");

	private Menu mSetting = new Menu("Format Number");
	private MenuItem R = new CheckMenuItem("Round");
	private MenuItem C = new CheckMenuItem("Ceili");
	private MenuItem F = new CheckMenuItem("Floor");

	private Label No1 =new Label("Number One");
	TextField txfName = new TextField();
	private Label No2 =new Label("Number Two");
	TextField txfName2 = new TextField();
	private Label No3 =new Label("Result");
	TextField txfName3 = new TextField();
	BorderPane root = new BorderPane();
	VBox TT =new VBox(No1,No2,No3);
	VBox RR =new VBox(txfName,txfName2,txfName3);



	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage st) throws Exception {
		root.setTop(bar);
		root.setLeft(TT);
		root.setCenter(RR);


		bar.getMenus().addAll(mFile,mSetting);
		mFile.getItems().addAll(mADD,mSub,mMul,mDiv,mMod,mExit);
		mADD.setAccelerator(KeyCombination.valueOf("ctrl+A"));
		mSub.setAccelerator(KeyCombination.valueOf("ctrl+S"));
		mMul.setAccelerator(KeyCombination.valueOf("ctrl+M"));
		mDiv.setAccelerator(KeyCombination.valueOf("ctrl+D"));
		mMod.setAccelerator(KeyCombination.valueOf("ctrl+O"));




		Scene sc = new Scene(root);
		st.setScene(sc);
		st.setTitle("Simple Notepad");
		st.show();

		mADD.setOnAction(e->{
			double num1 = Double.parseDouble(txfName.getText());
			double num2 = Double.parseDouble(txfName2.getText());
			double result =num1+num2;
			txfName3.setText(String.valueOf(result));
		});
		mSub.setOnAction(e->{
			double num1 = Double.parseDouble(txfName.getText());
			double num2 = Double.parseDouble(txfName2.getText());
			double result =num1-num2;
			txfName3.setText(String.valueOf(result));
		});
		mMul.setOnAction(e->{
			double num1 = Double.parseDouble(txfName.getText());
			double num2 = Double.parseDouble(txfName2.getText());
			double result =num1*num2;
			txfName3.setText(String.valueOf(result));
		});
		mDiv.setOnAction(e->{
			double num1 = Double.parseDouble(txfName.getText());
			double num2 = Double.parseDouble(txfName2.getText());
			double result =num1/num2;
			txfName3.setText(String.valueOf(result));
		});
		mMod.setOnAction(e->{
			double num1 = Double.parseDouble(txfName.getText());
			double num2 = Double.parseDouble(txfName2.getText());
			double result =num1%num2;
			txfName3.setText(String.valueOf(result));
		});
		R.setOnAction(e->{

			double num = Double.parseDouble(txfName3.getText());
			txfName3.setText(String.valueOf(Math.round(num)));

		});
		C.setOnAction(e->{
			double num = Double.parseDouble(txfName3.getText());
			txfName3.setText(String.valueOf(Math.ceil(num)));

		});
		F.setOnAction(e->{
			double num = Double.parseDouble(txfName3.getText());
			txfName3.setText(String.valueOf(Math.floor(num)));

		});

		txfName3.setEditable(false);
		mExit.setOnAction(e->{System.exit(0);});

	}
}



