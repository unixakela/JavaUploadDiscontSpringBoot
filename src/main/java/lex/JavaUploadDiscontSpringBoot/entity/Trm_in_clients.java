package lex.JavaUploadDiscontSpringBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "trm_in_clients")

public class Trm_in_clients implements Serializable {

    private static final long serialVersionUID = 1L;


    @Column(name = "global_id", nullable = false)
    private Integer globalId;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "classifclient", nullable = false)
    private Long classifclient;

    @Column(name = "sur_name", nullable = false)
    private String surName;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "inn")
    private String inn;

    @Column(name = "passport")
    private String passport;

    @Column(name = "pricetype")
    private String pricetype;

    @Column(name = "type", nullable = false)
    private Boolean type;

    @Column(name = "allow_paycash", nullable = false)
    private Boolean allowPaycash;

    @Column(name = "structure")
    private String structure;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "save_change", nullable = false)
    private Boolean saveChange;

    @Column(name = "version", nullable = false)
    private Long version;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    public Trm_in_clients() {
    }

    @Override
    public String toString() {
        return "Trm_in_clients{" +
                "globalId=" + globalId +
                ", id='" + id + '\'' +
                ", classifclient=" + classifclient +
                ", surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday='" + birthday + '\'' +
                ", inn='" + inn + '\'' +
                ", passport='" + passport + '\'' +
                ", pricetype='" + pricetype + '\'' +
                ", type=" + type +
                ", allowPaycash=" + allowPaycash +
                ", structure='" + structure + '\'' +
                ", active=" + active +
                ", saveChange=" + saveChange +
                ", version=" + version +
                ", deleted=" + deleted +
                '}';
    }

    public Integer getGlobalId() {
        return globalId;
    }

    public void setGlobalId(Integer globalId) {
        this.globalId = globalId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getClassifclient() {
        return classifclient;
    }

    public void setClassifclient(Long classifclient) {
        this.classifclient = classifclient;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Boolean getAllowPaycash() {
        return allowPaycash;
    }

    public void setAllowPaycash(Boolean allowPaycash) {
        this.allowPaycash = allowPaycash;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getSaveChange() {
        return saveChange;
    }

    public void setSaveChange(Boolean saveChange) {
        this.saveChange = saveChange;
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
}
