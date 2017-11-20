package info.App.VaniteaPOS.m_DataObject;


public class Menus {
    int id;
    String prod_name;
    String prod_desc;
    String image_url;
    int Qcost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_desc() {
        return prod_desc;
    }

    public void setProd_desc(String prod_desc) {
        this.prod_desc = prod_desc;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getQcost() {
        return Qcost;
    }

    public void setQcost(int qcost) {
        Qcost = qcost;
    }
}