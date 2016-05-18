package com.garpo.i0007n.controll;

import com.garpo.i0007n.model.Comment;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Anna
 */
public class CommentTableModel extends AbstractTableModel {
    Controller controller = Controller.getController();
    private List<Comment> commentList;
    private String[] colNames = {"Kommentar", "Datum", "Användare"};
    private int rows;

    public void setData(List<Comment> commentList){
        this.commentList = commentList;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getRowCount() {
        if (commentList.isEmpty() != true){
            rows = commentList.size();
        }
        else{
            rows = 0;
        }
        return rows;
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Comment comment = commentList.get(rowIndex);
        switch (columnIndex){
            case 0:
                return comment.getText();
            case 1:
                return comment.getUpdated(); //Ger användarID. Kan ändras att ge användarens namn istället.
            case 2:
                return comment.getUpdatedBy();
        }
        return null;
    }
}
