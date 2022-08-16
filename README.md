# alphasense-test
Coding task 1. Longest substring without repeating characters.

/**
 * Program to find length of Longest Substring
 * Iterate till we find a repeated char, and the rest of the chars are skipped once we find next repeated char by using map index.
 * Time Complexity O(n)
 * Space Complexity O(min(m,n))
 */
 
 Execution Result:
 
 The longest substring without repeating chars for abcabcbb is 3
The longest substring without repeating chars for bbbbb is 1
The longest substring without repeating chars for pwwkew is 3


Coding task 2. Find subarray with given sum.

/**
 * Find subarray with given sum.
 * Iterate to find cumulatove sum, and use a HashSet to store the aggregated value. Find from the SEt if the target-sum exists or not
 * Time Complexity O(n)
 * Space Complexity O(n)
 */
 
  Execution Result:
  
  The subarray{1,2,3,4} with given sum {7} exists ? true
The subarray{1,2,3,4} with given sum{8} exists ?false
