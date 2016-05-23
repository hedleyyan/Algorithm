
package reflection;

import java.util.Set;

import org.reflections.Reflections;
import unionfind.AbstractUnionFind;

public class Test {
    public static void main(String[] args) {
        Reflections reflections = new Reflections();

        Set<Class<? extends AbstractUnionFind>> subTypes = reflections.getSubTypesOf(AbstractUnionFind.class);

//        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(SomeAnnotation.class);
        
        for (Class c : subTypes) {
            System.out.println(c.getSimpleName());
        }
    }
}
