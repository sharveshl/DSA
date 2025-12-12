class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        // Arrays.sort(bills);
        for(int i:bills){
            if(i==5){
                five+=1;
            }
            else if(i==10){
                if(five>0){
                    five-=1;
                    ten+=1;
                }
                else{
                    return false;
                }
            }
            else{
                if(five>=1 && ten>0){
                    five-=1;
                    ten-=1;
                }
                else if(five>=3){
                    five-=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}