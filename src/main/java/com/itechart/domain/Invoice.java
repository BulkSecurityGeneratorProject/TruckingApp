package com.itechart.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @author blink7
 * @version 1.0
 * @since 2017-11-15
 */
@Entity
@Table(name = "invoices")
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idinvoice")
    private int id;

    @Column(name = "invoice_issuedate")
    private LocalDate issueDate;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemConsignment> itemConsignments;

    @Column(name = "invoice_status")
    @Convert(converter = StatusConverter.class)
    private Status status;

    @OneToOne
    @JoinColumn(name = "users_iduser_creator")
    private User creator;

    @Column(name = "invoice_checkdate")
    private LocalDate checkDate;

    @OneToOne
    @JoinColumn(name = "users_iduser_inspector")
    private User inspector;

    @OneToOne
    @JoinColumn(name = "waybills_idwaybill")
    private Waybill waybill;

    @OneToMany(mappedBy = "invoice")
    private List<LossAct> lossActs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public List<ItemConsignment> getItemConsignments() {
        return itemConsignments;
    }

    public void setItemConsignments(List<ItemConsignment> itemConsignments) {
        this.itemConsignments = itemConsignments;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public LocalDate getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(LocalDate checkDate) {
        this.checkDate = checkDate;
    }

    public User getInspector() {
        return inspector;
    }

    public void setInspector(User inspector) {
        this.inspector = inspector;
    }

    public Waybill getWaybill() {
        return waybill;
    }

    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }

    public List<LossAct> getLossActs() {
        return lossActs;
    }

    public void setLossActs(List<LossAct> lossActs) {
        this.lossActs = lossActs;
    }

    public boolean removeLossAct(LossAct lossAct) {
        boolean result = lossActs.remove(lossAct);
        lossAct.setInvoice(null);
        return result;
    }

    public enum Status {
        ISSUED,
        CHECKED,
        DELIVERED
    }

    @Convert
    private class StatusConverter implements AttributeConverter<Status, String> {

        @Override
        public String convertToDatabaseColumn(Status attribute) {
            switch (attribute) {
                case ISSUED:
                    return "I";
                case CHECKED:
                    return "C";
                case DELIVERED:
                    return "D";
                default:
                    throw new IllegalArgumentException("Unknown " + attribute);
            }
        }

        @Override
        public Status convertToEntityAttribute(String dbData) {
            switch (dbData) {
                case "I":
                    return Status.ISSUED;
                case "C":
                    return Status.CHECKED;
                case "D":
                    return Status.DELIVERED;
                default:
                    throw new IllegalArgumentException("Unknown " + dbData);
            }
        }
    }
}
