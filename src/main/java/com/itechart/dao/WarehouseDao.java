package com.itechart.dao;

import com.itechart.dao.exception.WarehouseDaoException;
import com.itechart.domain.Warehouse;

import java.util.List;
import java.util.Optional;

public interface WarehouseDao {

    /**
     * get warehouse by id from storage
     * @param id - unique id of existed warehouse
     * @return Optional warehouse object
     * @throws WarehouseDaoException - if there is error during performing method
     */
    Optional<Warehouse> getWarehouseById(Integer id) throws WarehouseDaoException;

    /**
     * gets list of warehouses from storage
     * @param namePattern - part of warehouse name for searching
     * @return list of found warehouse objects
     * @throws WarehouseDaoException - if there is error during performing method
     */
    List<Warehouse> findWarehousesByName(String namePattern) throws WarehouseDaoException;

    /**
     * gets warehouse objects from storage
     * @param recordOffset - offset of all warehouses stored in storage
     * @param recordCount - count of warehouses to return
     * @return list of warehouse objects
     * @throws WarehouseDaoException - if there is error during performing method
     */
    List<Warehouse> getWarehouses(final int recordOffset, final int recordCount) throws WarehouseDaoException;

    /**
     * gets count of warehouses in storage
     * @return count of warehouse objects in storage
     * @throws WarehouseDaoException - if there is error during performing method
     */
    int getContactCount() throws WarehouseDaoException;

    /**
     * adds new warehouse to the storage
     * @param warehouse - new warehouse object
     * @return id of added warehouse
     * @throws WarehouseDaoException if there is error during performing method
     */
    Integer addWarehouse(Warehouse warehouse) throws WarehouseDaoException;

    /**
     * updates existed warehouse in storage
     * @param id - unique id of existed warehouse
     * @param warehouse - new warehouse
     * @return true - if update is succeed
     *         false - if update isn't succeed
     * @throws WarehouseDaoException if there is error during performing method
     */
    Boolean updateWarehouseById(Integer id, Warehouse warehouse) throws WarehouseDaoException;

    /**
     * deletes existed warehouse in storage
     * @param id - unique id of existed warehouse
     * @return true - if delete is succeed
     *         false - if delete isn't succeed
     * @throws WarehouseDaoException if there is error during performing method
     */
    Boolean deleteWarehouseById(Integer id) throws WarehouseDaoException;
}
