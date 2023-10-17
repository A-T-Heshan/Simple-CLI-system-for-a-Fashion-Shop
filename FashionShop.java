import java.util.*;

public class FashionShop {

    final static String[] statusStringArray = {"Proccessing", "Delivering", "Delivered"};
    //------------------T-Shirt Prices---------------------------- 
    static int xsPrice = 600;
    static int sPrice = 800;
    static int mPrice = 900;
    static int lPrice = 1000;
    static int xlPrice = 1100;
    static int xxlPrice = 1200;
    //------------------Object Array-------------------------------
    static Order[] ordersArray = new Order[0];
    //------------------Scanner object-----------------------------
    static Scanner sc = new Scanner(System.in);

    //-----------------Main Method---------------------------------
    public static void main(String[] args) {
        mainMenu();
    }

    //----Show the main menu and navigate which is the next one-----
    public static void mainMenu() {
        while (true) {
            clearConsole();
            System.out.println("""
                                \t/$$$$$$$$                  /$$       /$$                            /$$$$$$  /$$
                               \t| $$_____/                 | $$      |__/                           /$$__  $$| $$
                               \t| $$\t/$$$$$$$  /$$$$$$$ | $$$$$$$  /$$  /$$$$$$$ /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$
                               \t| $$$$$|_____ $$ /$$_____/ | $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$
                               \t| $$__/ /$$$$$$$|  $$$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$
                               \t| $$   /$$__  $$ \\______ $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$
                               \t| $$  |  $$$$$$$ /$$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/
                               \t|__/   \\_______/|________/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/
                                \t                                                                                         \t    | $$
                                 \t                                                                                                 | $$ 
                                 \t                                                                                                 |__/""");
            System.out.printf("%n%s%n%n%n%-50s%s%n%n%-50s%s%n%n%-50s%s%n%n", "\t-----------------------------------------------------------------------------------------------------", "\t\t[1] Place Order", "[2] Search Coustomer", "\t\t[3] Search Order", "[4] View Reports", "\t\t[5] Change Order Status", "[6] Delete Order");
            while (true) {
                System.out.print("\t\tInput Option : ");
                 switch (sc.nextLine()) {
                    case "1":
                        placeOrder();
                        break;
                    case "2":
                        if (FashionShop.ordersArray.length == 0) {
                            emptyDatabaseErrorMessege();
                        } else {
                            searchCoustomer();
                        }
                    case "3":
                        if (FashionShop.ordersArray.length == 0) {
                            emptyDatabaseErrorMessege();
                        } else {
                            searchOrder();
                        }
                    case "4":
                        if (FashionShop.ordersArray.length == 0) {
                            emptyDatabaseErrorMessege();
                        } else {
                            viewReport();
                        }
                    case "5":
                        if (FashionShop.ordersArray.length == 0) {
                            emptyDatabaseErrorMessege();
                        } else {
                            changeOrderStatus();
                        }
                    case "6":
                        if (FashionShop.ordersArray.length == 0) {
                            emptyDatabaseErrorMessege();
                        } else {
                            deleteOrder();
                        }
                        break;
                    default:
                        clearLines(1);

                }
            }
        }
    }

    //--------------Place orders and take inputs--------------------
    public static void placeOrder() {
        String orderId = getNextOrderID();
        clearConsole();
        System.out.println("");
        System.out.println("""
                           \t  _____  _                   ____          _           
                           \t |  __ \\| |                 / __ \\        | |          
                           \t | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __ 
                           \t |  ___/| |/ _` |/ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|
                           \t | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |   
                           \t |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|   """);

        System.out.println(
                "\t_____________________________________________________");
        System.out.printf("%n%s%n%n", "\n\tEnter Order ID : " + orderId);
        phoneNumberLoop:
        while (true) {
            System.out.print("\tEnter Customer Phone Number : ");
            String PhoneNumber = sc.nextLine();
            if (PhoneNumber.matches("0\\d+") && PhoneNumber.length() == 10) {
                System.out.println("");
                while (true) {
                    System.out.print("\tEnter T-Shirt Size(XS/S/M/L/XL/XXL) : ");
                    String tShirtSize = sc.nextLine();
                    if (tShirtSize.equals("S") || tShirtSize.equals("XS") || tShirtSize.equals("M") || tShirtSize.equals("L") || tShirtSize.equals("XL") || tShirtSize.equals("XXL")) {
                        System.out.println("");
                        while (true) {
                            System.out.print("\tEnter QTY : ");
                            String qTYString = sc.nextLine();
                            if (qTYString.matches("\\d+")) {
                                int qty = Integer.valueOf(qTYString);
                                if (qty > 0) {
                                    int amount = 0;
                                    switch (tShirtSize) {
                                        case "XS" ->
                                            amount = xsPrice * qty;
                                        case "S" ->
                                            amount = sPrice * qty;
                                        case "M" ->
                                            amount = mPrice * qty;
                                        case "L" ->
                                            amount = lPrice * qty;
                                        case "XL" ->
                                            amount = xlPrice * qty;
                                        case "XXL" ->
                                            amount = xxlPrice * qty;
                                    }
                                    System.out.printf("%n%s%n%n%n", "\tAmount : " + amount + ".00");
                                    placeOrderLoop:
                                    while (true) {
                                        System.out.print("\tDo you want to place this order ? (Y/N) : ");
                                        String placeOrderYN = sc.nextLine();
                                        switch (placeOrderYN.toLowerCase()) {
                                            case "y" -> {
                                                ordersArray = saveToArray(ordersArray, (getNewObject(orderId, PhoneNumber, tShirtSize, qty, amount, 0)));
                                                System.out.println("\n\t\tOrder Placed...!");
                                                break placeOrderLoop;
                                            }
                                            case "n" -> {
                                                break placeOrderLoop;
                                            }
                                            default ->
                                                clearLines(1);
                                        }
                                    }
                                    System.out.println("");
                                    while (true) {
                                        System.out.print("\tDo you want to place another order ? (Y/N) : ");
                                        String placeAnotherOrderYN = sc.nextLine();
                                        if (placeAnotherOrderYN.equalsIgnoreCase("y")) {
                                            placeOrder();
                                        } else if (placeAnotherOrderYN.equalsIgnoreCase("n")) {
                                            mainMenu();
                                        } else {
                                            clearLines(1);
                                        }
                                    }
                                } else {
                                    clearLines(1);
                                }
                            } else {
                                clearLines(1);
                            }
                        }
                    } else {
                        clearLines(1);
                    }
                }
            } else {
                System.out.printf("%s%n%n", "\n\t\tInvalid Phone Number... Try Again !...");
                while (true) {
                    System.out.print("\tDo you want to try again ?  (Y/N) : ");
                    String phoneNoYN = sc.nextLine();
                    if (phoneNoYN.equalsIgnoreCase("y")) {
                        clearLines(5);
                        continue phoneNumberLoop;
                    } else if (phoneNoYN.equalsIgnoreCase("n")) {
                        mainMenu();
                    } else {
                        clearLines(1);
                    }
                }
            }
        }
    }

