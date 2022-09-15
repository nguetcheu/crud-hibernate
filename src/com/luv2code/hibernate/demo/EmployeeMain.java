package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Employee;


public class EmployeeMain {

	public static void main(String[] args) {
		
		// Cr�ation de la session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// r�cuperation d'une instance d'une session
		Session session = factory.getCurrentSession();
		
		try {
			/* Insertion 
			Employee employee1 = new Employee("nguetcheu kuinsi", "dominique", "capGemini");
			
			// D�but de la transaction
			session.beginTransaction();
			
			session.save(employee1);
			
			//Fin de la transaction
			session.getTransaction().commit();
			
			System.out.println("done");
			*/
			
			/*
			//Use a session object to save Java object
			System.out.println("Cr�ation d'un objet employee....");
			Employee ngamba = new Employee("ngamba", "mael", "flutter");
			
			// D�but de la  transaction
			session.beginTransaction();
			
			// Sauvegarde d'un objet employee
			System.out.println("Sauvegarde de l'employee....");
			System.out.println(ngamba);
			session.save(ngamba);
			
			// Fin de la transaction
			session.getTransaction().commit();
			
			// R�cuperation de id
			System.out.println("Sauvegarde de l'employee. id: "+ngamba.getId());
			System.out.println("Done!");
			
			// r�cuperation d'une session et D�but de la transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// recuperation de id
			System.out.println("\nR�cuperation d'un employee avec id: " + ngamba.getId());
			
			Employee myEmployee = session.get(Employee.class, ngamba.getId());
			// Fin de la transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			*/
			
			/*
			// debut transaction
			session.beginTransaction();
			
			// Execution de la requet sql
			List<Employee> listeEmployee =  session.createQuery("FROM Employee e where e.company = 'capGemini' ").getResultList();
			
			// affichage du resultat
			for (Employee employee : listeEmployee) {
				System.out.println(employee.toString());
			}
			
			// Fin de la transaction
			session.getTransaction().commit();
			*/
			
			// supression 
			int employeeid = 2;

			// debut de la transaction
			session.beginTransaction();
			
			// cr�ation employee
			Employee ngamba = session.get(Employee.class, employeeid);
			
			// requete de supression
			session.delete(ngamba);
			
			// Fin de la transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
