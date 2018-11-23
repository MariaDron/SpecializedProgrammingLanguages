import java.io.Closeable;
import java.io.IOException;

/**
 * Разработать класс, реализующий интерфейс Closeable.
 * В конструкторе вывести сообщение о создании, в методе close() - о закрытии.
 * Проверить функционирование блока try() с ресурсами.
 *
 * @author MariaDron
 */
public class CloseableImpl implements Closeable {

    public CloseableImpl() {
        System.out.println("The object of CloseableImple class was created");
    }

    @Override
    public void close() throws IOException {
        System.out.println("Class was closed");
    }
}