    //---------Search Customer using the PhoneNumber----------------
    public static void searchCoustomer() {
        searchCoustomerLoop:
        while (true) {
            clearConsole();
            System.out.println("");
            System.out.println("""
                               \t  _____                     _        _____          _                            
                               \t  / ____|                   | |      / ____|        | |                           
                               \t | (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ 
                               \t  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|
                               \t  ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |   
                               \t |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  """);
            System.out.printf("%s%n%n%n%s", "\t________________________________________________________________________________", "\tEnter customer phone number : ");
            String phoneNum = sc.nextLine();
            if (phoneNum.matches("0\\d+") && phoneNum.length() == 10) {
                boolean isValidNumber = false;
                checkPhoneNumberValidity:
                for (Order order : ordersArray) {
                    if (order.getPhoneNumber().equals(phoneNum)) {
                        isValidNumber = true;
                    }
                }
                int xsTShirtCount = 0;
                int sTShirtCount = 0;
                int mTShirtCount = 0;
                int lTShirtCount = 0;
                int xlTShirtCount = 0;
                int xxlTShirtCount = 0;
                if (isValidNumber == true) {
                    for (Order order : ordersArray) {
                        if (phoneNum.equals(order.getPhoneNumber())) {
                            switch (order.getSize()) {
                                case "XS" ->
                                    xsTShirtCount += order.getQTY();
                                case "S" ->
                                    sTShirtCount += order.getQTY();
                                case "M" ->
                                    mTShirtCount += order.getQTY();
                                case "L" ->
                                    lTShirtCount += order.getQTY();
                                case "XL" ->
                                    xlTShirtCount += order.getQTY();
                                case "XXL" ->
                                    xxlTShirtCount += order.getQTY();
                            }
                        }
                    }
                    String[] tShirtSizesForTable = {"XS", "S", "M", "L", "XL", "XXL"};
                    int[] QTYForTable = {xsTShirtCount, sTShirtCount, mTShirtCount, lTShirtCount, xlTShirtCount, xxlTShirtCount};
                    int[] amountsForTable = {(xsTShirtCount * xsPrice), (sTShirtCount * sPrice), (mTShirtCount * mPrice), (lTShirtCount * lPrice), (xlTShirtCount * xlPrice), (xxlTShirtCount * xxlPrice)};
                    for (int j = 0; j < amountsForTable.length; j++) {
                        for (int i = 0; i < amountsForTable.length - 1; i++) {
                            if (QTYForTable[i] < QTYForTable[i + 1]) {
                                int tempAmount = amountsForTable[i + 1];
                                amountsForTable[i + 1] = amountsForTable[i];
                                amountsForTable[i] = tempAmount;
                                int tempQTY = QTYForTable[i + 1];
                                QTYForTable[i + 1] = QTYForTable[i];
                                QTYForTable[i] = tempQTY;
                                String tempTShirtSize = tShirtSizesForTable[i + 1];
                                tShirtSizesForTable[i + 1] = tShirtSizesForTable[i];
                                tShirtSizesForTable[i] = tempTShirtSize;
                            }
                        }
                    }
                    printSearchCoustomer(tShirtSizesForTable, QTYForTable, amountsForTable);
                    System.out.println("");
                    while (true) {
                        System.out.print("\tDo you want to search another customer report ? (Y/N) : ");
                        String searchAgainYN = sc.nextLine();
                        if (searchAgainYN.equalsIgnoreCase("y")) {
                            searchCoustomer();
                        } else if (searchAgainYN.equalsIgnoreCase("n")) {
                            mainMenu();
                        } else {
                            clearLines(1);
                        }
                    }
                } else {
                    System.out.println("\n\t\tInvalid input....\n");
                    while (true) {
                        System.out.print("\tDo you want to try again ?  (Y/N) : ");
                        String phoneNoYN = sc.nextLine();
                        if (phoneNoYN.equalsIgnoreCase("y")) {
                            clearLines(5);
                            continue searchCoustomerLoop;
                        } else if (phoneNoYN.equalsIgnoreCase("n")) {
                            mainMenu();
                        } else {
                            clearLines(1);
                        }
                    }
                }
            } else {
                System.out.println("\n\t\tInvalid input....\n");
                while (true) {
                    System.out.print("\tDo you want to try again ?  (Y/N) : ");
                    String phoneNoYN = sc.nextLine();
                    if (phoneNoYN.equalsIgnoreCase("y")) {
                        clearLines(5);
                        continue searchCoustomerLoop;
                    } else if (phoneNoYN.equalsIgnoreCase("n")) {
                        mainMenu();
                    } else {
                        clearLines(1);
                    }
                }
            }
        }
    }

    //--------------print the table needed for search customer---------------------
    static void printSearchCoustomer(String[] tShirtSize, int[] QTY, int[] amount) {
        int totalAmount = 0;
        System.out.printf("%n%s%n%s%n%s%n", "\t\t\t+------------+------------+-----------------+", "\t\t\t|    Size    |     QTY    |      Amount     |", "\t\t\t+------------+------------+-----------------+");
        for (int i = 0; i < tShirtSize.length; i++) {
            System.out.printf("%s%-13s%-13s%-18s|%n%s|%-12s|%12s|%17s|%n", "\t\t\t", "|", "|", "|", "\t\t\t", ("  " + tShirtSize[i]), (String.valueOf(QTY[i]) + "   "), (String.valueOf(amount[i]) + ".00     "));
            totalAmount += amount[i];
        }
        System.out.printf("%s%-13s%-13s%-18s|%n%s%n%s%-26s|%17s|%n%s%n", "\t\t\t", "|", "|", "|", "\t\t\t+------------+------------+-----------------+", "\t\t\t", "|  Total Amount", (String.valueOf(totalAmount) + ".00     "), "\t\t\t+-------------------------+-----------------+");
    }

