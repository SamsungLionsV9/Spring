package com.example.first.project.dto;

import com.example.first.project.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {
    public String email;
    public String password;

    public Member toEntity(){
        return new Member(email, password);
    }
}

