public class Tree {
    public Tree left_child;
    public int left_value;
    public Tree middle_child;
    public int right_value;
    public Tree right_child;
    public int keys;

    //default constructor for tree class
    public Tree() {
        keys = 0;
        left_child = null;
        middle_child = null;
        right_child = null;
        left_value = 0;
        right_value = 0;
    }

    public Tree newNode() {
        Tree tempNode = new Tree();

        tempNode.keys = 0;
        tempNode.left_child = null;
        tempNode.middle_child = null;
        tempNode.right_child = null;
        tempNode.left_value = 0;
        tempNode.right_value = 0;

        return tempNode;
    }

}
