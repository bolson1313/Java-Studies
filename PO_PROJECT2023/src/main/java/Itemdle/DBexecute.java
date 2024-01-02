package Itemdle;


import org.controlsfx.control.PropertySheet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class DBexecute {
    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();


    public DBexecute() {
    }

    public ArrayList<String> getItemsToArray() {
        ArrayList<String> returnArray = new ArrayList<>();
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("from ItemsEntity");
            List<ItemsEntity> empList = query.list();
            for(ItemsEntity emp : empList){
                returnArray.add(emp.getName());
            }

            return returnArray;
        }
    }

    public List<ItemsEntity> getEntityToList(String name){
        try(Session session = factory.openSession()){
            Query query = session.createQuery("from ItemsEntity IE where IE.name='"+name+"'");
            List<ItemsEntity> itmList = query.list();
            //System.out.println(itmList.toString());
            return itmList;
        }
    }
    public List<ItemsEntity> getRandomItem(int index){
        try(Session session = factory.openSession()){
            Query query = session.createQuery("from ItemsEntity IE where IE.id="+index);
            List<ItemsEntity> itmList = query.list();
            //System.out.println(itmList.toString());
            return itmList;
        }
    }

    public List<StatsEntity> getStatsToList(){
        try(Session session = factory.openSession()){
            Query query = session.createQuery("FROM StatsEntity se");
            List<StatsEntity> statsList = query.list();
            //System.out.println(statsList.toString());
            return statsList;
        }
    }

    public void insertStat(Stats stats){
        try(Session session = factory.openSession()){
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("INSERT StatsEntity (id, itemName, tries, datetime) VALUES (null, '"+stats.getItemName()+"', "+stats.getTries()+", '"+stats.getDatetime()+"')");
            query.executeUpdate();
            transaction.commit();
        }
    }
}
