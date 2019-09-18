package com.truckdispature.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.truckdispature.dto.Transaction_details;

public class ExcelTransListReportView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		response.setHeader("Content-Disposition", "attachment; filename=\"trans_list.xls\"");


		String truckNumber1=request.getParameter("truckNumber");
		
		
		@SuppressWarnings("unchecked")
		List<Transaction_details> list = (List<Transaction_details>) model.get("transList");

		Sheet sheet = workbook.createSheet("Trans List");

		// Header row
		Row header = sheet.createRow(0);

		header.createCell(0).setCellValue("Trasaction Id");
		header.createCell(1).setCellValue("DateTime");
		header.createCell(2).setCellValue("Advance");
		header.createCell(3).setCellValue("GrossAfterCommission");
		header.createCell(4).setCellValue("Advance Type");
		header.createCell(5).setCellValue("Load Number");

		int rowNum = 1;

		for (Transaction_details trans : list) {

			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(trans.getTransno());
			row.createCell(1).setCellValue(String.valueOf(trans.getDatetime()));
			row.createCell(2).setCellValue(trans.getAdvance());
			row.createCell(3).setCellValue(trans.getGrossaftercommission());
			row.createCell(4).setCellValue(trans.getAdvancetype());
			row.createCell(5).setCellValue(trans.getLoadnumber());

		}

	}

}
