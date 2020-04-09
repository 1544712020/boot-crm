package com.lwz.core.dao;

import com.lwz.core.po.BaseDict;

import java.util.List;

/**
 * 数据字典的Dao接口
 */

public interface BaseDictDao {

    public List<BaseDict> selectBaseDictByTypeCode(String typecode);

}
