package com.enp.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enp.core.DataTable;
import com.enp.core.ENP;
import com.enp.dao.ClientDAO;
import com.enp.dao.UsageDAO;
import com.enp.daoimpl.ClientDAOImpl;
import com.enp.daoimpl.UsageDAOImpl;
import com.enp.pojo.Usage;
import com.enp.util.Constants;

public class RegisterServlet extends HttpServlet
{
   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
      doPost(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
      resp.setContentType("text/html");
      PrintWriter pw = resp.getWriter();
      UsageDAO usageDAO = new UsageDAOImpl();

      try
      {
         String client_id = req.getParameter("client_id");
         String pin = req.getParameter("pin");
         System.out.println(req.getParameterNames());
//         req.getParameterNames();

         if (client_id == null || client_id.trim().length() == 0 || pin == null || pin.trim().length() == 0)
         {
            pw.print("BAD REQUEST");
         }
         else
         {

            ClientDAO clientDAO = new ClientDAOImpl();

            if (clientDAO.isValidClient(client_id, pin))
            {
               Usage u = new Usage();
               u.setClient_id(client_id);
               u.setEntry_time(new Timestamp(System.currentTimeMillis()));
               u.setHit_type("REGISTER");

               usageDAO.write(u);

               String email = req.getParameter("email");
               String passcode = req.getParameter("passcode");
               DataTable data_table = null;

               File file = new File(Constants.DATA_TABLE_PATH + File.separator + "data_table.txt");
               if (file.exists())
               {
                  FileInputStream fi = new FileInputStream(file);
                  ObjectInputStream oi = new ObjectInputStream(fi);
                  data_table = (DataTable) oi.readObject();
                  oi.close();
                  fi.close();
               }

               boolean proceed = true;
               if (data_table != null)
               {
                  Map<String, List<String>> entries = data_table.getEntries();
                  if (entries.keySet().contains(email))
                  {
                     proceed = false;
                  }

               }
               if (proceed)
               {
                  String hash = ENP.sha256(passcode);
                  List<String> ndb = ENP.generateNegativePassword(hash);
                  if (data_table == null)
                     data_table = new DataTable();

                  data_table.getEntries().put(email, ndb);

                  FileOutputStream f = new FileOutputStream(file);
                  ObjectOutputStream o = new ObjectOutputStream(f);
                  o.writeObject(data_table);
                  o.close();
                  f.close();

                  pw.print("REGISTRATION DONE");
               }
               else
               {
                  pw.println("THE ENTRY FOR THIS ACCOUNT ALREADY EXISTS IN AUTHENTICATION DATA TABLE");
               }

            }
            else
            {
               pw.println("YOU ARE NOT AUTHORIZED TO USE THIS SERVICE");
            }

         }

      }
      catch (Exception e)
      {
         e.printStackTrace();
         pw.print("[ERROR] " + e.getMessage());
      }
      pw.close();

   }

}
