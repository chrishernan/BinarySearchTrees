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

            //if node has 2 child
            else if(node_to_delete.left!=null && node_to_delete.right!=null){
                
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
    //TODO: need a min funciton to find the min node in a subtree

    public Node find(Node root,int value) {
        if(root.key==value || root == null) {
            return root;
        }
        else if (value<root.key){
            return this.find(root.left,value);
        }

        else {
            return this.find(root.right,value);
        }

    }

}
