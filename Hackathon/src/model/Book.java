package model;

public class Book {
    private int id ;
    private String name;
    private  double price;
    private  String authorName;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private double interest;

    private  boolean status = true;

    public Book() {
    }

    public Book(int id, String name, double price, String authorName, String descriptions, double importPrice, double exportPrice, double interest, boolean status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.authorName = authorName;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", authorName='" + authorName + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", interest=" + interest +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
