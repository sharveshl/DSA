// User function Template for Java

class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        // code here
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> pos = new HashMap<>();
        for(int i=0; i<sorted.length; i++)
            pos.put(sorted[i], i);
        for(int i=0; i<n; i++){
            int p = pos.get(arr[i]);
            if(Math.abs(i-p)>k)
                return "No";
        }
        return "Yes";
    }
}