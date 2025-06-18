// Problem: Smallest Divisor
// Platform: GeeksforGeeks
// Date: 2025-06-15
// Problem Link: https://www.geeksforgeeks.org/problems/smallest-divisor/1

import java.util.Arrays;

class Solution {
    int smallestDivisor(int[] arr, int k) {
        int lo = 1, hi = Arrays.stream(arr).max().getAsInt(), ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (chec(arr, mid, k)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    static boolean chec(int[] arr, int possibleAns, int k) {
        int sum = 0;
        for (int i : arr) {
            sum += (i + possibleAns - 1) / possibleAns;  // same as ceil(i / possibleAns)
        }
        return sum <= k;
    }
}
