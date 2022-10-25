package com.example.demo.controller;

import com.example.demo.dto.classDTO;
import com.example.demo.dto.deptInfoDTO;
import com.example.demo.dto.memberDTO;
import com.example.demo.dto.userClassDTO;
import com.example.demo.service.memberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class memberController { //test
    private final memberService m;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/join")
    public void join(memberDTO dto) {
        String enPw = passwordEncoder.encode(dto.getPw());
        dto.setPw(enPw);
        m.join(dto);
    }
    @PostMapping("/login")
    public memberDTO login(memberDTO dto) {
        if(passwordEncoder.matches(dto.getPw(), m.login(dto).getPw())){
            return dto;
        }else{
            return null;
        }

    }
    @PostMapping("/modify")
    public void modify(memberDTO dto) { m.modify(dto);}

    @PostMapping("/calTotal")
    public int calTotal(deptInfoDTO dto){
        int total = m.calTotal(dto);
        return total;
    }
    @PostMapping("/calMine")
    public int calMine(memberDTO dto){
        int mine = m.calMine(dto);
        return mine;
    }

    @PostMapping("/cinput")
    public void cinput(userClassDTO dto) {m.cinput(dto);}

    @PostMapping("/fieldTotal")
    public userClassDTO fieldTotal(memberDTO dto) {
        return m.fieldTotal(dto);
    }

    @PostMapping("/userTotalClass")
    public classDTO userTotalClass(int id) {
        return m.userTotalClass(id);
    }

    @PostMapping("/userClass")
    public userClassDTO userClass(int id) {
        return m.userClass(id);
    }

    @PostMapping("/userCreditsGroupingField")
    public userClassDTO userCreditsGroupingField(int id) {
        return m.userCreditsGroupingField(id);
    }

    @PostMapping("/avgCreditsGroupingField")
    public userClassDTO avgCreditsGroupingField(memberDTO dto) {
        return m.avgCreditsGroupingField(dto);
    }

    @PostMapping("/countForAvg")
    public userClassDTO countForAvg(memberDTO dto) {
        return m.countForAvg(dto);
    }
}
