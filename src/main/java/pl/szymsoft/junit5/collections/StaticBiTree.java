package pl.szymsoft.junit5.collections;

import static lombok.AccessLevel.PRIVATE;

import javax.annotation.Nonnull;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = PRIVATE)
public class StaticBiTree<E extends Comparable<E>> implements SearchableContainer<E> {

    private static final Node<?> EMPTY_NODE = new EmptyNode<>();

    @Nonnull
    private Node<E> root;

    public static <E extends Comparable<E>> StaticBiTree<E> empty() {
        return new StaticBiTree<E>(emptyNode());
    }

    @SuppressWarnings("unchecked")
    private static <E extends Comparable<E>> Node<E> emptyNode() {
        return (Node<E>) EMPTY_NODE;
    }

    public void add(E value) {
        root = root.with(value);
    }

    @Override
    public boolean isEmpty() {
        return root.isEmpty();
    }

    @Override
    public int size() {
        return root.size();
    }

    @Override
    public boolean contains(E value) {
        return root.contains(value);
    }

    interface Node<T extends Comparable<T>> {

        int size();

        boolean isEmpty();

        boolean contains(T value);

        Node<T> with(T value);
    }

    private static class EmptyNode<T extends Comparable<T>> implements Node<T> {

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public boolean contains(T value) {
            return false;
        }

        @Override
        public Node<T> with(T value) {
            return new NotEmptyNode<>(value);
        }
    }

    @RequiredArgsConstructor(access = PRIVATE)
    private static class NotEmptyNode<T extends Comparable<T>> implements Node<T> {

        private final T value;

        private Node<T> leftNode = emptyNode();
        private Node<T> rightNode = emptyNode();

        @Override
        public int size() {
            return 1 + leftNode.size() + rightNode.size();
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(T value) {
            return this.value.equals(value)
                    || leftNode.contains(value)
                    || rightNode.contains(value);
        }

        @Override
        public Node<T> with(T newValue) {
            if (newValue.compareTo(value) < 0) {
                leftNode = new NotEmptyNode<>(newValue);
            }
            rightNode = new NotEmptyNode<>(newValue);
            return this;
        }
    }
}
