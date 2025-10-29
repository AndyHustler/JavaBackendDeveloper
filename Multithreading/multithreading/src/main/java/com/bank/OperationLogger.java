package com.bank;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OperationLogger implements PropertyChangeListener {
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        System.out.printf("ОПЕРАЦИЯ: %s; РЕЗУЛЬТАТ ВЫПОЛНЕНИЯ: %s \n", evt.getPropertyName(), evt.getNewValue());
    }

}
