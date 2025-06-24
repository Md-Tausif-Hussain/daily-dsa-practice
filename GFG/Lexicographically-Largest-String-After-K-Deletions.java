/*
🔠 Problem Title: Lexicographically Largest String After K Deletions
🌐 Platform: GFG
📅 Date: 2025-06-24
🧠 Approach: Monotonic Stack (Greedy) using StringBuilder
*/

class Solution {
    public String maxSubseq(String s, int k) {
        int n = s.length();
        int toRemove = k;                    
        StringBuilder result = new StringBuilder(); 

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            // Remove smaller characters from the end while deletions remain
            while (result.length() > 0 && toRemove > 0 && c > result.charAt(result.length() - 1)) {
                result.deleteCharAt(result.length() - 1);
                toRemove--;
            }
            
            result.append(c); 
        }

        // Trim to desired length if extra characters are present
        result.setLength(n - k);
        return result.toString();
    }
}
