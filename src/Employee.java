public class Employee {

    private BasicInfo info;
    private GenerateID ID;
    private HoursAndSalary sal;

    public Employee(BasicInfo in) {

        info = in;
        ID = new GenerateID(info.getDepartment());


    }

    public void setInfo(BasicInfo in) {

        info = in;

    }

    public void setID(GenerateID i) {

        ID = i;

    }

    public BasicInfo getInfo() {

        return info;

    }

    public GenerateID getID() {

        return ID;

    }

    public String toString() {

        return (info + "\n\nID: " + ID.getID() + " | PN: " + ID.getPositionNumber());

    }

}
