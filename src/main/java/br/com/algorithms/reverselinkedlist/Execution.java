package br.com.algorithms.reverselinkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Execution {
    public static void main(String[] args) {
        ListNode listNode = fillNodes(Arrays.asList(10, 20, 30, 40, 50, 60));
        new SolutionIterativeLinkReversal().reverseBetween(listNode, 3, 5);
        final StringBuilder builder = new StringBuilder();
        do {
            if (!builder.isEmpty()) {
                builder.append(",");
                listNode = listNode.getNext();
            }
            builder.append(listNode.getVal());

        } while (listNode.getNext() != null);

        System.out.println(builder);
    }

    public static ListNode fillNodes(final List<Integer> values) {
        final ListNode head = new ListNode();
        ListNode currentNode = null;
        final Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            final ListNode nextNode = new ListNode();
            final Integer value = iterator.next();
            if (currentNode == null) {
                head.setVal(value);
                head.setNext(nextNode);
            } else {
                currentNode.setVal(value);
                if (!iterator.hasNext())
                    continue;
                currentNode.setNext(nextNode);
            }
            currentNode = nextNode;
        }
        return head;
    }

}
