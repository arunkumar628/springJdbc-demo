package com.spring.jdbc;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.dao.impl.StudentDaoImpl;
import com.spring.jdbc.pojo.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext con = new AnnotationConfigApplicationContext(jdbcConfig.class);

		StudentDaoImpl studentDao = con.getBean("studentDao", StudentDaoImpl.class);

		Scanner sc = new Scanner(System.in);

		/*
		 * List<Student> selectAllStudent = studentDao.selectAllStudent();
		 * Collections.sort(selectAllStudent); for (Student s:selectAllStudent) {
		 * System.out.println(s); }
		 */
		boolean flag = true;
		while (flag) {
			System.out.println("1.INSERT STUDENT DATA");
			System.out.println("2.UPDATE STUDENT DATA");
			System.out.println("3.FIND STUDENT BY STUDENT ID");
			System.out.println("4.DELETE STUDENT DATA ");
			System.out.println("5.VIEW ALL STUDENT DATA");
			System.out.println("6.Exit");

			System.out.println("==========================================");
			System.out.print("Enter option :");
			int option = sc.nextInt();

			switch (option) {
			case 1:// INSERT STUDENT DATA
				System.out.print("Enter Student ID :");
				int sId = sc.nextInt();
				System.out.print("Enter Student Name :");
				String sName = sc.nextLine();
				sName = sc.nextLine();

				System.out.print("Enter Student Fees :");
				double sFees = sc.nextDouble();
				Student student = new Student(sId, sName, sFees);

				int insertStudent = studentDao.insertStudent(student);
				System.out.println(insertStudent + " row inserted");
				System.out.println("====================================");
				break;

			case 2:// UPDATE STUDENT DATA
				System.out.print("Enter Student ID to update details :");
				int updateId = sc.nextInt();
				System.out.print("Enter Student Name to be updated  :");
				String updateName = sc.nextLine();
				updateName = sc.nextLine();
				System.out.print("Enter Student Fees to be updated :");
				double updateFees = sc.nextDouble();
				Student updateStudent = new Student(updateId, updateName, updateFees);

				int updateStudentDetails = studentDao.updateStudent(updateStudent);
				System.out.println(updateStudentDetails + " row updated");
				System.out.println("*********************************");
				break;

			case 3:// FIND STUDENT BY STUDENT ID
				System.out.print("Enter Student ID to view details :");
				int viewId = sc.nextInt();

				Student selectStudent = studentDao.selectStudent(viewId);
				System.out.println(selectStudent);
				System.out.println("------------------------------------------");
				break;

			case 4:// DELETE STUDENT DATA
				System.out.print("Enter Student ID to delete details :");
				int deleteId = sc.nextInt();

				int deleteStudent = studentDao.deleteStudent(deleteId);
				System.out.println(deleteStudent + " row deleted");
				System.out.println("-------------------------------------------------");
				break;

			case 5:// VIEW ALL STUDENT DATA

				List<Student> selectAllStudent = studentDao.selectAllStudent();
				Collections.sort(selectAllStudent);
				for(int i=0;i<=selectAllStudent.size();i++)
				{
					if(selectAllStudent.size()==0)
					{
						System.out.println("no rows selected");
					}
				}
				for (Student s : selectAllStudent) {
					System.out.println(s);
				}
				System.out.println("--------------------------------------------");
				break;

			case 6:
				flag = false;
				System.out.println("Logged out...");
				break;
			default:
				System.out.println("invalid option");
				break;
			}

		}

	}

}
