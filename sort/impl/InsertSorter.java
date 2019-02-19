package com.secondriver.sort.impl;

import com.secondriver.sort.Element;
import com.secondriver.sort.Sorter;

/**
 * 简单插入排序
 * <p>
 */
public class InsertSorter implements Sorter {
    
    @Override
    public void sort(Element[] elements) {

        for(int i=1;i<elements.length;i++){
            Element tmp=elements[i];
            int j=0;
            for(j=i-1;j>=0;j--){
                if(tmp.compareTo(elements[j])<0){
                    elements[j+1]=elements[j];
                }else{
                    break;
                }
            }
            elements[j+1]=tmp;
        }
    }
}
