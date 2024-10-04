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

class LinkedList {
    // Function to print nodes in a given circular linked list
    static void printList(Node head) {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int key = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            tail.next = head; // Make the list circular
            Solution ob = new Solution();
            Node current = ob.deleteNode(head, key);
            Node rev = ob.reverse(current);
            printList(rev);
        }
    }
}

// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/

class Solution {
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        // If the list is empty or contains only one node
        if (head == null || head.next == head) {
            return head;
        }
        
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        // Traverse the circular linked list
        do {
            next = curr.next;  // Store next node
            curr.next = prev;  // Reverse the link
            prev = curr;       // Move prev to current
            curr = next;       // Move current to next
        } while (curr != head);  // Stop when we come back to head
        
        // Now 'prev' is the new head, so we need to fix the last node
        head.next = prev; // The old head (now tail) should point to the new head
        return prev;      // Return the new head of the reversed list
    }

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        // If the list is empty
        if (head == null) {
            return null;
        }
        
        Node curr = head;
        Node prev = null;

        // Special case: If head itself needs to be deleted and it's the only node
        if (head.data == key && head.next == head) {
            return null;  // The list becomes empty
        }

        // If the head itself holds the key to be deleted
        if (head.data == key) {
            // Find the last node to update its next pointer
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            // Point the last node's next to the next of head and update head
            last.next = head.next;
            head = head.next; // Update head
            return head;
        }

        // Traverse the list and find the node to delete
        do {
            prev = curr;
            curr = curr.next;
            if (curr.data == key) {
                prev.next = curr.next;  // Bypass the current node
                return head;
            }
        } while (curr != head);

        // If the key is not present, simply return the original list
        return head;
    }
}

