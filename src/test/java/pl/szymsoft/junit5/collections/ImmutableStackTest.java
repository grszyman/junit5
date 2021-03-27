package pl.szymsoft.junit5.collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.function.Consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("An ImmutableStack")
class ImmutableStackTest {

    private static final String FIRST_ELEMENT = "1";
    private static final String SECOND_ELEMENT = "2";

    private static final Consumer<ImmutableStack<String>> DEFINITION_OF_THE_EMPTY_STACK = stack -> assertAll(
            () -> assertThat(stack.isEmpty()).as("stack.isEmpty()").isTrue(),
            () -> assertThat(stack.peek()).as("stack.peek()").isEmpty(),
            () -> assertThat(stack.size()).as("stack.size()").isZero(),
            () -> assertThat(stack.pop()).as("stack.pop()").isEqualTo(stack)
    );

    private static final Consumer<ImmutableStack<String>> DEFINITION_OF_THE_NOT_EMPTY_STACK = stack -> assertAll(
            () -> assertThat(stack.isEmpty()).as("stack.isEmpty()").isFalse(),
            () -> assertThat(stack.peek()).as("stack.peek()").isPresent(),
            () -> assertThat(stack.size()).as("stack.size()").isPositive(),
            () -> assertThat(stack.pop()).as("stack.pop()").isNotEqualTo(stack)
    );

    @Test
    @DisplayName("is instantiated with empty()")
    void be_empty_at_the_beginning() {
        assertThat(ImmutableStack.empty())
                .isNotNull()
                .isInstanceOf(ImmutableStack.class);
    }

    @Nested
    @DisplayName("when created with empty()")
    class when_new {

        private ImmutableStack<String> stack = ImmutableStack.empty();

        @Test
        @DisplayName("is empty")
        void is_empty() {
            assertThat(stack).satisfies(DEFINITION_OF_THE_EMPTY_STACK);
        }

        @Nested
        @DisplayName("after pushing a first element")
        class after_pushing_an_element {

            @BeforeEach
            void push_first_element() {
                stack = stack.push(FIRST_ELEMENT);
            }

            @Test
            @DisplayName("is no longer empty")
            void is_no_longer_empty() {
                assertThat(stack).satisfies(DEFINITION_OF_THE_NOT_EMPTY_STACK);
            }

            @Test
            @DisplayName("has the first element on the top")
            void peek_return_the_element_1_on_the_top() {
                assertThat(stack.peek()).hasValue(FIRST_ELEMENT);
            }

            @Test
            @DisplayName("has a size of 1")
            void has_a_size_of_1() {
                assertThat(stack.size()).isOne();
            }

            @Nested
            @DisplayName("after popping an element")
            class after_popping_an_element {

                @BeforeEach
                void pop_an_element() {
                    stack = stack.pop();
                }

                @Test
                @DisplayName("is empty again")
                void is_empty_again() {
                    assertThat(stack).satisfies(DEFINITION_OF_THE_EMPTY_STACK);
                }
            }

            @Nested
            @DisplayName("after pushing a second element")
            class after_pushing_a_second_element {

                @BeforeEach
                void push_second_element() {
                    stack = stack.push(SECOND_ELEMENT);
                }

                @Test
                @DisplayName("is still not empty")
                void is_still_not_empty() {
                    assertThat(stack).satisfies(DEFINITION_OF_THE_NOT_EMPTY_STACK);
                }

                @Test
                @DisplayName("has a size of 2")
                void has_a_size_of_2() {
                    assertThat(stack.size()).isEqualTo(2);
                }

                @Test
                @DisplayName("has the second element on the top")
                void has_the_second_element_on_the_top() {
                    assertThat(stack.peek()).hasValue(SECOND_ELEMENT);
                }
            }
        }
    }
}
