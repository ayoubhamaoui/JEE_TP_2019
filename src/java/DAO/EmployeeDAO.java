/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entity.Employee;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author dell
 */
public class EmployeeDAO {
    EntityManager em;
    EntityTransaction tx;
    
    public EmployeeDAO() {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("GestionEmployeePU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    
    public void Add(Employee e){
        try{
            tx.begin();
            em.persist(e);
            tx.commit();
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    public List<Employee>FindAll(){
        Query req= em.createQuery("SELECT e FROM Employee e"); 
        return req.getResultList();
    }
    
}
