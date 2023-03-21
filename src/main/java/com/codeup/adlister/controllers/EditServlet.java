package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.EditServlet", urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            String adId = request.getParameter("id");
            Ad ad = DaoFactory.getAdsDao().findById(Long.parseLong(adId));
            request.setAttribute("ad", ad);
            request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
            return;
        }
        response.sendRedirect("/login");
    }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            long adId = Long.parseLong(request.getParameter("id"));
            Ad ad = DaoFactory.getAdsDao().findById(adId);
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            String location = request.getParameter("location");


            ad.setTitle(title);
            ad.setDescription(description);
            ad.setPrice(price);
            ad.setLocation(location);

            DaoFactory.getAdsDao().update(ad);

            response.sendRedirect("/profile");
        }
    }
