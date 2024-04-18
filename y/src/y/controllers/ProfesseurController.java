package y.controllers;
import veda.godao.DAO;
import veda.godao.utils.DAOConnexion;
import java.sql.Connection;
import y.entities.Professeur;
import annotation.DefaultParameter;
import annotation.Parameters;
import bdd.BddObject;
import model.database.Constante;
import model.lieu.CategorieLieu;
import url.ModelView;
import annotation.Url;




public class ProfesseurController {
    private DAO dao=new DAO("frame", "localhost", "5432", "postgres", "kiwi1234", true, 2);

    
    @Url(link = "traitementProfesseur.htm")
@Parameters(args = { "id" })
public Object insert(String  id ,String  nom ,String  prenom ) throws Exception{
    ModelView result = new ModelView();
    Professeur o=new Professeur();
    o.setNom(nom);o.setPrenom(prenom);
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "frame", "postgres", "kiwi1234", true, true)){
        dao.insertWithoutPrimaryKey(connex, o);
        connex.commit();
        result.setUrlRedirect("professeur.htm");
    } catch (Exception e) {
        return e.getMessage();
    }
    return result;
}



@Url(link = "listeprofesseur.htm")
public ModelView getListeProfesseur() throws Exception {
    ModelView result = new ModelView("professeur");

    try (Connection connex = DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "frame", "postgres", "kiwi1234", true, true)) {
        Professeur[] items = dao.select(connex, Professeur.class);
        result.addItem("professeurs", items);
    } catch (Exception e) {
        e.printStackTrace(); 
    }
    return result;
}
@Url(link = "updateprofesseur.htm")
public Object update(String  id ,String  nom ,String  prenom ) throws Exception{
    ModelView result = new ModelView();
    Professeur o=new Professeur();
    o.setNom(nom);o.setPrenom(prenom);
    Professeur where=new Professeur();
    where.setId(id);
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "frame", "postgres", "kiwi1234", true, true)){
        dao.update(connex, o, where);
        connex.commit();
        result.setUrlRedirect("professeur.htm");
        } catch (Exception e) {
        return e.getMessage();
    }
    return result;
}
@Url(link = "deleteprofesseur.htm")
@Parameters(args = { "id" })
public Object delete(String id) throws Exception {
    ModelView result = new ModelView();
    try {
        Professeur where = new Professeur();
        where.setId(Integer.parseInt(id)); 
        
        try (Connection connex = DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "frame", "postgres", "kiwi1234", true, true)) {
            dao.delete(connex, where);
            connex.commit();
            result.setUrlRedirect("listeprofesseur.htm");
        }
    } catch (Exception e) {
        result.setError(e.getMessage());
    }
    return result;
}
@Url(link = "professeur.htm")
public ModelView showpage()  throws Exception {
    ModelView result = new ModelView("professeur");
    return result;
}

}

