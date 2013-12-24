/*
 * package com.aptech.repository;
 * 
 * import java.util.List;
 * 
 * import javax.persistence.EntityManager; import
 * javax.persistence.NoResultException; import
 * javax.persistence.PersistenceContext; import javax.persistence.TypedQuery;
 * 
 * import org.springframework.stereotype.Repository;
 * 
 * import com.aptech.model.Employee;
 * 
 * @Repository("employeeRepository") public class EmployeeRepositoryImpl
 * implements EmployeeRepository {
 * 
 * @PersistenceContext private EntityManager em;
 * 
 * 
 * (non-Javadoc)
 * 
 * @see com.aptech.repository.EmployeeRepository#findAll(int, int)
 * 
 * @Override public List<Employee> findAll(int page, int pageSize) {
 * TypedQuery<Employee> query = em.createNamedQuery(Employee.FIND_ALL,
 * Employee.class);
 * 
 * query.setFirstResult(page * pageSize); query.setMaxResults(pageSize);
 * 
 * return query.getResultList(); }
 * 
 * 
 * (non-Javadoc)
 * 
 * @see com.aptech.repository.EmployeeRepository#findByEmail(java.lang.String)
 * 
 * @Override public List<Employee> findByEmail(String email) { try {
 * TypedQuery<Employee> query = em.createNamedQuery( Employee.FIND_BY_EMAIL,
 * Employee.class);
 * 
 * return query.setParameter("email", email).getResultList(); } catch
 * (NoResultException ex) { return null; } }
 * 
 * 
 * (non-Javadoc)
 * 
 * @see
 * com.aptech.repository.EmployeeRepository#findByFullName(java.lang.String)
 * 
 * @Override public List<Employee> findByFullName(String fullName) {
 * TypedQuery<Employee> query = em.createNamedQuery( Employee.FIND_BY_FULL_NAME,
 * Employee.class);
 * 
 * return query.setParameter("fullName", "%" + fullName + "%") .getResultList();
 * }
 * 
 * 
 * (non-Javadoc)
 * 
 * @see com.aptech.repository.EmployeeRepository#findById(Long)
 * 
 * @Override public Employee findById(Long employeeId) {
 * 
 * return em.find(Employee.class, employeeId); }
 * 
 * 
 * (non-Javadoc)
 * 
 * @see
 * com.aptech.repository.EmployeeRepository#findByUserRole(java.lang.String)
 * 
 * @Override public List<Employee> findByUserRole(String roleName) { try {
 * TypedQuery<Employee> query = em.createNamedQuery( Employee.FIND_BY_USER_ROLE,
 * Employee.class);
 * 
 * return query.setParameter("roleName", roleName).getResultList(); } catch
 * (NoResultException ex) { return null; } }
 * 
 * 
 * (non-Javadoc)
 * 
 * @see com.aptech.repository.EmployeeRepository#save(com.aptech.model.Employee)
 * 
 * @Override public Employee save(Employee employee) {
 * 
 * if (employee.getId() == null) { em.persist(employee); em.flush(); } else {
 * em.merge(employee); }
 * 
 * return employee; } }
 */