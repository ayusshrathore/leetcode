class Solution {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        StringBuilder sb = new StringBuilder();

        Stack<String> st = new Stack<>();
        
        for(String c : tokens) {
            if(c.equals(".") || c.equals(""))
                continue;
            
            if(!c.equals(".."))
                st.push(c);
            else if (!st.isEmpty()) 
                st.pop();                
        }
        
        if(st.isEmpty())
            return "/";
        
        for(String s : st)
            sb.append("/" + s);
        
        return sb.toString();
    }
}