/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int length(ListNode cur) {
        int len = 0;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public ListNode findNext(ListNode head) {
        while(head.next != null) {
            head = head.next;
        }
        return head;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(length(head) < k)
            return head;
        ArrayList<ListNode> arrayList = new ArrayList<>();
        int len = length(head);
        ListNode temp = head;
        while (len >= k) {
            ListNode cur = temp;
            int i = 1;
            while(i < k) {
                cur = cur.next;
                i++;
            }
            ListNode tempVal = cur.next;
            cur.next = null;
            arrayList.add(temp);
            temp = tempVal;
            len -= i;
        }
        if(temp != null)
            arrayList.add(temp);

        ListNode ans = null;
        ListNode cur = null;
        for(ListNode node : arrayList) {
            if(length(node) == k) {
                if(cur == null) {
                    cur = reverse(node);
                    ans = cur;
                } else {
                    cur = findNext(cur);
                    cur.next = reverse(node);
                }
            } else {
                cur = findNext(cur);
                cur.next = node;
            }
        }
        return ans;
    }
}