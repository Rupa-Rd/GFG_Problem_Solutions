//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1 || result.size() != 2) {
                System.out.println("false");
            } else {
                int sum1 = 0, sum2 = 0, sum3 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i <= result.get(0))
                        sum1 += arr[i];

                    else if (i <= result.get(1))
                        sum2 += arr[i];

                    else
                        sum3 += arr[i];
                }
                if (sum1 == sum2 && sum2 == sum3) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    public List<Integer> findSplit(int[] arr) {
        // Return an array of possible answer, driver code will judge and return true or
        // false based on
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int total = 0;

        // Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            total += arr[i];
        }

        // If the total sum is not divisible by 3, it's impossible to split the array
        if (total % 3 != 0) {
            res.add(-1);
            res.add(-1);
            return res;
        }

        int currSum = 0;
        int targetSum = total / 3;

        // Iterate through the array to find partition indices
        for (int i = 0; i < n; i++) {
            currSum += arr[i];

            // If a valid segment is found, store its index and reset currSum to 0
            if (currSum == targetSum) {
                res.add(i);
                currSum = 0;

                // If two valid segments are found and a third non-empty segment is possible
                if (res.size() == 2 && i < n - 1) {
                    return res;
                }
            }
        }

        // If valid indices are not found, return [-1, -1]
        res.clear();
        res.add(-1);
        res.add(-1);
        return res;
    }
}