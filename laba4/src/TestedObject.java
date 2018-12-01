/**
 * Реализовать собственный класс с несколькими полями и методами, переопределить унаследованный метод toString().
 *
 * @author MariaDron
 */
public class TestedObject {
    public String testString;
    private int i = 10;
    static int j = 0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return super.toString() + "; i = " + getI()
                + "; testString = " + testString;
    }

    /**
     * ============================================TASK 4
     * Реализовать локальный класс, проверить доступность полей и методов внешнего класса, локальных переменных метода
     * (изменяемых и нет), который создает локальный класс.
     */
    private void method(int i) {
        final float f = 150f;
        class LocalClass {
            private int k;
            private float fl;
            private int stJ;
            private String testStr;

            public LocalClass() {
                k = i;
                fl = f;
                stJ = j;
                testStr = testString;
            }
        }
    }

    /**
     * ============================================TASK 3
     * Реализовать вложенный класс, статический вложенный класс,
     * продемонстрировать доступность полей и методов внешнего класса.
     */
    class InnerClass {
        private String innerTestStr;
        private int innerI;

        public InnerClass() {
            innerTestStr = testString;
            innerI = i;
        }
    }

    static class StaticInnerClass {
        private String innerTestStr;
        private int innerI;

        public StaticInnerClass() {
            TestedObject testedObject = new TestedObject();
            innerTestStr = testedObject.toString();
            innerI = j;
        }
    }

    /**
     * Создать три анонимных класса на основе интерфейса, продемонстрировать полиморфизм.
     * Создать анонимный класс, вызвать его методы без определения локальной переменной.
     */
    public void createAnonymousClasses() {
        System.out.println("============================================\nTASK 6");
        AnonymousInterface class1 = () -> 1;

        AnonymousInterface class2 = new AnonymousInterface() {
            @Override
            public int getIndex() {
                return 2;
            }

            @Override
            public String toString() {
                return super.toString();
            }
        };

        AnonymousInterface class3 = new AnonymousInterface() {
            @Override
            public int getIndex() {
                return 3;
            }

            @Override
            public String toString() {
                return "Class3_" + super.toString() + "index=" + getIndex();
            }
        };

        System.out.println(class1.toString() + " index = " + class1.getIndex()
                + "\n" +class2.toString() + "\n" + class3.toString());
    }
}
