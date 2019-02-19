package com.secondriver.sort.impl;

import com.secondriver.sort.Element;
import com.secondriver.sort.Sorter;

/**
 * 堆排序
 * <p>
 * Author: secondriver
 * Created: 2018/10/13
 */
public class HeapSorter implements Sorter {


    public void Up(Element[] elements,int length){
        int size=(length-1)/2;
        for(int i=size;i>=0;i--){
            int child=i*2+1;
            if((child+1<=length)&&elements[child].compareTo(elements[child+1])<0){
                child++;
            }
            if(elements[i].compareTo(elements[child])<0){
                Element tmp;
                tmp=elements[i];
                elements[i]=elements[child];
                elements[child]=tmp;
            }
        }
    }
    public void heapSort(Element[] elements){
        for(int i=elements.length-1;i>0;i--){
            Up(elements,i);
            Element tmp;
            tmp=elements[i];
            elements[i]=elements[0];
            elements[0]=tmp;
        }
    }
    @Override
    public void sort(Element[] elements) {

        heapSort(elements);
    }
}
