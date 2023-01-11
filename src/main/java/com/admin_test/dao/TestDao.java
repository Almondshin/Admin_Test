package com.admin_test.dao;

import com.admin_test.vo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void add(Test test) {
        String sql = "insert into fundlist (fundname, contents, reword) values (?, ? , ?)";
        jdbcTemplate.update(sql, test.getFundname(),test.getContents(), test.getReword());
    }

}
