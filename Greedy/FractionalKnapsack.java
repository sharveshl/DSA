class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        ArrayList<ItemNode> arr = new ArrayList<>();
        for(int i=0; i<val.length; i++){
            arr.add(new ItemNode(val[i], wt[i]));
        }
        Collections.sort(arr, (a,b)->Double.compare((b.val/b.wt),(a.val/a.wt)));
        int i = 0;
        int n = val.length;
        double cost = 0;
        while(i<n && capacity>0){
            if(arr.get(i).wt<=capacity){
                cost+=arr.get(i).val;
                capacity-=arr.get(i).wt;
            }
            else{
                cost+=(capacity/arr.get(i).wt)*arr.get(i).val;
                capacity = 0;
            }
            i++;
        }
        return cost;
    }
}
class ItemNode{
    double val;
    double wt;
    public ItemNode(double val, double wt){
        this.val = val;
        this.wt = wt;
    }
}