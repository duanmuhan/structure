package com.cgs.datastructure.algorithm;

public class Sort {

  public static void FastSort(int[] arr){

  }

  public static void insertSort(int[] arr){
    if (arr.length == 0){
      return;
    }
    int index =0;
    int target = 0;
    for (int i=1; i<arr.length; i++){
       index = i;
       target = arr[i];
       while (index>0 && target< arr[index -1]){
         arr[index] = arr[index - 1];
         index --;
       }
       arr[index] = target;
    }
  }

  public static void heapSort(int[] arr){
    for (int i=arr.length -1; i>=1; i--){
      int tmp = arr[0];
       arr[0] = arr[i];
       arr[i] = tmp;
    }
  }

  private void buildMaxHeap(int[] arr){
    if (arr == null || arr.length == 0){
      return;
    }
    int half = arr.length / 2;
    for (int i=half; i>=0; i--){
      maxHeap(arr,0,i);
    }
  }

  private static void maxHeap(int[] arr,int heapSize,int index){
    int left = index * 2 + 1;
    int right = index * 2 + 2;
    int largest = index;
    if (left< heapSize && arr[left]> arr[index]){
      largest = left;
    }
    if (right< heapSize && arr[right] > arr[largest]){
      largest = right;
    }
    if (index != largest){
      int tmp = arr[index];
      arr[index] = arr[largest];
      arr[largest] = tmp;
    }
  }

  public static void bubbleSort(int[] arr){
    for (int i=0; i<arr.length; i++){
      for (int j=arr.length; j>i; j--){
        if (arr[i]>arr[j]){
          int tmp = arr[i];
          arr[i] = arr[j];
          arr[j] = tmp;
        }
      }
    }
  }

  public static void shellSort(int[] arr){
    int increment = 1;
    while (increment <= arr.length /3){
      increment = increment * 3 + 1;
    }
    while (increment > 0){
      int index = 0;
      int target = 0;
      for (int i=1; i<arr.length; i= i + increment){
        index = i;
        target = arr[i];
        while (index > 0 && target > arr[index - increment]){
          arr[index] = arr[index - increment];
          index = index - increment;
        }
      }
      increment = increment / 3;
    }
  }

  public static void selectSort(int[] arr){

    if (arr == null && arr.length == 0){
      return;
    }
    int min = arr[0];
    for (int i=0; i<arr.length; i++){
      for (int j=i;j<arr.length; j++){
        if (min < arr[j]){
          min = arr[j];
        }
      }
      arr[i] = min;
    }
  }

  public static void mergeSort(int[] arr){
    mergeSort(arr,0,arr.length-1);
  }

  private static void doMerge(int[] arr,int low,int mid,int high){
    int[] tmp = new int[high - low + 1];
    int i = low;
    int j = mid + 1;
    int k = 0;
    while (i <= mid && j<= high){
      if (arr[i] < arr[j]){
        tmp[k++] = arr[i++];
      }else {
        tmp[k++] = arr[j++];
      }
    }
    while (i <= mid){
      tmp[k++] = arr[i++];
    }
    while (j <= high){
      tmp[k++] = arr[j++];
    }
    for (int k1=0; k< tmp.length; k1 ++){
      arr[k1 + low] = tmp[k1];
    }
  }

  private static void mergeSort(int[] arr,int low,int high){
    int mid = (low + high)/2;
    if (low < high){
      mergeSort(arr,low,mid);
      mergeSort(arr,mid + 1,high);
      doMerge(arr,low,mid,high);
    }
  }

  public static void bucketSort(int[] arr){

  }
}
