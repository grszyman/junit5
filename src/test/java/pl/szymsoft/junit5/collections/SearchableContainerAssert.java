package pl.szymsoft.junit5.collections;

import org.assertj.core.api.Assertions;

@SuppressWarnings("UnusedReturnValue")
public class SearchableContainerAssert<E> extends CountableContainerAssert<SearchableContainerAssert<E>, SearchableContainer<E>> {

    protected final SearchableContainer<E> actual;

    SearchableContainerAssert(SearchableContainer<E> container) {
        super(container, SearchableContainerAssert.class);
        this.actual = container;
    }

    public static <E> SearchableContainerAssert<E> assertThat(SearchableContainer<E> actual) {
        return new SearchableContainerAssert<>(actual);
    }

    public SearchableContainerAssert<E> contains(E value) {
        isNotNull();
        Assertions.assertThat(actual.contains(value)).as("contains()").isTrue();
        return this;
    }

    public SearchableContainerAssert<E> doesNotContains(E value) {
        isNotNull();
        Assertions.assertThat(actual.doesNotContain(value)).as("doesNotContains()").isTrue();
        return this;
    }
}
