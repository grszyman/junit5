package pl.szymsoft.junit5.collections;

import static lombok.AccessLevel.PRIVATE;

import javax.annotation.Nonnull;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = PRIVATE)
public class StaticTree<E> {

    @Nonnull
    private Node<E> root;

    public static <E> StaticTree<E> empty() {
        return new StaticTree<>(new EmptyNode<>());
    }

    public void add(E value) {
        root = root.with(value);
    }

    public boolean isEmpty() {
        return root.isEmpty();
    }

    public int size() {
        return root.size();
    }

    public boolean contains(E value) {
        return root.contains(value);
    }

    interface Node<T> {

        int size();

        boolean isEmpty();

        boolean contains(T value);

        Node<T> with(T value);
    }

    private static class EmptyNode<T> implements Node<T> {

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
    private static class NotEmptyNode<T> implements Node<T> {

        private final T value;

        @Override
        public int size() {
            return 1;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(T value) {
            return this.value.equals(value);
        }

        @Override
        public Node<T> with(T value) {
            return this;
        }
    }
}
