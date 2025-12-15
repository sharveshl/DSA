/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    int max_col = 0;
    int min_col = 0;
    public void preOrder(Node root, int row, int col, HashMap<Integer,int[]> mp){
        if(root!=null){
            if(!mp.containsKey(col)){
                mp.put(col, new int[]{root.data, row});
            }
            else{
                int val = mp.get(col)[1];
                if(val<=row){
                    mp.get(col)[0] = root.data;
                    mp.get(col)[1] = row;
                }
            }
            if(col>max_col)
                max_col = col;
            if(col<min_col)
                min_col = col;
            preOrder(root.left, row+1, col-1, mp);
            preOrder(root.right, row+1,  col+1, mp);
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        HashMap<Integer, int[]> mp = new HashMap<>();
        preOrder(root, 0, 0, mp);
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=min_col; i<=max_col; i++){
            result.add(mp.get(i)[0]);
        }
        return result;
    }
}