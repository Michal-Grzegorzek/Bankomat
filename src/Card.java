import java.sql.SQLOutput;
import java.util.Scanner;

public class Card {
    final int cardNumber;
    final String owner;
    final int cvcCode;
    final String manufacturer;
    final String logIn;

    int endYear;
    int balance;
    int creditLim;
    int sumMoney = creditLim + balance;
    int moneyCardCount;

    public Card(String logIn, int cardNumber, String owner, int cvcCode, String manufacturer,
                int endYear, int balance, int creditLim) {
        this.logIn = logIn;
        this.cardNumber = cardNumber;
        this.owner = owner;
        this.cvcCode = cvcCode;
        this.manufacturer = manufacturer;
        this.endYear = endYear;
        this.balance = balance;
        this.creditLim = creditLim;
    }

    void showCardInfo() {
        System.out.println("The end of year: " + endYear + "\n"
                + "cardNumber: " + cardNumber + "\n"
                + "owner: " + owner + "\n"
                + "cvc code: " + cvcCode + "\n"
                + "manufacturer: " + manufacturer
        );
    }

    void pushMoney() {
        System.out.println("How much money do you want to push?");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int number = sc.nextInt();
            balance = balance + number;
            System.out.println("Current balance: " + balance + "\n" + "Added money: " + number);
        } else {
            System.out.println("Enter a number for pushing money");
        }

    }

    void getMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your account pin.");
        int pin = scanner.nextInt();
        if(pin==1234){ //pin do ustawienia pod danego klienta
            System.out.println("How much money do you want to get?");
            int number = 0;
            int sumMoney = creditLim + balance;
            if (scanner.hasNext()) {
                number = scanner.nextInt();
                if (sumMoney < number) {
                    System.out.println("You dont have enough money!");
                    System.out.println("Your balance: " + "\n" + balance);
                    System.out.println("Your credit limit: " + "\n" + creditLim);
                } else if (sumMoney>number) {
                    balance = balance - number;
                    if (balance < 0) {
                        creditLim = creditLim + balance;
                        balance = 0;
                    }
                    System.out.println("Your balance: " + balance);
                    System.out.println("Your credit limit: " + creditLim);
                }
            } else {
                System.out.println("Enter a number for getting money");
            }
        }
        else {
            System.out.println("Wrong account pin");
        }
    }

    void checkBalance() {
        System.out.println("Current positive balance: " + balance
                + "\n" + "Credit limit: " + creditLim);
    }

    /*void createNewCard(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name:");
        String name = scanner.nextLine();
        System.out.println("Enter the last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter your four-digit pin number");
        int pin = scanner.nextInt();
    }*/

}
