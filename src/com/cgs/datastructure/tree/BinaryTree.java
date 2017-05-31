package com.cgs.datastructure.tree;

import com.cgs.datastructure.tree.node.BinaryTreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class BinaryTree {

  private BinaryTreeNode root;
  private Queue<BinaryTreeNode> nodeQueue;

  public BinaryTree(BinaryTreeNode root){
    this.root = root;
    this.nodeQueue = new ArrayBlockingQueue<BinaryTreeNode>(100);
  }

  public BinaryTreeNode getRoot() {
    return root;
  }

  public void inOrderTraversal(BinaryTreeNode node){
      if (node == null){
        return;
      }
      inOrderTraversal(node.getLeftChild());
      System.out.println(node.getValue());
      inOrderTraversal(node.getRightChild());
  }

  public void beforeOrderTraversal(BinaryTreeNode node){
    if (node == null){
      return;
    }
    System.out.println(node.getValue());
    beforeOrderTraversal(node.getLeftChild());
    beforeOrderTraversal(node.getRightChild());
  }

  public void afterOrderTraversal(BinaryTreeNode node){
    if (node == null){
      return;
    }
    afterOrderTraversal(node.getLeftChild());
    afterOrderTraversal(node.getRightChild());
    System.out.println(node.getValue());
  }

  public void inOrderTraversalWithStack(BinaryTreeNode node){
    if (node == null){
      return;
    }
    Stack<BinaryTreeNode> stack = new Stack<>();
    stack.push(node);
    while (!stack.isEmpty()){
      if (node.getLeftChild() != null){
        node = node.getLeftChild();
        stack.push(node);
      }else {
        node = stack.pop();
        System.out.println(node.getValue());
        if (node.getRightChild() != null){
          stack.push(node);
        }
      }
    }
  }

  public void beforeOrderTraversalWithStack(BinaryTreeNode node){
    if (node == null){
      return;
    }
    Stack<BinaryTreeNode> stack = new Stack<>();
    stack.push(node);
    while (!stack.isEmpty()){
      BinaryTreeNode tmp = stack.pop();
      System.out.println(tmp.getValue());
      if (tmp.getLeftChild() != null){
        stack.push(tmp.getLeftChild());
      }
      if (tmp.getRightChild() != null){
        stack.push(tmp.getRightChild());
      }
    }
  }

  public void afterOrderTraversalWithStack(BinaryTreeNode node){
    if (node == null){
      return;
    }
    Stack<BinaryTreeNode> stack = new Stack<>();
    Map<BinaryTreeNode,Boolean> traceMap = new HashMap<>();
    stack.push(node);
    while (!stack.isEmpty()){
      BinaryTreeNode temp = stack.peek();
      if (node.getLeftChild() != null && !traceMap.containsKey(node)){
        temp = temp.getLeftChild();
        while (temp != null){
          if (traceMap.containsKey(temp)){
            break;
          }else {
            stack.push(temp);
          }
          temp = temp.getLeftChild();
        }
        continue;
      }
      if (temp.getRightChild() != null && !traceMap.containsKey(temp.getRightChild())){
        stack.push(temp.getRightChild());
        continue;
      }
      BinaryTreeNode popNode = stack.pop();
      traceMap.put(popNode,true);
      System.out.println(popNode.getValue());
    }
  }

  public void levelTraversal(){
    if (root != null){
      nodeQueue.add(root);
      while (nodeQueue.size() != 0){
        BinaryTreeNode node = nodeQueue.poll();
        System.out.println(node.getValue());
        nodeQueue.add(node.getLeftChild());
        nodeQueue.add(node.getRightChild());
      }
    }
  }

  public void addNode(BinaryTreeNode binaryTreeNode){
    if (binaryTreeNode != null){
      if (root == null){
        root = binaryTreeNode;
      }else {
        nodeQueue.add(root);
        while (nodeQueue.size() != 0){
          BinaryTreeNode node = nodeQueue.poll();
          if (node.getLeftChild() == null){
            node.setLeftChild(binaryTreeNode);
            return;
          }else if (node.getRightChild() == null){
            node.setRightChild(binaryTreeNode);
            return;
          }else{
            nodeQueue.add(node.getLeftChild());
            nodeQueue.add(node.getRightChild());
          }
        }
      }
    }
  }

  public int getHeight(){
    return  getHeight(root);
  }

  private int getHeight(BinaryTreeNode node){
    if (node == null){
      return 0;
    }
    return 1 + Math.max(getHeight(node.getLeftChild()),getHeight(node.getRightChild()));
  }

  public static void main(String[] args) {
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>(1);
    BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
    BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
    BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(4);

    BinaryTree tree = new BinaryTree(node);
    tree.addNode(node1);
    tree.addNode(node2);
    tree.addNode(node3);
    tree.inOrderTraversal(tree.getRoot());
  }
}
