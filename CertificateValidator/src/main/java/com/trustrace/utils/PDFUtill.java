package com.trustrace.utils;

import java.io.IOException;
import java.io.InputStream;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public final class PDFUtill {

	public static String read(InputStream inputStream) throws IOException {

		PdfReader reader;
		reader = new PdfReader(inputStream, null);
		String textFromPage = PdfTextExtractor.getTextFromPage(reader, 1);
		reader.close();
		return textFromPage;

	}

}
