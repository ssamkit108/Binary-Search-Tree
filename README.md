## Note
>This is a course assignment for the CSCI3901. I have implemented binary search tree with the mechanism to access the frequency searched item quickly.
Moreover, Testcases for the sudoku are mentioned in the Test case pdf file.

# Description

This program is mainly implemented unbalanced Binary Search Tree. But, we have implemented searching method slightly different to make searching more efficient. We store count for an item that how many times it is searched. If that item is searched more than its parent, then we move that item up one level in a tree. Following is the general approach used and a high-level overview of classes in the program:

**Class BinaryNode** : BinaryNode.java file contains BinaryNode class. which is consist of **2 methods** for creating Node for Binary Search Tree. The BinaryNode has mainly **four** fields named **value** which stores data of node and **left, right** and **parent** are links that set up the recursion, since each of them in a reference to the subtree. Moreover, two fields named **counter** and **depth**. The counter is used to store the frequency of search. Depth is a depth of item in the tree.

- **BinaryNode (String value):** This is a constructor that will initialize an object of BinaryNode class with passed value and null reference to other fields.
- **getNode(BinaryNode node):** This method will return the object of the BinaryNode class.

**Class SearchTree:** SearchTree.java file contains SearchTree class. This consists of **10 methods** for various types of processing Binary Search Tree. This class is responsible for inserting a new item into a tree, find an item in the tree, reset the counter of the item and print the tree. All the methods are explained in detail further.

# Files and external data

- There are two java files for this problem.
  - First java file named &quot; **BinaryNode.java**&quot;, which contains BinaryNode class with 2 methods. It has basically the structure of a node in the tree.
  - Second java file named &quot; **SearchTree.java**&quot;, which contains SearchTree class with 10 methods.
- There are no database tables related to this program implementation.

# Data Structure Used

- In this assignment, I have not used any collection framework data structure directly. But I have used the concept of **LinkedList** where I have data with a three-pointer parameter. one pointer named &quot;left&quot; will have a reference of left subtree, &quot;right&quot; will have reference to right subtree and &quot;parent&quot; will have reference to the parent node of that particular tree.

# Key algorithms and design elements:

The general approach to the solution is as follows:

- SearchTree:
  - This is a constructor that initializes the object of SearchTree class and give reference to root as null.
- Add:
  - This method accepts the value of the node as a string. And pass that value to the recursive method named add\_element(). That method will return the tree having reference to the root node.
  - After inserting the item, we call the set\_depth() method which will set the depth of all items in tree in-depth variable of BinaryNode.
  - This method will return true if an item is added successfully.
  - If the empty string is passed to this method or an item that is already present in the tree, then it will return false.
- Add_element:
  - This is a recursive method.
  - A new item is always inserted at a leaf. We start searching a key from root until we hit a leaf node. Once a leaf node is found, the new node is added as a child of the leaf node.
  - We Start from the root.
  - Compare the inserting element with root, if less than root, then recurse for left, else recurse for right.
  - After reaching the end, just insert that node at left (if less than current) else right.
  - This will update status field value to true or false.
- Find:
  - This method takes a string key as input. Search &quot;Key&quot; in a tree.
  - We start from the root.
  - Compare searched key with root, if less than root, then go to left, else go to the right.
  - If the key is not found, then we return 0.
  - If key found, then we increment the search count of that particular node and check whether the searched count of the parent node is less than current or not.
  - If the count of the parent node is less than the current node, then we call the change() method.
  - That will interchange the position of the node and move the current node one level up.
  - If the key is found, then it will return the depth of the item.

- Change:
  - This method takes two BinaryNode references to current and parent node.
  - Here we simply use the concept of rotation. If the value of the current node is less than the parent node then we need to rotate our subtree to the right from the parent node, else we need to rotate our subtree left from a parent.
  - At the time of the right rotation, we make the current node as a root node and make the parent node a right child of the current node. If there is the right child of the current node then we attach that on the left of the parent node.
  - At the time of left rotation, we do exactly vice versa of the right rotation.
  - After doing changing, we call the set\_depth() method, which updates the depth of each node.
- printTree:
  - This method will return the print string.
  - In this method, we call inorder() method which will generate string print.
  - If there is an empty tree, then this method will return a null string.
- Inorder:
  - This is a recursive method.
  - This method has passed the root node reference in the argument.
  - This will follow inorder traversal method of a binary search tree.
  - Where we first print left node, root node and then right node.
  - This will contact the string with node value and its depth and return that string to the print tree method.
- Reset:
  - This method will call the clear method.
  - It will set the count of all nodes to 0.
- Clear:
  - This is a recursive method.
  - This method has a reference to the root node as an argument.
  - Here we will traverse the whole tree started from the root and set the depth of all BinaryNode to 0.

# Assumptions

- String comparison is not case sensitive.
- New values are always added to the bottom of a tree.

# Limitations

- There must be no duplicate nodes.
- The left and right subtree each must also be a binary search tree.
- Implemented Binary Search Tree is unbalanced.
