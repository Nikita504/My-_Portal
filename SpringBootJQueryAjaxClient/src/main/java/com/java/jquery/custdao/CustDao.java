package com.java.jquery.custdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.java.jquery.model.Customer;

@Service
public class CustDao {

	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	

	public int save(Customer p) {

		String sql = "insert into customer(firstname,lastname) values('" + p.getFirstname() + "' ,  '" + p.getLastname()
				+ "' )";
		System.out.println(sql);
		return template.update(sql);
	}

	public int update(Customer p) {
		String sql = "update customer set firstname='" + p.getFirstname() + "',lastname='" + p.getLastname()
				+ "' where employeeId=" + p.getEmployeeId() + "";
		return template.update(sql);
	}

	public boolean delete(int employeeId) {
		String sql = "delete from customer where employeeId=" + employeeId + "";
		int result=template.update(sql);
		if(result==0) {
			return true;
		}else
			return false;
	}

	public List<Customer> getCustomers() {

		return template.query("select * from customer", new RowMapper<Customer>() {

			public Customer mapRow(ResultSet rs, int row) throws SQLException {
				Customer cust = new Customer();
				cust.setEmployeeId(rs.getInt(1));
				cust.setFirstname(rs.getString(2));
				cust.setLastname(rs.getString(3));
				return cust;
			}
		});
	}
}
