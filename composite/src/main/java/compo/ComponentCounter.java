package compo;

import java.util.function.Consumer;

public class ComponentCounter implements Consumer<Component> {
    private int count =0;
    @Override
    public void accept(Component component) {
        ++count;
    }
    public int getCount(){
        return count;
    }
}
