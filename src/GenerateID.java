import java.util.Random;

public class GenerateID {

    private Random rand = new Random();
    private String ID = null;
    private String positionNumber = null;
    private String department;

    public GenerateID(String d) {

        ID = String.format("%04d", rand.nextInt(1001));
        department = d;
        positionNumber = String.format("%s-%04d", department.substring(0, 2).toUpperCase(), rand.nextInt(1001));

    }

    public String getID() {

        return ID;

    }

    public String getPositionNumber() {

        return positionNumber;

    }

}
