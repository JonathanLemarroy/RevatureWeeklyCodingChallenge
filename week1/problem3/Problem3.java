package week1.problem3;

public class Problem3 {
    public static void main(String[] args) {

        System.out.println("Problem 3");
        args = new String[] { "PROCESSOR", "QUADRANT" }; // Used to test code without command line arguments.

        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " encoded: ");
            StringBuilder output = new StringBuilder();
            for (int j = 0; j < args[i].length(); j++) {
                int num = 1;
                char letter = args[i].charAt(j);
                if (Character.isLetter(letter)) {
                    if (Character.isUpperCase(letter)) {
                        int tempNum = num;
                        char tempLetter = (char)(letter - 'A' + 1);
                        if (j % 2 != 0) {
                            for (int k = 2; k < 10; k++) {
                                if ((letter - 'A' + 1) % k == 0) {
                                    if (Math.abs(k - ((letter - 'A' + 1) / k)) < Math.abs(tempNum - tempLetter)) {
                                        tempNum = k;
                                        tempLetter = (char) ((letter - 'A' + 1) / k);
                                    }
                                }
                            }
                        }
                        else{
                            for (int k = 9; k > 1; k--) {
                                if ((letter - 'A' + 1) % k == 0) {
                                    if (Math.abs(k - ((letter - 'A' + 1) / k)) < Math.abs(tempNum - tempLetter)) {
                                        tempNum = k;
                                        tempLetter = (char) ((letter - 'A' + 1) / k);
                                    }
                                }
                            }
                        }
                        if(Math.abs(tempNum - tempLetter) != Math.abs(num - (letter - 'A' + 1))){
                            num = tempNum;
                            letter = (char) (tempLetter + 'A' - 1);
                        }
                    } else {
                        int tempNum = num;
                        char tempLetter = (char)(letter - 'a' + 1);
                        if (j % 2 != 0) {
                            for (int k = 2; k < 10; k++) {
                                if ((letter - 'a' + 1) % k == 0) {
                                    if (Math.abs(k - ((letter - 'a' + 1) / k)) < Math.abs(tempNum - tempLetter)) {
                                        tempNum = k;
                                        tempLetter = (char) ((letter - 'a' + 1) / k);
                                    }
                                }
                            }
                        }
                        else{
                            for (int k = 9; k > 1; k--) {
                                if ((letter - 'a' + 1) % k == 0) {
                                    if (Math.abs(k - ((letter - 'a' + 1) / k)) < Math.abs(tempNum - tempLetter)) {
                                        tempNum = k;
                                        tempLetter = (char) ((letter - 'a' + 1) / k);
                                    }
                                }
                            }
                        }
                        if(Math.abs(tempNum - tempLetter) != Math.abs(num - (letter - 'a' + 1))){
                            num = tempNum;
                            letter = (char) (tempLetter + 'a' - 1);
                        }
                    }
                }
                output.append(letter);
                if (Character.isLetter(letter)) {
                    output.append(num);
                }
            }
            System.out.println(output);
        }
    }
}