    //---------------------Search order by Order ID--------------------
    static void searchOrder() {
        while (true) {
            clearConsole();
            System.out.println("""
                               \t   _____                     _        ____          _           
                                \t / ____|                   | |      / __ \\        | |          
                                \t| (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __ 
                                \t \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |  | | '__/ _` |/ _ \\ '__|
                                \t ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |   
                               \t|_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_|   """);
            System.out.printf("%s%n%n%n%s", "\t_____________________________________________________________", "\tEnter order ID : ");
            String orderID = sc.nextLine();
            System.out.println("");
            boolean isValidInput = false;
            if (orderID.matches("ODR#\\d+") && orderID.length() == 9) {
                loopID:
                for (Order order : ordersArray) {
                    if (orderID.equalsIgnoreCase(order.getID())) {
                        isValidInput = true;
                        System.out.printf("%s%-20s : %s%n%s%-20s : %s%n%s%-20s : %s%n%s%-20s : %s%n%s%-20s : %s%n%n%n", "\t", "Phone Number", order.getPhoneNumber(), "\t", "Size", order.getSize(), "\t", "QTY", order.getQTY(), "\t", "Amount", (order.getAmount() + ".00"), "\t", "Status", (statusStringArray[order.getStatus()]));
                        break;
                    }
                }
            }
            if (isValidInput == false) {
                System.out.printf("%s%n%n", "\t\tInvalid ID...");
            }
            while (true) {
                System.out.print("\tDo you want to search another order ? (Y/N) : ");
                String SearchAnotherOrderYN = sc.nextLine();
                if (SearchAnotherOrderYN.equalsIgnoreCase("y")) {
                    searchOrder();
                } else if (SearchAnotherOrderYN.equalsIgnoreCase("n")) {
                    mainMenu();
                } else {
                    clearLines(1);
                }
            }
        }
    }

    //----Show the Reports menu and navigate which is the next one-----------
    static void viewReport() {
        viewReportMainLoop:
        while (true) {
            clearConsole();
            System.out.println("""
                               \t  _____                       _   
                               \t |  __ \\                     | |  
                               \t | |__) |___ _ __   ___  _ __| |_ 
                               \t |  _  // _ \\ '_ \\ / _ \\| '__| __|
                               \t | | \\ \\  __/ |_) | (_) | |  | |_ 
                               \t |_|  \\_\\___| .__/ \\___/|_|   \\__|
                               \t            | |                   
                               \t            |_|                """);
            System.out.printf("%s%n%s%n%s%n%s%n", "\t_________________________________\n", "\t\t[1] Customer Reports\n", "\t\t[2] Item Reports\n", "\t\t[3] Order Reports\n\n");
            optionLoop:
            while (true) {
                System.out.print("\tEnter Option : ");
                switch (sc.nextLine()) {
                    case "1" -> {
                        viewCustomerReport();
                        break optionLoop;
                    }
                    case "2" -> {
                        viewItemReport();
                        break optionLoop;
                    }
                    case "3" -> {
                        viewOrderReport();
                        break optionLoop;
                    }
                    default -> {
                        clearLines(1);
                    }
                }
            }
            break;
        }
    }

    //----Show the Customer Report menu and navigate which is the next one
    static void viewCustomerReport() {
        viewCustomerReportMainLoop:
        while (true) {
            clearConsole();
            System.out.println("""
                               \t   _____          _                              _____                       _   
                               \t  / ____|        | |                            |  __ \\                     | |  
                               \t | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ 
                               \t | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __|
                               \t | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_ 
                               \t  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|
                               \t                                                            | |                   
                               \t                                                            |_|                   """);
            System.out.printf("%s%n%s%n%s%n%s%n", "\t________________________________________________________________________________\n", "\t\t[1] Best In Customers\n", "\t\t[2] View Customers\n", "\t\t[3] All Customers Report\n\n");
            while (true) {
                System.out.print("\tEnter Option : ");
                switch (sc.nextLine()) {
                    case "1":
                        bestInCustomers();
                        break;
                    case "2":
                        viewCustomers();
                        break;
                    case "3":
                        allCustomersReport();
                        break;
                    default:
                        clearLines(1);
                }
            }
        }
    }

    //-------who are the best customers-----------------
    static void bestInCustomers() {
        while (true) {
            clearConsole();
            System.out.println("""
                               \t  ____            _     _____          _____          _                            
                               \t |  _ \\          | |   |_   _|        / ____|        | |                           
                               \t | |_) | ___  ___| |_    | |  _ __   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ 
                               \t |  _ < / _ \\/ __| __|   | | | '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|
                               \t | |_) |  __/\\__ \\ |_   _| |_| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |   
                               \t |____/ \\___||___/\\__| |_____|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|   """);

            System.out.println("\t________________________________________________________________________________\n");
            String PhoneNumbersWithDuplicates[] = new String[0];
            for (Order order : ordersArray) {
                PhoneNumbersWithDuplicates = saveToArray(order.getPhoneNumber(), PhoneNumbersWithDuplicates);
            }
            String[] noDuplicatePhoneNumbers = getArrayWithoutDuplicates(PhoneNumbersWithDuplicates);
            int[] totalQTYArray = new int[0];
            int[] totalAmountArray = new int[0];
            for (String noDuplicatePhoneNumber : noDuplicatePhoneNumbers) {
                int totalQTY = 0;
                int totalAmount = 0;
                for (Order order : ordersArray) {
                    if (order.getPhoneNumber().equals(noDuplicatePhoneNumber)) {
                        totalQTY += order.getQTY();
                        totalAmount += order.getAmount();
                    }
                }
                totalAmountArray = saveToArray(totalAmountArray, totalAmount);
                totalQTYArray = saveToArray(totalQTYArray, totalQTY);
            }
            for (int k = 0; k < noDuplicatePhoneNumbers.length; k++) {
                for (int j = 0; j < noDuplicatePhoneNumbers.length - 1; j++) {
                    if (totalAmountArray[j] < totalAmountArray[j + 1]) {
                        int temp = totalAmountArray[j + 1];
                        totalAmountArray[j + 1] = totalAmountArray[j];
                        totalAmountArray[j] = temp;
                        temp = totalQTYArray[j + 1];
                        totalQTYArray[j + 1] = totalQTYArray[j];
                        totalQTYArray[j] = temp;
                        String temps = noDuplicatePhoneNumbers[j + 1];
                        noDuplicatePhoneNumbers[j + 1] = noDuplicatePhoneNumbers[j];
                        noDuplicatePhoneNumbers[j] = temps;
                    }
                }
            }
            printBestInCustomers(noDuplicatePhoneNumbers, totalQTYArray, totalAmountArray);
            while (true) {
                System.out.print("\tTo access the Main Menu, Please enter 0 : ");
                switch (sc.nextLine()) {
                    case "0" ->
                        mainMenu();
                    default ->
                        clearLines(1);
                }
            }
        }
    }

