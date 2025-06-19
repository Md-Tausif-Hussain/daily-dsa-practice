// Problem: Case-specific Sorting of Strings
// Platform: GeeksforGeeks
// Date: 2025-06-19
// Problem Link: https://www.geeksforgeeks.org/problems/case-specific-sorting-of-strings4845/1

import java.util.*;

class Solution {
    public static String caseSort(String s) {
        ArrayList<Character> lower = new ArrayList<>();
        ArrayList<Character> upper = new ArrayList<>();
        
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch))
                lower.add(ch);
            else
                upper.add(ch);
        }
        
        Collections.sort(lower);
        Collections.sort(upper);
        
        StringBuilder ans = new StringBuilder();
        int lIndex = 0, uIndex = 0;
        
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch))
                ans.append(lower.get(lIndex++));
            else
                ans.append(upper.get(uIndex++));
        }
        
        return ans.toString();
    }
}
