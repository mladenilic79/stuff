
package javafxapplication;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.w3c.dom.Document;

public class JavafxApplication extends Application implements EventHandler<ActionEvent> {
    
	// must be outside of main method if EventHandlering is manual
	Button button2;
	
	//method for properly closing the program
	private void closeProgram(Stage primaryStage) {
		Boolean answer = ConfirmBox.display("Title", "Sure you wanna exit");
		if (answer) {
			primaryStage.close();
		}
	}
	
	//Create branches for tree view method
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
	
    //Add button clicked for tableview
    public void addButtonClicked(TextField firstNameInput, TextField lastNameInput, TableView<Person> tableView){
        Person person = new Person();
        person.setFirstName(firstNameInput.getText());
        person.setLastName(lastNameInput.getText());
        tableView.getItems().add(person);
        firstNameInput.clear();
        lastNameInput.clear();
    }

    //Delete button clicked for tableview
    public void deleteButtonClicked(TableView<Person> tableView){
        ObservableList<Person> personsSelected, allPersons;
        allPersons = tableView.getItems();
        personsSelected = tableView.getSelectionModel().getSelectedItems();
        personsSelected.forEach(allPersons::remove);
    }
    
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == button2) {
			System.out.println("Hey Charlie!");
		}
	}
    
    @Override
    public void start(Stage primaryStage) {

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@ another stage (optional) (if opening another window)
        
    	// another page can be in another class
    	
        GridPane grid2 = new GridPane();
        
        Scene scene2 = new Scene(grid2, 300, 300);
        
        Stage stage2 = new Stage();
        
        Button closeButton = new Button("close the window");
        
        // lambda button
        closeButton.setOnAction(e -> {
        	stage2.close();
        });
        
        grid2.add(closeButton, 1, 1);
        
        stage2.setX(50);
        stage2.setY(50);
        stage2.setWidth(600);
        stage2.setHeight(300);
        
        // optional - force managing of this window first
        stage2.initModality(Modality.APPLICATION_MODAL);
        
//        stage2.setFullScreen(true);
        stage2.setScene(scene2);
//        stage2.show();
        // optional alternative - force managing of this window first
        stage2.showAndWait();

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@ root nodes (can be one inside of another)
        
        /*
        BorderPane - arranges nodes in top, left, right, bottom and center positions
        TextFlow - arranges multiple text nodes in a single flow
        AnchorPane - anchors nodes at a particular distance from the pane
        */

        // TabPane - tabs (root node)
        // create a tabpane
        TabPane tabpane = new TabPane();
        
        // create Tab
        Tab tab1 = new Tab("gridpane");
        Tab tab2 = new Tab("hbox");
        Tab tab3 = new Tab("vbox");
        Tab tab4 = new Tab("flowpane");
        Tab tab5 = new Tab("tilepane");
        Tab tab6 = new Tab("stackpane");
        Tab tab7 = new Tab("borderpane");
        
        Tab tab8 = new Tab("group");
        
        Tab tab9 = new Tab("webview");
        Tab tab10 = new Tab("tableview");
        Tab tab11 = new Tab("charts");
        
        // add tab
        tabpane.getTabs().add(tab1);
        tabpane.getTabs().add(tab2);
        tabpane.getTabs().add(tab3);
        tabpane.getTabs().add(tab4);
        tabpane.getTabs().add(tab5);
        tabpane.getTabs().add(tab6);
        tabpane.getTabs().add(tab7);
        tabpane.getTabs().add(tab8);
        tabpane.getTabs().add(tab9);
        tabpane.getTabs().add(tab10);
        tabpane.getTabs().add(tab11);
        
        // GridPane - arranges nodes as a grid of rows and columns
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(25, 25, 25, 25));
        gridpane.setGridLinesVisible(true);
        // add to the tab
        tab1.setContent(gridpane);
        
        // HBox - single horizontal row
        HBox hbox = new HBox();
        ObservableList<Node> hboxList = hbox.getChildren();
        // add some nodes
        Label hbox1 = new Label("jedan");
        Label hbox2 = new Label("dva");
        Label hbox3 = new Label("tri");
        hboxList.add(hbox1);
        hboxList.add(hbox2);
        hboxList.add(hbox3);
        // or in one line
