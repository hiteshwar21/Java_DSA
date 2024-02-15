package Interview;

import java.util.*;
import java.util.stream.Collectors;

public class EPAM {

/*    start[] = 7pm,6pm,8pm -> 18, 19, 21
      end[] =  8pm,8pm,10pm -> 20,

      19  6
      21  8

      int[] bookedTimes = 23
      [18] -1
      [19] -1
      [20] -1
 count++

 5,6,7

      telephone booth appointment. How many people can use that telephone?
      constraints : 12 AM - 11 PM -> 00 - 23  , unsorted Array, no extra space
      Sort: O(n Log n). Don't do it.
      Hint: Array Comparison,
    output: 2


    arr[] = {3, 1, 5, 2, 4}
    5 people in party. We need to move from left to right. We need to find the person who is just smaller than the current person

    O/P : 2;
    Explanation : {1, 0, 1,


    arr[] = {5,10, 6, 15, 20, 25, 7}
    O/P : 4
    Explanation :
    For(int i :
    Brute Force - O(N^2)


    // minValue = 6
    count++


    Create a list in main

    */
    public static void main(String[] args) {
        //getPeopleCount(start, end);
        int[] arr = {5,10, 6, 15, 20, 25, 7};
        List<String> gender = new ArrayList<>();
        gender.add("Male");
        gender.add("Female");
        gender.add("Female");
        Map<String, Long> genderCount = gender.
                stream().
                collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        Map<String, Long> sortedGenderCount = genderCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry:: getKey,
                                Map.Entry:: getValue,
                                (e1,e2) -> e1, LinkedHashMap::new));
        System.out.println(genderCount);
        System.out.println(sortedGenderCount);
        // Sample list of genders
        List<String> genderList = Arrays.asList("Male", "Female", "Male", "Female", "Non-Binary", "Male", "Female");

        // Using Streams and Lambda to find the count of different genders
        Map<String, Long> genderCountMap = genderList.stream()
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        // Print the result
        System.out.println("Gender Count: " + genderCountMap);
        System.out.println("Small Count to Right will be : " + getSmallCountToRight(arr));
    }

    static int getPeopleCount(int[] start, int[] end){
        int currPerson = 0, count =0;
        for(int i=1; i< start.length;i++){
            if(end[currPerson] <= start[i]){
                count++;
                currPerson = i;
            }
        }
        return count;
    }

    static int getSmallCountToRight(int[] arr){
        // arr[] = {5,10, 6, 15, 20, 25, 7}
        int minValue = arr[arr.length-1];
        int count = 0;
        for(int i = arr.length - 2 ; i>=0; i--){
            if(arr[i] > minValue){
                count++;
            } else{
                minValue = arr[i];
            }
        }
        return count;
    }



}