    //----------print the table needed for bestincoustomer----------
    static void printBestInCustomers(String[] customerID, int[] allQTY, int[] totalAmount) {
        System.out.printf("%n%s%n%s%n%s%n", "\t\t\t+------------------+---------------+---------------------+", "\t\t\t|   Customer ID    |    All QTY    |     Total Amount    |", "\t\t\t+------------------+---------------+---------------------+");
        for (int i = 0; i < totalAmount.length; i++) {
            System.out.printf("%s%-19s%-16s%-22s|%n%s%-18s|%15s|%21s|%n", "\t\t\t", "|", "|", "|", "\t\t\t|", ("    " + customerID[i]), (allQTY[i] + "   "), (String.valueOf(totalAmount[i]) + ".00    "));
        }
        System.out.println("\t\t\t+------------------+---------------+---------------------+\n");
    }

    //-----------all customers all order summary-------------------
    static void viewCustomers() {
        while (true) {
            clearConsole();
            System.out.println("""
                               \t __      ___                  _____          _                                
                               \t \\ \\    / (_)                / ____|        | |                               
                               \t  \\ \\  / / _  _____      __ | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ 
                               \t   \\ \\/ / | |/ _ \\ \\ /\\ / / | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|
                               \t    \\  /  | |  __/\\ V  V /  | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\
                               \t     \\/   |_|\\___| \\_/\\_/    \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/""");
            System.out.println("\t________________________________________________________________________________");
            String PhoneNumbersWithDuplicates[] = new String[0];
            for (Order order : ordersArray) {
                PhoneNumbersWithDuplicates = saveToArray(order.getPhoneNumber(), PhoneNumbersWithDuplicates);
            }
            String[] noDuplicatePhoneNumbers = getArrayWithoutDuplicates(PhoneNumbersWithDuplicates);
            int[] totalQTYArray = new int[0];
            int[] totalAmountArray = new int[0];
            for (String noDuplicatePhoneNumber : noDuplicatePhoneNumbers) {
                int totalQTY = 0;
                int totalAmount = 0;
                for (Order order : ordersArray) {
                    if (order.getPhoneNumber().equals(noDuplicatePhoneNumber)) {
                        totalQTY += order.getQTY();
                        totalAmount += order.getAmount();
                    }
                }
                totalAmountArray = saveToArray(totalAmountArray, totalAmount);
                totalQTYArray = saveToArray(totalQTYArray, totalQTY);
            }
            printBestInCustomers(noDuplicatePhoneNumbers, totalQTYArray, totalAmountArray);
            while (true) {
                System.out.print("\tTo access the Main Menu, Please enter 0 : ");
                switch (sc.nextLine()) {
                    case "0" ->
                        mainMenu();
                    default ->
                        clearLines(1);
                }
            }
        }
    }

    //-----------all customers all order summary-------------------
    static void allCustomersReport() {
        while (true) {
            clearConsole();
            System.out.println("""
                                \t           _ _    _____          _                              _____                       _       
                               \t     /\\   | | |  / ____|        | |                            |  __ \\                     | |      
                               \t    /  \\  | | | | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ 
                               \t   / /\\ \\ | | | | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|
                               \t  / ____ \\| | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\
                               \t /_/    \\_\\_|_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/
                                \t                                                                          | |                       
                                  \t                                                                          |_|                       """);

            System.out.println("\t___________________________________________________________________________________________________");
            String PhoneNumbersWithDuplicates[] = new String[0];
            for (Order order : ordersArray) {
                PhoneNumbersWithDuplicates = saveToArray(order.getPhoneNumber(), PhoneNumbersWithDuplicates);
            }
            String[] noDuplicatePhoneNumbers = getArrayWithoutDuplicates(PhoneNumbersWithDuplicates);
            int[] totalAmountArray = new int[0];
            int[] totalXSTShirtsArray = new int[0];
            int[] totalSTShirtsArray = new int[0];
            int[] totalMTShirtsArray = new int[0];
            int[] totalLTShirtsArray = new int[0];
            int[] totalXLTShirtsArray = new int[0];
            int[] totalXXLTShirtsArray = new int[0];
            for (String noDuplicatePhoneNumber : noDuplicatePhoneNumbers) {
                int totalAmount = 0;
                int totalQTYXSTShirts = 0;
                int totalQTYSTShirts = 0;
                int totalQTYMTShirts = 0;
                int totalQTYLTShirts = 0;
                int totalQTYXLTShirts = 0;
                int totalQTYXXLTShirts = 0;
                for (Order order : ordersArray) {
                    if (order.getPhoneNumber().equals(noDuplicatePhoneNumber)) {
                        totalAmount += order.getAmount();
                        switch (order.getSize()) {
                            case "XS" ->
                                totalQTYXSTShirts += order.getQTY();
                            case "S" ->
                                totalQTYSTShirts += order.getQTY();
                            case "M" ->
                                totalQTYMTShirts += order.getQTY();
                            case "L" ->
                                totalQTYLTShirts += order.getQTY();
                            case "XL" ->
                                totalQTYXLTShirts += order.getQTY();
                            case "XXL" ->
                                totalQTYXXLTShirts += order.getQTY();
                        }
                    }
                }
                totalXSTShirtsArray = saveToArray(totalXSTShirtsArray, totalQTYXSTShirts);
                totalSTShirtsArray = saveToArray(totalSTShirtsArray, totalQTYSTShirts);
                totalMTShirtsArray = saveToArray(totalMTShirtsArray, totalQTYMTShirts);
                totalLTShirtsArray = saveToArray(totalLTShirtsArray, totalQTYLTShirts);
                totalXLTShirtsArray = saveToArray(totalXLTShirtsArray, totalQTYXLTShirts);
                totalXXLTShirtsArray = saveToArray(totalXXLTShirtsArray, totalQTYXXLTShirts);
                totalAmountArray = saveToArray(totalAmountArray, totalAmount);
            }
            printAllInCustomers(noDuplicatePhoneNumbers, totalXSTShirtsArray, totalSTShirtsArray, totalMTShirtsArray, totalLTShirtsArray, totalXLTShirtsArray, totalXXLTShirtsArray, totalAmountArray);
            while (true) {
                System.out.print("\tTo access the Main Menu, Please enter 0 : ");
                switch (sc.nextLine()) {
                    case "0" ->
                        mainMenu();
                    default ->
                        clearLines(1);
                }
            }
        }
    }