//        hbox.getChildren().add(btn);
        hbox.setSpacing(50);
        // add to the tab
        tab2.setContent(hbox);
        
        // VBox - single vertical column
        VBox vbox = new VBox();
        ObservableList<Node> vboxList = vbox.getChildren();
        // add some nodes
        Label vbox1 = new Label("jedan");
        Label vbox2 = new Label("dva");
        Label vbox3 = new Label("tri");
        vboxList.add(vbox1);
        vboxList.add(vbox2);
        vboxList.add(vbox3);
        // or in one line
//        vbox.getChildren().add(vbox1);
        vbox.setSpacing(50);
        // add to the tab
        tab3.setContent(vbox);
        
        // flow pane - flow elements horizontaly or verticaly
        FlowPane flowpane = new FlowPane();
        // add some nodes
        Label flowpane1 = new Label("jedan");
        Label flowpane2 = new Label("dva");
        Label flowpane3 = new Label("tri");
        Label flowpane4 = new Label("jedan");
        Label flowpane5 = new Label("dva");
        Label flowpane6 = new Label("tri");
        Label flowpane7 = new Label("jedan");
        Label flowpane8 = new Label("dva");
        Label flowpane9 = new Label("tri");
        flowpane.getChildren().add(flowpane1);
        flowpane.getChildren().add(flowpane2);
        flowpane.getChildren().add(flowpane3);
        flowpane.getChildren().add(flowpane4);
        flowpane.getChildren().add(flowpane5);
        flowpane.getChildren().add(flowpane6);
        flowpane.getChildren().add(flowpane7);
        flowpane.getChildren().add(flowpane8);
        flowpane.getChildren().add(flowpane9);
        flowpane.setHgap(200);
        flowpane.setVgap(200);
        // default orientation is horizontal, this changes to vertical
        flowpane.setOrientation(Orientation.HORIZONTAL);
        // add to the tab
        tab4.setContent(flowpane);
        
        // TilePane - adds all nodes in the form of uniformly sized tiles
        TilePane tilePane = new TilePane();
        // add some nodes
        Label tilePane1 = new Label("jedan");
        Label tilePane2 = new Label("dva");
        Label tilePane3 = new Label("tri");
        Label tilePane4 = new Label("jedan");
        Label tilePane5 = new Label("dva");
        Label tilePane6 = new Label("tri");
        Label tilePane7 = new Label("jedan");
        Label tilePane8 = new Label("dva");
        Label tilePane9 = new Label("tri");
        tilePane.getChildren().add(tilePane1);
        tilePane.getChildren().add(tilePane2);
        tilePane.getChildren().add(tilePane3);
        tilePane.getChildren().add(tilePane4);
        tilePane.getChildren().add(tilePane5);
        tilePane.getChildren().add(tilePane6);
        tilePane.getChildren().add(tilePane7);
        tilePane.getChildren().add(tilePane8);
        tilePane.getChildren().add(tilePane9);
        tilePane.setTileAlignment(Pos.TOP_LEFT);
        tilePane.setHgap(200);
        tilePane.setVgap(200);
        // add to the tab
        tab5.setContent(tilePane);
        
        // StackPane - arranges nodes on top of another just like in a stack
        StackPane stackpane = new StackPane();
        ObservableList<Node> stackpaneList = stackpane.getChildren();
        // add some nodes
        Label stackpane1 = new Label("jedan");
        Label stackpane2 = new Label("dva");
        Label stackpane3 = new Label("tri");
        stackpaneList.add(stackpane1);
        stackpaneList.add(stackpane2);
        stackpaneList.add(stackpane3);
        // add to the tab
        tab6.setContent(stackpane);
        
        // borderPane - set content to top, bottom, left, right & center
        BorderPane borderPane = new BorderPane();
        // add some nodes
        Label borderPane1 = new Label("top");
        Label borderPane2 = new Label("left");
        Label borderPane3 = new Label("center");
        Label borderPane4 = new Label("right");
        Label borderPane5 = new Label("bottom");
        borderPane.setTop(borderPane1);
        borderPane.setLeft(borderPane2);      
        borderPane.setCenter(borderPane3);
        borderPane.setRight(borderPane4);
        borderPane.setBottom(borderPane5);
        // add to the tab
        tab7.setContent(borderPane);
        
        // group (just for grouping, use no layout, stack one element on top of one another)
        Group group = new Group();
        ObservableList<Node> groupList = group.getChildren();
        // add some nodes
        Label group1 = new Label("jedan");
        Label group2 = new Label("dva");
        Label group3 = new Label("tri");
        groupList.add(group1);
        groupList.add(group2);
        groupList.add(group3);
        // or in one line
