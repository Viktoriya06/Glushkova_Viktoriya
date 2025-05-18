import java.util.Set;
import java.util.TreeSet;
import java.util.Queue;
import java.util.LinkedList;

class Solution48 {
    public static Set<Integer> generateU(int limit) {
        Set<Integer> u = new TreeSet<>(); 
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        u.add(1);

        while (u.size() < limit) {
            int x = queue.poll();
            int y = 2 * x + 1;
            int z = 3 * x + 1;

            if (!u.contains(y) && u.size() < limit) {
                u.add(y);
                queue.add(y);
            }
            if (!u.contains(z) && u.size() < limit) {
                u.add(z);
                queue.add(z);
            }
        }

        return u;
    }

    public static void main(String[] args) {
        Set<Integer> result = generateU(12);
        System.out.println(result);

        Set<Integer> result2 = generateU(20);
        System.out.println(result2);
    }
}

