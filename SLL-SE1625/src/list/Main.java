package list;

import dll.DLL;
import cll.CLL;
import sll.SLL;

public class Main {

    public static void main(String[] args) throws Exception {
        //demoCLL();
        demoDLL();
    }
    
    public static void demoDLL() throws Exception {
        DLL<Integer> d = new DLL<Integer>();
        d.addFirst(1);        
        d.addFirst(2);
        d.addFirst(3);
        d.addLast(4);
        d.addLast(5);

        Integer arr[] = {7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        d.addMany(arr, 10);
        d.addPos(6, 5);
        d.removeFirst();
        d.removeLast();
        //d.removeAt(5);

        //d.removeAt(100); //Cause Exception
        //d.removeAll();
        System.out.println(d.toString());

        //s.get(100);
        System.out.println("Size: " + d.size());
        System.out.println("Index of 5: " + d.indexOf(5));
        System.out.println("Value of index 8: " + d.get(8));

        //System.out.println(s.get(100)); //Cause Exception
    }
    
    public static void demoCLL() throws Exception {
        CLL<Integer> c = new CLL<>();
        c.addFirst(1);        
        c.addFirst(2);
        c.addFirst(3);
        c.addLast(4);
        c.addLast(5);

        Integer arr[] = {7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        c.addMany(arr, 10);
        c.addPos(0, 0);
        
        c.removeFirst();
        c.removeFirst();
        c.removeLast();
        c.removeLast();
        c.removeAt(4);

        //c.removeAt(100); //Cause Exception
        //c.removeAll();
        
        c.rotateClockWise();
        System.out.println(c.toString());
        //s.get(100);
        System.out.println("Size: " + c.size());
        System.out.println("Index of 5: " + c.indexOf(5));
        System.out.println("Value of index 8: " + c.get(8));

        //System.out.println(s.get(100)); //Cause Exception
    }

    public static void demoSLL() throws Exception {
        SLL<Integer> s = new SLL<Integer>();
//        s.addFirst(1);        
//        s.addFirst(2);
//        s.addFirst(3);
//        s.addLast(4);
//        s.addLast(5);

        Integer arr[] = {7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        s.addMany(arr, 10);
        s.addPos(6, 5);
        s.removeFirst();
        s.removeLast();
        //s.removeAt(5);

        //s.removeAt(100); //Cause Exception
        //s.removeAll();
        System.out.println(s.toString());

        //s.get(100);
        System.out.println("Size: " + s.size());
        System.out.println("Index of 5: " + s.indexOf(5));
        System.out.println("Value of index 8: " + s.get(8));

        //System.out.println(s.get(100)); //Cause Exception
    }

}
