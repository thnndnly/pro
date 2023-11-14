package newchess.domain;

import newchess.App;
import newchess.pieces.*;
import newchess.data.*;

public class Game {

    boolean gameRunning;
    Tile[][] board = new Tile[8][8];
    public Game(){
        initialize();
    }

    public void initialize(){
        gameRunning = true;
        // Rooks
        board[0][0] = new Tile(new Rook(Color.WHITE));
        board[0][7] = new Tile(new Rook(Color.WHITE));
        board[7][0] = new Tile(new Rook(Color.BLACK));
        board[7][7] = new Tile(new Rook(Color.BLACK));

        // Knights
        board[0][1] = new Tile(new Knight(Color.WHITE));
        board[0][6] = new Tile(new Knight(Color.WHITE));
        board[7][1] = new Tile(new Knight(Color.BLACK));
        board[7][6] = new Tile(new Knight(Color.BLACK));

        // Bishops
        board[0][2] = new Tile(new Bishop(Color.WHITE));
        board[0][5] = new Tile(new Bishop(Color.WHITE));
        board[7][2] = new Tile(new Bishop(Color.BLACK));
        board[7][5] = new Tile(new Bishop(Color.BLACK));

        // Queens
        board[0][3] = new Tile(new Queen(Color.WHITE));
        board[7][3] = new Tile(new Queen(Color.BLACK));

    }

    public void startGame() {
        App.clearCL();
        System.out.println("Neues Spiel, möge Maggnus mit dir sein.");

        printBoard();

    }

    private void printBoard(){
        for(Tile[] row : board){
            if(row == null) continue;
            for(Tile tile : row){
                if(tile == null) continue;
                System.out.print(tile.print());
            }
            System.out.println("\n");
        }
    }
}
