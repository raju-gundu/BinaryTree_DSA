//Searching in Binary Tree
import java.util.LinkedList;
import java.util.Queue;
/*
 * Searching for a value in a binary tree means looking through the tree to find a node that has that value.
 * Since binary trees do not have a specific order like binary search trees, we typically use any traversal method to search.
 * The most common methods are depth-first search (DFS) and breadth-first search (BFS).
 * In DFS, we start from the root and explore the depth nodes first.
 * In BFS, we explore all the nodes at the present depth level before moving on to the nodes at the next level.
 * We continue this process until we either find the node with the desired value or reach the end of the tree.
 * If the tree is empty or the value isn’t found after exploring all possibilities, 
 * we conclude that the value does not exist in the tree.
 */

public class search {
    // Here is the implementation of searching in a binary tree using Depth-First
    // Search (DFS)
    public static boolean searchDFS(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        boolean left_res = searchDFS(root.left, key);
        boolean right_res = searchDFS(root.right, key);
        return left_res || right_res;
    }

    // Here is the implementation of searching in a binary tree using Breadth-First
    // Search (BFS)
    public static boolean searchBFS(Node root, int key){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data==key) {
                return true;
            }

            if (curr.left!=null) {
                q.add(curr.left);
            }
            if (curr.right!=null) {
                q.add(curr.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);

        int value = 10;
        System.out.println("Search using DFS");
        if (searchDFS(root, value))
        {
            System.out.println(value + " is found in the binary tree");
        }
        else{
            System.out.println(value + " is not found in the binary tree");
        }

        System.out.println("Search using BFS");
        if (searchBFS(root, value))
        {
            System.out.println(value + " is found in the binary tree");
        }
        else{
            System.out.println(value + " is not found in the binary tree");
        }       
        
    }
}
