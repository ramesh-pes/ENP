package com.enp.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enp.core.DataTable;
import com.enp.core.ENP;
import com.enp.util.Constants;

public class VerificationServlet extends HttpServlet
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
//         System.out.println(email);
//         System.out.println(passcode);

         File file = new File(Constants.DATA_TABLE_PATH + File.separator + "data_table.txt");
         if (file.exists())
         {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            data_table = (DataTable) oi.readObject();
            oi.close();
            fi.close();

            List<String> ndb = data_table.getEntries().get(email);
            String hash = ENP.sha256(passcode);
            if (ENP.verifyNegativePassword(ndb, hash))
            {
               resp.sendRedirect("verification.jsp?msg=Passcode Verification Successful");
            }
            else
            {
               resp.sendRedirect("verification.jsp?msg=Passcode Verification Failed");

            }
         }

         else
         {
            resp.sendRedirect("verification.jsp?msg=Passcode Verification Failed");
         }
      }
      catch (Exception e)
      {
         resp.sendRedirect("verification.jsp?msg=Passcode Verification Failed");
      }
   }

}
