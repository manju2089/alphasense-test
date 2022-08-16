import java.util.HashMap;
import java.util.Map;

/**
 * Program to find length of Longest Substring
 * Iterate till we find a repeated char, and the rest of the chars are skipped once we find next repeated char by using map index.
 * Time Complexity O(n)
 * Space Complexity O(min(m,n))
 */
public class task1 {

    public static int lenOfLongestSubstring(String input) {
        int len = input.length(), result = 0;
        Map<Character, Integer> map = new HashMap<>(); // map to store character with curr index
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < len; j++) {
            // When a same character is seen, move the sliding pointer and for every iteration find the maximum length to be returned.
            if (map.containsKey(input.charAt(j))) {
                i = Math.max(map.get(input.charAt(j)), i);
            }
            result = Math.max(result, j - i + 1);
            map.put(input.charAt(j), j + 1);
        }
        return result;
    }

    public static void main(String[] args)
    {
        int resultSet1 = lenOfLongestSubstring("abcabcbb"); //test string 1
        int resultSet2 = lenOfLongestSubstring("bbbbb"); // test string 2
        int resultSet3 = lenOfLongestSubstring("pwwkew"); // test string 3

        System.out.println("The longest substring without repeating chars for abcabcbb is "+ resultSet1);
        System.out.println("The longest substring without repeating chars for bbbbb is "+ resultSet2);
        System.out.println("The longest substring without repeating chars for pwwkew is "+ resultSet3);
    }
}
