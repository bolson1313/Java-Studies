package project;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Menu {

    public int id, AccesCode;
    private int attempts = 1;

    public Menu() {
    }

    public void OpenMenu(){
        //pole do logowania
        this.id = Inputs.InputInt("Podaj id: ");
        this.AccesCode = Inputs.InputInt("Podaj kod dostępu: ");

        //tworzenie obiektów wszystkich klas
        Burglary burglary = new Burglary(0);
        DataBase dataBase = new DataBase("SELECT id, name, surname, acces_code, authorized FROM users WHERE id="+id+ " AND acces_code="+AccesCode);
        User user = dataBase.DBCheckUser(id, AccesCode);
        Water water = new Water();
        Air air = new Air();
        Doors doors = new Doors();
        Windows windows = new Windows();
        Electricity electricity = new Electricity();
        Ticket ticket = new Ticket();
        //zmienne dodatkowe
        int option;

        //aktualna data i godzina aby rejestrować ruch w budynku
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        //walidacja logowania
        if(user != null){
            //jesli uzytkownik istnieje program sprawdzi czy ma on dostep do panelu administratora oraz wyswietli odpowiednie menu
            if(user.isAuthorized()){
                //wejscie do panelu admina jedynie gdy uzytkownik jest autoryzowany
                user.setTime(now.format(formater));
                dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'wejscie', '"+user.getTime()+"', "+user.getId()+");");
                dataBase.AddAction();
                while(true){
                    System.out.println("======================| Witaj W panelu administracyjnym "+user.getName()+ "! |======================");
                    System.out.println("\t\t\t\t\tWszedłeś do budynku o "+now.format(formater));
                    System.out.println("1. Sprawdź temperaturę powietrza oraz powietrza\n" +
                            "2. Odblokuj/Zablokuj okna w budynku\n" +
                            "3. Odblokuj/Zablokuj drzwi w budynku\n" +
                            "4. Włącz/Wyłącz całą sieć elektryczną w budynku\n" +
                            "5. Włącz/Wyłącz światła w budynku\n" +
                            "6. Odetnij wodę w budynku\n" +
                            "7. Sprawdź sprawy zglaszane przez lokatrowów\n" +
                            "8. Sprwadź liste akcji\n" +
                            "9. Wyjdź z budynku\n" +
                            "10. Wyłącz program");
                    System.out.println("==================================================================================");
                    System.out.println("* Co chcesz zrobić? *");
                    option = Inputs.InputInt("Wpisz opcje: ");
                    switch (option){
                        case 1:
                            System.out.println(water);
                            System.out.println(air);
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
                            dataBase.setQuery("SELECT * FROM tickets");
                            dataBase.DBSelectAll();
                            break;
                        case 8:
                            dataBase.setQuery("SELECT * FROM actions");
                            System.out.println("Co sie działo w budynku: ");
                            dataBase.DBSelectAll();
                            break;
                        case 9:
                            user.setTime(now.format(formater));
                            dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'wyjscie', '"+user.getTime()+"', "+user.getId()+");");
                            dataBase.AddAction();
                            OpenMenu();
                            break;
                        case 10:
                            String conf;
                            conf = Inputs.InputString("Czy napewno chcesz wyjść? (Y/N): ");
                            if(conf.equals("Y") || conf.equals("y")){
                                now = LocalDateTime.now();
                                user.setTime(now.format(formater));
                                dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'wyjscie', '"+user.getTime()+"', "+user.getId()+");");
                                dataBase.AddAction();
                                System.exit(1);
                            }
                            break;
                        default:
                            break;
                    }
                }

            }else if(!user.isAuthorized() && !doors.isLocked()) {
                //wejscie do panelu uzytkownika gdzie moze zglaszac usterki itd
                user.setTime(now.format(formater));
                dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'wejscie', '"+user.getTime()+"', "+user.getId()+");");
                dataBase.AddAction();
                while(true){
                    System.out.println("=================================| Witaj "+user.getName()+ "! |=================================");
                    System.out.println("\t\t\t\t\tWszedłeś do budynku o "+now.format(formater));
                    System.out.println("1. Sprawdź temperaturę powietrza oraz wody\n" +
                            "2. Otwórz drzwi\n" +
                            "3. Otwóz okno\n" +
                            "4. Włącz światło\n" +
                            "5. Otwórz wodę\n" +
                            "6. Zgłoś sprawe do administratora budynku\n" +
                            "7. Wyjdź z budynku\n" +
                            "8. Wyłącz program");
                    System.out.println("==================================================================================");
                    System.out.println("* Co chcesz zrobić? *");
                    option = Inputs.InputInt("Wpisz opcje: ");
                    switch (option){
                        case 1:
                            System.out.println(water);
                            System.out.println(air);
                            break;
                        case 2:
                            windows.Open();
                            if(windows.isLocked()){
                                dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'WinClsd', '"+user.getTime()+"', "+user.getId()+");");
                            }else{
                                dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'WinOpn', '"+user.getTime()+"', "+user.getId()+");");
                            }
                            dataBase.AddAction();
                            break;
                        case 3:
                            doors.Open();
                            if(windows.isLocked()){
                                dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'DrsClsd', '"+user.getTime()+"', "+user.getId()+");");
                            }else{
                                dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'DrsOpn', '"+user.getTime()+"', "+user.getId()+");");
                            }
                            dataBase.AddAction();
                            break;
                        case 4:
                            electricity.Turn();
                            if(electricity.lights){
                                dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'LghOn', '"+user.getTime()+"', "+user.getId()+");");
                            }else{
                                dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'LghOff', '"+user.getTime()+"', "+user.getId()+");");
                            }
                            break;
                        case 5:
                            water.RunWater();
                            if(water.running){
                                dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'WtrOn', '"+user.getTime()+"', "+user.getId()+");");
                            }else {
                                dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'WtrOff', '" + user.getTime() + "', " + user.getId() + ");");
                            }
                            break;
                        case 6:
                            ticket.setMessage(Inputs.InputString("Opisz krótko sprawę: "));
                            now = LocalDateTime.now();
                            user.setTime(now.format(formater));
                            dataBase.setQuery("INSERT INTO `tickets` (`id`, `user_id`, `message`, `date`) VALUES (NULL, '"+user.getId()+"', '"+ticket.getMessage()+"', '"+user.getTime()+"')");
                            break;
                        case 7:
                            user.setTime(now.format(formater));
                            dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'wyjscie', '"+user.getTime()+"', "+user.getId()+");");
                            dataBase.AddAction();
                            OpenMenu();
                            break;
                        case 8:
                            String conf;
                            conf = Inputs.InputString("Czy napewno chcesz wyjść? (Y/N): ");
                            if(conf.equals("Y") || conf.equals("y")){
                                now = LocalDateTime.now();
                                user.setTime(now.format(formater));
                                dataBase.setQuery("INSERT INTO `actions` (`id`, `action`, `date`, `user_id`) VALUES (NULL, 'wyjscie', '"+user.getTime()+"', "+user.getId()+");");
                                dataBase.AddAction();
                                System.exit(1);
                            }
                            break;
                        default:
                            break;
                    }
                }

            }

        }else {
            //program prosi o 3 krotne wpisanie poprawnych danych do wejscia
            burglary.setAcces_Denied_Counter(attempts++);
            System.out.println("Błędny kod lub id! Wprowadź poprawne dane! Drzwi mogą być również zablokowane!\nTwoje próby: "+burglary.getAcces_Denied_Counter());

            if(burglary.getAcces_Denied_Counter()==3){
                System.out.println("Próba włamania zosała zgłoszona! Policja przyjedzie w ciągu następnej godziny :)");
            }else {
                OpenMenu();
            }
        }

    }
}
