package com.dms.model;

import java.util.ArrayList;
import java.util.List;
import com.dms.exception.DocumentNotFoundException;

public class DocumentManagementSystem {

	private List<Document> documentList;

	public void addDocuemnt(Document document) {
		if (documentList == null) {
			documentList = new ArrayList<>();
		}
		documentList.add(document);
	}

	public List<Document> getAllDocuments() {
		return documentList;
	}

	public boolean removeDocument(int docId) throws NullPointerException, DocumentNotFoundException {
		if (documentList == null) {
			throw new NullPointerException("Document Management System is empty");
		}
		for (Document d : documentList) {
			if (d.getDocId() == docId) {
				return documentList.remove(d);
			}
		}
		throw new DocumentNotFoundException("Document not available in the Document Management System");
	}

	public Document searchDocuement(int docId) throws DocumentNotFoundException {
		if (documentList == null) {
			throw new NullPointerException("Document Management System is empty");
		}
		for (Document d : documentList) {
			if (d.getDocId() == docId) {
				return d;
			}
		}
		throw new DocumentNotFoundException("Document not available in the Document Management System");
	}
}
