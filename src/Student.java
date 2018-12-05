public class Student {
    // 学号、姓名、性别、生日、所在学院、班级
    private String number, name, birthday, college, Class, city, password;
    private boolean sex;
    private Integer cityNumber;

    Student(String number, String name, boolean sex, String birthday, String college, String Class, String city) {
        this.number = number;
        this.name = name;
        this.sex = sex;//true male, false famale
        this.birthday = birthday;
        this.college = college;
        this.Class = Class;
        this.city = city;
        this.password = "";
        this.cityNumber = 0;
    }

    public String showAsSQL() {
        return "(\"" + number + "\",\"" +
                name + "\"," +
                (sex ? 1 : 0) + ",\"" +
                birthday + "\",\"" +
                college + "\",\"" +
                Class + "\",\"" +
                city + "\",\"" +
                password +"\",\"" +
                cityNumber +
                "\")";
    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", college='" + college + '\'' +
                ", Class='" + Class + '\'' +
                ", city='" + city + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + (sex ? "male" : "famale") +
                ", cityNumber=" + cityNumber +
                '}';
    }

    //todo getter
    public String getName() {
        return name;
    }

    public String getclass() {
        return Class;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCollege() {
        return college;
    }

    public String getNumber() {
        return number;
    }

    public Integer getCityNumber() {
        return cityNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public boolean isSex() {
        return sex;
    }

    //todo setter
    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setClass(String aClass) {
        Class = aClass;
    }

    public void setCollege(String college) {
        this.college = college;
    }


    public void setCityNumber(Integer cityNumber) {
        this.cityNumber = cityNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
