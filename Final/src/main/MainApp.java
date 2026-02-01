package main;

import java.util.List;
import java.util.Scanner;

import dao.ItemDAO;
import daoimpl.ItemDAOImpl;
import dto.Item;

public class MainApp {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
				ItemDAO dao=new ItemDAOImpl();
		while(true) {
			System.out.println("\n---LOST & FOUND SYSTEM ---");
			System.out.println("1.Report  Lost Item");
			System.out.println("2.Report Found Item");
			System.out.println("3.View Lost Item");
			System.out.println("4.View Found Item");
			System.out.println("5.Exit");
			System.out.println("Choice");
			
			int ch=sc.nextInt();
			sc.nextLine();
			
			if(ch==1||ch==2) {
				System.out.println("Item Name:");
				String name=sc.nextLine();
				System.out.println("Place:");
				String place=sc.nextLine();
				String status=(ch==1)?"LOST":"FOUND";
				dao.addItem(new Item(name,place,status));
				
				System.out.println("Item added successfully!");
			}
			else if(ch==3||ch==4) {
				String status=(ch==3)?"LOST":"FOUND";
				List<Item> items=dao.viewItems(status);
				
				System.out.println("\nID NAME PLACE STATUS");
				for(Item i:items) {
					System.out.println(i.getId() + " " + i.getName() + " " +i.getPlace() + " " + i.getStatus());
				}
			}
			else if(ch==5) {
				System.out.println("Thank you!");
				break;
			}else {
				System.out.println("Invalid choice");
			}
		}
		sc.close();
	}
	}