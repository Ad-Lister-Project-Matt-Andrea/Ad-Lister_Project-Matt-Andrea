package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            request.setAttribute("categories", DaoFactory.getAdsCategoriesDao().all());
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

        // TODO: put this into helper function
        String[] categoriesStringList = request.getParameterValues("category");
        ArrayList<Long> longList = new ArrayList<>();
        for (String category:categoriesStringList) {
            long id = Long.parseLong(category);
            longList.add(id);
        }
        ArrayList<Category> categories = DaoFactory.getAdsCategoriesDao().findByIds(longList);

        if(title == null || description ==null || price == null || location == null || categories == null){
            response.sendRedirect("/ads/create");
            return;
        }

        Ad ad = new Ad();
        try {
            ad.setUserId(user_id);
            ad.setTitle(title);
            ad.setDescription(description);
            ad.setPrice(Double.parseDouble(price));
            ad.setLocation(location);
            ad.setCategories(categories);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            response.sendRedirect("/ads/create");
            return;
        }

        long adId = DaoFactory.getAdsDao().insert(ad);
        ad.setId(adId);
        DaoFactory.getAdsCategoriesDao().insert(ad);
        response.sendRedirect("/ads");
        
    }
}
