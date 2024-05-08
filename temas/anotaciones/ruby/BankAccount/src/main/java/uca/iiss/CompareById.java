package uca.iiss;

// creamos la anotación

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.util.Comparator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CompareById {
    Class<? extends Comparator<BankAccount>> value() default BankAccountComparatorById.class;
}