package pl.szymsoft.junit5.collections;

import pl.szymsoft.junit5.utils.HumanDisplayName;

@HumanDisplayName
class TypeBasedImmutableStackTest extends ImmutableStackContract {

    @Override
    ImmutableStack<String> createEmptyStack() {
        return TypeBasedImmutableStack.empty();
    }
}
