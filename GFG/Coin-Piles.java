/*
🔐 Problem Title: Coin Piles
🌐 Platform: GFG
📅 Date: 2025-06-17
🧠 Approach: Sorting + Prefix Sum + Binary Search (Upper Bound)
*/

import java.util.Arrays;

class Solution {

    // Function to compute the minimum number of coins to be added/removed
    public int minimumCoins(int[] arr, int k) {
        // Sort the array for prefix sums and binary search to work correctly
        Arrays.sort(arr);
        int n = arr.length;

        // Create prefix sum array to quickly get sum of first i elements
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int ans = Integer.MAX_VALUE; // Initialize answer with max possible value

        // Try fixing each element as the base value
        for (int i = 0; i < n; i++) {
            int remLeft = prefix[i]; // Cost to reduce elements to the left of i
            int upper = upperBound(arr, arr[i] + k); // Find index where elements > arr[i] + k
            int remRight = prefix[n] - prefix[upper] - (n - upper) * (arr[i] + k); // Cost to reduce larger elements
            ans = Math.min(ans, remLeft + remRight); // Update minimum cost
        }

        return ans;
    }

    // Binary search to find the index of the first element greater than value
    static int upperBound(int[] arr, int v) {
        int lo = 0, hi = arr.length - 1, ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= v) {
                lo = mid + 1;
                ans = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}
