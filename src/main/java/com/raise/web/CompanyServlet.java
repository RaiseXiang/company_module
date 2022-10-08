package com.raise.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.raise.bean.CompanyInfo;
import com.raise.bean.PageBean;
import com.raise.service.CompanyService;
import com.raise.service.impl.CompanyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author xiangxiaolong
 * @create 2022-02-18 23:48
 */
@WebServlet("/company/*")
public class CompanyServlet extends BasicServlet {
    private CompanyService companyService = new CompanyServiceImpl();
    public void selectCompanyInfo(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("我被执行了");
    }

    //初始的查询方法，查询当前的数据条数，一级当前页面应该展示的数据
    public void selectCompanyInit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        Integer start = Integer.parseInt(req.getParameter("start"));
        Integer limit = Integer.parseInt(req.getParameter("limit"));
        int begin = (start - 1) * limit;

        req.setCharacterEncoding(StandardCharsets.UTF_8 + "");
        String line = req.getReader().readLine();
        String companyName = null;
        String interUser = null;
        CompanyInfo companyInfo = null;
        if (line != null && !"".equals(line)){
            JSONObject jsonObject = JSON.parseObject(line);
            companyName = jsonObject.getString("companyName");
            interUser = jsonObject.getString("interUser");
            companyInfo = new CompanyInfo();
            companyInfo.setCompanyName(companyName);
            companyInfo.setInterUser(interUser);
        }
        PageBean initData = null;
        if (companyInfo != null && ((companyInfo.getCompanyName() != null && !companyInfo.getCompanyName().equals(""))
                || (companyInfo.getInterUser() != null && !companyInfo.getInterUser().equals("")))) {
            companyInfo.setCompanyName(companyName);
            companyInfo.setInterUser(interUser);
            initData = companyService.getSearchData(begin,limit,companyInfo);
        }else {
            initData = companyService.getInitData(begin,limit);
        }

        String respData = JSON.toJSONString(initData);
//        System.out.println(respData);
        resp.getWriter().write(respData);
    }

    //新增面试公司
    public void addCompany(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        String line = req.getReader().readLine();
        CompanyInfo companyInfo = JSON.parseObject(line, CompanyInfo.class);
        companyInfo.setInterDate(companyInfo.getInterDate().substring(0,10));
        //新增
        if (companyInfo.getCompanyId() == 0){
            companyService.insertCompage(companyInfo);
            resp.getWriter().write("add");
        }else {
            //修改
            System.out.println(companyInfo);
            companyService.updateById(companyInfo);
            resp.getWriter().write("update");
        }

//        System.out.println(companyInfo);
    }

    //删除公司
    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        int companyId = Integer.parseInt(req.getParameter("companyId"));
//        System.out.println(companyId);
        companyService.deleteById(companyId);
        resp.getWriter().write("success");
    }

    //依据id查找公司
    public void selectById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        int companyId = Integer.parseInt(req.getParameter("companyId"));
        CompanyInfo companyInfo = companyService.selectById(companyId);
        String data = JSON.toJSONString(companyInfo);
        resp.getWriter().write(data);
    }


    //重定向
    public void tran_inter_detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String companyId = req.getParameter("companyId");
        System.out.println(companyId);
        req.setAttribute("companyId",companyId);
        resp.sendRedirect("http://39.104.84.224:8080/company_module/inter_detail.html?companyId=" + companyId);
//        req.getRequestDispatcher("inter_detail.html");
    }
}
