package dll;

public class DLL <T> {

    Node head;
    Node tail;

    public DLL() {
    }

    boolean isEmpty() {
        return head == null;
    }

    private Node getNode(int pos) throws Exception {
        Node tmp = head;
        int count = 0;
        while (count != pos && tmp.next != null) {
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
            tail = p;
        } else {
            p.next = head;
            head.pre = p;
            head = p;
        }
    }

    public void addLast(T el) {
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

    public void addPos(T el, int pos) throws Exception {
        Node p = new Node(el);
        if (isEmpty()) {
            head = p;
            tail = p;
        } else {
            Node tmp = getNode(pos);
            p.next = tmp.next;
            tmp.next = p;
        }
    }

    public void addMany(T[] arr, int arrSize) {
        if (isEmpty()) {
            for (int i = 0; i < arrSize - 1; i++) {
                addLast(arr[i]);
            }
            addLast(arr[arrSize - 1]);
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
            while (tmp.next != null) {
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
        } else {
            head = head.next;
        }
    }

    public void removeLast() {
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

    public void removeAt(int pos) throws Exception {
        if (isEmpty() || pos == 0 || head.next == null) {
            removeFirst();
        } else {
            Node tmp = head;
            int count = 0;
            while (tmp.next.next != null && count != pos) {
                tmp = tmp.next;
                count++;
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

    public void removeAll() {
        head = null;
        tail = null;
    }

    public void printAll() {
        Node node = head;
        while (node != null) {
            if (node.next != null) {
                System.out.print(node.value + " <=> ");
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
                tmp += node.value + " <=> ";
            } else {
                tmp += node.value;
            }
            node = node.next;
        }
        return tmp;
    }
}
