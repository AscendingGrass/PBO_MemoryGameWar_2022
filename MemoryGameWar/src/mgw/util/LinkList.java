package mgw.util;

public class LinkList<T>{
    private Node<T> head;
    private int size;

    public LinkList() {
        head = null;
        size = 0;
    }
    
    public void add(T something){
        Node<T> temp = new Node(something);
        if(head == null){
            head = temp;
        }else {
            Node<T> test = head;
            while(test.right != null)
                test = test.right;
            test.right = temp;
        }
        size++;
    }
    public void set(int idx, T something){
        if(idx < size){
            int counter = 0;
            Node<T> temp = head;
            while(counter < idx){
                counter++;
                temp = temp.right;
            }
            temp.konstanta = something;
        }
    }
    public void show(){
        Node<T> temp = head;
        while(temp != null){
            System.out.println(temp.konstanta);
            temp = temp.right;
        }  
    }
    public int size(){
        return size;
    }
    public T get(int idx){
        if(idx >= size)
            return null;
        int counter = 0;
        Node<T> temp = head;
        while(counter < idx){
            counter++;
            temp = temp.right;
        }
        return temp.konstanta;
    }
    
    public void remove(int idx){
        int counter = 0;
        if(idx == 0){
            removeFirst();
        }else if (idx == size-1){
            removeLast();
        }else if(idx < size){
            Node<T> temp = head;
            while(counter < idx-1){
                counter++;
                temp = temp.right;
            }
            Node<T> baru = temp.right.right;
            temp.right = baru;
            size--;
        }
    }
    public void removeFirst(){
        head = head.right;
        size--;
    }
    public void removeLast(){
        if(head.right == null)
            head = null;
        else{
            Node temp = head;
            while(temp.right.right != null)
                temp = temp.right;
            temp.right = null;
        }
        size--;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}