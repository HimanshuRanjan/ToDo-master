package com.branwenevans.todo;

public class ListItem {

    private String label;

    private boolean done;
    private String label1;

    public ListItem(String label,String label1) {
        this.label = label;
        this.label1 = label1;
    }

    public ListItem(String label,String label1, boolean done) {
        this.label = label;
        this.done = done;
        this.label1 = label1;
    }

    public String getLabel() {
        return label;
    }
    public String getLabel1() {
        return label1;
    }

    public boolean isDone() {
        return done;
    }

    public void done() {
        this.done = true;
    }
}
