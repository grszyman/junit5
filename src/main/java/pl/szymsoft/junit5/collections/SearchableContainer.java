package pl.szymsoft.junit5.collections;

public interface SearchableContainer<E> extends CountableContainer {

    boolean contains(E value);

    default boolean doesNotContain(E value) {
        return !contains(value);
    }
}
