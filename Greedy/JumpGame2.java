class Solution {
    public int jump(int[] nums) {
        int maxIndex = 0;
        int currentEnd = 0;
        int jump = 0;
        for(int i=0; i<nums.length-1; i++){
            maxIndex = Math.max(maxIndex, i+nums[i]);
            if(currentEnd==i){
                jump+=1;
                currentEnd = maxIndex;
            }
        }
        return jump;
    }
}