package Interview;

import java.util.Arrays;
import java.util.Scanner;

public class Apple1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int[] giftBox = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        System.out.println();

        int result = minArrayDiff(giftBox);
        System.out.println(result);

        scanner.close();
    }


    public static int minArrayDiff(int[] giftBoxes) {
        Arrays.sort(giftBoxes);
        int n = giftBoxes.length;

        // Calculate the sum of the gift items
        int totalSum = Arrays.stream(giftBoxes).sum();

        // Calculate the target average
        int targetAvg = totalSum / n;

        // Calculate the minimum difference after redistributing
        int minDiff = 0;
        for (int i = 0; i < n - 1; i++) {
            int diff = targetAvg - giftBoxes[i];
            minDiff += Math.abs(diff);
            giftBoxes[i] += diff;
            giftBoxes[i + 1] -= diff;
        }

        return minDiff;
    }

}