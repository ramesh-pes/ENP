package com.enp.pojo;

import java.sql.Timestamp;

public class Usage
{
   private String client_id;
   private String hit_type;
   private Timestamp entry_time;

   public String getClient_id()
   {
      return client_id;
   }

   public void setClient_id(String client_id)
   {
      this.client_id = client_id;
   }

   public String getHit_type()
   {
      return hit_type;
   }

   public void setHit_type(String hit_type)
   {
      this.hit_type = hit_type;
   }

   public Timestamp getEntry_time()
   {
      return entry_time;
   }

   public void setEntry_time(Timestamp entry_time)
   {
      this.entry_time = entry_time;
   }

}
