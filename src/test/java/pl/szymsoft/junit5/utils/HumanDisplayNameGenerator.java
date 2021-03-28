package pl.szymsoft.junit5.utils;

import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayNameGenerator;

public class HumanDisplayNameGenerator implements DisplayNameGenerator {

    @Override
    public String generateDisplayNameForClass(Class<?> testClass) {
        return "An " + toTestedClassName(testClass);
    }

    private String toTestedClassName(Class<?> testClass) {
        var simpleName = testClass.getSimpleName();
        return simpleName.endsWith("Test")
                ? simpleName.substring(0, simpleName.length() - 4)
                : simpleName;
    }

    @Override
    public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
        return nestedClass.getSimpleName().replace("_", " ");
    }

    @Override
    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
        return testMethod.getName().replace("_", " ");
    }
}
