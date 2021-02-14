package com.sl.ms.inventorymanagement;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class ProductExceptionController {
   @ExceptionHandler(ProductNotfoundException.class)
   public ResponseEntity<Object> exception(ProductNotfoundException ex, WebRequest request) {
	   List<String> details = new ArrayList<>();
       details.add(ex.getLocalizedMessage());
       ErrorResponse error = new ErrorResponse("Product Not Found", details);
       return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
   }
   
}
