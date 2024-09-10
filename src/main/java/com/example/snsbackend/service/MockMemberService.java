package com.example.snsbackend.service;

import com.example.snsbackend.model.Member;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class MockMemberService {
    private Map<String, Member> mockDatabase = new HashMap<>();

    // 목데이터
    public MockMemberService() {
        Member member1 = new Member();
        member1.setStudentId("20191111");
        member1.setName("홍길동");
        member1.setEmail("Inu@inu.ac.kr");
        member1.setPassword("1234");
        member1.setMajor("컴퓨터공학과");
        member1.setGraduation("N");

        Member member2 = new Member();
        member2.setStudentId("20192222");
        member2.setName("김철수");
        member2.setEmail("Inu2@inu.ac.kr");
        member2.setPassword("1234");
        member2.setMajor("임베디드시스템공학과");
        member2.setGraduation("N");

        mockDatabase.put(member1.getStudentId(), member1);
        mockDatabase.put(member2.getStudentId(), member2);
    }

    // 학번으로 회원정보 찾기
    public Member findByStudentId(String studentId) {
        return mockDatabase.get(studentId);
    }

    // 회웝가입

    public String register(Member member) {
        if (mockDatabase.containsKey(member.getStudentId())) {
            return "이미 가입된 학번입니다.";
        }
        mockDatabase.put(member.getStudentId(), member);
        return "가입 성공";
    }
}
