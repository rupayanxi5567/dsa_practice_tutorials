import java.util.Scanner;

public class BinaryTrees {

    public BinaryTrees() {

    }

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    public void populatesTheChilds(Scanner sc, Node node) {
        System.out.println("Do you wanna enter left value for " + node.val);
        boolean left = sc.nextBoolean();
        if (left) {
            System.out.println("Enter the value for left child of " + node.val);
            int val = sc.nextInt();
            node.left = new Node(val);
            populatesTheChilds(sc, node.left);
        }

        System.out.println("Do you wanna enter right value for " + node.val);
        boolean right = sc.nextBoolean();
        if (right) {
            System.out.println("Enter the value for right child of " + node.val);
            int val = sc.nextInt();
            node.right = new Node(val);
            populatesTheChilds(sc, node.right);
        }
    }

    public void populatesTheRoot(Scanner sc) {
        System.out.println("Enter the root node value: ");
        int val = sc.nextInt();
        root = new Node(val);
        populatesTheChilds(sc, root);
    }

    public void display() {
        display(root, " ");
    }

    public void display(Node node, String indentation) {
        if (node == null) return;
        System.out.println(indentation + node.val);
        display(node.left, indentation + "\t");
        display(node.right, indentation + "\t");
    }

    public void pretty(Node node, int lvl) {
        if (node == null) {
            return;
        }
        pretty(node.right, lvl + 1);
        if (lvl != 0) {
            for (int i = 0; i < lvl - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>" + node.val);
        } else {
            System.out.println(node.val);
        }
        pretty(node.left, lvl + 1);
    }

    public void pretty() {
        pretty(root, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTrees trees = new BinaryTrees();
        trees.populatesTheRoot(sc);
        trees.pretty();
    }
}