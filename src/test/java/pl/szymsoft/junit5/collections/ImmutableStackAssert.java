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
                () -> org.assertj.core.api.Assertions.assertThat(actual.isEmpty()).as("stack.isEmpty()").isTrue(),
                () -> org.assertj.core.api.Assertions.assertThat(actual.peek()).as("stack.peek()").isEmpty(),
                () -> org.assertj.core.api.Assertions.assertThat(actual.size()).as("stack.size()").isZero(),
                () -> org.assertj.core.api.Assertions.assertThat(actual.pop()).as("stack.pop()").isEqualTo(actual)
        );
        return this;
    }

    public ImmutableStackAssert<E> isNotEmpty() {
        isNotNull();
        assertAll(
                () -> Assertions.assertThat(actual.isEmpty()).as("stack.isEmpty()").isFalse(),
                () -> Assertions.assertThat(actual.peek()).as("stack.peek()").isPresent(),
                () -> Assertions.assertThat(actual.size()).as("stack.size()").isPositive(),
                () -> Assertions.assertThat(actual.pop()).as("stack.pop()").isNotEqualTo(actual)
        );
        return this;
    }
}
