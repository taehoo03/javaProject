package sec08;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request,
                             HttpServletResponse response)
            throws ServletException, IOException {

        ProductDAO dao = new ProductDAO();

        ArrayList<ProductVO> productList =
                dao.selectProduct();

        request.setAttribute(
                "productList",
                productList
        );

        RequestDispatcher rd =
                request.getRequestDispatcher(
                        "/productView"
                );

        rd.forward(request, response);
    }
}