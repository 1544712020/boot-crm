package com.lwz.core.service.impl;

import com.lwz.core.dao.BaseDictDao;
import com.lwz.core.po.BaseDict;
import com.lwz.core.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("baseDictService")
public class BaseDictServiceImpl implements BaseDictService {

    @Autowired
    private BaseDictDao baseDictDao;

    public List<BaseDict> findBaseDictByTypeCode(String typeCode) {
        return baseDictDao.selectBaseDictByTypeCode(typeCode);
    }
}
