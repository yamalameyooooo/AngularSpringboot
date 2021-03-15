package com.example.demo.controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.pojo.ExcelRow;
import com.example.demo.pojo.ReturnBean;


@RestController
@RequestMapping("/excel")
public class ExcelAnalyseController {

	@PostMapping(value = "/upload")
	public ReturnBean analyseExcel(@RequestParam MultipartFile file) throws IOException, ParseException {
		ReturnBean returnBean = new ReturnBean();
		String responseMessage = "";
		BufferedReader br;
		List<String> result = new ArrayList<>();
		String[] resultarr = null;
		List<String> col0 = new ArrayList<>();
		List<String> col1 = new ArrayList<>();
		List<String> col2 = new ArrayList<>();
		List<String> col3 = new ArrayList<>();
		List<String> col4 = new ArrayList<>();
		List<ExcelRow> excelRowList = new ArrayList<>();
		List<ExcelRow> excelRowListFinal = new ArrayList<>();

		// for extra columns define new col ArrayList

		try {
			String line;
			InputStream is = file.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				result.add(line);
				result.add("newLine");
			}
			result.remove(result.size() - 1);
			String res = result.toString().replace("[", "");
			res = res.replace("]", "");
			res = res.replace(" ", "");
			resultarr = res.split(",");
			// *******************************************************//
			for (String i : resultarr) {
				if (i.equals("newLine")) {
					break;
				}
				col0.add(i);

			}

			int col1start = col0.size() + 1;

			// *******************************************************//
			for (int i = col1start; i <= resultarr.length; i++) {
				if (resultarr[i].equals("newLine")) {
					break;
				}
				col1.add(resultarr[i]);

			}

			int col2start = col1start + col1.size() + 1;

			// *******************************************************//

			for (int i = col2start; i <= resultarr.length; i++) {
				if (resultarr[i].equals("newLine")) {
					break;
				}
				col2.add(resultarr[i]);

			}

			int col3start = col2start + col2.size() + 1;

			// *******************************************************//

			for (int i = col3start; i <= resultarr.length; i++) {
				if (resultarr[i].equals("newLine")) {
					break;
				}
				col3.add(resultarr[i]);

			}

			int col4start = col3start + col3.size() + 1;

			// *******************************************************//

			for (int i = col4start; i < resultarr.length; i++) {
				if (resultarr[i].equals("newLine")) {
					break;
				}
				col4.add(resultarr[i]);

			}

			int col5start = col4start + col4.size() + 1;

			// *******************************************************//
			// for extra column paste the above for loop HERE and
			// increment the variable values
			// *******************************************************//

			for (int i = 0; i < col0.size(); i++) {
				ExcelRow excelRowObj = new ExcelRow();
				excelRowObj.setCol0(col0.get(i).replace("\"", ""));
				excelRowObj.setCol1(col1.get(i).replace("\"", ""));
				excelRowObj.setCol2(col2.get(i).replace("\"", ""));
				excelRowObj.setCol3(col3.get(i).replace("\"", ""));
				excelRowObj.setCol4(col4.get(i).replace("\"", ""));
				excelRowList.add(excelRowObj);
			}

			for (ExcelRow i : excelRowList) {
				if (!i.getCol0().contains("Condition/Validity")) {
					excelRowListFinal.add(i);
				}
			}

			// EXCEL FILE CREATION*************************

			XSSFWorkbook workbook = new XSSFWorkbook();

			XSSFSheet sheet = workbook.createSheet();// creating a blank sheet
			int rownum = 0;
			for (ExcelRow i : excelRowListFinal) {
				Row row = sheet.createRow(rownum++);
				createList(i, row);

			}

			FileOutputStream out = new FileOutputStream(new File("D:\\FB_TLA_PM.xlsx")); // file name with path
			workbook.write(out);
			out.close();

			responseMessage = "Yayy!! Your file is converted successfully & is downloaded to D:/ automatically with name: FB_TLA_PM.xlsx";
			returnBean.setMessage(responseMessage);
			returnBean.setStatus("Success");
		} catch (Exception e) {
			e.printStackTrace();
			responseMessage = "Duhhh!! It seems there is some kind of error happening in the poorly written server logic. Please head to Contact section.";
			returnBean.setMessage(responseMessage);
			returnBean.setStatus("Failure");
		}
		return returnBean;
	}

	private static void createList(ExcelRow i, Row row) // creating cells for each row
	{
		Cell cell = row.createCell(0);
		cell.setCellValue(i.getCol0());

		cell = row.createCell(1);
		cell.setCellValue(i.getCol1());

		cell = row.createCell(2);
		cell.setCellValue(i.getCol2());

		cell = row.createCell(3);
		cell.setCellValue(i.getCol3());

		cell = row.createCell(4);
		cell.setCellValue(i.getCol4());

	}

}
