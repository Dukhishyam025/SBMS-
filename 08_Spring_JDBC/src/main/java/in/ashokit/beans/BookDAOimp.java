package in.ashokit.beans;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookDAOimp implements BookDAO {

	private JdbcTemplate jdbcTemplate;
	
	

	public BookDAOimp(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	@Override
	public void saveBook(int bid, String bname, double bprice) {

		String sql = "insert into book values(?,?,?)";
		jdbcTemplate.update(sql, ps	-> {
			 ps.setInt(1, bid);
			 ps.setString(2,bname);
			 ps.setDouble(3, bprice);	
		});
	}

}
