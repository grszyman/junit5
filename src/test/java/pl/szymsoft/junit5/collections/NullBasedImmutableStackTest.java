package pl.szymsoft.junit5.collections;

import pl.szymsoft.junit5.utils.HumanDisplayName;

@HumanDisplayName
class NullBasedImmutableStackTest extends ImmutableStackContract {

    @Override
    ImmutableStack<String> createEmptyStack() {
        return NullBasedImmutableStack.empty();
    }
}