//        group.getChildren().add(btn);
        // add to the tab
        tab8.setContent(group);
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@ nodes/elements

        /*
        Scrollbar
        ProgressBar
        Slider
        */
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@ basic elements classes first row
        
        // label
        // can receive imageview inside constructor, show both text & image
        Label label_node = new Label("label node");
        gridpane.add(label_node, 0, 0);
        // label node
        Label label = new Label();
        // dinamically set text
        label.setText("label");
        gridpane.add(label, 1, 0);
        
        // text & css
        Label text_node = new Label("text node");
        gridpane.add(text_node, 0, 1);
        // text node
        Text text = new Text();
        // dinamically set text
        text.setText("text");
        // set id for css for any node (for any graphic variable)
        text.setId("text1");
        // inline style (css) for any node
//        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridpane.add(text, 1, 1);
        // reading (put in event handler?)
        text.getText();
        
        // textfield
        Label textfield_node = new Label("textfield node");
        gridpane.add(textfield_node, 0, 2);
        // textfield node
        TextField textField = new TextField();
        // dinamically setting text
        textField.setText("textfield");
        gridpane.add(textField, 1, 2);
        // reading (put in event handler?)
        String text2 = textField.getText();
        
        // password
        Label password_node = new Label("password node");
        gridpane.add(password_node, 0, 3);
        // password node
        PasswordField passwordField = new PasswordField();
        // dinamically set text
        passwordField.setText("password");
        gridpane.add(passwordField, 1, 3);
        // retreving password (put in event handler/convenience method?)
        passwordField.getText();
        
        // textArea
        Label textArea_node = new Label("textArea node");
        gridpane.add(textArea_node, 0, 4);
        // textArea node
        TextArea textArea = new TextArea();
        // dinamically set text
        textArea.setText("text area");
        gridpane.add(textArea, 1, 4);
        // reading (put in event handler?)
        textArea.getText();
        
        // toggle single
        Label toggleSingle_node = new Label("toggle single node");
        gridpane.add(toggleSingle_node, 0, 5);
        // toggle single node
        ToggleButton toggleButton1 = new ToggleButton("toggle single");
        gridpane.add(toggleButton1, 1, 5);
        // check if selected (put in event handler?)
        boolean isSelected = toggleButton1.isSelected();
        
        // toggle group
        Label toggleGroup_node = new Label("toggle group node");
        gridpane.add(toggleGroup_node, 0, 6);
        // toggle group node
        ToggleButton toggleButton2 = new ToggleButton("toggle group one");
        ToggleButton toggleButton3 = new ToggleButton("toggle group two");
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleButton2.setToggleGroup(toggleGroup);
        toggleButton3.setToggleGroup(toggleGroup);
        gridpane.add(toggleButton2, 1, 6);
        gridpane.add(toggleButton3, 1, 7);
        // check for selected (put in event handler?)
        ToggleButton selectedToggleButton = (ToggleButton) toggleGroup.getSelectedToggle();
        
        // radio
        Label radioGroup_node = new Label("radio group node");
        gridpane.add(radioGroup_node, 0, 8);
        // radio node
        RadioButton radioButton1 = new RadioButton("radio Left");
        RadioButton radioButton2 = new RadioButton("radio Right");
        ToggleGroup radioGroup = new ToggleGroup();
        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);
        gridpane.add(radioButton1, 1, 8);
        gridpane.add(radioButton2, 1, 9);
        // reading selected (put in event handler?)
        RadioButton selectedRadioButton = (RadioButton) radioGroup.getSelectedToggle();
        
        // choicebox
        Label choicebox_node = new Label("choicebox node");
        gridpane.add(choicebox_node, 0, 10);
        // choicebox node
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Choice 1");
        choiceBox.getItems().add("Choice 2");
        gridpane.add(choiceBox, 1, 10);
        // reading (put in event handler?)
        String value = (String) choiceBox.getValue();
        
        // combobox
        Label combobox_node = new Label("combobox node");
        gridpane.add(combobox_node, 0, 11);
        // combobox node
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().add("Choice 1");
        comboBox.getItems().add("Choice 2");
        comboBox.getItems().add("Choice 3");
        // set editable (not editable by default)
        comboBox.setEditable(true);
        gridpane.add(comboBox, 1, 11);
        // reading (put in event handler?)
        String value1 = (String) comboBox.getValue();
        comboBox.setOnAction(e -> {
        	String text3 = (String) comboBox.getValue();
        });
        
        // listview
        Label listview_node = new Label("listview node");
        gridpane.add(listview_node, 0, 12);
        // listview node
        ListView<String> listView = new ListView<>();
        listView.getItems().add("Item 1");
        listView.getItems().add("Item 2");
        listView.getItems().add("Item 3");
        // allow for multiple items - optional
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        gridpane.add(listView, 1, 12);
        // button lambda for reading the results (putted in event handler?)
        Button buttonListView = new Button("Read list view");
        gridpane.add(buttonListView, 2, 12);
        buttonListView.setOnAction(event -> {
            ObservableList<Integer> selectedIndices = listView.getSelectionModel().getSelectedIndices();
            for(Object o : selectedIndices){
                System.out.println(o + " " + o.getClass());
            }
        });
        // or alternatively
        ObservableList<String> items = listView.getSelectionModel().getSelectedItems();
        
        // checkbox
        Label checkbox_node = new Label("checkbox node");
        gridpane.add(checkbox_node, 0, 13);
        // checkbox node
        CheckBox checkBox = new CheckBox("checkbox");
        // inderteminate option is optional, default is unchecked
        checkBox.setAllowIndeterminate(true);
        gridpane.add(checkBox, 1, 13);
        // reading (put in event handler?)
        boolean isIndeterminate = checkBox.isIndeterminate();
        boolean isSelected1 = checkBox.isSelected();
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@ basic elements classes second row
        
        // fileChooser
        Label fileChooser_node = new Label("fileChooser node");
        gridpane.add(fileChooser_node, 4, 0);
        // fileChooser node
        FileChooser fileChooser = new FileChooser();
        // set initial directory optional
        fileChooser.setInitialDirectory(new File("D:\\"));
        // add filename filter optional
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt")
           ,new FileChooser.ExtensionFilter("HTML Files", "*.htm")
        );
        // button for calling fileChooser
        Button buttonFileChooser = new Button("Select File");
        gridpane.add(buttonFileChooser, 5, 0);
        // put file chooser method in event handler / button
        buttonFileChooser.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
        });
        
        // directoryChooser
        Label directoryChooser_node = new Label("directoryChooser node");
        gridpane.add(directoryChooser_node, 4, 1);
        // directoryChooser node
        DirectoryChooser directoryChooser = new DirectoryChooser();
        // set initial directory
        directoryChooser.setInitialDirectory(new File("D:\\"));
        // button for calling directoryChooser
        Button buttonDirectoryChooser = new Button("Select Directory");
        gridpane.add(buttonDirectoryChooser, 5, 1);
        // put directory chooser method in event handler / button
        buttonDirectoryChooser.setOnAction(e -> {
            File selectedDirectory = directoryChooser.showDialog(primaryStage);
        });
        
        // datePicker
        Label datePicker_node = new Label("datePicker node");
        gridpane.add(datePicker_node, 4, 2);
        // datePicker node
        DatePicker datePicker = new DatePicker();
        gridpane.add(datePicker, 5, 2);
        // reading (put in event handler?)
        LocalDate value2 = datePicker.getValue();
        
        // colorPicker
        Label colorPicker_node = new Label("colorPicker node");
        gridpane.add(colorPicker_node, 4, 3);
        // colorPicker node
        ColorPicker colorPicker = new ColorPicker();
        // set current color
        colorPicker.setValue(Color.AQUAMARINE);
        gridpane.add(colorPicker, 5, 3);
        // retrive color
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Color color = colorPicker.getValue();
            }
        };
        colorPicker.setOnAction(event); 
        
        // tooltip
        Label tooltip_node = new Label("tooltip node");
        gridpane.add(tooltip_node, 4, 4);
        // tooltip node
        Tooltip tooltip = new Tooltip("tooltip text");
        // set delay exists in java 9
        // set to node
        tooltip_node.setTooltip(tooltip);
        
        // toolbar (can get any javafx control inside, buttons etc..)
        Label toolbar_node = new Label("toolbar node");
        gridpane.add(toolbar_node, 4, 5);
        // toolbar node
        ToolBar toolBar = new ToolBar();
        // optional vertical
        toolBar.setOrientation(Orientation.HORIZONTAL);
        // add some data
        Label labelData1 = new Label("data 1");
        Label labelData2 = new Label("data 2");
        toolBar.getItems().add(labelData1);
        // add separator
        toolBar.getItems().add(new Separator());
        toolBar.getItems().add(labelData2);
        gridpane.add(toolBar, 5, 5);
        
        // button
        Label button_node = new Label("button node");
        gridpane.add(button_node, 4, 6);
        // button node
        Button button = new Button();
        // broke lines if needed
        button.setWrapText(true);
        // allow for shortcut keys, optional
        button.setMnemonicParsing(true);
        // underscore for mnemonic shortcut, optional, otherwise just put regular text
        // activate with alt than keypress
        button.setText("_Click");
        gridpane.add(button, 5, 6);

        // menubutton - shows & hides menuItems (nodes) underneath it
        Label menuButton_node = new Label("menuButton node");
        gridpane.add(menuButton_node, 4, 7);
        // menubutton node
        // add same data
        MenuItem menuItem1 = new MenuItem("Option 1");
        MenuItem menuItem2 = new MenuItem("Option 2");
        MenuItem menuItem3 = new MenuItem("Option 3");
        //underscore before menu item means use alt & keyboard to start menu
        MenuButton menuButton = new MenuButton("_menuitem", null, menuItem1, menuItem2, menuItem3);
        // alternatively with graphics
        // MenuButton menuButton = new MenuButton("Options", imageview2, menuItem1, menuItem2, menuItem3);
        gridpane.add(menuButton, 5, 7);
        // add event handlers on every option
        menuItem1.setOnAction(e -> {
            System.out.println("MenuButton Item 1 Selected");
        });
        menuItem2.setOnAction(e -> {
            System.out.println("MenuButton Item 2 Selected");
        });
        menuItem3.setOnAction(e -> {
            System.out.println("MenuButton Item 3 Selected");
        });
        
        // menubar
        Label menu_node = new Label("menu node");
        gridpane.add(menu_node, 4, 8);
        // menubar node
        MenuBar menuBar = new MenuBar();
        // menuitem
        Menu menu1 = new Menu("Menu 1");
        // menuitem convenience methods
        menu1.setOnShowing(e -> { System.out.println("Showing Menu 1"); });
        menu1.setOnShown  (e -> { System.out.println("Shown Menu 1"); });
        menu1.setOnHiding (e -> { System.out.println("Hiding Menu 1"); });
        menu1.setOnHidden (e -> { System.out.println("Hidden Menu 1"); });
        menuBar.getMenus().add(menu1);
        // items in menuitem
        MenuItem menuItem4 = new MenuItem("menuItem 1");
        MenuItem menuItem5 = new MenuItem("menuItem 2");
        menu1.getItems().add(menuItem4);
        menu1.getItems().add(menuItem5);
        // actions on menuitems
        menuItem4.setOnAction(e -> {
            System.out.println("Menu Item 1 Selected");
        });
        menuItem5.setOnAction(e -> {
            System.out.println("Menu Item 2 Selected");
        });
        // separator
        SeparatorMenuItem separator = new SeparatorMenuItem();
        menu1.getItems().add(separator);
        // submenu in menuitem
        Menu subMenu = new Menu("Menu 1.1");
        MenuItem menuItem11 = new MenuItem("Item 1.1.1");
        subMenu.getItems().add(menuItem11);
        menu1.getItems().add(subMenu);
        // item that can be checked in menuitem
        CheckMenuItem checkMenuItem = new CheckMenuItem("Check this!");
        menu1.getItems().add(checkMenuItem);
        checkMenuItem.setOnAction(e -> {
            if(checkMenuItem.isSelected())
                System.out.println("Program will now display line numbers");
            else
                System.out.println("Hiding line number");
        });
        // select only one by radio
        RadioMenuItem choice1Item = new RadioMenuItem("Choice 1");
        RadioMenuItem choice2Item = new RadioMenuItem("Choice 2");
        ToggleGroup toggleGroup2 = new ToggleGroup();
        toggleGroup2.getToggles().add(choice1Item);
        toggleGroup2.getToggles().add(choice2Item);
        menu1.getItems().add(choice1Item);
        menu1.getItems().add(choice2Item);
        gridpane.add(menuBar, 5, 8);
        
        // tree view
        //Root
        TreeItem<String> root = new TreeItem<>();
        root.setExpanded(true);
        //Bucky
        TreeItem<String> bucky = makeBranch("Bucky", root);
        makeBranch("thenewboston", bucky);
        makeBranch("YouTube", bucky);
        makeBranch("Chicken", bucky);
        //Megan
        TreeItem<String> megan = makeBranch("Megan", root);
        makeBranch("Glitter", megan);
        makeBranch("Makeup", megan);
        //Create the tree and hide the main Root
        TreeView<String> tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if (newValue != null) {
                    	// take the value and use it
                        System.out.println(newValue.getValue());
                    }
                });
        gridpane.add(tree, 4, 11);

        // image
        Label image_node = new Label("image node");
        gridpane.add(image_node, 4, 9);
        // image node
        // maybe it will work without fileinputstream maybe it wont?????????????
        // FileInputStream input = new FileInputStream("resources/images/iconmonstr-home-6-48.png");
        Image image = new Image("https://www.tutorialspoint.com/green/images/logo.png");
        ImageView imageView = new ImageView(image);
        // set origin
