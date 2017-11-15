package com.itechart.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author blink7
 * @version 1.0
 * @since 2017-11-15
 */
@Entity
@Table(name = "waybills")
public class Waybill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idwaybill")
    private int id;

    @OneToOne(mappedBy = "waybill", fetch = FetchType.EAGER)
    private Invoice invoice;

    @OneToOne
    @JoinColumn(name = "clients_idclients")
    private Client client;

    @Column(name = "waybill_departure_date")
    private LocalDate departureDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_iduser_driver")
    private User driver;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_park_idcar")
    private Car car;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "warehouses_idwarehouse_from")
    private Warehouse from;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "warehouses_idwarehouse_to")
    private Warehouse to;

    @OneToMany(mappedBy = "waybill", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WaybillCheckpoint> waybillCheckpoints = new ArrayList<>();

    @Column(name = "waybill_status")
    @Convert(converter = StatusConverter.class)
    private Status status;

    @Column(name = "waybills_issuedate")
    private LocalDate issueDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Warehouse getFrom() {
        return from;
    }

    public void setFrom(Warehouse from) {
        this.from = from;
    }

    public Warehouse getTo() {
        return to;
    }

    public void setTo(Warehouse to) {
        this.to = to;
    }

    /**
     * Use this method only to get a {@link WaybillCheckpoint#checkpoint checkpoint}
     * and set {@link WaybillCheckpoint#checkDate checkDate} value.
     *
     * To add and remove a checkpoint use {@link #addCheckpoint(Checkpoint) addCheckpoint} method
     * and {@link #removeCheckpoint(Checkpoint) removeCheckpoint} method accordingly.
     *
     * @return a wrapper containing {@link Waybill} and {@link Checkpoint}.
     */
    public List<WaybillCheckpoint> getWaybillCheckpoints() {
        return waybillCheckpoints;
    }

    public void addCheckpoint(Checkpoint checkpoint) {
        WaybillCheckpoint waybillCheckpoint = new WaybillCheckpoint(this, checkpoint);
        waybillCheckpoints.add(waybillCheckpoint);
    }

    public void removeCheckpoint(Checkpoint checkpoint) {
        waybillCheckpoints.removeIf(waybillCheckpoint -> waybillCheckpoint.getWaybill().equals(this)
                && waybillCheckpoint.getCheckpoint().equals(checkpoint));
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public enum Status {
        STARTED,
        COMPLETED
    }

    @Convert
    private class StatusConverter implements AttributeConverter<Status, String> {

        @Override
        public String convertToDatabaseColumn(Status attribute) {
            switch (attribute) {
                case STARTED:
                    return "S";
                case COMPLETED:
                    return "C";
                default:
                    throw new IllegalArgumentException("Unknown " + attribute);
            }
        }

        @Override
        public Status convertToEntityAttribute(String dbData) {
            switch (dbData) {
                case "S":
                    return Status.STARTED;
                case "C":
                    return Status.COMPLETED;
                default:
                    throw new IllegalArgumentException("Unknown " + dbData);
            }
        }
    }
}
