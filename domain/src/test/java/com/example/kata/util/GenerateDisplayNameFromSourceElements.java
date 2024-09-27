package com.example.kata.util;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@DisplayNameGeneration(GenerateDisplayNameFromSourceElements.ReplaceUnderscoresAndOmitParameterTypes.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface GenerateDisplayNameFromSourceElements {

    class ReplaceUnderscoresAndOmitParameterTypes extends DisplayNameGenerator.ReplaceUnderscores {

        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            var name = super.generateDisplayNameForMethod(testClass, testMethod);
            return removeParameterTypes(name);
        }

        private static String removeParameterTypes(String name) {
            return name.replaceAll("[(].*", "");
        }
    }
}
