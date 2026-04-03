

import java.util.ArrayList;
import java.util.List;
import java.util.*;

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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> temp = new ArrayList<>();

            while (levelSize > 0) {
                Node t = q.poll();
                temp.add(t.data);

                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);

                levelSize--;
            }

            res.add(temp);
        }

        return res;
    }
    public List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>>res=new ArrayList<>();
        Queue<Node>q=new LinkedList<>();
        if(root==null)return res;
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer>temp=new ArrayList<>();
            while(levelSize>0){
                Node t = q.poll();
                temp.add(t.data);
                if(t.left!=null)q.offer(t.left);
                if(t.right!=null)q.offer(t.right);
                levelSize--;
            }
            res.add(temp);
        }
        Collections.reverse(res);
        return res;
    }
    public List<List<Integer>> zizZagLevelOrderBottom(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node>q=new LinkedList<>();
        boolean LeftToRight=true;
        if(root==null)return res;
        q.offer(root);
        while (!q.isEmpty()){
            List<Integer>temp=new ArrayList<>();
            int size = q.size();
            while ((size>0)){
                Node t = q.poll();
                if(LeftToRight){
                    temp.add(t.data);

                }else{
                    temp.add(0,t.data);
                }
                if(t.left!=null)q.offer(t.left);
                if(t.right!=null)q.offer(t.right);
                size--;
            }
            res.add(temp);
            LeftToRight=!LeftToRight;
        }

        return res;
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

        Traversals obj = new Traversals();

        System.out.println("\n\nLevel Order:");
        List<List<Integer>> level = obj.levelOrder(root);
        for (List<Integer> l : level) {
            System.out.println(l);
        }

        System.out.println("\nLevel Order Bottom:");
        List<List<Integer>> bottom = obj.levelOrderBottom(root);
        for (List<Integer> l : bottom) {
            System.out.println(l);
        }

        System.out.println("\nZigZag Level Order:");
        List<List<Integer>> zigzag = obj.zizZagLevelOrderBottom(root);
        for (List<Integer> l : zigzag) {
            System.out.println(l);
        }
    }
        }


