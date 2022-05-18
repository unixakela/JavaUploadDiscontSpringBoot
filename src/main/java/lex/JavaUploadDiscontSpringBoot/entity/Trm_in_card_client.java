package lex.JavaUploadDiscontSpringBoot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "trm_in_card_client")
public class Trm_in_card_client implements Serializable {

    private Long global_id;

    @Id
    private Long card;

    private String client;
    private Long version;
    private Long  deleted;

    public Trm_in_card_client() {
    }

    public Long getGlobal_id() {
        return global_id;
    }

    public void setGlobal_id(Long global_id) {
        this.global_id = global_id;
    }

    public Long getCard() {
        return card;
    }

    public void setCard(Long card) {
        this.card = card;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getDeleted() {
        return deleted;
    }

    public void setDeleted(Long deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Trm_in_card_client{" +
                "global_id=" + global_id +
                ", card=" + card +
                ", client='" + client + '\'' +
                ", version=" + version +
                ", deleted=" + deleted +
                '}';
    }
}
