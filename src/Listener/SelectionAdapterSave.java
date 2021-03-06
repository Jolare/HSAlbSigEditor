package Listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SelectionAdapterSave extends SelectionAdapter {
	private Shell shell;
	private CTabFolder parent;

	public SelectionAdapterSave(Shell shell, CTabFolder c) {
		this.shell = shell;
		this.parent = c;
	}

	public void widgetSelected(SelectionEvent e) {
		CTabItem item = parent.getSelection();
		Text text = (Text) item.getControl();
		FileDialog fileSave = new FileDialog(shell, SWT.SAVE);
		String fileName = fileSave.open();
		FileIO.write(fileName, text.getText());
		item.setText(fileName);
	}
}
