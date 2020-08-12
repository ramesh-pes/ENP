package com.enp.dao;

import java.util.List;

import com.enp.pojo.Client;

public interface ClientDAO
{

   public void write(Client client) throws Exception;

   public void remove(String client_id) throws Exception;

   public List<Client> getAllClient() throws Exception;
   
   public boolean isValidClient(String clientID, String pin) throws Exception;

}
