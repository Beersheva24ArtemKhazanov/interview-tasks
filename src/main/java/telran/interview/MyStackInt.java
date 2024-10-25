package telran.interview;

import java.util.*;

public class MyStackInt {
    private LinkedList<Integer> list;
    private LinkedList<Integer> listOfMaxes;

    public MyStackInt() {
        list = new LinkedList<>();
        listOfMaxes = new LinkedList<>();
    }

    public void push(int num) {
        if (listOfMaxes.isEmpty() || num >= listOfMaxes.getLast()) {
            listOfMaxes.addLast(num);
        }
        list.addLast(num);
    }

    public int pop() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        int removedNum = list.removeLast();
        if (removedNum == listOfMaxes.getLast()) {
            listOfMaxes.removeLast();
        }
        return removedNum;
    }

    public int peek() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getMaxElement() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return listOfMaxes.getLast();
    }
}