//        imageView.setX(0);
//        imageView.setY(0);
        // fitting of image
//        imageView.setFitHeight(50);
//        imageView.setFitWidth(170);
        // use neighbouring nodes to fit image
        imageView.fitWidthProperty().bind(menuBar.widthProperty());
        imageView.fitHeightProperty().bind(image_node.heightProperty());
        // ratio
//        imageView.setPreserveRatio(true);
        gridpane.add(imageView, 5, 9, 1, 1);
        // second instace of the same image example
        ImageView imageView2 = new ImageView(image);
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@ convenience methods (event handling integrated in elements..)
        //@@@@@ & event handlers 
        //@@@@@ for manual implementation implement:
        //@@@@@ EventHandler<ActionEvent>   -for button clicks

        Label convenience_handlers = new Label("convenience & handlers node");
        gridpane.add(convenience_handlers, 4, 10);
        button2 = new Button("button");
        
        // for manual implemetation of EventHandler only
        button2.setOnAction(this);
        
        gridpane.add(button2, 5, 10);
        TextField textField2 = new TextField("textfield");
        gridpane.add(textField2, 6, 10);
        
        // convenience @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("convenience 1");
                // calling another stage to open from external class
                AlertBox.display("Title of Window", "Wow this alert box is awesome!");
            }
        });

        button2.setOnMouseClicked (new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent e) {
                System.out.println("convenience 2");
                // for properly closing the program (see below also)
                closeProgram(primaryStage);
            }
        });

        // also for properly closing the program
        primaryStage.setOnCloseRequest(e -> {
        	e.consume();
        	closeProgram(primaryStage);
        });
        
        /*
        // shorthand lambda button
        button2.setOnMouseClicked (e -> {
                System.out.println("convenience 2");
        });
        */
        
        // event handling @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // mouse filter
        EventHandler<MouseEvent> mouseFilter = new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent e) {
              System.out.println("mouse filter");
           }
        };
        button2.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseFilter);
        
        // removing handler/filter
