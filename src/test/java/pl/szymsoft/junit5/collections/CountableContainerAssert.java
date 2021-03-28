package pl.szymsoft.junit5.collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.assertj.core.api.AbstractAssert;

@SuppressWarnings("UnusedReturnValue")
public class CountableContainerAssert<SELF extends CountableContainerAssert<SELF, ACTUAL>, ACTUAL extends CountableContainer> extends AbstractAssert<SELF, ACTUAL> {

    protected final SELF myself;

    @SuppressWarnings("unchecked")
    public CountableContainerAssert(ACTUAL actual, Class<? extends CountableContainerAssert> selfType) {
        super(actual, selfType);
        myself = (SELF) selfType.cast(this);
    }

    public SELF isEmpty() {
        isNotNull();
        assertAll(
                () -> assertThat(actual.isEmpty()).as("isEmpty()").isTrue(),
                () -> assertThat(actual.size()).as("size()").isZero()
        );
        return myself;
    }

    public SELF isNotEmpty() {
        isNotNull();
        assertAll(
                () -> assertThat(actual.isEmpty()).as("isEmpty()").isFalse(),
                () -> assertThat(actual.size()).as("size()").isPositive()
        );
        return myself;
    }

    public SELF hasSize(int size) {
        isNotNull();
        assertThat(actual.size()).as("size()").isEqualTo(size);
        return myself;
    }
}
