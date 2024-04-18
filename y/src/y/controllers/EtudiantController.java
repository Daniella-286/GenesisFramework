package y.controllers;
import veda.godao.DAO;
import veda.godao.utils.DAOConnexion;
import java.sql.Connection;
import y.entities.Etudiant;
import annotation.DefaultParameter;
import annotation.Parameters;
import bdd.BddObject;
import model.database.Constante;
import model.lieu.CategorieLieu;
import url.ModelView;
import annotation.Url;




public class EtudiantController {
    private DAO dao=new DAO("frame", "localhost", "5432", "postgres", "kiwi1234", true, 2);

    
    @Url(link = "traitementEtudiant.htm")
@Parameters(args = { "id" })
public Object insert(String  id ,String  nom ,String  prenom ) throws Exception{
    ModelView result = new ModelView();
    Etudiant o=new Etudiant();
    o.setNom(nom);o.setPrenom(prenom);
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "frame", "postgres", "kiwi1234", true, true)){
        dao.insertWithoutPrimaryKey(connex, o);
        connex.commit();
        result.setUrlRedirect("etudiant.htm");
    } catch (Exception e) {
        return e.getMessage();
    }
    return result;
}



@Url(link = "listeetudiant.htm")
public ModelView getListeEtudiant() throws Exception {
    ModelView result = new ModelView("etudiant");

    try (Connection connex = DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "frame", "postgres", "kiwi1234", true, true)) {
        Etudiant[] items = dao.select(connex, Etudiant.class);
        result.addItem("etudiants", items);
    } catch (Exception e) {
        e.printStackTrace(); 
    }
    return result;
}
@Url(link = "updateetudiant.htm")
public Object update(String  id ,String  nom ,String  prenom ) throws Exception{
    ModelView result = new ModelView();
    Etudiant o=new Etudiant();
    o.setNom(nom);o.setPrenom(prenom);
    Etudiant where=new Etudiant();
    where.setId(id);
    try(Connection connex=DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "frame", "postgres", "kiwi1234", true, true)){
        dao.update(connex, o, where);
        connex.commit();
        result.setUrlRedirect("etudiant.htm");
        } catch (Exception e) {
        return e.getMessage();
    }
    return result;
}
@Url(link = "deleteetudiant.htm")
@Parameters(args = { "id" })
public Object delete(String id) throws Exception {
    ModelView result = new ModelView();
    try {
        Etudiant where = new Etudiant();
        where.setId(Integer.parseInt(id)); 
        
        try (Connection connex = DAOConnexion.getConnexion("org.postgresql.Driver", "postgresql", "localhost", "5432", "frame", "postgres", "kiwi1234", true, true)) {
            dao.delete(connex, where);
            connex.commit();
            result.setUrlRedirect("listeetudiant.htm");
        }
    } catch (Exception e) {
        result.setError(e.getMessage());
    }
    return result;
}
@Url(link = "etudiant.htm")
public ModelView showpage()  throws Exception {
    ModelView result = new ModelView("etudiant");
    return result;
}

}

