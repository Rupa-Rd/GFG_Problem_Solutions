//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
       if (s.length() < p.length()) {
            return "-1"; // If p is longer than s, no window can exist
        }
        
        // Frequency map for characters in p
        HashMap<Character, Integer> pFreq = new HashMap<>();
        for (char ch : p.toCharArray()) {
            pFreq.put(ch, pFreq.getOrDefault(ch, 0) + 1);
        }
        
        // Frequency map for the current window in s
        HashMap<Character, Integer> windowFreq = new HashMap<>();
        
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = -1; // To store the starting index of the smallest window
        int matched = 0; // To keep track of how many characters we have matched
        
        for (right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowFreq.put(rightChar, windowFreq.getOrDefault(rightChar, 0) + 1);
            
            // If the current character in the window matches its count in pFreq
            if (pFreq.containsKey(rightChar) && windowFreq.get(rightChar).intValue() == pFreq.get(rightChar).intValue()) {
                matched++;
            }
            
            // Once we have matched all the characters, try to minimize the window
            while (matched == pFreq.size()) {
                // Update the smallest window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                
                // Try to shrink the window from the left
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                
                // If we remove a character that breaks the match, decrease the matched count
                if (pFreq.containsKey(leftChar) && windowFreq.get(leftChar).intValue() < pFreq.get(leftChar).intValue()) {
                    matched--;
                }
                
                left++; // Move the left pointer to shrink the window
            }
        }
        
        // If no valid window is found, return "-1"
        return start == -1 ? "-1" : s.substring(start, start + minLen);
    }
}