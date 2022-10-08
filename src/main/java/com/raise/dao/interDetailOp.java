package com.raise.dao;

import com.raise.bean.InterDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xiangxiaolong
 * @create 2022-02-22 16:42
 */
public interface interDetailOp {
    List<InterDetail> selectByCompanyId(@Param("start") int start, @Param("limit") int limit, @Param("interDetail") InterDetail interDetail);
    int selectCount(@Param("interDetail") InterDetail interDetail);
    @Insert("insert into ri_interdetail values (null,#{companyId},#{rank},#{question},#{answer},#{star},#{interUser},0,null,null )")
    void addInter(InterDetail interDetail);

    @Select("select * from ri_interdetail where id = #{id} and is_delete = 0")
    @ResultMap("interDetailResultMap")
    InterDetail selectById(@Param("id") int id);

    @Update("update ri_interdetail set rank=#{rank},question=#{question},answer=#{answer},star=#{star},inter_user=#{interUser} where id=#{id}")
    void updateById(InterDetail interDetail);
    //删除

    @Update("update ri_interdetail set is_delete = 1 where id = #{id}")
    void deleteById(@Param("id") int id);
}
