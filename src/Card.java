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
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();



            balance = balance + number;
            System.out.println("Transaction completed!");
            System.out.println("Current balance: " + balance + "\n" + "Added money: " + number);
        } else {
            System.out.println("Enter a number for pushing money");
        }

    }

    void getMoney() {
        int bankNote200;
        int bankNote100;
        int bankNote50;
        int bankNote20;
        int bankNote10;
        Scanner scanner = new Scanner(System.in);
            System.out.println("How much money do you want to get?");
            int number;
            int sumMoney = creditLim + balance;
            if (scanner.hasNext()) {
                number = scanner.nextInt();
                if (sumMoney < number) {
                    System.out.println("You don't have enough money!");
                    System.out.println("Your balance: " + "\n" + balance);
                    System.out.println("Your credit limit: " + "\n" + creditLim);
                } else if (sumMoney>number) {



                    if (number%10!=0) {
                        System.out.println("The ATM only withdraws cash in 200, 100, 50 and 20 banknotes.");
                        System.out.println("Please enter a valid value.");

                    } else if (number / 200 > 0) {
                        bankNote200 = number / 200;
                        int number2 = number - (200 * bankNote200);
                        System.out.println("A 200 euro banknote has been withdrawn - " + bankNote200 + " pcs.");

                        if (number2 / 100 > 0) {
                            bankNote100 = number2 / 100;
                            int number3 = number2 - (100 * bankNote100);
                            System.out.println("A 100 euro banknote has been withdrawn - " + bankNote100 + " pcs.");

                            if (number3 / 50 > 0) {
                                bankNote50 = number3 / 50;
                                int number4 = number3 - (50 * bankNote50);
                                System.out.println("A 50 euro banknote has been withdrawn - " + bankNote50 + " pcs.");

                                if (number4 / 20 > 0) {
                                    bankNote20 = number4 / 20;
                                    int number5 = number4 - (20 * bankNote20);
                                    System.out.println("A 20 euro banknote has been withdrawn - " + bankNote20 + " pcs.");

                                    if (number5/10>0 ){
                                        bankNote10=number5/10;
                                        System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                                    }
                                } else if(number4/10>0){
                                    bankNote10=number4/10;
                                    System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                                }

                            } else if(number3 / 20 > 0) {
                                bankNote20 = number3 / 20;
                                int number4 = number3 - (20 * bankNote20);
                                System.out.println("A 20 euro banknote has been withdrawn - " + bankNote20 + " pcs.");

                                if(number4/10>0) {
                                    bankNote10=number4/10;
                                    System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                                }

                            } else if (number3/10>0) {
                                bankNote10=number3/10;
                                System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                            }
                        } else if (number2 / 50 > 0) {
                            bankNote50 = number2 / 50;
                            int number4 = number2 - (50 * bankNote50);
                            System.out.println("A 50 euro banknote has been withdrawn - " + bankNote50 + " pcs.");

                            if (number4 / 20 > 0) {
                                bankNote20 = number4 / 20;
                                int number5 = number4 - (20 * bankNote20);
                                System.out.println("A 20 euro banknote has been withdrawn - " + bankNote20 + " pcs.");

                                if(number5/10>0) {
                                    bankNote10=number5/10;
                                    System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                                }

                            }
                            else if (number4/10>0) {
                                bankNote10=number4/10;
                                System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                            }
                        } else if (number2 / 20 > 0) {
                            bankNote20 = number2 / 20;
                            int number3 = number2 - (20* bankNote20);
                            System.out.println("A 20 euro banknote has been withdrawn - " + bankNote20 + " pcs.");

                            if(number3/10>0) {
                                bankNote10=number3/10;
                                System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                            }

                        } else if(number2/10>0) {
                            bankNote10=number2/10;
                            System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                        }
                    }else if (number / 100 > 0) {
                        bankNote100 = number / 100;
                        int number3 = number - (100 * bankNote100);
                        System.out.println("A 100 euro banknote has been withdrawn - " + bankNote100 + " pcs.");

                        if (number3 / 50 > 0) {
                            bankNote50 = number3 / 50;
                            int number4 = number3 - (50 * bankNote50);
                            System.out.println("A 50 euro banknote has been withdrawn - " + bankNote50 + " pcs.");

                            if (number4 / 20 > 0) {
                                bankNote20 = number4 / 20;
                                int number5 = number4 - (20 * bankNote20);
                                System.out.println("A 20 euro banknote has been withdrawn - " + bankNote20 + " pcs.");

                                if (number5/10>0 ){
                                    bankNote10=number5/10;
                                    System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                                }

                            } else if(number4/10>0 ){
                                bankNote10=number4/10;
                                System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                            }
                        } else if(number3 / 20 > 0) {
                            bankNote20 = number3 / 20;
                            int number4 = number3 - (20 * bankNote20);
                            System.out.println("A 20 euro banknote has been withdrawn - " + bankNote20 + " pcs.");

                            if(number4/10>0){
                                bankNote10 = number4/10;
                                System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                            }

                        } else if (number3/10>0){
                            bankNote10 = number3/10;
                            System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                        }
                    } else if (number / 50 > 0) {
                        bankNote50 = number / 50;
                        int number4 = number - (50 * bankNote50);
                        System.out.println("A 50 euro banknote has been withdrawn - " + bankNote50 + " pcs.");

                        if (number4 / 20 > 0) {
                            bankNote20 = number4 / 20;
                            int number5 = number4 - (20 * bankNote20);
                            System.out.println("A 20 euro banknote has been withdrawn - " + bankNote20 + " pcs.");

                            if(number5/10>0){
                                bankNote10 = number5/10;
                                System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                            }

                        } else if (number4/10>0) {
                            bankNote10 = number4/10;
                            System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                        }
                    } else if (number / 20 > 0) {
                        bankNote20 = number / 20;
                        int number1 = number - (20*bankNote20);
                        System.out.println("A 20 euro banknote has been withdrawn - " + bankNote20 + " pcs.");

                        if(number1/10>0){
                            bankNote10 = number1/10;
                            System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                        }

                    } else if (number/10>0) {
                        bankNote10 = number/10;
                        System.out.println("A 10 euro banknote has been withdrawn - " + bankNote10 + " pcs.");
                    }

                    if(number%10!=0){
                        getMoney();
                    } else {
                        balance = balance - number;
                        if (balance < 0) {
                            creditLim = creditLim + balance;
                            balance = 0;
                        }
                        System.out.println("Your balance: " + balance);
                        System.out.println("Your credit limit: " + creditLim);

                    }

                }
            } else {
                System.out.println("Enter a number for getting money");
            }
    }

    void checkBalance() {
        System.out.println("Current positive balance: " + balance
                + "\n" + "Credit limit: " + creditLim);
    }
}
