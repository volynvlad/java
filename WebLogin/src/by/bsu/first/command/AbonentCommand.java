package by.bsu.first.command;

import by.bsu.first.entity.Abonent;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Ihar_Blinou on 10/21/2015.
 */
public class AbonentCommand implements Command {
    private static final String PATH_PAGE_ABONENTS = "/jsp/abonents.jsp";
    @Override
    public String execute(HttpServletRequest request) {
        String url = "jdbc:mysql://localhost:3306/testphone";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "pass");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        Connection cn = null;
        try { // 1 блок
          //  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(url, prop);

            Statement st = null;
            final String SQL_INSERT =
                    "INSERT INTO phonebook(idphonebook, lastname, phone ) VALUES(?,?,?)";

            PreparedStatement ps  = cn.prepareStatement(SQL_INSERT);
            ps.setInt(1, 777);
            ps.setString(2, "МИХЕД");
            ps.setInt(3, 777777);
            ps.executeUpdate();
  try { // 2 блок
                st = cn.createStatement();
                ResultSet rs = null;

                    rs = st.executeQuery("SELECT * FROM phonebook");
                    ArrayList<Abonent> lst = new ArrayList<>();
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        int phone = rs.getInt(3);
                        String name = rs.getString(2);
                        lst.add(new Abonent(id, phone, name));
                    }
                    if (lst.size() > 0) {
                       request.setAttribute("list", lst);
                    } else {
                        request.setAttribute("not_list", "Abonents not found");
                    }
                } finally {
/*
* закрыть Statement, если он был открыт или ошибка
* произошла во время создания Statement
*/
                if (st != null) { // для 2-го блока try
                    st.close();
                } else {
                    System.err.println("Statement не создан");
                }
            }
        } catch (SQLException e) { // для 1-го блока try
            System.err.println("DB connection error: " + e);
/*
* вывод сообщения о всех SQLException
*/
        } finally {
/*
* закрыть Connection, если он был открыт
*/
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }
        }


        return PATH_PAGE_ABONENTS;
    }
}
