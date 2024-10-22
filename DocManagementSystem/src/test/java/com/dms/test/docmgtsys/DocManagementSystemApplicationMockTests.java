package com.dms.test.docmgtsys;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import com.dms.exception.DocumentNotFoundException;
import com.dms.model.Document;
import com.dms.model.DocumentManagementSystem;

public class DocManagementSystemApplicationMockTests {

	@Mock
	Document document1 = new Document(12, "Mathematics", "xyz");
	
	@Mock
	Document document2 = new Document(13, "Mathematics", "xyz");
	
	DocumentManagementSystem documentManagementSystem = new DocumentManagementSystem();
	
	@Test
	public void addDocumentTest() {
		documentManagementSystem.addDocuemnt(document1);
	}
	
	@Test
	public void addDocumentCheckTest() {
		documentManagementSystem.addDocuemnt(document1);
		List<Document> docList = documentManagementSystem.getAllDocuments();
		Document docCheck = new Document();
		for(Document doc: docList) {
			docCheck=doc;
		}
		Assertions.assertEquals(document1,docCheck);
	}
	
	@Test
	public void addDocumentTotalTest() {
		documentManagementSystem.addDocuemnt(document1);
		documentManagementSystem.addDocuemnt(document2);
		List<Document> docList = documentManagementSystem.getAllDocuments();
		Assertions.assertEquals(2, docList.size());
	}
	

	@Test
	public void removeDocumentAvailableTest() throws NullPointerException, DocumentNotFoundException {
		documentManagementSystem.addDocuemnt(document1);
		documentManagementSystem.addDocuemnt(document2);
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
		documentManagementSystem.addDocuemnt(document1);
		DocumentNotFoundException dnfe = assertThrows(DocumentNotFoundException.class, () -> documentManagementSystem.removeDocument(19));
		String actualmsg = dnfe.getMessage();
		String expectedmsg = "Document not available in the Document Management System";
		Assertions.assertTrue(actualmsg.contains(expectedmsg));
		
	}
	
	@Test
	public void searchDocumentAvailableTest() throws NullPointerException, DocumentNotFoundException {
		documentManagementSystem.addDocuemnt(document1);
		documentManagementSystem.addDocuemnt(document2);
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
		documentManagementSystem.addDocuemnt(document1);
		DocumentNotFoundException dnfe = assertThrows(DocumentNotFoundException.class, () -> documentManagementSystem.searchDocuement(19));
		String actualmsg = dnfe.getMessage();
		String expectedmsg = "Document not available in the Document Management System";
		Assertions.assertTrue(actualmsg.contains(expectedmsg));
		
	}
	
}
