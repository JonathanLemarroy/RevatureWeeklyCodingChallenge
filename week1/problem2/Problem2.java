package week1.problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class Problem2 {

    /**
     * This can find the smallest and largest value in a List.
     * 
     * @param <E>
     * @param numbers
     * @return List<E> whose 0th index is the smallest and 1st index is the largest
     */
    public static <E extends Comparable<E>> List<E> findSmallestLargest(List<E> numbers){
        if(numbers.isEmpty())
            return null;
        E largest = numbers.get(0);
        E smallest = numbers.get(0);
        for(int i = 0; i < numbers.size(); i++){
            E value = numbers.get(i);
            if(value.compareTo(largest) > 0)
                largest = value;
            if(value.compareTo(smallest) < 0)
                smallest = value;
        }
        ArrayList<E> smallestLargest = new ArrayList<E>();
        smallestLargest.add(smallest);
        smallestLargest.add(largest);
        return smallestLargest;
    }

    /**
     * This finds the missing numbers in a List<Integer>. Time complexity is O(3n) 
     * where n is the difference between largest and smallest values
     * 
     * @param numbers
     * @return
     */
    public static List<Integer> findMissing(List<Integer> numbers){
        List<Integer> smallestLargest = findSmallestLargest(numbers);
        if(smallestLargest == null || smallestLargest.size() != 2)
            return null;
        boolean nums[] = new boolean[smallestLargest.get(1) - smallestLargest.get(0) + 1];
        ArrayList<Integer> missing = new ArrayList<Integer>();
        for(int i = 0; i < numbers.size(); i++){
            nums[numbers.get(i) - smallestLargest.get(0)] = true;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == false)
                missing.add(i + smallestLargest.get(0));
        }
        return missing;
    }

    public static void main(String[] args) {
        System.out.println("Problem 2");
        System.out.print("Find Min and Max: ");
        System.out.println(findSmallestLargest(Arrays.asList(1,4,4,6,7,6,12,9))); //You can replace this with command line arguments if desired
        System.out.print("Find missing elements: ");
        System.out.println(findMissing(Arrays.asList(1,4,4,6,7,6,12,9))); //You can replace this with command line arguments if desired
    }
}
