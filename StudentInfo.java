public class StudentInfo {
    private String IDNumber, firstName, lastName, courseName;
    private int Tuition, Misc;
    public String[] studentType = {"Discounted", "Walk-in", "Continuing"};


    public void studentData(String IDNum, String fName, String lName, String[] studType, String course) {
        IDNum = IDNumber;
        fName = firstName;
        lName = lastName;
        studType = studentType;
        course = courseName;
    }

    public int getTuition() {
        return Tuition;
    }
    public int getMisc() {
        return Misc;
    }
    
    public double getGoldDisc() {
        return (Tuition+Misc) - (.50*(Tuition+Misc));
    }

    public double getBlueDisc() {
        return (Tuition+Misc) - (.30*(Tuition+Misc));
    }

    public double getWhiteDisc() {
        return (Tuition+Misc) - (.10*(Tuition+Misc));
    }

    public double getContDisc() {
        return (Tuition+Misc) - (.10*(Tuition));
    }

    public void setTourism() {
        this.Tuition = 10000;
        this.Misc = 22500;
    }
    
    public void setComputerScience() {
        this.Tuition = 20000;
        this.Misc = 11000;
    }
    
    public void setEngineering() {
        this.Tuition = 30000;
        this.Misc = 25000;
    }
    
    public void setNursing() {
        this.Tuition = 15000;
        this.Misc = 15000;
    }
    
    public void setArchitecture() {
        this.Tuition = 25000;
        this.Misc = 23000;
    }

    
}


