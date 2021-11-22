package com.revature.project.util;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;
import java.util.Map;

import com.revature.project.util.*;

public class ViewUtil {
	
	public static Map<String, Object> baseModel(Context ctx) {
        Map<String, Object> model = new HashMap<>();
        model.put("msg", new MessageBundle(RequestUtil.getSessionLocale(ctx)));
        model.put("currentUser", RequestUtil.getSessionCurrentUser(ctx));
        return model;
    }

    public static Handler notFound = ctx -> {
        ctx.render(Path.Template.NOT_FOUND, baseModel(ctx));
    };

}