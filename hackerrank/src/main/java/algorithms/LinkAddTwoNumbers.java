package algorithms;

/**
 * LeetCode 两数相加
 *
 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 示例：
 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
public class LinkAddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 以下三个变量是解法核心变量
         */
        ListNode res = null;//结果链表
        ListNode cur = null;//结果链表的游标，链接构建过程都需要有游标，否则链表构建会有问题
        int upBit = 0;//进位值


        while (l1 != null) {//任意，先遍历l1链表
            int l1Var = l1.val;//取得链表1的值
            int l2Var = 0;//定义链表2的变量，因为这个链表的长度可能小于1链表
            if (l2 != null) {//如果链表2还有值
                l2Var = l2.val;//取值
                l2 = l2.next;//下移链表游标，在这个算法里，l1,l2都是链表的游标，用于取值；而cur变量就是用来做结果集的游标并且辅助构建链表
            }
            int r = l1Var + l2Var + upBit;//将进位的值，两个链表当前位次的值相加求和
            upBit = r / 10;//除以10，求得进位数
            int thisR = r % 10;//求余10求得当前位次的值
            l1 = l1.next;//下于游标
            ListNode thisRNode = new ListNode(thisR);//构建被位次node节点
            if (res == null) {
                res = thisRNode;
                cur = res;//时刻记得移动结果游标
            } else {
                cur.next = thisRNode;
                cur = thisRNode;//时刻记得移动结果游标
            }
        }
        while (l2 != null) {//l1的长度小于l2的长度
            int l2Var = l2.val;
            int r = l2Var + upBit;
            upBit = r / 10;
            int thisR = r % 10;
            l2 = l2.next;
            ListNode thisRNode = new ListNode(thisR);
            if (res == null) {
                res = thisRNode;
                cur = res;
            } else {//时刻记得移动结果游标
                cur.next = thisRNode;
                cur = thisRNode;
            }
        }
        if (upBit != 0) {//l1,l2长度长度，但有进位，比如[5],[5] 的情况
            ListNode thisRNode = new ListNode(upBit);
            cur.next = thisRNode;
        }
        return res;
    }

    public static void main(String[] args) {
        //1
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);

        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(4);
        a.next = b;
        b.next = c;
        d.next = e;
        e.next = f;
        //2
        ListNode aa = new ListNode(5);
        ListNode bb = new ListNode(5);
        //3
        ListNode aaa = new ListNode(1);
        ListNode g = new ListNode(9);
        ListNode h = new ListNode(9);
        g.next = h;


        //ListNode r = addTwoNumbers(a,d);//1,[2,4,3]和[5,6,4] ,结果，[7,0,8]
        //ListNode r = addTwoNumbers(aa,bb);2, [5]和[5],结果是[0,1]
        ListNode r = addTwoNumbers(aaa, g);//3,[1] 和[9,9],结果是[001]
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
