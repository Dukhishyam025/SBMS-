package in.ashokit.beans;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import in.ashokit.dto.BookDTO;
import in.ashokit.rowmapper.BookRowMapper;

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


 
	@Override
	public List<BookDTO> getbooks() {
		
		String sql ="select * from book";
		
		List<BookDTO> books = jdbcTemplate.query(sql, new BookRowMapper());
		
		return books;
		
	}
	
	
	

}
