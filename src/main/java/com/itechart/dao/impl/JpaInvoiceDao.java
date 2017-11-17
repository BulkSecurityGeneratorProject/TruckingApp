package com.itechart.dao.impl;

import com.itechart.dao.InvoiceDao;
import com.itechart.domain.Invoice;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

/**
 * @author blink7
 * @version 1.0
 * @since 2017-11-17
 */
public class JpaInvoiceDao implements InvoiceDao {

    private EntityManager em;

    @Override
    public List<Invoice> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Invoice> cq = cb.createQuery(Invoice.class);
        Root<Invoice> root = cq.from(Invoice.class);
        cq.select(root);
        TypedQuery<Invoice> q = em.createQuery(cq);
        return q.getResultList();
    }

    @Override
    public List<Invoice> findAllByPage(int pageNumber, int pageSize) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Invoice> cq = cb.createQuery(Invoice.class);
        Root<Invoice> root = cq.from(Invoice.class);
        cq.select(root);
        TypedQuery<Invoice> q = em.createQuery(cq);
        q.setFirstResult((pageNumber - 1) * pageSize);
        q.setMaxResults(pageSize);
        return q.getResultList();
    }

    @Override
    public Optional<Invoice> findOne(int id) {
        return Optional.of(em.find(Invoice.class, id));
    }

    @Override
    public void save(Invoice invoice) {
        em.persist(invoice);
    }

    @Override
    public void delete(Invoice invoice) {
        em.remove(em.merge(invoice));
    }

    @Override
    public int size() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Invoice> root = cq.from(Invoice.class);
        cq.select(cb.count(root));
        return em.createQuery(cq).getSingleResult().intValue();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}
