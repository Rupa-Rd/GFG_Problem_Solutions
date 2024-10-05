//{ Driver Code Starts
// Initial Template for Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputArr = input.split(" ");
            int[] arr = new int[inputArr.length];
            for (int i = 0; i < inputArr.length; i++) {
                arr[i] = Integer.parseInt(inputArr[i]);
            }

            Solution ob = new Solution();
            long ans = ob.findSmallest(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public long findSmallest(int[] arr) {
        // Your code goes here
        int res = 1;  // Initialize result to the smallest positive integer

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // If current element is greater than 'res', we can't form 'res'
            if (arr[i] > res) {
                break;
            }
            // Otherwise, we can include arr[i] in our sum and extend the range
            res += arr[i];
        }

        return res;
    }
}