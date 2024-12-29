package finki.das.StocksDataWebApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PythonScriptController {

    private final RestTemplate restTemplate;

    public PythonScriptController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/run-python-script")
    public String runPythonScript() {
        try {
            // Assuming your Python service is running on localhost:5000
            String url = "http://localhost:5000/run-script";
            String response = restTemplate.getForObject(url, String.class);
            return "Python script response: " + response;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error invoking Python script: " + e.getMessage();
        }
    }
}
