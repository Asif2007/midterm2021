package design;

import databases.ConnectDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FortuneEmployee {

	/**
	 * FortuneEmployee class has a main methods where you will be able to create Object from
	 * EmployeeInfo class to use fields and attributes.Demonstrate as many methods as possible
	 * to use with proper business work flow.Think as a Software Architect, Product Designer and
	 * as a Software Developer.(employee.info.system) package is given as an outline,you need to elaborate
	 * more to design an application that will meet for fortune 500 Employee Information
	 * Services.
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
	 *
	 **/
	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

		//implementation here...
		ArrayList<EmployeeInfo> empArr = new ArrayList<>();
		EmployeeInfo emp = new EmployeeInfo(0, "John");
		emp.setAge(30);
		emp.setGender("m");
		emp.setMajor("Software Developer");
		empArr.add(emp);

		emp = new EmployeeInfo(1, "Jane");
		emp.setAge(25);
		emp.setGender("f");
		emp.setMajor("Software Architect");
		empArr.add(emp);

		emp = new EmployeeInfo(2, "Lena");
		emp.setAge(21);
		emp.setGender("f");
		emp.setMajor("Product Designer");
		empArr.add(emp);

		// connect to db
		try	{
			ConnectDB connectDB = new ConnectDB();
			Connection connect = connectDB.connectToMySql();
			PreparedStatement ps = connect.prepareStatement("DROP TABLE IF EXISTS `fortune_employee`;");
			ps.executeUpdate();
			ps = connect.prepareStatement("CREATE TABLE `fortune_employee` (`data` varchar (255));");
			ps.executeUpdate();
			// store into mysql db
			for(EmployeeInfo em: empArr) {
				connectDB.insertDataFromStringToMySql(em.employeeId+"-"+em.employeeName+"-"+em.getAge()+"-"+em.getGender()+"-"+em.getMajor(),
						"fortune_employee", "data");
			}
			// Retrieve the db table data
			List<String> emps = connectDB.readDataBase("fortune_employee", "data");
			System.out.println("ID\t Name\t Age\t Gender\t Major\t");
			for(String st:emps){
				String[] empdata = st.split("-");
				System.out.println(empdata[0]+"\t"+empdata[1]+"\t"+empdata[2]+"\t"+empdata[3]+"\t"+empdata[4]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
