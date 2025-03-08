package data;

/*
 Me voy a crear mi protocolo para manejar el juego
 En mi protocolo tengo datos y mensajes con el siguiente significado:
 */

public interface Protocol
{
    public static final int MSG_MOVE_POSITION = 0;
    public static final int MSG_SET_NAME = 1;
    public static final int MSG_INIT_PLAYER = 2;
    public static final int MSG_ADD_NEW_PLAYER = 3;
    public static final int MSG_REMOVE_PLAYER = 4;
    public static final int MSG_SEND_POSITION = 5;   
    public static final int MSG_PRESSED=6;
    public static final int MSG_ONE_POINT=7;
    public static final int MSG_ONE_POINT_LESS=8;
    public static final int MSG_OVER_LOAD_PLAYERS=9;
}

