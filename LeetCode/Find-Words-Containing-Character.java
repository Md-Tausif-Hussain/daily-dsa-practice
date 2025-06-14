// Problem: Find Words Containing Character (LeetCode #2942)
// Platform: LeetCode
// Date: 2025-06-14
// Problem Link: https://leetcode.com/problems/2942-find-words-containing-character

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findWordsContainingChar(String[] words, char ch) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.indexOf(ch) != -1) {
                result.add(word);
            }
        }
        return result;
    }
}
