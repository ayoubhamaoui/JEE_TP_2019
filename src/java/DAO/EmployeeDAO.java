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
        }finally{
            em.close();
        }
    }
    
    public Employee FindByID(Integer em_no){
        Employee e;
        tx.begin();
        e= em.find(Employee.class, em_no);
        tx.commit();
        return e;
    }
    
    public List<Employee>FindAll(){
        Query req= em.createQuery("SELECT e FROM Employee e"); 
        List<Employee> emL = req.getResultList();
        em.close();
        return emL;
    }
    
    public void Delete(Integer em_no){
        try{
            Employee e = em.find(Employee.class, em_no);
            System.out.println("Deletion:"+em_no.toString());
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }finally{
            em.close();
        }
    }
    
    
}
