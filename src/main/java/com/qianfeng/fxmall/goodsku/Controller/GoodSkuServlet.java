package com.qianfeng.fxmall.goodsku.Controller;

import com.qianfeng.fxmall.goodsku.Service.GoodSkuServiceImpl;
import com.qianfeng.fxmall.goodsku.Service.Impl.IGoodSkuService;
import com.qianfeng.fxmall.goodsku.bean.WxbGoodSku;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodSkuServlet extends HttpServlet {

    private IGoodSkuService goodSkuService = new GoodSkuServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("Page");
        try {
            page = page == null?"1":page;
            List<WxbGoodSku> goodSkusList = goodSkuService.queryGoodSkuByPage(Integer.parseInt(page));
            req.setAttribute("goodSkusList",goodSkusList);
            req.getRequestDispatcher("goodSku,jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
