//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {


    String roundToNearest(String str) {
        // Get the length of the string (since the number is big)
        int n = str.length();

        // Extract the last digit from the string
        int lastDigit = str.charAt(n - 1) - '0';

        // If the last digit is less than 5, round down (just remove the last digit)
        if (lastDigit <= 5) {
            return str.substring(0, n - 1) + "0"; // replace the last digit with '0'
        }

        // If the last digit is 5 or more, we need to round up
        StringBuilder sb = new StringBuilder(str.substring(0, n - 1)); // exclude last digit

        // Now, add one to the remaining part and manage the carry
        int carry = 1;
        for (int i = sb.length() - 1; i >= 0; i--) {
            int currentDigit = sb.charAt(i) - '0' + carry;

            if (currentDigit == 10) {
                sb.setCharAt(i, '0'); // set to 0 and continue carrying
                carry = 1;
            } else {
                sb.setCharAt(i, (char)(currentDigit + '0')); // set the current digit without carry
                carry = 0;
                break;
            }
        }

        // If there's still a carry left, it means we need to add a '1' at the start
        if (carry == 1) {
            sb.insert(0, '1');
        }

        // Append a '0' at the end to round to the nearest multiple of 10
        sb.append('0');
        
        return sb.toString();
    }

}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends