package com.cgs.datastructure.list;

import com.cgs.datastructure.list.node.ListNode;

public class MyList {

  private ListNode head;
  private ListNode current;

  public MyList(){
    this.head = null;
  }

  public void addFirstNode(ListNode node){
    node.setNext(head);
    head = node;
  }

  public ListNode removeFirstNode(ListNode node){
    ListNode tempNode = head;
    head = tempNode.getNext();
    return tempNode;
  }

  public void reverse(){
    ListNode current = head.getNext();
    ListNode prev = head;
    ListNode post = head.getNext().getNext();
    while (current != null){
      current.setNext(prev);
      prev = current;
      current = post;
      post = post.getNext();
    }
    head = current;
  }

  public ListNode getMiddle(){
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null){
      fast = fast.getNext().getNext();
      slow = slow.getNext();
    }
    return slow;
  }

  public void insertNodeByIndex(int index){
    int i=0;
    while (i <= index){

    }
  }

  public int getLength(){
    ListNode index = head;
    if (head == null){
      return 0;
    }
    int length = 1;
    while (index.getNext() != null){
      index = index.getNext();
      length ++;
    }
    return length;
  }

}
