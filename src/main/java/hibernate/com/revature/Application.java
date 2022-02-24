package hibernate.com.revature;

import hibernate.com.revature.model.Director;
import hibernate.com.revature.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        Session session = HibernateUtil.getSession();
        String sql = "Select * from Artist";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        List<Director> directorList = (List<Director>) session.createSQLQuery(sql);
        System.out.println(directorList.size());
    }

}
