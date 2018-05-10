package mx.itesm.listviewsspinners;

/**
 * Created by UXLab on 02/02/18.
 */

public class Student {

    private String name, hobby, phone, address;
    private int age;

    public String getName() {
        return name;
    }
    public String getHobby() {
        return hobby;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public int getAge() {
        return age;
    }

    public Student(String name, String hobby, int age, String phone, String address){
        this.name = name;
        this.hobby = hobby;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }
}
