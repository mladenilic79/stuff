package d_external;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;

import b_objectoriented.ObjectClass;

public class JDBC2 {

    // static connection
    static Connection conn;
    
    // complex pulling using method
    public static ArrayList<ObjectClass> selectFromTable() throws SQLException{
        ArrayList<ObjectClass> lista1 = new ArrayList<>();
        String query = "SELECT * FROM ACTOR;";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            // put field number in parameter
            ObjectClass object = new ObjectClass(rs.getInt(1), rs.getString(2));
            lista1.add(object);
        }
        return lista1;
    }
    
    // complex pushing using method
    public static void insertIntoTable(ObjectClass instance)
            throws SQLException{
        ObjectClass oc1 = new ObjectClass(11, "nenad");
        String query = "INSERT INTO ljudi (ime, poeni) "
                + "VALUES ('"+oc1.getVar3()+"', "+oc1.getVar2()+");";
        Statement st = conn.createStatement();
        st.execute(query);
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< basics >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // variables
        String imeBaze = "sakila";
        String url = "jdbc:mysql://localhost:3306/" + imeBaze;
        // for not warning about SSL
        String url2 = "jdbc:mysql://localhost:3306/basicdb?useSSL=false";
        String user = "root";
        String password = "root";
        
        // data
        String tableName = "ljudi";
        String name1 = "cira";
        String name2 = "pera";
        String points = "40";
        String id = "1";

        // registering driver (not needed maybe?)
        Class.forName("com.mysql.jdbc.Driver");
        
        // creating connection
        conn = DriverManager.getConnection(url, user, password);
        if (conn == null) {
            System.out.println("connection failed");
        }

        // set autocommit to true/false
        conn.setAutoCommit(false);
        // create savepoint
        Savepoint firstSavepoint = conn.setSavepoint();
        // rollback to previous commit
//        conn.rollback();
        // rollback to savepoint
        conn.rollback(firstSavepoint);
        // commit all changes
        conn.commit();
        // release savepoint
        conn.releaseSavepoint(firstSavepoint);
        // set autocomit to true again
        conn.setAutoCommit(true);
        
        // basic statement for querying
        Statement st = conn.createStatement();
        // statement for updating through result set and inserting rows
        st = conn.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
        /*
        put only one in brackets of create statement in case of updating
        result set, default no need to be coded
            Resultset.TYPE_FORWARD_ONLY // default, forward only
            ResultSet.TYPE_SCROLL_SENSITIVE, // scrol, sensitive to updates
            ResultSet.TYPE_SCROLL_INSENSITIVE, // scrol, insensitive to updates
        
        put only one in brackets of create statement in case of updating
        result set, default no need to be coded
            ResultSet.CONCUR_READ_ONLY, // default, no-update
            ResultSet.CONCUR_UPDATABLE, // update
         */
        
        /*
        execution (for regular statemens & prepared statements)
        
            for select query, returns result set
                rs = st.executeQuery();
            
            for update, insert & delete, returns int (num of rows affected)
                st.executeUpdate();
        
            for all types of queries, returns boolean
            (true if return is result set, false if its delete, insert, update)
                    st.execute();
        */
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< simple queries & returning keys >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@
        
        // create table
        String query = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "ID INT PRIMARY KEY AUTO_INCREMENT"
                + ", IME VARCHAR(15) NOT NULL"
                + ", POENI SMALLINT"
                + ");";
        st.execute(query);
        
        // insert query
        query = "INSERT INTO ljudi (ime, poeni) "
                + "VALUES ('"+name1+"', "+points+");";
        st.execute(query);
        
        // insert query with returns of last inserted/generated id
        st.execute(query, RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = st.getGeneratedKeys();
        // set cursor to first row.. don't know why?
        generatedKeys.first();
        int lastID = generatedKeys.getInt(1);
        
        // update query
        st.execute("UPDATE ljudi SET IME='"+name2+"', "
                + "POENI="+points+" WHERE ID="+id+";");
        
        // delete query
        st.execute("DELETE FROM ljudi "
                + "WHERE IME='"+name1+"' AND POENI="+points+";");

        // insert query again
        st.execute("INSERT INTO ljudi (ime, poeni) "
                + "VALUES ('"+name1+"', "+points+");");
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< select queries, traversing & updating results >>>>> @@@@@@@@@@@
        
        // select query 1
        query = "SELECT * FROM ljudi;";
        ResultSet rs = st.executeQuery(query);
        
        // cursor navigation
        
        // move cursor to first row
        rs.first(); 
        // gets values from table, parameter is column index or field name
        rs.getInt(1);
        rs.getString(2);
        rs.last();
        rs.next();
        rs.previous();
        rs.beforeFirst();
        rs.afterLast();
        // moves the cursor to the given row number from first
        rs.absolute(2);
        // moves the cursor to the given row number from last
        rs.absolute(-2);
        // moves cursor relative to current position 
        rs.relative(2);
        rs.relative(-2);
        
        // data manipulation
        
        // returns cursor back to current row from insert row
        rs.moveToCurrentRow();
        // position cursor on insert row (special row for constructing records)
        rs.moveToInsertRow();
        // move back to current row again
        rs.moveToCurrentRow();
        
        /*
        update specified values
        (all fields must be added in case of inserting)
        */
        rs.updateInt(4, 1999);
        rs.updateString(2, "kepa");

        // insert values in result set & database
//        rs.insertRow();
        // update values in result set & database
        rs.updateRow();
        
        // delete current row
        rs.deleteRow();

        // select query 2
        query = "SELECT * FROM film WHERE LENGTH=47;";
        rs = st.executeQuery(query);
        
        // looping
        
        while(rs.next()){
            
            // reading (put field name or field id pharentasis in parameter)
            System.out.print(rs.getInt(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getString(3) + " ");
            System.out.println(rs.getInt(4) + " ");
            
            // updating (put field name or field id pharentasis in parameter)
            int i = 1999;
            rs.updateInt(4, i);
            rs.updateRow();
        }
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< complex queries & method queries >>>>> @@@@@@@@@@@@@@@@@@@@@@@@
        
        // complex pushing
        ObjectClass oc1 = new ObjectClass(11, "nenad");
        query = "INSERT INTO ljudi (ime, poeni) "
                + "VALUES ('"+oc1.getVar3()+"', "+oc1.getVar2()+");";
        st.execute(query);
        
        // complex pulling
        ArrayList<ObjectClass> lista1 = new ArrayList<>();
        query = "SELECT * FROM ACTOR;";
        rs = st.executeQuery(query);
        rs.beforeFirst(); // this line is optional??
        while(rs.next()){
            // put field number in parameter
            ObjectClass object = new ObjectClass(rs.getInt(1), rs.getString(2));
            lista1.add(object);
        }
        
        // complex pushing using method
        ObjectClass oc2 = new ObjectClass();
        insertIntoTable(oc2);
        
        // complex pulling using method
        ArrayList<ObjectClass> lista2 = new ArrayList<>();
        lista2 = selectFromTable();
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< prepared & callable statements & batch >>>>> @@@@@@@@@@@@@@@@@@
        
        // prepared statement
        query = "SELECT * FROM ACTOR WHERE ACTOR_ID = ? and first_name = ?;";
        PreparedStatement ps = conn.prepareStatement(query);
        // (placeholder ? num of place/field, value)
        ps.setInt(1, 71);
        ps.setString(2, "ADAM");
        rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getString(3) + " ");
            System.out.println(rs.getDate(4));
        }
        
        /*
        calling for stored procedures (here from sakila)
        for input & output parameters & whole procedure check sql
        */
        CallableStatement cs = conn.prepareCall("{CALL film_in_stock(?,?,?)}");
        // (placeholder position or field name, value)
        cs.setInt(1,1); // input parameter
        cs.setInt(2,1); // input parameter
        cs.setInt(3,5); // register output parameter
        cs.execute();
        System.out.println(cs.getInt(3)); // get output parameter

        // batch (update example) (can be any sql)
        st.addBatch("INSERT INTO ljudi (IME, POENI) VALUES('Amaretto', 49);");
        st.addBatch("INSERT INTO ljudi (IME, POENI) VALUES('Hazelnut', 49);");
        // execute all at the same time, arrays returns index of success
        int[] updateCounts = st.executeBatch();
        // clear batch list
        st.clearBatch();
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< information >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // database getmetadata gives access to various information
        DatabaseMetaData dbmetadata = conn.getMetaData();
        System.out.println(dbmetadata.getDriverName());
        System.out.println(dbmetadata.getDriverVersion());
        System.out.println(dbmetadata.getURL());
        System.out.println(dbmetadata.getUserName());
        
        // resultset metadata gives access to various information
        ResultSetMetaData rsmetadata = rs.getMetaData();
        // get database name from which field are from
        System.out.println("catalog name " + rsmetadata.getCatalogName(1));
        System.out.println("table name " + rsmetadata.getTableName(1));
        System.out.println("column count " + rsmetadata.getColumnCount());
        System.out.println("column name " + rsmetadata.getColumnName(1));
        
        rs.close(); // close resultset
        st.close(); // close statement
        conn.close(); // close connection
    }
}