//        button2.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseFilter);

        // mouse handler
        EventHandler<javafx.scene.input.MouseEvent> mouseHandler =
                new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent e) {
                System.out.println("mouse handler");
            }
        };
        button2.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, mouseHandler);

        // key handler
        EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("key handler");
            }
        };
        textField2.addEventHandler(KeyEvent.KEY_TYPED, keyHandler);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@ webview

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("http://google.com");
        // load local content
//        String content = "Hello World!";
//        webEngine.loadContent(content, "text/html");
        // reload content
        webEngine.reload();
        // set zoom level (bigger than 1 is zoom in..)
        webView.setZoom(1.25);
        // font scale
        webView.setFontScale(1.25);
        // send info to server
        webEngine.setUserAgent("MyApp Web Browser 1.0 - AppleWebKit/555.99 JavaFX 8.0");
        // disable (enable) context menu (right click)
        webView.setContextMenuEnabled(true);
        // obtaining history
        WebHistory history = webEngine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        // looping through history ?????????????????????????????????????????????
        // webhistory.entry has following info: URL, Title, Last visited date
        Iterator<WebHistory.Entry> iterator = entries.iterator();
        while(iterator.hasNext()){
            WebHistory.Entry entry = iterator.next();
            String url           = entry.getUrl();
            String title         = entry.getTitle();
            Date lastVisitedDate = entry.getLastVisitedDate();
        }
        // or ??????????????????????????????????????????????????????????????????
        for(WebHistory.Entry entry : entries){
            String url           = entry.getUrl();
            String title         = entry.getTitle();
            Date lastVisitedDate = entry.getLastVisitedDate();
        }
        // moving through history ??????????????????????????????????????????????
