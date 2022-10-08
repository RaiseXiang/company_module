package com.raise.service;

import com.raise.bean.CompanyInfo;
import com.raise.bean.PageBean;

import java.util.List;

/**
 * @author xiangxiaolong
 * @create 2022-02-19 19:16
 */
public interface CompanyService {
   PageBean getInitData(int start,int limit);
   void insertCompage(CompanyInfo companyInfo);
   void deleteById(int id);
   PageBean getSearchData(int start,int limit,CompanyInfo companyInfo);
   CompanyInfo selectById(int id);
   void updateById(CompanyInfo companyInfo);
}
