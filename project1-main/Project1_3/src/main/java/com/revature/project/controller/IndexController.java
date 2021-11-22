package com.revature.project.controller;

import io.javalin.http.Handler;
import com.revature.project.dao.UserDAO;

import java.util.Map;

import com.revature.project.dao.ProductDAO;
import com.revature.project.util.Path;
import com.revature.project.util.ViewUtil;
public class IndexController {
	public static Handler serveIndexPage = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);
        model.put("users", UserDAO.getAllUsernames());
        model.put("product", ProductDAO.getRandomProduct());
        ctx.render(Path.Template.INDEX, model);
    };

}
