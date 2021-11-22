import java.awt.*;
import java.util.*;

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
            for (int i =0; i<lista.size(); i++) {
                if (cardHashMap.containsKey(lista.get(i).logIn)) {
                    lista.get(i).checkBalance();
                }
            }
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
                        lookingForACard();
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
        Random numer = new Random();
        int cardNumber = numer.nextInt(9000000)+999999;
        int cvcCode = numer.nextInt(900)+99;
        Card card1 = new Card(logIn,cardNumber,name + " " + lastName, cvcCode,"VISA", 2025,500,100);
        lista.add(card1);
        startProgramm();
    }

    void lookingForACard(){

            for (int i =0; i<lista.size(); i++){
                if (cardHashMap.containsKey(lista.get(i).logIn)) {
                    showCardInfo(lista.get(i));
                }else{
                    System.out.println("Karta nie istnieje");
                }
            }
    }

    void lookingCardBalance(){

        for (int i =0; i<lista.size(); i++){
            if (cardHashMap.containsKey(lista.get(i).logIn)) {
                showCardInfo(lista.get(i));
            }else{
                System.out.println("Karta nie istnieje");
            }
        }
    }


}

