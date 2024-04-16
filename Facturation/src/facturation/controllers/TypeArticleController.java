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
import facturation.entities.TypeArticle;
import annotation.DefaultParameter;
import annotation.Parameters;
import bdd.BddObject;
import model.database.Constante;
import model.lieu.CategorieLieu;
import url.ModelView;

@Controller
@Singleton

public class TypeArticleController {
    private DAO dao=new DAO("articles", "localhost", "5432", "postgres", "kiwi1234", true, 2);

    
    @URLMapping("inserttypeArticle.do")
public ModelRedirect insert(ServletEntity entity) throws Exception{
    TypeArticle o=new TypeArticle();
    [fields]
    o.setDescription(entity.getData().get("description"));
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        dao.insertWithoutPrimaryKey(connex, o);
        connex.commit();
        ModelRedirect model=new ModelRedirect("tocrudtypeArticle.do");
        return model;
    }
}

@URLMapping("tocrudtypeArticle.htm")
@Parameters("tocrudtypeArticle.do")
public ModelView crudpage(ServletEntity entity) throws Exception{
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        ModelView model=new ModelView();
        model.setView("pages/layout/layout.jsp");
        TypeArticle[] o=dao.select(connex, TypeArticle.class);
        model.addItem("viewpage", "typeArticle.jsp");
        model.addItem("title", "TypeArticle");
        model.addItem("o", o);
        
        return model;
    }
}
@URLMapping("updatetypeArticle.do")
public ModelRedirect update(ServletEntity entity) throws Exception{
    TypeArticle o=new TypeArticle();
    o.setDescription(entity.getData().get("description"));
    TypeArticle where=new TypeArticle();
    where.setId(entity.getData().get("id"));
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        dao.update(connex, o, where);
        connex.commit();
        ModelRedirect model=new ModelRedirect("tocrudtypeArticle.do");
        return model;
    }
}
@URLMapping("deletetypeArticle.do")
public ModelRedirect delete(ServletEntity entity) throws Exception{
    TypeArticle where=new TypeArticle();
    where.setId(entity.getData().get("id"));
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        dao.delete(connex, where);
        connex.commit();
        ModelRedirect model=new ModelRedirect("tocrudtypeArticle.do");
        return model;
    }
}
@Url(link = "typeArticle.htm")
public ModelView showpage()  throws Exception {
    ModelView result = new ModelView("typeArticle");
    return result;
}

}

