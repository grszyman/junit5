package pl.szymsoft.junit5.collections;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

@SuppressWarnings("UnusedReturnValue")
public class ImmutableStackAssert<E> extends AbstractAssert<ImmutableStackAssert<E>, ImmutableStack<E>> {

    ImmutableStackAssert(ImmutableStack<E> stack) {
        super(stack, ImmutableStackAssert.class);
    }

    public static <E> ImmutableStackAssert<E> assertThat(ImmutableStack<E> actual) {
        return new ImmutableStackAssert<>(actual);
    }

    public ImmutableStackAssert<E> isEmpty() {
        isNotNull();
        assertAll(
                () -> Assertions.assertThat(actual.isEmpty()).as("isEmpty()").isTrue(),
                () -> Assertions.assertThat(actual.peek()).as("peek()").isEmpty(),
                () -> Assertions.assertThat(actual.size()).as("size()").isZero(),
                () -> Assertions.assertThat(actual.pop()).as("pop()").isEqualTo(actual)
        );
        return this;
    }

    public ImmutableStackAssert<E> isNotEmpty() {
        isNotNull();
        assertAll(
                () -> Assertions.assertThat(actual.isEmpty()).as("isEmpty()").isFalse(),
                () -> Assertions.assertThat(actual.peek()).as("peek()").isPresent(),
                () -> Assertions.assertThat(actual.size()).as("size()").isPositive(),
                () -> Assertions.assertThat(actual.pop()).as("pop()").isNotEqualTo(actual)
        );
        return this;
    }
}
