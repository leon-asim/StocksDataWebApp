package finki.das.StocksDataWebApp.controller;

import finki.das.StocksDataWebApp.service.CsvFileService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private final CsvFileService csvFileService;

    public FileController(CsvFileService csvFileService) {
        this.csvFileService = csvFileService;
    }

    @GetMapping("/process-folder")
    public String processFolder(/*@RequestParam String folderPath*/) {
        try {
            csvFileService.saveAllFromFolder("C:\\Users\\Com\\PycharmProjects\\dasDomashno\\Fetched_Files");
            return "Files processed successfully.";
        } catch (IOException e) {
            return "Error processing files: " + e.getMessage();
        }
    }
}

