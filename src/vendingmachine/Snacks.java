package vendingmachine;

// == SNACK CLASS/OBJECT == //
class Snacks {

    // == ENTITY == //
    private String snackCode;
    private String snackName;
    private int stock;
    private Long price;

    // == CONSTRUCTOR == //
    public Snacks(String snackCode, String snackName, int stock, Long price) {
        this.snackCode = snackCode;
        this.snackName = snackName;
        this.stock = stock;
        this.price = price;
    }

    // == SETTER GETTER == //
    public void setSnackCode(String snackCode) {
        this.snackCode = snackCode;
    }

    public String getSnackCode() {
        return this.snackCode;
    }

    public void setSnackName(String snackName) {
        this.snackName = snackName;
    }

    public String getSnackName() {
        return this.snackName;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return this.stock;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPrice() {
        return this.price;
    }

}
