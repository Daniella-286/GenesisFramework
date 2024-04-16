package facturation.entities;
import veda.godao.annotations.Column;
import veda.godao.annotations.Table;
import veda.godao.annotations.PrimaryKey;

@Table("facture")

public class Facture {
    @PrimaryKey
@Column("id")
private String id;
public String getId(){ return id; }
public void setId(String o){ id=o; }
@Column("daty")
private java.time.LocalDate daty;
public java.time.LocalDate getDaty(){ return daty; }
public void setDaty(java.time.LocalDate o){ daty=o; }
@Column("designation")
private String designation;
public String getDesignation(){ return designation; }
public void setDesignation(String o){ designation=o; }
@Column("etat")
private String etat;
public String getEtat(){ return etat; }
public void setEtat(String o){ etat=o; }
@Column("montanttotal")
private Double montanttotal;
public Double getMontanttotal(){ return montanttotal; }
public void setMontanttotal(Double o){ montanttotal=o; }

    public Facture(){}
public Facture(String o){ id=o; }

}

