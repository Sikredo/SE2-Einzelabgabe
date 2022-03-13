package se2.fischbacher.einzelabgabe;

public interface TCPHandler {
    String getRequestString();
    void handleServerResponse(String serverResponse);
}
