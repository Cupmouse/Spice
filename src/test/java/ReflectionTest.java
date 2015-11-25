import net.spicesoftware.api.decoration.fill.GrayScale8Color;
import net.spicesoftware.api.util.ToString;
import net.spicesoftware.api.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @since 2015/11/17
 */
public class ReflectionTest {

    public static void main(String[] args) {
        B a = new B();
        List<Field> declaredFields = ReflectionUtil.getFieldsIncludeSuperClasses(B.class);
        System.out.println(declaredFields.stream().map(Field::toString).collect(Collectors.joining("/")));

        String toString = declaredFields.stream()
                .filter(field -> field.getAnnotation(ToString.class) != null)
                .map(field1 -> {
                    StringBuilder stringBuilder = new StringBuilder();
                    try {
                        Object value;
                        synchronized (a) {
                            field1.setAccessible(true);
                            value = field1.get(a);
                            field1.setAccessible(false);
                        }
                        ToString annotation = field1.getAnnotation(ToString.class);
                        String name = annotation.value();
                        stringBuilder
                                .append(name.isEmpty() ? field1.getName() : name)
                                .append(':')
                                .append(value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return stringBuilder.toString();
                })
                .collect(Collectors.joining(", ", a.getClass().getName() + "{", "}"));

        System.out.println(new GrayScale8Color(100).toString());
    }

    public static class A {
        @ToString
        public final int TESTINT = 999;
        @ToString
        private final int TESTPINT = 1000;
        public final int TESTNINT = 999;
    }
    public static class B extends A{
        @ToString
        public final int TESTINT = 999;
        protected Object object = new Object();
        @ToString
        private String string = "string";
    }
}
