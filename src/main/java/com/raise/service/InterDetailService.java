package com.raise.service;

import com.raise.bean.CompanyInfo;
import com.raise.bean.InterDetail;
import com.raise.bean.PageBean;

/**
 * @author xiangxiaolong
 * @create 2022-02-19 19:16
 */
public interface InterDetailService {
   PageBean getInitData(int start,int limit,InterDetail interDetail);
   void insertInter(InterDetail interDetail);
   void deleteById(int id);
   PageBean getSearchData(int start,int limit,InterDetail interDetail);
   InterDetail selectById(int id);
   void updateById(InterDetail interDetail);
}
