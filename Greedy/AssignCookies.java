public boolean select(int[] g, int[] s, int i, int j)
{
    if(s[j]>=g[i])
        return true;
    return false;
}
public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0;
    int j = 0;
    int n = g.length;
    int m = s.length;
    while(i<n && j<m){
        if(select(g, s, i, j)){
            i++;
            j++;
        }
        else{
            j++;
        }
    }
    return i;
}