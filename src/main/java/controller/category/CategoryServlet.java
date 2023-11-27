package controller.category;

import model.entity.Category;
import model.service.category.CategoryService;
import model.service.category.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/category_manage")
public class CategoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            showTable(request, response);
        }else if (action.equals("search")){
            showSearchTable(request,response);
        } else if (action.equals("sort")) {
            categoryService.sortAZ();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            showTable(request, response);
        }else if (action.equals("search")){
            String search = request.getParameter("search");
            categoryService.findByName(search);
        }
    }
    private void showTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("views/category/showTable.jsp").forward(request,response);
    }
    private void showSearchTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        System.out.println(search);
        if (search.isEmpty()) {
            showTable(request, response);
        }
        List<Category> categories = categoryService.findByName(search);;
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("views/category/showTable.jsp").forward(request,response);
    }
}