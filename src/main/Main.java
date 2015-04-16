package main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Artur on 14.04.2015.
 */
public class Main {
    /*
    Меню:
    1 - добавить контакт
    2 - удалить контакт
    3 - вывести все контакты
    4 - выйти из программы
     */
    public static void main(String[] args) {
        // использование конструктора
        // Contact c = new Contact("Anna", "89112314567", "mail@gmail.ru");
        // Накладно:
        //        c.name = "Anna";
        //        c.phone = "89112314567";
        //        c.email = "mail@gmail.ru";
        int a=0, b=0, ind;
        String name, phone, email;
        ContactArray ContactBase = new ContactArray();
        while (true) {
            System.out.println("Меню:");
            System.out.println("1 - добавить контакт");
            System.out.println("2 - удалить контакт по индексу");
            System.out.println("3 - удалить контакт по имени");
            System.out.println("4 - вывести все контакты");
            System.out.println("5 - вывести контакт по имени");
            System.out.println("6 - редактировать контакт");
            System.out.println("7 - сортировать");
            System.out.println("8 - выход из программы");
            Scanner scan = new Scanner(System.in);
            try {
                a = scan.nextInt();
            }
            catch ( InputMismatchException e)
            {
                a = 9;
            }
            switch (a) {
                case 1: {
                    System.out.println("Введите имя:");
                    name = scan.next();
                    System.out.println("Введите телефон");
                    phone = scan.next();
                    System.out.println("Введите email");
                    email = scan.next();
                    ContactBase.add(name, phone, email);
                    break;
                }
                case 2: {
                    System.out.println("Введите номер удаляемой строки");
                    try {
                        ind = scan.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Введите номер!");
                        break;
                    }
                    if (ind > ContactBase.size()) {
                        System.out.println("Введите номер меньше либо равный объему базы");
                        break;
                    }
                    ContactBase.delete(ind);
                    break;
                }
                case 3: {
                    System.out.println("Введите имя для удаляемой записи");
                    name = scan.next();
                    ind = ContactBase.searchByName(name);
                    if (ind == -1) System.out.println("Такая запись не найдена!");
                    else ContactBase.deleteByName(name);
                    break;
                }
                case 4: {
                    ContactBase.display();
                    break;
                }
                case 5: {
                    System.out.println("Введите имя искомой записи");
                    name = scan.next();
                    ind = ContactBase.searchByName(name);
                    if (ind == -1) System.out.println("Такая запись не найдена!");
                    else ContactBase.display(ind);
                    break;
                }
                case 6: {
                    System.out.println("Введите имя для редактируемого контакта");
                    name = scan.next();
                    ind = ContactBase.searchByName(name);
                    if (ind == -1) System.out.println("Такая запись не найдена!");
                    else {
                        ContactBase.display(ind);
                        System.out.println("Подменю редактирования:");
                        System.out.println("1 - изменить имя");
                        System.out.println("2 - изменить номер телефона");
                        System.out.println("3 - изменить email");
                        System.out.println("4 - выход из подпрограммы");
                        try {
                            b = scan.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Введите номер!");
                            break;
                        }
                        switch (b) {
                            case 1: {
                                System.out.println("Введите новое имя");
                                name = scan.next();
                                ContactBase.changename(name, ind);
                                ContactBase.display(ind);
                                break;
                            }
                            case 2: {
                                System.out.println("Введите новый телефон");
                                phone = scan.next();
                                ContactBase.changephone(phone, ind);
                                ContactBase.display(ind);
                                break;
                            }
                            case 3: {
                                System.out.println("Введите новый email");
                                email = scan.next();
                                ContactBase.changeemail(email, ind);
                                ContactBase.display(ind);
                                break;
                            }
                            case 4: {
                                break;
                            }
                        }

                    }
                    break;
                }
                case 7: {
                    //sorting
                    ContactBase.sort();
                    ContactBase.display();
                    break;
                }

                case 8: {
                    System.exit(0);
                }
                default: {
                    System.out.println("Введите число от 1 до 8!");
                    break;
                }
            }
    }
    }


}
//Tasks 14/4/2015
// 1 - поиск по имени  OK
// 2 - редактирование контакта OK
// 2.2 - что хотите изменить OK
// 2.3 - сохранить изменение OK
// 3 - создать две коллекции и заполнить их именами
// 3.1 - программа создает 3-ю коллекцию, заполняя ее именами первой и второй без повторений
// Dima, Anna, Alex
// Alex, Vova, Dima, Sasha
// Dima, Anna, Alex, Vova, Sasha
// 3.2 - В третью записываются только те, которые есть в обеих коллекциях
// Dima, Alex
// Sort