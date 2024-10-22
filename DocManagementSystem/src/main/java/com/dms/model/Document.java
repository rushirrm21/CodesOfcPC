package com.dms.model;

public class Document {

	private int docId;
	private String docTitle;
	private String docContent;
	public Document() {
		super();
	}
	public Document(int docId, String docTitle, String docContent) {
		super();
		this.docId = docId;
		this.docTitle = docTitle;
		this.docContent = docContent;
	}
	public int getDocId() {
		return docId;
	}
}
