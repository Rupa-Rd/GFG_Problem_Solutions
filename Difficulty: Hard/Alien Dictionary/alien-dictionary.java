//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            int k = Integer.parseInt(sc.nextLine());
            int n = words.length;
            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, k);
            if (order.length() == 0) {
                System.out.println("false");
                System.out.println("~");
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                System.out.println("~");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2) {
                        return Integer.compare(a.length(), b.length());
                    }

                    return Integer.compare(index1, index2);
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String findOrder(String[] dict, int k) {
        // Write your code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < k; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < dict.length - 1; i++){
            int size = Math.min(dict[i].length(), dict[i + 1].length());
            String s1 = dict[i];
            String s2 = dict[i + 1];
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";  // Invalid order
            }
            
            for(int j = 0; j < size; j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    graph.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        
    
        ArrayList<Integer> topo =  new ArrayList<>();
        topo = bfs(k, graph);
        
        if (topo.size() != k) {
            return "";  // Cycle detected or not all nodes are covered
        }
        
        StringBuilder alienDict = new StringBuilder();
        
        for(int ele: topo){
            
            char alphabet = (char) (ele +'a');
            alienDict.append(alphabet);
        }
        
        // System.out.println(alienDict.toString());
        return alienDict.toString();
    }
    public ArrayList<Integer> bfs(int k, ArrayList<ArrayList<Integer>> graph){
        int[] indegree = new int[k];
        
        for(int i = 0; i < k; i++){
            for(int ne: graph.get(i)){
                indegree[ne] ++;
            }
            
        }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < k; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int top = q.poll();
            ans.add(top);
            
            for(int neigh: graph.get(top)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.add(neigh);
                }
            }
        }
        
        return ans;
    }
}