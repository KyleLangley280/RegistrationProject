/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package langleyproject1;

/**
 *
 * @author JSU2
 */
public class Online extends Course {
    private String name,crn_number,course_number,section_number,credit_hours,start,stop,days,location,type,instructor;
    
    public Online (String newName, String newCRN, String newCN, String newSN, String newCredHours,  String newType, String newInstructor){
        super(newName,newCRN,newCN,newSN,newCredHours,newType,newInstructor);
        
        this.name = newName;
        this.crn_number = newCRN;
        this.course_number = newCN.replaceAll(" ","");
        this.section_number = newSN;
        this.credit_hours = newCredHours;
        this.type = newType;
        this.instructor = newInstructor;
}
    @Override
    public String toString(){
        return ("#" + crn_number + ": " + course_number + "-" + section_number 
                + " ( " + name + " ), " + instructor + ", " + type + ", WorldWideWeb");
    }
    
    
    public String getName() {
        return this.name;
    }


    @Override
    public String getCrn_number() {
        return this.crn_number;
    }



    @Override
    public String getCourse_number() {
        return this.course_number;
    }



    @Override
    public String getSection_number() {
        return this.section_number;
    }


    @Override
    public String getCredit_hours() {
        return this.credit_hours;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getInstructor() {
        return this.instructor;
    }
    //online conflicts with which basically does nothing
    @Override
    public boolean conflictsWith(String compareStart, String compareStop, String compareDays) {
        return false;
    }
}









