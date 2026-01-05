class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int sumInitial = 0;
        for(int i=0; i<k; i++)
            sumInitial+=arr[i];
        int maxSum = sumInitial;
        int n = arr.length;
        for(int i=k; i<n; i++){
            sumInitial+=arr[i];
            sumInitial-=arr[i-k];
            maxSum = Math.max(maxSum, sumInitial);
        }
        return maxSum;
    }
}
