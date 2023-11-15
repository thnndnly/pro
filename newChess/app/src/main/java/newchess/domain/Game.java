package newchess.domain;

import newchess.App;
import newchess.pieces.*;
import newchess.data.*;
import newchess.ui.CommandLineInputParser;

import java.util.ArrayList;
import java.util.List;

public class Game {

    CommandLineInputParser clui;
    boolean gameRunning;
    Color turn;
    Tile[][] board = new Tile[8][8];
    public Game(){
        initialize();
    }

    public Tile getTile(Koordinates koordinates) {
        return board[koordinates.getX()][koordinates.getY()];
    }

    public void initialize(){
        clui = new CommandLineInputParser();
        gameRunning = true;
        turn = Color.WHITE;
        // Rooks
        board[0][0] = new Tile(new Rook(Color.BLACK));
        board[0][7] = new Tile(new Rook(Color.BLACK));
        board[7][0] = new Tile(new Rook(Color.WHITE));
        board[7][7] = new Tile(new Rook(Color.WHITE));

        // Knights
        board[0][1] = new Tile(new Knight(Color.BLACK));
        board[0][6] = new Tile(new Knight(Color.BLACK));
        board[7][1] = new Tile(new Knight(Color.WHITE));
        board[7][6] = new Tile(new Knight(Color.WHITE));

        // Bishops
        board[0][2] = new Tile(new Bishop(Color.BLACK));
        board[0][5] = new Tile(new Bishop(Color.BLACK));
        board[7][2] = new Tile(new Bishop(Color.WHITE));
        board[7][5] = new Tile(new Bishop(Color.WHITE));

        // Queens
        board[0][3] = new Tile(new Queen(Color.BLACK));
        board[7][3] = new Tile(new Queen(Color.WHITE));

        // Kings
        board[0][4] = new Tile(new King(Color.BLACK));
        board[7][4] = new Tile(new King(Color.WHITE));

        // Pawns
        for(int i = 0; i < 8; i++){
            board[1][i] = new Tile(new Pawn(Color.BLACK));
            board[6][i] = new Tile(new Pawn(Color.WHITE));
        }

        // No pieces
        for(int i = 0; i < 8; i++){
            for(int j = 2; j < 6; j++){
                board[j][i] = new Tile(new NoPiece());
            }
        }

    }

    public void startGame() {
        App.clearCL();
        System.out.println("Neues Spiel, möge Maggnus mit dir sein.");
        while (gameRunning) {
            printBoard();
            System.out.println("\nGib deinen Zug ein:\n");
            String input = clui.getInput();
            if(clui.isInputCorrect(input)) {
                Move move = clui.parseInput(input);

            }
            else {
                System.out.println("Ungültige Eingabe, bitte versuche es noch einmal.");
            }
        }
    }

    private void printBoard(){
        for(Tile[] row : board){
            if(row == null) continue;
            for(Tile tile : row){
                if(tile == null) continue;
                System.out.print(tile.print());
            }
            System.out.print("\n");
        }
    }

    private boolean isMoveLegal(Move move) {
        boolean result = true;
        // Hier müssen wir gucken ob der Legal ist dazu brauchen wir:
        // 1. Welcher Spieler hat den Zug und welche Figur versucht er zu bewegen?
        // 2. Kann die bewegte Figur diesen Zug überhaupt machen?
        // 3. Behindert eine Figur den Zug egal ob feidlich oder freundlich
        // 4. Ist das Zielfeld mit einer Figur belgt oder nicht
        // 5.
        List<String> errors = new ArrayList<String>();
        // 1.
        if(!isMovingFigurePlayersFigure(move.getStartingTile())){
            errors.add("Der Spieler hat versucht eine Figur zu bewegen welche Ihm nicht gehört.");
            result = false;
        }
        // 2.
        if(!isMoveInPossibleMovesOfPiece(move)){
            errors.add("Die Figur die du gewählt hast, kann sich so nicht bewegen.");
            result = false;
        }
        // 3.

        MoveError.errors = errors;
        return result;
    }

    boolean isMovingFigurePlayersFigure(Koordinates koordinates) {
        return turn == getTile(koordinates).getColor();
    }

    private boolean isMoveInPossibleMovesOfPiece(Move move) {
        Koordinates startingKoordinates = move.getStartingTile();
        Koordinates endKoordinates = move.getEndingTile();
        List<Koordinates> possibleMoves = getTile(startingKoordinates).getMoves(startingKoordinates);
        return possibleMoves.contains(endKoordinates);
    }

    private boolean isPieceInWay(Move move) {
        boolean result = true;
        if(doesPieceMovingRequireFreeway(getTile(move.getStartingTile()).getPiece())) {
            List<Koordinates> needToBeFreeTiles = move.getNeedToBeEmpty();
            for(Koordinates koordinates : needToBeFreeTiles) {
                if(!getTile(koordinates).isTileEmpty()) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public boolean doesPieceMovingRequireFreeway(Piece piece) {
        return !(piece instanceof Pawn || piece instanceof Knight || piece instanceof King);
    }
}