    //-----------print the table needs for all customers report----
    static void printAllInCustomers(String[] PhoneNum, int[] totalXSTShirtsArray, int[] totalSTShirtsArray, int[] totalMTShirtsArray, int[] totalLTShirtsArray, int[] totalXLTShirtsArray, int[] totalXXLTShirtsArray, int[] totalAmount) {
        System.out.printf("%n%s%n%s%n%s%n", "\t\t\t+------------------+----------+----------+----------+----------+----------+----------+---------------------+", "\t\t\t|   Phone Number   |    XS    |     S    |     M    |     L    |    XL    |    XXL   |        Total        |", "\t\t\t+------------------+----------+----------+----------+----------+----------+----------+---------------------+");
        for (int i = 0; i < totalAmount.length; i++) {
            System.out.printf("%s%-19s%-11s%-11s%-11s%-11s%-11s%-11s%-22s|%n%s%-18s|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|%21s|%n", "\t\t\t", "|", "|", "|", "|", "|", "|", "|", "|", "\t\t\t|", ("    " + PhoneNum[i]), ("    " + totalXSTShirtsArray[i]), ("    " + totalSTShirtsArray[i]), ("    " + totalMTShirtsArray[i]), ("    " + totalLTShirtsArray[i]), ("    " + totalXLTShirtsArray[i]), ("    " + totalXXLTShirtsArray[i]), (String.valueOf(totalAmount[i]) + ".00    "));
        }
        System.out.println("\t\t\t+------------------+----------+----------+----------+----------+----------+----------+---------------------+\n");
    }

    //---------Menu if view item report and navigate to next step-----------
    static void viewItemReport() {
        while (true) {
            clearConsole();
            System.out.println("""
                               \t _____ _                   _____                       _       
                                \t|_   _| |                 |  __ \\                     | |      
                                 \t  | | | |_ ___ _ __ ___   | |__) |___ _ __   ___  _ __| |_ ___ 
                                 \t  | | | __/ _ \\ '_ ` _ \\  |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|
                                \t _| |_| ||  __/ | | | | | | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\
                                \t|_____|\\__\\___|_| |_| |_| |_|  \\_\\___| .__/ \\___/|_|   \\__|___/
                                \t                                     | |                       
                                 \t                                     |_|      """);
            System.out.println("\t______________________________________________________________\n");
            System.out.printf("%s%n%n%s%n%n", "\t\t[1] Best Selling Categories Sorted By QTY", "\t\t[2] Best Selling Categories Sorted By Amount");
            while (true) {
                System.out.print("\tEnter Option : ");
                switch (sc.nextLine()) {
                    case "1" ->
                        sellingCategoryORderByQTY();
                    case "2" ->
                        sellingCategoryORderByAmount();
                    default ->
                        clearLines(1);
                }
            }
        }

    }

    //--------calculate how many orders for each t-shirt size------
    static void sellingCategoryORderByQTY() {

        while (true) {
            clearConsole();
            System.out.println("""
                               \t   _____            _           _   ____           ____ _________     __
                               \t  / ____|          | |         | | |  _ \\         / __ \\__   __\\ \\   / /
                               \t | (___   ___  _ __| |_ ___  __| | | |_) |_   _  | |  | | | |   \\ \\_/ / 
                               \t  \\___ \\ / _ \\| '__| __/ _ \\/ _` | |  _ <| | | | | |  | | | |    \\   /  
                               \t  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| | | |__| | | |     | |   
                               \t |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, |  \\___\\_\\ |_|     |_|   
                               \t                                           __/ |                        
                               \t                                          |___/                         """);
            System.out.println("\t__________________________________________________________________");
            int countXSTShirts = 0, countSTShirts = 0, countMTShirts = 0, countLTShirts = 0, countXLTShirts = 0, countXXLTShirts = 0;
            int amountXSTShirts = 0, amountSTShirts = 0, amountMTShirts = 0, amountLTShirts = 0, amountXLTShirts = 0, amountXXLTShirts = 0;
            for (Order order : ordersArray) {
                switch (order.getSize()) {
                    case "XS" -> {
                        countXSTShirts += order.getQTY();
                        amountXSTShirts += order.getAmount();
                    }
                    case "S" -> {
                        countSTShirts += order.getQTY();
                        amountSTShirts += order.getAmount();
                    }
                    case "M" -> {
                        countMTShirts += order.getQTY();
                        amountMTShirts += order.getAmount();
                    }
                    case "L" -> {
                        countLTShirts += order.getQTY();
                        amountLTShirts += order.getAmount();
                    }
                    case "XL" -> {
                        countXLTShirts += order.getQTY();
                        amountXLTShirts += order.getAmount();
                    }
                    case "XXL" -> {
                        countXXLTShirts += order.getQTY();
                        amountXXLTShirts += order.getAmount();
                    }
                }
            }
            String[] TShirtsSizes = {"XS", "S", "M", "L", "XL", "XXL"};
            int[] tempQTY = {countXSTShirts, countSTShirts, countMTShirts, countLTShirts, countXLTShirts, countXXLTShirts};
            int[] tempTotalAmount = {amountXSTShirts, amountSTShirts, amountMTShirts, amountLTShirts, amountXLTShirts, amountXXLTShirts};
            for (int i = 0; i < tempQTY.length; i++) {
                for (int j = 0; j < tempQTY.length - 1; j++) {
                    if (tempQTY[j] < tempQTY[j + 1]) {
                        int temp = tempQTY[j + 1];
                        tempQTY[j + 1] = tempQTY[j];
                        tempQTY[j] = temp;
                        temp = tempTotalAmount[j + 1];
                        tempTotalAmount[j + 1] = tempTotalAmount[j];
                        tempTotalAmount[j] = temp;
                        String temps = TShirtsSizes[j + 1];
                        TShirtsSizes[j + 1] = TShirtsSizes[j];
                        TShirtsSizes[j] = temps;
                    }
                }
            }
            printSellingCategoryORder(TShirtsSizes, tempQTY, tempTotalAmount);
            while (true) {
                System.out.print("\tTo access the Main Menu, Please enter 0 : ");
                switch (sc.nextLine()) {
                    case "0" ->
                        mainMenu();
                    default ->
                        clearLines(1);
                }
            }
        }
    }

