package Itemdle;


import org.hibernate.HibernateException;
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
            for (ItemsEntity emp : empList) {
                returnArray.add(emp.getName());
            }

            return returnArray;
        }
    }

    public List<ItemsEntity> getEntityToListByName(String itemName) {
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("from ItemsEntity IE where IE.name=:itemName");
            query.setParameter("itemName", itemName);
            List<ItemsEntity> itmList = query.list();
            //System.out.println(itmList.toString());
            return itmList;
        }
    }

    public List<ItemsEntity> getEntityToList() {
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("from ItemsEntity");
            List<ItemsEntity> itmList = query.list();
            return itmList;
        }
    }

    public List<ItemsEntity> getRandomItemByName(String itemName) {
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("from ItemsEntity IE where IE.name=:itemName");
            query.setParameter("itemName", itemName);
            List<ItemsEntity> itmList = query.list();
            //System.out.println(itmList.toString());
            return itmList;
        }
    }

    public List<StatsEntity> getStatsToList() {
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("FROM StatsEntity se");
            List<StatsEntity> statsList = query.list();
            //System.out.println(statsList.toString());
            return statsList;
        }
    }


    public void saveStats(StatsEntity stats) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(stats);
            tx.commit();
        }
    }

    public void addItem(ItemsEntity item) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(item);
            tx.commit();
        }
    }

    public void updateItem(ItemsEntity updatedItem) {
        Transaction transaction = null;

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            ItemsEntity existingItem = session.get(ItemsEntity.class, updatedItem.getItem_id());

            if (existingItem != null) {
                // Update cells
                existingItem.setName(updatedItem.getName());
                existingItem.setUser(updatedItem.getUser());
                existingItem.setTag(updatedItem.getTag());
                existingItem.setEffect(updatedItem.getEffect());
                existingItem.setQuality(updatedItem.getQuality());
                existingItem.setPrice(updatedItem.getPrice());
                existingItem.setBuyable(updatedItem.isBuyable());
                existingItem.setUpgrade(updatedItem.isUpgrade());

                session.update(existingItem);
                transaction.commit();
            } else {
                System.out.println("Item with ID " + updatedItem.getItem_id() + " not found.");
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public void deleteItemByName(String itemName) {
        Transaction transaction = null;

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();

            // get items entity by name
            Query query = session.createQuery("from ItemsEntity IE where IE.name=:itemName");
            query.setParameter("itemName", itemName);
            ItemsEntity existingItem = (ItemsEntity) query.uniqueResult();

            if (existingItem != null) {
                session.delete(existingItem);
                transaction.commit();
            } else {
                System.out.println("Item with name '" + itemName + "' not found.");
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
