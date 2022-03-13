package se2.fischbacher.einzelabgabe.handler.interfaces;

public interface TCPHandler {
    String getRequestString();
    void handleServerResponse(String serverResponse);
}
