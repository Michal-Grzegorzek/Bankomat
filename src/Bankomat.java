import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bankomat {

        boolean isPoweredOn = false;
        int moneyCount = 900;
        //HashMap<String, Integer> cardHashMap = new HashMap();
        ArrayList<Card> lista = new ArrayList<>();

        Map<String, String>  cardHashMap = new HashMap<String, String>();
        Card mUserCard;

        void pushMoney() {
            mUserCard.pushMoney();
            showMainMenu();
        }

        void getAllCards() {

        }

        void setCurrentCard() {

        }

        void getMoney() {
//        System.out.println("How much money do you want to get?");
//        Scanner sc = new Scanner(System.in);
//        int line = 0;
//        if (sc.hasNextInt()) {
//            line = sc.nextInt();
//            if (line > moneyCount) {
//                System.out.println("Sorry! It is very cheap ATM. We dont have enough money.");
//                line = 0;
//                System.out.println("Current balance: " + moneyCount + "\n" + "Removed money: " + line);
//            } else {
//                moneyCount = moneyCount - line;
//                System.out.println("Current balance: " + moneyCount + "\n" + "Removed money: " + line);
//            }
//        } else {
//            System.out.println("Enter a number for getting money");
//        }
            mUserCard.getMoney();
            showMainMenu();
        }

        void showMainMenu() {
            System.out.println("\n" + "Choose what do you want:" + "\n"
                    + "1. Get money" + "\n"
                    + "2. Push money" + "\n"
                    + "3. Show balance" + "\n"
                    + "4. Show info about card" + "\n"
                    + "5. Exit");
        }

        void showBalance() {
            mUserCard.checkBalance();
            showMainMenu();
        }

        boolean checkPassword() {
            System.out.println("Please enter your login: ");
            Scanner scLog = new Scanner(System.in);
            String login = scLog.nextLine();
            System.out.println("Please enter your password: ");
            Scanner scPas = new Scanner(System.in);
            String password = scPas.nextLine();

            try{
                if (cardHashMap.get(login).equals(password)) {
                    System.out.println("Udało się");
                    return true;
                } else {
                    System.out.println("Wrong password or login");
                    return false;
                }
            }catch (NullPointerException e){
                System.out.println("Wrong password or login");
                return false;
            }
        }

        void startProgramm() {
            System.out.println("\n" + "Choose what do you want:" + "\n"
                    + "1. Create a new bank card " + "\n"
                    + "2. Log in");
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            if (option.contains("1")) {
                System.out.println("Creating your new bank card...");
                createNewCard();
            } else if (option.contains("2")) {
            boolean incorrectPas = true;
            while (incorrectPas) {
                incorrectPas = !checkPassword();
            }

            showMainMenu();
            while (isPoweredOn == true) {
                Scanner sc = new Scanner(System.in);
                String line = sc.nextLine();
                switch (line) {
                    case "1":
                        getMoney();
                        break;
                    case "2":
                        pushMoney();
                        break;
                    case "3":
                        showBalance();
                        break;
                    case "4":
                        showCardInfo(lista.get(0));
                        break;
                    case "5":
                        toglePower();
                        break;
                    default:
                        System.out.println("Choose correct action");
                        showMainMenu();
                }
            }
        } else {
                System.out.println("Invalid value");
                startProgramm();
            }
        }
        void showCardInfo(Card card){
            card.showCardInfo();
            showMainMenu();
        }

        void toglePower() {
            if (isPoweredOn == false) {
                isPoweredOn = true;
                System.out.println("Hi! ATM  is on and ready to work.");
                startProgramm();
            } else {
                isPoweredOn = false;
            }
        }

        void start() {
            toglePower();
        }

    void createNewCard(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name:");
        String name = scanner.nextLine();
        System.out.println("Enter the last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter your log in:");
        String logIn = scanner.nextLine();
        System.out.println("Enter your four-digit pin number:");
        String pin = scanner.nextLine();
        cardHashMap.put(logIn,pin);
        String nazwa = logIn;
        Card card1 = new Card(logIn,1232112,name + " " + lastName, 123,"Visa?", 2025,500,100);
        lista.add(card1);
        System.out.println(cardHashMap.get(logIn));
        System.out.println(lista.get(0).logIn);
        if (cardHashMap.get(logIn).equals(lista.get(0).logIn)) {
            System.out.println("Udało się");
        }
        startProgramm();
    }

    void szukanieKartyPoLoginie(){

        System.out.println(cardHashMap.get(0));
        System.out.println(lista.get(0));
    }


}

