//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            
            int l=sc.nextInt();
			int r=sc.nextInt();
			Solution ob = new Solution();
			ArrayList<Integer> numbers = ob.uniqueNumbers(l,r);
			for(int num : numbers){
			    System.out.print(num+" ");
			}
			System.out.println();

        }
    }
}

// } Driver Code Ends


class Solution{

    static ArrayList<Integer> uniqueNumbers(int L,int R){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = L; i <= R; i++){
            if(checkUnique(i)){
                ans.add(i);
            }
        }
        
        return ans;
    }
    static boolean checkUnique(int n){
        boolean[] digits = new boolean[10];
        
        while(n != 0){
            
            int r = n % 10;
            if(digits[r] == true){
                return false;
            }else{
                digits[r] = true;
            }
            
            
            n /= 10;
        }
        
        return true;
    }
}