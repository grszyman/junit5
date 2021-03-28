package pl.szymsoft.junit5.collections;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.szymsoft.junit5.collections.ImmutableTreeAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import pl.szymsoft.junit5.utils.HumanDisplayName;

@HumanDisplayName
class StaticBiTreeTest {

    @Test
    void is_instantiated_with_the_empty_method() {
        assertThat(StaticBiTree.empty())
                .isNotNull()
                .isInstanceOf(StaticBiTree.class);
    }

    @Nested
    class when_created_with_the_empty_method {

        private final StaticBiTree<String> tree = StaticBiTree.empty();

        @Test
        void is_empty() {
            assertThat(tree).isEmpty();
        }

        @Test
        void does_not_contain_an_element() {
            assertThat(tree.contains("AN_ELEMENT")).isFalse();
        }

        @Nested
        class after_adding_the_first_element {

            private static final String FIRST_ELEMENT = "1";

            @BeforeEach
            void add_the_first_element() {
                tree.add(FIRST_ELEMENT);
            }

            @Test
            void is_no_longer_empty() {
                assertThat(tree).isNotEmpty();
            }

            @Test
            void has_size_of_1() {
                assertThat(tree.size()).isOne();
            }

            @Test
            void contains_the_first_element() {
                assertThat(tree.contains(FIRST_ELEMENT)).isTrue();
            }

            @Nested
            class after_adding_the_second_element {

                private static final String SECOND_ELEMENT = "2";

                @BeforeEach
                void add_the_second_element() {
                    tree.add(SECOND_ELEMENT);
                }

                @Test
                void is_still_not_empty() {
                    assertThat(tree).isNotEmpty();
                }

                @Test
                void has_size_of_2() {
                    assertThat(tree.size()).isEqualTo(2);
                }

                @Test
                void contains_the_first_element() {
                    assertThat(tree.contains(FIRST_ELEMENT)).isTrue(); // TODO: move to assertion
                }

                @Test
                void contains_the_second_element() {
                    assertThat(tree.contains(SECOND_ELEMENT)).isTrue(); // TODO: move to assertion
                }

            }

        }
    }
}
