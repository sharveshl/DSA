class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        int ind = 0;
        while(ind<=maxIndex && ind<n){
            maxIndex = Math.max(maxIndex, nums[ind]+ind);
            ind++;
        }
        return maxIndex>=n-1;
    }
}