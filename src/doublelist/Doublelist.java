package doublelist;

import java.util.Scanner;

public class Doublelist {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        Node root = new Node("A");
        
        Node n1 = new Node("B");
        root.setRight(n1);
        
        Node n3 = new Node("D");
        Node n2 = new Node("C", n1, n3);
        n1.setRight(n2);
        
        int op = 0;
        
        while(op != 4){        
            System.out.println("1: Show");
            System.out.println("2: Add");
            System.out.println("3: Remove");
            System.out.println("4: Exit");
            op = sc.nextInt();
            System.out.println("");

            switch(op){
                case 1:
                    showList(root);
                    break;
                case 2:
                    if (addNode(sc, root))
                        root = root.getLeft();
                    break;
                case 3:
                    switch(removeNode(sc, root)){
                        case 1:
                            root = root.getRight();
                            System.out.println("Done\n");
                            break;
                        case 0:
                            System.out.println("Node not found\n");
                            break;
                    }
                    break;
            }
        }
        
    }
    
    private static int removeNode(Scanner sc, Node n){
        System.out.print("Enter node's data to find: ");
        sc.nextLine();
        Node target = search(sc.nextLine(), n);
        if (target != null) {
            if (target.getLeft() == null) {
                target.getRight().setNullLeft();
                return 1;
            }
            if (target.getRight() == null) {
                target.getLeft().setNullRight();
                return 2;
            }
            else{
                target.getLeft().setRight(target.getRight());
                return 3;
            }
   
        }
        return 0;
    }
    
    private static boolean addNode(Scanner sc, Node n){
        System.out.print("Enter command: ");
        sc.nextLine();
        String c = sc.nextLine();
        String[] values;
        Node target;
        int c1 = 0;
        if (c.contains("<-")){
            c1 = 1;
            values = c.split("<-");
            target = search(values[1], n);
            Node temp = new Node(values[0]);
            try{
                target.getLeft().setRight(temp);
                target.setLeft(temp);
            }catch(NullPointerException ex){
                target.setLeft(temp);
                return true;
            }
        }
        if (c.contains("->")){
            c1 = 2;
            values = c.split("->");
            target = search(values[0], n);
            Node temp = new Node(values[1]);
            try{
                target.getRight().setLeft(temp);
                target.setRight(temp);
            }catch(NullPointerException ex){
                target.setRight(temp);
            }
        }
        if (c.contains("<-") && c.contains("->") || c1 == 0)
            System.out.println("Invalid command.\n");
        return false;
    }
    
    private static Node search(String q, Node n){
        while(n != null){
            if (n.getData().equals(q))
                return n;
            else
                n = n.getRight();
        }
        return null;
    }
    
    private static void showList(Node n){
        while(n != null){
            Node l = n.getLeft(), r = n.getRight();
            if(l != null)
                System.out.print(l.getData());
            System.out.print(" -> " + n.getData() + " -> ");
            if (r != null)
                System.out.print(r.getData());
            System.out.println("");
            n = n.getRight();
        }
        System.out.println("");
    }
    
}
