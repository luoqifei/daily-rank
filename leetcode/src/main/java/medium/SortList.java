package medium;

/**
 * 链表排序
 *
 * @see <a href="https://leetcode-cn.com/problems/sort-list/description/">leetcode 链表排序</a>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * 基于这样的时间复杂度，合适的右快速排序和归并排序
 */
public class SortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int a) {
            val = a;
        }
    }
    //首先
    public ListNode sortList(ListNode head) {
        quickSort(head, null);//执行快速排序，交换节点内部的数值
        return head;//因为只是交换数值，返回头结点
    }

    //递归
    public void quickSort(ListNode head, ListNode end) {
        if (head != end) {//快速排序，双指针不能相等
            ListNode nextBaseNode = sortByBasenode(head);//取得下一个基准node
            quickSort(head, nextBaseNode);//左边的递归
            quickSort(nextBaseNode.next, end); //右边递归
        }
    }
    //基于某个
    public ListNode sortByBasenode(ListNode base) {
        ListNode slow = base;//慢指针
        ListNode fast = base.next;//快指针

        while (fast != null) {
            //这个循环处理，基准节点base没有任何变化，知识先将比基准小的都放到slow指针的左侧，比如：
            if (fast.val < base.val) {//发现有节点的值小于基准值
                slow = slow.next;//左指针右移
                //交换左右指针节点的值
                int tmp = slow.val;
                slow.val = fast.val;
                fast.val = tmp;
            }
            //不管right值怎样，都需要向后移动
            fast = fast.next;
        }
        //最后将base的值放入slow节点，并交换值
        int tmp = base.val;
        base.val = slow.val;
        slow.val = tmp;
        return slow;
    }
}
