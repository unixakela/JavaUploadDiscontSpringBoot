package lex.JavaUploadDiscontSpringBoot.excel;

public class ExcelBean {
    private String date; // имя
    private String sub_name; // табельный номер
    private String phone; // Дополнение к еде
    private String card; // Отдел
    private String birthday; // Отдел

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "ExcelBean{" +
                "date='" + date + '\'' +
                ", sub_name='" + sub_name + '\'' +
                ", phone='" + phone + '\'' +
                ", card='" + card + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}