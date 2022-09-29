package ifrs.edu;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class ConversorTest {

    @Test
    public void KilosvalorBaixo() {
        final int VALOR = 2;
        final String EXPECTED = Double.toString(VALOR / 2.2046);

        given()
        .pathParam("value", VALOR)
          .when().get("/lbToKg/{value}")
          .then()
             .statusCode(200)
             .body(is(EXPECTED));
    }

    @Test
    public void KilosString() {
        final String VALOR = "TEST OR DIE";

        given()
        .pathParam("value", VALOR)
          .when().get("/lbToKg/{value}")
          .then()
             .statusCode(404);
    }

    @Test
    public void librasValorAlto() {
        final int VALOR = 275;
        final String EXPECTED = Double.toString(VALOR * 2.2046);

        given()
        .pathParam("value", VALOR)
          .when().get("/kgToLb/{value}")
          .then()
             .statusCode(200)
             .body(is(EXPECTED));
    }

    @Test
    public void librasString() {
        final String VALOR = "TEST OR DIE";

        given()
        .pathParam("value", VALOR)
          .when().get("/lbToKg/{value}")
          .then()
             .statusCode(404);
    }


}