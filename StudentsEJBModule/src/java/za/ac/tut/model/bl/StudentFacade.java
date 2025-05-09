/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model.bl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.model.entity.Student;

/**
 *
 * @author Hello
 */
@Stateless
public class StudentFacade extends AbstractFacade<Student> implements StudentFacadeLocal {

    @PersistenceContext(unitName = "StudentsEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }

    @Override
    public List<Student> getStudentByGender(Character gender) {
        Query query=em.createQuery("SELECT s FROM Student s WHERE s.gender=?1");
        query.setParameter(1, gender);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public List<Student> getStudentPassed() {
        Query query=em.createQuery("SELECT s FROM Student s WHERE s.markObtainted>49");
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public List<Student> getStudentFailed() {
        Query query=em.createQuery("SELECT s FROM Student s WHERE s.markObtainted<50");
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public Long getStudentCount() {
        Query query=em.createQuery("SELECT COUNT(s) FROM Student s");
        Long cnt =(Long)query.getSingleResult();
        
        return cnt;
    }

    @Override
    public Long getTotalPassed() {
        Query query =em.createQuery("SELECT COUNT(s) FROM Student s WHERE s.markObtainted>49");
        Long cnt = (Long)query.getSingleResult();
        return cnt;
    }

    @Override
    public Long getTotalFailed() {
        Query query =em.createQuery("SELECT COUNT(s) FROM Student s WHERE s.markObtainted<50");
        Long cnt = (Long)query.getSingleResult();
        return cnt;
    }

    @Override
    public Double getAvgMark() {
        Query query=em.createQuery("SELECT(s.markObtainted) FROM Student s");
        Double avg = (Double)query.getSingleResult();
        return avg;
    }

    @Override
    public Integer getMaximunMark() {
        Query query=em.createQuery("SELECT MAX(s.markObtainted) FROM Student s");
        Integer mark = (Integer)query.getSingleResult();
        return mark;
    }

    @Override
    public Integer getMinimunMark() {
        Query query=em.createQuery("SELECT MIN(s.markObtainted) FROM Student s");
        Integer mark = (Integer)query.getSingleResult();
        return mark;
    }
    
}
