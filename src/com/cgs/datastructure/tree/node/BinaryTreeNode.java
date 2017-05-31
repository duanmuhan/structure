package com.cgs.datastructure.tree.node;

public class BinaryTreeNode<T extends Comparable<T>> {

  private BinaryTreeNode leftChild;
  private BinaryTreeNode rightChild;
  private T value;

  public BinaryTreeNode(T value){
    this.value = value;
  }

  public BinaryTreeNode getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(BinaryTreeNode leftChild) {
    this.leftChild = leftChild;
  }

  public BinaryTreeNode getRightChild() {
    return rightChild;
  }

  public void setRightChild(BinaryTreeNode rightChild) {
    this.rightChild = rightChild;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}
