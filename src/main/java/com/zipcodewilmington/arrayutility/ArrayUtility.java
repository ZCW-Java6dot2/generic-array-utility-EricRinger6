package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] array;

    public ArrayUtility(T[] inputArray) {
        this.array = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] merged = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length + arrayToMerge.length);
        Integer count = 0;

        int index = 0;
        for(T t : array){
            merged[index] = t;
            index++;
        }
        for(T t : arrayToMerge){
            merged[index] = t;
            index++;
        }

        for(T t : merged){
            if(t.equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T[] merge = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length + arrayToMerge.length);
        int index = 0;
        for(T t : array){
            merge[index] = t;
            index++;
        }
        for(T t : arrayToMerge){
            merge[index] = t;
            index++;
        }

        int totalCount = 1;
        int count = 0;
        T output = arrayToMerge[0];

        for(int i = 0; i < merge.length - 1; i++){
            count = 0;
            T temp = merge[i];
            for(int x = 1; x < merge.length; x++){
                if(temp == merge[x]){
                    count++;
                }
            }
            if(count > totalCount){
                totalCount = count;
                output = temp;
            }
        }

        return output;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for(T t : array){
            if(t.equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        int count = 0;
        for(T t : array){
            if(!t.equals(valueToRemove)){
                count++;
            }
        }
        
        T[] output = (T[]) Array.newInstance(array.getClass().getComponentType(), count);
        int index = 0;
        for(T t : array){
            if(!t.equals(valueToRemove)){
                output[index] = t;
                index++;
            }
        }
        return output;
    }
}
