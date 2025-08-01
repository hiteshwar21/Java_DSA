package EPAMCoding;

import java.util.Arrays;
import java.util.Comparator;

public class fetchMinIntervalCost {
    public static void main(String[] args) {
        int[][] segments ={{1, 3, 5},{4, 6, 2}, {2, 5, 3},{7, 8, 1}};
        System.out.println(minProductOfNonOverlappingSegments(segments));
    }

    public static int minProductOfNonOverlappingSegments(int[][] segments){
        Arrays.sort(segments, Comparator.comparingInt(s -> s[1] ));
        int minCostProduct = Integer.MAX_VALUE;
        int i=1;
        while (i < segments.length) {
            int currStartValue = segments[i][0];
            int prevEndValue = segments[i-1][1];

            if(prevEndValue<=currStartValue) {
                minCostProduct = Math.min(minCostProduct, segments[i][2]*segments[i-1][2]);
            }
            i++;
        }
        return minCostProduct;
    }

}
