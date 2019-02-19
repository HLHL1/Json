package com.secondriver.sort.impl;

import com.secondriver.sort.Element;
import com.secondriver.sort.Sorter;

/**
 * 选择排序
 * <p>
 */
public class SelectSorter implements Sorter {
    
    @Override
    public void sort(Element[] elements) {
        int len=elements.length;
        int beg=0,end=len-1;
       while(beg<=end){
            Element ma=elements[beg],mi=elements[beg];
            for(int j=beg;j<=end;j++){
                if(elements[j].compareTo(ma)>0){
                    ma=elements[j];
                }
                if(elements[j].compareTo(mi)<0){
                    mi=elements[j];
                }
            }
            Element tmp=mi;
            mi=elements[beg];
            elements[beg]=tmp;
            tmp=ma;
            ma=elements[end];
            elements[end]=tmp;

            beg++;
            end--;
        }
    }
}
