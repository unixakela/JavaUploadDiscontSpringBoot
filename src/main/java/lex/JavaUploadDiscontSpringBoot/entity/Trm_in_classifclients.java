package lex.JavaUploadDiscontSpringBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="trm_in_classifclients")
public class Trm_in_classifclients implements Serializable {

    @Column(name = "global_id", nullable = false)
    private Long global_id;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "owner", nullable = false)
    private Long owner;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "pricetype", nullable = false)
    private String pricetype;

    @Column(name = "version", nullable = false)
    private Long version;

    @Column(name = "deleted", nullable = false)
    private  Boolean deleted;

    public Trm_in_classifclients() {
    }

    public Long getGlobal_id() {
        return global_id;
    }

    public void setGlobal_id(Long global_id) {
        this.global_id = global_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Trm_in_classifclients{" +
                "global_id=" + global_id +
                ", id=" + id +
                ", owner=" + owner +
                ", name='" + name + '\'' +
                ", pricetype='" + pricetype + '\'' +
                ", version=" + version +
                ", deleted=" + deleted +
                '}';
    }
}
