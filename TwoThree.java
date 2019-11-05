public class TwoThree {
    private Tree root;
    private int size;

    public TwoThree(){
        root = new Tree();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void insert(int value){
        //root is empty
        if(root.keys == 0){
            root.left_value = value;
            root.keys+=1;
            size+=1;
        } else if(root.keys == 1){
            //if root has at least one value
            root.right_value = value;
            root.keys+=1;
            size+=1;

            //maintain ordered tree
            if(root.right_value < root.left_value){
                swap(root);
            }
        } else if(root.keys == 2){
            //if root is full
            int newRootVal;
            Tree newRoot = root.newNode();
            Tree rightNode = root.newNode();

            //case 1: third value inserted is greater than left and right val
            if(root.left_value < value && root.right_value < value){
                newRootVal = root.right_value;
                int temp = value;
                int left = root.left_value;

                newRoot.left_value = newRootVal;
                newRoot.keys+=1;

                rightNode.left_value = temp;
                rightNode.keys +=1;

                root.right_value = 0;
                root.keys = 1;

                newRoot.left_child = root;
                newRoot.right_child = rightNode;
                root = newRoot;
            }

            //case 2: third value inserted is less than left and right val
            if(value < root.left_value && value < root.right_value){
                newRootVal = root.left_value;
                int temp = value;
                int right = root.right_value;

                newRoot.left_value = newRootVal;
                newRoot.keys+=1;

                rightNode.left_value = right;
                rightNode.keys+=1;

                root.right_value = 0;
                root.left_value = value;
                root.keys = 1;

                newRoot.left_child = root;
                newRoot.right_child = rightNode;
                root = newRoot;
            }

            //case 3: third value inserted is between left and right val
            if(value > root.left_value && value < root.right_value){
                newRootVal = value;
                int left = root.left_value;
                int right = root.right_value;

                newRoot.left_value = newRootVal;
                newRoot.keys += 1;

                rightNode.left_value = root.right_value;
                rightNode.keys+=1;

                root.right_value = 0;
                root.keys = 1;

                newRoot.left_child = root;
                newRoot.right_child = rightNode;
                root = newRoot;
            }

            size+=1;
        }
    }

    public void print(){
        print_tree(root);
    }

    private void swap(Tree c){
        int val = c.left_value;
        c.left_value = c.right_value;
        c.right_value = val;
    }

    private void print_tree(Tree c){
        if(c == null){
            return;
        }

        print_tree(c.left_child);
        System.out.print(c.left_value + " ");
        print_tree(c.middle_child);

        if(c.right_value != 0) {
            System.out.print(c.right_value + " ");
        }

        print_tree(c.right_child);
    }

}
