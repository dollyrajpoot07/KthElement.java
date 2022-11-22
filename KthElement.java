// K-th Element of Two Sorted Arrays

// Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the k’th position of the final sorted array.

// Examples: 

// Input : Array 1 - 2 3 6 7 9
//         Array 2 - 1 4 8 10
//         k = 5
// Output : 6
// Explanation: The final sorted array would be -
// 1, 2, 3, 4, 6, 7, 8, 9, 10
// The 5th element of this array is 6.

// Input : Array 1 - 100 112 256 349 770
//         Array 2 - 72 86 113 119 265 445 892
//         k = 7
// Output : 256
// Explanation: Final sorted array is -
// 72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
// 7th element of this array is 256.

class KthElement {

    static long maxN = (long) 1e10;

    static int upperBound(int[] a, int low, int high, long element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (a[middle] > element)
                high = middle;
            else
                low = middle + 1;
        }
        return low;
    }

    static long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        long left = 1, right = maxN;
        long ans = (long) 1e15;

        while (left <= right) {
            long mid = (left + right) / 2;
            long up_cnt = upperBound(arr1, 0, n, mid);
            up_cnt += upperBound(arr2, 0, m, mid);

            if (up_cnt >= k) {
                ans = Math.min(ans,
                        mid);
                right = mid - 1;
            } else
                left = mid + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5, m = 7, k = 7;
        int arr1[] = { 100, 112, 256, 349, 770 };
        int arr2[] = { 72, 86, 113, 119, 265, 445, 892 };
        System.out.print(kthElement(arr1, arr2, n, m, k) + "\n");
    }
}
