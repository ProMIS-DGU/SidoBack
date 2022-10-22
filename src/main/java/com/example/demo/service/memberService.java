package com.example.demo.service;

import com.example.demo.dao.memberDAO;
import com.example.demo.dto.classDTO;
import com.example.demo.dto.deptInfoDTO;
import com.example.demo.dto.memberDTO;
import com.example.demo.dto.userClassDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class memberService {
    private final memberDAO m;
    public void join(memberDTO dto){
        m.join(dto);
    }
    public memberDTO login(memberDTO dto){
        return m.login(dto);
    }
    public void modify(memberDTO dto){
        m.modify(dto);
    }
    public int calMine(memberDTO dto){
        return m.calMine(dto);
    }
    public int calTotal(deptInfoDTO dto){
        return m.calTotal(dto);
    }
    public void cinput(userClassDTO dto) { m.cinput(dto);}
    public classDTO userTotalClass(int id){
        return m.userTotalClass(id);
    }
    public userClassDTO userClass(int id){
        return m.userClass(id);
    }
}
