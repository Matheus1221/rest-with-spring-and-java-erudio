package br.com.quon.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import br.com.quon.controllers.BookController;
import br.com.quon.data.vo.v1.BookVO;
import br.com.quon.exception.RequireObjectIsNullException;
import br.com.quon.exception.ResourceNotFoundException;
import br.com.quon.mapper.DozerMapper;

import br.com.quon.model.Book;
import br.com.quon.repositories.BookRepository;


@Service
public class BookServices {

	

	
	
	private Logger logger = Logger.getLogger(BookServices.class.getName());


	@Autowired
	BookRepository repository;
	
	@Autowired

	

	
	public List<BookVO> findAll() {
		logger.info("Finding all book!");

		var books = DozerMapper.parseListObjects(repository.findAll(), BookVO.class);  
		books
			.stream()
			.forEach(p -> {
				try {
					p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel());
				} catch (Exception e) {				
					e.printStackTrace();
				}
			});
		return books;
	}
	
	

	public BookVO findById(Long id) {  
		logger.info("Finding one book!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not Records found for this ID!"));
		BookVO  vo =  DozerMapper.parseObject(entity, BookVO.class);
		try {
			vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	
	
	
	
	public BookVO create(BookVO book) {
		
		if(book == null) throw new RequireObjectIsNullException();
		
		logger.info("crating one book!");
		var entity = DozerMapper.parseObject(book, Book.class);
		var vo =  DozerMapper.parseObject(repository.save(entity), BookVO.class);
		try {
			vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public BookVO update(BookVO book) {
		logger.info("updating one book!");
		var entity = repository.findById(book.getKey())
		.orElseThrow(() -> new ResourceNotFoundException("Not Records found for this ID!"));
		
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		var vo =  DozerMapper.parseObject(repository.save(entity), BookVO.class);
		try {
			vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public void  delete(Long id) {
		logger.info("deleting one book!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not Records found for this ID!"));
		
		repository.delete(entity);
	}

}