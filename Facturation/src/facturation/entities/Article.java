package facturation.entities;
import veda.godao.annotations.Column;
import veda.godao.annotations.Table;
import veda.godao.annotations.PrimaryKey;

@Table("article")

public class Article {
    @PrimaryKey
@Column("id")
private String id;
public String getId(){ return id; }
public void setId(String o){ id=o; }
@Column("code")
private String code;
public String getCode(){ return code; }
public void setCode(String o){ code=o; }
@Column("designation")
private String designation;
public String getDesignation(){ return designation; }
public void setDesignation(String o){ designation=o; }
@veda.godao.annotations.ForeignKey(recursive=true)
@Column("unite")
private UniteArticle uniteArticle;
public UniteArticle getUniteArticle(){ return uniteArticle; }
public void setUniteArticle(UniteArticle o){ uniteArticle=o; }
@veda.godao.annotations.ForeignKey(recursive=true)
@Column("type")
private TypeArticle typeArticle;
public TypeArticle getTypeArticle(){ return typeArticle; }
public void setTypeArticle(TypeArticle o){ typeArticle=o; }
@Column("pu")
private Double pu;
public Double getPu(){ return pu; }
public void setPu(Double o){ pu=o; }

    public Article(){}
public Article(String o){ id=o; }

}

