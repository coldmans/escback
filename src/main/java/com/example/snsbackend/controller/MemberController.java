package com.example.snsbackend.controller;

import com.example.snsbackend.model.Member;
import com.example.snsbackend.service.MockMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MemberController {

    @Autowired
    private MockMemberService mockMemberService;

    // 회원가입 폼 페이지를 표시
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    // 회원가입 처리
    @PostMapping("/api/members/register")
    public String register(@ModelAttribute Member member, Model model) {
        Member existingMember = mockMemberService.findByStudentId(member.getStudentId());

        if (existingMember == null) {
            mockMemberService.register(member);
            return "redirect:/register?success"; // 회원가입 성공 시 리다이렉트
        } else {
            return "redirect:/register?error"; // 이미 등록된 학번인 경우 리다이렉트
        }
    }
}