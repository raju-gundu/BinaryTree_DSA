import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    

    public static void printTree(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data+" ");

            if (curr.left!=null) {
                q.add(curr.left);
            }

            if (curr.right!=null) {
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
        printTree(root);
    }
}
