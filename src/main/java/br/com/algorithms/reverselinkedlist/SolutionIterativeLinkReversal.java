package br.com.algorithms.reverselinkedlist;

public class SolutionIterativeLinkReversal {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null)
            return null;

        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.getNext();
            m--;
            n--;
        }

        ListNode con = prev, tail = cur;
        ListNode third;
        while (n > 0) {
            third = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = third;
            n--;
        }
        if(con != null){
            con.setNext(prev);
        }else {
            head = prev;
        }
        tail.setNext(cur);
        return  head;
    }

}
