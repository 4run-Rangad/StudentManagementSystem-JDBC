import dao.StudentDAO;
import model.Student;

public class Main {
    public static void main(String[] args){
       StudentDAO dao = new StudentDAO();
       Student s1 = new Student("Rahul" , "rahul@gmail.com", "MCA", 85);
       Student s2 = new Student("Ajay" , "ajay@gmail.com", "MCA", 79);
       dao.addStudent(s2);

    }
}
