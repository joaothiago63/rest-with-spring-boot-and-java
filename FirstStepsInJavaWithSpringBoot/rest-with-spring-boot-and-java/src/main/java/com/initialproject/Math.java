package com.initialproject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.initialproject.converters.NumberConverter;
import com.initialproject.exceptions.UnsupportedMathOperationException;
import com.initialproject.math.SimpleMath;

@RestController
public class Math {

	SimpleMath math = new SimpleMath();
	
	
	@RequestMapping(value = "sum/{numberOne}/{numberTwo}" , method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,@PathVariable (value = "numberTwo")String numberTwo)throws Exception {
		if(!NumberConverter.isANumber(numberOne) ||!NumberConverter.isANumber(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
  		
		return math.sum(NumberConverter.toDouble(numberOne), NumberConverter.toDouble(numberTwo));
	}
	
	@RequestMapping(value = "min/{numberOne}/{numberTwo}" , method = RequestMethod.GET)
	public Double minus(@PathVariable(value = "numberOne") String numberOne,@PathVariable (value = "numberTwo")String numberTwo)throws Exception {
		if(!NumberConverter.isANumber(numberOne) ||!NumberConverter.isANumber(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
  		
		return math.minus(NumberConverter.toDouble(numberOne), NumberConverter.toDouble(numberTwo));
	}
	
	@RequestMapping(value = "mult/{numberOne}/{numberTwo}" , method = RequestMethod.GET)
	public Double mult(@PathVariable(value = "numberOne") String numberOne,@PathVariable (value = "numberTwo")String numberTwo)throws Exception {
		if(!NumberConverter.isANumber(numberOne) ||!NumberConverter.isANumber(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
  		
		return math.mult(NumberConverter.toDouble(numberOne), NumberConverter.toDouble(numberTwo));
	}
	
	@RequestMapping(value = "div/{numberOne}/{numberTwo}" , method = RequestMethod.GET)
	public Double div(@PathVariable(value = "numberOne") String numberOne,@PathVariable (value = "numberTwo")String numberTwo)throws Exception {
		if(!NumberConverter.isANumber(numberOne) ||!NumberConverter.isANumber(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
  		
		return math.div(NumberConverter.toDouble(numberOne), NumberConverter.toDouble(numberTwo));
	}
	
	@RequestMapping(value = "sqrt/{numberOne}" , method = RequestMethod.GET)
	public Double sqrt(@PathVariable(value = "numberOne") String numberOne)throws Exception {
		if(!NumberConverter.isANumber(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value!");
  		
		return math.sqrt(NumberConverter.toDouble(numberOne));
	}
	
	@RequestMapping(value = "media/{numberOne}/{numberTwo}" , method = RequestMethod.GET)
	public Double media(@PathVariable(value = "numberOne") String numberOne,@PathVariable (value = "numberTwo")String numberTwo)throws Exception {
		if(!NumberConverter.isANumber(numberOne) ||!NumberConverter.isANumber(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
  		
		return math.media(NumberConverter.toDouble(numberOne), NumberConverter.toDouble(numberTwo));
	}
	
	
}
