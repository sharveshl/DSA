class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platform = 1;
        int result = 1;
        int i = 1;
        int j = 0;
        while(i<arr.length){
            if(arr[i]<=dep[j]){
                platform+=1;
                result = Math.max(result,platform);
                i++;
            }
            else{
                platform-=1;
                j++;
            }
        }
        return result;
    }
}
