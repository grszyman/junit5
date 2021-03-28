package pl.szymsoft.junit5.collections;

import static lombok.AccessLevel.PRIVATE;

import java.util.Optional;

import lombok.RequiredArgsConstructor;

public interface TypeBasedImmutableStack<E> extends ImmutableStack<E> {

    static <E> TypeBasedImmutableStack<E> empty() {
        return new EmptyTypeBasedImmutableStack<>();
    }

    Optional<E> peek();

    TypeBasedImmutableStack<E> with(E value);

    TypeBasedImmutableStack<E> pop();

    boolean isEmpty();

    int size();

    class EmptyTypeBasedImmutableStack<E> implements TypeBasedImmutableStack<E> {

        @Override
        public Optional<E> peek() {
            return Optional.empty();
        }

        @Override
        public TypeBasedImmutableStack<E> with(E value) {
            return new NotEmptyTypeBasedImmutableStack<>(this, value);
        }

        @Override
        public TypeBasedImmutableStack<E> pop() {
            return this;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public int size() {
            return 0;
        }
    }

    @RequiredArgsConstructor(access = PRIVATE)
    class NotEmptyTypeBasedImmutableStack<E> implements TypeBasedImmutableStack<E> {

        private final TypeBasedImmutableStack<E> parentStack;
        private final E valueOnTop;

        @Override
        public Optional<E> peek() {
            return Optional.ofNullable(valueOnTop);
        }

        @Override
        public TypeBasedImmutableStack<E> with(E value) {
            return new NotEmptyTypeBasedImmutableStack<>(this, value);
        }

        @Override
        public TypeBasedImmutableStack<E> pop() {
            return parentStack;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public int size() {
            return 1 + parentStack.size();
        }
    }
}
