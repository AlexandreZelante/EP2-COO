package ep2coo;

import java.time.LocalDateTime;

public class Reserva {
    Sala sala;
    LocalDateTime inicio;
    LocalDateTime fim;
    
    public Reserva(Sala sala, LocalDateTime inicio, LocalDateTime fim){
        this.sala = sala;
        this.inicio = inicio;
        this.fim = fim;
    }
    
    Sala sala(){
        return sala;
    }
    
    LocalDateTime inicio(){
        return inicio;
    }
    
    LocalDateTime fim(){
        return fim;
    }
}