    //-------print the table for sellingCategoryORderByQTY------
    static void printSellingCategoryORder(String[] tShirtSize, int[] QTY, int[] Totalamount) {
        System.out.printf("%n%s%n%s%n%s%n", "\t\t\t+------------+------------+-----------------+", "\t\t\t|    Size    |     QTY    |   Total Amount  |", "\t\t\t+------------+------------+-----------------+");
        for (int i = 0; i < tShirtSize.length; i++) {
            System.out.printf("%s%-13s%-13s%-18s|%n%s%-12s|%12s|%17s|%n", "\t\t\t", "|", "|", "|", "\t\t\t|", ("  " + tShirtSize[i]), (String.valueOf(QTY[i]) + "  "), (String.valueOf(Totalamount[i]) + ".00  "));
        }
        System.out.println("\t\t\t+------------+------------+-----------------+\n");
    }

    static void sellingCategoryORderByAmount() {
        while (true) {
            clearConsole();
            System.out.println("""
                                \t   _____            _           _   ____                                               _   
                               \t  / ____|          | |         | | |  _ \\            /\\                               | |  
                               \t | (___   ___  _ __| |_ ___  __| | | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ 
                               \t  \\___ \\ / _ \\| '__| __/ _ \\/ _` | |  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|
                               \t  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ 
                               \t |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|
                               \t                                           __/ |                                           
                               \t                                          |___/                                            """);
            System.out.println("\t_____________________________________________________________________________________");
            int countXSTShirts = 0, countSTShirts = 0, countMTShirts = 0, countLTShirts = 0, countXLTShirts = 0, countXXLTShirts = 0;
            int amountXSTShirts = 0, amountSTShirts = 0, amountMTShirts = 0, amountLTShirts = 0, amountXLTShirts = 0, amountXXLTShirts = 0;
            for (Order order : ordersArray) {
                switch (order.getSize()) {
                    case "XS" -> {
                        countXSTShirts += order.getQTY();
                        amountXSTShirts += order.getAmount();
                    }
                    case "S" -> {
                        countSTShirts += order.getQTY();
                        amountSTShirts += order.getAmount();
                    }
                    case "M" -> {
                        countMTShirts += order.getQTY();
                        amountMTShirts += order.getAmount();
                    }
                    case "L" -> {
                        countLTShirts += order.getQTY();
                        amountLTShirts += order.getAmount();
                    }
                    case "XL" -> {
                        countXLTShirts += order.getQTY();
                        amountXLTShirts += order.getAmount();
                    }
                    case "XXL" -> {
                        countXXLTShirts += order.getQTY();
                        amountXXLTShirts += order.getAmount();
                    }
                }
            }

            String[] TShirtsSizes = {"XS", "S", "M", "L", "XL", "XXL"};
            int[] tempQTY = {countXSTShirts, countSTShirts, countMTShirts, countLTShirts, countXLTShirts, countXXLTShirts};
            int[] tempTotalAmount = {amountXSTShirts, amountSTShirts, amountMTShirts, amountLTShirts, amountXLTShirts, amountXXLTShirts};

            for (int i = 0; i < tempQTY.length; i++) {
                for (int j = 0; j < tempQTY.length - 1; j++) {
                    if (tempTotalAmount[j] < tempTotalAmount[j + 1]) {
                        int temp = tempQTY[j + 1];
                        tempQTY[j + 1] = tempQTY[j];
                        tempQTY[j] = temp;
                        temp = tempTotalAmount[j + 1];
                        tempTotalAmount[j + 1] = tempTotalAmount[j];
                        tempTotalAmount[j] = temp;
                        String temps = TShirtsSizes[j + 1];
                        TShirtsSizes[j + 1] = TShirtsSizes[j];
                        TShirtsSizes[j] = temps;
                    }
                }
            }
            printSellingCategoryORder(TShirtsSizes, tempQTY, tempTotalAmount);
            while (true) {
                System.out.print("\tTo access the Main Menu, Please enter 0 : ");
                switch (sc.nextLine()) {
                    case "0" ->
                        mainMenu();
                    default ->
                        clearLines(1);
                }
            }
        }
    }

    static void viewOrderReport() {
        while (true) {
            clearConsole();
            System.out.println("""
                               \t   ____          _             _____                       _   
                               \t  / __ \\        | |           |  __ \\                     | |  
                               \t | |  | |_ __ __| | ___ _ __  | |__) |___ _ __   ___  _ __| |_ 
                               \t | |  | | '__/ _` |/ _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __|
                               \t | |__| | | | (_| |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_ 
                               \t  \\____/|_|  \\__,_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|
                               \t                                         | |                   
                               \t                                         |_|                   """);
            System.out.println("\t_________________________________________________________________________\n");

            System.out.printf("%s%n%n%s%n%n", "\t\t[1] All Orders", "\t\t[2] Order By Amount");
            while (true) {
                System.out.print("\tEnter Option : ");
                switch (sc.nextLine()) {
                    case "1" ->
                        viewAllOrders();
                    case "2" ->
                        viewAllOrdersOrderByAmount();
                    default ->
                        clearLines(1);
                }
            }
        }

    }

    static void viewAllOrders() {
        while (true) {
            clearConsole();
            System.out.println("""
                               \t\t __      ___                  ____          _               
                               \t\t \\ \\    / (_)                / __ \\        | |              
                               \t\t  \\ \\  / / _  _____      __ | |  | |_ __ __| | ___ _ __ ___ 
                               \t\t   \\ \\/ / | |/ _ \\ \\ /\\ / / | |  | | '__/ _` |/ _ \\ '__/ __|
                               \t\t    \\  /  | |  __/\\ V  V /  | |__| | | | (_| |  __/ |  \\__ \\
                               \t\t     \\/   |_|\\___| \\_/\\_/    \\____/|_|  \\__,_|\\___|_|  |___/""");
            System.out.println("\t\t______________________________________________________________\n\n");
            System.out.printf("%s%n%s%n%s%n", "\t\t+--------------+---------------+--------+---------+---------------+--------------+", "\t\t|   Order ID   |  Customer ID  |  Size  |   QTY   |     Amount    |    Status    |", "\t\t+--------------+---------------+--------+---------+---------------+--------------+");
            for (Order order : ordersArray) {
                printOrderReportTableForViewOrder(order.getID(), order.getPhoneNumber(), order.getSize(), order.getQTY(), order.getAmount(), order.getStatus());
            }
            System.out.println("\t\t+--------------+---------------+--------+---------+---------------+--------------+\n\n");
            while (true) {
                System.out.print("\tTo access the Main Menu, Please enter 0 : ");
                switch (sc.nextLine()) {
                    case "0" ->
                        mainMenu();
                    default ->
                        clearLines(1);
                }
            }
        }
    }

