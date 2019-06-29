package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper mapper;

    public PageResult findAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbBrand> page = (Page<TbBrand>)mapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void insert(TbBrand brand) {
        mapper.insert(brand);
    }

    @Override
    public void update(TbBrand brand) {
        mapper.updateByPrimaryKey(brand);
    }

    @Override
    public TbBrand findOne(long id) {
        return mapper.selectByPrimaryKey(id);
    }
}
