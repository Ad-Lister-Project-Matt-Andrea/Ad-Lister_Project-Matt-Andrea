package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.DeleteAdServlet", urlPatterns = "/delete")
public class DeleteAdServlet  extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adId = request.getParameter("id");
        Ad ad = DaoFactory.getAdsDao().findById(Long.parseLong(adId));

        DaoFactory.getAdsDao().delete(ad);

        response.sendRedirect("/profile");

    }
}
