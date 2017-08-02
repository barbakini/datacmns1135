package datacmns1135;


import datacmns1135.repository.MainDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Datacmns1135Application implements CommandLineRunner {

	@Autowired
	private MainDocumentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Datacmns1135Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

	}
}
