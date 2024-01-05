package com.example.lesson07.repository;

import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class StudentRepository {
	// extends에 JPA라는 것, Entity의 타입, Id의 타입 을 넣어준다.
	// extends JpaRepository<StudentEntity, Integer>
	
	// 어디서 오류가 나서 수정한다고 인터페이스를 클래스로 만듬
	
	@PersistenceContext
	private EntityManager em; // JPA 역활 / 결국 이 아래의 코드들이 interface에 들어있는거나 마찬가지이다.
	
	public StudentEntity save(StudentEntity studentEntity) {
		em.persist(studentEntity);
		return studentEntity;
	}
}
