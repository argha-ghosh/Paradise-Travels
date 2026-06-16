package LogIn;
import java.util.Scanner;
import java.io.*;

public class UserInformation {
    public static int checkUser(String uname, String upass, String fname) {
        int status = 0;
        try {
            Scanner sc = new Scanner(new File(fname));
            
            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                String cols[] = row.split(";");
                String name = cols[0];
                String pass = cols[6];

                if (uname.equals(name) && upass.equals(pass)) {
                    status = 1;
                    break;
                } else if (uname.equals(name) && !upass.equals(pass)) {
                    status = 2;
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot Read From File");
        }
        return status;
    }

     public static boolean registerUser(String firstName, String lastName, String birthDate, String mobileNumber, String email, String nidNumber, String password, String fname) {
        String userInfo = firstName + ";" + lastName + ";" + birthDate + ";" + mobileNumber + ";" + email + ";" + nidNumber + ";" + password;
        
        if (checkUser(firstName, password, fname) == 0) {
            writeInFile(userInfo, fname, true);
            return true;
        }
        
        return false;
    }


    public static void writeInFile(String userInfo, String fname, boolean append) {
        try {
            FileWriter fw = new FileWriter(new File(fname), append);
            fw.write(userInfo + "\n");
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot Read From File");
        } catch (Exception e) {
            System.out.println("Cannot Read From File");
        }
    }


     public static String getUsername(String fname) {
        String username = "";
        try {
            Scanner sc = new Scanner(new File(fname));

            if (sc.hasNextLine()) {
                String row = sc.nextLine();
                String cols[] = row.split(";");
                username = cols[0];
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot Read From File");
        }
        return username;
    }

     public static String getPassword(String fname) {
        String password = "";
        try {
            Scanner sc = new Scanner(new File(fname));

            if (sc.hasNextLine()) {
                String row = sc.nextLine();
                String cols[] = row.split(";");
                password = cols[1];
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot Read From File");
        }
        return password;
    }

}
