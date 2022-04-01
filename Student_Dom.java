package com.ssm.StudentXT;

import java.util.ArrayList;
import java.util.Scanner;

public class Student_Dom {
    public static void main(String[] args) {
        //创建集合，储存学生数据
        ArrayList<Student> array = new ArrayList<Student>();
        while (true) {
            System.out.println("--------欢迎来到管理系统--------");
            System.out.println("1.添加学生.");
            System.out.println("2.删除学生.");
            System.out.println("3.修改学生.");
            System.out.println("4.查看所有学生.");
            System.out.println("5.退出.");
            System.out.println("请输入你的选择：");

            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            switch (line) {
                case "1":
                    //System.out.println("添加学生");
                    addStudnet(array);
                    break;
                case "2":
                    //System.out.println("删除学生");
                    deleteStudnet(array);
                    break;
                case "3":
                    //System.out.println("修改学生");
                    updateSutdent(array);
                    break;
                case "4":
                    //System.out.println("查看所有学生");
                    findAllStudnt(array);
                    break;
                case "5":
                    System.out.println("谢谢使用！");
                    //break;
                    System.exit(0);
            }
        }
    }
    //添加学生代码
    public static void addStudnet(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入学生的学号：");
            id = sc.nextLine();
            boolean flag = isUsed(array,id);
            if (flag) {
                System.out.println("你的学号已被占用，请重新输入");
            }else {
                break;
            }
        }
        System.out.println("请输入学生的姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生的年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生的居住地：");
        String address = sc.nextLine();

        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        //添加到集合
        array.add(s);
        System.out.println("添加学生成功");
    }
    //学号重复问题
    public static boolean isUsed(ArrayList<Student> array, String id){
            boolean flag = false;
            for (int i =0;i<array.size();i++){
                Student s = array.get(i);
                if (s.getId().equals(id)){
                    flag = true;
                    break;
                }
            }
            return flag;
    }
    //查看所有学生信息代码
    public static void findAllStudnt(ArrayList<Student> array){
        //判断集合中是否有数据，如果没有显示该提示消息
        if (array.size()==0){
            System.out.println("无信息，请添加后再查询！!!");
        //为了程序不再执行下去，给出return
            return;
        }
        System.out.println("学号\t\t姓名\t\t年龄\t\t居住地");
        for (int i =0;i <array.size(); i++){
            Student s = array.get(i);
            System.out.println(s.getId()+"\t\t"+s.getName()+"\t\t"+s.getAge()+"岁"+"\t"+s.getAddress());
        }
    }
    //删除学生信息代码
    public static void deleteStudnet(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除学生的学号：");
        String id = sc.nextLine();
        //遍历集合将对应学生对象从集合中删除
        int index = -1;
        for (int i = 0;i<array.size(); i++){
            Student s = array.get(i);
            if (s.getId().equals(id)){
                //array.remove(i);
                index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println("该信息不存在，请重新输入。");
        }else {
            array.remove(index);
            System.out.println("删除成功！");
        }
    }
    //修改学生信息的代码
    public static void updateSutdent(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的学生的学号：");

        String id = sc.nextLine();
        System.out.println("请输入新学生的新姓名");
        String name = sc.nextLine();
        System.out.println("请输入新学生的新学号");
        String age = sc.nextLine();
        System.out.println("请输入新学生的新居住地");
        String address = sc.nextLine();

        Student s =new Student();
        s.setId(id);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        for (int i =0;i <array.size();i++){
                Student student = array.get(i);
            if (student.getId().equals(id)){
                array.set(i,s);
                break;
            }
        }
        System.out.println("修改成功！！");
    }
}
