package es.somber.apitest5;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

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
		
		
		return  ResponseEntity.ok(new Result("ok"));
	}
	
}
