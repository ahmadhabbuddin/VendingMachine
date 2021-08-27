package vendingmachine;

// == OBJECT TRANSACTION HISTORY == //
class TransactionHistory {

    // == ENTITY == //
    private Long id;
    private String snackCode;
    private Long payment;

    // == CONSTRUCTOR == //
    public TransactionHistory(Long id, String snackCode, Long payment) {
        this.id = id;
        this.snackCode = snackCode;
        this.payment = payment;
    }

    // == SETTER GETTER == //
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setSnackCode(String snackCode) {
        this.snackCode = snackCode;
    }

    public String getSnackCode() {
        return this.snackCode;
    }

    public void setIncome(Long payment) {
        this.payment = payment;
    }

    public Long getIncome() {
        return this.payment;
    }

}
