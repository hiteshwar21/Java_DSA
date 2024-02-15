package Interview;

import java.util.Arrays;
import java.util.Scanner;

public class Apple {
    /*public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        System.out.println(input);

        int[] savingFactors = Arrays.stream(input[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(savingFactors);
        int[] fertilizerBags = Arrays.stream(input[1].split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(fertilizerBags);

        int result = maximizeSavedPlants(savingFactors, fertilizerBags);
        System.out.println(result);

        scanner.close();
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the first array
        //System.out.print("Enter the elements for the first array (space-separated): ");
        String[] input1 = scanner.nextLine().split("\\s+");
        int[] array1 = new int[input1.length];
        for (int i = 0; i < input1.length; i++) {
            array1[i] = Integer.parseInt(input1[i]);
        }

        // Input for the second array
        //System.out.print("Enter the elements for the second array (space-separated): ");
        String[] input2 = scanner.nextLine().split("\\s+");
        int[] array2 = new int[input2.length];
        for (int i = 0; i < input2.length; i++) {
            array2[i] = Integer.parseInt(input2[i]);
        }

        int result = maximizeSavedPlants(array1, array2);
        System.out.println(result);
    }

    private static int maximizeSavedPlants(int[] savingFactors, int[] fertilizerBags) {
        Arrays.sort(savingFactors);
        Arrays.sort(fertilizerBags);

        int savedPlants = 0;
        int bagIndex = 0;

        for (int factor : savingFactors) {
            while (bagIndex < fertilizerBags.length && fertilizerBags[bagIndex] < factor) {
                bagIndex++;
            }

            if (bagIndex < fertilizerBags.length) {
                savedPlants++;
                bagIndex++;
            } else {
                break; // No more suitable bags left
            }
        }

        return savedPlants;
    }
}
