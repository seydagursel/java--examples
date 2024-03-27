
import java.util.*;
public class MainText {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Document d = new Document();
		
		

		while(true) {

			for (MenuItems m : MenuItems.values()) {
				System.out.println(m.getStr());
			}

			try {
				
				int choice = sc.nextInt();
				
				if (choice == 1) {
					Paragraph p = new Paragraph();
					d.addParagraph(p);
				} 
				else if (choice == 2) {
					boolean outerLoop=true;
					do {
                        
						try {
							System.out.print("Please enter a paragraph number (starting from 1): ");
							int number = sc.nextInt();
							Paragraph tmp = d.getParagraphs().get(number - 1);
							tmp.displayParagraph();
							
							boolean loop=true;
							do {
			                    try { 
			                    	System.out.println("Please enter a new line:  ");
			                    	String line = sc.nextLine();
			                        tmp.addLine(line);
			                        
			                        loop=false;
			                    }
			                    catch(InvalidLine invalid) {
			                    	System.err.print(invalid);
			                    	sc.nextLine();
			                    }
			                    
			                    
							}while(loop);
							outerLoop=false;

						}
						catch(InputMismatchException i) {
			            	
			            	System.out.println("Please enter a valid choice!");	
			            	sc.nextLine();
			            }
						
				
					}while(outerLoop);
					

				} 
				else if (choice == 3) {
					boolean loop2=true;
					do {
						System.out.print("Please enter a paragraph number (starting from 1): ");
						try {
							int number = sc.nextInt();
							Paragraph tmp = d.getParagraphs().get(number - 1);
							tmp.displayParagraph();
							loop2=false;
						}
						catch(InputMismatchException i) {
			            	
			            	System.out.println("Please enter a valid choice!");	
			            	sc.nextLine();
			            } 
					}while(loop2);
					

				} 
				else if (choice == 4) {
					boolean loop3=true;
					do {
						System.out.println("1. Plain text print");
						System.out.println("2. Formatted text print");
						System.out.println("3. Detailed text print");
						System.out.println("4. Sorted text print");
						try {
							int innerChoice = sc.nextInt();
							if (innerChoice == 1) {
								new PlainTextView(d).print();
							} else if (innerChoice == 2) {
								new FormattedView(d).print();
							} else if (innerChoice == 3) {
								new DetailedView(d).print();
							} else if (innerChoice==4) {
								new SortedView(d).print();
							}else {
								System.out.println("Wrong choice for print format!");
							}
							loop3=false;
						}
						catch(InputMismatchException i) {
			            	
			            	System.out.println("Please enter a valid choice!");	
			            	sc.nextLine();
			            } 
					}while(loop3);
					
				} 
				else if (choice == 5) {
					System.out.println("Please enter word(s) to search...");
					String word = sc.nextLine();
					d.search(word);
				} 
				else if (choice == 6) {
					break;
				} 
				else {
					System.out.println("Wrong choice for menu!");
				}
				
			}
			catch(InputMismatchException i) {
            	
            	System.out.println("Please enter a valid choice!");	
            	sc.nextLine();
            } 

            System.out.println("");
			
			

		}

	}

}
