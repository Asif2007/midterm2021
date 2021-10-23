package design;

import org.testng.Assert;

public class UnitTestingEmployeeInfo {
    public static void main(String[] args) {
        //Write Unit Test for all the methods has been implemented in this package.

        //implementation here...
        int emp_id = 3;
        String emp_name = "tom";
        int age = 50;
        String gender = "male";
        String major = "Math";
        EmployeeInfo emp0 = new EmployeeInfo(emp_id, emp_name);
        emp0.setAge(age);
        emp0.setGender(gender);
        emp0.setMajor(major);

        EmployeeInfo emp1 = new EmployeeInfo(emp_id, emp_name);
        emp1.setAge(11);
        emp1.setGender("f");
        emp1.setMajor("Math");

        EmployeeInfo emp2 = new EmployeeInfo(emp_id, emp_name);
        emp2.setAge(50);
        emp2.setGender("f");
        emp2.setMajor("Arabic");


        try {
            Assert.assertEquals(emp0.employeeId, emp_id, "different id");
        }catch(Exception ex){
            ex.getMessage();
        }
        try {
            Assert.assertEquals(emp0.getMajor(), emp1.getMajor());
        }catch(Exception ex){
            ex.getMessage();
        }
        try {
            Assert.assertEquals(emp0.employeeName, emp_name, "different name");
        }catch(Exception ex){
            ex.getMessage();
        }
        try {
            Assert.assertEquals(emp0.age, 50, "different age");
        }catch(Exception ex){
            ex.getMessage();
        }
        try {
            Assert.assertTrue(emp0.getAge()==emp2.getAge());
        }catch(Exception ex){
            ex.getMessage();
        }
    }
}

