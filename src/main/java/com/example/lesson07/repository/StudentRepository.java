package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	// extends에 JPA라는 것, Entity의 타입, Id의 타입 을 넣어준다.
	// extends JpaRepository<StudentEntity, Integer>
	
	// Spring date JPA
	
	// Select, Update => 엔티티 save(엔티티) 메소드의 작동 방식
	// -> 1. insert(id가 null)
	// 2. update(id가 있음)
	
	// 엔티티 findById(id) => 해당 id의 엔티티 하나가 나온다. (이미 정해져 있음)
	// 단, 해당 엔티티는 Optional<엔티티> 형태로 나온다 => 추가 조치 필요.
	// -> orElse(null) => 해당 id의 정보가 존재하면 <엔티티>, 없으면 null로 리턴한다.
	
	// Delete => void delete(엔티티객체)
	
	// List<엔티티객체> findAll(); => 모든 행 전제 select
	
	// ex02/1 - JPQL: 함수명만 잘 만들면 알아서 잘 만들어서 돌려줌?
	// 2. order by id desc
	public List<StudentEntity> findAllByOrderByIdDesc(); // 이름만 정확하면 알아서 만들어준다.
	// 3. order by id desc limit 3
	public List<StudentEntity> findTop3ByOrderByIdDesc(); 
	// 4. Where = name
	public List<StudentEntity> findByName(String name); 
	// 5. where name in("", "", "")
	public List<StudentEntity> findByNameIn(List<String> names); 
	// 6. where name="" and dreamjob=""
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob); 
	// 7. where email like %""%
	public List<StudentEntity> findByEmailContaining(String email); 
	// 8. where name like 김%  (startsWith, 메소드 이름은 좀 다름
	public List<StudentEntity> findByNameStartingWith(String name); 
	// 9. between 1~5 (1, 5 포함)
	public List<StudentEntity> findByIdBetween(int startId, int endId); // 변수명은 딱히 상관없음 
	
	
	
	
	// 어디서 오류가 나서 수정한다고 인터페이스를 클래스로 만듬
//	@PersistenceContext
//	private EntityManager em; // JPA 역활 / 결국 이 아래의 코드들이 interface에 들어있는거나 마찬가지이다.
//	
//	public StudentEntity save(StudentEntity studentEntity) {
//		em.persist(studentEntity);
//		return studentEntity;
//	}
}
