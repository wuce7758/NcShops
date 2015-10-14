package com.ncshop.domain;

import java.util.ArrayList;

public class OrderItemArr {
	private Boolean next=false;  
    private  int error;  
    private ArrayList<TempOrder> array = new ArrayList<TempOrder>();  
    public Boolean getNext() {  
        return next;  
    }  
    public void setNext(Boolean next) {  
        this.next = next;  
    }  
    public int getError() {  
        return error;  
    }  
    public void setError(int error) {  
        this.error = error;  
    }  
    public ArrayList<TempOrder> getArray() {  
        return array;  
    }  
    public void setArray(ArrayList<TempOrder> array) {  
        this.array = array;  
    }  

}
