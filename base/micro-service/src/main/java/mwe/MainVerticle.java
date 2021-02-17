package mwe;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.openapi.RouterBuilder;

public class MainVerticle extends AbstractVerticle {
    @Override
    public void start() {
        // Create a Router
        RouterBuilder.create(vertx, "openapi/service-spec.yaml").onSuccess(routerBuilder -> {
            System.out.println("it worked! :)");
        })
        .onFailure(err -> {
            System.err.println("it failed :(");
            System.err.println(err.toString());
            vertx.close();
        });
    }
}