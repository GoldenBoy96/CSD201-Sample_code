package list;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        SLL s = new SLL();
        s.addFirst(1);        
        s.addFirst(2);
        s.addFirst(3);
        s.addLast(4);
        s.addLast(5);
        s.addPost(6, 1);
        int arr[] = {7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        s.addMany(arr, 10);
        s.removeFirst();
        s.removeLast();
        s.removeAt(5);
        
        //s.removeAt(100); //Cause Exception
                
        //s.removeAll();
        System.out.println(s.toString());
        //s.get(100);
        System.out.println("Size: " + s.size());
        System.out.println("Index of 5: " + s.indexOf(5));
        System.out.println("Value of index 8: " + s.get(8));
        
        //System.out.println(s.get(100)); //Cause Exception
        
        
        
//        LinkedList<Integer> s1 = new LinkedList<>();
//        s1.add(5);
//        s1.add(7);
//        s1.add(9);
//        System.out.println(s1.toString());
//        System.out.println(s1.get(1));
//        System.out.println(s1.indexOf(7));
//        System.out.println(s1.get(0));
        
    }

}
