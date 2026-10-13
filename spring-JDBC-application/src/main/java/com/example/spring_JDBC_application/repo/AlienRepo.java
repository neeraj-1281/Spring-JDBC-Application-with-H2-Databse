package com.example.spring_JDBC_application.repo;

import com.example.spring_JDBC_application.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlienRepo {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired   //Setter Injection
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien alien){
        String sql = "insert into alien (id,name,tech) values(?,?,?)";
        int rows = template.update(sql,alien.getId(), alien.getName(), alien.getTech());
        System.out.println(rows+" rows affected");
    }

    public List<Alien> findAll(){
        String sql = "select * from alien";
        List<Alien> aliens = template.query(sql,(rs,r)->{
            Alien a = new Alien();
            a.setId(rs.getInt("id"));
            a.setName(rs.getString("name"));
            a.setTech(rs.getString("tech"));
            return a;
        });
        return aliens;
    }

}
