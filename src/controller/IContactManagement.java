package controller;

import model.Contact;

import java.util.List;

public interface IContactManagement<T> {
    void showAll();

    void addNew(Contact contact);

    void updateById(String id, Contact contact);

    void removeById(String id);

    int findById(String id);
    void readFile(String path);
    void writeFile(String path);
}

