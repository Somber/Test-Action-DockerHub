package es.somber.apitest5;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {

	@Value("${entorno}")
	private String entorno;
	
	class Result {
		public Result(String message) {
			super();
			this.message = message;
		}

		public String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
		
	}
	
	@GetMapping(value="/test")
	public ResponseEntity<?> index() {
		
		
		return  ResponseEntity.ok(new Result(entorno));
	}
	
}
