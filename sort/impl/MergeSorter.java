package com.secondriver.sort.impl;

import com.secondriver.sort.Element;
import com.secondriver.sort.Sorter;

/**
 * 归并排序
 * <p>
 * Author: secondriver
 * Created: 2018/10/13
 */
public class MergeSorter implements Sorter {
    public void mergeSort(Element[] elements,int left,int right){

        if(left>=right){
            return ;
        }
        int mid=(right-left)/2;
        mergeSort(elements,left,left+mid);
        mergeSort(elements,left+mid+1,right);

        int beg1=left,end1=mid+left;
        int beg2=end1+1,end2=right;
        Element<Integer>[] tmp=new Element[right+1-left];
        int index=0;
        while(beg1<=end1&&beg2<=end2){
            if(elements[beg1].compareTo(elements[beg2])<=0){
                tmp[index++]=elements[beg1];
                beg1++;
            }else{
                tmp[index++]=elements[beg2];
                beg2++;
            }
        }
        while(beg1<=end1||beg2<=end2){
            while(beg1<=end1){
                tmp[index++]=elements[beg1++];
            }
            while(beg2<=end2){
                tmp[index++]=elements[beg2++];
            }
        }

        index=0;
        for(int i=left;i<=right;i++){
            elements[i]=tmp[index++];
        }

    }
    @Override
    public void sort(Element[] elements) {

        mergeSort(elements,0,elements.length-1);
    }
}
