package com.cgs.datastructure.list.node;

public class ListNode{

  private ListNode next;
  private int data;

  public void display(){
    System.out.println(data);
  }

  public ListNode getNext() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }
}
