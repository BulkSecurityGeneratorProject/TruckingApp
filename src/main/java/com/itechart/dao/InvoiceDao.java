package com.itechart.dao;

import com.itechart.domain.Invoice;

import java.util.List;
import java.util.Optional;

/**
 * @author blink7
 * @version 1.0
 * @since 2017-11-15
 */
public interface InvoiceDao {

    /**
     * Returns all instances of the {@link Invoice}.
     *
     * @return all invoices
     */
    List<Invoice> findAll();

    /**
     * Returns all instances of the {@link Invoice} by the given page number and size.
     *
     * @param pageNumber
     * @param pageSize
     * @return all invoices per page.
     */
    List<Invoice> findAllByPage(int pageNumber, int pageSize);

    /**
     * Retrieves a invoice by its id.
     *
     * @param id
     * @return the invoice with the given id or {@literal null} if none found.
     */
    Optional<Invoice> findOne(int id);

    /**
     * Saves a given invoice.
     *
     * @param invoice to save
     */
    void save(Invoice invoice);

    /**
     * Deletes a given invoice.
     *
     * @param invoice to delete
     */
    void delete(Invoice invoice);
}
