package finki.das.StocksDataWebApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class StocksDataWebAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StocksDataWebAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Specify the path to the Python script
		String pythonScriptPath = "C:\\Users\\Com\\PycharmProjects\\dasDomashno\\scraper.py";

		// Run the Python script using ProcessBuilder
		ProcessBuilder processBuilder = new ProcessBuilder("C:\\Users\\Com\\AppData\\Local\\Microsoft\\WindowsApps\\python.exe", pythonScriptPath);
		processBuilder.redirectErrorStream(true);

		Process process = processBuilder.start();

		// Optional: Capture the output of the script
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		// Wait for the process to finish
		process.waitFor();
	}
}
