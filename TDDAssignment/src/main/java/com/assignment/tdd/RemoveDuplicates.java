package com.assignment.tdd;

import org.apache.commons.lang.ArrayUtils;



public class RemoveDuplicates {

    public int[] removeDuplicates(int duplicateArray[]) {

        int index = 1;
        while(index < duplicateArray.length) {
            if(duplicateArray[index] == duplicateArray[index-1]) {
                duplicateArray = ArrayUtils.remove(duplicateArray,index);
            } else {
                index++;
            }
        }
        return duplicateArray;
    }
}
