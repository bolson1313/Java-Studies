package project;

import java.sql.*;

public class DataBase {
    private String query;
    private final String DBPath = "jdbc:mysql://localhost:3306/buildingdb";
    private final String DBUser = "root";
    private final String DBPassword = "";

    public DataBase(String query) {
        this.query = query;
    }

    public void setQuery(String query) {
        this.query = query;
    }


    //metoda zwraca i tworzy obiekt klasy User na podstawie bazy danych
    public User DBCheckUser(int id, int acces_code){
        Connection connect = null;
        User user=null;
        try {
            connect = DriverManager.getConnection(DBPath, DBUser, DBPassword);
            Statement statement = connect.createStatement();
            ResultSet result = statement.executeQuery(query);  //wykonanie kwerendy selct
            if(result.next()){
                user = new User(result.getInt(1),result.getString(2), result.getString(3), result.getInt(4), result.getBoolean(5));
            }
            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    //metoda do monitorowania akcji uzytkownika
    public void AddAction(){
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(DBPath, DBUser, DBPassword);
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);
            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //metoda wypisuje wszystkie sprawy do administracji
    public void DBSelectAll(){
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(DBPath, DBUser, DBPassword);
            Statement statement = connect.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                System.out.println("ID: "+result.getInt(1)+" | UserID: "+result.getInt(2)+ " | Message: "+result.getString(3)+" | Time: "+result.getString(4));
            }
            System.out.println("\n");
            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean DBCheckIfExists(){
        Connection connect = null;
        boolean exists;
        try {
            connect = DriverManager.getConnection(DBPath, DBUser, DBPassword);
            Statement statement = connect.createStatement();
            ResultSet result = statement.executeQuery(query);
            exists =  result.next();
            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exists;
    }

    //metoda wypisuje monit budynku
    public void DBSelectActions(){
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(DBPath, DBUser, DBPassword);
            Statement statement = connect.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                System.out.println("ID: "+result.getInt(1)+" | Action: "+result.getString(2)+" | Date: "+result.getString(3)+" | User PIN: "+result.getInt(4));
            }
            System.out.println("\n");
            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}