package facturation.controllers;
import eriq.flamework.annotations.Controller;
import eriq.flamework.annotations.Singleton;
import eriq.flamework.annotations.URLMapping;
import eriq.flamework.model.ModelRedirect;
import eriq.flamework.model.ModelView;
import eriq.flamework.servlet.ServletEntity;
import veda.godao.DAO;
import veda.godao.utils.DAOConnexion;
import java.sql.Connection;
import facturation.entities.UniteArticle;
import annotation.DefaultParameter;
import annotation.Parameters;
import bdd.BddObject;
import model.database.Constante;
import model.lieu.CategorieLieu;
import url.ModelView;

@Controller
@Singleton

public class UniteArticleController {
    private DAO dao=new DAO("articles", "localhost", "5432", "postgres", "kiwi1234", true, 2);

    
    @URLMapping("insertuniteArticle.do")
public ModelRedirect insert(ServletEntity entity) throws Exception{
    UniteArticle o=new UniteArticle();
    [fields]
    o.setDescription(entity.getData().get("description"));
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        dao.insertWithoutPrimaryKey(connex, o);
        connex.commit();
        ModelRedirect model=new ModelRedirect("tocruduniteArticle.do");
        return model;
    }
}

@URLMapping("tocruduniteArticle.htm")
@Parameters("tocruduniteArticle.do")
public ModelView crudpage(ServletEntity entity) throws Exception{
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        ModelView model=new ModelView();
        model.setView("pages/layout/layout.jsp");
        UniteArticle[] o=dao.select(connex, UniteArticle.class);
        model.addItem("viewpage", "uniteArticle.jsp");
        model.addItem("title", "UniteArticle");
        model.addItem("o", o);
        
        return model;
    }
}
@URLMapping("updateuniteArticle.do")
public ModelRedirect update(ServletEntity entity) throws Exception{
    UniteArticle o=new UniteArticle();
    o.setDescription(entity.getData().get("description"));
    UniteArticle where=new UniteArticle();
    where.setId(entity.getData().get("id"));
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        dao.update(connex, o, where);
        connex.commit();
        ModelRedirect model=new ModelRedirect("tocruduniteArticle.do");
        return model;
    }
}
@URLMapping("deleteuniteArticle.do")
public ModelRedirect delete(ServletEntity entity) throws Exception{
    UniteArticle where=new UniteArticle();
    where.setId(entity.getData().get("id"));
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        dao.delete(connex, where);
        connex.commit();
        ModelRedirect model=new ModelRedirect("tocruduniteArticle.do");
        return model;
    }
}
@Url(link = "uniteArticle.htm")
public ModelView showpage()  throws Exception {
    ModelView result = new ModelView("uniteArticle");
    return result;
}

}

