package exam.binding;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductBindingServlet extends HttpServlet {

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

        ArrayList<ProductVo> productList =
                new ArrayList<ProductVo>();

        ProductVo product1 = new ProductVo(
                1,
                "노트북",
                1000000,
                "삼성",
                "고성능 노트북"
        );

        ProductVo product2 = new ProductVo(
                2,
                "스마트폰",
                800000,
                "애플",
                "최신 스마트폰"
        );

        ProductVo product3 = new ProductVo(
                3,
                "태블릿",
                600000,
                "LG",
                "휴대용 태블릿"
        );

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        request.setAttribute("productList", productList);

        RequestDispatcher rd =
                request.getRequestDispatcher("/productView");

        rd.forward(request, response);
    }
}