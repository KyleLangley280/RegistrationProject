/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package langleyproject1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.MINUTES;

/**
 *
 * @author JSU2
 */
public class Traditional extends Course{
    
    private String name,crn_number,course_number,section_number,credit_hours,start,stop,days,location,type,instructor;
    
    public Traditional (String newName, String newCRN, String newCN, String newSN, String newCredHours, String newStart, String newStop, String newDays, String newLocation, String newType, String newInstructor){
        super(newName,newCRN,newCN,newSN,newCredHours,newType,newInstructor);
        
        this.name = newName;
        this.crn_number = newCRN;
        this.course_number = newCN.replaceAll(" ","");
        this.section_number = newSN;
        this.credit_hours = newCredHours;
        this.start = newStart;
        this.stop = newStop;
        this.days = newDays;
        this.location = newLocation;
        this.type = newType;
        this.instructor = newInstructor;
    }
    
    //toString method to be able to print the classes
    @Override
    public String toString(){
        return ("#" + crn_number + ": " + course_number + "-" + section_number +
                " ( " + name + " ), " + instructor + ", " + type + ", " + start 
                + "-" + stop + ", " + days + ", " + location);
    }
    
    @Override
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
    public String getStart() {
        return this.start;
    }

 

    @Override
    public String getStop() {
        return this.stop;
    }


    @Override
    public String getDays() {
        return this.days;
    }



    @Override
    public String getLocation() {
        return this.location;
    }


    @Override
    public String getType() {
        return this.type;
    }



    @Override
    public String getInstructor() {
        return this.instructor;
    }

    @Override
    public boolean conflictsWith(String compareStart, String compareStop, String compareDays) {
        
        LocalTime firstStart = formatLocalTime(this.start);
        LocalTime firstStop = formatLocalTime(this.stop);
        LocalTime secondStart = formatLocalTime(compareStart);
        LocalTime secondStop = formatLocalTime(compareStop);
        
        boolean equalDays = false;
        
        for (String i : this.days.split("")) { //If days overlap
            
            for (String j : compareDays.split("")) {
                if (i.equals(j)) {
                    equalDays = true;
                }
            }
        }
        LocalTime usefulStopTime = firstStop.plus(15, MINUTES);
        LocalTime usefulCompareStopTime = secondStop.plus(15, MINUTES);
        
        //15 minute addition to have time to get to class
        boolean conflicts = false;
        if (equalDays) { //If times overlap
            if ((firstStart.isAfter(usefulCompareStopTime)) || 
                    (firstStart.equals(usefulCompareStopTime)) || 
                    (secondStart.isAfter(usefulStopTime)) || 
                    (secondStart.equals(usefulStopTime))) {
                
                
            }
            
            else {
                conflicts = true;
            }
            
        }
        
        return conflicts;   
    }

    public LocalTime formatLocalTime(String time) {
        LocalTime returnValue;
        
        DateTimeFormatter doubleHours= DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter singleHours= DateTimeFormatter.ofPattern("H:mm");
        
        if (time.split("").length == 4) {
            returnValue = LocalTime.parse(time, singleHours);
        }
        
        else {
            returnValue = LocalTime.parse(time, doubleHours);
        }
        
        return returnValue;
    }
}
