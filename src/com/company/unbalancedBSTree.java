package com.company;

/**
 * Created by Christian.Hernandez on 4/24/2017.
 */
public class unbalancedBSTree {
    Node root = null;

    public unbalancedBSTree() {
        ;
    }

    public void insert(Node root,int data) {

        if(root == null) {root = new Node(data);}

        else if(data < root.key){
            this.insert(root.left,data);
        }

        else {
            this.insert(root.right,data);
        }

    }

    //deletes the node with a desired key
    public boolean delete(int key) {
        Node node_to_delete = this.find(root,key);
        if(node_to_delete==null) {
            return false;
        }

        else{
            //if node has 0 children
            if(node_to_delete.left==null && node_to_delete.right==null){
                node_to_delete=null;
                return true;
            }

            //if node has 2 children
            else if(node_to_delete.left!=null && node_to_delete.right!=null){
                node_to_delete = replace_parent_node_with_leftmost_node(node_to_delete);
                return true;
            }

            //if node has 1 children
            else {
                if(node_to_delete.left!= null) {
                    node_to_delete = node_to_delete.left;
                    return true;
                }
                node_to_delete = node_to_delete.right;
                return true;
            }

        }
    }

    //finds the leftmost node of a tree
    public Node find_min(Node root) {
        if(root.left==null) {
            return root;
        }
        else {
            return this.find_min(root.left);
        }
    }

    public Node replace_parent_node_with_leftmost_node(Node node_to_del){
        Node leftmost_node = find_min(node_to_del.right);
        if(leftmost_node.right!=null){
            Node temp_node = leftmost_node;
            leftmost_node = leftmost_node.right;
            return temp_node;
        }
        return leftmost_node;
    }

    //recursively find a node;
    public Node find(Node root, int key){
        if(root.key==key || root == null){
            return root;
        }

        else if(root.key>key){
             return this.find(root.left,key);
        }

        else {
            return this.find(root.right,key);
        }
    }


    //TODO: verification(?) and traversal functions/methods
}
