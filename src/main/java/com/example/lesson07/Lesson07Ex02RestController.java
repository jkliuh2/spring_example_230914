package com.example.lesson07;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RequestMapping("/lesson07/ex02")
@RestController
public class Lesson07Ex02RestController {

	// !) 이번에만 BO생략 -> 바로 Repository로 가져올 것임.
	@Autowired
	private StudentRepository studentRepository;
	
	// Select하는 여러가지 방법
	// url: http://localhost/lesson07/ex02/1
	@GetMapping("/1")
	public List<StudentEntity> getStudentList() {
		// 1. "전체" 조회(기본 제공 메소드)
		// return studentRepository.findAll();
		
		// 2. id 기준 내림차순 "전체" 조회
		//return studentRepository.findAllByOrderByIdDesc();
		// 에러 -> 이런 메소드 없으니까 => Repository에 정의해야함
		
		// 3. id 기준 내림차순 + limit 3(Top3)
		//return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4. name=김바다 조회
		//return studentRepository.findByName("김바다");
		
		// 5. in문으로 일치하는 값 모두 조회(이름)
		//return studentRepository.findByNameIn(Arrays.asList("유재석", "조세호", "홍길동")); 
		// 이름을 배열로 묶어서 보내는 개념. asList 말고도 다른거 써도 무관
		
		// 6. 여러 컬럼값과 일치하는 데이터 조회(이름 And 장래희망)
		//return studentRepository.findByNameAndDreamJob("홍길동", "의적");
		
		// 7. email 컬럼에 naver.com 키워드가 포함된 데이터 조회(like문 - %naver%)
		//return studentRepository.findByEmailContaining("naver");
		// Contains, Containing 둘다 똑같음. 오히려 Like는 "키워드가 일치"해야 가져온다.
		
		// 8. name이 "김" 으로 시작하는 데이터 조회(like - 김%)
		//return studentRepository.findByNameStartingWith("김");
		// 메소드 이름 주의
		
		// 9. id가 1 ~ 5 인 데이터 조회(between)(1이상 5이하)
		return studentRepository.findByIdBetween(1, 5);
	}
}
