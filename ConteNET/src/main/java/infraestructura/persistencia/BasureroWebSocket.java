/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura.persistencia;

import aplicacion.ContenedorService;
import com.google.gson.Gson;
import dominio.LecturaContenedor;
import java.net.InetSocketAddress;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;



/**
 *
 * @author lanch
 */
public class BasureroWebSocket extends WebSocketServer{
    private final ContenedorService contenedorService;
    private final Gson gson;

    public BasureroWebSocket(int port, ContenedorService service) {
        super(new InetSocketAddress(port));
        this.contenedorService = service;
        this.gson = new Gson();
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.out.println("Conectado: " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println("Desconectado");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        try {
            LecturaContenedor lectura = gson.fromJson(message, LecturaContenedor.class);
            contenedorService.registrarNuevaLectura(lectura);
            System.out.println("Dato guardado: " + lectura.getIdContenedor());
        } catch (Exception e) {
            System.err.println("Error JSON: " + e.getMessage());
        }
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void onStart() {
        System.out.println("Servidor iniciado en puerto: " + getPort());
    }
}
