package com.qqq.game;

import com.qqq.entity.Domino;
import com.qqq.entity.Player;
import com.qqq.entity.Room;
import com.qqq.exception.IncorrectValueException;
import com.qqq.exception.StorageException;

import java.util.Objects;
import java.util.Scanner;

public class Game {

    private static final int NUM_FOR_TWO_PLAYERS = 7;
    private static final int NUM_FOR_THREE_AND_FOUR_PLAYERS = 5;

    private boolean gameRunning = true;
    private boolean roundRunning = true;

    private void giveDominoToPlayers(Room room) throws StorageException, IncorrectValueException {
        int nPlayers = room.getNumberOfPlayers();
        if (nPlayers == 2) {
            for (Player player : room.getPlayers()) {
                for (int i = 0; i < NUM_FOR_TWO_PLAYERS; i++) {
                    player.addDomino(room
                            .getDominoBank()
                            .takeFirstDomino());
                }
            }
        } else if (nPlayers == 3 || nPlayers == 4) {
            for (Player player : room.getPlayers()) {
                for (int i = 0; i < NUM_FOR_THREE_AND_FOUR_PLAYERS; i++) {
                    player.addDomino(room
                            .getDominoBank()
                            .takeFirstDomino());
                }
            }
        } else {
            throw new IncorrectValueException("Unable to start the game with " + nPlayers + " player");
        }
        System.out.println("give domino");
    }

    private int nPlayerWithFirstMove(Room room) {
        int nPlayers = room.getNumberOfPlayers();
        Domino[] dominoMaxs = new Domino[room.getNumberOfPlayers()];

        for (int i = 0; i < nPlayers; i++) {
            dominoMaxs[i] = room.getPlayers().get(i).maxDouble();
        }
        int res = -1;

        for (int i = 0 ; i < nPlayers; i++) {
            if (dominoMaxs[i] != null) {
                if (res == -1) {
                    res = i;
                    dominoMaxs[i].setAvailable(true);
                }
                if (dominoMaxs[res].getLeft() < dominoMaxs[i].getLeft()) {
                    dominoMaxs[i].setAvailable(true);
                    dominoMaxs[res].setAvailable(false);
                    res = i;
                }
            }
        }

        if (res == -1) {
            return nPlayerWithMaxDomino(room);
        } else {
            return res;
        }
    }

    private int nPlayerWithMaxDomino(Room room) {
        int res = 0;
        int nPlayers = room.getNumberOfPlayers();
        Domino[] dominoMaxs = new Domino[room.getNumberOfPlayers()];

        for (int i = 0; i < nPlayers; i++) {
            dominoMaxs[i] = room.getPlayers().get(i).maxDomino();
        }

        dominoMaxs[res].setAvailable(true);

        for (int i = 0; i < nPlayers; i++) {
            if (dominoMaxs[res].getSum() < dominoMaxs[i].getSum()) {
                dominoMaxs[i].setAvailable(true);
                dominoMaxs[res].setAvailable(false);
                res = i;
            }
        }

        return res;
    }

    // at least one
    private boolean isEmptyHand(Room room) {
        for (Player player : room.getPlayers()) {
            if (player.isHandEmpty()) {
                return true;
            }
        }
        return false;
    }

