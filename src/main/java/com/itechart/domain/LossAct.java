package com.itechart.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author blink7
 * @version 1.0
 * @since 2017-11-15
 */
@Entity
@Table(name = "act_of_loss")
public class LossAct implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "invoices_idinvoice")
    private Invoice invoice;

    @Id
    @ManyToOne
    @JoinColumn(name = "items_iditem")
    private Item item;

    @Column(name = "item_amount")
    private int amount;

    @Column(name = "act_date_issue")
    private LocalDate date;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
