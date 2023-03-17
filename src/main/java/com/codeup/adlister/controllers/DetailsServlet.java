package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.DetailsServlet", urlPatterns = "/ads/details")
public class DetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adId = request.getParameter("id");
        Ad ad = DaoFactory.getAdsDao().findById(Long.parseLong(adId));
        request.setAttribute("ad", ad);
        request.getRequestDispatcher("/WEB-INF/ads/details.jsp").forward(request, response);
    }
}
