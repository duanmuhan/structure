package com.cgs.datastructure.tree;

public class AVLTree<T extends Comparable<T>> {

  private AVLTreeNode<T> root;

  public AVLTree(AVLTreeNode<T> root){
    this.root = root;
  }

  private int height(AVLTreeNode<T> node){
    if (node != null){
      return node.getHeight();
    }
    return 0;
  }

  public int height(){
    return height(root);
  }

  private AVLTreeNode<T> LLRotation(AVLTreeNode<T> k2){
    AVLTreeNode<T> k1;
    k1 = k2.getLeftChild();
    k2.setLeftChild(k1.getRightChild());
    k2.setHeight(Math.max(height(k2.getLeftChild()),height(k2.getRightChild())) + 1);
    k1.setHeight(Math.max(height(k1.getLeftChild()),k2.getHeight()) + 1);
    return k1;
  }

  public AVLTreeNode<T> RRRotation(AVLTreeNode<T> k1){
    AVLTreeNode<T> k2;
    k2 = k1.getRightChild();
    k1.setLeftChild(k2.getRightChild());
    k2.setLeftChild(k1);
    k2.setHeight(Math.max(height(k2.getLeftChild()),height(k2.getRightChild())) + 1);
    k1.setHeight(Math.max(height(k1.getLeftChild()),k2.getHeight()));
    return k2;
  }

  public AVLTreeNode<T> LRRotation(AVLTreeNode<T> k3){
    k3.setLeftChild(RRRotation(k3.getLeftChild()));
    return LLRotation(k3);
  }

  public AVLTreeNode<T> RLRotation(AVLTreeNode<T> k1){
    k1.setRightChild(LLRotation(k1.getRightChild()));
    return RRRotation(k1);
  }

  public void insert(T value){
    AVLTreeNode node = new AVLTreeNode();
    AVLTreeNode currentNode = root;
    node.setValue(value);
    if (currentNode == null){
      root = node;
    }else{
      while (currentNode != null){
        if (currentNode.getValue() == node.getValue()){
          return;
        }else if(value.compareTo((T) currentNode.getValue()) < 0){
          currentNode = currentNode.getLeftChild();
        }else if(value.compareTo((T) currentNode.getRightChild()) < 0){
          currentNode = currentNode.getRightChild();
        }
      }
    }
  }

  public void delete(T value){

  }


  class AVLTreeNode<T extends Comparable<T>>{
    private T value;
    private AVLTreeNode leftChild;
    private AVLTreeNode rightChild;
    private int height;

    public T getValue() {
      return value;
    }

    public void setValue(T value) {
      this.value = value;
    }

    public AVLTreeNode getLeftChild() {
      return leftChild;
    }

    public void setLeftChild(AVLTreeNode leftChild) {
      this.leftChild = leftChild;
    }

    public AVLTreeNode getRightChild() {
      return rightChild;
    }

    public void setRightChild(AVLTreeNode rightChild) {
      this.rightChild = rightChild;
    }

    public int getHeight() {
      return height;
    }

    public void setHeight(int height) {
      this.height = height;
    }
  }
}
