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

  /*
  * 判断树是否平衡
  * */
  public boolean isBalanced(AVLTreeNode node){
    if (node == null){
      return true;
    }
    int left = depth(node.getLeftChild());
    int right = depth(node.getRightChild());
    return Math.abs(left - right) <=1 && isBalanced(node.getLeftChild()) && isBalanced(node.getRightChild());
  }

  private int depth(AVLTreeNode root){
    if (root == null){
      return 0;
    }
    return Math.max(depth(root.getLeftChild()),depth(root.getRightChild())) + 1;
  }

  public boolean isSameTree(AVLTreeNode node1,AVLTreeNode node2){
    if (node1 == null && node2 == null){
      return true;
    }
    if (node1.getValue() == node2.getValue()){
      return isSameTree(node1.getLeftChild(),node2.getLeftChild()) && isSameTree(node1.getRightChild(),node2.getRightChild());
    }
    return false;
  }

  public boolean SymmetricTree(AVLTreeNode treeNode){
    if (root == null){
      return true;
    }
    return false;
  }

  //树的问题最好往递归的思路上去发展。
  private boolean isSymmetricHelp(AVLTreeNode left,AVLTreeNode right){
    if (left== null || right == null){
      return left== right;
    }
    if (left.getValue() != left.getRightChild()){
      return  false;
    }
    return isSymmetricHelp(left.getLeftChild(),right.getRightChild()) && isSymmetricHelp(left.getLeftChild(),right.getLeftChild());
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
