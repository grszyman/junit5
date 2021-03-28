package pl.szymsoft.junit5.collections;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.szymsoft.junit5.collections.ImmutableStackAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import pl.szymsoft.junit5.utils.HumanDisplayName;

@Testable
@HumanDisplayName
abstract class ImmutableStackContract {

    abstract ImmutableStack<String> createEmptyStack();

    @Test
    void is_instantiated_with_the_empty_method() {
        assertThat(createEmptyStack())
                .isNotNull()
                .isInstanceOf(ImmutableStack.class);
    }

    @Nested
    class when_created_with_the_empty_method {

        private ImmutableStack<String> stack = createEmptyStack();

        @Test
        void is_empty() {
            assertThat(stack).isEmpty();
        }

        @Nested
        class after_pushing_the_first_element {

            private static final String FIRST_ELEMENT = "1";

            @BeforeEach
            void push_first_element() {
                stack = stack.with(FIRST_ELEMENT);
            }

            @Test
            void is_no_longer_empty() {
                assertThat(stack).isNotEmpty();
            }

            @Test
            void has_the_first_element_on_the_top() {
                assertThat(stack.peek()).hasValue(FIRST_ELEMENT);
            }

            @Test
            void has_a_size_of_1() {
                assertThat(stack.size()).isOne();
            }

            @Nested
            class after_popping_an_element {

                @BeforeEach
                void pop_an_element() {
                    stack = stack.pop();
                }

                @Test
                void is_empty_again() {
                    assertThat(stack).isEmpty();
                }
            }

            @Nested
            class after_pushing_the_second_element {

                private static final String SECOND_ELEMENT = "2";

                @BeforeEach
                void push_second_element() {
                    stack = stack.with(SECOND_ELEMENT);
                }

                @Test
                void is_still_not_empty() {
                    assertThat(stack).isNotEmpty();
                }

                @Test
                void has_a_size_of_2() {
                    assertThat(stack.size()).isEqualTo(2);
                }

                @Test
                void has_the_second_element_on_the_top() {
                    assertThat(stack.peek()).hasValue(SECOND_ELEMENT);
                }

                @Nested
                class after_popping_two_elements {

                    @BeforeEach
                    void pop_two_elements() {
                        stack = stack.pop().pop();
                    }

                    @Test
                    void is_empty_again() {
                        assertThat(stack).isEmpty();
                    }
                }
            }
        }
    }
}
