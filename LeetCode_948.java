import java.util.Arrays;

public class LeetCode_948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        int count = 0;
        Arrays.sort(tokens);
        int left = 0, right = n - 1;
        int maxScore = 0;
        while (left <= right) {
            if (tokens[left] <= power) {
                power -= tokens[left++];
                count++;
                maxScore = Math.max(maxScore, count);
            } else if (count > 0) {
                power += tokens[right--];
                count--;
            } else {
                break;
            }
        }
        return maxScore;
    }
    public static void main(String[] args) {
        LeetCode_948 solution = new LeetCode_948();

        // Example usage:
        int[] tokens = {100, 200, 300, 400};
        int power = 200;
        int maxScore = solution.bagOfTokensScore(tokens, power);

        System.out.println("Maximum Score: " + maxScore);
    }
}
