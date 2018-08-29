package easy;

/**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 算法核心在于，需要一个节点node，记录下结果链表的头部。同时必须有一个cur游标，标志着这个结果链表的尾部node。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode firstNode = new ListNode(0);//用于记录结果集链表的头部
        ListNode cur = firstNode;//结果集链表在生成的过程，需要时刻记录他末尾的node节点，方便增加node
        while (l1 != null && l2 != null) {//1------循环遍历l1，l2链表，当两者都不为空
            if (l1.val <= l2.val) {//判断两个链表当前头部的值大小，越小的，就增加到结果集链表尾部
                cur.next = l1;//游标已指向结果集末尾node节点，所以它的next，就是这两个链表当前head的较小值节点
                l1 = l1.next;//链表的头部l需要下移，也就是指向下一个node
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;//当至少有一个链表遍历完成之后，cur游标的next指向另一个非空链表即可完成
        return firstNode.next;
    }

    public static void main(String[] args) {

    }
}
