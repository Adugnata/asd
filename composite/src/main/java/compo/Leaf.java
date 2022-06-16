package compo;

import java.util.function.Consumer;

public class Leaf extends Component {
    @Override
    void print() {
        System.out.println("I am leaf at memory" + this);
    }
/*
    @Override
    int getCount() {
        return 1;
    }*/

    @Override
    void forEach(Consumer<Component> action) {
        action.accept(this);
    }
}
