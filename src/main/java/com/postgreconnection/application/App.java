package com.postgreconnection.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.function.Function;

public class App 
{
    public static void main( String[] args )
    {
        Connection connect = null;

        try
        {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste_db", "postgres", "root");
            
            Function<Connection, String> isConnected = cnnct -> cnnct != null ? "Connected" : "Connect fail";
            System.out.println(isConnected.apply(connect));
        }

        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}