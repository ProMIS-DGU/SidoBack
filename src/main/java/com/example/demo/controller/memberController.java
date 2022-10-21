package com.example.demo.controller;

import com.example.demo.dto.classDTO;
import com.example.demo.dto.deptInfoDTO;
import com.example.demo.dto.memberDTO;
import com.example.demo.dto.userClassDTO;
import com.example.demo.service.memberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class memberController {
    private final memberService m;

    @PostMapping("/join")
    public void join(memberDTO dto) {
        m.join(dto);
    }
    @PostMapping("/login")
    public memberDTO login(memberDTO dto) {
        return m.login(dto);
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
}
