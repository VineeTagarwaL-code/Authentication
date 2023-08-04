import java.util.*;

public class authentication {
    public static void main(String[] args) throws InterruptedException {
        // class for generating the keypad
        createMatrix keypad = new createMatrix();
        user user = new user();
        user newUser;
        String userNameUser = "", pinUser = "";

        int input;
        Scanner sc = new Scanner(System.in);
        int tries = 0;
        boolean isloggedIn = false;

        do {

            System.out.println("Press 1 for creating an account  ");
            System.out.println("Press 2 for updating your account  ");
            System.out.println("Press 3 for loggining in your account  ");
            System.out.println("Press 4 for exiting ");
            System.out.print("Enter your Choice : ");
            input = sc.nextInt();

            switch (input) {
                case 1: {
                    System.out.print("Enter Your UserName : ");
                    sc.nextLine();
                    String userName = sc.nextLine();
                    System.out.print("Enter Your Pin ( should be only of 4 digits) : ");

                    String pass = sc.nextLine();
                    if (pass.length() == 4) {

                        newUser = new user(userName, pass);
                        System.out.println();
                        newUser.successMessage();
                        System.out.println();
                    } else {
                        System.out.println("Pin Should be  of 4 digits  ");

                    }

                    break;
                }
                case 2: {
                    if (isloggedIn) {
                        System.out.println("Account Name :" + userNameUser);
                        System.out.println("Is this Right ? (y/n) :");
                        char ch = sc.next().charAt(0);
                        if (ch == 'y') {
                            System.out.println("press 1 for updating username");
                            System.out.println("press 2 for updating pin");
                            System.out.println("press 1 for updating both");
                            System.out.println("enter your choice");
                            int choice = sc.nextInt();
                            switch (choice) {
                                case 1: {
                                    System.out.println("Enter Your New UserName : ");
                                    String newUserName = sc.nextLine();
                                    if (user.updateUserName(newUserName, userNameUser)) {
                                        System.out.println("updated Succesfully!");
                                        break;
                                    } else {
                                        System.out.println("error");
                                    }

                                }
                                case 2: {
                                    break;
                                }
                                case 3: {
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    break;

                }
                case 3: {
                    System.out.print("Enter Your UserName : ");
                    sc.nextLine();
                    String userName = sc.nextLine();
                    user checkUser = new user();
                    int pin = 0;
                    if (checkUser.userExists(userName)) {
                        do {
                            System.out.println();
                            System.out.println("Use Row and Columm wise indexes for using keypad ! ");

                            for (int i = 0; i < 4; i++) {
                                int arr[][] = keypad.keypad(3, 3);
                                keypad.displayKeypad(arr);
                                System.out.print("\r");

                                System.out.print("Enter Your PIN " + i + "th digit " + " : ");

                                int row = sc.nextInt();
                                int col = sc.nextInt();
                                int pinNo = keypad.returnTheValue(arr, row, col);
                                pin = (pin * 10) + pinNo;
                                System.out.println();
                                System.out.println("PIN:" + pin);
                                System.out.println();
                            }

                            String Pin = String.valueOf(pin);

                            pin = 0;
                            if (user.userAC(userName, Pin)) {
                                userNameUser = userName;
                                pinUser = Pin;
                                isloggedIn = true;
                                System.out.println("Successfully Logged in ! ");
                                break;
                            }
                            System.out.println(3 - tries + " tries's left !");
                            System.out.println();
                            tries++;
                        } while (tries != 3);
                        if (!isloggedIn) {
                            System.out.println("ReTry Late !: ");
                            System.out.println();
                        }

                    } else {
                        System.out.println("no such user exists");
                        System.out.println();
                    }

                    break;
                }
                case 4: {
                    System.out.println("Thank You for choosing our service ! :)");
                    System.out.println();
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid Choice");
                    System.out.println();
            }

        } while (input != 4);

    }

}
