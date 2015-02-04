package org.magland.jcommon;

import java.net.HttpURLConnection;
import java.net.URL;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author magland
 */
public class JUtils {

	static public String getFileSuffix(String path) {
		int ind = path.lastIndexOf(".");
		if (ind < 0) {
			return "";
		}
		return path.substring(ind + 1);
	}
	
	static public String getFileName(String path) {
		int ind=path.lastIndexOf("/");
		if (ind<0) return path;
		return path.substring(ind+1);
	}
	
	static public String getFilePath(String path) {
		int ind=path.lastIndexOf("/");
		if (ind<0) return "";
		return path.substring(0,ind);
	}
	
	static public String appendPaths(String path1,String path2) {
		if (path1.isEmpty()) return path2;
		if (path2.isEmpty()) return path1;
		return path1+"/"+path2;
	}
	
	static public void showInformation(String title,String message) {
		Dialogs.create()
			.owner(null)
			.title(title)
			.masthead(null)
			.message(message)
			.showInformation();
	}
	
	static public void showWarning(String title,String message) {
		Dialogs.create()
			.owner(null)
			.title(title)
			.masthead(null)
			.message(message)
			.showWarning();
	}
	
	static public Boolean connectedToInternet() {
		try {
			try{
				URL url=new URL("http://www.google.com");
				HttpURLConnection con=(HttpURLConnection)url.openConnection();
				con.connect();
				if (con.getResponseCode()==200) {
					return true;
				}
				else return false;
			}
			catch(Exception ee) {
				return false;
			}
		}
		catch (Exception ee) {
			return false;
		}
	}
	
	static public Stage popupWidget(Node W,String title) {
		VBox root = new VBox();
		root.getChildren().addAll(W);

		Scene scene = new Scene(root, 300, 300);
		
		Stage stage=new Stage();

		stage.setTitle(title);
		stage.setScene(scene);
		stage.show();
		
		return stage;
	}
}