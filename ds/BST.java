package ds;

public class BST {
  
  TreeNode root;

  public TreeNode root() {
    return root;
  }

  public void add(int value) {
    if( root == null ) {
      root = new TreeNode(value);
    } else {
      TreeNode parent = root;  
      TreeNode current = root;

      while(current != null) {
        parent = current;
        if( value > current.data ) {
          current = current.right;
        } else {
          current = current.left;
        }
      }
      
      if(value > parent.data) 
        parent.right = new TreeNode(value);
      else
        parent.left = new TreeNode(value); 
      
    }
     
  }  
    
  public TreeNode search(int value) {
    TreeNode current = root;
    while(current != null) {
      if(current.data == value)
        return current;
      
      if(value > current.data) 
        current = current.right;
      else
        current = current.left;
    } 
    return current;
  }

  private TreeNode min(TreeNode node) {
    while(node.left != null) 
      node = node.left;
    return node;
  }
  
  public TreeNode delete(int value) {
    TreeNode current = root;
    TreeNode parent = root;
    
    while(current != null) {
      if(current.data == value) 
        break;
      
      parent = current;
      if(value > current.data) {
        current = current.right;
      } else {
        current = current.left; 
      }
    }
   
    if(current != null) {
      // only single root node
      if(current == root && current.left == null && current.right == null) {
        root = null;
      } else if( current == root)  {
        //root needs to be deleted
        if(root.left == null) // root with only right child
          root = root.right;
        else if( root.right == null) // root with only left child
          root = root.left;
        else { // root having both children
           // find min in right sub tree
          TreeNode parentr = root.right;
          TreeNode minr = root.right;
          while(minr.left != null) {
            parentr = minr;
            minr = minr.left; 
          }
          
          if(minr == root.right) {
            minr.left = root.left;
            root = minr;
          } else {
            root.data = minr.data;
            parentr.left = minr.right;
            
            // return minr as deleted node;
            minr.data = value;
            current = minr;
          }
        }
      } else if( current.left == null && current.right == null) {
        // leaf node
        if(parent.left == current) 
          parent.left = null;
        else
          parent.right = null;
      } else if( current.left == null ) {
        // non leaf node
        if(parent.left == current) {
          parent.left = current.right;
        } else {
          parent.right = current.right;
        }
      } else if( current.right == null) {
        // non leaf node
        if(parent.left == current)
          parent.left = current.left;
        else
          parent.right = current.left;
      } 
      
    }
   
    return current; 
  }    

}
