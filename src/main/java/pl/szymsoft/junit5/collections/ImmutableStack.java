package pl.szymsoft.junit5.collections;

import java.util.Optional;

public interface ImmutableStack<E> {

    Optional<E> peek();

    ImmutableStack<E> with(E value);

    ImmutableStack<E> pop();

    boolean isEmpty();

    int size();
}
