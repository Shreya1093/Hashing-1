/*49. Group Anagrams
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */

/*Time Complexity:O(n)
*Space Complexity:O(1)
Approach:Create a map from prime product (as double) → list of anagrams.
For each string:
Compute its prime product by multiplying prime values of its characters.
Use this product as a key in the map.
Add the string to the list for that key.
Return all values from the map as grouped anagrams.*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Edge case: If input is null or empty, return empty list
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        // Map to store prime product as key and list of anagrams as value
        HashMap<Double, List<String>> map = new HashMap<>();
        // Iterate through each word
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            // Compute the unique prime product key for the word
            double primeProduct = primeProduct(s);
            // If key doesn't exist, initialize the list
            if (!map.containsKey(primeProduct)) {
                map.put(primeProduct, new ArrayList<>());
            }
            // Add the string to the corresponding anagram group
            map.get(primeProduct).add(s);
        }
        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }

    // method to compute the product of primes corresponding to each character
    private double primeProduct(String s) {
        // 26 prime numbers for characters a-z
        int[] primes = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101, 103 };
        double result = 1.0;
        // Multiply primes corresponding to characters
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result = result * primes[c - 'a'];
        }
        return result;
    }
}