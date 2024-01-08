package Itemdle;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class DataBase {
    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public DataBase() {
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

    public List<ItemsEntity> getEntityToList(){
        try(Session session = factory.openSession()){
            Query query = session.createQuery("from ItemsEntity");
            List<ItemsEntity> itmList = query.list();
            return itmList;
        }
    }
    public List<ItemsEntity> getRandomItem(int index){
        try(Session session = factory.openSession()){
            Query query = session.createQuery("from ItemsEntity IE where IE.item_id="+index);
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


    public void saveStats(StatsEntity stats){
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            session.save(stats);
            tx.commit();
        }
    }
}
