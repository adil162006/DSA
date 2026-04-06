public class TreeSymmetry {
    boolean isSame(Node root1,Node root2){
        if(root1==null  && root2 == null)return true;
        if(root1==null  || root2 == null)return false;

        if(root1.data == root2.data)return  true;

        boolean r1 = isSame(root1.left,root2.left);
        boolean r2 = isSame(root1.right,root2.right);

        return  r1 && r2;

    }
    boolean isSymmetry(Node root){
        return symmetryHelper(root.left,root.right);
    }

    boolean symmetryHelper(Node root1,Node root2){
        if(root1==null  && root2 == null)return true;
        if(root1==null  || root2 == null)return false;

        if(root1.data == root2.data)return  true;

        boolean r1 = isSame(root1.left,root2.right);
        boolean r2 = isSame(root1.right,root2.left);

        return  r1 && r2;
    }
    public Node invertTree(Node root) {
        if(root == null) return null;
        Node temp = root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;

    }
    public boolean flipEquiv(Node root1, Node root2) {
        if(root1==null && root2==null)return true;
        if(root1==null || root2==null)return false;

        if(root1.data!=root2.data)return false;


        boolean noFlip = flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right);
        boolean flip = flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left);

        return noFlip||flip;
    }
    public boolean isSubtree(Node root, Node subRoot) {
        if(root==null )return false;

        if( isSameTree(root,subRoot))return true;

        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
    boolean isSameTree(Node root1,Node root2){
        if(root1==null && root2==null)return true;
        if(root1==null || root2==null)return false;

        if(root1.data != root2.data) return false;

        boolean r1 = isSame(root1.left,root2.left);
        boolean r2 = isSame(root1.right,root2.right);


        return r1 && r2;

    }


    public static void main(String[] args) {
        // -------- Tree 1 --------
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(2);
        root1.left.left = new Node(3);
        root1.left.right = new Node(4);
        root1.right.left = new Node(4);
        root1.right.right = new Node(3);

        // -------- Tree 2 (same as Tree 1) --------
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(2);
        root2.left.left = new Node(3);
        root2.left.right = new Node(4);
        root2.right.left = new Node(4);
        root2.right.right = new Node(3);

        // -------- Tree 3 (different tree) --------
        Node root3 = new Node(1);
        root3.left = new Node(2);
        root3.right = new Node(2);
        root3.left.left = new Node(3);
        root3.right.right = new Node(5); // different value

        TreeSymmetry obj = new TreeSymmetry();

        // ✅ Test isSame
        System.out.println("Tree1 vs Tree2 (isSame): " + obj.isSame(root1, root2)); // true
        System.out.println("Tree1 vs Tree3 (isSame): " + obj.isSame(root1, root3)); // false

        // ✅ Test isSymmetry
        System.out.println("Tree1 is Symmetric: " + obj.isSymmetry(root1)); // true
        System.out.println("Tree3 is Symmetric: " + obj.isSymmetry(root3)); // false
    }
}
