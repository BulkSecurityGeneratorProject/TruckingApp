package com.itechart.dao;

import com.itechart.dao.exception.ClientDaoException;
import com.itechart.domain.Client;
import com.itechart.domain.Warehouse;

import java.util.List;
import java.util.Optional;

public interface ClientDao {

    /**
     * gets client by id from storage
     * @param id - unique id of existed client
     * @return Optional client object
     * @throws ClientDaoException - if there is error during performing method
     */
    Optional<Client> getClientById(Integer id) throws ClientDaoException;

    /**
     * gets list of clients from storage
     * @param namePattern - part of client name for searching
     * @return list of found clients objects
     * @throws ClientDaoException - if there is error during performing method
     */
    List<Client> findClientsByName(String namePattern) throws ClientDaoException;

    /**
     * gets client objects from storage
     * @param recordOffset - offset of all clients stored in storage
     * @param recordCount - count of clients to return
     * @return list of client objects
     * @throws ClientDaoException - if there is error during performing method
     */
    List<Warehouse> getClients(final int recordOffset, final int recordCount) throws ClientDaoException;

    /**
     * gets count of clients in storage
     * @return count of client objects in storage
     * @throws ClientDaoException - if there is error during performing method
     */
    int getClientCount() throws ClientDaoException;

    /**
     * adds new cleint to the storage
     * @param client - new client object
     * @return id of added client
     * @throws ClientDaoException if there is error during performing method
     */
    Integer addClient(Client client) throws ClientDaoException;

    /**
     * updates existed client in storage
     * @param id - unique id of existed warehouse
     * @param warehouse - new warehouse
     * @return true - if update is succeed
     *         false - if update isn't succeed
     * @throws ClientDaoException if there is error during performing method
     */
    Boolean updateClientById(Integer id, Client warehouse) throws ClientDaoException;

    /**
     * deletes existed warehouse in storage
     * @param id - unique id of existed warehouse
     * @return true - if delete is succeed
     *         false - if delete isn't succeed
     * @throws ClientDaoException if there is error during performing method
     */
    Boolean deleteClientById(Integer id) throws ClientDaoException;
}
