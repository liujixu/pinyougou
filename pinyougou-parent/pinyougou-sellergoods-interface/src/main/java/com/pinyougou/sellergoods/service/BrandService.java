package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;
import entity.Result;

import java.util.List;

public interface BrandService {

    public PageResult findAll(int pageNum,int pageSize);

    public void insert(TbBrand brand);

    void update(TbBrand brand);

    TbBrand findOne(long id);
}
