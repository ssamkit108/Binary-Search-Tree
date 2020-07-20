//Here we have used BinaryNode class for a node of tree
//Please refer BinaryNode class in BinaryNode.java file

public class SearchTree {

    public BinaryNode root;    //reference pointer to Root of Binary Search Tree
    boolean status;            //temporary variable for add method
    BinaryNode temp = null;    //temporary reference for change method
    String print = "";         //String variable for PrintTree method

    //Constructor to initialise tree with null root node
    public SearchTree() {
        root = null;
    }

    //set depth of BinaryNode using root node
    //Traverse whole tree suing recursive method
    private void set_depth(BinaryNode node, int level) {
        if (node != null) {
            set_depth(node.left, level + 1);
            node.depth = level;
            set_depth(node.right, level + 1);
        }
    }

    //Add passed String value at right position
    //This method mainly calls add_element()
    //It return true if value added successfully else it will return false
    public boolean add(String value) {
		//Input Validation
        if(value == null){
            return false;
        }
        else if(value.equalsIgnoreCase("null") || value.equalsIgnoreCase("empty")){
            return false;
        }
        else if(value.isEmpty()){
            return false;
        }else if((!value.matches(".*\\S.*"))){
            return false;
        }
        else {
            try {
                root = add_element(root, value);
                set_depth(root, 1);
                return status;
            }catch (Exception e){
                return false;
            }
        }
    }


    // A recursive function to insert a new value in Binary Search Tree
    //return BinaryNode refer to root
    private BinaryNode add_element(BinaryNode current, String value) {

        //Base condition for recursive method addRecursive
        //If pointing current pointer is empty return new node
        if (current == null ) {
            status = true;
            return new BinaryNode(value);
        }

        //Value is already in tree return false
        if (value.equalsIgnoreCase(current.value)) {
            status = false;
        }

        //otherwise , recur down the tree
        //find right place to add node in BST
        if (value.compareToIgnoreCase(current.value) < 0) {

            BinaryNode left_child = add_element(current.left, value);
            current.left = left_child;

            // Set parent of root of left subtree
            left_child.parent = current;
        } else if (value.compareToIgnoreCase(current.value) > 0) {

            BinaryNode right_child = add_element(current.right, value);
            current.right = right_child;

            // Set parent of root of right subtree
            right_child.parent = current;
        }
        return current;
    }

    //It will find the passed string "value"
    //return depth of the found node
    //return 0 if node not found
    public int find(String value) {
		//Input Validation
        if(value == null){
            return 0;
        }
        else if(value.equalsIgnoreCase("null") || value.equalsIgnoreCase("empty")){
            return 0;
        }
        else if(value.isEmpty()){
            return 0;
        }else if((!value.matches(".*\\S.*"))) {
            return 0;
        }
        else {
            try {
                BinaryNode current = root;
                BinaryNode parent = root;

                // root from the class
                // Walk a path from the root to where the node should be
                //This will point to node which contains searched value
                while ((current != null) && !(current.value.equalsIgnoreCase(value))) {
                    parent = current;

                    if (value.compareToIgnoreCase(current.value) < 0) {
                        current = current.left;
                    } else {
                        current = current.right;
                    }
                }

                //Checks element is there or not
                if (current == null) {
                    //System.out.println("Not found");
                    return 0;
                }

                //Element found and return depth of node
                else {
                    current.count++;

                    //change the node if searched more than it's parent
                    if (current.count > parent.count) {
                        //call the method to change node of tree
                        change(current, parent);
                        set_depth(root, 1);
                    }
                    return current.depth;
                }
            }catch (Exception e){
                return 0;
            }
        }
    }

    //This method will change the node with parent node
    private void change(BinaryNode current, BinaryNode parent) {

        //If element is left side parent node
        //do right rotation
        if ((current.value).compareToIgnoreCase(parent.value) < 0) {
            //temporary reference for change method
            BinaryNode temp = null;

            //storing right subtree of found node in temp node
            if (current.right != null) {
                temp = current.right;
                current.right = null;
            }

            //if parent is not root node
            if (parent.parent != null) {
                if(parent.value.compareToIgnoreCase(parent.parent.value)>0) {
                    parent.parent.right = current;
                }
                else {
                    parent.parent.left = current;
                }
                current.parent = parent.parent;
            }

            //if parent is root node
            if (parent.parent == null) {
                root = current;
                current.parent = null;
            }
            parent.left = null;
            current.right = parent;
            parent.parent = current;
            if (temp != null) {
                temp.parent = parent;
                parent.left = temp;
            }
        }

        //If element is right side of parent node
        //do left rotation
        else {
            BinaryNode temp = null;

            //storing left subtree of found node in temp node
            if (current.left != null) {
                temp = current.left;
                current.left = null;
            }

            //if parent is not root node
            if (parent.parent != null) {
                if(parent.value.compareToIgnoreCase(parent.parent.value)>0) {
                    parent.parent.right = current;
                }
                else {
                    parent.parent.left = current;
                }
                current.parent = parent.parent;
            }

            //if parent is root node
            if (parent.parent == null) {
                root = current;
                current.parent = null;
            }
            parent.right = null;
            current.left = parent;
            parent.parent = current;
            if (temp != null) {
                temp.parent = parent;
                parent.right = temp;
            }
        }
    }

    // This method mainly calls inorder()
    //It will return string of binary search tree
    public String printTree() {
        try {
            print = "";
            String print = inorder(root);

            //If tree dose not contain any element then it will return null string
            if (print.length() == 0) {
                return null;
            }
            return print;
        }catch (Exception e){
            return null;
        }
    }

    //Recursive method to generate print string
    //It will traverse tree in sorted order s
    private String inorder(BinaryNode r) {
        if (r != null) {
            inorder(r.left);
            print = print + (r.value + " " + r.depth + "\n");
            inorder(r.right);
            return print;
        }
        else {
            return print;
        }
    }


    //It will call the clear() method with passing root pointer
    public void reset() {
        clear(root);
    }

    //This method will set all counter to 0.
    private void clear(BinaryNode r) {
        if (r != null) {
            clear(r.left);
            r.count = 0;
            clear(r.right);
        }

    }

}