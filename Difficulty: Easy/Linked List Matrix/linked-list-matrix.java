//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node right, down;

    Node(int data) {
        this.data = data;
        right = null;
        down = null;
    }
}

public class Linked_list_2D_Matrix {

    // Non-static display method
    void display(Node head) {
        Node Dp = head;
        while (Dp != null) {
            Node Rp = Dp;
            while (Rp != null) {
                System.out.print(Rp.data + " ");
                if (Rp.right != null)
                    System.out.print(Rp.right.data + " ");
                else
                    System.out.print("null ");
                if (Rp.down != null)
                    System.out.print(Rp.down.data + " ");
                else
                    System.out.print("null ");
                Rp = Rp.right;
            }
            Dp = Dp.down;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Linked_list_2D_Matrix ll2d =
            new Linked_list_2D_Matrix(); // Create an instance of the class

        try {
            int t = Integer.parseInt(scanner.nextLine().trim());

            while (t-- > 0) {
                // Read and process the first line of input
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }

                String[] elements = line.split("\\s+");
                int n = elements.length;

                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(elements[i]);
                }

                int[][] mat = new int[n][n];
                mat[0] = arr;

                // Read the remaining rows of the matrix
                for (int i = 1; i < n; i++) {
                    line = scanner.nextLine().trim();
                    elements = line.split("\\s+");
                    for (int j = 0; j < n; j++) {
                        mat[i][j] = Integer.parseInt(elements[j]);
                    }
                }

                Solution obj = new Solution();
                Node head = obj.construct(mat);
                ll2d.display(head); // Call non-static method using instance
                System.out.println();
            }
        } catch (NumberFormatException e) {
            System.err.println(
                "Error reading input. Please ensure the input is in the correct format.");
        } finally {
            scanner.close();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*class Node

class Node
{
   int data;
   Node right,down;

   Node(int data){
       this.data = data;
       right = null;
       down = null;
   }
}
*/
/*Function should return the head of the 2D LL.*/
class Solution {
    static Node constructUtil(int[][] arr, int i, int j) {
      
        // Base case: if we are out of bounds, return null
        if (i >= arr.length || j >= arr[0].length) {
            return null;
        }

        // Create a new Node with the current
        // matrix value
        Node curr = new Node(arr[i][j]);

        // Recursively construct the right
        // and down pointers
        curr.right = constructUtil(arr, i, j + 1);
        curr.down = constructUtil(arr, i + 1, j);

        // Return the constructed Node
        return curr;
    }
    static Node construct(int arr[][]) {
        // Add your code here.
        return constructUtil(arr, 0, 0);
    }
}