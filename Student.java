package com.ssm.StudentXT;

public class Student {
    private String id;
    private String name;
    private String age;
    private String address;
    public Student(){}
    public Student(String id,String name,String age,String address){
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(String age){
        this.age = age;
    }
    public String getAge(){
        return age;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }


}
