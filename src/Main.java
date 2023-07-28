public class Main {
    public static void main(String[] args) {

        var items = new Array(3);
        items.insert(1);
        items.insert(2);
        items.insert(3);
        items.insertAt(5, 0);
        items.print();

    }
}