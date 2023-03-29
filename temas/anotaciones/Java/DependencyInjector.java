import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.*;

public class DependencyInjector {
    public static void injectField(Object obj) throws Exception{
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(CompareById.class)) {
                // Inyectar el comparador por ID
                field.setAccessible(true);  //para acceder a atributo privado
                field.set(obj, new BankAccountComparatorById());
            } else if (field.isAnnotationPresent(CompareByDate.class)) {
                // Inyectar el comparador por fecha
                field.setAccessible(true);
                field.set(obj, new BankAccountComparatorByCreationDate());
            }else if (field.isAnnotationPresent(LocalDateNow.class)) {
                // Inyectar el comparador por fecha
                field.setAccessible(true);
                field.set(obj, LocalDate.now());
            }
        }
    }

    public static void injectMethod(Object obj) throws Exception{
        Class<?> clazz = obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(CompareById.class)) {
                // Inyectar el comparador por ID
                method.invoke(obj, new BankAccountComparatorById());
            } else if (method.isAnnotationPresent(CompareByDate.class)) {
                // Inyectar el comparador por fecha
                method.invoke(obj, new BankAccountComparatorByCreationDate());
            }
        }
    }
}