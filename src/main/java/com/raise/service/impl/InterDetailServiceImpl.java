package com.raise.service.impl;

import com.raise.bean.CompanyInfo;
import com.raise.bean.InterDetail;
import com.raise.bean.PageBean;
import com.raise.dao.companyInfoOp;
import com.raise.dao.interDetailOp;
import com.raise.service.CompanyService;
import com.raise.service.InterDetailService;
import com.raise.util.MybatisFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author xiangxiaolong
 * @create 2022-02-19 19:17
 */
public class InterDetailServiceImpl implements InterDetailService {

    @Override
    public PageBean getInitData(int start, int limit, InterDetail interDetail) {
        SqlSessionFactory sqlSessionFactory = MybatisFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        interDetailOp mapper = sqlSession.getMapper(interDetailOp.class);
        if (interDetail.getQuestion() != null && !"".equals(interDetail.getQuestion())){
            interDetail.setQuestion("%" + interDetail.getQuestion() + "%");
        }
        System.out.println(interDetail);
        List<InterDetail> interDetails = mapper.selectByCompanyId(start, limit, interDetail);
        int cnt = mapper.selectCount(interDetail);
        PageBean pageBean = new PageBean(interDetails, cnt);
        sqlSession.close();
        return pageBean;
    }

    @Override
    public void insertInter(InterDetail interDetail) {
        SqlSessionFactory sqlSessionFactory = MybatisFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        interDetailOp mapper = sqlSession.getMapper(interDetailOp.class);
        mapper.addInter(interDetail);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteById(int id) {
        SqlSessionFactory sqlSessionFactory = MybatisFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        interDetailOp mapper = sqlSession.getMapper(interDetailOp.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean getSearchData(int start, int limit, InterDetail interDetail) {
        return null;
    }

    @Override
    public InterDetail selectById(int id) {
        SqlSessionFactory sqlSessionFactory = MybatisFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        interDetailOp mapper = sqlSession.getMapper(interDetailOp.class);
        InterDetail interDetail = mapper.selectById(id);
        return interDetail;
    }

    @Override
    public void updateById(InterDetail interDetail) {
        SqlSessionFactory sqlSessionFactory = MybatisFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        interDetailOp mapper = sqlSession.getMapper(interDetailOp.class);
        mapper.updateById(interDetail);
        sqlSession.commit();
        sqlSession.close();
    }
}
