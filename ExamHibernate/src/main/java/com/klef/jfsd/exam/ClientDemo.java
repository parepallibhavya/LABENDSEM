package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo 
{
    public static void main(String args[])
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
        
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 
        
        Transaction t = session.beginTransaction(); 
        
        Animal a = new Animal();
        a.setName("hen");
        a.setVegetarian(true);
        a.setFood("Rice");
        a.setLegs(4);
        
        session.save(a);
        
        Dog d = new Dog();
        d.setBreed("german shepherd");
        d.setColor("brown");
        
        session.save(d);
        
        Cat c = new Cat();
        c.setBreed("catdoll");
        c.setColor("white");
        
        session.save(c);
        
        t.commit();
        
        System.out.println("Success..");
        
        session.close();
        sf.close();
    }
}
