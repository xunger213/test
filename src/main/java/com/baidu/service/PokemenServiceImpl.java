package com.baidu.service;

import com.baidu.mapper.PokemenMapper;
import com.baidu.pojo.Attributes;
import com.baidu.pojo.Pokemen;
import com.baidu.pojo.QeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PokemenServiceImpl implements PokemenService {
    @Autowired
    private PokemenMapper pokemenMapper;

    @Override
    public List<Attributes> findAttributes() {
        return pokemenMapper.findAttributes();
    }

    @Override
    public List<Pokemen> findPokemensPage(QeVo qeVo) {
        List<Pokemen> pokemens = pokemenMapper.findPokemensPage(qeVo);
        for (Pokemen p : pokemens) {
            List<Attributes> pattrs = pokemenMapper.findAttributesById(p.getId());
            p.setAttrs(pattrs);
        }
        return pokemens;
    }

    @Override
    public List<Attributes> findAttributesById(Integer id) {
        return pokemenMapper.findAttributesById(id);
    }

    @Override
    public int addPokemen(Pokemen pokemen) {
        return pokemenMapper.addPokemen(pokemen);
    }

    @Override
    public int addPokemenAttrs(Map<String, Object> map) {
        return pokemenMapper.addPokemenAttrs(map);
    }

    @Override
    public int deletePokemen(Integer pid) {
        int i = pokemenMapper.deletePokemenAttrs(pid);
        return pokemenMapper.deletePokemen(pid);
    }

    @Override
    public Pokemen findPokemensById(Integer pid) {
        return pokemenMapper.findPokemensById(pid);
    }

    @Override
    public int updatePokemen(Pokemen pokemen) {
        return pokemenMapper.updatePokemen(pokemen);
    }

    @Override
    public int updatePokemenAttrs(Map<String, Object> map) {
        int pid = (int) map.get("pid");
        int i = pokemenMapper.deletePokemenAttrs(pid);
        return pokemenMapper.addPokemenAttrs(map);
    }

    @Override
    public List<Pokemen> findPokemens() {
        return pokemenMapper.findPokemens();
    }

    @Override
    public int addPokemens(List<Pokemen> pokemens) {
        return pokemenMapper.addPokemens(pokemens);
    }


}
