public class Main {

    public static void main(String[] args) {
        int asu = 12;
        System.out.println(addTwoDigits(asu));
    }

    static int addTwoDigits(int n) {
        return Integer.parseInt(String.valueOf(String.valueOf(n).charAt(0))) + Integer.parseInt(String.valueOf(String.valueOf(n).charAt(1)));
    }


}
