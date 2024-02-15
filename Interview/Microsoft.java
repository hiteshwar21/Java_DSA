package Interview;

public class Microsoft {
    public static void main(String[] args) {
        String R = "B";
        int[] V = {100};
        int[] result2 = solution2(R,V);
        System.out.println(result2);
    }

    public static int[] solution2(String recipients, int[] amounts) {
        int minimumA = 0;
        int minimumB = 0;

        int balanceA = 0;
        int balanceB = 0;

        for (int idx = 0; idx < recipients.length(); idx++) {
            if (recipients.charAt(idx) == 'A') {
                balanceA += amounts[idx];
                balanceB -= amounts[idx];
                if (balanceB < minimumB) {
                    minimumB = balanceB;
                }
            } else if (recipients.charAt(idx) == 'B') {
                balanceB += amounts[idx];
                balanceA -= amounts[idx];
                if (balanceA < minimumA) {
                    minimumA = balanceA;
                }
            }
        }

        return new int[] { -minimumA, -minimumB };
    }
}
