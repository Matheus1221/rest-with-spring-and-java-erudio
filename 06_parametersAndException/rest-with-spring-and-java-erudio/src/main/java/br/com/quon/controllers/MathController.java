package br.com.quon.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.quon.exception.UnsupportedMathOperationException;
import br.com.quon.utils.MathUtils;



@RestController
public class MathController {
	
	
	private final AtomicLong counter = new AtomicLong();
	
	private final MathUtils mathUtils = new MathUtils();
	
	
	

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable (value = "numberOne") String numberOne,
			@PathVariable (value = "numberTwo") String numberTwo
			
			) throws Exception {
		
			
		if (!mathUtils.isNumeric(numberOne) || !mathUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
			}
		return mathUtils.convertToDouble(numberOne) + mathUtils.convertToDouble(numberTwo);
	}
	
	@GetMapping("/sub/{numberOne}/{numberTwo}")
	public Double sub(
			@PathVariable (value = "numberOne") String numberOne,
			@PathVariable (value = "numberTwo") String numberTwo
			
			) throws Exception {
		
			
		if (!mathUtils.isNumeric(numberOne) || !mathUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
			}
		return mathUtils.convertToDouble(numberOne) - mathUtils.convertToDouble(numberTwo);
	}
	
	
	@GetMapping("/div/{numberOne}/{numberTwo}")
	public Double div(
			@PathVariable (value = "numberOne")String numberOne,
			@PathVariable (value = "numberTwo")String numberTwo
		
			) throws Exception{
					
		if(!mathUtils.isNumeric(numberOne) || !mathUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return mathUtils.convertToDouble(numberOne) / mathUtils.convertToDouble(numberTwo);
	}


	@GetMapping("/mult/{numberOne}/{numberTwo}")
	public Double mult(
			@PathVariable (value = "numberOne")String numberOne,
			@PathVariable (value = "numberTwo")String numberTwo
		
			) throws Exception{
					
		if(!mathUtils.isNumeric(numberOne) || !mathUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return mathUtils.convertToDouble(numberOne) * mathUtils.convertToDouble(numberTwo);
	}
	
	@GetMapping("/media/{numberOne}/{numberTwo}")
	public Double media(
			@PathVariable (value = "numberOne")String numberOne,
			@PathVariable (value = "numberTwo")String numberTwo
		
			) throws Exception{
					
		if(!mathUtils.isNumeric(numberOne) || !mathUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		double sumNumber= mathUtils.convertToDouble(numberOne) + mathUtils.convertToDouble(numberTwo);
		
		double media = sumNumber / 2;
		
		return media;
	}

	

	@GetMapping("/raiz/{numberOne}/{numberTwo}")
	public Double raizQ(
			@PathVariable (value = "numberOne")String numberOne,
			@PathVariable (value = "numberTwo")String numberTwo
		
			) throws Exception{
					
		if(!mathUtils.isNumeric(numberOne) || !mathUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		double sumRaiz = mathUtils.convertToDouble(numberOne) + mathUtils.convertToDouble(numberTwo);
		
		double raiz = Math.sqrt(sumRaiz);
		
		return raiz;
	}

	


	
}