//        history.go(-1);
//        history.go( 1);
        // retrieving current index ????????????????????????????????????????????
        int currentIndex = history.getCurrentIndex();
        // execute javascript ??????????????????????????????????????????????????
//        webEngine.executeScript("myFunction()");
        // retrieving value from javascript ????????????????????????????????????
//        String returnValue = (String) webEngine.executeScript("myFunction()");
        // accessing dom ???????????????????????????????????????????????????????
        Document document = webEngine.getDocument();
        // add to the tab
        tab9.setContent(webView);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@ tableview
        
        // create javafx collection
        ObservableList<Person> personData = FXCollections.observableArrayList();
        // add same data to it
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
        // create table
        TableView<Person> tableView = new TableView<>();
        tableView.setEditable(true);
        // create columns
        // column without generics
        TableColumn<Person, String> column1 = new TableColumn<>("First Name");
        // column with generics
        TableColumn<Person, String> column2 = new TableColumn<>("Last Name");
        // register fields from class to fields in table ???????????????????????
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        // add columns to table
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        // nested columns
//        TableColumn cityCol = new TableColumn("City");
//        TableColumn stateCol = new TableColumn("State");
//        column1.getColumns().addAll(cityCol, stateCol);
        // hide columns
//        column1.setVisible(false);
        // add data to table
        tableView.setItems(personData);
        // editing table
        // Name input
        TextField firstNameInput = new TextField();
        firstNameInput.setPromptText("fistName");
        // Price input
        TextField lastNameInput = new TextField();
        lastNameInput.setPromptText("lastPrice");
        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked(firstNameInput, lastNameInput, tableView));
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked(tableView));
        // put editing elements in layout
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(firstNameInput, lastNameInput, addButton, deleteButton);
        // put table and editing elements in layout
        VBox vBox = new VBox();
        vBox.getChildren().addAll(tableView, hBox);
        // add all to tab
        tab10.setContent(vBox);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@ chart classes
        
        /*
        AreaChart
        BarChart
        BubbleChart
        PieChart
        StackedAreaChart
        StackedBarChart
        */
        
        // scatter chart
        // set axis
        NumberAxis xAxis1 = new NumberAxis();
        xAxis1.setLabel("No of employees");
        NumberAxis yAxis1 = new NumberAxis();
        yAxis1.setLabel("Revenue per employee");
        // chart instance
        ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis1, yAxis1);
        // data series
        XYChart.Series<Number, Number> dataSeries1 = new XYChart.Series<>();
        dataSeries1.setName("2014");
        dataSeries1.getData().add(new Data<>( 1, 567));
        dataSeries1.getData().add(new Data<>( 5, 612));
        dataSeries1.getData().add(new Data<>(10, 800));
        dataSeries1.getData().add(new XYChart.Data<>(20, 780));
        dataSeries1.getData().add(new XYChart.Data<>(40, 810));
        // add to chart
        scatterChart.getData().add(dataSeries1);
        
        // line chart
        // set axis
        NumberAxis xAxis2 = new NumberAxis();
        xAxis2.setLabel("No of employees");
        NumberAxis yAxis2 = new NumberAxis();
        yAxis2.setLabel("Revenue per employee");
        // chart instance
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis2, yAxis2);
        // data series
        XYChart.Series<Number, Number> dataSeries2 = new XYChart.Series<>();
        dataSeries2.setName("2014");
        dataSeries2.getData().add(new Data<>( 1, 567));
        dataSeries2.getData().add(new Data<>( 5, 612));
        dataSeries2.getData().add(new XYChart.Data<>(10, 800));
        dataSeries2.getData().add(new XYChart.Data<>(20, 780));
        dataSeries2.getData().add(new XYChart.Data<>(40, 810));
        // add to chart
        lineChart.getData().add(dataSeries2);
        
        // add charts to till pane
        TilePane tilePaneCharts = new TilePane();
        tilePaneCharts.getChildren().add(scatterChart);
        tilePaneCharts.getChildren().add(lineChart);
        tilePaneCharts.setTileAlignment(Pos.CENTER);
        tilePaneCharts.setHgap(20);
        tilePaneCharts.setVgap(20);
        tab11.setContent(tilePaneCharts);
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@ 2D drawing classes
        
        //Line
        int startX = 1, startY = 1;
        int endX = 2, endY = 2;
        Line line = new Line(startX, startY, endX, endY);
        line.setStartX(4);
        line.setStartY(5);
        line.setEndX(2);
        line.setEndY(1);
        
        /*
        Rectangle
        Rounded Rectangle (arched edges)
        Circle
        Ellipse
        Polygon (closed shape)
        Polyline (unclosed shape)
        Cubic Curve (Bezier parametric curve in the XY plane is a curve of degree 3)
        QuadCurve (Bezier parametric curve in the XY plane is a curve of degree 2)
        Arc
        Types Of Arc (we can draw three types of arc's Open, Chord, Round)
        SVGPath (we can construct images by parsing SVG paths. This class has a
                property named content of String datatype. This represents the
                SVG Path encoded string, from which the image should be drawn..
        */
        
        // custom drawing path class
        // Path path = new Path();
        // path methods
        /*
        LineTo - draw a straight line to a point in the specified coordinates from the current position
        HlineTo - draw a horizontal line to a point in the specified coordinates from the current position
        VLineTo - draw a vertical line to a point in the specified coordinates from the current position
        QuadCurveTo - draw a quadratic curve to a point in the specified coordinates from the current position
        CubicCurveTo - draw a cubic curve to a point in the specified coordinates from the current position
		ArcTo - draw an arc to a point in the specified coordinates from the current position
        */
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // 3D drawing classes
        
        /*
        box
        cilinder
        sphere
        */
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@ properties & effects of nodes
        
        // properties of objects @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        /*
        Stroke Type
        Stroke Width
        Stroke Fill
        Stroke
        Stroke Line
        Stroke Miter Limit
        Stroke Line Cap
        Smooth
        */
        
        // properties of 3D objects @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        /*
        CullFace (line visibility front / back)
        DrawMode (3D & 2D representations)
        PhongMaterial (material)
        */
       
        // properties of text @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        /*
        family (font family)
        weight (bold etc..)
        posture (italic etc..)
        size (font)

        strike through
        under line
        */
        
        // properties of color @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        /*
        Color color = new Color.BEIGE
        Color c = Color.rgb(0,0,255)
        Color c = Color.hsb(270,1.0,1.0)
        Color c = Color.web("0x0000FF",1.0)
        
        Uniform
        Image Pattern
        Gradient (linear & gradient)
        
        setFill
        setStroke
        */
        
        // effects @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        /*
        bloom
        blur
        ...
        */

        // glow
        Glow glow = new Glow();
        glow.setLevel(0.9);
        imageView.setEffect(glow); 
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@ operation & transformation & animation classes
        
        // operations of objects (2D 3D?) @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        /*
        Union Operation
        Intersection Operation
        Subtraction Operation
        */
        
        // transformations of nodes @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        /*
        Rotation
        Scaling
        Translation
        Shearing - slants the shape of an object
        */
        
        // animation classes @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        /*
        FadeTransition
        FillTransition
        RotateTransition
        ScaleTransition
        StrokeTransition
        TranslateTransition
        PathTransition
        SequentialTransition
        PauseTransition
        ParallelTransition
        */
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@ properties & binding
        
        textfield_node.textProperty().bind(textField.textProperty());
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@ inner & outer class & css & launching
        
        // inner class
        Scene scene = new Scene(tabpane, 1600, 800);
        
        // adding css to scene
//      scene.getStylesheets().add("style1/button-styles.css");
      // or if that doesn't work try
//      scene.getStylesheets().add((new File("src/cssFile.css")).toURI().toString());
      // applying of css to concrete node
//      vbox.getStylesheets().add("style1/button-styles.css");
        
        // outer class
        primaryStage.setTitle("JavaFX Welcome");
        // for setting the scene, can be used to change scenes
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
//        Application.launch(args);
    }
 
}
