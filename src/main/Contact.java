package main;

/**
 * Created by Artur on 14.04.2015.
 */
public class Contact {
    String name;
    String phone;
    String email;
    //конструктор
    public Contact (String newName, String newPhone, String newEmail){
        name = newName;
        phone = newPhone;
        email = newEmail;
    }
    public void display(){
        System.out.println(name + " " + phone + " " + email);
    }


}
