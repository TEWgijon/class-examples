package es.tew.grpcexample;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AlumnoServer {
    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(9990)
                .addService(new FinderImpl())
                .build()
                .start();
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final AlumnoServer server = new AlumnoServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class FinderImpl extends FinderGrpc.FinderImplBase {
        private final Map<String, String> alumnos = new HashMap<>() {{
            put("UO123456", "Enol");
            put("UO654321", "Oscar");
            put("UO135246", "María");
            put("UO246135", "Andrea");
        }};

        public void findAlumno(AlumnoRequest req, StreamObserver<AlumnoReply> responseObserver) {
            AlumnoReply reply = AlumnoReply.newBuilder().setName(alumnos.getOrDefault(req.getUo(), "No identificado")).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
