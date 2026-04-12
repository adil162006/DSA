import java.util.*;
public class Height {
    int height(Node root){
        if(root==null)return 0;

        int left = height(root.left);
        int right = height(root.right);

        return 1+Math.max(left,right);
    }
    boolean balancedTree(Node root){
        boolean ans = true;
        balancedHelper(root,ans);
        return ans;
    }
    int balancedHelper(Node root,boolean ans){
        if(root==null)return 0;
        int left = balancedHelper(root.left,ans);
        int right = balancedHelper(root.right,ans);

        if(Math.abs(left-right)>1)ans = false;

        return 1+ Math.max(left,right);

    }
    int minDepth(Node root){
        if(root==null) return 0;
        if(root.right==null && root.left ==null)return 1;
        if(root.left == null ) return  1 + minDepth(root.right);
        if(root.right == null ) return  1 + minDepth(root.left);

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return  1+Math.min(left,right);
    }
    public static void main(String[] args) {
        // Creating sample tree
        /*
                1
               / \
              2   3
             / \
            4   5
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Height obj = new Height();

        // Testing functions
        System.out.println("Height of tree: " + obj.height(root));
        System.out.println("Is Balanced: " + obj.balancedTree(root));
        System.out.println("Minimum Depth: " + obj.minDepth(root));
    }
}
