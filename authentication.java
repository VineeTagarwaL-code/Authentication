import java.util.*;

public class authentication {
    public static void main(String[] args) throws InterruptedException {
        // class for generating the keypad
        createMatrix keypad = new createMatrix();
        user user = new user();
        user newUser;
        String userNameUser = "", pinUser = "";

        int input;
        try (Scanner sc = new Scanner(System.in)) {
            int tries = 0;
            boolean isloggedIn = false;

            do {
                System.out.println();
                System.out.println("Press 1 for creating an account  ");
                System.out.println("Press 2 for updating your account  ");
                System.out.println("Press 3 for loggining in your account  ");
                System.out.println("Press 4 for deleting your account ");
                System.out.println("Press 5 for logging out  ");
                System.out.println("Press 6 for exiting ");
                System.out.println();
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
                                sc.nextLine();
                                System.out.println("press 1 for updating username");
                                System.out.println("press 2 for updating pin");
                                System.out.println("press 3 for updating both");
                                System.out.println("enter your choice");
                                int choice = sc.nextInt();
                                switch (choice) {
                                    case 1: {
                                        sc.nextLine();
                                        System.out.println("Enter Your New UserName : ");
                                        String newUserName = sc.nextLine();
                                        if (user.updateUserName(newUserName, userNameUser)) {
                                            System.out.println("updated Succesfully!");
                                            break;
                                        } else {
                                            System.out.println("error");
                                        }
                                        break;
                                    }
                                    case 2: {
                                        int pin = 0;
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

                                        if (user.updatePass(Pin, userNameUser)) {
                                            System.out.println();
                                            System.out.println("Pin Updated Successfully !");
                                            System.out.println();
                                        } else {
                                            System.out.println();
                                            System.out.println("error while updating password");
                                            System.out.println();
                                        }

                                        break;
                                    }
                                    case 3: {

                                        sc.nextLine();
                                        System.out.println("Enter Your New UserName : ");
                                        String newUserName = sc.nextLine();
                                        int pin = 0;
                                        System.out.println();
                                        System.out.println("Use Row and Columm wise indexes for using keypad ! ");
                                        System.out.println("Enter your new pin ! ");
                                        System.out.println();
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

                                        if (user.updateBoth(userNameUser , pinUser , newUserName , Pin)) {
                                            System.out.println("updated Succesfully!");
                                            break;
                                        } else {
                                            System.out.println("error");
                                        }

                                        break;
                                    }
                                }
                            } else{
                                System.out.println();
                                System.out.println("Please login into your Account to update ");
                                System.out.println();
                            }
                        }else {
                                System.out.println();
                                System.out.println("Please Login First , choose option (3)");
                                System.out.println();
                                break;
                            }
                        break;

                    }
                    case 3: {
                        if(!isloggedIn){
                             System.out.println();
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
                                 System.out.println();
                                System.out.println(3 - tries + " tries's left !");
                                System.out.println();
                                tries++;
                            } while (tries != 3);
                            if (!isloggedIn) {
                                 System.out.println();
                                System.out.println("Retry Later !: ");
                                System.out.println();
                            }

                        } else {
                             System.out.println();
                            System.out.println("no such user exists");
                            System.out.println();
                        }

                        break;
                           
                        }else{
                            System.out.println();
                            System.out.println("Please Logout "+userNameUser+"'s account first ");
                            break;
                        }
                        
                    }
                    case 4: {
                        if(isloggedIn){
                            System.out.println("Are You Sure ? The Action is not irrovacable !");
                            System.out.println("(y/n)");
                            char ch = sc.next().charAt(0);

                            if(ch =='y'){
                                if(user.deleteUser(userNameUser)){
                                    System.out.println("User deleted Successfully !");
                                    break;
                                }
                            }else{
                                System.out.println("Thank You For Staying With Us !");
                                break;
                            }
                        }
                        else{
                            System.out.println();
                            System.out.println("Please Login first");
                            break;
                        }

                        break;
                    }
                    case 5: {
                        isloggedIn=false;
                        System.out.println("Logged out successfully !");
                        System.out.println();
                        break;
                    }
                    case 6: {
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

}
