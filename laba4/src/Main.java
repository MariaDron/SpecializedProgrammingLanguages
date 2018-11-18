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
        System.out.println("============================================\nTASK 1");
        TestedObject testedObject = new TestedObject();
        System.out.println(testedObject.toString());

        Main main = new Main();
        main.methodParameters();
    }

    private void methodParameters() throws NoSuchMethodException, IllegalAccessException {
        printParameters(testedObject, str, list, i, bool);
    }

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
