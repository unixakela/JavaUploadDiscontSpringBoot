package lex.JavaUploadDiscontSpringBoot.tz;
import lex.JavaUploadDiscontSpringBoot.enumumeration.StatusChange;

public class TZClientsChange {
    private String id_client;
    private String phone;
    private String oldGroupe;
    private String oldName;
    private String newGroupe;
    private String newName;
    private StatusChange status;


    public TZClientsChange() {
    }

    public TZClientsChange(String id_client, String phone, String oldGroupe, String oldName, String newGroupe, String newName, StatusChange status) {
        this.id_client = id_client;
        this.phone = phone;
        this.oldGroupe = oldGroupe;
        this.oldName = oldName;
        this.newGroupe = newGroupe;
        this.newName = newName;
        this.status = status;
    }

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOldGroupe() {
        return oldGroupe;
    }

    public void setOldGroupe(String oldGroupe) {
        this.oldGroupe = oldGroupe;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewGroupe() {
        return newGroupe;
    }

    public void setNewGroupe(String newGroupe) {
        this.newGroupe = newGroupe;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public StatusChange getStatus() {
        return status;
    }

    public void setStatus(StatusChange status) {
        this.status = status;
    }
}
