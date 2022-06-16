package compo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Composite extends Component {
    List<Component> components = new ArrayList<>();

    @Override
    void print() {
        System.out.println("I am at Composite Memoery: " + this);
        components.forEach(Component::print);
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public List<Component> getComponents() {
        return Collections.unmodifiableList(components);
    }

/*    @Override
    int getCount() {
        int count = 1;
        for (Component c : components) {
            count += c.getCount();
        }
        return count;
    }*/

    @Override
    void forEach(Consumer<Component> action) {
        action.accept(this);
        components.forEach(c -> c.forEach(action));

    }
}
