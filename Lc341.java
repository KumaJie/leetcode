package leetcode;

import java.util.*;

/**
 * @author Kuma
 * @date 2021年3月23日
 * 341. 扁平化嵌套列表迭代器
 */
public class Lc341 {
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> st = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        Collections.reverse(nestedList);
        for (NestedInteger i : nestedList){
            st.push(i);
        }
    }

    @Override
    public Integer next() {
        return st.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!st.isEmpty() && !st.peek().isInteger()){
            Collections.reverse(st.peek().getList());
            for (NestedInteger i : st.pop().getList()){
                st.push(i);
            }
        }
        return !st.isEmpty() && st.peek().isInteger();
    }
}
