package ep2coo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GerenciadorDeSalas {
    List<Sala> salas = new ArrayList<Sala>();
    Collection<Reserva> colecaoReserva = new ArrayList<Reserva>();
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    Sala adicionaSalaChamada(String nome, int capacidadeMaxima, String descricao) throws SalaExistenteException{
        for(Sala nsala : salas){
            if(nsala.getNome().equals(nome)){
                //Fazer o try-catch no main
                throw new SalaExistenteException("Sala '" + nsala.getNome() + "' ja existente");
            }
        }
        Sala sala = new Sala(nome, capacidadeMaxima, descricao);
        salas.add(sala);
        return sala;
    }
    
    void removeSalaChamada(String nome){
        for(Sala sala : salas){
            if(nome.equals(sala.getNome())){
                salas.remove(sala);
                return;
            }
        }
        System.out.println("Sala nao encontrada");
    }
    
    List<Sala> listaDeSalas(){
        return this.salas;
    }
    
    
    void adicionaSala(Sala sala){
        salas.add(sala);
    }
    
    Reserva reservaSalaChamada(String nome, LocalDateTime inicio, LocalDateTime fim) throws InterseccaoReservaException, SalaNaoExistenteException{
        Sala salaReserva = null;
        Reserva reserva = null;
        for(Sala sala : salas){
            if(nome.equals(sala.getNome())){
                //Achou a sala
                salaReserva = sala;
                break;
            }
        }
        
        if(salaReserva == null){
            throw new SalaNaoExistenteException("Sala nao existe! Crie ou entao coloque o nome correto");
        }
        
        //Percorre a lista de reservas, e se a sala da reserva for igual a recebida no parametro, verifica se os horarios batem
        for(Reserva iReserva : colecaoReserva){
            if(iReserva.sala == salaReserva){
                //Vê se vai sobrepor 
                if(iReserva.inicio().isBefore(fim) && iReserva.fim().isAfter(inicio)){
                    throw new InterseccaoReservaException("Sala já reservada de " + iReserva.inicio.format(formatter) + " até " + iReserva.fim.format(formatter));
                }
            }
        }
        
        reserva = new Reserva(salaReserva, inicio, fim);
        colecaoReserva.add(reserva);
        
        return reserva;
    }
    
    void cancelaReserva(Reserva reserva){
        colecaoReserva.remove(reserva);
    }
    
    Collection<Reserva> reservasParaSala(){
        return colecaoReserva;
    }
    
    void imprimeReservasDaSala(Sala sala) {
       int cont = 0;
       System.out.println("Sala: " + sala.nome);
       System.out.println("Descrição da sala: " + sala.observacoes);
       for(Reserva iReserva : colecaoReserva){
           if(iReserva.sala == sala){
               System.out.println("Inicio: " + iReserva.inicio.format(formatter));
               System.out.println("Fim: " + iReserva.fim.format(formatter));
               System.out.println();
               cont++;
           }
       }
       
       if(cont == 0){
           System.out.println("Não há reservas nessa sala!");
       }
    }
}


