package com.example.demo.service;

import com.example.demo.dao.memberDAO;
import com.example.demo.dto.classDTO;
import com.example.demo.dto.deptInfoDTO;
import com.example.demo.dto.memberDTO;
import com.example.demo.dto.userClassDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public int modify(memberDTO dto){
        return m.modify(dto);
    }
    public void modifySemester(memberDTO dto){
        m.modifySemester(dto);
    }
    public int calMine(memberDTO dto){
        return m.calMine(dto);
    }
    public int calTotal(deptInfoDTO dto){
        return m.calTotal(dto);
    }
    public void cinput(userClassDTO dto) { m.cinput(dto);}
    public List<classDTO> userTotalClass(int id){
        return m.userTotalClass(id);
    }
    public List<userClassDTO> userClass(int id){
        return m.userClass(id);
    }
    public List<userClassDTO> userCreditsGroupingField(int id){
        return m.userCreditsGroupingField(id);
    }
    public List<userClassDTO> avgCreditsGroupingField(memberDTO dto){
        return m.avgCreditsGroupingField(dto);
    }
    public int countForAvg(memberDTO dto){
        return m.countForAvg(dto);
    }
    public deptInfoDTO fieldTotal(memberDTO dto){
        return m.fieldTotal(dto);
    }
}
