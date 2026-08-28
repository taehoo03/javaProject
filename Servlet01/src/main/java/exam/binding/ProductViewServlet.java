package exam.binding;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductViewServlet extends HttpServlet {

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

        response.setContentType("text/html; charset=UTF-8");

        ArrayList<ProductVo> productList =
                (ArrayList<ProductVo>)
                request.getAttribute("productList");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>상품 목록</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>상품 목록</h2>");

        for (ProductVo product : productList) {

            out.println("상품번호 : "
                    + product.getProductNo() + "<br>");

            out.println("상품명 : "
                    + product.getProductName() + "<br>");

            out.println("가격 : "
                    + product.getPrice() + "원<br>");

            out.println("회사 : "
                    + product.getCompany() + "<br>");

            out.println("설명 : "
                    + product.getDescription() + "<br>");

            out.println("<hr>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}