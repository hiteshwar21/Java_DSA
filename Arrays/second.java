package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Main {

    public static int solution(String s, List<Integer> c) {
        int left = 0, right = c.size();
        while (left <= right) {
            int mid = left + (right-left)/2;
            HashSet<Integer> all = new HashSet<>(c.subList(0, mid));
            int[] have = new int[26];
            Arrays.fill(have, -1);
            boolean mark = true;
            for (int i = 0, temp = -1; mark && i < s.length(); ++i) {
                int p = s.charAt(i) - 'a';
                if (have[p] > temp) {
                    mark = false;
                }
                have[p] = i;
                if (all.contains(i + 1)) {
                    temp = i;
                }
            }
            if (mark) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ++right > c.size() ? (-1) : right;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,2};
        System.out.println(solution("aabcba", Arrays.asList(1, 5, 2)));
    }
}
