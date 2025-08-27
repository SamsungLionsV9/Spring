package com.example.first.project.controller;

import org.springframework.ui.Model;
import com.example.first.project.dto.MemberForm;
import com.example.first.project.entity.Member;
import com.example.first.project.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/members/new")
    public String newMember() {
        return "members/new";
    }

    @PostMapping("/members/create")
    public String createMember(MemberForm memberForm) {
        log.info(memberForm.toString());
        Member member = memberForm.toEntity();
        log.info(member.toString());
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        return "";
    }

    @GetMapping("/members/{email}")
    public String show(@PathVariable String email, Model model) {
        Member memberEntity = memberRepository.findById(email).orElse(null);
        model.addAttribute("members", memberEntity);
        return "members/show";
    }
    @GetMapping("/members")
    public String index(Model model) {
        Iterable<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members/index";
    }
}
