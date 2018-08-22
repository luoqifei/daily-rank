package dayscode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 删除单链表的重复元素
 * 比如，1，2，3，3，5，2，4
 * 删除后，就是1，2，3，5，4
 */
public class DeleteDuplicatesNode {
    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static Node addNodeAtLast(Node head, int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return head;
        }
        Node endNode = head;
        while (endNode.next != null) {
            endNode = endNode.next;
        }
        endNode.next = node;
        return head;
    }

    public static Node removeDuplicatesNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> elements = new HashSet<>();
        Node previous = null;//删除节点，需要记住上一个节点位置
        Node cur = head;
        while (cur != null) {
            if (!elements.contains(cur.data)) {//遍历节点，如果节点不在set中，加入缓存key，下移previous位置
                elements.add(cur.data);
                previous = cur;
            } else {
                previous.next = cur.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void display(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int T = sc.nextInt();
        while (T-- > 0) {
            int ele = sc.nextInt();
            head = addNodeAtLast(head, ele);
        }
        head = removeDuplicatesNode(head);
        display(head);
    }
}
