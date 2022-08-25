package br.com.algorithms;

public class ReverseArray {
    public static void main(String[] args) {
        char[] c = {'a', 'b', 'c', 'd', 'e'};
        int begin = 0, end = c.length - 1;
        while (begin < end) {
            swap(begin++, end--, c);
        }
        System.out.println(c);
    }
    private static void swap(int begin, int end, char[] c) {
        char temp = c[begin];
        c[begin] = c[end];
        c[end] = temp;
    }

}
