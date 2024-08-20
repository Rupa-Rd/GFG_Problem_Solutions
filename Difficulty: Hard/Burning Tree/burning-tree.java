//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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
			if (i >= ip.length)
				break;

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
		if (root == null)
			return;

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

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
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
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        HashMap<Integer, List<Integer> > ans
            = new HashMap<>();
        findMinTime(root, target, 0, ans, 0);
        return ans.size()-1;
    }
        static int
    findMinTime(Node root, int target, int level,
                HashMap<Integer, List<Integer> > ans,
                int consider)
    {
        // if the root is null, return -1
        if (root == null)
            return -1;
 
        // if consider is 1, push the root node data to ans
        // at the current level
        if (consider == 1) {
            ans.computeIfAbsent(level,
                                k -> new ArrayList<>())
                .add(root.data);
        }
 
        // if the root node is the target node, add it to
        // ans at level 0 and recursively call findMinTime
        // on its left and right subtrees
        if (root.data == target) {
            ans.computeIfAbsent(0, k -> new ArrayList<>())
                .add(root.data);
            findMinTime(root.left, target, 1, ans, 1);
            findMinTime(root.right, target, 1, ans, 1);
            return 1;
        }
 
        // recursively call findMinTime on the left and
        // right subtrees and store their return values
        int left = findMinTime(root.left, target, level + 1,
                               ans, consider);
        int right = findMinTime(root.right, target,
                                level + 1, ans, consider);
 
        // if left subtree has the target node, push the
        // root node data to ans at the level of the left
        // subtree + 1 and recursively call findMinTime on
        // the right subtree
        if (left != -1) {
            ans.computeIfAbsent(left,
                                k -> new ArrayList<>())
                .add(root.data);
            findMinTime(root.right, target, left + 1, ans,
                        1);
            return left + 1;
        }
 
        // if right subtree has the target node, push the
        // root node data to ans at the level of the right
        // subtree + 1 and recursively call findMinTime on
        // the left subtree
        if (right != -1) {
            ans.computeIfAbsent(right,
                                k -> new ArrayList<>())
                .add(root.data);
            findMinTime(root.left, target, right + 1, ans,
                        1);
            return right + 1;
        }
 
        // if the target node is not found in the left or
        // right subtrees, return -1
        return -1;
    }
}