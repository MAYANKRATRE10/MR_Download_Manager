package org.example.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FileInfo {

    private SimpleStringProperty index = new SimpleStringProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty URL = new SimpleStringProperty();
    private SimpleStringProperty status = new SimpleStringProperty();
    private SimpleStringProperty action = new SimpleStringProperty();
    private SimpleStringProperty path = new SimpleStringProperty();


    public FileInfo(String index, String name, String URL, String status,String action,String path) {
        this.index.set(index);
        this.name.set(name);
        this.URL.set(URL);
        this.status.set(status);
        this.action.set(action);
        this.path.set(path);
    }

    public String getIndex() {
        return index.get();
    }
    public SimpleStringProperty indexProperty() {
        return index;
    }
    public void setIndex(String index) {
        this.index.set(index);
    }


    public String getName() {
        return name.get();
    }
    public SimpleStringProperty nameProperty() {
        return name;
    }
    public void setName(String name) {
        this.name.set(name);
    }



    public String getURL() {
        return URL.get();
    }
    public SimpleStringProperty URLProperty() {
        return URL;
    }
    public void setURL(String URL) {
        this.URL.set(URL);
    }



    public String getStatus() {
        return status.get();
    }
    public SimpleStringProperty statusProperty() {
        return status;
    }
    public void setStatus(String status) {
        this.status.set(status);
    }


    public String getAction() {
        return action.get();
    }
    public SimpleStringProperty actionProperty() {
        return action;
    }
    public void setAction(String action) {
        this.action.set(action);
    }


    public String getPath() {
        return path.get();
    }

    public SimpleStringProperty pathProperty() {
        return path;
    }

    public void setPath(String path) {
        this.path.set(path);
    }


    @Override
    public String toString() {
        return "FileInfo{" +
                "index=" + index +
                ", name=" + name +
                ", URL=" + URL +
                ", status=" + status +
                ", action=" + action +
                ", path=" + path +
                '}';
    }
}
