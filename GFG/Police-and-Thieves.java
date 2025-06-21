/*
🚓 Problem Title: Police and Thieves
🌐 Platform: GeeksforGeeks
📅 Date: 2025-06-21
🧠 Approach: Two-pointer technique with separate lists for police and thieves
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int catchThieves(char[] arr, int k) {
        int n = arr.length;

        // Lists to store indices of police and thieves
        List<Integer> police = new ArrayList<>();
        List<Integer> thieves = new ArrayList<>();

        // Separate out police and thieves
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') police.add(i);
            else if (arr[i] == 'T') thieves.add(i);
        }

        int i = 0, j = 0, count = 0;

        // Two-pointer technique to pair police with nearby thieves
        while (i < police.size() && j < thieves.size()) {
            if (Math.abs(police.get(i) - thieves.get(j)) <= k) {
                count++; // Thief caught
                i++;
                j++;
            } else if (police.get(i) < thieves.get(j)) {
                i++; // Move police pointer
            } else {
                j++; // Move thief pointer
            }
        }

        return count;
    }
}
