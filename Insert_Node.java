import java.util.LinkedList;
import java.util.Queue;

/*
 * Inserting elements means add a new node into the binary tree. 
 * As we know that there is no such ordering of elements in the binary tree, 
 * So we do not have to worry about the ordering of node in the binary tree. 
 * We would first creates a root node in case of empty tree. 
 * Then subsequent insertions involve iteratively searching for an empty place at each level of the tree. 
 * When an empty left or right child is found then new node is inserted there.
 * By convention, insertion always starts with the left child node.
 */
public class Insert_Node {
    public static void addNode(Node root, int key) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.left == null) {
                curr.left = new Node(key);
                break;
            } else {
                queue.add(curr.left);
            }

            if (curr.right == null) {
                curr.right = new Node(key);
                break;
            } else {
                queue.add(curr.right);
            }
        }
    }

    public static void printTree(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }

        }
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        addNode(root, 6);
        addNode(root, 7);
        printTree(root);
    }
}
