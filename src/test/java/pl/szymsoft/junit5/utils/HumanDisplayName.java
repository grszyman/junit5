package pl.szymsoft.junit5.utils;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.annotation.meta.TypeQualifierDefault;

import org.junit.jupiter.api.DisplayNameGeneration;

@Target({TYPE, METHOD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@TypeQualifierDefault({TYPE, METHOD})
@DisplayNameGeneration(HumanDisplayNameGenerator.class)
public @interface HumanDisplayName {
}
