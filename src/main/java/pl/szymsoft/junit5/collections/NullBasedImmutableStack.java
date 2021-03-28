package pl.szymsoft.junit5.collections;

import static lombok.AccessLevel.PRIVATE;

import java.util.Optional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = PRIVATE)
public class NullBasedImmutableStack<E> implements ImmutableStack<E> {

    private final ImmutableStack<E> parentStack;
    private final E valueOnTop;

    public static <E> ImmutableStack<E> empty() {
        return new NullBasedImmutableStack<>(null, null);
    }

    @Override
    public Optional<E> peek() {
        return Optional.ofNullable(valueOnTop);
    }

    @Override
    public ImmutableStack<E> with(E value) {
        return new NullBasedImmutableStack<>(this, value);
    }

    @Override
    public ImmutableStack<E> pop() {
        return parentStack == null ? this : parentStack;
    }

    @Override
    public boolean isEmpty() {
        return valueOnTop == null;
    }

    @Override
    public int size() {
        if (parentStack == null) {
            return 0;
        }
        return 1 + parentStack.size();
    }
}