    private boolean isAvailable(Room room) {
        for (Player player : room.getPlayers()) {
            for (Domino domino : player.getHand()) {
                if (domino.isAvailable()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void updageAvailable(Room room) {
        if (!room.getTable().isEmpty()) {
            int leftTable = room.getTable().getLeftSide();
            int rightTable = room.getTable().getRightSide();

            for (Player player : room.getPlayers()) {
                for (Domino domino : player.getHand()) {
                    domino.setAvailable(domino.isSame(leftTable, rightTable));
                }
            }
        }
    }

    private boolean haveWinner(Room room) {
        for (Player player : room.getPlayers()) {
            if (player.getScore() >= 100) {
                return true;
            }
        }
        return false;
    }

    private Player winner(Room room) {
        for (Player player : room.getPlayers()) {
            if (player.getScore() >= 100) {
                return player;
            }
        }
        return null;
    }

    public void game(Room room) throws StorageException, IncorrectValueException {


        while(gameRunning) {
            giveDominoToPlayers(room);
            int nPlayer = nPlayerWithFirstMove(room);
            System.out.println("find player with first move");
            int nPlayers = room.getNumberOfPlayers();
            System.out.println("get number of players");

            while (roundRunning) {

                room.getPlayers().get(nPlayer).changedMoving();
                System.out.println("=====================================");

                while (!room.getPlayers().get(nPlayer).hasAvailable()) {
                    room.getPlayers()
                            .get(nPlayer)
                            .addDomino(room
                            .getDominoBank()
                            .takeFirstDomino());
                    updageAvailable(room);
                }
                System.out.println(room.getPlayers().get(nPlayer).handToString());
                System.out.println("choose domino to put on the table: ");
                Scanner choose = new Scanner(System.in);
                int chooseNum = choose.nextInt();
                if (room.getTable().isEmpty()) {
                    room.getPlayers().get(nPlayer).putOnEmpty(room.getTable(), chooseNum);
                } else {
                    boolean leftAvailable = room.getPlayers()
                            .get(nPlayer)
                            .getHand()
                            .get(chooseNum)
                            .isSame(room.getTable().getLeftSide());
                    boolean rightAvailable = room.getPlayers()
                            .get(nPlayer)
                            .getHand()
                            .get(chooseNum)
                            .isSame(room.getTable().getRightSide());
                    if (leftAvailable && rightAvailable) {
                        System.out.println("choose left(0) or right(1)");
                        Scanner chooseSide = new Scanner(System.in);
                        int chooseSideNum = chooseSide.nextInt();
                        if (chooseSideNum == 0) {
                            room.getPlayers().get(nPlayer).putOn(room.getTable(), chooseNum, true);
                            System.out.println("leftAvailable rightAvailable");
                        } else if (chooseSideNum == 1) {
                            System.out.println("rightAvailable leftAvailable");
                            room.getPlayers().get(nPlayer).putOn(room.getTable(), chooseNum, false);
                        }
                    } else
                    if (leftAvailable) {
                        System.out.println("leftAvailable");
                        room.getPlayers().get(nPlayer).putOn(room.getTable(), chooseNum, true);
                    }
                    else
                    if (rightAvailable) {
                        System.out.println("rightAvailable");
                        room.getPlayers().get(nPlayer).putOn(room.getTable(), chooseNum, false);
                    }
                }
                System.out.println(room.getTable().toString());

                if (isEmptyHand(room)) {
                    roundRunning = false;
                    int sum = 0;
                    int iTemp = 0;
                    for (int i = 0; i < nPlayers; i++) {
                        if(room.getPlayers().get(i).isHandEmpty()) {
                            iTemp = i;
                        }
                    }
                    for (int i = 0; i < nPlayers; i++) {
                        if(i != iTemp) {
                            sum = sum + room.getPlayers().get(i).getSum();
                        }
                    }
                    room.getPlayers().get(iTemp).addScore(sum);
                    break;
                }

                updageAvailable(room);
                if (!isAvailable(room) || room.getTable().isEmpty()) {
                    roundRunning = false;
                    int sum = room.getPlayers().get(0).getSum();
                    int iTemp = 0;
                    for (int i = 0; i < nPlayers; i++) {
                        if(room.getPlayers().get(i).getSum() < sum) {
                            iTemp = i;
                            sum = room.getPlayers().get(i).getSum();
                        }
                    }
                    for (int i = 0; i < nPlayers; i++) {
                        if(i != iTemp) {
                            sum = sum + room.getPlayers().get(i).getSum() - room.getPlayers().get(iTemp).getSum();
                        }
                    }
                    room.getPlayers().get(iTemp).addScore(sum);
                    break;
                }

                room.getPlayers().get(nPlayer).changedMoving();
                nPlayer = (nPlayer + 1) % nPlayers;
            }

            if (haveWinner(room)) {
                gameRunning = false;
                System.out.println("winner - " + Objects.requireNonNull(winner(room)).getLogin());
            }
        }
    }
}
