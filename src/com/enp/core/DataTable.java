package com.enp.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTable implements Serializable
{
   private static final long serialVersionUID = 1L;
   private Map<String, List<String>> entries = new HashMap<>();

   public Map<String, List<String>> getEntries()
   {
      return entries;
   }

   public void setEntries(Map<String, List<String>> entries)
   {
      this.entries = entries;
   }

}
