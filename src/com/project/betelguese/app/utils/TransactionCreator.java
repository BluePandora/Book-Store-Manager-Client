package com.project.betelguese.app.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import javafx.collections.ObservableList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.project.betelguese.app.item.TransactionItem;
import com.project.betelguese.utils.items.Transaction;

public class TransactionCreator {

	private Font titleFont;
	private Font addressFont;
	private Font firstFont;
	private Font secondFont;
	private Font boldBlueFont;
	private Font darkFont;
	private PdfWriter writer;
	private Document document;
	private Transaction transaction;

	private ObservableList<TransactionItem> transactionData;

	public TransactionCreator(String transactionName, Transaction transaction)
			throws DocumentException, IOException {
		createFont();
		document = new Document();
		addmetaData();
		writer = PdfWriter.getInstance(document, new FileOutputStream(
				"D:\\transaction\\" + transactionName + ".pdf"));
		this.transaction = transaction;
	}

	private void createFont() throws DocumentException, IOException {
		titleFont = new Font(BaseFont.createFont(
				"C:\\windows\\fonts\\Silent Reaction.ttf", BaseFont.IDENTITY_H,
				BaseFont.NOT_EMBEDDED), 30, Font.NORMAL, BaseColor.BLUE);
		addressFont = new Font(BaseFont.createFont(
				"C:\\windows\\fonts\\MuseoSansRounded-700.otf",
				BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED), 10, Font.NORMAL,
				BaseColor.DARK_GRAY);
		firstFont = new Font(BaseFont.createFont(
				"C:\\windows\\fonts\\MuseoSansRounded-700.otf",
				BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED), 12, Font.NORMAL,
				BaseColor.BLACK);
		secondFont = new Font(BaseFont.createFont(
				"C:\\windows\\fonts\\MuseoSansRounded-300.otf",
				BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED), 12, Font.NORMAL,
				BaseColor.BLUE);
		boldBlueFont = new Font(BaseFont.createFont(
				"C:\\windows\\fonts\\MuseoSansRounded-300.otf",
				BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED), 12, Font.BOLD,
				BaseColor.BLUE);
		darkFont = new Font(BaseFont.createFont(
				"C:\\windows\\fonts\\MuseoSansRounded-300.otf",
				BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED), 12, Font.NORMAL,
				BaseColor.DARK_GRAY);
	}

	private void createNewPage() throws MalformedURLException, IOException,
			DocumentException {
		document.newPage();
		addimage();
		addtitlePage();
		addUserInfo();
		addTransactionTitle();
	}

	public void createTransaction() throws DocumentException,
			MalformedURLException, IOException {
		createNewPage();
		addTransaction(1);
		addTransaction(2);
		addTotal();
	}

