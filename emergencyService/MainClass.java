package deneme;

import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MainClass {

	public static ArrayList<Appointment> list = new ArrayList<>();
	private static ArrayList<Doctor>doctors=new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int selection = 0;
		String menu =" ";
        int count=0;
		while(true) {
            if(count==0) {
            	for (MenuItem m : MenuItem.values()) {
   				 menu +="\n"+m.getStr();
   				 count++;
                }
			}
			String forMenu=JOptionPane.showInputDialog(null,menu,"MENU",JOptionPane.QUESTION_MESSAGE);
			selection=Integer.parseInt(forMenu);
			
            try {
                
                
                if (selection == 1) {
        			
        			String name =JOptionPane.showInputDialog(null,"Please enter a name","GET INFO",JOptionPane.QUESTION_MESSAGE);
        			
        			String surname = JOptionPane.showInputDialog(null,"Please enter a surname","GET INFO",JOptionPane.QUESTION_MESSAGE);
        			
        			String field = JOptionPane.showInputDialog(null,"Please enter a field","GET INFO",JOptionPane.QUESTION_MESSAGE);
        			list.add(new Doctor(name, surname, field));
        			doctors.add(new Doctor(name, surname, field));
        			
        		} else if (selection == 2) {
        			String name =JOptionPane.showInputDialog(null,"Please enter a name","GET INFO",JOptionPane.QUESTION_MESSAGE);
        			
        			String surname = JOptionPane.showInputDialog(null,"Please enter a surname","GET INFO",JOptionPane.QUESTION_MESSAGE);
        			String IDstring = JOptionPane.showInputDialog(null,"Please enter a ID: ","GET INFO",JOptionPane.QUESTION_MESSAGE);
        			long ID = Long.parseLong(IDstring);
        			list.add(new Patient(name, surname, ID));
        		} else if (selection == 3) {
        			String doctorInfo=" ";  
        			Collections.sort(doctors,new MyComparator());
   
        			for(Doctor d:doctors) {  				
        				doctorInfo+=d.displayInfo();
			
        		    }
        			JOptionPane.showMessageDialog(null,doctorInfo,"Doctors",JOptionPane.INFORMATION_MESSAGE);
        		} else if (selection == 4) {
        			Iterator<Appointment> itd = list.iterator();
        			String patientInfo=" ";
        			while (itd.hasNext()) {
        				Appointment a = itd.next();
        				if (a instanceof Patient) {
        					Patient p = (Patient) a;
        					patientInfo+=p.displayInfo();
        				}
        			}
        			JOptionPane.showMessageDialog(null,patientInfo,"Patients",JOptionPane.INFORMATION_MESSAGE);
        		} else if (selection == 5) {
        			System.out.print("Please enter a code: ");
        			String code = sc.nextLine();
        			list.add(new AmbulanceDepartment(code));
        		} else if (selection == 6) {
        			System.out.print("Please enter a code: ");
        			String code = sc.nextLine();
        			list.add(new FireDepartment(code));
        		} else if (selection == 7) {
        			Iterator<Appointment> itd = list.iterator();
        			while (itd.hasNext()) {
        				Appointment a = itd.next();
        				if (a instanceof AmbulanceDepartment) {
        					AmbulanceDepartment aD = (AmbulanceDepartment) a;
        					aD.print();
        				}
        			}
        		} else if (selection == 8) {
        			Iterator<Appointment> itd = list.iterator();
        			while (itd.hasNext()) {
        				Appointment a = itd.next();
        				if (a instanceof FireDepartment) {
        					FireDepartment fD = (FireDepartment) a;
        					fD.print();
        				}
        			}
        		} else if (selection == 9) {
        			Iterator<Appointment> itd = list.iterator();
        			while (itd.hasNext()) {
        			    Appointment a = itd.next();
        				a.getAppointment();
        				System.out.println();
        				System.out.println("-----");
        				System.out.println();
        			}
        		} else if (selection == 0) {
        			break;
        		} else {
        			System.out.println("Wrong selection. Please retry!");
        		}
                
            }catch(InputMismatchException i) {
            	
            	System.out.println("Please enter a valid choice!");	
            	sc.nextLine();
            } 

            System.out.println("");
		}   

	}

}
