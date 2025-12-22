// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int n = arr.length;
        int m = arr[0].length;
        int row = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            int temp = 0;
            for(int j=0; j<m; j++){
                if(arr[i][j]==1){
                    break;
                }
                else{
                    temp++;
                }
            }
            if((m-temp)>count){
                row = i;
                count = m-temp;
            }
        }
        return row;
    }
}
