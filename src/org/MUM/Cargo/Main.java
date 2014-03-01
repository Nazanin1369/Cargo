package org.MUM.Cargo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main 
{


	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int q=0;
		String desc;
		String z;
		double w;
		String customerName;


		ArrayList<Package> allPackages = new ArrayList<Package>();
		ArrayList<Customer> customers = new ArrayList<Customer>();

		//Construct customers
		Customer c1= new Customer("Jack");
		customers.add(c1);
		c1.setRole(new Senior());

		Customer c2= new Customer("Ammy");
		customers.add(c2);
		c2.setRole(new Senior());

		Customer c3= new Customer("Leila");
		customers.add(c3);
		c3.setRole(new Senior());

		Customer c4 = new Customer("Cheryl");
		customers.add(c4);
		c4.setRole(new Student());

		Customer c5 = new Customer("Michael");
		customers.add(c5);
		c5.setRole(new Student());

		Customer c6 = new Customer("Jane");
		customers.add(c6);
		c6.setRole(new Student());


		//--------------------------------------------------------------
		System.out.println("Enter your name: ");
		customerName = sc.next();
		for(Customer s : customers)
		{
			if(s.name.equals(customerName))
			{
				System.out.println("How many packages do you have?");
				q=sc.nextInt();
				while(q != 0)
				{
					System.out.println("Enter your package description: ");
					desc=sc.next();
					System.out.println("Enter package weight: ");
					w=sc.nextDouble();
					System.out.println("Enter zone: ");
					z=sc.next();
					Package p =new Package(desc, w, z);
					allPackages.add(p);

					System.out.println("Your package has been created,the number is: "+ p.getNumber());
					q --;
				}
				if(s.role instanceof Senior )
				{
					Senior sn=(Senior) s.role;
					for(Package p : allPackages)
						findMinimum(p,q,sn);
				}
				else if(s.role instanceof Student)
				{
					Student st = (Student) s.role;
					for(Package p : allPackages)
						findMinimum(p,q,st);
				}

				else
				{
					for(Package p : allPackages)
						findMinimum(p,q);
				}
			}//----------------------------------------------------------------------------
			else
			{
				
				int role;
				System.out.println("Your name is not in the customers list.Sign up please: ");
				System.out.println("**sign up**");
				System.out.println("Name: ");
				customerName = sc.next();
				System.out.println("Role(1.Senior/2.Student/3.none): ");
				role = sc.nextInt();
				Customer c=new Customer(customerName);
				System.out.println("Your account has been created.");
				customers.add(c);
				if(role==1)
				{
					Senior sn= new Senior();
					c.setRole(sn);
					System.out.println("How many packages do you have?");
					q=sc.nextInt();
					while(q != 0)
					{
						System.out.println("Enter your package description: ");
						desc=sc.next();
						System.out.println("Enter package weight: ");
						w=sc.nextDouble();
						System.out.println("Enter zone: ");
						z=sc.next();
						Package p =new Package(desc, w, z);
						allPackages.add(p);

						System.out.println("Your package has been created,the number is: "+ p.getNumber());
						q --;
					}//End of while
					for(Package p : allPackages)
						findMinimum(p,q,sn);
					break;
				}
				else if(role==2){
					Student st = new Student();
					c.setRole(st);
					System.out.println("How many packages do you have?");
					q=sc.nextInt();
					while(q != 0)
					{
						System.out.println("Enter your package description: ");
						desc=sc.next();
						System.out.println("Enter package weight: ");
						w=sc.nextDouble();
						System.out.println("Enter zone: ");
						z=sc.next();
						Package p =new Package(desc, w, z);
						allPackages.add(p);

						System.out.println("Your package has been created,the number is: "+ p.getNumber());
						q --;
					}//End of while
					for(Package p : allPackages)
						findMinimum(p,q,st);
					break;
				}
				else if(role==3)
				{
					System.out.println("sry,No discount has been devoted for your role.");
					System.out.println("How many packages do you have?");
					q=sc.nextInt();
					while(q != 0)
					{
						System.out.println("Enter your package description: ");
						desc=sc.next();
						System.out.println("Enter package weight: ");
						w=sc.nextDouble();
						System.out.println("Enter zone: ");
						z=sc.next();
						Package p =new Package(desc, w, z);
						allPackages.add(p);

						System.out.println("Your package has been created,the number is: "+ p.getNumber());
						q --;
					}//End of while
					break;
				}
				else
				{
					System.out.println("Invalid Entry!");
					break;
				}


			}//End of if
			

		}//End of for

	}//End of main






	public static void findMinimum(Package p, int q, CustomerRole r)
	{
		double min=0;
		String carrierName="";
		ArrayList<Double> costs = new ArrayList<Double>();
		//create carrier objects
		FedEx f=new FedEx();
		UPS up = new UPS();
		USMail us = new USMail();
		DHL dhl = new DHL();
		//
		double fedExCost = (f.computeShipment(p))-(r.discount);
		double upsCost = (up.computeShipment(p))-(r.discount);
		double usMailCost = (us.computeShipment(p))-(r.discount);
		double dhlCost = (dhl.computeShipment(p))-(r.discount);

		costs.add(fedExCost);
		costs.add(upsCost);
		costs.add(usMailCost);
		costs.add(dhlCost);
		Collections.sort(costs);
		min = costs.get(0);
		if(min==fedExCost)
		{
			carrierName="FedEx";
		}
		if(min==upsCost)
		{
			carrierName="UPS";
		}
		if(min==usMailCost)
		{
			carrierName="USMail";
		}

		System.out.format("%s  ,$%3.2f  ,%s,",p.description,min,carrierName);

	}

	public static void findMinimum(Package p, int q)
	{
		double min=0;
		String carrierName="";
		ArrayList<Double> costs = new ArrayList<Double>();
		//create carrier objects
		FedEx f=new FedEx();
		UPS up = new UPS();
		USMail us = new USMail();
		DHL dhl = new DHL();
		//
		double fedExCost = (f.computeShipment(p));
		double upsCost = (up.computeShipment(p));
		double usMailCost = (us.computeShipment(p));
		double dhlCost = (dhl.computeShipment(p));

		costs.add(fedExCost);
		costs.add(upsCost);
		costs.add(usMailCost);
		costs.add(dhlCost);
		Collections.sort(costs);
		min = costs.get(0);
		if(min==fedExCost)
		{
			carrierName="FedEx";
		}
		if(min==upsCost)
		{
			carrierName="UPS";
		}
		if(min==usMailCost)
		{
			carrierName="USMail";
		}

		System.out.format("%s  ,$%3.2f  ,%s,",p.description,min,carrierName);

	}
	
	public void getPackahe()
	{
		
	}

}
