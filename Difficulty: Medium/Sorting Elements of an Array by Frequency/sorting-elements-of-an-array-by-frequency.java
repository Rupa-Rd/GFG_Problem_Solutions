//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java
class Compare
  implements Comparator<Map.Entry<Integer, Integer> > {
  public int compare(Map.Entry<Integer, Integer> a,
                     Map.Entry<Integer, Integer> b)
  {
    // b is at top and a is at bottom - have that in
    // mind
    if (a.getValue() == b.getValue()) // when freq same
      return a.getKey().compareTo(
      b.getKey()); // smaller val stays at top
    return b.getValue().compareTo(
      a.getValue()); // higher freq stays at top
  }
}
class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr1[]) {
        // add your code here
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i: arr1){
            arr.add(i);
        }
        int N = arr.size();
    Map<Integer, Integer> mpp
      = new HashMap<>(); // val, freq
    for (int a : arr) {
      mpp.put(a, mpp.getOrDefault(a, 0) + 1);
    }
    // max heap - as max wise freq elements is what
    // needed
    PriorityQueue<Map.Entry<Integer, Integer> > maxH
      = new PriorityQueue<>(new Compare());

    for (Map.Entry<Integer, Integer> m :
         mpp.entrySet()) {
      maxH.add(m); // freq, val
    }
    // now the max freq is at TOP of MAX heap

    int i = 0; // to maintain index to copy
    while (maxH.size() > 0) {
      int val = maxH.peek().getKey(); // val
      int freq = maxH.peek().getValue(); // freq

      while (freq-- > 0) {
        // freq - those many times make a copy
        arr.set(i, val);
        i++;
      }
      maxH.poll(); // heapify happens and next top
      // freq ele goes up
    }
    
    return arr;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends