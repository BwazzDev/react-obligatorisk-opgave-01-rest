import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientGuiApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private boolean connected = false;

    private final HBox container = new HBox();
    private TextField usernameTxf = new TextField();
    private Button connectBtn = new Button("Connect");
    private ListView<String> chatBox = new ListView<>();
    private TextField chatInputTxf = new TextField();
    private Button sendBtn = new Button("Send Message");
    private ListView<User> userList = new ListView<>();

    private ObservableList<User> users = FXCollections.observableArrayList();
    private ObservableList<String> messages = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(container);
        container.setPrefSize(600, 400);
        container.setSpacing(10);
        container.setPadding(new Insets(10));
        primaryStage.setScene(scene);
        primaryStage.show();
        initGui();
        initListeners();
    }

    public void initGui() {
        VBox ccleft = new VBox();
        VBox ccright = new VBox();

        container.getChildren().add(ccleft);
        container.getChildren().add(ccright);

        HBox loginBar = new HBox();
        HBox chatInput = new HBox();

        ccleft.getChildren().add(loginBar);
        ccleft.getChildren().add(chatBox);
        ccleft.getChildren().add(chatInput);
        ccright.getChildren().add(userList);

        // Loginbar

        connectBtn.setOnAction(event -> connect());


        loginBar.getChildren().add(usernameTxf);
        loginBar.getChildren().add(connectBtn);

        // Chatbox


        // Chat Input


        sendBtn.setOnAction(e -> sendMessage());

        chatInput.getChildren().add(chatInputTxf);
        chatInput.getChildren().add(sendBtn);

        // Styling
        ccleft.setSpacing(10);
        loginBar.setSpacing(10);
        chatInput.setSpacing(10);

        chatBox.setPrefWidth(450);
        userList.setPrefWidth(125);
        chatInputTxf.setPrefWidth(325);

    }

    public void connect() {
        if (!usernameTxf.getText().isEmpty() && !connected) {
            users.add(new User(usernameTxf.getText()));
            connected = true;
            usernameTxf.setDisable(true);
            connectBtn.setText("Connected");
        }
    }

    public void sendMessage() {
        if (connected) {
            messages.add(usernameTxf.getText() + ": " + chatInputTxf.getText());
            chatInputTxf.clear();
        }
    }

    public void initListeners() {
        userList.setItems(users);
        chatBox.setItems(messages);
    }
}