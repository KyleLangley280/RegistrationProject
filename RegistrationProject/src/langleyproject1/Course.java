
package langleyproject1;


public abstract class Course {
    
    public Course( String name, String crn_number, String course_number, String section_number, String credit_hours,String type, String Instructor){
  
    }
    public String getName() {
        return this.getName();
    }


    public String getCrn_number() {
        return this.getCrn_number();
    }

    public String getCourse_number() {
        return this.getCourse_number();
    }

    public String getSection_number() {
        return this.getSection_number();
    }

 

    public String getCredit_hours() {
        return this.getCredit_hours();
    }



    public String getStart() {
        return this.getStart();
    }



    public String getStop() {
        return this.getStop();
    }



    public String getDays() {
        return this.getDays();
    }



    public String getLocation() {
        return this.getLocation();
    }



    public String getType() {
        return this.getType();
    }

 

    public String getInstructor() {
        return this.getInstructor();
    }

    public abstract boolean conflictsWith(String compareStart, 
            String compareStop,String compareDays);
  }

    
    
    
    
    
    
    

    
    

