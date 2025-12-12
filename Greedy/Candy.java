class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = 1;
        r[n-1] = 1;
        int maxCandy = 0;
        for(int i=1; i<n; i++){
            if(ratings[i]>ratings[i-1]){
                l[i] = l[i-1]+1;
            }
            else{
                l[i] = 1;
            }
        }
        for(int i=n-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                r[i] = r[i+1]+1;
            }
            else
                r[i] = 1;
        }
        for(int i=0; i<n; i++){
            maxCandy+=Math.max(l[i],r[i]);
        }
        return maxCandy;
    }
    public int candy(int[] ratings) {
        int n = ratings.length;
        int peak;
        int valley;
        int candies = n;
        int i = 1;
        while(i<n){
            if(ratings[i]==ratings[i-1]){
                i+=1;
                continue;
            }
                
            peak = 0;
            while(i<n && ratings[i]>ratings[i-1]){
                peak+=1;
                candies+=peak;
                i++;
            }
            valley = 0;
            while(i<n && ratings[i]<ratings[i-1]){
                valley+=1;
                candies+=valley;
                i++;
            }
            candies-=Math.min(valley, peak);
        }
        return  candies;
    }
}