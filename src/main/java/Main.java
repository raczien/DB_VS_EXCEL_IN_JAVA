
import models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);

        processDataFromDB(logger);

        processDataFromExcel(logger);
    }

    private static void processDataFromDB(Logger logger) {
        logger.warn("Start processing data from DB.");
        long startDbFetchingTime = System.currentTimeMillis();

        List<FilmDetail> filmDetailsFromDb = DataBaseDataLoader.loadData();
        filmDetailsFromDb.forEach(System.out::println);

        logger.info("(DB) Process took %s milliseconds.".formatted(System.currentTimeMillis() - startDbFetchingTime));
    }

    private static void processDataFromExcel(Logger logger) {
        logger.info("Start processing data from Excel.");
        long startExcelFetching = System.currentTimeMillis();

        // Beispiel, wie man eine Excel ausliest und die Daten in ein Java Objekt mapped.
        // Kann adaptiert werden um die verschiedenen Excel Files im "./files" Ordner zu laden.
        List<Language> languages = LanguageExcelReaderExample.readExcelFile("./files/language.xlsx");

        List<FilmDetail> filmDetailsFromExcel = ExcelDataLoader.loadData();
        filmDetailsFromExcel.forEach(System.out::println);

        logger.info("(Excel) Process took %s milliseconds.".formatted(System.currentTimeMillis() - startExcelFetching));
    }
}
