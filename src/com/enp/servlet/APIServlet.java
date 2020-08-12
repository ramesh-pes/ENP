package com.enp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enp.dao.ClientDAO;
import com.enp.daoimpl.ClientDAOImpl;
import com.enp.mail.MailThread;
import com.enp.pojo.Client;
import com.enp.util.Constants;
import com.enp.util.Util;

public class APIServlet extends HttpServlet
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
         ClientDAO clientDAO = new ClientDAOImpl();
         String type = req.getParameter("type");
         if (type == null)
         {
            resp.sendRedirect("asaservice.jsp?msg=Bad Request");
         }
         else
         {
            if (type.equals("put"))
            {
               String name = req.getParameter("name");
               Client c = new Client();
               c.setClient_id("CLIENT-" + Util.generateID());
               c.setPin(Util.getAlphaNumericString(16));
               c.setName(name);
               clientDAO.write(c);

               String url1 = "http://" + Constants.HOST + ":" + Constants.PORT + "/ENP/register";
               String url2 = "http://" + Constants.HOST + ":" + Constants.PORT + "/ENP/verify";

               String register_service = url1;
               String verify_service = url2;

               String sub = "API access details to ENP services";
               String body = "Dear <b>" + name + "</b><br/><br/>An API access has been set up for you to the ENP services and here is the details about it.<br/><br/>";
               body += "CLIENT ID: <b>" + c.getClient_id() + "</b><br/>";
               body += "PIN: <b>" + c.getPin() + "</b><br/><br/>";
               body += "Request URL to access the <b>REGISTER</b> Service: <br/>";
               body += "<b>" + register_service + "</b><br/><br/>";
               body += "Request URL to access the <b>VERIFY</b> Service: <br/>";
               body += "<b>" + verify_service + "</b><br/><br/><br/>";
               body += "Parameters for each of the above requests: <br/>";
               body += "<b>email:</b>xyz@pqr.com<br/>";
               body += "<b>passcode:</b>1234<br/>";
               body += "<b>client_id:</b>" + c.getClient_id() + "<br/>";
               body += "<b>pin:</b>" + c.getPin() + "<br/>";

               String to = c.getName();
               List<String> rec = new ArrayList<>();
               rec.add(to);

               new MailThread(body, sub, rec);

               resp.sendRedirect(
                        "asaservice.jsp?msg=success");

            }
            else if (type.equals("delete"))
            {
               String client_id = req.getParameter("client_id");
               clientDAO.remove(client_id);
               resp.sendRedirect("asaservice.jsp?msg=Deleted the Access to the Client " + client_id);

            }
         }
      }
      catch (Exception e)
      {
         resp.sendRedirect("asaservice.jsp?msg=Error: " + e.getMessage());
      }
   }

}
