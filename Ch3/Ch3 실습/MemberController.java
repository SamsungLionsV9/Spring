package com.example.first.project.controller;

import com.example.first.project.entity.Member;
import com.example.first.project.repository.MemberRepository;
import com.example.first.project.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Controller
public class MemberController {
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/members/new")
    public String newMember() {
        return "members/new";
    }

    @PostMapping("/members/create")
    public String createMember(@RequestBody Member member) {
        log.info("member={}", member);
        memberRepository.save(member);
        return "redirect:/";
    }
}
