package models;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.MappingUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LanguageExcelReaderExample {

    public static List<Language> readExcelFile(String filePath) {
        List<Language> languages = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row currentRow : sheet) {
                if (currentRow.getRowNum() == 0) {
                    continue;
                }

                long languageId = 0;
                String name = "";
                LocalDateTime lastUpdate = null;

                for (Cell currentCell : currentRow) {
                    int columnIndex = currentCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0 -> languageId = (long) currentCell.getNumericCellValue();
                        case 1 -> name = currentCell.getStringCellValue().trim();
                        case 2 -> lastUpdate = MappingUtils.convertToLocalDateTime(currentCell.getStringCellValue());
                    }
                }
                languages.add(new Language(languageId, name, lastUpdate));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return languages;
    }

}
