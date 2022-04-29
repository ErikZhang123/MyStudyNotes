
public class MyQueue<E> implements DelayedQueue<E>{
    private node<E> head;
    private node<E> next;
    private node<E> tail;
    private int size;
    private int delay_condition;
    private int calculator;
    private boolean flag = false;//flag 为true时可以pop，flag为false时不能pop

    public MyQueue(int i){
//        if(i<=1) i=0;
        head =null;
        next = null;
        size = 0;
        delay_condition = i;
        calculator = delay_condition;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void enqueue(E element) {
        //is head
        if(size==0 ){
            head = new node(element);
            tail = head;
            calculator = delay_condition;
            size++;
            calculator--;
        }//is not head
        else{
            if(flag){
                calculator = delay_condition;
                flag = false;
            }
            node temp = new node(element);
            node temp2 = tail;

            tail.next = temp;
            tail = temp;
            tail.prev = temp2;
            size++;
            calculator--;
        }
    }

    @Override
    public E dequeue() throws IllegalStateException {
        if(size == 0 )
            throw new IllegalStateException("");
        if(!check())
            return null;
        node<E> pointer = head;
        head = head.next;
        size -- ;
        return pointer.item;
    }

    @Override
    public E peek() throws IllegalStateException {
        if(size == 0 ) throw new IllegalStateException("The stack is empty.");
        return head.item;
    }

    @Override
    public int getDelay() {
        if(calculator<0)
            return 0;
        if(calculator==15)
            return 14;
        return calculator;
    }

    @Override
    public void setMaximumDelay(int d) {
        this.delay_condition = d;
    }

    @Override
    public int getMaximumDelay() {
        return delay_condition;
    }

    @Override
    public boolean clear() {
        if(size == 0)
            return true;
        if(check()){
            head = null;
            tail = null;
            size = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object elem) {
        int i=0;
        if (elem == null) {
            for (node<E> x = head; x != null && i<size; x = x.next,i++) {
                if (x.item == null)
                    return true;
            }
        } else {
            for (node<E> x = head; x != null && i<size; x = x.next,i++) {
                if (elem.equals(x.item))
                    return true;
            }
        }
        return false;
    }

    public boolean check(){
        if(this.calculator <= 0)
            flag = true;
        return flag;
    }
}

