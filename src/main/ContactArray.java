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
        System.out.println(ListStandart.get(ind).getName() + " " + ListStandart.get(ind).getPhone() + " " + ListStandart.get(ind).getEmail());
    }

    public int searchByName(String name) {
        for (int i = 0; i < ListStandart.size(); i++)
            if (name.equals(ListStandart.get(i).getName()))   return i;
        return -1;
    }

    public void changename (String name, int ind){
        ListStandart.get(ind).setName(name);
    }
    public void changephone (String phone, int ind){
        ListStandart.get(ind).setPhone(phone);
    }
    public void changeemail (String email, int ind){
        ListStandart.get(ind).setEmail(email);
    }
    public void sort(){
        int minind;
        for( int i = 0; i < ListStandart.size(); i++){
            minind = i;
            for(int j = i; j<ListStandart.size();j++){
                if(ListStandart.get(j).getName().compareTo(ListStandart.get(minind).getName()) < 0 )  minind = j;
            }
            String name = ListStandart.get(i).getName();
            String phone = ListStandart.get(i).getPhone();
            String email = ListStandart.get(i).getEmail();
            ListStandart.get(i).setName(ListStandart.get(minind).getName());
            ListStandart.get(i).setPhone(ListStandart.get(minind).getPhone());
            ListStandart.get(i).setEmail(ListStandart.get(minind).getEmail());
            ListStandart.get(minind).setName(name);
            ListStandart.get(minind).setPhone(phone);
            ListStandart.get(minind).setEmail(email);
        }
    }
}
