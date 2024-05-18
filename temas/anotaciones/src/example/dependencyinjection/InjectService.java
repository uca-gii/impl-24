package example.dependencyinjection;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectService {
    Class<? extends MainService> value();
}
