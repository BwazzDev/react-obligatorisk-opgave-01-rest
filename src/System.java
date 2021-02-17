import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class System {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String> messages = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void addMessage(String message) {
        messages.add(message);
    }
}
