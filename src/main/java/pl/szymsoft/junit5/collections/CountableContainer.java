package pl.szymsoft.junit5.collections;

interface CountableContainer {

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }
}
