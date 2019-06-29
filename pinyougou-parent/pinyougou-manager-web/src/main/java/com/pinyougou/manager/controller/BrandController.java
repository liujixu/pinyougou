package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService service;

    @RequestMapping("/findAll.do")
    public PageResult findAll(int pageNum,int pageSize){

        return service.findAll(pageNum,pageSize);
    }

    @RequestMapping("/insert.do")
    public Result insert(@RequestBody TbBrand brand){
        try {
            service.insert(brand);
           return new Result(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"保存失败");
        }
    }

    @RequestMapping("/update.do")
    public Result update(@RequestBody TbBrand brand) {
        try {
            service.update(brand);
            return new Result(true, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "保存失败");
        }
    }
    @RequestMapping("/findOne.do")
    public TbBrand findOne(long id){
        return service.findOne(id);
    }
}
