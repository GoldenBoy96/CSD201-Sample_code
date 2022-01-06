package list;

public class SLL {

    Node head, tail;

    SLL() {
    }

    boolean isEmpty() {
        return head == null;
    }
    
    void addFirst(int el) {
        Node p = new Node(el);
        if (isEmpty()) {
            head = p;
            tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }
    
    void addLast(int el) {
        Node p = new Node(el);
        if (isEmpty()) {
            head = p;
            tail = p;
        } else {
            Node tmp = tail;
            tmp.next = p;
            tail = tmp.next;
        }
    }
    
    void addPost(int el, int pos) throws Exception {
        Node p = new Node(el);
        if (isEmpty()) {
            head = p;
        } else {
            Node tmp = head;
            int count = 0;
            while (count != pos && tmp.next != null) {
                tmp = tmp.next;
                count++;
            }
            
            if(count != pos) {
                throw new Exception("Index is out of bounds: Index: " + pos + " Size: " + size());
                //addLast(el); //default
                //System.out.println("Can not add!");
            } else {
                p.next = tmp.next;
                tmp.next = p;
            }
        }
    }
    
    void addMany(int[] arr, int arrSize) {
        if (isEmpty()) {            
            for (int i = 0; i < arrSize; i ++) {
                addLast(arr[i]);
            }
        } else {            
            for (int i = 0; i < arrSize; i ++) {
                addLast(arr[i]);
            }
        }
    }
    
    int size() {
        if (isEmpty()) {
            return 0;
        } else {
            int count = 0;
            Node tmp = head;
            while (tmp.next != null) {
                count ++;
                tmp = tmp.next;
            }
            return count + 1;
        }
    }
    
    int indexOf(int value) {
        if (isEmpty()) {
            return -1;
        } else {
            int count = 0;
            Node tmp = head;
            while (tmp.value != value && tmp.next != null) {
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
    
    int get(int index) throws Exception{
        if (isEmpty()) {
            throw new Exception("Index is out of bounds: Index: " + index + " Size: " + size());
        } else {
            Node tmp = head;
            int count = 0;
            while (count != index && tmp.next != null) {
                count++;
                tmp = tmp.next;
            }
            if (count != index) {
                throw new Exception("Index is out of bounds: Index: " + index + " Size: " + size());
            } else {
                return tmp.value;
            }
        }
    }
    
    void removeFirst() {
        if (isEmpty()) {
        } else {
            head = head.next;
        }
    }
    
    void removeLast() {
        if (isEmpty() || head.next == null) {
            removeFirst();
        } else {
            Node tmp = head;
            while (tmp.next.next != null) {
                tmp = tmp.next;
            }
            tmp.next = null;
            tail = tmp;
        }
        
    }
    
    void removeAt(int pos) throws Exception {
        if (isEmpty() || pos == 0 || head.next == null) {
            removeFirst();
        } else {
            Node tmp = head;
            int count = 0;
            while (tmp.next.next != null && count != pos) {
                tmp = tmp.next;
                count ++;
            }
            if (count != pos) {
                throw new Exception("Index is out of bounds: Index: " + pos + " Size: " + size());
                //removeLast(); //default
                //System.out.println("Can't find that position!");
            } else {
                tmp.next = tmp.next.next;
            }
        }
    }
    
    void removeAll() {
        head = null;
    }

    void printAll() {
        Node node = head;
        while (node != null) {
            if (node.next != null) {
                System.out.print(node.value + " -> ");
            } else {
                System.out.print(node.value);
            }

            node = node.next;
        }
        System.out.println("");
    }
    
    @Override
    public String toString() {
        String tmp = "";
        Node node = head;
        while (node != null) {
            if (node.next != null) {
                tmp += node.value + " -> ";
            } else {
                tmp += node.value;
            }
            node = node.next;
        }
        return tmp;
    }
}
