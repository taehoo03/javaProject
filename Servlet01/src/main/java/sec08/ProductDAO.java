package sec08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ojdbc.DBConnect;

public class ProductDAO {

    public ArrayList<ProductVO> selectProduct() {

        ArrayList<ProductVO> list =
                new ArrayList<ProductVO>();

        String sql =
                "SELECT PRDNO, PRDNAME, PRDPRICE, PRDMAKER, PRDCOLOR, CTGNO "
              + "FROM PRODUCTFIN "
              + "WHERE ROWNUM <= 3";

        try {

            Connection conn = DBConnect.getConnection();

            PreparedStatement pstmt =
                    conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                ProductVO product = new ProductVO();

                product.setPrdNo(
                        rs.getString("PRDNO"));

                product.setPrdName(
                        rs.getString("PRDNAME"));

                product.setPrdPrice(
                        rs.getInt("PRDPRICE"));

                product.setPrdMaker(
                        rs.getString("PRDMAKER"));

                product.setPrdColor(
                        rs.getString("PRDCOLOR"));

                product.setCtgNo(
                        rs.getInt("CTGNO"));

                list.add(product);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}