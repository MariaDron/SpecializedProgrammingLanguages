/**
 * Сделать класс с перегруженными конструкторами (по умолчанию, с заданными параметрами, создание копии другого объекта).
 *
 * @author Maria Dron
 */
public class ScopeConstructor {
    ListManipulation listManipulationCopy;
    public ScopeConstructor() {}

    public ScopeConstructor(int i) {}

    public ScopeConstructor(ListManipulation listManipulation) {
        listManipulationCopy = listManipulation.clone();
    }
}
