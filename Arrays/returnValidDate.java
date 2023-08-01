package Arrays;

import java.util.ArrayList;
import java.util.List;

public class returnValidDate {
    public static void main(String[] args) {
        String result = solution("02-??");
        System.out.println(result);
    }

    public static String solution(String date) {
        // Split the date string into month and day components
        String[] components = date.split("-");
        String month = components[0];
        String day = components[1];

        // Generate all possible combinations for the question marks
        List<String> possibleMonths = generateCombinations(month);
        List<String> possibleDays = generateCombinations(day);

        String latestDate = "xx-xx"; // Initialize with the default invalid value

        // Iterate through all combinations and find the latest valid date
        for (String possibleMonth : possibleMonths) {
            for (String possibleDay : possibleDays) {
                if (isValidDate(possibleMonth, possibleDay)) {
                    // Check if the current valid date is later than the latest found
                    if (isLaterDate(possibleMonth, possibleDay, latestDate)) {
                        latestDate = possibleMonth + "-" + possibleDay;
                    }
                }
            }
        }

        return latestDate;
    }

    private static void generateCombinationsHelper(String prefix, String remaining, List<String> combinations) {
        if (remaining.isEmpty()) {
            combinations.add(prefix);
            return;
        }

        char c = remaining.charAt(0);
        if (c == '?') {
            for (char digit = '0'; digit <= '9'; digit++) {
                generateCombinationsHelper(prefix + digit, remaining.substring(1), combinations);
            }
        } else {
            generateCombinationsHelper(prefix + c, remaining.substring(1), combinations);
        }
    }

    private static List<String> generateCombinations(String component) {
        List<String> combinations = new ArrayList<>();
        generateCombinationsHelper("", component, combinations);
        return combinations;
    }

    // Helper function to generate all possible combinations for a given component
    //private static List<String> generateCombinations(String component) {


    // Helper function to check if a date is valid
    private static boolean isValidDate(String month, String day) {
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(day);

        // Check if the month and day are within valid ranges
        if (m >= 1 && m <= 12 && d >= 1) {
            switch (m) {
                case 2: // February
                    return d <= 28;
                case 4: // April
                case 6: // June
                case 9: // September
                case 11: // November
                    return d <= 30;
                default: // Other months
                    return d <= 31;
            }
        }
        return false;
    }

    // Helper function to compare two dates and check if the first one is later
    private static boolean isLaterDate(String month1, String day1, String date2) {
        int m1 = Integer.parseInt(month1);
        int d1 = Integer.parseInt(day1);
        if (date2.equals("xx-xx")) {
            return true; // If date2 is invalid, consider the first date as later
        }
        String[] components2 = date2.split("-");
        int m2 = Integer.parseInt(components2[0]);
        int d2 = Integer.parseInt(components2[1]);
        if (m1 > m2) {
            return true;
        } else if (m1 == m2 && d1 > d2) {
            return true;
        }
        return false;
    }
}





