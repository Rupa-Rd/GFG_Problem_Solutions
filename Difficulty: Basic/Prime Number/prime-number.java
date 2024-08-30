//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isPrime(N));
        }
    }
}
// } Driver Code Ends


class Solution{
    static int isPrime(int num){
        // code here
        
        // Brute force-> TC: O(n) SC: O(n)
//         if(num == 1){
//             return 0;
//         }
//         if(num == 2){
//             return 1;
//         }
// 		ArrayList<Integer> primes = new ArrayList<>();

// 		for(int i = 2; i <num; i ++){
// 			if(num % i == 0)
// 			primes.add(i);
// 		}

// 		return primes.size() == 0 ? 1 : 0;

        if(num == 1)
        return 0;
        if(num == 2)
        return 1;
        
        for(int i = 2; i <= Math.sqrt(num); i ++){
            if(num % i == 0)
            return 0;
            if(num % (num / i) == 0 )
            return 0;
        }
        
        return 1;
    }
}