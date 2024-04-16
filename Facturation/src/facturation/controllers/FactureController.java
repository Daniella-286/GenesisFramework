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
import facturation.entities.Facture;
import annotation.DefaultParameter;
import annotation.Parameters;
import bdd.BddObject;
import model.database.Constante;
import model.lieu.CategorieLieu;
import url.ModelView;

@Controller
@Singleton

public class FactureController {
    private DAO dao=new DAO("articles", "localhost", "5432", "postgres", "kiwi1234", true, 2);

    
    @URLMapping("insertfacture.do")
public ModelRedirect insert(ServletEntity entity) throws Exception{
    Facture o=new Facture();
    [fields]
    o.setDaty(java.time.LocalDate.parse(entity.getData().get("daty")));o.setDesignation(entity.getData().get("designation"));o.setEtat(entity.getData().get("etat"));o.setMontanttotal(Double.parseDouble(entity.getData().get("montanttotal")));
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        dao.insertWithoutPrimaryKey(connex, o);
        connex.commit();
        ModelRedirect model=new ModelRedirect("tocrudfacture.do");
        return model;
    }
}

@URLMapping("tocrudfacture.htm")
@Parameters("tocrudfacture.do")
public ModelView crudpage(ServletEntity entity) throws Exception{
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        ModelView model=new ModelView();
        model.setView("pages/layout/layout.jsp");
        Facture[] o=dao.select(connex, Facture.class);
        model.addItem("viewpage", "facture.jsp");
        model.addItem("title", "Facture");
        model.addItem("o", o);
        
        return model;
    }
}
@URLMapping("updatefacture.do")
public ModelRedirect update(ServletEntity entity) throws Exception{
    Facture o=new Facture();
    o.setDaty(java.time.LocalDate.parse(entity.getData().get("daty")));o.setDesignation(entity.getData().get("designation"));o.setEtat(entity.getData().get("etat"));o.setMontanttotal(Double.parseDouble(entity.getData().get("montanttotal")));
    Facture where=new Facture();
    where.setId(entity.getData().get("id"));
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        dao.update(connex, o, where);
        connex.commit();
        ModelRedirect model=new ModelRedirect("tocrudfacture.do");
        return model;
    }
}
@URLMapping("deletefacture.do")
public ModelRedirect delete(ServletEntity entity) throws Exception{
    Facture where=new Facture();
    where.setId(entity.getData().get("id"));
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "articles", "postgres", "kiwi1234", true, true)){
        dao.delete(connex, where);
        connex.commit();
        ModelRedirect model=new ModelRedirect("tocrudfacture.do");
        return model;
    }
}
@Url(link = "facture.htm")
public ModelView showpage()  throws Exception {
    ModelView result = new ModelView("facture");
    return result;
}

}

