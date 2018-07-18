package com.example.plane;

public class Solution {

    private final String ROW_LETTERS = "ABCDEFGHJK";

    public int solution(int numberOfRows, String bookedSeats) {
        boolean[][] allSeats = new boolean[numberOfRows][10];
        bookSeats(bookedSeats, allSeats);

        return getBlocks(allSeats);
    }

    private void bookSeats(String bookedSeats, boolean[][] allSeats) {
        String[] bookedSeatsArray;

        if (bookedSeats.length() > 0) {
            bookedSeatsArray = bookedSeats.split(" ");
            for (String bookedSeat : bookedSeatsArray) bookedSeat(bookedSeat, allSeats);
        }
    }

    private void bookedSeat(String bookedSeat, boolean[][] allSeats) {
        String rowNumberAsString = bookedSeat.substring(0, bookedSeat.length() - 1);
        char seatLetterAsChar = bookedSeat.charAt(bookedSeat.length() - 1);

        int rowNumber = Integer.parseInt(rowNumberAsString) - 1;
        int seatNumber = ROW_LETTERS.indexOf(seatLetterAsChar);

        allSeats[rowNumber][seatNumber] = true;
    }

    private int getBlocks(boolean[][] allSeats) {
        int totalBlocks = 0;

        for (boolean[] row : allSeats) totalBlocks += getBlocks(row);

        return totalBlocks;
    }

    private int getBlocks(boolean[] row) {
        int rowBlocks = 0;

        if (!(row[0] || row[1] || row[2])) rowBlocks++;
        if (!(row[4] || row[5]) && (!row[3] || !row[6])) rowBlocks++;
        if (!(row[7] || row[8] || row[9])) rowBlocks++;

        return rowBlocks;
    }
}