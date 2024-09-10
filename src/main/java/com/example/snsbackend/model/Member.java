package com.example.snsbackend.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class Member {
    private String studentId; // 학번
    private String name; // 이름
    private String email; // 이메일
    private String password; // 비밀번호
    private String major; // 전공
    private String graduation; // 졸업여부
}
