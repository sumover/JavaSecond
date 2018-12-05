import java.util.Arrays;
import java.util.Scanner;

class Idcard implements Comparable<Idcard> {
    String number;
    int year, mouth, day;

    @Override
    public String toString() {
        return "[" +
                "number=" + number +
                ", year=" + year +
                ", mouth=" + mouth +
                ", day=" + day +
                ']';
    }

    @Override
    public int compareTo(Idcard o) {
        if (year != o.year) return year < o.year ? -1 : 1;
        else if (mouth != o.mouth) return mouth < o.mouth ? -1 : 1;
        else if (day != o.day) return day < o.day ? -1 : 1;
        return 0;
    }

    Idcard(String number) {
        this.number = number;
        this.year = (number.charAt(6) - '0') * 1000 + (number.charAt(7) - '0') * 100 +
                (number.charAt(8) - '0') * 10 + number.charAt(9) - '0';
        this.mouth = (number.charAt(10) - '0') * 10 + number.charAt(11) - '0';
        this.day = (number.charAt(12) - '0') * 10 + number.charAt(13) - '0';
    }

    String show1() {
        return Integer.toString(year) + "-" +
                (mouth > 10 ? Integer.toString(mouth) : "0" + Integer.toString(mouth)) + "-" +
                (day > 10 ? Integer.toString(day) : "0" + Integer.toString(day));
    }

    String show2() {
        return number;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Idcard[] idcards = new Idcard[scanner.nextInt()];
        scanner.nextLine();
        for (int i = 0; i < idcards.length; ++i)
            idcards[i] = new Idcard(scanner.nextLine());
        String line;
        Arrays.sort(idcards);
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equals("sort1")) {
                for (Idcard idcard : idcards)
                    System.out.println(idcard.show1());
            } else if (line.equals("sort2")) {
                for (Idcard idcard : idcards)
                    System.out.println(idcard.show2());
            } else break;
        }
    }
}
