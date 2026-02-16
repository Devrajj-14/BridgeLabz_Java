static void method1() {
    int x = 10 / 0; // ArithmeticException
    System.out.println(x);
}

static void method2() {
    method1(); // exception propagates to caller
}

public static void main(String[] args) {
    try {
        method2();
    } catch (ArithmeticException e) {
        System.out.println("Handled exception in main");
    }
}
