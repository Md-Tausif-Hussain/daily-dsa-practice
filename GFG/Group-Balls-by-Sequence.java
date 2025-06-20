/*
🔵 Problem Title: Group Balls by Sequence
📅 Date: 2025-06-20
🧠 Approach: Frequency Counting + Greedy Grouping using TreeMap
*/

import java.util.TreeMap;

public class Solution {
    // Function to check if the array can be grouped into sets of size 'k' with consecutive numbers
    public boolean validgroup(int[] arr, int k) {
        // If total elements are not divisible by k, cannot group them equally
        if (arr.length % k != 0) return false;

        // TreeMap stores numbers in sorted order and counts their frequencies
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Try to form groups of k consecutive numbers starting from the smallest
        while (!countMap.isEmpty()) {
            int first = countMap.firstKey(); // Smallest available number

            // Try to form a sequence of k numbers starting from 'first'
            for (int i = 0; i < k; i++) {
                int num = first + i;

                // If required number is missing, return false
                if (!countMap.containsKey(num)) {
                    return false;
                }

                // Use one occurrence of the number
                countMap.put(num, countMap.get(num) - 1);

                // Remove number from map if its frequency becomes 0
                if (countMap.get(num) == 0) {
                    countMap.remove(num);
                }
            }
        }

        // Successfully formed all groups
        return true;
    }
}
