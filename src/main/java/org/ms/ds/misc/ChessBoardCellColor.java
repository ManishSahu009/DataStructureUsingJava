package org.ms.ds.misc;

public final class ChessBoardCellColor {
    public boolean isBlack(String field) {
        char[] digs = field.toCharArray();
        return (isOddColumn(digs[0]) && isOddRow(digs[1])) || (isEvenColumn(digs[0]) && isEvenRow(digs[1]));
    }

    public boolean isWhite(String field) {
        return !isBlack(field);
    }

    private boolean isOddColumn(char col) {
        return col == 'A' || col == 'C' || col == 'E' || col == 'G';
    }

    private boolean isEvenColumn(char col) {
        return col == 'B' || col == 'D' || col == 'F' || col == 'H';
    }

    private boolean isOddRow(char row) {
        return row == '1' || row == '3' || row == '5' || row == '7';
    }

    private boolean isEvenRow(char row) {
        return row == '2' || row == '4' || row == '6' || row == '8';
    }

    public static void main(String[] args) {
        ChessBoardCellColor app = new ChessBoardCellColor();
        System.out.println(app.isBlack("A1"));
        System.out.println(app.isBlack("B2"));
        System.out.println(app.isBlack("C3"));
    }
}
