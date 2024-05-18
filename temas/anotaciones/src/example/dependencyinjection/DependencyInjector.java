package example.dependencyinjection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class DependencyInjector {
    public static void injectDependencies(Object object) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectService.class)) {
                InjectService annotation = field.getAnnotation(InjectService.class);
                Class<? extends MainService> serviceClass = annotation.value();
                MainService serviceInstance = serviceClass.getDeclaredConstructor().newInstance();
                field.setAccessible(true);
                field.set(object, serviceInstance);
            }
        }
    }
}