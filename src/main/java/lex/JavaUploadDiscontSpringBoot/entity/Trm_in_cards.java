package lex.JavaUploadDiscontSpringBoot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "trm_in_cards")
public class Trm_in_cards implements Serializable {

    private Long global_id;

    @Id
    private Long id;


    private String start_card_code;

    private String stop_card_code;
    private String date_from;
    private String date_till;
    private boolean active;
    private Long version;
    private boolean deleted;

    public Trm_in_cards() {
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

    public String getStart_card_code() {
        return start_card_code;
    }

    public void setStart_card_code(String start_card_code) {
        this.start_card_code = start_card_code;
    }

    public String getStop_card_code() {
        return stop_card_code;
    }

    public void setStop_card_code(String stop_card_code) {
        this.stop_card_code = stop_card_code;
    }

    public String getDate_from() {
        return date_from;
    }

    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }

    public String getDate_till() {
        return date_till;
    }

    public void setDate_till(String date_till) {
        this.date_till = date_till;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Trm_in_cards{" +
                "global_id=" + global_id +
                ", id=" + id +
                ", start_card_code='" + start_card_code + '\'' +
                ", stop_card_code='" + stop_card_code + '\'' +
                ", date_from='" + date_from + '\'' +
                ", date_till='" + date_till + '\'' +
                ", active=" + active +
                ", version=" + version +
                ", deleted=" + deleted +
                '}';
    }
}
