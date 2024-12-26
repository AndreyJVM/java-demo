package annotations;

import java.lang.reflect.Method;

public class AnnotationsProcessor {

    public static void processorLogging(Class<?> someClass) {

        for(Method method : someClass.getDeclaredMethods()) {
            Log log = method.getAnnotation(Log.class);
            if (log != null) {
                System.out.println("Logging Methods: " + method.getName() + ", Level: " + log.level());
            }
        }
    }
}