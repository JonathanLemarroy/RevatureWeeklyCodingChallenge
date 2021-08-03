package week1.problem1;

import java.util.ArrayList;
import java.util.List;

public abstract class Problem1 {

    private static StringBuilder builder = new StringBuilder();

    private static void conbinationGenerator(int index, String str, List<String> combinations){
        for(int i = index; i < str.length(); i++){
            builder.append(str.charAt(i));
            combinations.add(builder.toString());
            conbinationGenerator(i + 1, str, combinations);
            builder.setLength(builder.length() - 1);
        }
    }

    public static String longestCommonSubsequences(String str1, String str2){
        ArrayList<String> str1Combinations = new ArrayList<String>();
        ArrayList<String> str2Combinations = new ArrayList<String>();
        conbinationGenerator(0, str1, str1Combinations);
        conbinationGenerator(0, str2, str2Combinations);
        String longest = "";
        for(int i = 0; i < str1Combinations.size(); i++){
            for(int j = 0; j < str2Combinations.size(); j++){
                if(str1Combinations.get(i).length() > longest.length() && str1Combinations.get(i).equals(str2Combinations.get(j)))
                    longest = str1Combinations.get(i);

            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println("Problem 1");
        System.out.print("Longest Common Subsequence: ");
        System.out.println(longestCommonSubsequences("Minneapolis", "Minnesota")); // This can be changed to input from command line
    }
}
