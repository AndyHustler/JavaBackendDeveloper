package com.example;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.StringBuilder;

public class MyStringBuilder {

    private StringBuilder stringBuilder;

    public MyStringBuilder() {
        stringBuilder = new StringBuilder();
    }

    public MyStringBuilder(String str) {
        stringBuilder = new StringBuilder(str);
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public MyStringBuilder append(Object obj) {
        support.firePropertyChange("append", stringBuilder.toString(), stringBuilder.append(obj).toString());
        return this;
    }
}
