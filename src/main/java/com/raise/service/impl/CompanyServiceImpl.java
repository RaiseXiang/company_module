package com.raise.service.impl;

import com.raise.bean.CompanyInfo;
import com.raise.bean.PageBean;
import com.raise.dao.companyInfoOp;
import com.raise.service.CompanyService;
import com.raise.util.MybatisFactoryUtil;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author xiangxiaolong
 * @create 2022-02-19 19:17
 */
public class CompanyServiceImpl implements CompanyService {

    //获取页面的初始数据
    @Override
    public PageBean getInitData(int start,int limit) {
        SqlSessionFactory sqlSessionFactory = MybatisFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        companyInfoOp mapper = sqlSession.getMapper(companyInfoOp.class);
        List<CompanyInfo> companyInfos = mapper.selectByIndex(start, limit,null);
        int count = mapper.selectTotalCount(null);
        PageBean pageBean = new PageBean(companyInfos, count);
        sqlSession.close();
        return pageBean;
    }

    @Override
    public void insertCompage(CompanyInfo companyInfo) {
        SqlSessionFactory sqlSessionFactory = MybatisFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        companyInfoOp mapper = sqlSession.getMapper(companyInfoOp.class);
        mapper.insertCompany(companyInfo);
        sqlSession.commit();
        sqlSession.close();
    }

    //删除数据
    @Override
    public void deleteById(int id) {
        SqlSessionFactory sqlSessionFactory = MybatisFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        companyInfoOp mapper = sqlSession.getMapper(companyInfoOp.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    //搜索页面数据
    //获取页面的初始数据
    @Override
    public PageBean getSearchData(int start,int limit,CompanyInfo companyInfo) {
        SqlSessionFactory sqlSessionFactory = MybatisFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        companyInfoOp mapper = sqlSession.getMapper(companyInfoOp.class);
        companyInfo.setCompanyName("%" + companyInfo.getCompanyName() + "%");
        companyInfo.setInterUser("%" + companyInfo.getInterUser() + "%");
        //System.out.println(companyInfo);
        List<CompanyInfo> companyInfos = mapper.selectByIndex(start, limit,companyInfo);


        int count = mapper.selectTotalCount(companyInfo);
        PageBean pageBean = new PageBean(companyInfos, count);
        sqlSession.close();
        return pageBean;
    }

    @Override
    public CompanyInfo selectById(int id) {
        SqlSessionFactory sqlSessionFactory = MybatisFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        companyInfoOp mapper = sqlSession.getMapper(companyInfoOp.class);
        CompanyInfo companyInfo = mapper.selectById(id);
        sqlSession.close();
        return companyInfo;
    }

    @Override
    public void updateById(CompanyInfo companyInfo) {
        SqlSessionFactory sqlSessionFactory = MybatisFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        companyInfoOp mapper = sqlSession.getMapper(companyInfoOp.class);
        mapper.updateById(companyInfo);
        sqlSession.commit();
        sqlSession.close();
    }
}
