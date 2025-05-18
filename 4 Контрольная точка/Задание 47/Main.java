import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution47 {
    public static int[] snail(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return new int[0];
        }

        int rows = array.length;
        int cols = array[0].length;
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        int dir = 0; // 0: right, 1: down, 2: left, 3: up

        while (top <= bottom && left <= right) {
            if (dir == 0) { // right
                for (int i = left; i <= right; i++) {
                    result.add(array[top][i]);
                }
                top++;
            } else if (dir == 1) { // down
                for (int i = top; i <= bottom; i++) {
                    result.add(array[i][right]);
                }
                right--;
            } else if (dir == 2) { // left
                for (int i = right; i >= left; i--) {
                    result.add(array[bottom][i]);
                }
                bottom--;
            } else if (dir == 3) { // up
                for (int i = bottom; i >= top; i--) {
                    result.add(array[i][left]);
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(snail(array1)));

        int[][] array2 = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        System.out.println(Arrays.toString(snail(array2)));

        int[][] array3 = {{1}};
        System.out.println(Arrays.toString(snail(array3)));

        int[][] array4 = {};
        System.out.println(Arrays.toString(snail(array4)));

        int[][] array5 = {{1,2}, {3,4}};
        System.out.println(Arrays.toString(snail(array5)));
    }
}
