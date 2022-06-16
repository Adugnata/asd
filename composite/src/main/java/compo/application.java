package compo;

import java.util.ArrayList;
import java.util.List;

public class application {
    public static void main(String[] args) {
        Leaf l1 = new Leaf();
        Leaf l2 = new Leaf();
        Leaf l3 = new Leaf();
        Composite c1 = new Composite();
        Composite c2 = new Composite();
        Composite c3 = new Composite();
        c1.addComponent(l1);
        c1.addComponent(l2);
        c1.addComponent(l3);
        c2.addComponent(c1);
        c3.addComponent(c2);

        c3.print();
        //System.out.println(c3.getCount());
        ComponentCounter componentCounter = new ComponentCounter();
        c3.forEach(componentCounter);
        System.out.println(componentCounter.getCount());
    }
}
