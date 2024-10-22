package com.dms.test.docmgtsys;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.dms.exception.DocumentNotFoundException;
import com.dms.model.Document;
import com.dms.model.DocumentManagementSystem;

public class DocumentManagementSystemTest {

	DocumentManagementSystem documentManagementSystem = new DocumentManagementSystem();

	@Test
	public void addDocumentTest() {
		Document document = new Document(12, "Mathematics", "xyz");
		documentManagementSystem.addDocuemnt(document);
	}
	
	@Test
	public void addDocumentCheckTest() {
		Document document = new Document(12, "Mathematics", "xyz");
		documentManagementSystem.addDocuemnt(document);
		List<Document> docList = documentManagementSystem.getAllDocuments();
		Document docCheck = new Document();
		for(Document doc: docList) {
			docCheck=doc;
		}
		Assertions.assertEquals(document,docCheck);
	}
	
	@Test
	public void addDocumentTotalTest() {
		Document document1 = new Document(12, "Mathematics", "xyz");
		Document document2 = new Document(13, "Mathematics", "xyz");
		Document document3 = new Document(14, "Mathematics", "xyz");
		documentManagementSystem.addDocuemnt(document1);
		documentManagementSystem.addDocuemnt(document2);
		documentManagementSystem.addDocuemnt(document3);
		List<Document> docList = documentManagementSystem.getAllDocuments();
		Assertions.assertEquals(3, docList.size());
	}
	

	@Test
	public void removeDocumentAvailableTest() throws NullPointerException, DocumentNotFoundException {
		Document document1 = new Document(12, "Mathematics", "xyz");
		Document document2 = new Document(13, "Mathematics", "xyz");
		Document document3 = new Document(14, "Mathematics", "xyz");
		documentManagementSystem.addDocuemnt(document1);
		documentManagementSystem.addDocuemnt(document2);
		documentManagementSystem.addDocuemnt(document3);
		boolean result = documentManagementSystem.removeDocument(12);
		Assertions.assertTrue(result);
	}
	
	@Test
	public void removeDocumentNotAvailableTest()throws NullPointerException, DocumentNotFoundException {	
		NullPointerException ex = assertThrows(NullPointerException.class, () -> documentManagementSystem.removeDocument(12));
		String actualmsg = ex.getMessage();
		String expectedmsg = "Document Management System is empty";
		Assertions.assertTrue(actualmsg.contains(expectedmsg));
		
	}
	
	@Test
	public void removeDocumentNotFoundTest()throws NullPointerException, DocumentNotFoundException {	
		Document document1 = new Document(12, "Mathematics", "xyz");
		documentManagementSystem.addDocuemnt(document1);
		DocumentNotFoundException dnfe = assertThrows(DocumentNotFoundException.class, () -> documentManagementSystem.removeDocument(19));
		String actualmsg = dnfe.getMessage();
		String expectedmsg = "Document not available in the Document Management System";
		Assertions.assertTrue(actualmsg.contains(expectedmsg));
		
	}
	
	@Test
	public void searchDocumentAvailableTest() throws NullPointerException, DocumentNotFoundException {
		Document document1 = new Document(12, "Mathematics", "xyz");
		Document document2 = new Document(13, "Mathematics", "xyz");
		Document document3 = new Document(14, "Mathematics", "xyz");
		documentManagementSystem.addDocuemnt(document1);
		documentManagementSystem.addDocuemnt(document2);
		documentManagementSystem.addDocuemnt(document3);
		Assertions.assertEquals(document1,documentManagementSystem.searchDocuement(12));
	}
	
	@Test
	public void searchDocumentNotAvailableTest()throws NullPointerException, DocumentNotFoundException {	
		NullPointerException ex = assertThrows(NullPointerException.class, () -> documentManagementSystem.searchDocuement(12));
		String actualmsg = ex.getMessage();
		String expectedmsg = "Document Management System is empty";
		Assertions.assertTrue(actualmsg.contains(expectedmsg));
		
	}
	
	@Test
	public void searchDocumentNotFoundTest()throws NullPointerException, DocumentNotFoundException {	
		Document document1 = new Document(12, "Mathematics", "xyz");
		documentManagementSystem.addDocuemnt(document1);
		DocumentNotFoundException dnfe = assertThrows(DocumentNotFoundException.class, () -> documentManagementSystem.searchDocuement(19));
		String actualmsg = dnfe.getMessage();
		String expectedmsg = "Document not available in the Document Management System";
		Assertions.assertTrue(actualmsg.contains(expectedmsg));
		
	}
}
