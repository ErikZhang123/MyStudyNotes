public class node<E> {
    E item;
    node<E> next;
    node<E> prev;
    public node(E element){
        this.item = element;
        this.next = null;
        this.prev = null;
    }
}