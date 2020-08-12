package com.enp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.enp.dao.ClientDAO;
import com.enp.pojo.Client;
import com.enp.util.MySQLUtility;
import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.log.LogFactory;

public class ClientDAOImpl implements ClientDAO
{

   @Override
   public void write(Client client) throws Exception
   {
      Connection con = null;
      try
      {
         con = MySQLUtility.connect();
         PreparedStatement ps = con.prepareStatement("insert into clients values (?,?,?)");
         ps.setString(1, client.getClient_id());
         ps.setString(2, client.getName());
         ps.setString(3, client.getPin());
         ps.execute();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         con.close();
      }

   }

   @Override
   public void remove(String client_id) throws Exception
   {
      Connection con = null;
      try
      {
         con = MySQLUtility.connect();
         con.createStatement().execute("delete from clients where client_id='" + client_id + "' ");
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         con.close();
      }

   }

   @Override
   public List<Client> getAllClient() throws Exception
   {
      Connection con = null;
      List<Client> result = new ArrayList<>();
      try
      {
         con = MySQLUtility.connect();
         ResultSet rs = con.createStatement().executeQuery("select * from clients");
         while (rs.next())
         {
            Client cl = new Client();
            cl.setClient_id(rs.getString("client_id"));
            cl.setName(rs.getString("name"));
            cl.setPin(rs.getString("pin"));
            result.add(cl);
         }

      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         con.close();
      }
      return result;
   }

   @Override
   public boolean isValidClient(String clientID, String pin) throws Exception
   {
      Connection con = null;
      boolean result = false;
      try
      {
         con = MySQLUtility.connect();
         ResultSet rs = con.createStatement().executeQuery("select count(*) from clients where client_id='" + clientID + "' and pin='" + pin + "' ");
         rs.next();
         if (rs.getInt(1) > 0)
         {
            result = true;
         }

      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         con.close();
      }
      return result;

   }

}
