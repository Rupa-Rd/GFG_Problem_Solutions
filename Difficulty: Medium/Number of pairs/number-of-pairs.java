//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int X[], int Y[], int M, int N) {
        // code here
        // Possible pairs: 2-1, 2-5, 1-1, 1-5, 6-1, 6-5;
        int NoOfY[] = new int[5];
        for (int i = 0; i < N; i++)
            if (Y[i] < 5)
                NoOfY[Y[i]]++;

        // Sort Y[] so that we can do binary search in it
        Arrays.sort(Y);

        long total_pairs = 0; // Initialize result

        // Take every element of X and count pairs with it
        for (int i = 0; i < M; i++)
            total_pairs += count(X[i], Y, N, NoOfY);

        return total_pairs;
    }
    public int count(int x, int Y[], int n, int NoOfY[])
    {
        // If x is 0, then there cannot be any value in Y
        // such that x^Y[i] > Y[i]^x
        if (x == 0)
            return 0;

        // If x is 1, then the number of pairs is equal to
        // number of zeroes in Y[]
        if (x == 1)
            return NoOfY[0];

        // Find number of elements in Y[] with values
        // greater than x getting upperbound of x with
        // binary search
        int idx = Arrays.binarySearch(Y, x);
        int ans;
        if (idx < 0) {
            idx = Math.abs(idx + 1);
            ans = Y.length - idx;
        }
        else {
            while (idx < n && Y[idx] == x) {
                idx++;
            }
            ans = Y.length - idx;
        }

        // If we have reached here, then x must be greater
        // than 1, increase number of pairs for y=0 and y=1
        ans += (NoOfY[0] + NoOfY[1]);

        // Decrease number of pairs for x=2 and (y=4 or y=3)
        if (x == 2)
            ans -= (NoOfY[3] + NoOfY[4]);

        // Increase number of pairs for x=3 and y=2
        if (x == 3)
            ans += NoOfY[2];

        return ans;
    }
}