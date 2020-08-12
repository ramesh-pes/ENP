package com.enp.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.enp.dao.UsageDAO;
import com.enp.pojo.Usage;
import com.enp.util.MySQLUtility;

public class UsageDAOImpl implements UsageDAO
{

   @Override
   public void write(Usage u) throws Exception
   {
      Connection con = null;
      try
      {
         con = MySQLUtility.connect();
         con.createStatement().execute("insert into api_usage values ('" + u.getClient_id() + "','" + u.getHit_type() + "','" + u.getEntry_time() + "') ");

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
   public List<Usage> getAllUsageForClient(String client_id) throws Exception
   {
      Connection con = null;
      List<Usage> result = new ArrayList<>();
      try
      {
         con = MySQLUtility.connect();
         ResultSet rs = con.createStatement().executeQuery("select * from api_usage where client_id='" + client_id + "' ");
         while (rs.next())
         {
            Usage u = new Usage();
            u.setClient_id(rs.getString("client_id"));
            u.setEntry_time(rs.getTimestamp("entry_time"));
            u.setHit_type(rs.getString("hit_type"));
            result.add(u);
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
   public List<Usage> getAllUsageByHits(String hit_type) throws Exception
   {
      Connection con = null;
      List<Usage> result = new ArrayList<>();
      try
      {
         con = MySQLUtility.connect();
         ResultSet rs = con.createStatement().executeQuery("select * from api_usage where hit_type='" + hit_type + "' ");
         while (rs.next())
         {
            Usage u = new Usage();
            u.setClient_id(rs.getString("client_id"));
            u.setEntry_time(rs.getTimestamp("entry_time"));
            u.setHit_type(rs.getString("hit_type"));
            result.add(u);
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
   public List<Usage> getAllUsageForClientByHits(String client_id, String hit_type) throws Exception
   {
      Connection con = null;
      List<Usage> result = new ArrayList<>();
      try
      {
         con = MySQLUtility.connect();
         ResultSet rs = con.createStatement().executeQuery("select * from api_usage where client_id='" + client_id + "' and hit_type='" + hit_type + "'");
         while (rs.next())
         {
            Usage u = new Usage();
            u.setClient_id(rs.getString("client_id"));
            u.setEntry_time(rs.getTimestamp("entry_time"));
            u.setHit_type(rs.getString("hit_type"));
            result.add(u);
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
