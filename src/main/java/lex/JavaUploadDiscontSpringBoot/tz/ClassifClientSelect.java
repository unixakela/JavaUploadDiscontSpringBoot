package lex.JavaUploadDiscontSpringBoot.tz;

public class ClassifClientSelect {
    private String id;
    private String name;
    private boolean selected;

    public ClassifClientSelect(String id, String name, boolean selected) {
        this.id = id;
        this.name = name;
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "ClassifClientSelect{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", selected=" + selected +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
