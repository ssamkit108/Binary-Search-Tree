//This class will used by SearchTree class.
public class BinaryNode
{
    String value;           //data of node
    BinaryNode left;        //reference pointer to root of left subtree
    BinaryNode right;       //reference pointer to root of right subtree
    BinaryNode parent;      //reference pointer to parent of subtree
    int count=0;            //Searched count for particular node
    int depth;              //Depth for particular node

    //Constructor of BinaryNode
    public BinaryNode(String value)
    {
        this.value=value;
        this.left=null;
        this.right=null;
        this.parent=null;
        getNode(this);
    }
    //Getter which return node object
    public BinaryNode getNode(BinaryNode node)
    {
        return node;
    }
}