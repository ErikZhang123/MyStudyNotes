/*
 * Example JDBC client for University Registration DB
 * Skeleton Java program for COMP9120 S2, 2020, tutorial 7 (October 2020).
 * Make sure you have added an appropriate PostgreSQL JDBC driver library
 */
package JDBCtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.ds.PGSimpleDataSource;

public class JDBCclient {
    // connection parameters - ENTER YOUR LOGIN AND PASSWORD HERE
    private final String userid   = "y21s1c9120_jzha7298";
    private final String passwd   = "500325207";
	private final String myHost	  = "soit-db-pro-2.ucc.usyd.edu.au";

    // instance variable for the database connection   
    private Connection conn = null; 
        
    /**
     * Establishes a connection to the PostgreSQL database.
     * The connection parameters are read from the instance variables above
     * (userid, passwd, and database).
     * @returns  true   on success and then the instance variable 'conn' 
     *                  holds an open connection to the database.
     *           false  otherwise
     */ 
    public boolean connectToDatabase ()
    {
       try 
       {   
           /* connect to the database */
		   PGSimpleDataSource source = new PGSimpleDataSource();
		   source.setServerName(myHost);
		   source.setDatabaseName(userid);
		   source.setUser(userid);
		   source.setPassword(passwd);

           conn = source.getConnection();
           return true;
       }
       catch (SQLException sql_ex) 
       {  
           /* error handling */
           System.out.println(sql_ex);
           return false;
       }
    }
        
    /**
     * open ONE single database connection
     */
    public boolean openConnection ()
    {
        boolean retval = true;
        
        if ( conn != null )
            System.err.println("You are already connected to PostgreSQL server; no second connection is needed!");
        else {
            if ( connectToDatabase() )
                System.out.println("You are successfully connected to PostgreSQL server.");
            else {
                System.out.println("Oops - something went wrong.");
                retval = false;
            }
        }
        
        return retval;
    }

    /**
     * close the database connection again
     */
    public void closeConnection ()
    {
        if ( conn == null )
            System.err.println("You are not connected to PostgreSQL server!");
        else try
        {
             conn.close(); // close the connection again after usage! 
             conn = null;
        }
        catch (SQLException sql_ex) 
        {  /* error handling */
             System.out.println(sql_ex);
        }
    }
    
    

    /**
     * Example Function, Exercise 2:
     * Lists on the screen all course offerings ascending by uos_Code
     * including all semesters when the course is offered.
     *
     * Assumes that we are already connected to the database
     */
    public void listUnits ()
    {
       try
       {
          /* prepare a dynamic query statement */
          PreparedStatement stmt = conn.prepareStatement(
                                    "SELECT uosCode, uosName, credits, semester, year "
                                     + "  FROM UoSOffering JOIN UnitOfStudy USING (uosCode)"
                                     + " ORDER BY uosCode,year,semester");
     
          /* execute the query and loop through the resultset */
          ResultSet rset = stmt.executeQuery(); 
          int nr = 0;
          while ( rset.next() )
          {
             nr++;
             System.out.println(rset.getString("uosCode") 
                                + " - " + rset.getString("uosName") 
                                + " ("  + rset.getInt("credits") 
                                + "cp) "+ rset.getInt("year")
                                + "-"   + rset.getString("semester"));
          }
              
          if ( nr == 0 )
             System.out.println("No entries found.");
                 
          /* clean up! (NOTE this really belongs in a finally{} block) */
          stmt.close();
       }
       catch (SQLException sqle) 
       {  
           /* error handling */
           System.out.println("SQLException : " + sqle);
       }
    }
    
    /**
     * Main program.
     */
    public static void main ( String[] args )
    {
       // create our actual client and test the database connection
       JDBCclient uniDB = new JDBCclient();
      
       if ( uniDB.openConnection() ) {
           uniDB.listUnits();
           uniDB.closeConnection();
        }
    }
}
