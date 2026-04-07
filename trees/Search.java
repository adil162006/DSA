public class Search {
    Node lcaAns = null;

    Node lca(Node root, Node p, Node q){
        lcaAns = null;
        lcaHelper(root, p, q);
        return lcaAns;
    }

    int lcaHelper(Node root, Node p, Node q){
        if(root == null) return 0;

        int left = lcaHelper(root.left, p, q);
        int right = lcaHelper(root.right, p, q);

        int self = (root == p || root == q) ? 1 : 0;

        int total = left + right + self;

        if(total == 2 && lcaAns == null){
            lcaAns = root;
        }
        return total;
    }

    // Normal Binary Tree Search
    Node search(Node root, int tar){
        if(root == null) return null;

        if(root.data == tar) return root;

        Node left = search(root.left, tar);
        if(left != null) return left;

        return search(root.right, tar);
    }

    // BST Search
    Node bstSearch(Node root, int tar){
        if(root == null) return null;

        if(root.data == tar) return root;

        if(root.data < tar) return bstSearch(root.right, tar);
        else return bstSearch(root.left, tar);
    }
}