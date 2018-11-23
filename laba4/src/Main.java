import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MariaDron
 */
public class Main {
    public TestedObject testedObject = new TestedObject();
    public String str = "str";
    public List list = new ArrayList();
    public Integer i = 5;
    public Boolean bool = true;


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {
        Main main = new Main();
        main.overrideToStringMethod();
        main.methodParameters();

        TestedObject testedObject = new TestedObject();
        testedObject.createAnonymousClasses();
    }

    /**
     * Реализовать собственный класс с несколькими полями и методами, переопределить унаследованный метод toString().
     */
    private void overrideToStringMethod() {
        System.out.println("============================================\nTASK 1");
        TestedObject testedObject = new TestedObject();
        System.out.println(testedObject.toString());
    }

    private void methodParameters() throws NoSuchMethodException, IllegalAccessException {
        printParameters(testedObject, str, list, i, bool);
    }

    /**
     * Реализовать метод, принимающий пять разнотипных параметров (в т.ч. собственных классов), тремя разными способами:
     * с явным заданием пяти разных параметров, через массив object[] и varargs. Напечатать на экране тип параметра
     * и его значение (для класса - основные поля).
     */
    public void printParameters(TestedObject testedObject, String str, List list, Integer i, Boolean bool) throws NoSuchMethodException, IllegalAccessException {
        System.out.println("\n============================================\nTASK 2");

        Method method = Main.class.getMethod("printParameters", TestedObject.class,
                String.class, List.class, Integer.class, Boolean.class);
        Field[] fields = Main.class.getFields();
        Parameter[] parameters = method.getParameters();
        for (int j = 0; j < parameters.length; j++) {
            System.out.println(parameters[j].getType().getName() + " " + fields[j].getName() + " = " + fields[j].get(this));
        }
    }
}
