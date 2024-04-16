package facturation.entities;
import veda.godao.annotations.Column;
import veda.godao.annotations.Table;
import veda.godao.annotations.PrimaryKey;

@Table("unite_article")

public class UniteArticle {
    @PrimaryKey
@Column("id")
private String id;
public String getId(){ return id; }
public void setId(String o){ id=o; }
@Column("description")
private String description;
public String getDescription(){ return description; }
public void setDescription(String o){ description=o; }

    public UniteArticle(){}
public UniteArticle(String o){ id=o; }

}

