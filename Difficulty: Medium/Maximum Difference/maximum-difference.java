//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    static void reverse(int a[])
    {
        int i, k, n = a.length;
        int t;
        for (i = 0; i < n / 2; i++)
        {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }
    static void leftSmaller(int arr[], int n, int SE[]) 
    {
        // Create an empty stack
        Stack<Integer> S = new Stack<>();
 
        // Traverse all array elements
        // compute nearest smaller elements of every element
        for (int i = 0; i < n; i++)
        {
            // Keep removing top element from S while the top
            // element is greater than or equal to arr[i]
            while (!S.empty() && S.peek() >= arr[i])
            {
                S.pop();
            }
 
            // Store the smaller element of current element
            if (!S.empty())
            {
                SE[i] = S.peek();
            } 
            // If all elements in S were greater than arr[i]
            else
            {
                SE[i] = 0;
            }
 
            // Push this element
            S.push(arr[i]);
        }
    }
    public int findMaxDiff(int[] arr) {
        // code here
        int n = arr.length;
        int[] LS = new int[n]; // To store left smaller elements
 
        // find left smaller element of every element
        leftSmaller(arr, n, LS);
 
        // find right smaller element of every element
        // first reverse the array and do the same process
        int[] RRS = new int[n]; // To store right smaller elements in
         
        // reverse array
        reverse(arr);
        leftSmaller(arr, n, RRS);
 
        // find maximum absolute difference b/w LS & RRS
        // In the reversed array right smaller for arr[i] is
        // stored at RRS[n-i-1]
        int result = -1;
        for (int i = 0; i < n; i++) 
        {
            result = Math.max(result, Math.abs(LS[i] - RRS[n - 1 - i]));
        }
 
        // return maximum difference b/w LS & RRS
        return result;
    }
}
