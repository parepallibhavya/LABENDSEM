package com.klef.jfsd.exam1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {

    public static void main(String[] args) {
        ClientDemo clientDemo = new ClientDemo();
        //clientDemo.insertClient();
       clientDemo.displayClients();
    }

    private void insertClient() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Client client = new Client();
        client.setName("Bhasree");
        client.setGender("Female");
        client.setAge(11);
        client.setLocation("vijayawada");
        client.setEmail("bhasree@gmail.com");
        client.setMobile("9988008709");

        session.persist(client);

        transaction.commit();
        System.out.println("Client added successfully: " + client);
        session.close();
        sessionFactory.close();
    }

    private void displayClients() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Client> query = session.createQuery("FROM Client", Client.class);
        List<Client> clients = query.getResultList();

        System.out.println("List of all clients:");
        for (Client client : clients) {
            System.out.println(client);
        }
        session.close();
        sessionFactory.close();
    }
}
