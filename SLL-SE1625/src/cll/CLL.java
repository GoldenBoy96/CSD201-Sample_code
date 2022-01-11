package cll;

public class CLL<T>{

    Node<T> head;

    public CLL() {
    }

    boolean isEmpty() {
        return head == null;
    }

    private Node getNode(int pos) throws Exception {
        Node tmp = head;
        int count = 0;
        while (count != pos && tmp.next != head) {
            tmp = tmp.next;
            count++;
        }

        if (count != pos) {
            throw new Exception("Index is out of bounds: Index: " + pos + " Size: " + size());
            //addLast(el); //default
            //System.out.println("Can not add!");
        } else {
            return tmp;
        }
    }

    public void addFirst(T el) {
        Node p = new Node(el);
        if (isEmpty()) {
            head = p;
            head.next = p;
            head.pre = p;
        } else if(head.next == head) {
            p.next = head;
            p.pre = head;
            head.next = p;
            head.pre = p;
            head = p;
        } else {
            p.next = head;
            p.pre = head.pre;
            head.pre.next = p;
            head.pre = p;
            head = p;
        }
    }

    public void addLast(T el) {
        addFirst(el);
        rotateCounterClockWise();
    }

    public void addPos(T el, int pos) throws Exception {
        
            Node p = new Node(el);
            Node tmp = getNode(pos);
            p.next = tmp.next;
            p.pre = tmp;
            tmp.next = p;
        
    }

    public void addMany(T[] arr, int arrSize) {
        if (isEmpty()) {
            for (int i = 0; i < arrSize; i++) {
                addLast(arr[i]);
            }
        } else {
            for (int i = 0; i < arrSize; i++) {
                addLast(arr[i]);
            }
        }
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            int count = 0;
            Node tmp = head;
            while (tmp.next != head) {
                count++;
                tmp = tmp.next;
            }
            return count + 1;
        }
    }

    public int indexOf(T value) {
        if (isEmpty()) {
            return -1;
        } else {
            int count = 0;
            Node tmp = head;
            while (tmp.value != value && tmp.next != head) {
                count++;
                tmp = tmp.next;
            }
            if (tmp.value == value) {
                return count;
            } else {
                return -1;
            }
        }
    }

    public T get(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("Index is out of bounds: Index: " + index + " Size: " + size());
        } else {
            Node tmp = getNode(index);
            return (T) tmp.value;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
                       
        } else if (head.next == head){
            head = null;
        } else {
            head.pre.next = head.next;
            head.next.pre = head.pre;
            rotateCounterClockWise();
        }
        
    }

    public void removeLast() {
        if (isEmpty() || head.next == head) {
            removeFirst();
        } else {
            head.pre.pre.next = head;
            head.pre = head.pre.pre;
        }

    }

    public void removeAt(int pos) throws Exception {
        if (isEmpty() || pos == 0 || head.next == head) {
            removeFirst();
        } else {
            Node tmp = head;
            int count = 0;
            while (tmp.next.next != head && count != pos) {
                tmp = tmp.next;
                count++;
            }
            if (count != pos) {
                throw new Exception("Index is out of bounds: Index: " + pos + " Size: " + size());
                //removeLast(); //default
                //System.out.println("Can't find that position!");
            } else {
                tmp.pre.next = tmp.next;
                tmp.next.pre = tmp.pre;
            }
        }
    }
    
    public void rotateClockWise() {
        head = head.pre;
    }
    
    public void rotateCounterClockWise() {
        head = head.next;
    }

    public void removeAll() {
        head = null;
    }

    public void printAll() {
        Node node = head;
        if (!isEmpty()) {
            System.out.print("<- ");
            do {
                if (node.next != head) {
                    System.out.print(node.value + " <=> ");
                } else {
                    System.out.print(node.value + " ->");
                }

                node = node.next;
            } while (node != head);
            System.out.println("");
        } else {
            System.out.println("Empty List!");
        }
    }

    @Override
    public String toString() {
        String tmp = "";
        Node node = head;
        if (!isEmpty()) {
            tmp += "<- ";
            do {
                if (node.next != head) {
                    tmp += node.value + " <=> ";
                } else {
                    tmp += node.value + " ->";
                }
                node = node.next;
            } while (node != head);
        }
        return tmp;
    }
}
