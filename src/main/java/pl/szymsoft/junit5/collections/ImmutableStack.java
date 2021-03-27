package pl.szymsoft.junit5.collections;

import static lombok.AccessLevel.PRIVATE;

import java.util.Optional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = PRIVATE)
public class ImmutableStack<E> {

    private final ImmutableStack<E> parentStack;
    private final E valueOnTop;

    public static <E> ImmutableStack<E> empty() {
        return new ImmutableStack<>(null, null);
    }

    public Optional<E> peek() {
        return Optional.ofNullable(valueOnTop);
    }

    public ImmutableStack<E> push(E value) {
        return new ImmutableStack<>(this, value);
    }

    public ImmutableStack<E> pop() {
        return parentStack == null ? this : parentStack;
    }

    public boolean isEmpty() {
        return valueOnTop == null;
    }

    public long size() {
        if (parentStack == null) {
            if (valueOnTop == null) {
                return 0;
            }
            return 1;
        }
        return 1 + parentStack.size();
    }
}