    static void viewAllOrdersOrderByAmount() {
        while (true) {
            clearConsole();
            System.out.println("""
                               \t   ____          _                 ____                                               _   
                               \t  / __ \\        | |               |  _ \\            /\\                               | |  
                               \t | |  | |_ __ __| | ___ _ __ ___  | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ 
                               \t | |  | | '__/ _` |/ _ \\ '__/ __| |  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|
                               \t | |__| | | | (_| |  __/ |  \\__ \\ | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ 
                               \t  \\____/|_|  \\__,_|\\___|_|  |___/ |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|
                               \t                                          __/ |                                           
                               \t                                         |___/                                            """);
            System.out.println("\t______________________________________________________________________________________\n");
            int[] Amounts = new int[0];
            String[] orderID = new String[0];
            for (Order order : ordersArray) {
                Amounts = saveToArray(Amounts, order.getAmount());
                orderID = saveToArray(orderID, order.getID());
            }
            for (int j = 0; j < Amounts.length; j++) {
                for (int i = 0; i < Amounts.length - 1; i++) {
                    if (Amounts[i] < Amounts[i + 1]) {
                        int tempAmount = Amounts[i];
                        Amounts[i] = Amounts[i + 1];
                        Amounts[i + 1] = tempAmount;
                        String tempOrderID = orderID[i];
                        orderID[i] = orderID[i + 1];
                        orderID[i + 1] = tempOrderID;
                    }
                }
            }
            System.out.printf("%s%n%s%n%s%n", "\t\t+--------------+---------------+--------+---------+---------------+--------------+", "\t\t|   Order ID   |  Customer ID  |  Size  |   QTY   |     Amount    |    Status    |", "\t\t+--------------+---------------+--------+---------+---------------+--------------+");
            for (String orderid : orderID) {
                for (Order order : ordersArray) {

                    if (orderid.equalsIgnoreCase(order.getID())) {
                        printOrderReportTable(order.getID(), order.getPhoneNumber(), order.getSize(), order.getQTY(), order.getAmount(), order.getStatus());
                    }
                }
            }
            System.out.println("\t\t+--------------+---------------+--------+---------+---------------+--------------+\n\n");

            while (true) {
                System.out.print("\tTo access the Main Menu, Please enter 0 : ");
                switch (sc.nextLine()) {
                    case "0" ->
                        mainMenu();
                    default ->
                        clearLines(1);
                }
            }
        }
    }

    static void printOrderReportTableForViewOrder(String orderID, String PhoneNumber, String tShirtSize, int QTY, int amount, int status) {
        System.out.printf("%s|%-14s|%15s|%-8s|%-9s|%15s|%-14s|%n", "\t\t", (" " + orderID), (PhoneNumber + "  "), (" " + tShirtSize), ("   " + QTY), (String.valueOf(amount) + ".00  "), ("  " + statusStringArray[status]));
    }

    static void printOrderReportTable(String orderID, String PhoneNumber, String tShirtSize, int QTY, int amount, int status) {
        System.out.printf("%s|%-14s|%15s|%-8s|%-9s|%15s|%-14s|%n", "\t\t", (" " + orderID), (PhoneNumber + "  "), (" " + tShirtSize), ("   " + QTY), (String.valueOf(amount) + ".00  "), ("  " + statusStringArray[status]));
    }

