package controller;

import java.io.IOException;

import eriq.flamework.annotations.Controller;
import eriq.flamework.annotations.Singleton;
import eriq.flamework.annotations.URLMapping;
import eriq.flamework.model.ModelView;
import eriq.flamework.servlet.ServletEntity;

import annotation.DefaultParameter;
import annotation.Parameters;
import annotation.Url;
import bdd.BddObject;
import model.database.Constante;
import model.lieu.CategorieLieu;
import url.ModelView;

@Controller
@Singleton
public class HelloController {
    // @URLMapping("hello.do")
    // public ModelView hello(ServletEntity entity) throws IOException {
    // ModelView view = new ModelView();
    // view.setView("pages/layout/layout.jsp");
    // view.addItem("title", "Welcome");
    // view.addItem("viewpage", "hello.jsp");
    // return view;
    // }

    @Url(link = "hello.htm")
    public ModelView hello()
            throws Exception {
        // ModelView result=new ModelView("web/static/header.jsp",
        // "web/pages/formCategorieLieu.jsp", "web/static/footer.jsp");
        ModelView result = new ModelView("hello");
        return result;
    }
}
