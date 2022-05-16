public class Node<T> {
    T konstanta;
    Node<T> right;

    public Node(T variabel) {
        konstanta = variabel;
        right = null;
    }

    public Node() {
        right = null;
        konstanta = null;
    }

    @Override
    public String toString() {
        return (String)konstanta ;
    }
}
