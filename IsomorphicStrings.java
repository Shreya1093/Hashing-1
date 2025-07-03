/* 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
Constraints:
1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
Example 1:
Input: s = "egg", t = "add"
Output: true
Explanation:
The strings s and t can be made identical by:
Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
 */

/*Time Complexity:O(n)
 *Space Complexity:O(1)
 Approach:A HashMap<Character, Character> to track mapping from s to t.A HashSet<Character> to avoid mapping.multiple s characters to the same t character
 */

import java.util.HashMap;
import java.util.HashSet;

class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        // If lengths differ, can't be isomorphic
        if (s.length() != t.length()) {
            return false;
        }
        // Map to track character mapping from s → t
        HashMap<Character, Character> sMap = new HashMap<>();
        // Set to track already mapped characters from t
        HashSet<Character> set = new HashSet<>();
        // Iterate through both strings
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i); // character from s
            char tChar = t.charAt(i); // character from t
            // If mapped character doesn't match current tChar, not isomorphic
            if (sMap.containsKey(sChar)) {
                if (sMap.get(sChar) != tChar) {
                    return false;
                }
            } else {
                // If tChar already mapped to another sChar, conflict
                if (set.contains(tChar)) {
                    return false;
                }
                // Establish new mapping and mark tChar as used
                sMap.put(sChar, tChar);
                set.add(tChar);
            }
        }
        // All character mappings valid
        return true;
    }
}