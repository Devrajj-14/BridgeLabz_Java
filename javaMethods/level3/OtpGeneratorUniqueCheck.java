package javaMethods.level3;

public class OtpGeneratorUniqueCheck {

    public static int generateOtp() {
        // generates 6 digit otp from 100000 to 999999
        return 100000 + (int) (Math.random() * 900000);
    }

    public static boolean allUnique(int[] otps) {
        // nested loop to check duplicates
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];

        // generate 10 otps
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOtp();
            System.out.println(otps[i]);
        }

        boolean unique = allUnique(otps);

        if (unique) {
            System.out.println("all otp are unique");
        } else {
            System.out.println("duplicate otp found");
        }
    }
}
