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
import facturation.entities.Article;
import annotation.DefaultParameter;
import annotation.Parameters;
import bdd.BddObject;
import model.database.Constante;
import model.lieu.CategorieLieu;
import url.ModelView;

@Controller
@Singleton

public class ArticleController {
    private DAO dao=new DAO("articles", "localhost", "5432", "postgres", "kiwi1234", true, 2);

    
    @URLMapping("insertarticle.do")
public ModelRedirect insert(ServletEntity entity) throws Exception{
    Article o=new Article();
    o.setCode(entity.getData().get("code"));o.setDesignation(entity.getData().get("designation"));o.setUniteArticle(new facturation.entities.UniteArticle(entity.getData().get("uniteArticle")));o.setTypeArticle(new facturation.entities.TypeArticle(entity.getData().get("typeArticle")));o.setPu(Double.parseDouble(entity.getData().get("pu")));
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        dao.insertWithoutPrimaryKey(connex, o);
        connex.commit();
        ModelRedirect model=new ModelRedirect("tocrudarticle.do");
        return model;
    }
}

@URLMapping("tocrudarticle.htm")
@Parameters("tocrudarticle.do")
public ModelView crudpage(ServletEntity entity) throws Exception{
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        ModelView model=new ModelView();
        model.setView("pages/layout/layout.jsp");
        Article[] o=dao.select(connex, Article.class);
        model.addItem("viewpage", "article.jsp");
        model.addItem("title", "Article");
        model.addItem("o", o);
        facturation.entities.UniteArticle[] uniteArticle=dao.select(connex, facturation.entities.UniteArticle.class);
model.addItem("uniteArticles", uniteArticle);facturation.entities.TypeArticle[] typeArticle=dao.select(connex, facturation.entities.TypeArticle.class);
model.addItem("typeArticles", typeArticle);
        return model;
    }
}
@URLMapping("updatearticle.do")
public ModelRedirect update(ServletEntity entity) throws Exception{
    Article o=new Article();
    o.setCode(entity.getData().get("code"));o.setDesignation(entity.getData().get("designation"));o.setUniteArticle(new facturation.entities.UniteArticle(entity.getData().get("uniteArticle")));o.setTypeArticle(new facturation.entities.TypeArticle(entity.getData().get("typeArticle")));o.setPu(Double.parseDouble(entity.getData().get("pu")));
    Article where=new Article();
    where.setId(entity.getData().get("id"));
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        dao.update(connex, o, where);
        connex.commit();
        ModelRedirect model=new ModelRedirect("tocrudarticle.do");
        return model;
    }
}
@URLMapping("deletearticle.do")
public ModelRedirect delete(ServletEntity entity) throws Exception{
    Article where=new Article();
    where.setId(entity.getData().get("id"));
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        dao.delete(connex, where);
        connex.commit();
        ModelRedirect model=new ModelRedirect("tocrudarticle.do");
        return model;
    }
}
@Url(link = "article.htm")
public ModelView showpage()  throws Exception {
    ModelView result = new ModelView("article");
    return result;
}

}

