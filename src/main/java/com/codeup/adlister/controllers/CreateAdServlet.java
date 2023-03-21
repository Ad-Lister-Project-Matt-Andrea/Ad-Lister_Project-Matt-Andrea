package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
            return;
        }
        response.sendRedirect("/profile");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }


        long user_id = user.getId();
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String location = request.getParameter("location");
        String category = request.getParameter("category");

        System.out.println(category);
        
        Ad ad = new Ad();
        try {
            ad.setUserId(user_id);
            ad.setTitle(title);
            ad.setDescription(description);
            ad.setPrice(Double.parseDouble(price));
            ad.setLocation(location);

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            response.sendRedirect("/ads/create");
            return;
        }

            //TODO: Insert Ad, store that ID in a variable
            long adID = DaoFactory.getAdsDao().insert(ad);
            long categoryId = DaoFactory.getAdsCategoriesDao().getCategoryId(category);

            DaoFactory.getAdsCategoriesDao().insert(adID, categoryId);
            //TODO: Insert ad id and category id into ads_categories table
            response.sendRedirect("/ads");
        
    }
}
