package api;

// LIFO - Last in first out
public final class Stack<T> {
    public Node<T> top;

    public Stack() {
    }

    public Stack(T value) {
        push(new Node<>(value));
    }

    public Node<T> peek() {
        return top;
    }

    public void push(Node<T> node) {
        if (node != null) {
            node.previous = top;
            top = node;
        }
    }

    public void pop() {
        if (top != null) {
            top = top.previous;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final Stack<?> stack = (Stack<?>) object;

        return top != null ? top.equals(stack.top) : stack.top == null;
    }

    @Override
    public int hashCode() {
        return top != null ? top.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Stack{" +
            "top=" + top +
            '}';
    }
}
