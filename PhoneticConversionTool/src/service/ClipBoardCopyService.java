package service;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ClipBoardCopyService {
	
	public void copyToClipBoard(String convertedValue) {
		
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection strsel = new StringSelection(convertedValue);
		clip.setContents(strsel, strsel);
	}

}
