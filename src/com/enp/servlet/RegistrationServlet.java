package com.enp.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enp.core.DataTable;
import com.enp.core.ENP;
import com.enp.util.Constants;

public class RegistrationServlet extends HttpServlet
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
      try
      {
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

            resp.sendRedirect("registration.jsp?msg=Registration Phase Completed. The entry for the email " + email + " has been made in the Authentication Data Table");
         }
         else
         {
            resp.sendRedirect("registration.jsp?msg=The entry for this email is already present in the Authentication Data Table");
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
         resp.sendRedirect("registration.jsp?msg=Error: " + e.getMessage());
      }
   }

}
