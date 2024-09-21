//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            String s1 = str.split(" ")[0];
            String s2 = str.split(" ")[1];

            Solution obj = new Solution();

            if (obj.isAnagram(s1, s2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a, String b) {

        // Your code here
        // Bruteforce: O(N + M)
        // int[] aChars = new int[26];
        // int[] bChars = new int[26];
        
        // for(char i: a.toCharArray()){
        //     aChars[i - 'a'] +=1;
        // }
        
        // for(char i: b.toCharArray()){
        //     bChars[i - 'a'] +=1;
        // }
        
        // for(int j = 0; j < 26; j++){
        //     if(aChars[j] != bChars[j]){
        //         return false;
        //     }
        // }
        
        // return true;
        
        // Optimal solution: O(N + M)
        
        HashMap<Character, Integer> map = new HashMap<>();
        if(a.length() != b.length()){
            return false;
        }
        for(char i: a.toCharArray()){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(char i: b.toCharArray()){
            if(!map.containsKey(i)){
                return false;
            }
            map.put(i, map.get(i) - 1);
            
            if(map.get(i) == 0){
                map.remove(i);
            }
            
        }

        return map.isEmpty();
    }
}