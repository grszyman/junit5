package pl.szymsoft.junit5.collections;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

@SuppressWarnings("UnusedReturnValue")
public class ImmutableTreeAssert<E> extends AbstractAssert<ImmutableTreeAssert<E>, StaticTree<E>> {

    ImmutableTreeAssert(StaticTree<E> tree) {
        super(tree, ImmutableTreeAssert.class);
    }

    public static <E> ImmutableTreeAssert<E> assertThat(StaticTree<E> actual) {
        return new ImmutableTreeAssert<>(actual);
    }

    public ImmutableTreeAssert<E> isEmpty() {
        isNotNull();
        assertAll(
                () -> Assertions.assertThat(actual.isEmpty()).as("isEmpty()").isTrue(),
                () -> Assertions.assertThat(actual.size()).as("size()").isZero()
        );
        return this;
    }

    public ImmutableTreeAssert<E> isNotEmpty() {
        isNotNull();
        assertAll(
                () -> Assertions.assertThat(actual.isEmpty()).as("isEmpty()").isFalse(),
                () -> Assertions.assertThat(actual.size()).as("size()").isPositive()
        );
        return this;
    }
}
