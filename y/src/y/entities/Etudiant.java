package y.entities;
import veda.godao.annotations.Column;
import veda.godao.annotations.Table;
import veda.godao.annotations.PrimaryKey;

@Table("etudiant")

public class Etudiant {
    @PrimaryKey
@Column("id")
private Integer id;
public Integer getId(){ return id; }
public void setId(Integer o){ id=o; } 
public void setIdString (String o) { fieldNameMin] = Integer.valueOf(o) ;   } 
@Column("nom")
private String nom;
public String getNom(){ return nom; }
public void setNom(String o){ nom=o; } public void setNomString (String o) { fieldNameMin] = String.valueOf(o) ;   } 
@Column("prenom")
private String prenom;
public String getPrenom(){ return prenom; }
public void setPrenom(String o){ prenom=o; } public void setPrenomString (String o) { fieldNameMin] = String.valueOf(o) ;   } 

    public Etudiant(){} ; 
public Etudiant(Integer o){ id=o; }

}

