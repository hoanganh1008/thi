package controller;

import jdk.internal.util.xml.impl.Input;
import model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactManagement implements IContactManagement {
    List<Contact> contactList = new ArrayList<>();

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public ContactManagement() {
        contactList.add(new Contact("012","family","bố","nam","k biết","1/1/1000",""));
        contactList.add(new Contact("013","family","mẹ","nữ","k biết","12/11/1000",""));
        contactList.add(new Contact("014","family","em","nam","k biết","13/13/1000",""));
        contactList.add(new Contact("015","family","anh","nam","k biết","14/1/1000",""));
        contactList.add(new Contact("016","family","chị","nữ","k biết","1/15/1000",""));
    }

    public ContactManagement(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public void showAll() {
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }
    @Override
    public void addNew(Contact contact) {
        contactList.add(contact);
    }

    @Override
    public void updateById(String id, Contact contact) {
        int index = findById(id);
        if (index != -1) {
            contactList.set(index, contact);
        } else {
            System.out.println("Không tồn tại danh bạ này!");
        }
    }

    @Override
    public void removeById(String id) {
        int index = findById(id);
        if (index != -1) {
            contactList.remove(index);
        } else {
            System.out.println("Không tồn tại danh bạ này!");
        }
    }

    @Override
    public int findById(String phone) {
        int index = -1;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getNumberId().equals(phone)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public void searchContactByPhoneNumber(String phone)
    {
        for (Contact contact:contactList
             ) {
            if(contact.getNumberId().equals(phone))
            {
                System.out.println(contact);
            }
        }
    }

    @Override
    public void readFile(String path) {
        try {
            InputStream is = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(is);
            contactList = (List<Contact>) ois.readObject();
            ois.close();
            is.close();
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeFile(String path) {
        try {
            OutputStream os = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(contactList);
            oos.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
