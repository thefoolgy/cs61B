public class HelloNumbers {
    public static void main(String[] args) {
        int x = 1;
	int a = 0;;
        while (x < 11) {
            System.out.print(a + " ");
            a = x + a;
	    x += 1;
        }
    }
}
