package laskin;

import java.util.LinkedList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa implements Komento {

    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Sovelluslogiikka sovellus;
    private Button undo;
    private LinkedList<Integer> historia = new LinkedList<>();
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus){
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.sovellus = sovellus;
        this.undo = undo;
    }
    
    @Override
    public void suorita() {
        historia.add(sovellus.tulos());
        sovellus.nollaa();
        int laskunTulos = sovellus.tulos();
        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        sovellus.nollaa();
        sovellus.plus(historia.pop());
        int laskunTulos = sovellus.tulos();
        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(true);
    }
    
}
