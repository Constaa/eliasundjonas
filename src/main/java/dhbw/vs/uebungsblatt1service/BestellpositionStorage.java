package dhbw.vs.uebungsblatt1service;

import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;
@Service
public class BestellpositionStorage
        extends ConcurrentHashMap<Long,Bestellposition> {
    private BestellpositionStorage() {
        this.put(0L, new Bestellposition(0L,0L,3L,1));
        this.put(1L, new Bestellposition(1L,0L,2L,4));
        this.put(2L, new Bestellposition(2L,1L,0L,1));
        this.put(3L, new Bestellposition(3L,2L,2L,1));
        this.put(4L, new Bestellposition(4L,3L,2L,2));
        this.put(5L, new Bestellposition(5L,4L,3L,5));
    }
}
