package medium;

/**
 * @see <a href="https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/">交换链表相邻两个元素</a>
 */
public class SwapPairs {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {//特殊情况处理，节点数量小于2
            return head;
        }
        ListNode root = new ListNode(0);//必须定义一个根节点，从而记住最后链表的头部
        root.next = head;//自定义节点next与链表链接上
        ListNode pre = root;//需要一个节点记住，发生交换前，上一次交换的末尾节点索引点

        while (pre.next != null && pre.next.next != null) {//下一次交换的下一个节点，下下个节点都不为空才能交换
            ListNode start = pre.next;//定义下一次交换的第一个节点
            ListNode then = pre.next.next;//定义下一次交换的第二个节点
            //第一个和第二个节点位置交换
            //这里有个必须注意的是，链表位置交换，比如1->2->3->4->5，这个链表，2和3要交换。执行交换操作就是
            //1先指向3，然后2执行4，最后3指向2,这样就链接起来了。
            pre.next = then;
            start.next = then.next;
            then.next = start;

            pre = start;//最后更新下一次交换前的上个节点node
        }
        return root.next;
    }
}
