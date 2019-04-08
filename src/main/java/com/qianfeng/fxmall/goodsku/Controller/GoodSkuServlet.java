package com.qianfeng.fxmall.goodsku.Controller;

import com.qianfeng.fxmall.goodsku.Service.GoodSkuServiceImpl;
import com.qianfeng.fxmall.goodsku.Service.Impl.IGoodSkuService;
import com.qianfeng.fxmall.goodsku.bean.WxbGoodSku;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class GoodSkuServlet extends BaseServlet {

    private IGoodSkuService goodSkuService = new GoodSkuServiceImpl();

    /**
     *
     * 按页码查询
     */
   public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("Page");
        try {
            page = page == null?"1":page;
            List<WxbGoodSku> goodSkuList = goodSkuService.queryGoodSkuByPage(Integer.parseInt(page));
            req.setAttribute("goodSkusList",goodSkuList);
            req.getRequestDispatcher("goodSku.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入
     * @param req
     * @param resp
     * @throws Exception
     */
    public void insert(HttpServletRequest req, HttpServletResponse resp)throws Exception{
       WxbGoodSku goodSku = new WxbGoodSku();
       goodSku.setSkuName("mianmo");
       goodSku.setSkuPrice("100");
       goodSku.setGoodId("li123455");
       goodSku.setOrderNo(11);
       goodSku.setServiceMoney("8");
       goodSku.setSkuCost("10");
       goodSku.setSkuId("hu789");
       goodSku.setSkuPrice("20");

       goodSkuService.insertGoodSku(goodSku);

       //图片传入
        /*if (ServletFileUpload.isMultipartContent(req)) {
            ServletFileUpload upload = new ServletFileUpload();
            upload.setSizeMax(5 * 1024 * 1024);
            FileItemIterator itr = upload.getItemIterator(req);
            Integer i = 0;
            while (itr.hasNext()) {
                FileItemStream item = itr.next();
                if (item.isFormField()) {
                    String value = Streams.asString(item.openStream(), "UTF-8");
                    switch (item.getFieldName()) {
                        case "sku_name":
                            goodSku.setSkuName(value);
                            break;
                        case "sku_price":
                            goodSku.setSkuPrice((value));
                            break;
                        case "order_no":
                            goodSku.setOrderNo(Long.parseLong(value));
                            break;
                        case "good_id":
                            goodSku.setGoodId(value);
                            break;
                        case "service_money":
                            goodSku.setServiceMoney((value));
                            break;
                        case "sku_cost":
                            goodSku.setSkuCost((value));
                            break;
                        case "sku_id":
                            goodSku.setSkuId((value));
                            break;
                        case "sku_price":
                            goodSku.setSkuPrice((value));
                            break;
                    }
                } else {
                    //获得文件名,进行处理
                    String filename = item.getName();
                    if (filename != null && filename.length() > 0) {
                        String filename2 = UUID.randomUUID().toString() +
                                filename.substring(filename.lastIndexOf("."));
                        // 保存新文件名,用于存入数据库
                        if(i == 0){
                            goodSku.setGoodPic(filename2);
                        }
                        if(i == 1){
                            goodSku.setGoodPic1(filename2);
                        }
                        if(i == 2){
                            goodSku.setGoodPic2(filename2);
                        }
                        filename = SystemConstantsUtils.UPLOAD_PATH + filename2;
                        // 创建文件输出流
                        FileOutputStream out = new FileOutputStream(filename);
                        // 读上传文件流,写入文件
                        Streams.copy(item.openStream(), out, true);
                        i++;
                    }
                }
            }
            goodSkuService.insertGoodSku(goodSku);

        }*/
    }

}
