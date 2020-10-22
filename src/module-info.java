module pldAgile {
	requires java.xml;
	requires java.sql;
	requires transitive javafx.graphics;
	requires transitive javafx.fxml;
	requires javafx.controls;
	requires java.base;
	opens vue;
	exports vue;
	exports modele;
}