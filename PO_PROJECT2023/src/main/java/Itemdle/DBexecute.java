package Itemdle;


import org.controlsfx.control.PropertySheet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class DBexecute {
    private final Configuration configuration = new Configuration().configure("file:src/main/resources/Itemdle/hibernate.cfg.xml");
    private final SessionFactory factory = configuration.buildSessionFactory();

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
            System.out.println(itmList.toString());
            return itmList;
        }
    }
    public List<ItemsEntity> getRandomItem(int index){
        try(Session session = factory.openSession()){
            Query query = session.createQuery("from ItemsEntity IE where IE.id="+index);
            List<ItemsEntity> itmList = query.list();
            System.out.println(itmList.toString());
            return itmList;
        }
    }
}
