package controller;

import model.Category;
import model.Product;
import service.CategoryService;
import service.CategoryServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static javafx.beans.property.adapter.JavaBeanDoublePropertyBuilder.create;

@WebServlet(name = "ProductServlet", urlPatterns = "/ProductS")
public class ProductServlet extends HttpServlet {
    CategoryService categoryService =new CategoryServiceImpl();

    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request,response);
                break;
            case "delete":
                try {
                    delete(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "view":
                showViewForm(request,response);

                break;
            default:
                showList(request, response);
        }
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        request.setAttribute("ct", categories);
        int id =Integer.parseInt(request.getParameter("id"));
        Product product =productService.findById(id);
        request.setAttribute("pr",product);
        request.getRequestDispatcher("product/view.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id =Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        response.sendRedirect("/ProductS");
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        request.setAttribute("cate", categories);
        request.getRequestDispatcher("product/create.jsp").forward(request, response);
    }



    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        List<Category> categories = categoryService.findAll();
        request.setAttribute("cate", categories);
        List<Product> products = productService.findAll();
        request.setAttribute("prod", products);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    create(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name =request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color =request.getParameter("color");
        String description =request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Category category =categoryService.findById(categoryId);
        productService.add(new Product(id,name,price,quantity,color,description,category));
        response.sendRedirect("/ProductS");
    }
}

