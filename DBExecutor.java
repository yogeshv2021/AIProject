import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBExecutor{


    private final String url = "jdbc:postgresql://postgres/cpaas_lyca_ireland";
    private final String user = "root";
    private final String password = "root123";
    public static String fname = null;

    Connection conn;
    PreparedStatement prst;
    ResultSet getqueryoutput;
    int getoutput;
    static String Query ="Select *from response";

    public void DbMethodCreateQuery(String Query){
       try{
          Class.forName("org.postgresql.Driver");
          conn = DriverManager.getConnection(url,user,password);
          prst = conn.prepareStatement(Query);
          System.out.println("Connection to database is successfull");
          getoutput = prst.executeUpdate();
          return getoutput;
         }
      }
      catch(SQLException| ClassNotFoundException e){
              System.out.println("Exception occured" + e);
      }
      finally{
        try{
          if (conn !=null) {
            conn.close();
          }
          if (prst!=null) {
             prst.close();
          }
        }
        catch (SQLException e){
              System.out.println("Exception occured" + e);
        }
      }
    }

    public void DbMethodDeleteQuery(String Query){
       try{
          Class.forName("org.postgresql.Driver");
          conn = DriverManager.getConnection(url,user,password);
          prst = conn.prepareStatement(Query);
          System.out.println("Connection to database is successfull");
          getqueryoutput = prst.executeUpdate();
          return getqueryoutput;

         }
      }
      catch(SQLException| ClassNotFoundException e){
              System.out.println("Exception occured" + e);
      }
      finally{
        try{
          if (conn !=null) {conn.close();};
          if (prst!=null) {prst.close();}; 
        }
        catch (SQLException e){
              System.out.println("Exception occured" + e);
        }
      }
    }

    public void DbMethodUpdateQuery(String Query){
       try{
          Class.forName("org.postgresql.Driver");
          conn = DriverManager.getConnection(url,user,password);
          prst = conn.prepareStatement(Query);
          System.out.println("Connection to database is successfull");
          getoutput = prst.executeUpdate();
   
          return getoutput;
      }
      catch(SQLException| ClassNotFoundException e){
              System.out.println("Exception occured" + e);
      }
      finally{
        try{
          if (conn !=null) {conn.close();};
          if (prst!=null) {prst.close();}; 
        }
        catch (SQLException e){
              System.out.println("Exception occured" + e);
        }
      }
    }

    public void DbMethodSelectQuery(String Query){
       try{
          Class.forName("org.postgresql.Driver");
          conn = DriverManager.getConnection(url,user,password);
          prst = conn.prepareStatement(Query);
          System.out.println("Connection to database is successfull");
          getqueryoutput = prst.executeQuery();
   
          while (getqueryoutput.next()){
              return getqueryoutput.getString("response_body");
         }
      }
      catch(SQLException| ClassNotFoundException e){
              System.out.println("Exception occured" + e);
      }
      finally{
        try{
          if (conn !=null) {conn.close();};
          if (prst!=null) {prst.close();}; 
        }
        catch (SQLException e){
              System.out.println("Exception occured" + e);
        }
      }
    }

    public static void main(String[] args){
         DBExecutor d1 = new DBExecutor();
         d1.DbMethodCreateQuery(Query);

    }
}
