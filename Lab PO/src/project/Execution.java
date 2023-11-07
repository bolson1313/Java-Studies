package project;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class Execution {

    private int attempts = 1;

    private static final Water water = new Water();
    private static final Air air = new Air();
    private static final Doors doors = new Doors();
    private static final Windows windows = new Windows();
    private static final Electricity electricity = new Electricity();
    private static final Ticket ticket = new Ticket();
    public Execution() {
    }

    public void OpenMenu(){
        while(true) {

            //pole do logowania
            //zmienne pomocnicze
            System.out.println("==== |Aby wejśc do budynku podaj dane!| ====");
            int id = 0;
            int accesCode = 0;
            try {
                id = Inputs.InputInt("Idenfyfikator: ");
                accesCode = Inputs.InputInt("Kod dostępu: ");
            } catch (InputMismatchException e){
                System.out.println("Podałeś nieprawidłowe znaki!");
            }
            System.out.println("=============================================");
            //tworzenie obiektów wszystkich klas
            Burglary burglary = new Burglary(0);
            DataBase dataBase = new DataBase("SELECT id, name, surname, acces_code, authorized FROM users WHERE id=" + id + " AND acces_code=" + accesCode); //tworzy obiekt, jesli uzytkownik nie istnieje obiekt = null
            User user = dataBase.DBCheckUser(id, accesCode);
            //zmienne dodatkowe
            int option;

            //aktualna data i godzina aby rejestrować ruch w budynku
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            //walidacja logowania
            if (user != null) {
                //jesli uzytkownik istnieje program sprawdzi czy ma on dostep do panelu administratora oraz wyswietli odpowiednie menu
                if (user.isAuthorized()) {
                    //wejscie do panelu admina jedynie gdy uzytkownik jest autoryzowany
                    user.setTime(now.format(formater));                                                                                                             //zaktualizowanie czasu logowania uzytkownika
                    dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'Entry', '" + user.getTime() + "', " + user.getId() + ");"); //monitorowanie wejscia
                    dataBase.AddAction();
                    while (true) {
                        System.out.println("\n======================| Witaj W panelu administracyjnym " + user.getName() + "! |======================");
                        System.out.println("\t\t\t\t\tWszedłeś do budynku o " + now.format(formater));
                        System.out.println("1. Ogólne informacje\n" +
                                "2. Odblokuj/Zablokuj okna w budynku\n" +
                                "3. Odblokuj/Zablokuj drzwi w budynku\n" +
                                "4. Włącz/Wyłącz całą sieć elektryczną w budynku\n" +
                                "5. Włącz/Wyłącz światła w budynku\n" +
                                "6. Odetnij wodę w budynku\n" +
                                "7. Sprawdź sprawy zglaszane przez lokatrowów\n" +
                                "8. Sprwadź liste akcji\n" +
                                "9. Usuń/Dodaj użytkowników\n" +
                                "10. Wyjdź z budynku\n" +
                                "11. Wyłącz program");
                        System.out.println("==================================================================================");
                        System.out.println("* Co chcesz zrobić? *");
                        try {
                            option = Inputs.InputInt("Wpisz opcje: ");
                        } catch (InputMismatchException e) {
                            System.out.println("Podałeś ciag znakow zamiast cyfry!");
                            option = 0;
                        }
                        System.out.println();
                        switch (option) {
                            case 1:
                                System.out.println("Ogólne informacje");
                                System.out.println(water);
                                System.out.println(air);
                                System.out.println(doors);
                                System.out.println(windows);
                                System.out.println(electricity);
                                System.out.println();
                                break;
                            case 2:
                                windows.Lock();
                                break;
                            case 3:
                                doors.Lock();
                                break;
                            case 4:
                                electricity.CutOff();
                                break;
                            case 5:
                                electricity.Turn();
                                break;
                            case 6:
                                water.CutOff();
                                break;
                            case 7:
                                System.out.println("Lista spraw:");
                                dataBase.setQuery("SELECT * FROM tickets");
                                dataBase.DBSelectAll();
                                String tmpconf2 = Inputs.InputString("Czy chcesz usunąć jakąś zakończoną sprawę? T/N: ");
                                while (true) {
                                    if (tmpconf2.equals("T") || tmpconf2.equals("t")) {
                                        tmpconf2 = Inputs.InputString("Podaj id sprawy którą chcesz usunac: ");
                                        dataBase.setQuery("SELECT * FROM tickets WHERE id=" + tmpconf2 + "");
                                        try {
                                            if (dataBase.DBCheckIfExists()) {
                                                String tmpconf3 = Inputs.InputString("Potwierdź czy chcesz usunąć sprawe od ID " + tmpconf2 + "? T/N: ");
                                                if (tmpconf3.equals("T") || tmpconf3.equals("t")) {
                                                    dataBase.setQuery("DELETE FROM tickets WHERE `tickets`.`id` = " + tmpconf2 + "");
                                                    dataBase.AddAction();
                                                    System.out.println("Sprawa zostala usunieta!");
                                                    break;
                                                }
                                                break;
                                            } else {
                                                System.out.println("Sprawa o tym ID nie isenitje!");
                                            }
                                        } catch (RuntimeException re){
                                            System.out.println("Podales nieprawidlowy znak!");
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                break;
                            case 8:
                                dataBase.setQuery("SELECT * FROM actions");
                                System.out.println("Co sie działo w budynku: ");
                                dataBase.DBSelectActions();
                                break;
                            case 9:
                                while (true) {
                                    String tmpoption = Inputs.InputString("Jeśli chcesz dodać uzytkownika wciśnij 1, usunąć 2, jeśli nic wciśnij cokolwiek: "); //dodawanie acces code eror
                                    if (tmpoption.equals("1")) {
                                        int tmp = 0;
                                        System.out.println("Podaj dane użtykownika do dodania: ");
                                        //czytanie imienia
                                        String tmpName = null;
                                        tmpName = Inputs.InputString("Podaj imię: ");
                                        while(tmpName.isEmpty()){
                                            tmpName = Inputs.InputString("Błąd! Podaj imie ponownie: ");
                                        }
                                        //czytanie nazwiska
                                        String tmpSurename = Inputs.InputString("Podaj nazwisko: ");
                                        while(tmpSurename.isEmpty()){
                                            tmpSurename = Inputs.InputString("Błąd! Podaj nazwisko pownownie: ");
                                        }
                                        //czytanie i sprawdzenie kodu
                                        String tmpAccesCode;
                                        while(true){
                                            try{
                                                tmpAccesCode = Inputs.InputString("Podaj kod dostępu (4 cyfry): ");
                                                tmp = Integer.parseInt(tmpAccesCode);
                                                if(tmpAccesCode.length()==4){
                                                    break;
                                                }
                                            } catch (Exception e){
                                                System.out.print("Błąd! ");
                                            }
                                        }

                                        //czy autoryzowany
                                        String tmpIsAuthorized = Inputs.InputString("Podaj czy użytkownik ma być autoryzowany(T/N): ");
                                        while(tmpIsAuthorized.isEmpty()){
                                            tmpIsAuthorized = Inputs.InputString("Błąd! Podaj czy użytkownik ma być autoryzowany(T/N): ");
                                        }
                                        boolean confirm = false;
                                        if(tmpIsAuthorized.equals("T") || tmpIsAuthorized.equals("t")){
                                            confirm = true;
                                        }

                                        String tmpconf = Inputs.InputString("Czy napewno chcesz dodać? T/N: ");
                                        while(tmpconf.isEmpty()){
                                            tmpconf = Inputs.InputString("Błąd! Podaj czy użytkownik ma zostać dodany(T/N): ");
                                        }
                                        if (tmpconf.equals("T") || tmpconf.equals("t")) {
                                            if(confirm){
                                                dataBase.setQuery("INSERT INTO `users` (`id`, `name`, `surname`, `acces_code`, `authorized`) VALUES (NULL, '" + tmpName + "', '" + tmpSurename + "', '" + tmpAccesCode + "', '1')");
                                                dataBase.AddAction();
                                                System.out.println("Autoryzowany Użytkownik dodany do bazy!");
                                            } else {
                                                dataBase.setQuery("INSERT INTO `users` (`id`, `name`, `surname`, `acces_code`, `authorized`) VALUES (NULL, '" + tmpName + "', '" + tmpSurename + "', '" + tmpAccesCode + "', '0')");
                                                dataBase.AddAction();
                                                System.out.println("Nie Autoryzowany Użytkownik dodany do bazy!");
                                            }
                                            break;
                                        } else {
                                            System.out.println("Użytkownik nie zostal dodany!");
                                            break;
                                        }
                                    } else if (tmpoption.equals("2")) {
                                        dataBase.setQuery("SELECT * FROM users");
                                        System.out.println("Wszyscy użytkownicy: ");
                                        dataBase.DBSelectActions();
                                        tmpoption = Inputs.InputString("Podaj id użytkownika którego chesz usunąć: ");
                                        dataBase.setQuery("SELECT * FROM users WHERE id = " + tmpoption + "");
                                        try {
                                            if (tmpoption.equals(String.valueOf(user.getId()))) {
                                                System.out.println("Nie możesz usunąć użytkownika na którym się znajdujesz");
                                            } else if (dataBase.DBCheckIfExists()) {
                                                String tmpconf = Inputs.InputString("Czy napeno chcesz usunąć użytkownika o ID: " + tmpoption + "? T/N: ");
                                                if (tmpconf.equals("T") || tmpconf.equals("t")) {
                                                    dataBase.setQuery("DELETE FROM users WHERE `users`.`id` = " + tmpoption + "");
                                                    dataBase.AddAction();
                                                    System.out.println("Uzytkownik został usunięty!");
                                                    break;
                                                } else {
                                                    System.out.println("Użytkownik nie został usunięty!");
                                                    break;
                                                }
                                            } else {
                                                System.out.println("Brak uzytkownika w bazie!");
                                            }
                                        } catch (RuntimeException re){
                                            System.out.println("Podano ciag znaków zamiast liczby");
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                break;
                            case 10:
                                user.setTime(now.format(formater));
                                dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'Exit', '" + user.getTime() + "', " + user.getId() + ");");
                                dataBase.AddAction();
                                OpenMenu();
                                break;
                            case 11:
                                String conf;
                                conf = Inputs.InputString("Czy napewno chcesz wyjść? (T/N): ");
                                if (conf.equals("t") || conf.equals("T")) {
                                    now = LocalDateTime.now();
                                    user.setTime(now.format(formater));
                                    dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'Exit', '" + user.getTime() + "', " + user.getId() + ");");
                                    dataBase.AddAction();
                                    System.exit(1);
                                }
                                break;
                            default:
                                break;
                        }
                    }

                } else if (!user.isAuthorized() && !doors.isLocked()) {
                    //wejscie do panelu uzytkownika gdzie moze zglaszac usterki itd
                    user.setTime(now.format(formater));
                    dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'Entry', '" + user.getTime() + "', " + user.getId() + ");");
                    dataBase.AddAction();
                    while (true) {
                        System.out.println("\n=================================| Witaj " + user.getName() + "! |=================================");
                        System.out.println("\t\t\t\t\tWszedłeś do budynku o " + now.format(formater));
                        System.out.println("1. Ogólne informacje\n" +
                                "2. Otwórz/Zamknij okna\n" +
                                "3. Otwóz/Zamknij drzwi\n" +
                                "4. Włącz/Wyłącz światło\n" +
                                "5. Otwórz/Zamknij kran\n" +
                                "6. Zgłoś sprawe do administratora budynku\n" +
                                "7. Wyjdź z budynku\n" +
                                "8. Wyłącz program");
                        System.out.println("==================================================================================");
                        System.out.println("* Co chcesz zrobić? *");
                        try {
                            option = Inputs.InputInt("Wpisz opcje: ");
                        } catch (InputMismatchException e) {
                            System.out.println("Podałeś ciag znakow zamiast cyfry!");
                            option = 0;
                        }
                        System.out.println();
                        switch (option) {
                            case 1:                         //opcja sprawdzenia temperatury
                                System.out.println("Ogólne informacje:");
                                System.out.println(water);
                                System.out.println(air);
                                System.out.println(doors);
                                System.out.println(windows);
                                System.out.println(electricity);
                                System.out.println();
                                break;
                            case 2:                         //opcja otwarcia okien jeśli drzwi są odblokowane to program zamknie je lub otworzy, zmiana zostanie wprowadzona do bazy danych w tabeli actions
                                windows.Open();
                                if (!windows.isLocked()) {
                                    if (windows.isOpen()) {
                                        dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'WinOpn', '" + user.getTime() + "', " + user.getId() + ");");
                                        dataBase.AddAction();
                                    } else {
                                        dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'WinClsd', '" + user.getTime() + "', " + user.getId() + ");");
                                        dataBase.AddAction();
                                    }
                                }
                                break;
                            case 3:                          //opcja otwarcia drzwi jeśli drzwi są odblokowane to program zamknie je lub otworzy, zmiana zostanie wprowadzona do bazy danych w tabeli actions
                                doors.Open();
                                if (!doors.isLocked()) {
                                    if (doors.isOpen()) {
                                        dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'DrsOpn', '" + user.getTime() + "', " + user.getId() + ");");
                                        dataBase.AddAction();
                                    } else {
                                        dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'DrsClsd', '" + user.getTime() + "', " + user.getId() + ");");
                                        dataBase.AddAction();
                                    }
                                }
                                break;
                            case 4:                          //opcja włączenia świateł jeśli jest prąd w budynku jest włączony, zmiana zostanie wprowadzona do bazy danych w tabeli actions
                                electricity.Turn();
                                if (!electricity.isCutOff()) {
                                    if (electricity.lights) {
                                        dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'LhgtOn', '" + user.getTime() + "', " + user.getId() + ");");
                                        dataBase.AddAction();
                                    } else {
                                        dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'LghtOff', '" + user.getTime() + "', " + user.getId() + ");");
                                        dataBase.AddAction();
                                    }
                                }
                                break;
                            case 5:                           //opcja włączenia wody jeśli jest zawór jest otwarty, zmiana zostanie wprowadzona do bazy danych w tabeli actions
                                water.RunWater();
                                if (!water.isCutOff) {
                                    if (water.running) {
                                        dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'WtrOn', '" + user.getTime() + "', " + user.getId() + ");");
                                        dataBase.AddAction();
                                    } else {
                                        dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'WtfOff', '" + user.getTime() + "', " + user.getId() + ");");
                                        dataBase.AddAction();
                                    }

                                }
                                break;
                            case 6:                             //po wybraniu tej opcji wyswietla sie pole tekstowe w ktorym wpisujemy problem, problem zostaje wyslany do bazy danych w tabelce tickets, moze je wyswietlac administrator
                                String ticketmsg = Inputs.InputString("Opisz krótko sprawę(45 znaków): ");
                                while (true) {
                                    if (ticketmsg.length() <= 45) {
                                        ticket.setMessage(ticketmsg);
                                        now = LocalDateTime.now();
                                        user.setTime(now.format(formater));
                                        dataBase.setQuery("INSERT INTO `tickets` (`id`, `user_id`, `message`, `date`) VALUES (NULL, '" + user.getId() + "', '" + ticket.getMessage() + "', '" + user.getTime() + "')");
                                        dataBase.AddAction();
                                        System.out.println("Sprawa została zgłoszona!\n");
                                        break;
                                    } else {
                                        ticketmsg = Inputs.InputString("Opisz krótko sprawę(45 znaków): ");
                                    }
                                }
                                break;
                            case 7:                             //wyjscie z budynku, powrot do pola logowania, zapisuje w bazie danych uzytkownika i godzine w ktorej wyszedl
                                user.setTime(now.format(formater));
                                dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'Exit', '" + user.getTime() + "', " + user.getId() + ");");
                                dataBase.AddAction();
                                OpenMenu();
                                break;
                            case 8:                             //wyjscie z programu po potwierdzeniu, zapisuje w bazie danych uzytkownika i godzine w ktorej wyszedl
                                String conf;
                                conf = Inputs.InputString("Czy napewno chcesz wyjść? (T/N): ");
                                if (conf.equals("T") || conf.equals("t")) {
                                    now = LocalDateTime.now();
                                    user.setTime(now.format(formater));
                                    dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'Exit', '" + user.getTime() + "', " + user.getId() + ");");
                                    dataBase.AddAction();
                                    System.exit(1);
                                }
                                break;
                            default:
                                break;
                        }
                    }

                } else {
                    //program prosi o 3 krotne wpisanie poprawnych danych do wejscia
                    burglary.setAcces_Denied_Counter(attempts++);
                    System.out.println("Błędny kod lub id! Wprowadź poprawne dane! Drzwi moga być też zamknięte, Poczekaj na administratora!\nTwoja próba: " + burglary.getAcces_Denied_Counter());

                    if (burglary.getAcces_Denied_Counter() == 3) {
                        System.out.println("Próba włamania zosała zgłoszona! Policja przyjedzie w ciągu następnej godziny :)");
                        System.exit(1);
                    } else {
                        OpenMenu();
                    }
                }

            } else {
                //program prosi o 3 krotne wpisanie poprawnych danych do wejscia
                burglary.setAcces_Denied_Counter(attempts++);
                System.out.println("Błędny kod lub id! Wprowadź poprawne dane!\nTwoja próba: " + burglary.getAcces_Denied_Counter());

                if (burglary.getAcces_Denied_Counter() == 3) {
                    System.out.println("Próba włamania zosała zgłoszona! Policja przyjedzie w ciągu następnej godziny :)");
                    System.exit(1);
                } else {
                    OpenMenu();
                }
            }
        }
    }
}