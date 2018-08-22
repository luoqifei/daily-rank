package dayscode;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 二叉树层次遍历打印输出
 */
public class BSTTraversal {
    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        Node cur;
        if (data <= root.data) {
            cur = insert(root.left, data);
            root.left = cur;
        }
        else{
            cur = insert(root.right, data);
            root.right = cur;
        }
        return root;
    }

    static void levelOrder(Node root) {
        Queue<Node> elements = new LinkedList();//利用队列先进先出
        elements.offer(root);
        while (!elements.isEmpty()) {//队列循环输出
            Node tmp = elements.poll();
            System.out.print(tmp.data + " ");
            if (tmp.left != null) {
                elements.offer(tmp.left);
            }
            if (tmp.right != null) {
                elements.offer(tmp.right);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }
}
