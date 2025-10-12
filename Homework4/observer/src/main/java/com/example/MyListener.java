package com.example;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyListener implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.printf("New subject event << %s >>. Old string << %s >>, new string << %s >>", (String) evt.getPropertyName(), (String) evt.getOldValue(), (String) evt.getNewValue());
    }

}
