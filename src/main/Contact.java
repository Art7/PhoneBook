package main;

/**
 * Created by Artur on 14.04.2015.
 */
public class Contact {
    private String name;
    private String phone;
    private String email;
    //конструктор
    public Contact (String name, String phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    public void display(){
        System.out.println(name + " " + phone + " " + email);
    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setEmail(String email){
        this.email = email;
    }



}
