package com.myit.portal.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myit.portal.action.bean.AdvImg;
import com.myit.portal.action.bean.Category;
import com.myit.portal.action.bean.Commodity;

/**
 * 
 * 首页操作流程控制类<br>
 * 跳转到首页
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping(value = "/index")
public class IndexAction extends BaseAction {

    private static final Logger LOGGER = Logger.getLogger(IndexAction.class);

    /**
     * 跳转到首页<br>
     * 
     * @author created by LiuCongwen at 2012-4-27
     * @param model
     * @param request
     * @throws Exception
     */
    @RequestMapping(value = "")
    public String index(Model model, HttpServletRequest request) throws Exception {
        LOGGER.info("index IN");

        LOGGER.info("index OUT");
        return "index.ftl";
    }

    @RequestMapping(value = "/getAdverImgs")
    public String getAdverImgs(Model model, HttpServletRequest request) throws Exception {
        LOGGER.info("getAdverImgs IN");

        List<AdvImg> advImgs = new ArrayList<AdvImg>();

        // TODO 测试数据
        advImgs.add(new AdvImg("http://www.baidu.com", "img/1.jpg"));
        advImgs.add(new AdvImg("http://www.baidu.com", "img/2.jpg"));
        advImgs.add(new AdvImg("http://www.baidu.com", "img/3.jpg"));
        advImgs.add(new AdvImg("http://www.baidu.com", "img/4.jpg"));
        advImgs.add(new AdvImg("http://www.baidu.com", "img/1.jpg"));
        advImgs.add(new AdvImg("http://www.baidu.com", "img/2.jpg"));
        advImgs.add(new AdvImg("http://www.baidu.com", "img/3.jpg"));
        advImgs.add(new AdvImg("http://www.baidu.com", "img/4.jpg"));

        model.addAttribute("advImgs", advImgs);

        LOGGER.info("getAdverImgs OUT");
        return "advImgs.ftl";
    }

    @RequestMapping(value = "/getCategotyRecoms")
    public String getCategotyRecoms(Model model, HttpServletRequest request) throws Exception {
        LOGGER.info("getCategotyRecoms IN");

        // 总共8个分类
        List<Category> categories = new ArrayList<Category>();

        // TODO 测试数据
        for (int categories_i = 0; categories_i < 8; categories_i++) {

            Category category = new Category();

            category.setTitle("盖浇饭");

            // 每类4个分组
            List<List<Commodity>> groups = new ArrayList<List<Commodity>>();

            for (int groups_i = 0; groups_i < 4; groups_i++) {
                // 每组4个商品
                List<Commodity> commodities = new ArrayList<Commodity>();
                for (int commodities_i = 0; commodities_i < 4; commodities_i++) {

                    // 商品
                    Commodity commodity = new Commodity("1", "盖浇饭", "img/logo.jpg", new BigDecimal(7.50), new BigDecimal(0.50));
                    commodities.add(commodity);
                }

                groups.add(commodities);
            }

            category.setGroups(groups);

            categories.add(category);
        }

        model.addAttribute("categories", categories);

        LOGGER.info("getCategotyRecoms OUT");
        return "categoryRecoms.ftl";
    }

}
