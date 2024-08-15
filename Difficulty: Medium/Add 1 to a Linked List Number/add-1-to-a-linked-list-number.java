//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
        head = reverse(head);
        
        head = add(head);
        
        return reverse(head);
        
    }
    public Node add(Node head){
        Node res = head;
        Node temp = null, prev = null;
 
        int carry = 1, sum;
        // head = reverse(head);
        while (head != null) 
        {
            
            sum = carry + head.data;
 
            carry = (sum >= 10) ? 1 : 0;
 
            sum = sum % 10;
 
            head.data = sum;
 
            temp = head;
            head = head.next;
        }
 
        if (carry > 0)
        temp.next = new Node(carry);
 
        // res = reverse(res);
        return res;
    }
    public Node reverse(Node temp){
        
        Node prev = null;
        Node current = temp;
        Node next = null;
        
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
