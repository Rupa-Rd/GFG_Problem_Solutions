//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        // Bruteforce: O(n^2)
        
        // int max = 0;
        
        // for(int i = 0; i < n; i++){
        //     int sum =0;
        //     for(int j = i; j < n; j ++){
        //         sum += arr[j];
        //         if(sum == 0){
        //             max = Math.max(max, j - i + 1);
        //         }
        //     }
        // }
        
        // return max;
        
        // Optimal: O(n)
        
        HashMap<Integer, Integer> mpp = new HashMap<>();
        
        int maxi = 0;
        int sum = 0; 

        for(int i = 0;i<n;i++) {

            sum += arr[i]; 

            if(sum == 0) {
                maxi = i + 1; 
            }
            else {
                if(mpp.get(sum) != null) {

                    maxi = Math.max(maxi, i - mpp.get(sum)); 
                }
                else {

                    mpp.put(sum, i); 
                }
            }
        }
        return maxi; 
    }
}