package com.revature.project;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.http.staticfiles.Location;
import static io.javalin.apibuilder.ApiBuilder.before;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;

import org.eclipse.jetty.webapp.WebAppContext;

//import com.revature.project.controller.IndexController;

import com.revature.project.controller.ProductController;
//import com.revature.project.controller.UserController;
import com.revature.project.controller.ReimbursementController;
import com.revature.project.dao.ProductDAO;
import com.revature.project.dao.UserDAO;
import com.revature.project.util.Filters;
import com.revature.project.util.HerokuUtil;
import com.revature.project.util.Path;
import com.revature.project.util.ViewUtil;

public class App {
	
	
	 public static ProductDAO productDao;
     public static UserDAO userDao;

	public static void main(String[] args) {
		Javalin app = Javalin.create(config -> {
            config.addStaticFiles("src/main/webapp", Location.CLASSPATH);
            config.registerPlugin(new RouteOverviewPlugin("/routes"));
        }).start(HerokuUtil.getHerokuAssignedPort());
		
////		// 2. Creating the WebAppContext for the created content
//				WebAppContext ctx = new WebAppContext();
//			ctx.setResourceBase("src/main/webapp");
////				ctx.setContextPath("/jetty-jsp-example");
//				
//				//3. Including the JSTL jars for the webapp.
//				ctx.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",".*/[^/]*jstl.*\\.jar$");
//			
//				//4. Enabling the Annotation based configuration
//				org.eclipse.jetty.webapp.Configuration.ClassList classlist = org.eclipse.jetty.webapp.Configuration.ClassList.setServerDefault(app);
//		        classlist.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration", "org.eclipse.jetty.plus.webapp.EnvConfiguration", "org.eclipse.jetty.plus.webapp.PlusConfiguration");
//		        classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration", "org.eclipse.jetty.annotations.AnnotationConfiguration");
//		        
		      
			
		
		app.routes(() -> {
//		app.get("/users", UserController.fetchAllUsernames);
//		app.get("/users/\\{id}", UserController.fetchById);
//		app.post("/users", UserController.addUser);
			
			app.get("/reimbursement", ReimbursementController.createReimbursement);
		});
		
		
//------------------------------------------------------------------------		
		
		
		//app.routes(() -> {
//            before(Filters.handleLocaleChange);
//            before(LoginController.ensureLoginBeforeViewingProducts);
           // get(Path.Web.INDEX, IndexController.serveIndexPage);
//            get(Path.Web.PRODUCTS, ProductController.fetchAllProducts);
//            get(Path.Web.ONE_PRODUCT, ProductController.fetchOneProduct);
//            get(Path.Web.LOGIN, LoginController.serveLoginPage);
//            post(Path.Web.LOGIN, LoginController.handleLoginPost);
//            post(Path.Web.LOGOUT, LoginController.handleLogoutPost);
       // });
		
		
//		app.get("hello", ctx-> ctx.html("<h1>Welcome to Javalin</h>"));
//		app.get("Welcome", ctx->ctx.html("<h1>Welcome to Javalin World</h1>"));
		//app.get("SomeData/{name}", ctx->ctx.html("<h1)> Welcome " +ctx.pathParam("name") + " to Javalin!!!</h1>"));
	
		//app.get("api/v1/users", ctz->ctx.html(new User(100,"test1234", "test@gmail.com", true).toString()));
//		app.get("/", ctx -> {
//            ctx.html("index.html");
//        });

//		app.get("/users", UserController.fetchAllUsernames);
//		app.get("/users/{id}", UserController.fetchById);
//		app.post("/users", UserController.addUser);
//		
		//app.error(404, ViewUtil.notFound);
		
	}
}
