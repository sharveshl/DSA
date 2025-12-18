class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if (s.length() <= 1)
            return false;
        for (char i : s.toCharArray()) {
            if (i == '(' || i == '{' || i == '[')
                st.push(i);
            else {
                if (!st.isEmpty()) {
                    char t = st.peek();
                    if (i == '}' && t == '{')
                        st.pop();
                    else if (i == ']' && t == '[')
                        st.pop();
                    else if (i == ')' && t == '(')
                        st.pop();
                    else
                        return false;
                } else
                    return false;
            }

        }
        return st.isEmpty();
    }
}