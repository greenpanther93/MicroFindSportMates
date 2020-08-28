package wrapper;
import java.util.ArrayList;
import java.util.List;
public class InstanceDatabase {
    private static List<Object> objects = new ArrayList<Object>();

    public synchronized static int addObject(Object obj) {
        objects.add(obj);
        return objects.size()-1;
    }

    public static Object getObject(int index) {
        return objects.get(index);
    }
}