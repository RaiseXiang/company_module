package com.raise.dao;

import com.raise.bean.CompanyInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xiangxiaolong
 * @create 2022-02-19 0:06
 */
public interface companyInfoOp {
    // 依据当前页面 和 查询条数查询数据
    List<CompanyInfo> selectByIndex(@Param("start") int start,@Param("pageNum") int pageNum,@Param("CompanyInfo") CompanyInfo companyInfo);

    //查询目前数据库的所有数据
    int selectTotalCount(@Param("CompanyInfo") CompanyInfo companyInfo);

    //新增公司信息
    @Insert("insert into ri_company values(null,#{interDate},#{companyName},#{companyAddress},#{interUser},0,null,null )")
    void insertCompany(CompanyInfo companyInfo);

    //删除该条公司记录
    @Update("UPDATE ri_company  SET is_delete = 1 WHERE company_id = #{id}")
    void deleteById(int id);

    @Select("select * from ri_company where company_id = #{id}")
    @ResultMap("brandResultMap")
    CompanyInfo selectById(@Param("id") int id);

    @Update("UPDATE ri_company SET inter_date = #{interDate},company_name = #{companyName},company_address = #{companyAddress} WHERE company_id = #{companyId}")
    void updateById(CompanyInfo companyInfo);
}
