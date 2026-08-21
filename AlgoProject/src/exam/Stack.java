package stack;

public class Stack {
    private int stackSize;
    private int top;
    private char[] stackArr;

    public Stack(int stackSize) {
        this.stackSize = stackSize;
        this.top = -1;
        this.stackArr = new char[stackSize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stackSize - 1;
    }

    public void push(char item) {
        if (isFull()) {
            System.out.println("Stack Full. Overflow");
        } else {
            stackArr[++top] = item;
        }
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return 'E';
        } else {
            return stackArr[top--];
        }
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return 'E';
        } else {
            return stackArr[top];
        }
    }

    public void clear() {
        top = -1;
    }

    public void showStack() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
        } else {
            System.out.println("Stack items : ");

            for (int i = 0; i <= top; i++) {
                System.out.println(i + " : " + stackArr[i]);
            }

            System.out.println("top : " + top);
        }
    }

    public int size() {
        return top + 1;
    }

    public int getCapacity() {
        return stackSize;
    }
}