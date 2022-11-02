package com.example.demo.controller;

import com.example.demo.dto.classDTO;
import com.example.demo.dto.deptInfoDTO;
import com.example.demo.dto.memberDTO;
import com.example.demo.dto.userClassDTO;
import com.example.demo.service.memberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class memberController { //test
    private final memberService m;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/join") //postman 잘됨
    public void join(memberDTO dto) {
        String enPw = passwordEncoder.encode(dto.getPw());
        dto.setPw(enPw);
        m.join(dto);
    }
    @PostMapping("/login") //postman 잘됨
    public memberDTO login(memberDTO dto) {
        if(passwordEncoder.matches(dto.getPw(), m.login(dto).getPw())){
            return dto;
        }else{
            return null;
        }

    }
    @PostMapping("/modify") // 잘됨
    public void modify(memberDTO dto) { m.modify(dto);}

    @PostMapping("/calTotal") // 잘됨
    public int calTotal(deptInfoDTO dto){
        int total = m.calTotal(dto);
        return total;
    }
    @PostMapping("/calMine") // 잘 됨
    public int calMine(memberDTO dto){
        int mine = m.calMine(dto);
        return mine;
    }

    @PostMapping("/cinput") // 잘 됨
    public void cinput(userClassDTO dto) {m.cinput(dto);}

    @PostMapping("/fieldTotal") // 잘 됨 (postman은 _ 이거 인식 못함)
    public deptInfoDTO fieldTotal(memberDTO dto) {
        return m.fieldTotal(dto);
    }

    @PostMapping("/userTotalClass") // 잘 됨
    public ResponseEntity<List<classDTO>> userTotalClass(int id) {
        ResponseEntity<List<classDTO>> classes = null;
        classes = new ResponseEntity<List<classDTO>>(m.userTotalClass(id), HttpStatus.OK);
        return classes;
    }

    @PostMapping("/userClass") // 잘 됨
    public ResponseEntity<List<userClassDTO>> userClass(int id) {
        ResponseEntity<List<userClassDTO>> classes = null;
        classes = new ResponseEntity<List<userClassDTO>>(m.userClass(id), HttpStatus.OK);
        return classes;
    }

    @PostMapping("/userCreditsGroupingField") // 잘 됨
    public ResponseEntity<List<userClassDTO>> userCreditsGroupingField(int id) {
        ResponseEntity<List<userClassDTO>> entity = null;
        entity = new ResponseEntity<List<userClassDTO>>(m.userCreditsGroupingField(id), HttpStatus.OK);
        return entity;
    }

    @PostMapping("/avgCreditsGroupingField") // 잘 됨
    public ResponseEntity<List<userClassDTO>> avgCreditsGroupingField(memberDTO dto) {
        ResponseEntity<List<userClassDTO>> entity = null;
        entity = new ResponseEntity<List<userClassDTO>>(m.avgCreditsGroupingField(dto), HttpStatus.OK);
        return entity;
    }

    @PostMapping("/countForAvg") // 잘 됨
    public int countForAvg(memberDTO dto) {
        return m.countForAvg(dto);
    }
}
