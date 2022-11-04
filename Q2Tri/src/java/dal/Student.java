
package dal;

import java.sql.Date;
import java.util.ArrayList;

public class Student extends DBContext{
    public int sid;
    public String name;
    public boolean gender;
    public Date dob;

    public Student(int sid, String name, boolean gender, Date dob) {
        this.sid = sid;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public Student() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    
}
