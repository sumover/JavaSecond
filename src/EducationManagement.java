import java.sql.*;
        import java.util.Iterator;
        import java.util.LinkedList;
        import java.util.List;


public class EducationManagement {
    private static final String DB_URL, USER, PASSWORD, JDBC_DRIVER;

    /*
     * table value
     * number ,name,sex,birthday,college,class,city,city_number
     * todo 我可不去他妈的吧
     */
    static {
        JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        /*
         * TODO qtmd 那个url需要特殊设置
         *todo jdbc:mysql://localhost:3306/educationmanagement?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false
         */
        DB_URL = "jdbc:mysql://localhost:3306/educationmanagement?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        USER = "root";
        PASSWORD = "2323180";
    }

    private Connection connection;
    private Statement statement;

    EducationManagement() {
        this.connection = null;
        this.statement = null;
        try {
            // TODO: 2018/12/5 connect to MySQL
            Class.forName(JDBC_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            this.statement = connection.createStatement();
            System.out.println("SUCCESS TO LOGIN TO MySQL!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getStudentByNo(String sno) {
        Student student = null;
        try {
            ResultSet resultSet = statement.executeQuery("select * from educationmanagement.student where number=" + sno);
            resultSet.next();
            student = new Student(
                    resultSet.getString("number"),
                    resultSet.getString("name"),
                    resultSet.getBoolean("sex"),
                    resultSet.getString("birthday"),
                    resultSet.getString("college"),
                    resultSet.getString("class"),
                    resultSet.getString("city")
            );
            student.setPassword(resultSet.getString("password"));
            student.setCityNumber(resultSet.getInt("city_number"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void setPassword(String number, String password) {
        try {
            statement.execute(
                    "update educationmanagement . student set password = \"" + password +
                            "\"where number = \"" + number + "\";"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudents(List<Student> students) {
        Iterator iterator = students.iterator();
        while (iterator.hasNext()) {
            try {
                statement.execute(
                        "insert into student (number, name, sex, birthday, college, class, city, password, city_number)" +
                                "values " + ((Student) iterator.next()).showAsSQL() + ";"
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteStudent(String number) {
        try {
            statement.execute("delete from educationmanagement.student where number=\"" + number + "\";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudentByCity(String City) {
        List<Student> students = new LinkedList<Student>();
        try {
            ResultSet resultSet = statement.executeQuery(
                    "select * from educationmanagement.student where city=\"" + City + "\";"
            );
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getString("number"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("sex"),
                        resultSet.getString("birthday"),
                        resultSet.getString("college"),
                        resultSet.getString("class"),
                        resultSet.getString("city"));
                student.setPassword(resultSet.getString("password"));

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public void close() {
        try {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
            System.out.println("EXIT!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}