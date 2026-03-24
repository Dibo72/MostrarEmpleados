package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MostrarEmpleados {
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword());
            Statement stmt =conn.createStatement()){

            String sql = "SELECT empleado.nombre as empleado, departamento.nombre as departamento " +
                            "FROM empleado JOIN departamento ON departamento_id = departamento.id";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String empleado = rs.getString("empleado");
                String departamento = rs.getString("departamento");
                System.out.println(empleado + " " + departamento);
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}