/* 290. Word Pattern
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:
Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.
Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Explanation:
The bijection can be established as:
'a' maps to "dog".
'b' maps to "cat".
Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
 */

/*Time Complexity:O(nk)->n = length of the pattern,k = average length of each word in the string s
 *Space Complexity:O(nk)
 Approach:A HashMap<Character, String> to map pattern letters to words.A HashSet<String> to ensure that no two pattern letters map to the same word
 */

import java.util.HashMap;
import java.util.HashSet;

class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        // Splitting the input string into words using space as delimiter
        String[] words = s.split(" ");
        // Length mismatch means immediate failure
        if (pattern.length() != words.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();// pattern letter → word
        HashSet<String> set = new HashSet<>();// tracks words already assigned
        // Loop through the pattern and words simultaneously
        for (int i = 0; i < words.length; i++) {
            char letter = pattern.charAt(i); // current pattern character
            String word = words[i]; // current word from string
            // If the pattern character is already mapped
            if (map.containsKey(letter)) {
                // Check if the existing mapping matches the current word
                if (!map.get(letter).equals(word)) {
                    return false; // mismatch found — return false
                }
            } else {
                // If the word is already mapped to another pattern character
                if (set.contains(word)) {
                    return false; // violates one-to-one mapping — return false
                }
                // Add new mapping and mark the word as used
                map.put(letter, word);
                set.add(word);
            }
        }
        // All characters and words match the pattern — return true
        return true;
    }
}