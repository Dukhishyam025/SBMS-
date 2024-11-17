package in.ashokit.beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import in.ashokit.dto.BookDTO;
import in.ashokit.generator.ExcelGenerator;

public class BookService {
	
	private BookDAO bookdao;
	
	private ExcelGenerator excelGenerator;

	public BookService(BookDAO bookdao , ExcelGenerator excelGenerator) {
		this.bookdao = bookdao;
		this.excelGenerator = excelGenerator;
	}
	
	public void getBooks() throws Exception
	{
		List<BookDTO> books =bookdao.getbooks();
		
		excelGenerator.generateExcel(books);
		
		books.forEach(System.out::println);
	}



	public void bookService()throws Exception
	{
		File file = new File("book.txt");
		FileReader fileReader = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fileReader);
		
		String line = br.readLine();
	    
		while(line !=null)
		{
		     String[] data = line.split(",");
		     Integer bid = Integer.parseInt(data[0]);
		     String bname = data[1];
		     Double bprice = Double.parseDouble(data[2]);
		     
		     bookdao.saveBook(bid,bname,bprice);
		     
			line=br.readLine();
		}
		
		System.out.println("Book record inserted into DB successfully.... ");
		
		br.close();
	}
}
