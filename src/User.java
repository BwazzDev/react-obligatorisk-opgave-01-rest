public class User {
    private final String name;
    private static int id = 1000;
    private final int userID;

    public User(String name) {
        this.name = name;
        this.userID = id;
        id++;
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return userID + " | " + name;
    }
}
