import com.revature.dao.PaintingDAO;
import com.revature.model.Painting;
import com.revature.service.PaintingService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MuseumTest {
    Painting compositionIX;
    Painting compositionFromMock;
    Connection mockConnection;
    PreparedStatement mockPrepared;
    ResultSet mockResultForGetPainting;
    PaintingDAO mockdao;
    PaintingDAO realdao;

    @BeforeAll
    public void SetUpMocks() throws SQLException {
        compositionIX = new Painting(1, "Composition IX", null, "Abstract", 1939);
        compositionFromMock = new Painting(1, "Composition IX", null, "Abstract", 1939);
        mockdao = Mockito.mock(PaintingDAO.class);

        Mockito.when(mockdao.getPainting("Composition IX")).thenReturn(compositionFromMock);

        mockConnection = Mockito.mock(Connection.class);
        mockPrepared = Mockito.mock(PreparedStatement.class);
        mockResultForGetPainting = Mockito.mock(ResultSet.class);

        PaintingDAO pdao = new PaintingDAO(mockConnection);
        realdao = new PaintingDAO(mockConnection);

        Mockito.when(mockResultForGetPainting.next()).thenReturn(true).thenReturn(false);
        Mockito.when(mockResultForGetPainting.getInt("artist_id")).thenReturn(1);
        Mockito.when(mockResultForGetPainting.getString("title")).thenReturn("Composition IX");
        Mockito.when(mockResultForGetPainting.getString("url")).thenReturn(null);
        Mockito.when(mockResultForGetPainting.getString("genre")).thenReturn("Abstract");
        Mockito.when(mockResultForGetPainting.getInt("year_made")).thenReturn(1939);
        Mockito.when(mockConnection.prepareStatement("Select * From Painting Where title = ?")).thenReturn(mockPrepared);
        Mockito.when(mockPrepared.executeQuery()).thenReturn(mockResultForGetPainting);

    }

    @Test
    public void PaintingServiceGetPaintingTest() throws SQLException {
        /*.class? we care about compiled files?
        it means that mockito is using reflection -
        reflection, meaning that mockito is changing code at runtime rather than
        compile-time
         */
        PaintingService ps = new PaintingService(mockdao);
        assertTrue(compositionIX.equals(ps.getPainting("Composition IX")));

        /*Why are we testing real data in the database??
        * Bad idea- let's use a mock DAO
        * whats a mock?
        * A mock is a 'dummy' object that contains all of its methods,
        * but we must tell Mockito exactly what all those methods should return
        * so, it is 'fake' object
        *
        * why do we want one?
        * we want to standardize behavior for objects that rely on the mocked object*/
    }

    @Test
    public void PaintingDAOGetPaintingTest() throws SQLException {
        assertEquals(compositionFromMock, realdao.getPainting("Composition IX"));
    }

}
