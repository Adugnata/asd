import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExternalIterator {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(List.of(1,2,3,4,5));
        Iterator iter = list.iterator();
        while(iter.hasNext())
            System.out.printf("%d ",iter.next());
        list.forEach(action->System.out.printf("%d ",action));
    }
}
