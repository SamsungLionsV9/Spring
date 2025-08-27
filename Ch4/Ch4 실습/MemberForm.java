package com.example.first.project.dto;

import com.example.first.project.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class MemberForm {
    public String email;
    public String password;

    public Member toEntity(){
        return new Member(email, password);
    }
}

