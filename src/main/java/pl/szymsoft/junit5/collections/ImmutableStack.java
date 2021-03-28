package pl.szymsoft.junit5.collections;

import java.util.Optional;

public interface ImmutableStack<E> extends CountableContainer {

    Optional<E> peek();

    ImmutableStack<E> with(E value);

    ImmutableStack<E> pop();
}
