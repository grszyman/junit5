package pl.szymsoft.junit5.collections;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.assertj.core.api.Assertions;

@SuppressWarnings("UnusedReturnValue")
public class ImmutableStackAssert<E> extends CountableContainerAssert<ImmutableStackAssert<E>, ImmutableStack<E>> {

    ImmutableStackAssert(ImmutableStack<E> stack) {
        super(stack, ImmutableStackAssert.class);
    }

    public static <E> ImmutableStackAssert<E> assertThat(ImmutableStack<E> actual) {
        return new ImmutableStackAssert<>(actual);
    }

    @Override
    public ImmutableStackAssert<E> isEmpty() {
        super.isEmpty();
        assertAll(
                () -> Assertions.assertThat(actual.peek()).as("peek()").isEmpty(),
                () -> Assertions.assertThat(actual.pop()).as("pop()").isEqualTo(actual)
        );
        return this;
    }

    @Override
    public ImmutableStackAssert<E> isNotEmpty() {
        super.isNotEmpty();
        assertAll(
                () -> Assertions.assertThat(actual.peek()).as("peek()").isPresent(),
                () -> Assertions.assertThat(actual.pop()).as("pop()").isNotEqualTo(actual)
        );
        return this;
    }
}