    static void changeOrderStatus() {
        while (true) {
            clearConsole();
            System.out.println("""
                               \t  ____          _              _____ _        _             
                                \t / __ \\        | |            / ____| |      | |            
                                \t| |  | |_ __ __| | ___ _ __  | (___ | |_ __ _| |_ _   _ ___ 
                                \t| |  | | '__/ _` |/ _ \\ '__|  \\___ \\| __/ _` | __| | | / __|
                                \t| |__| | | | (_| |  __/ |     ____) | || (_| | |_| |_| \\__ \\
                                \t \\____/|_|  \\__,_|\\___|_|    |_____/ \\__\\__,_|\\__|\\__,_|___/""");

            System.out.printf("%s%n%n%n%s", "\t________________________________________________________", "\tEnter order ID : ");
            String orderID = sc.nextLine();
            System.out.println("");
            boolean isValidInput = false;
            if (orderID.matches("ODR#\\d+") && orderID.length() == 9) {
                for (Order order : ordersArray) {
                    if (order.getID().equals(orderID)) {
                        System.out.printf("%s%-20s : %s%n%s%-20s : %s%n%s%-20s : %s%n%s%-20s : %s%n%s%-20s : %s%n%n%n", "\t", "Phone Number", order.getPhoneNumber(), "\t", "Size", order.getSize(), "\t", "QTY", order.getQTY(), "\t", "Amount", (order.getAmount() + ".00"), "\t", "Status", (statusStringArray[order.getStatus()]));
                        isValidInput = true;
                        if (order.getStatus() == 2) {
                            System.out.println("\t\tCan't change this order status, Order already delivered!...");
                            System.out.println("");
                        } else {
                            System.out.print("\tDo you want to change this order status ? (Y/N) : ");
                            String changeStatusYN = sc.nextLine();
                            if (changeStatusYN.equalsIgnoreCase("y")) {
                                if (order.getStatus() == 0) {
                                    System.out.println("\n\t\t[1] Order Delivering\n");
                                    System.out.println("\t\t[2] Order Delivered\n");
                                    L1:
                                    while (true) {
                                        System.out.print("\tEnter Option : ");
                                        switch (sc.nextLine()) {
                                            case "1" -> {
                                                order.setStatus((order.getStatus() + 1));
                                                System.out.println("\n\t\tStatus Changed...");
                                                break L1;
                                            }
                                            case "2" -> {
                                                order.setStatus((order.getStatus() + 2));
                                                System.out.println("\n\t\tStatus Changed...");
                                                break L1;
                                            }
                                            default -> {
                                                clearLines(1);
                                                continue L1;
                                            }
                                        }
                                    }
                                } else if (order.getStatus() == 1) {
                                    System.out.println("\n\t\t[1] Order Delivered\n");
                                    L1:
                                    while (true) {
                                        System.out.print("\n\tEnter Option : ");
                                        switch (sc.nextLine()) {
                                            case "1" -> {
                                                order.setStatus((order.getStatus() + 1));
                                                System.out.println("\n\t\tStatus Changed...");
                                                break L1;
                                            }
                                            default -> {
                                                continue L1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (isValidInput == false) {
                System.out.println("\t\tInvalid ID...");
                System.out.println("");
            }

            System.out.println("");
            while (true) {
                System.out.print("\tDo you want to change another order status ? (Y/N) : ");
                String SearchAnotherOrderYN = sc.nextLine();

                if (SearchAnotherOrderYN.equalsIgnoreCase("y")) {
                    changeOrderStatus();
                } else if (SearchAnotherOrderYN.equalsIgnoreCase("n")) {
                    mainMenu();
                } else {
                    clearLines(1);
                }
            }
        }
    }

    static void deleteOrder() {
        while (true) {
            clearConsole();
            System.out.println("""
                               \t  _____       _      _          ____          _           
                               \t |  __ \\     | |    | |        / __ \\        | |          
                               \t | |  | | ___| | ___| |_ ___  | |  | |_ __ __| | ___ _ __ 
                               \t | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|
                               \t | |__| |  __/ |  __/ ||  __/ | |__| | | | (_| |  __/ |   
                               \t |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\__,_|\\___|_|   """);
            System.out.println("\n\t_____________________________________________________\n");
            System.out.print("\tEnter Order ID : ");
            String orderID = sc.nextLine();
            System.out.println("");

            boolean isValidInput = false;
            Order orderAddress;
            int index = -1;
            if (orderID.matches("ODR#\\d+") && orderID.length() == 9) {
                for (Order order : ordersArray) {
                    if (orderID.equals(order.getID())) {
                        for (int i = 0; i < ordersArray.length; i++) {
                            index = i;
                        }
                        System.out.printf("%s%-20s : %s%n%s%-20s : %s%n%s%-20s : %s%n%s%-20s : %s%n%s%-20s : %s%n%n%n", "\t", "Phone Number", order.getPhoneNumber(), "\t", "Size", order.getSize(), "\t", "QTY", order.getQTY(), "\t", "Amount", (order.getAmount() + ".00"), "\t", "Status", (statusStringArray[order.getStatus()]));
                        isValidInput = true;
                        deleteConfirmLoop:
                        while (true) {
                            System.out.print("\tDo you want to delete this order ? (Y/N) : ");
                            String input = sc.nextLine();
                            switch (input.toLowerCase()) {
                                case "y" -> {
                                    Order[] tempArr = new Order[ordersArray.length - 1];
                                    boolean isAddressPassed = false;
                                    for (int i = 0; i < tempArr.length; i++) {
                                        if (i < index) {
                                            tempArr[i] = ordersArray[i];
                                        } else {
                                            tempArr[i] = ordersArray[i + 1];
                                        }
                                    }
                                    ordersArray = tempArr;

                                    System.out.println("\n\t\tOrder Deleted...!\n");
                                    break deleteConfirmLoop;
                                }
                                case "n" -> {
                                    break deleteConfirmLoop;
                                }
                                default -> {
                                    clearLines(1);
                                    continue deleteConfirmLoop;
                                }
                            }
                        }
                    }
                }
            }
            if (isValidInput == false) {
                System.out.println("\n\t\tInvalid ID...");
                System.out.println("");
            }
            System.out.println("");
            while (true) {
                System.out.print("\tDo you want to delete another order ? (Y/N) : ");
                String SearchAnotherOrderYN = sc.nextLine();
                if (SearchAnotherOrderYN.equalsIgnoreCase("y")) {
                    deleteOrder();
                } else if (SearchAnotherOrderYN.equalsIgnoreCase("n")) {
                    mainMenu();
                } else {
                    clearLines(1);
                }
            }
        }
    }

    static String[] getArrayWithoutDuplicates(String[] arr) {
        String[] noDupliatesArray = new String[1];
        noDupliatesArray[0] = arr[0];
        for (int i = 0; i < arr.length; i++) {
            boolean alreadyIncluded = false;
            Loop:
            for (String noDupliatesArray1 : noDupliatesArray) {
                if (arr[i].equals(noDupliatesArray1)) {
                    alreadyIncluded = true;
                    break Loop;
                }
            }
            if (alreadyIncluded == false) {
                noDupliatesArray = saveToArray(noDupliatesArray, arr[i]);
            }
        }
        return noDupliatesArray;
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    static Order getNewObject(String orderID, String phoneNumber, String size, int QTY, int amount, int status) {
        return new Order(orderID, phoneNumber, size, QTY, amount, status);
    }

    static void clearLines(int lineCount) {
        System.out.print("\033[" + String.valueOf(lineCount) + "A");
        System.out.print("\033[0J");
    }

    static String getNextOrderID() {
        String IDFormat = "ODR#%05d";
        return String.format(IDFormat, (ordersArray.length + 1));
    }

    static String[] saveToArray(String PhoneNumber, String[] arr) {
        String[] tempArr = new String[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }
        tempArr[arr.length] = PhoneNumber;
        return tempArr;
    }

    static Order[] saveToArray(Order[] arr, Order obj) {
        Order[] tempArr = new Order[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }
        tempArr[arr.length] = obj;
        return tempArr;
    }

    static String[] saveToArray(String arr[], String string) {
        String[] tempArr = new String[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }
        tempArr[arr.length] = string;
        return tempArr;
    }

    static int[] saveToArray(int arr[], int value) {
        int[] tempArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }
        tempArr[arr.length] = value;
        return tempArr;
    }
    static void emptyDatabaseErrorMessege() {
        clearConsole();
        System.out.println("""
                           \t\t\t\t88888888888  88888888ba   88888888ba     ,ad8888ba,    88888888ba   
                           \t\t\t\t88           88      "8b  88      "8b   d8"'    `"8b   88      "8b  
                           \t\t\t\t88           88      ,8P  88      ,8P  d8'        `8b  88      ,8P  
                           \t\t\t\t88aaaaa      88aaaaaa8P'  88aaaaaa8P'  88          88  88aaaaaa8P'  
                           \t\t\t\t88\"\"\"""      88\"\"""88'    88\"\"""88'    88          88  88\"\"""88'    
                           \t\t\t\t88           88    `8b    88    `8b    Y8,        ,8P  88    `8b    
                           \t\t\t\t88           88     `8b   88     `8b    Y8a.    .a8P   88     `8b   
                           \t\t\t\t88888888888  88      `8b  88      `8b    `"Y8888Y"'    88      `8b  """);
                                                                                               
        System.out.printf("%s%n%s","\n\n\n\tNothing in the DATABASE!!!...\n","\n\n\t\t\tPress any key...");         
        String nope = sc.nextLine();
        mainMenu();
	}
}