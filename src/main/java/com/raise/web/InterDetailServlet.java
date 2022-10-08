package com.raise.web;

import com.alibaba.fastjson.JSON;
import com.raise.bean.CompanyInfo;
import com.raise.bean.InterDetail;
import com.raise.bean.PageBean;
import com.raise.service.CompanyService;
import com.raise.service.InterDetailService;
import com.raise.service.impl.CompanyServiceImpl;
import com.raise.service.impl.InterDetailServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author xiangxiaolong
 * @create 2022-02-22 16:40
 */
@WebServlet("/interDetail/*")
public class InterDetailServlet extends BasicServlet{
    private InterDetailService interService = new InterDetailServiceImpl();
    public void selectInterDetail(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        Integer start = Integer.parseInt(req.getParameter("start"));
        Integer limit = Integer.parseInt(req.getParameter("limit"));
        int begin = (start - 1) * limit;
        int companyId = Integer.parseInt(req.getParameter("companyId"));
        InterDetail interDetail = new InterDetail();
        interDetail.setCompanyId(companyId);
        System.out.println(interDetail);
        PageBean res = interService.getInitData(begin, limit, interDetail);
        String respData = JSON.toJSONString(res);
//        System.out.println(respData);

        resp.getWriter().write(respData);
    }

    public void selectBySearch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        Integer start = Integer.parseInt(req.getParameter("start"));
        Integer limit = Integer.parseInt(req.getParameter("limit"));
        int companyId = Integer.parseInt(req.getParameter("companyId"));
        int begin = (start - 1) * limit;
        req.setCharacterEncoding(StandardCharsets.UTF_8 + "");
        String line = req.getReader().readLine();
        InterDetail interDetail = JSON.parseObject(line, InterDetail.class);
        interDetail.setCompanyId(companyId);
        PageBean res = interService.getInitData(begin, limit, interDetail);
        String respData = JSON.toJSONString(res);

        System.out.println(respData);

        resp.getWriter().write(respData);
    }


    //新增或修改
    public void addInter(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        String line = req.getReader().readLine();
        InterDetail interDetail = JSON.parseObject(line, InterDetail.class);
        if (interDetail.getId() == 0){
            //新增
            interService.insertInter(interDetail);
            resp.getWriter().write("add");
        }else {
            //修改
            interService.updateById(interDetail);
            resp.getWriter().write("update");
        }
    }

    public void selectById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        InterDetail interDetail = interService.selectById(id);
        String res = JSON.toJSONString(interDetail);
        resp.getWriter().write(res);
    }

    //删除
    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        interService.deleteById(id);
        resp.getWriter().write("success");
    }
}
