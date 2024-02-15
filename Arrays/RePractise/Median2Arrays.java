package Arrays.RePractise;

/*Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
        The overall run time complexity should be O(log (m+n)) .
        Example 1: Input: nums1 = [1,3], nums2 = [2] Output: 2.00000 Explanation: merged array = [1,2,3] and median is 2.*/

public class Median2Arrays {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,6,8,10};
        System.out.println(findMedianBasic(arr1, arr2));
        System.out.println(findMedianBinarySearch(arr1, arr2));
        //Can use PriorityQueue too
        //System.out.println(findMedianHeap(arr1, arr2));
    }

    static double findMedianBasic(int[] arr1, int[] arr2) {
        int medianSize = arr1.length + arr2.length;
        int arr1Size = arr1.length;
        int arr2Size = arr2.length;
        double result = 0.0;

        if (arr1Size == 0 && arr2Size == 0) {
            System.out.println("Not possible");
            return result;
        } else if (arr1Size == 0) {
            if (arr2Size % 2 == 0) {
                result = (double) (arr2[arr2Size / 2] + arr2[arr2Size / 2 - 1]) / 2;
            } else {
                result = arr2[arr2Size / 2];
            }
        } else if (arr2Size == 0) {
            if (arr1Size % 2 == 0) {
                result = (double) (arr1[arr1Size / 2] + arr1[arr1Size / 2 - 1]) / 2;
            } else {
                result = arr1[arr1Size / 2];
            }
        } else {
            int itr = 0;
            int idx1 = 0, idx2 = 0;

            int median = medianSize/2;
            while (itr < median) {
                if (arr1[idx1] > arr2[idx2]) {
                    idx2++;
                } else {
                    idx1++;
                }
                itr++;
            }
            result = Math.min(arr1[idx1], arr2[idx2]);
            if (arr1[idx1] < arr2[idx2]) {
                idx1++;
                idx2--;
            } else {
                idx2++;
                idx1--;
            }
            if (medianSize % 2 == 0) {
                if(idx1<arr1Size && idx2<arr2Size) {
                    result += Math.min(arr1[idx1], arr2[idx2]);
                } else if(idx1 == arr1Size) {
                    result += arr2[idx2];
                } else if (idx2 == arr2Size) {
                    result += arr1[idx1];
                }
                result = result / 2.0;
            }
        }

        return result;
    }

    /*static double findMedianBinarySearch(int[] arr1, int[] arr2) {
        arr1 : {1,3,5}
        arr2 : {2,4,6,8}
        Median : 4

        arr1 : 1,2,3
        arr2 : 4,5,6,7
        Median : 4

        **Assumptions:
         1. arr1 is the smaller of the 2 arrays always.
         2.

        Base Case : Both array empty, return "not possible"

        Case 1: Any of the arrays is empty, return median of the other array.

        Case 2: arr1[end] < arr[start], entry of arr2[median-arr1.length]

        Case 3:
     */

    static double findMedianBinarySearch(int[] arr1, int[] arr2) {
        int size1 = arr1.length;
        int size2 = arr2.length;
        if(size1 > size2){
            return findMedianBinarySearch(arr2, arr1);
        }
        int start = 0, end = size1;
        int realMid = (arr1.length+arr2.length + 1)/2;

        while (start <= end) {
            int mid = start + (end-start)/2;
            int leftAsize = mid;
            int leftBsize = realMid - mid;
            int leftA
                    = (leftAsize > 0)
                    ? arr1[leftAsize - 1]
                    : Integer
                    .MIN_VALUE; // checking overflow
            // of indices
            int leftB = (leftBsize > 0) ? arr2[leftBsize - 1]
                    : Integer.MIN_VALUE;
            int rightA = (leftAsize < size1)
                    ? arr1[leftAsize]
                    : Integer.MAX_VALUE;
            int rightB = (leftBsize < size2)
                    ? arr2[leftBsize]
                    : Integer.MAX_VALUE;

            // if correct partition is done
            if (leftA <= rightB && leftB <= rightA) {
                if ((size1 + size2) % 2 == 0)
                    return (Math.max(leftA, leftB)
                            + Math.min(rightA, rightB))
                            / 2.0;
                return Math.max(leftA, leftB);
            }
            else if (leftA > rightB) {
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return 0.0;
    }
}
