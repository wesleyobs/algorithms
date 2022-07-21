package br.com.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("{{}[][[[]]]}"));
        System.out.println(s.isValid("([)]"));
        System.out.println(s.isValid("()[]{}"));
    }
}

class Solution {
    public boolean isValid(String s) {
//        final Pattern compile = Pattern.compile("(\\[})|(\\[\\))|(\\{\\))|(\\{\\])|(\\(\\])|(\\(})");
//        final Matcher matcher = compile.matcher(s);
//        if (matcher.find()) return false;
        if (!(s.length() % 2 == 0))
            return false;
        final List<String> stringList = new LinkedList<>(Arrays.asList(s.split("")));
        this.validate(stringList);
        return stringList.isEmpty();
    }

    private void validate(final List<String> stringList) {
        int position = 0;
        do {
            if (position < 0) position = 0;
            final char charFromLeft = stringList.get(position).charAt(0);
            final char charFromRight = stringList.get(position + 1).charAt(0);
            if (charFromLeft == '{' && charFromRight == '}') {
                this.removeElements(stringList, position--);
                continue;
            } else if (charFromLeft == '[' && charFromRight == ']') {
                this.removeElements(stringList, position--);
                continue;
            } else if (charFromLeft == '(' && charFromRight == ')') {
                this.removeElements(stringList, position--);
                continue;
            }
            position++;
        } while (position < stringList.size() - 1);
    }

    private void removeElements(final List<String> stringList, int position) {
        stringList.remove(position--);
        stringList.remove(position + 1);
    }
}
