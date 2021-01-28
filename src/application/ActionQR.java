package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ActionQR {
	
	private StringProperty colDate = new SimpleStringProperty();
	private StringProperty colWho = new SimpleStringProperty();
	private StringProperty colWhat = new SimpleStringProperty();
	
	public ActionQR(String colDate, String colWho, String colWhat) {
		this.colDate = new SimpleStringProperty(colDate);
		this.colWho = new SimpleStringProperty(colWho);
		this.colWhat = new SimpleStringProperty(colWhat);
	}
	
	public StringProperty colDateProperty() {
		   return colDate;
	}
	
	public StringProperty colWhoProperty() {
		   return colWho;
	}
	
	public StringProperty colWhatProperty() {
		   return colWhat;
	}

}
