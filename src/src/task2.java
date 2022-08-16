import java.util.HashSet;
import java.util.Set;

/**
 * Find subarray with given sum.
 * Iterate to find cumulatove sum, and use a HashSet to store the aggregated value. Find from the SEt if the target-sum exists or not
 * Time Complexity O(n)
 * Space Complexity O(n)
 */
public class task2 {

    public static boolean findSubArraySum(int[] input , int length , int sum) {
        int aggregated_sum = 0;
       Set<Integer> set = new HashSet<>();// Set to store the aggregated sum

        for (int i = 0; i < length; i++) {
            aggregated_sum = aggregated_sum + input[i];//Get a cumulative sum of all the inputs so far
            if (set.contains(aggregated_sum - sum)) { // When there is a key found, the subarray with target sum exists
                return true;
            }
            set.add(aggregated_sum);
        }
        return false;
    }
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4};
        int len = arr.length;
        int sumCheck1 = 7;
        boolean result_true = findSubArraySum(arr, len, sumCheck1);

        System.out.println("The subarray{1,2,3,4} with given sum {7} exists ? " + result_true);

        int sumCheck2 = 8;
        boolean result_false = findSubArraySum(arr, len, sumCheck2);

        System.out.println("The subarray{1,2,3,4} with given sum{8} exists ?" + result_false);
    }

}
