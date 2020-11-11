module pldAgile {
	requires java.xml;
	requires java.sql;
	requires transitive javafx.graphics;
	requires transitive javafx.fxml;
	requires javafx.controls;
	requires java.base;
	requires com.google.common;
	requires junit;
	requires org.junit.jupiter.api;
	opens vue;
	exports vue;
	exports modele;
	exports controleur;
	opens controleur;
}