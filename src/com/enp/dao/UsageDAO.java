package com.enp.dao;

import java.util.List;

import com.enp.pojo.Usage;

public interface UsageDAO
{

   public void write(Usage u) throws Exception;

   public List<Usage> getAllUsageForClient(String client_id) throws Exception;

   public List<Usage> getAllUsageByHits(String hit_type) throws Exception;

   public List<Usage> getAllUsageForClientByHits(String client_id, String hit_type) throws Exception;

}
