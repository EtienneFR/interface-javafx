package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ActionQC {

	private StringProperty colDate2 = new SimpleStringProperty();
	private StringProperty colWho2 = new SimpleStringProperty();
	private StringProperty colWhat2 = new SimpleStringProperty();
	
	public ActionQC(String colDate2, String colWho2, String colWhat2) {
		this.colDate2 = new SimpleStringProperty(colDate2);
		this.colWho2 = new SimpleStringProperty(colWho2);
		this.colWhat2 = new SimpleStringProperty(colWhat2);
	}
	
	public StringProperty colDate2Property() {
		   return colDate2;
	}
	
	public StringProperty colWho2Property() {
		   return colWho2;
	}
	
	public StringProperty colWhat2Property() {
		   return colWhat2;
	}
	
}
