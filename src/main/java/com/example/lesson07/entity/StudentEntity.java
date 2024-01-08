package com.example.lesson07.entity;

import java.time.ZonedDateTime;
import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // 객체를 출력 시 필드 값이 보여진다. (없어도 되지만 있으면 유용)
@AllArgsConstructor // 모든 파라미터 있는 생성자
@NoArgsConstructor // 파라미터 없는 생성자
@Builder(toBuilder = true) // setter 대신에 사용 / tobuilder = true : 필드값 변경 허용
@Getter // 오직 getter만
@Table(name = "new_student") // 이게 없으면 테이블명이 student_entity 인줄 안다.
@Entity // 이 객체는 엔티티다. (JPA - DB)간 통신할 때, 이 객체를 가지고 통신한다.
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	id;
	
	private String name;
	
	@Column(name = "phoneNumber") // 이거 없으면 (_)로 자동변환 한다.
	private String phoneNumber; // 카멜케이스에는 어노테이션 걸어줘야 된다.
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp // createdAt이 null이어도 현재시간으로 저장. 
	@Column(name = "createdAt", updatable = false) // 업데이트시 변경되지 않도록 설정.
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
	// ZonedDateTime: timezone 정보가 있는 Date 타입
}
