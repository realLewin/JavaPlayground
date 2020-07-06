package com.lewin.playground.distributedsystem.ideas;

/**
 * there is a central server that store all the database information,and there are several other node connected
 * to the central server, each node process a piece of database information, then deliver the info back to the
 * server. for example, the server store info that can be alphabetically, A-Z, then node one get the piece of
 * A-J, node two get K-O, node there get P-Z, when user change info related to F, the info will first send to
 * node one, node one process it, then deliver to the central server, if some other node like node two read
 * the date piece F, you should promise thread safety, or node one should process atomically.
 */
public class Main {
}
