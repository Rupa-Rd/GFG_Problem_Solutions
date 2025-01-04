//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            int target = Integer.parseInt(br.readLine());
            Node root = buildTree(s);

            Solution g = new Solution();
            System.out.println(g.minTime(root, target));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /*class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }*/

    public static int minTime(Node root, int target) {
        HashMap<Node, Node> parentMap = new HashMap<>();
        mapParents(root, parentMap);
        
        Node targetNode = moveToTarget(root, target);
        
        Queue<Node> bfs = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        int minTime = 0;
        bfs.add(targetNode);
        
        while(!bfs.isEmpty()){
            int size = bfs.size();
            
            for(int i = 0; i < size; i++){
                Node top = bfs.poll();
                visited.add(top);
                // 3 directions
                if(top.left != null && !visited.contains(top.left)){
                    bfs.add(top.left);
                }
                if(top.right != null && !visited.contains(top.right)){
                    bfs.add(top.right);
                }
                if(parentMap.get(top) != null && !visited.contains(parentMap.get(top))){
                    bfs.add(parentMap.get(top));
                }

            }
            minTime ++;
        }
        // System.out.println(targetNode);
        return minTime - 1;
        
    }
    public static Node moveToTarget(Node root, int target) {
        if (root == null) return null;
        
        if (root.data == target) {
            return root;
        }
        
        Node leftResult = moveToTarget(root.left, target);
        if (leftResult != null) return leftResult;
    
        return moveToTarget(root.right, target);
    }
    public static void mapParents(Node root, HashMap<Node, Node> parentMap){
        parentMap.put(root, null);
        
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        
        while(!nodes.isEmpty()){
            int size = nodes.size();
            
            for(int i = 0; i < size; i++){
                Node top = nodes.poll();
                
                if(top.left != null){
                    nodes.add(top.left);
                    parentMap.put(top.left, top);
                }
                if(top.right != null){
                    nodes.add(top.right);
                    parentMap.put(top.right, top);
                }
            }
        }
    }
}