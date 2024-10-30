//Maximum Depth or Height of Binary Tree
import java.util.Queue;
import java.util.LinkedList;
public class Height_BT {
    public static void findHeight(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int cnt=0;
        while (!q.isEmpty()) {
            int size = q.size();

            // Traverse all nodes at the current level
            for (int i = 0; i < size; i++) {
                Node temp = q.poll();

                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
            cnt++;
            
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        root.right.right.left=new Node(6);
        root.right.right.right = new Node(7);

        findHeight(root);
    }
}
