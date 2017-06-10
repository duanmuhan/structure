package com.cgs.datastructure.tree;

import com.cgs.datastructure.list.node.ListNode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solutions {

  //时间复杂度不符合要求
  public int[] twoSum(int[] nums, int target) {
    Map<String,Integer> map = new HashMap<String,Integer>();
    for(int i=0; i<nums.length; i++){
      for(int j=1; j<nums.length; j++){
        if (i != j){
          String key = i + "_" + j;
          int value = nums[i] + nums[j];
          map.put(key,value);
        }
      }
    }
    for(String key : map.keySet()){
      if(target == map.get(key)){
        String[] indexs = key.split("_");
        return new int[]{Integer.valueOf(indexs[0]),Integer.valueOf(indexs[1])};
      }
    }
    return null;
  }

  //计算数组哪两个元素和为特定值
  public int[] twoSumFast(int[] nums, int target){
    for (int i=0; i<nums.length; i++){
      int theOther = target - nums[i];
      for (int j=i+1; j<nums.length; j++){
        if (nums[j] == theOther && j!= i){
          return new int[]{i,j};
        }
      }
    }
    return null;
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int sum = l1.getData() + l2.getData();
    ListNode result = new ListNode();
    result.setData(sum);
    return result;
  }

  //时间复杂度不符合要求，去他大爷的。
  public int lengthOfLongestSubstring(String s) {
    int longest = 0;
    List<Character> charset = new ArrayList<>();
    for (int i=0; i<s.length(); i++){
      if (!charset.contains(s.charAt(i))){
        charset.add(s.charAt(i));
        if (longest < charset.size()){
          longest = charset.size();
        }
      }else {
        if (longest < charset.size()){
          longest = charset.size();
        }
        charset = charset.subList(charset.indexOf(s.charAt(i)) + 1,charset.size());
        charset.add(s.charAt(i));
      }
    }
    return longest;
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double result = 0;
    int[] merge = new int[nums1.length + nums2.length];
    int index = 0;
    int indexOfNum1 = 0;
    int indexOfNum2 = 0;
    while (index<merge.length){
      if ((indexOfNum1 == nums1.length)&&(indexOfNum2 < nums2.length)){
        for (int i = indexOfNum2; i<nums2.length; i++){
          merge[index] = nums2[i];
          index ++;
        }
        break;
      }
      if ((indexOfNum2 == nums2.length)&&(indexOfNum1 < nums1.length)){
        for (int i= indexOfNum1; i<nums1.length; i++){
          merge[index] = nums1[i];
          index ++;
        }
        break;
      }
      if (nums1[indexOfNum1] < nums2[indexOfNum2]) {
        merge[index] = nums1[indexOfNum1];
        indexOfNum1++;
      }else if (nums1[indexOfNum1] >= nums2[indexOfNum2]){
        merge[index] = nums2[indexOfNum2];
        indexOfNum2 ++;
      }
      index++;
    }
    if ((nums1.length + nums2.length)%2 == 0){
      result = merge[merge.length/2 -1] + merge[merge.length/2];
      result = result /2;
    }

    if ((merge.length % 2) == 1){
      result = merge[merge.length/2];
    }

    return result;
  }

  public String longestPalindrome(String s) {
    StringBuilder sb = new StringBuilder();
    int length = 0;
    Stack<Character> characterStack = new Stack<>();
    Stack<Character> resultStack = new Stack<>();
    for (int i=0; i<s.length(); i++){
      for (int j=i; j<s.length(); j++){
        characterStack.push(s.charAt(i));
        if (characterStack.peek().equals(s.charAt(j))){
          int index = j;
          int tmpLength = 0;
          while (!characterStack.isEmpty()){
            Character top = characterStack.pop();
            if (top.equals(s.charAt(index))){
              tmpLength = tmpLength + 1;
              index = index + 1;
              resultStack.push(top);
              if (tmpLength>length){
                length = tmpLength;
              }
            }else {
              while (!resultStack.isEmpty()){
                sb.append(resultStack.peek());
                characterStack.push(resultStack.pop());
              }
              sb.append(sb.reverse());
              break;
            }
          }
        }else {
          characterStack.push(s.charAt(j));
        }
        characterStack.clear();
      }
    }
    return sb.toString();
  }

  //大整数出问题了。。
  public int reverse(long num){
    String s = String.valueOf(num);
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    int index = 0;
    int length;
    if (s.charAt(0) == '-'){
       index = 1;
      while (index<s.length()){
        stack.push(s.charAt(index));
        index++;
      }
      sb.append(s.charAt(0));
      while (!stack.isEmpty()){
        sb.append(stack.pop());
      }
    }else {
      length = s.length();
      while (index <length){
        stack.push(s.charAt(index));
        index++;
      }
      while (!stack.isEmpty()){
        sb.append(stack.pop());
      }
    }
    return new BigDecimal(sb.toString()).toBigInteger().intValue();
  }

  //去除重复的整数
  public  int removeDuplicates(int[] nums){
    int last = nums.length -1;
    int i=last;
    while (i>=1){
      if (nums[i-1] == nums[i]){
        for (int j= i-1; j<last-1; j++){
          nums[j]= nums[j+1];
        }
        last--;
      }
      i--;
    }
    return last + 1;
  }

  public int maxSubArray(int[] A) {
    int max = Integer.MIN_VALUE, sum = 0;
    for (int i = 0; i < A.length; i++) {
      if (sum < 0)
        sum = A[i];
      else
        sum += A[i];
      if (sum > max)
        max = sum;
    }
    return max;
  }

  public static void main(String[] args) {
    Solutions solutions = new Solutions();
    int[] nums =new int[]{3,2,4};
    //int[] result = solutions.twoSumFast(nums,6);
    //int length = solutions.lengthOfLongestSubstring("abcabcbb");
    int[] nums1 = {0,1,1,2,2,2,2,4,3,3};
    int[] nums2 = {2};
    //double result = solutions.findMedianSortedArrays(nums1,nums2);
    //solutions.longestPalindrome("babad");
    //System.out.println(result);
    int reverse = solutions.removeDuplicates(nums1);
    System.out.println(reverse);
  }
}
