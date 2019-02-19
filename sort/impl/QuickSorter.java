package com.secondriver.sort.impl;

import com.secondriver.sort.Element;
import com.secondriver.sort.Sorter;

/**
 * 快速排序
 *
 * <p>
 */
public class QuickSorter implements Sorter {

    //方法一：左右指针法
//    private void qsort(Element[] elements,int left,int right){
//        if(left>=right){
//            return ;
//        }
//        int beg=left,end=right;
//        Element key=elements[beg];
//        while(beg<end){
//            while(beg<end&&elements[end].compareTo(key)>=0){
//                end--;
//            }
//            while(beg<end&&elements[beg].compareTo(key)<=0){
//                beg++;
//            }
//            if(beg<end) {
//                Element tmp = elements[end];
//                elements[end] = elements[beg];
//                elements[beg] = tmp;
//            }
//        }
//        Element tmp = elements[end];
//        elements[end] = elements[left];
//        elements[left] = tmp;
//        qsort(elements,left,beg-1);
//        qsort(elements,end+1,right);
//    }

    //方法二：挖坑法
//    private void qsort(Element[] elements,int left,int right){
//        if(left>=right){
//            return ;
//        }
//        int beg=left,end=right;
//        Element tmp=elements[beg];
//        while(beg<end){
//            while(beg<end&&elements[end].compareTo(tmp)>0){
//                end--;
//            }
//            elements[beg]=elements[end];
//            while(beg<end&&elements[beg].compareTo(tmp)<=0){
//                beg++;
//            }
//            elements[end]=elements[beg];
//        }
//        elements[beg]=tmp;
//        qsort(elements,left,beg-1);
//        qsort(elements,end+1,right);
//    }


    //方法三：前后指针法
    //key值不可以是第一个
    private void qsort(Element[] elements,int left,int right){

        if(left>=right){
            return ;
        }
        int cur=left,prev=left-1;
        Element key=elements[right];
        while(cur<=right){
            if(elements[cur].compareTo(key)>0){
                cur++;
            }else{
                if(elements[cur].compareTo(elements[++prev])==0){
                    cur++;
                }else{
                    Element tmp=elements[cur];
                    elements[cur]=elements[prev];
                    elements[prev]=tmp;
                }
            }
        }
        qsort(elements,left,prev-1);
        qsort(elements,prev+1,right);
    }
    @Override
    public void sort(Element[] elements) {

        qsort(elements,0,elements.length-1);

    }
}
