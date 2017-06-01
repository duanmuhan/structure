package com.cgs.datastructure.tree.node;

public class RedBlackTreeNode {

  private Color color;
  private RedBlackTreeNode leftChild;
  private RedBlackTreeNode rightChild;
  private int value;

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public RedBlackTreeNode getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(RedBlackTreeNode leftChild) {
    this.leftChild = leftChild;
  }

  public RedBlackTreeNode getRightChild() {
    return rightChild;
  }

  public void setRightChild(RedBlackTreeNode rightChild) {
    this.rightChild = rightChild;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  enum Color{
    RED,BLACK
  }
}
