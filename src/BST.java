import java.util.Arrays;
import java.util.Scanner;

public class BST {
    public class Node{
        int val;
        int height;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
        public int getVal(){
            return val;
        }
    }

    private Node root;
    public BST(){

    }

    public int getHeight(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public void insert(int val){
        root=insert(val,root);
    }

    public Node insert(int val,Node node){
        if(node==null){
            node=new Node(val);
            return node;
        }
        if(val<node.getVal()){
            node.left=insert(val,node.left);
        }
        if(val>node.getVal()){
            node.right=insert(val,node.right);
        }
        node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
        return node;
    }

    public boolean isBalanced(Node node){
        if(node==null){
            return true;
        }
        return Math.abs(getHeight(node.left)-getHeight(node.right))<=1 && isBalanced(node.right) && isBalanced(node.left);
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    public void displays(Node node,String details){
        if(node==null){
            return;
        }
        System.out.println(details+node.getVal());
        displays(node.left,"Left child of "+node.getVal()+" : ");
        displays(node.right,"Right child of "+node.getVal()+" : ");
    }

    public void displays(){
        displays(this.root,"Root node: ");
    }

    public void populate(int []a){
        for(int i:a){
            this.insert(i);
        }
    }

    public void populateSorted(int[] a,int st,int end){
        if(st>=end){
            return;
        }

        int mid=st+(end-st)/2;
        this.insert(a[mid]);
        populateSorted(a,st, mid);
        populateSorted(a,mid+1,end);
    }

    public void populateSorted(int []a){
        populateSorted(a,0,a.length);
    }

    public static void main() {
        BST tree=new BST();
        int []a={53,5,634,6,57,69,5,56,66,86,86,68,68,6,4,6,67,8};
        Arrays.sort(a);
        tree.populateSorted(a);
        tree.displays();
    }

}
