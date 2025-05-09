/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.model.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.model.entity.Student;

/**
 *
 * @author Hello
 */
@Local
public interface StudentFacadeLocal {

    void create(Student student);

    void edit(Student student);

    void remove(Student student);

    Student find(Object id);

    List<Student> findAll();

    List<Student> findRange(int[] range);
    List<Student> getStudentByGender(Character gender);
    List<Student> getStudentPassed();
    List<Student> getStudentFailed();
    
    Long getStudentCount();  
    Long getTotalPassed();
    Long getTotalFailed();
    Double getAvgMark();
    Integer getMaximunMark();
    Integer getMinimunMark();
    
    
    
    int count();
    
}
