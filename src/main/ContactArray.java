package main;

import java.util.ArrayList;

/**
 * Created by Artur on 14.04.2015.
 */
public class ContactArray {
    ArrayList<Contact> ListStandart = null;

    public ContactArray() {
        ListStandart = new ArrayList<Contact>();
    }

    public void display() {
        for (int i = 0; i < ListStandart.size(); i++) {
            display(i);
        }
    }

    public void add(String name, String phone, String email) {
        ListStandart.add(new Contact(name, phone, email));
    }

    public void delete(int index) {
        ListStandart.remove(index);
    }

    public void deleteByName(String name) {
        ListStandart.remove(searchByName(name));
    }

    public int size() {
        return ListStandart.size();
    }

    public void display(int ind) {
        System.out.println(ListStandart.get(ind).name + " " + ListStandart.get(ind).phone + " " + ListStandart.get(ind).email);
    }

    public int searchByName(String name) {
        for (int i = 0; i < ListStandart.size(); i++)
            if (name.equals(ListStandart.get(i).name))   return i;
        return -1;
    }

    public void changename (String name, int ind){
        ListStandart.get(ind).name = name;
    }
    public void changephone (String phone, int ind){
        ListStandart.get(ind).phone = phone;
    }
    public void changeemail (String email, int ind){
        ListStandart.get(ind).email = email;
    }
}
