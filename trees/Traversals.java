
public class Traversals {
    static void inorder(Node root){
        if(root == null)return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void postorder(Node root){
        if(root == null)return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    static void preorder(Node root){
        if(root == null)return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */

                Node root = new Node(1);
                root.left = new Node(2);
                root.right = new Node(3);
                root.left.left = new Node(4);
                root.left.right = new Node(5);
                root.right.right = new Node(6);

                System.out.print("Inorder: ");
                inorder(root);

                System.out.print("\nPreorder: ");
                preorder(root);

                System.out.print("\nPostorder: ");
                postorder(root);
            }
        }


