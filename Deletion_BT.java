//Deletion in Binary Tree
import java.util.Queue;
import java.util.LinkedList;
/*
 * Deleting a node from a binary tree means removing a specific node while keeping the tree’s structure. 
 * First, we need to find the node that want to delete by traversing through the tree using any traversal method. 
 * Then replace the node’s value with the value of the last node in the tree (found by traversing to the rightmost leaf), 
 * and then delete that last node. 
 * This way, the tree structure won’t be effected. 
 * And remember to check for special cases, like trying to delete from an empty tree, to avoid any issues.
 * Note: There is no specific rule of deletion but we always make sure that during deletion the binary tree proper should be preserved.
 */
public class Deletion_BT {

    //deletion function
    public static Node deleteNode(Node root,int valToDel){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node target = null;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if(curr.data==valToDel){
                target = curr;
                break;
            }
            if (curr.left!=null) {
                q.add(curr.left);
            }
            if (curr.right!=null) {
                q.add(curr.right);
            }
        }
        if (target==null) {
            return root;
        }

        Node lastNode = null;
        Node lastParent = null;
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> parentQueue = new LinkedList<>();
        q1.add(root);
        parentQueue.add(null);

        while (!q1.isEmpty()) {
            Node curr = q1.poll();
            Node parent = parentQueue.poll();

            lastNode = curr;
            lastParent = parent;

            if (curr.left!=null) {
                q1.add(curr.left);
                parentQueue.add(curr);
            }

            if (curr.right!=null) {
                q1.add(curr.right);
                parentQueue.add(curr);
            }
        }

        target.data=lastNode.data;

        if (lastParent!=null) {
            if (lastParent.left==lastNode) {
                lastParent.left=null;
            }
            else{
                lastParent.right=null;
            }
        }
        else{
            return null;
        }
        return root;
    }

    //inorder traversal
    public static void inorder(Node root){
        if (root==null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);

        System.out.print("Original tree (in-order): ");
        inorder(root);
        System.out.println();

        int valToDel = 3;
        root = deleteNode(root, valToDel);

        System.out.print("Tree after deleting " + valToDel + " (in-order): ");
        inorder(root);
        System.out.println();
    }    
}