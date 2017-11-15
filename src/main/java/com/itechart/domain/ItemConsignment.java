package com.itechart.domain;

import javax.persistence.*;

public class ItemConsignment {

    @Id
    @Column(name = "iditem_consignments")
    private Integer id;

    @Column(name = "item_amount")
    private Integer amount;

    @Column(name = "item_status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "iditem")
    private Item idItem;

    @OneToOne
    @JoinColumn(name = "idinvoice")
    private Invoice idInvoice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Invoice getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Invoice idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemConsignment that = (ItemConsignment) o;

        if (!id.equals(that.id)) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (!idItem.equals(that.idItem)) return false;
        return idInvoice.equals(that.idInvoice);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + idItem.hashCode();
        result = 31 * result + idInvoice.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ItemConsignment{" +
            "id=" + id +
            ", amount=" + amount +
            ", status='" + status + '\'' +
            ", idItem=" + idItem +
            ", idInvoice=" + idInvoice +
            '}';
    }
}
