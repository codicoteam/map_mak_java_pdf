package com.clinpride.pdf_maker.model;

import java.util.List;

public class RequestModel {
    private String id;
    private String title;
    private String message;
    private int quantity;
    private double paymentTotal;
    private double expectedDeposit;
    private String customerPhoneNumber;
    private String customerEmail;
    private String rowMaterials;
    private String customerName;
    private boolean showQuotation;
    private boolean doYouHaveMaterials;
    private double expectedBudget;
    private List<Furniture> furnitureBought;
    private String customerAddress;
    private String documentType;
    private String dateNow;
    private String termsAndCondition;



    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTermsAndCondition() {
        return termsAndCondition;
    }

    public void setTermsAndCondition(String termsAndCondition) {
        this.termsAndCondition = termsAndCondition;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateNow() {
        return dateNow;
    }

    public void setDateNow(String dateNow) {
        this.dateNow = dateNow;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(double paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public double getExpectedDeposit() {
        return expectedDeposit;
    }

    public void setExpectedDeposit(double expectedDeposit) {
        this.expectedDeposit = expectedDeposit;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }




    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getRowMaterials() {
        return rowMaterials;
    }

    public void setRowMaterials(String rowMaterials) {
        this.rowMaterials = rowMaterials;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isShowQuotation() {
        return showQuotation;
    }

    public void setShowQuotation(boolean showQuotation) {
        this.showQuotation = showQuotation;
    }

    public boolean isDoYouHaveMaterials() {
        return doYouHaveMaterials;
    }

    public void setDoYouHaveMaterials(boolean doYouHaveMaterials) {
        this.doYouHaveMaterials = doYouHaveMaterials;
    }

    public double getExpectedBudget() {
        return expectedBudget;
    }

    public void setExpectedBudget(double expectedBudget) {
        this.expectedBudget = expectedBudget;
    }

    public List<Furniture> getFurnitureBought() {
        return furnitureBought;
    }

    public void setFurnitureBought(List<Furniture> furnitureBought) {
        this.furnitureBought = furnitureBought;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    // Furniture sub-class
    public static class Furniture {
        private String name;
        private String description;
        private double productPrice;
        private int quantity;

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(double productPrice) {
            this.productPrice = productPrice;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
