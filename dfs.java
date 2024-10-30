public class dfs {
    public static void inOrderDFS(Node root){
        if (root==null) {
            return;
        }
        inOrderDFS(root.left);
        System.out.print(root.data+" ");
        inOrderDFS(root.right);
    }

    public static void preOrderDFS(Node root){
        if (root==null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrderDFS(root.left);
        preOrderDFS(root.right);
    }

    public static void postOrderDFS(Node root){
        if (root==null) {
            return;
        }
        postOrderDFS(root.left);
        postOrderDFS(root.right);
        System.out.print(root.data+" ");
    }
    public static void main(String[] args) {
        // Creating the tree
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);

       
        System.out.print("In-order DFS: ");
        inOrderDFS(root);
        System.out.print("\nPre-order DFS: ");
        preOrderDFS(root);
        System.out.print("\nPost-order DFS: ");
        postOrderDFS(root);
        
    }
}
