package compo;

import java.util.function.Consumer;

public abstract class Component {
    abstract void print();
   // abstract int getCount();
    abstract void forEach(Consumer<Component> action);
}
