/**
 * Реализовать собственный класс с несколькими полями и методами, переопределить унаследованный метод toString().
 *
 * @author MariaDron
 */
public class TestedObject {
    public String testString;
    private int i = 10;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return super.toString() + "; i = " + getI() + "; testString = " + testString;
    }
}
