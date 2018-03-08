package com.visites.agent.repository;

import com.visites.agent.model.Agent;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.List;

public class AgentRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ini_PU");


    public int Create(String first_name, String last_name, String telephone) {

        EntityManager emf = entityManagerFactory.createEntityManager();
        Session session = (Session) emf.getDelegate();

        session.getTransaction().begin();

        Agent agent = new Agent();
        agent.setFirst_name(first_name);
        agent.setLast_name(last_name);
        agent.setTelephone(telephone);

        int id = (Integer) session.save(agent);

        session.getTransaction().commit();

        emf.close();

        return id;
    }

    public String Read(int id) {

        EntityManager emf = entityManagerFactory.createEntityManager();

        Query query = emf.createQuery("SELECT i FROM Agent i WHERE i.id = :id");

        query.setParameter("id", id);

        Agent res = (Agent) query.getSingleResult();

        emf.close();

        return res.toString();
    }

    public int Update(int id, String first_name, String last_name, String telephone) {

        EntityManager emf = entityManagerFactory.createEntityManager();
        Session session = (Session) emf.getDelegate();

        session.getTransaction().begin();

        Query query = emf.createQuery("UPDATE Agent i SET i.first_name = :first_name, i.last_name = :last_name, i.telephone = :telephone WHERE i.id = :id");

        query.setParameter("first_name", first_name);
        query.setParameter("last_name", last_name);
        query.setParameter("telephone", telephone);
        query.setParameter("id", id);

        int res = query.executeUpdate();

        session.getTransaction().commit();

        emf.close();

        return res;
    }

    public int Delete(int id) {

        EntityManager emf = entityManagerFactory.createEntityManager();
        Session session = (Session) emf.getDelegate();

        session.getTransaction().begin();

        Query query = emf.createQuery("DELETE FROM Agent i WHERE i.id = :id");
        query.setParameter("id", id);

        int res = query.executeUpdate();

        session.getTransaction().commit();

        emf.close();

        return res;
    }

    public List All() {
        EntityManager emf = entityManagerFactory.createEntityManager();
        Session session = (Session) emf.getDelegate();

        session.getTransaction().begin();

        Query query = emf.createQuery("FROM Agent i");

        List res = query.getResultList();

        session.getTransaction().commit();

        emf.close();

        return res;
    }
}
