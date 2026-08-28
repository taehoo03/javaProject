package sec08;

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

        response.setContentType(
                "text/html; charset=UTF-8"
        );

        ArrayList<ProductVO> productList =
                (ArrayList<ProductVO>)
                request.getAttribute("productList");

        PrintWriter out =
                response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>상품 목록</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>상품 목록</h2>");

        if (productList != null) {

            for (ProductVO product : productList) {

                out.println("상품번호 : "
                        + product.getPrdNo()
                        + "<br>");

                out.println("상품명 : "
                        + product.getPrdName()
                        + "<br>");

                out.println("가격 : "
                        + product.getPrdPrice()
                        + "원<br>");

                out.println("제조사 : "
                        + product.getPrdMaker()
                        + "<br>");

                out.println("색상 : "
                        + product.getPrdColor()
                        + "<br>");

                out.println("카테고리번호 : "
                        + product.getCtgNo()
                        + "<br>");

                out.println("<hr>");
            }

        } else {

            out.println("상품 정보가 없습니다.");

        }

        out.println("</body>");
        out.println("</html>");
    }
}