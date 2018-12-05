import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EducationManagement educationManagement = new EducationManagement();
        System.out.println(educationManagement.getStudentByCity("Eir"));
        educationManagement.close();
    }
}
