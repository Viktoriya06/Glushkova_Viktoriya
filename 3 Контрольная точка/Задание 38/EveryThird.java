import java.util.ArrayList;
import java.util.List;

public class EveryThird {

    public static List<Integer> everyThird(int numPlayers, int startPlayer) {
        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(i);
        }

        List<Integer> eliminated = new ArrayList<>();
        int currentIndex = startPlayer - 1;

        while (players.size() > 1) {
            currentIndex = (currentIndex + 2) % players.size();
            eliminated.add(players.remove(currentIndex));
        }

        eliminated.addAll(players);
        return eliminated;
    }

    public static void main(String[] args) {
        int numPlayers = 7;
        int startPlayer = 1;
        List<Integer> eliminated = everyThird(numPlayers, startPlayer);
        System.out.println("Выбывшие игроки: " + eliminated);
    }
}

