package com.baidu.service;

import com.baidu.pojo.Attributes;
import com.baidu.pojo.Pokemen;
import com.baidu.pojo.QeVo;

import java.util.List;
import java.util.Map;

public interface PokemenService {
    List<Attributes> findAttributes();

    List<Pokemen> findPokemensPage(QeVo qeVo);

    List<Attributes> findAttributesById(Integer id);

    int addPokemen(Pokemen pokemen);

    int addPokemenAttrs(Map<String, Object> map);

    int deletePokemen(Integer pid);

    Pokemen findPokemensById(Integer pid);

    int updatePokemen(Pokemen pokemen);

    int updatePokemenAttrs(Map<String, Object> map);

    List<Pokemen> findPokemens();

    int addPokemens(List<Pokemen> pokemens);
}
