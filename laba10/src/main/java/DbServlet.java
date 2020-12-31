import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/GoDb")
public class DbServlet extends HttpServlet {
    Connection connection;

    @SneakyThrows
    @Override
    public void init() throws ServletException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                "root","134576290");
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        CallableStatement callableStatement = connection.prepareCall("{call getCountryCount(?)}");
        callableStatement.setInt(1, 0);
        callableStatement.execute();

        int countryCount = callableStatement.getInt(1);
        pw.println("Country count: "+ countryCount);
        pw.flush();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
//        PreparedStatement statement = connection.prepareStatement("SELECT * FROM test.country where country_name like ?");
//        statement.setString(1, "%"+request.getParameter("name")+"%");
//        ResultSet resultSet = statement.executeQuery();
//
//        while(resultSet.next()){
//            String id = resultSet.getString(1);
//            String name = resultSet.getString(2);
//            String slogan = resultSet.getString(3);
//            pw.println("Country id: "+id+" Country code: "+name +"  Country slogan: "+ slogan);
//            pw.flush();
//        }

        Statement statementStat = connection.createStatement();
        String SQL = "SELECT * FROM test.country where country_name like " + "'Russia'";
        ResultSet resultSetStat = statementStat.executeQuery(SQL);
        while(resultSetStat.next()){
            String idStat = resultSetStat.getString(1);
            String nameStat = resultSetStat.getString(2);
            String sloganStat = resultSetStat.getString(3);
            pw.println("CountryStat id: "+idStat+" CountryStat code: "+nameStat +"  CountryStat slogan: "+ sloganStat+"\n");
            pw.flush();
        }
    }
}
