package in.ashokit.beans;

import java.util.List;

import in.ashokit.dto.BookDTO;

public interface BookDAO {

	public void saveBook(int bid , String bname , double bprice);
	
	public List<BookDTO> getbooks(); 
}
