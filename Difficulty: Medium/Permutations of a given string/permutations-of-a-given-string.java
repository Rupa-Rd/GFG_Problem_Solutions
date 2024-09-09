//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        Set<String> ans = new TreeSet<>();
        recursion(0, S, ans);
        return new ArrayList<>(ans);
    }
    public void recursion(int idx,String S, Set<String> ans){
        if(idx == S.length()){
            // StringBuilder temp = new StringBuilder();
            // for(int i = 0; i < S.length(); i++){
            //     temp.append(S.charAt(i));
            // }
            ans.add(S);
        }
        
        for(int i = idx; i < S.length(); i++){
            S = swap(i, idx, S);
            recursion(idx + 1, S, ans);
            S = swap(i, idx, S);
        }
    }
    public String swap(int i, int indx, String S){
        StringBuilder str = new StringBuilder(S);
        str.setCharAt(i, S.charAt(indx));
        str.setCharAt(indx, S.charAt(i));
        
        return str.toString();
    }
}