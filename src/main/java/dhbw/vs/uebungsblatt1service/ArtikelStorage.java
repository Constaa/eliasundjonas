package dhbw.vs.uebungsblatt1service;

import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;
@Service
public class ArtikelStorage
        extends ConcurrentHashMap<Long,Artikel> {
    private ArtikelStorage() {
        this.put(0L, new Artikel(0L,"Zahnbürste", 1.98));
        this.put(1L, new Artikel(1L,"Klobürste", 2.98));
        this.put(2L, new Artikel(2L,"Haarbürste", 2.49));
        this.put(3L, new Artikel(3L,"Kamm", 1.49));
    }
}