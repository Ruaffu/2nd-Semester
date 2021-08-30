import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Dialog dialog = new Dansk();
        System.out.println(dialog.welcome());

        while (true) {
            dialog = changeLanguage(dialog, getInput("select language da/eng"));

            System.out.println(dialog.welcome());

           if(getInput(dialog.quit()).equals('q')){
               break;
           }
        }
    }

    public static Dialog changeLanguage(Dialog dialog, String language){

        if (language.equals("da")){
            return new Dansk();
        }
        if (language.equals("eng")){
            return new English();
        }
        return dialog;
    }

    public static String getInput(String s){
        System.out.println(s +" : ");

        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
