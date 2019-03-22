package baozi_synchronized;

public class Baozi {
    private static int count = 0;
    private int id = ++count;

    @Override
    public String toString() {
        return "包子:" + id;
    }
}
