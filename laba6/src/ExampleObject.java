import java.io.Serializable;

public class ExampleObject implements Serializable {
    String str = "test";
    Long l = 94563L;
    Boolean bool = true;

    @Override
    public String toString() {
        return "ExampleObject{" +
                "str='" + str + '\'' +
                ", l=" + l +
                ", bool=" + bool +
                '}';
    }
}