	public void createTransaction(
			ObservableList<TransactionItem> transactionData) {
		this.transactionData = transactionData;
		for (int i = 0; i < transactionData.size(); i++) {
			if (i % 10 == 0) {
				try {
					createNewPage();
				} catch (IOException | DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				addTransaction(transactionData.get(i), i);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			addTotal();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addTransaction(TransactionItem transactionItem, int position)
			throws DocumentException {
		Chunk header = new Chunk();
		header.setFont(darkFont);
		header.append("#  " + transactionItem.getBooksName().getValue());// 318.816
		header.append(dummyLines(header.getWidthPoint(), 1));
		header.append(transactionItem.getBooksStock().getValue());// 399.12003
		header.append(dummyLines(header.getWidthPoint(), 2));
		header.append(transactionItem.getBooksPrice().getValue());// 468.85205
		header.append(dummyLines(header.getWidthPoint(), 3));
		header.append(transactionItem.getTotalPaid().getValue());// 513.38403
		header.append(dummyLines(header.getWidthPoint(), 4));
		header.append(newLine());
		header.append(newLine());
		if (position == transactionData.size() - 1) {
			document.add(header);
			header = new Chunk();
			header.setFont(firstFont);
			header.append(dummyLines('=', 70));
			document.add(header);
		} else {
			header.append(newLine());
			document.add(header);

		}

	}

	private void addTotal() throws DocumentException {
		Paragraph paragraph = new Paragraph();
		paragraph.setFont(firstFont);
		paragraph.add(new Chunk("Paid:          "));
		paragraph.setFont(secondFont);
		int sum = 0;
		int item = 0;
		for (int i = 0; i < transactionData.size(); i++) {
			item += Integer.parseInt(transactionData.get(i).getBooksStock()
					.getValue());
			sum += Integer.parseInt(transactionData.get(i).getTotalPaid()
					.getValue());
		}
		paragraph.add(new Chunk(Integer.toString(sum)));
		paragraph.add(new Chunk(dummyLines(' ', 55)));
		paragraph.setFont(firstFont);
		paragraph.add(new Chunk("Total Item: "));
		paragraph.setFont(secondFont);
		paragraph.add(new Chunk(Integer.toString(item)));

		paragraph.add(new Chunk(dummyLines(' ', 30)));
		paragraph.setFont(firstFont);
		paragraph.add(new Chunk("SubTotal: "));
		paragraph.setFont(secondFont);
		paragraph.add(new Chunk(Integer.toString(sum)));

		paragraph.add(newLine());
		paragraph.setFont(firstFont);
		paragraph.add(new Chunk("Change:        "));
		paragraph.setFont(secondFont);
		paragraph.add(new Chunk("0"));

		document.add(paragraph);
	}

	private void addTransactionTitle() throws DocumentException {
		Paragraph divider = new Paragraph();
		divider.setFont(firstFont);
		divider.add(newLine());
		divider.add(dummyLines('-', 104));
		Chunk header = new Chunk();
		header.setFont(firstFont);
		header.append("Description");// 318.816
		header.append(dummyLines(header.getWidthPoint(), 1));
		header.append("Qty");// 399.12003
		header.append(dummyLines(header.getWidthPoint(), 2));
		header.append("Rate");// 468.85205
		header.append(dummyLines(header.getWidthPoint(), 3));
		header.append("Amount");// 513.38403
		header.append(dummyLines(header.getWidthPoint(), 4));
		divider.add(header);
		divider.add(newLine());
		divider.add(dummyLines('-', 104));
		divider.add(newLine());
		document.add(divider);
	}

	private void addTransaction(int i) throws DocumentException {
		Chunk header = new Chunk();
		header.setFont(darkFont);
		header.append("#  Himur Ache Jol");// 318.816
		header.append(dummyLines(header.getWidthPoint(), 1));
		header.append("2");// 399.12003
		header.append(dummyLines(header.getWidthPoint(), 2));
		header.append("120");// 468.85205
		header.append(dummyLines(header.getWidthPoint(), 3));
		header.append("240");// 513.38403
		header.append(dummyLines(header.getWidthPoint(), 4));
		header.append(newLine());
		header.append(newLine());
		document.add(header);
		header = new Chunk();
		header.setFont(darkFont);
		header.append("#  Holud Himu Kalo RAB");// 318.816
		header.append(dummyLines(header.getWidthPoint(), 1));
		header.append("8");// 399.12003
		header.append(dummyLines(header.getWidthPoint(), 2));
		header.append("150");// 468.85205
		header.append(dummyLines(header.getWidthPoint(), 3));
		header.append("1200");// 513.38403
		header.append(dummyLines(header.getWidthPoint(), 4));
		header.append(newLine());
		if (i == 2) {
			document.add(header);
			header = new Chunk();
			header.setFont(firstFont);
			header.append(dummyLines('=', 70));
			document.add(header);
		} else {
			header.append(newLine());
			document.add(header);

		}

	}

	private String newLine() {
		return "\n";

	}

	private String dummyLines(char divider, int count) {
		String dividerString = "";
		for (int i = 0; i < count; i++) {
			dividerString += divider;
		}
		return dividerString;
	}

	private String dummyLines(float widthPoint, int flag) {
		final long count;
		if (flag == 1) {
			count = Math.round((318.816 - widthPoint) / 3f);
		} else if (flag == 2) {
			count = Math.round((399.12003 - widthPoint) / 3f);
		} else if (flag == 3) {
			count = Math.round((468.85205 - widthPoint) / 3f);
		} else if (flag == 4) {
			count = Math.round((513.38403 - widthPoint) / 3f);
		} else {
			count = 0;
		}
		String dividerString = "";
		for (int i = 0; i < count; i++) {
			dividerString += ' ';
		}
		return dividerString;
	}

	private void addimage() throws MalformedURLException, IOException,
			DocumentException {
		Image image = Image
				.getInstance("G:\\work/Book Store Manager(FX)/src/com/project/betelguese/assets/css/flat_book_icon.png");
		image.setScaleToFitLineWhenOverflow(true);
		image.setScaleToFitHeight(true);
		// image.scalePercent(40);
		image.scaleAbsolute(image.getWidth() / 2, image.getHeight() / 2);
		image.setAbsolutePosition(35, 760);
		// image.setRotationDegrees(90);
		document.add(image);
	}

	private void addtitlePage() throws DocumentException {
		Paragraph storeName = new Paragraph();
		storeName.setFont(titleFont);
		storeName.setAlignment(Paragraph.ALIGN_CENTER);
		storeName.add("Shahjalal Book Store");
		document.add(storeName);
		Paragraph divider = new Paragraph(dummyLines('_', 78));
		Paragraph storeAddress = new Paragraph();
		storeAddress.setFont(addressFont);
		storeAddress.setAlignment(Paragraph.ALIGN_CENTER);
		storeAddress
				.add("Address:106/7D Monipuripara,Tejgaon Dhaka-1215.\nTel:+8801680842208");
		document.add(storeAddress);
		document.add(divider);

	}

	private void addUserInfo() throws DocumentException, IOException {
		PdfContentByte pdfContentByte = writer.getDirectContent();
		Barcode128 barcode128 = new Barcode128();
		barcode128.setCode(transaction.getTransactionId());
		barcode128.setStartStopText(false);
		Image image39 = barcode128.createImageWithBarcode(pdfContentByte, null,
				null);
		Paragraph firstLine = new Paragraph();
		firstLine.setFont(firstFont);
		firstLine.add(newLine());
		firstLine.add("Transaction ID: ");
		firstLine.add(dummyLines(' ', 80));
		addDetail(firstLine, "Created Date:", transaction.getCreatedTime());
		firstLine.add(newLine());
		firstLine.add(dummyLines(' ', 109));
		addDetail(firstLine, "Operator:", transaction.getAdminName());
		document.add(firstLine);
		image39.setAbsolutePosition(130, 690);
		document.add(image39);
		createBox(pdfContentByte);
		document.add(addDetail("Contact Name:", transaction.getCustomerName(),
				true));
		document.add(addDetail("Contact Number:",
				transaction.getCustomerNumber(), false));
	}

	private Element addDetail(String header, String detail, boolean needNewLine) {
		Paragraph paragraph = new Paragraph();
		paragraph.setFont(firstFont);
		if (needNewLine) {
			paragraph.add(newLine());
		}
		paragraph.add(header + " ");
		paragraph.setFont(secondFont);
		paragraph.add(detail);
		return paragraph;
	}

	private void addDetail(Paragraph paragraph, String header, String detail) {
		paragraph.setFont(firstFont);
		paragraph.add(header + " ");
		paragraph.setFont(secondFont);
		paragraph.add(detail);
	}

	public void open() {
		document.open();
	}

	public void close() {
		document.close();
	}

	private void createBox(PdfContentByte pdfContentByte) {
		pdfContentByte.saveState();
		pdfContentByte.setColorStroke(BaseColor.BLACK);
		pdfContentByte.rectangle(20, 630, 550, 100);
		pdfContentByte.stroke();
		pdfContentByte.restoreState();
	}

	private void addmetaData() {
		document.addTitle("Testing...");
		document.addKeywords("Testing...");
		document.addAuthor("Book Store Manager.");
		document.addCreator(System.getProperty("user.name"));
	}

}
