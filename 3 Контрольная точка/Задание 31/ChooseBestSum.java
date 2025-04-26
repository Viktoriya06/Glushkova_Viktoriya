import java.util.Arrays;

public class ChooseBestSum {

    public static Integer chooseBestSum(int t, int k, int[] ls) {
        if (ls == null || ls.length < k) {
            return null;
        }

        Arrays.sort(ls);
        Integer bestSum = null;


        bestSum = findBestSumRecursive(ls, k, t, 0, 0, 0);

        return bestSum;
    }

    private static Integer findBestSumRecursive(int[] ls, int k, int t, int index, int count, int currentSum) {
        if (count == k) {
            if (currentSum <= t) {
                return currentSum;
            } else {
                return null;
            }
        }

        if (index >= ls.length) {
            return null;
        }

        Integer include = findBestSumRecursive(ls, k, t, index + 1, count + 1, currentSum + ls[index]);
        Integer exclude = findBestSumRecursive(ls, k, t, index + 1, count, currentSum);

        if (include == null && exclude == null) {
            return null;
        } else if (include == null) {
            return exclude;
        } else if (exclude == null) {
            return include;
        } else {
            return Math.max(include, exclude);
        }
    }

    public static void main(String[] args) {
        int[] ts = {50, 55, 56, 57, 58};
        System.out.println(chooseBestSum(163, 3, ts));
    }
}
