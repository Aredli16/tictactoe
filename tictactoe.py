"""
Tic Tac Toe Player
"""

import math

X = "X"
O = "O"
EMPTY = None


def initial_state():
    """
    Returns starting state of the board.
    """
    return [[EMPTY, EMPTY, EMPTY],
            [EMPTY, EMPTY, EMPTY],
            [EMPTY, EMPTY, EMPTY]]


def player(board):
    count = sum(row.count(EMPTY) for row in board)
    if count % 2 == 0:
        return O
    return X


def actions(board):
    """
    Returns set of all possible actions (i, j) available on the board.
    """
    actions = []
    for i in range(3):
        for j in range(3):
            if board[i][j] == EMPTY:
                actions.append((i, j))
    return actions

def result(board, action):
    """
    Returns the board that results from making move (i, j) on the board.
    """
    raise NotImplementedError


def winner(board):
    """
    Returns the winner of the game, if there is one.
    """
    if(terminal(board)):
        player = utility(board);
        if(player == -1):
            return "Player O won the game ! " 
        elif(player == 1):
            return "Player X won the game ! " 
        elif(player == 0):
            return "Otherwise !" 
    raise NotImplementedError


def terminal(board):
    """
    Returns True if game is over, False otherwise.
    """
    raise NotImplementedError


def utility(board):
    for row in board :
        if all(cell == X for cell in row):
            return 1
        elif all(cell == O for cell in row):
            return -1
        
    for col in range(3):
        if all(board[row][col] == X for row in range(3)):
            return 1
        elif all(board[row][col] == O for row in range(3)):
            return -1
        
    if board[0][0] == X and board[1][1] == X and board[2][2] == X:
        return 1
    elif board[0][0] == O and board[1][1] == O and board[2][2] == O:
        return -1
    else:
        return 0


def minimax(board):
    """
    Returns the optimal action for the current player on the board.
    """
    raise NotImplementedError
