public class TwoThreeTree {

    public static void main(String[] args){
        System.out.println("Hello world");

        int size;
        TwoThree tree = new TwoThree();

        tree.insert(9);
        tree.insert(15);
        tree.insert(4);

        size = tree.getSize();
        System.out.println("Size: " + size);

        tree.print();
    }

}
