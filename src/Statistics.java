import java.io.*;

public class Statistics implements Serializable {
    private int userWins;
    private int aiWins;
    private int ties;

    public Statistics() {
        userWins = 0;
        aiWins = 0;
        ties = 0;
    }

    public void incrementUserWins() {
        userWins++;
    }

    public void incrementAiWins() {
        aiWins++;
    }

    public void incrementTies() {
        ties++;
    }

    public int getUserWins() {
        return userWins;
    }

    public int getAiWins() {
        return aiWins;
    }

    public int getTies() {
        return ties;
    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }

    public static Statistics loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Statistics) ois.readObject();
        }
    }
}