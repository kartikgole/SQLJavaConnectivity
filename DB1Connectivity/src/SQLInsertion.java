

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class SQLInsertion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection DatabaseConnection = null;
		FileReader FReader1=null;
		FileReader FReader2=null;
		FileReader FReader3=null;
		FileReader FReader4=null;
		FileReader Freader5=null;
		FileReader FReader6=null;

		BufferedReader BReader=null;
		PreparedStatement PrepStatement=null;
		
     
		try {
	
			//Database Connectivity
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String DBURL = "jdbc:mysql://localhost:3306/company?user=root&password=root";
			
			DatabaseConnection = DriverManager.getConnection(DBURL);
			
			if (DatabaseConnection != null) {
				
				System.out.println("\n\tThe System is Connected to the Database 'Company'.");
				DatabaseConnection.setAutoCommit(false);
				
				//Insertion of Data into the table 'Employee'
				
				FReader1=new FileReader("C:/Users/Kartik/Desktop/DB1/Project 1 Files/Data Files/EMPLOYEE.txt");	//Reading the file here
				if(FReader1!=null) {
				BReader=new BufferedReader(FReader1);
				
				String Line;
				int Count=0;
				String Address_temp;
				String Address;
				
				while((Line=BReader.readLine())!=null) {
					

					String EmployeeObject[]=Line.split(",");
					
							
						//Insertion Query
						PrepStatement = DatabaseConnection.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?,?,?,?,?)");
						
						//Setting Data into Actual Database
						PrepStatement.setString(1, EmployeeObject[0].replaceAll("'", ""));
						PrepStatement.setString(2, EmployeeObject[1].replaceAll("'", ""));
						PrepStatement.setString(3, EmployeeObject[2].replaceAll("'", ""));
						PrepStatement.setString(4, EmployeeObject[3].replaceAll("'", ""));
						String sDate1=EmployeeObject[4].replaceAll("'", "");					
						java.util.Date utilDate = new SimpleDateFormat("dd-MMM-yyyy").parse(sDate1);
						java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
						PrepStatement.setDate(5, sqlDate);
	                   
						Address_temp = " "+EmployeeObject[5].replaceAll("'","")+","+EmployeeObject[6]+","+EmployeeObject[7];
	                    Address = Address_temp;
	                    

	                    PrepStatement.setString(6, Address.replaceAll("'", "" ));
	                    PrepStatement.setString(7, EmployeeObject[8].replaceAll("'", ""));
						Double  d = new Double(EmployeeObject[9].replaceAll("'", ""));
				        PrepStatement.setDouble(8, d);					
				        PrepStatement.setString(9, EmployeeObject[10].replaceAll("'",""));
						PrepStatement.setInt(10, Integer.parseInt(EmployeeObject[11].replaceAll("'", "")));					
						int i=PrepStatement.executeUpdate();		
						Count++;
					}
					DatabaseConnection.commit();
					System.out.println(+Count+"\tValues have been Inserted into the Employee Table.");
				
					

				}  
				
				//Insertion of Data into the table 'Department'	
				
				FReader2=new FileReader("C:/Users/Kartik/Desktop/DB1/Project 1 Files/Data Files/DEPARTMENT.txt");
				if(FReader2!=null) {
				BReader=new BufferedReader(FReader2);
				String Line1;
				int Count1=0;

				while((Line1=BReader.readLine())!=null) {

					String DepartmentObject[]=Line1.split(",");
					
					PrepStatement = DatabaseConnection.prepareStatement("Insert into DEPARTMENT VALUES(?,?,?,?)");
			        PrepStatement.setString(1, DepartmentObject[0].replaceAll("'", ""));
					PrepStatement.setInt(2,Integer.parseInt(DepartmentObject[1]));
			        PrepStatement.setString(3, DepartmentObject[2].replaceAll("'", ""));
			        String sDate1=DepartmentObject[3].replaceAll("'", "");					
					java.util.Date utilDate = new SimpleDateFormat("dd-MMM-yyyy").parse(sDate1);
					java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
					PrepStatement.setDate(4, sqlDate);
			        int i =PrepStatement.executeUpdate();
			        Count1++;
				}
				DatabaseConnection.commit();
				System.out.println(+Count1+"\tValues have been Inserted into the Department Table.");
				}
				
				//Insertion of data into the table 'Dept_Locations'
				
				FReader3=new FileReader("C:/Users/Kartik/Desktop/DB1/Project 1 Files/Data Files/DEPT_LOCATIONS.txt");
				if(FReader3!=null) {
				BReader=new BufferedReader(FReader3);
				String Line2;
				int Count2=0;
				
				while((Line2=BReader.readLine())!=null) {

					String LocationsObject[]=Line2.split(",");

					PrepStatement = DatabaseConnection.prepareStatement("Insert into DEPT_LOCATIONS VALUES(?,?)");
			        
					PrepStatement.setInt(1,Integer.parseInt(LocationsObject[0]));
			        PrepStatement.setString(2, LocationsObject[1].replaceAll("'", ""));
			        int i =PrepStatement.executeUpdate();
			        Count2++;
				}
				DatabaseConnection.commit();
				System.out.println(+Count2+"\tValues have been inserted into Dept_Locations Table.");
				} 
				
				
				//Insertion of Data into the table 'Works_On'
				
				FReader3=new FileReader("C:/Users/Kartik/Desktop/DB1/Project 1 Files/Data Files/WORKS_ON.txt");
				if(FReader3!=null) {
				BReader=new BufferedReader(FReader3);
				String Line3;
				int Count3=0;
				
				while((Line3=BReader.readLine())!=null) {

					String WorksOnObject[]=Line3.split(",");

					PrepStatement = DatabaseConnection.prepareStatement("Insert into WORKS_ON VALUES(?,?,?)");
					
					PrepStatement.setString(1, WorksOnObject[0].replaceAll("'", ""));
					PrepStatement.setInt(2,Integer.parseInt(WorksOnObject[1]));
					Double  d = new Double(WorksOnObject[2]);
			        PrepStatement.setDouble(3, d);
			        int i =PrepStatement.executeUpdate();
			        Count3++;
				}
				DatabaseConnection.commit();
				System.out.println(+Count3+"\tValues have been inserted into Works_On Table.");
				} 
		
				//Insertion of Data into the table 'Project'	
				
				FReader3=new FileReader("C:/Users/Kartik/Desktop/DB1/Project 1 Files/Data Files/PROJECT.txt");
				if(FReader3!=null) {
				BReader=new BufferedReader(FReader3);
				String Line4;
				int Count4=0;
				
				while((Line4=BReader.readLine())!=null) {

					String ProjectObject[]=Line4.split(",");
					
					PrepStatement = DatabaseConnection.prepareStatement("Insert into PROJECT VALUES(?,?,?,?)");
					
					PrepStatement.setString(1, ProjectObject[0].replaceAll("'", ""));
					PrepStatement.setInt(2,Integer.parseInt(ProjectObject[1]));
					PrepStatement.setString(3, ProjectObject[2].replaceAll("'", ""));
					PrepStatement.setInt(4,Integer.parseInt(ProjectObject[3]));
			        int i =PrepStatement.executeUpdate();
			        Count4++;
				}
				DatabaseConnection.commit();
				System.out.println(+Count4+"\tValues have been inserted into Project Table.");
				} 
	
				//Insertion of Data into the table 'Dependent'
				
				
				FReader2=new FileReader("C:/Users/Kartik/Desktop/DB1/Project 1 Files/Data Files/DEPENDENT.txt");
				if(FReader2!=null) {
				BReader=new BufferedReader(FReader2);
				String Line5;
				int Count5=0;
				
				while((Line5=BReader.readLine())!=null) {

					String DependentObject[]=Line5.split(",");
					
					PrepStatement = DatabaseConnection.prepareStatement("Insert into DEPENDENT VALUES(?,?,?,?,?)");
			        PrepStatement.setString(1, DependentObject[0].replaceAll("'", ""));
			        PrepStatement.setString(2, DependentObject[1].replaceAll("'", ""));
			        PrepStatement.setString(3, DependentObject[2].replaceAll("'", ""));
			        String sDate1=DependentObject[3].replaceAll("'", "");					
					java.util.Date utilDate = new SimpleDateFormat("dd-MMM-yyyy").parse(sDate1);
					java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
					PrepStatement.setDate(4, sqlDate);
					PrepStatement.setString(5, DependentObject[4].replaceAll("'", ""));
			        int i =PrepStatement.executeUpdate();
			        Count5++;
				}
				DatabaseConnection.commit();
				System.out.println(+Count5+"\tValues have been inserted into Dependent Table.");
				}
			  
				}
			
			}catch (Exception ex) {
			System.out.println("Cannot connect to DB. :(");
					ex.printStackTrace();
		}
	}


}


