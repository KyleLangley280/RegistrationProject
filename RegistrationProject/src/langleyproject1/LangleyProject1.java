/*
empty crn
too long or too short crn
trying to add class you already have
*/
package langleyproject1;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class LangleyProject1 {

int arraySize;

    public static void main(String[] args) {
     
        ArrayList<String> class_loop;
        ArrayList<Course> total_classes = new ArrayList<>();
        ArrayList<Course> trial_schedule = new ArrayList<>();
        String line;
    
        Boolean quit = false;
        boolean courseFound = false;
        boolean crnFound = false;
        Scanner input = new Scanner(System.in);
        int user;
        String user_classes;
        
        try {
            
        Scanner in = new Scanner(Paths.get("project1input.csv"), "UTF-8");
        while(in.hasNextLine()){
            
            line = in.nextLine();
            
            class_loop = new ArrayList(Arrays.asList(line.split("\t")));
            
            if (class_loop.size() == 7){
            
            
                
            total_classes.add(new Online(class_loop.get(0),class_loop.get(1),
                    class_loop.get(2),class_loop.get(3), class_loop.get(4),
                    class_loop.get(5),class_loop.get(6)));
            
                }
            
            else{
                total_classes.add(new Traditional(class_loop.get(0),class_loop.get(1),
                    class_loop.get(2),class_loop.get(3),
                    class_loop.get(4),class_loop.get(5),class_loop.get(6),
                    class_loop.get(7),class_loop.get(8),class_loop.get(9),
                    class_loop.get(10)));
                    
                 }
            
            }
   
        }
     catch (Exception e) {
             
            System.err.println(e.toString());
            
        }
     
        
        
         while(quit == false){
            
            
                  System.out.println("\n1) Search Courses\n" +"2) Register for Course\n" +"3) View Trial Schedule\n" +"4) Quit");
                  System.out.println("Your choice?: ");
                  user = input.nextInt();
                  input.nextLine();
                  courseFound = false;
                  switch(user){
                  case (1):
                   
                           System.out.println("Enter course number in the format SSNNN (for example, CS201): ");
                           user_classes = input.nextLine();
                           
                           for (Course c : total_classes ){
                   
                                    if (((c.getCourse_number()).equals(user_classes))){
                                             System.out.println(c);
                                             courseFound = true;
                                     }
                                   
                           }
                
                           if (courseFound == false){
                                    System.out.println("ERROR: class not found; try again\n");
                           }
                
                  break;
            
                  case(2):
                    
                           System.out.println("Enter CRN number: ");
                           int counter = 0;
                           user_classes = input.nextLine();
                           for (Course c : total_classes){
                               if(((c.getCrn_number()).equals(user_classes))){
                                   
                               }

                               else{
                                   counter++;
                               }
                               
                               if(counter == total_classes.size()){
                                   System.out.println("ERROR: No class found");                                 
                               }
                               
                               else if (user_classes.length() != 5){
                                   System.out.println("ERROR: No class found");
                                   break;
                               }
                               
                               
                                if(((c.getCrn_number()).equals(user_classes))){
                                    crnFound = false;
                                    if (trial_schedule.size() != 0){
                                        for(int i = 0; i < trial_schedule.size();i++){  
                                            if (trial_schedule.get(i) instanceof Traditional){
                                                if(c.conflictsWith(trial_schedule.get(i).getStart(), trial_schedule.get(i).getStop(), trial_schedule.get(i).getDays()) == false){
                                                    crnFound = true;
                                                    
                                                }
                                                else{
                                                    crnFound = false;
                                                    break;
                                                }
                                            }
                                            else{
                                                if (trial_schedule.get(i) instanceof Online){
                                                    
                                                    crnFound = true;
                                                    
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        crnFound = true;
                                    }
                                    
                                    if (crnFound == false){
                                            System.out.println("ERROR: CRN not found/conflicts with one of your other classes \n");
                                    }
                                    else{
                                        System.out.println("Course added successfully!");
                                        trial_schedule.add(c);
                                    }
                                  
                            }

                           }
                           
                  break; 
            
                  case(3):
                           boolean trialSchedule = false;
                           for (Course c: trial_schedule){
                                    System.out.println(c);
                           }
                
                  break;
                
                  case(4):
                    
                           System.out.println("Thanks for using the student registration system!");
                           quit = true;
                           break;
                
                  default:
                           System.out.println("ERROR: Input must be in range (1-4): ");
                  break;
                  }
            
            
        }
        
        
        
    }      
}

