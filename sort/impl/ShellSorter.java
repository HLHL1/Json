package com.secondriver.sort.impl;

import com.secondriver.sort.Element;
import com.secondriver.sort.Sorter;

/**
 * 希尔排序
 * <p>
 */
public class ShellSorter implements Sorter {
    
    @Override
    public void sort(Element[] elements) {
        int len=elements.length;
        int grep=len;
        while(grep>1){
            grep=grep/3+1;
            for(int i=grep;i<len;i+=grep){
               Element tmp=elements[i];
               int j=0;
                for(j=i-grep;j>=0;j-=grep){
                    if(tmp.compareTo(elements[j])<0){
                        elements[j+grep]=elements[j];
                    }else{
                        break;
                    }
                }
                elements[j+grep]=tmp;
            }
        }
    }
}
